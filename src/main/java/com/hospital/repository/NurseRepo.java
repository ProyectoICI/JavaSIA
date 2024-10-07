package main.java.com.hospital.repository;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;
import test.InitialData;

import java.sql.*;
import java.util.ArrayList;

public class NurseRepo {

    public void guardar(Hospital hospital, Enfermera enfermera) {
        hospital.addNurse(enfermera);
    }


    public void remover(Hospital hospital, Enfermera enfermera) {
        hospital.removeNurse(enfermera);
    }

    public ArrayList<Enfermera> encontrarTodos(Hospital hospital) {
        return new ArrayList<>(hospital.getNurses());
    }

    public void cargarData(Hospital hospital) {
        ArrayList<Enfermera> enfermerasIniciales = InitialData.cargarEnfermeras();
        for(Enfermera enfermera : enfermerasIniciales) {
            hospital.addNurse(enfermera);
        }
    }



    public void cargarDataDB(Hospital hospital, Connection db) throws SQLException {
        String sqlEnf = "SELECT * FROM Enfermera";
        Statement stmtHospital = db.createStatement();
        ResultSet rsEnfermera = stmtHospital.executeQuery(sqlEnf);

        while (rsEnfermera.next()) {
            int id = rsEnfermera.getInt("enfermeraID");
            String nombre = rsEnfermera.getString("nombre");
            String apellido = rsEnfermera.getString("apellido");
            String prefDepto = rsEnfermera.getString("prefDepto");
            String prefTurno = rsEnfermera.getString("prefTurno");
            String deptoAsignado = rsEnfermera.getString("deptoAsignado");
            int asistencia = rsEnfermera.getInt("asistencia");
            int ocupado = rsEnfermera.getInt("ocupado");
            int idInterno = rsEnfermera.getInt("idInterno");


            String sqlEnfermera = "SELECT * FROM Enfermera WHERE enfermeraID = ?";
            PreparedStatement pstmtEnf = db.prepareStatement(sqlEnfermera);
            pstmtEnf.setInt(1, id);
            ResultSet rsEnf = pstmtEnf.executeQuery();

            while (rsEnf.next()) {
                int enfID = rsEnf.getInt("enfermeraID");
                Enfermera enf = loadEnfermeraByID(db, enfID);
                hospital.addNurse(enf);
            }

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
}

