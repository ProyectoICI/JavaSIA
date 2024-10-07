package main.java.com.hospital.repository;

import main.java.com.hospital.model.Hospital;
import test.InitialData;

import java.sql.Connection;

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

    public void cargarDataDB(Hospital hospital, Connection db) {
        String sql = "SELECT * FROM Hospital";
        System.out.println("asd");
    }
}
