package main.java.com.hospital.service;


import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.repository.HospitalRepo;

import java.sql.Connection;
import java.sql.SQLException;

public class HospitalService {
    public static final HospitalRepo hospitalRepo = new HospitalRepo();

    public void oldLoadInitialData(Hospital hospital) { hospitalRepo.cargarData(hospital); }

    public void loadDatabaseData(Hospital hospital, Connection db) throws SQLException { hospitalRepo.cargarDataDB(hospital, db); }

    public static void cambioNombre(Hospital hospital, String nombre) {
        hospitalRepo.cambioNombre(hospital, nombre);
    }

    public static void cambioDireccion(Hospital hospital, String direccion) {
        hospitalRepo.cambioDireccion(hospital, direccion);
    }

    public static void cambioNumero(Hospital hospital, int numero) {
        hospitalRepo.cambioNumero(hospital, numero);
    }


}
