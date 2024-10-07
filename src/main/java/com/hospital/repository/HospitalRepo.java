package main.java.com.hospital.repository;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;
import test.InitialData;

import java.sql.*;
import java.time.LocalDate;

public class HospitalRepo {
    public void cambioNombre(Hospital hospital, String nombre) {
        hospital.changeName(nombre, hospital);
    }

    public void cambioDireccion(Hospital hospital, String direccion) {
        hospital.changeLocation(direccion, hospital);
    }

    public void cambioNumero(Hospital hospital, int numero) {
        hospital.changeNumber(numero, hospital);
    }

    public void cargarData(Hospital hospital) {
        Hospital hospitalInicial = InitialData.cargarHospital();

        hospital.setNombreHospital(hospitalInicial.getNombreHospital());
        hospital.setDireccionHospital(hospitalInicial.getDireccionHospital());
        hospital.setNumeroHospital(hospitalInicial.getNumeroHospital());
    }

    public void cargarDataDB(Hospital hospital, Connection db) throws SQLException {
        String sqlHospital = "SELECT * FROM Hospital";
        Statement stmtHospital = db.createStatement();
        ResultSet rsHospital = stmtHospital.executeQuery(sqlHospital);

        while (rsHospital.next()) {
            int id = rsHospital.getInt("hospitalID");
            String nombreHospital = rsHospital.getString("nombreHospital");
            String direccionHospital = rsHospital.getString("direccionHospital");
            int numeroHospital = rsHospital.getInt("numeroHospital");

            hospital.setNombreHospital(nombreHospital);
            hospital.setDireccionHospital(direccionHospital);
            hospital.setNumeroHospital(String.valueOf(numeroHospital));

            String sqlDepto = "SELECT * FROM HospitalDepto WHERE hospital_id = ?";
            PreparedStatement pstmtDepto = db.prepareStatement(sqlDepto);
            pstmtDepto.setInt(1, id);
            ResultSet rsDepto = pstmtDepto.executeQuery();

            while (rsDepto.next()) {
                int deptoID = rsDepto.getInt("deptoID");
                Departamento depto = loadDepartamentoByID(db, deptoID);
                hospital.addDepartment(depto);
            }

/*            String sqlEnfermera = "SELECT * FROM HospitalEnfermera WHERE hospital_id = ?";
            PreparedStatement pstmtEnf = db.prepareStatement(sqlEnfermera);
            pstmtEnf.setInt(1, id);
            ResultSet rsEnf = pstmtEnf.executeQuery();

            while (rsEnf.next()) {
                int enfID = rsEnf.getInt("enfermeraID");
                Enfermera enf = loadEnfermeraByID(db, enfID);
                hospital.addNurse(enf);
            }

            String sqlTurno = "SELECT * FROM HospitalTurno WHERE hospital_id = ?";
            PreparedStatement pstmtShift = db.prepareStatement(sqlTurno);
            pstmtShift.setInt(1, id);
            ResultSet rsTurno = pstmtShift.executeQuery();

            while (rsTurno.next()) {
                int turnID = rsTurno.getInt("turnoID");
                Turno shift = loadTurnoByID(db, turnID);
                hospital.addShift(shift);
            }*/

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

    private Departamento loadDepartamentoByID(Connection db, int deptoID) throws SQLException {
        String sql = "SELECT * FROM Departamento WHERE deptoID = ?";
        PreparedStatement pstmt = db.prepareStatement(sql);
        pstmt.setInt(1, deptoID);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            String nombreDepto = rs.getString("nombreDepto");
            int idDepto = rs.getInt("deptoID");
            int necesidad = rs.getInt("necesidad");

            return new Departamento(nombreDepto, idDepto, necesidad);

        }
        return null;
    }
}
