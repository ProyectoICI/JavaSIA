package main.java.com.hospital.repository;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;
import test.InitialData;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DepartmentRepo {
    public void guardar(Hospital hospital, Departamento departamento) {
        hospital.addDepartment(departamento);
    }



    public void remover(Hospital hospital, Departamento departamento) {
        hospital.removeDepartment(departamento);
    }

    public HashMap<Integer,Departamento> encontrarTodos(Hospital hospital) {
        return new HashMap<>(hospital.getDepartments());
    }

    public Departamento buscarDepto(Hospital hospital, int id) {
        return hospital.getDepartment(id);
    }

    public void cargarData(Hospital hospital) {
        Map<Integer, Departamento> departamentosIniciales = InitialData.cargarDeptos();
        for (Departamento departamento : departamentosIniciales.values()) {
            hospital.addDepartment(departamento);
        }
    }

    public void cargarDataDB(Hospital hospital, Connection db) throws SQLException {
        String sqlDeptos = "SELECT * FROM Departamento";
        Statement stmtDeptos = db.createStatement();
        ResultSet rsDeptos = stmtDeptos.executeQuery(sqlDeptos);

        while (rsDeptos.next()) {
            int id = rsDeptos.getInt("deptoID");
            int necesidad = rsDeptos.getInt("necesidad");
            String name = rsDeptos.getString("nombreDepto");

            Departamento depto = new Departamento(name, id, necesidad);

            // Load nurses for this department
            String sqlEnfermeras = "SELECT * FROM DepartamentoEnfermera WHERE deptoID = ?";
            PreparedStatement pstmtEnfermeras = db.prepareStatement(sqlEnfermeras);
            pstmtEnfermeras.setInt(1, id);
            ResultSet rsEnfermeras = pstmtEnfermeras.executeQuery();

            while (rsEnfermeras.next()) {
                int enfermeraID = rsEnfermeras.getInt("enfermeraID");
                // Assuming you have a method to load an Enfermera by ID
                Enfermera enfermera = loadEnfermeraByID(db, enfermeraID);
                depto.addEnfermera(enfermera);
            }

            // Load shifts for this department
            String sqlTurnos = "SELECT * FROM DepartamentoTurno WHERE deptoID = ?";
            PreparedStatement pstmtTurnos = db.prepareStatement(sqlTurnos);
            pstmtTurnos.setInt(1, id);
            ResultSet rsTurnos = pstmtTurnos.executeQuery();

            while (rsTurnos.next()) {
                int turnoID = rsTurnos.getInt("turnoID");
                // Assuming you have a method to load a Turno by ID
                Turno turno = loadTurnoByID(db, turnoID);
                depto.addTurno(turno);
            }

            hospital.addDepartment(depto);
        }
    }

    private Enfermera loadEnfermeraByID(Connection db, int enfermeraID) throws SQLException {
        String sql = "SELECT * FROM Enfermera WHERE enfermeraID = ?";
        PreparedStatement pstmt = db.prepareStatement(sql);
        pstmt.setInt(1, enfermeraID);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String prefDepto = rs.getString("prefDepto");
            String prefTurno = rs.getString("prefTurno");
            int asistencia = rs.getInt("asistencia");
            boolean ocupado = rs.getBoolean("ocupado");
            String deptoAsignado = rs.getString("deptoAsignado");

            return new Enfermera(nombre, apellido, prefDepto, prefTurno, enfermeraID, deptoAsignado, asistencia, ocupado);
        }
        return null;
    }

    private Turno loadTurnoByID(Connection db, int turnoID) throws SQLException {
        String sql = "SELECT * FROM Turno WHERE turnoID = ?";
        PreparedStatement pstmt = db.prepareStatement(sql);
        pstmt.setInt(1, turnoID);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String enfermeraAsignada = rs.getString("enfermeraAsignada");
            String horarioTurno = rs.getString("horarioTurno");
            LocalDate diaTurno = rs.getDate("diaTurno").toLocalDate();
            String deptoTurno = rs.getString("deptoTurno");

            return new Turno(enfermeraAsignada, horarioTurno, diaTurno, deptoTurno);
        }
        return null;
    }
}
