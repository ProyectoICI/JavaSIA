package main.java.com.hospital.repository;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;
import test.InitialData;

import java.sql.Connection;
import java.time.LocalDate;
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

    public void cargarDataDB(Hospital hospital, Connection db) {
        String sql = "SELECT * FROM Turno";
        System.out.println("asd");
    }
}
