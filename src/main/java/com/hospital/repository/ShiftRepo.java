package main.java.com.hospital.repository;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;
import test.InitialData;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ShiftRepo {

    public void guardar(Hospital hospital, Turno turno) {
        hospital.addShift(turno);
    }


    public void remover(Hospital hospital, Turno turno) {
        hospital.removeShift(turno);
    }

    public ArrayList<Turno> encontrarTodos(Hospital hospital) {
        return new ArrayList<>(hospital.getShifts());
    }

    public void cargarData(Hospital hospital, boolean randomizeShifts) {
        ArrayList<Turno> turnosIniciales = InitialData.cargarTurnos();

        if (!randomizeShifts) {
            for (Turno turno : turnosIniciales) {
                hospital.addShift(turno);
            }
        } else {

            String[] randomTime = {"Mañana", "Dia", "Noche"};
            LocalDate randomDate;
            Map<Integer, Departamento> deptosHospital = hospital.getDepartments();

            Random randDay = new Random();
            Random randMonth = new Random();

            int yearDate = 2024;
            int randomMonth;
            int randomDay;

            String stringRandomDay;
            String stringRandomMonth;

            int indexTime;
            int indexDeptos;

            for (int i = 0; i < turnosIniciales.size(); i++) {
                Turno turnoRandom = new Turno();
                indexTime = (int) (Math.random() * randomTime.length);
                indexDeptos = (int) (Math.random() * turnosIniciales.size());

                randomDay = randDay.nextInt(27) + 1;
                randomMonth = randMonth.nextInt(12) + 1;

                if (randomDay <= 9) {
                    stringRandomDay = "0" + randomDay;
                } else {
                    stringRandomDay = String.valueOf(randomDay);
                }

                if (randomMonth <= 9) {
                    stringRandomMonth = "0" + randomMonth;
                } else {
                    stringRandomMonth = String.valueOf(randomMonth);
                }

                String randomDateString = yearDate + "-" + stringRandomMonth + "-" + stringRandomDay;


                randomDate = LocalDate.parse(randomDateString);

                turnoRandom.setDiaTurno(randomDate);
                turnoRandom.setHorarioTurno(randomTime[indexTime]);
                turnoRandom.setDeptoTurno(deptosHospital.get(indexDeptos).getNombreDepto());
                hospital.addShift(turnoRandom);
            }


        }

    }

    public void cargarData(Hospital hospital) {
        ArrayList<Turno> turnosIniciales = InitialData.cargarTurnos();
        for (Turno turno : turnosIniciales) {
            hospital.addShift(turno);
        }
    }

    public void cargarDataDB(Hospital hospital, Connection db) throws SQLException {
        String sqlShift = "SELECT * FROM Turno";
        Statement stmtHospital = db.createStatement();
        ResultSet rsTurno = stmtHospital.executeQuery(sqlShift);

        while (rsTurno.next()) {
            int id = rsTurno.getInt("turnoID");
            String enfermeraAsig = rsTurno.getString("enfermeraAsig");
            String diaTurno = rsTurno.getString("diaTurno");
            String horarioTurno = rsTurno.getString("horarioTurno");
            String deptoTurno = rsTurno.getString("deptoTurno");


            String sqlTurno = "SELECT * FROM Turno WHERE turnoID = ?";
            PreparedStatement pstmtShift = db.prepareStatement(sqlTurno);
            pstmtShift.setInt(1, id);
            ResultSet rsShift = pstmtShift.executeQuery();

            while (rsShift.next()) {
                int shiftID = rsShift.getInt("turnoID");
                Turno shift = loadTurnoByID(db, shiftID);
                hospital.addShift(shift);
            }

        }

    }

    private Turno loadTurnoByID(Connection db, int turnoID) throws SQLException {
        String sql = "SELECT * FROM Turno WHERE turnoID = ?";
        PreparedStatement pstmt = db.prepareStatement(sql);
        pstmt.setInt(1, turnoID);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String enfermeraAsignada = rs.getString("enfermeraAsig");
            String horarioTurno = rs.getString("horarioTurno");
            String diaTurnoStr = rs.getString("diaTurno");
            LocalDate diaTurno = LocalDate.parse(diaTurnoStr, DateTimeFormatter.ISO_LOCAL_DATE);
            String deptoTurno = rs.getString("deptoTurno");

            return new Turno(enfermeraAsignada, horarioTurno, diaTurno, deptoTurno);
        }
        return null;
    }
}
