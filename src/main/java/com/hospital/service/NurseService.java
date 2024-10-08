package main.java.com.hospital.service;

import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.repository.NurseRepo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class NurseService {
    private static final NurseRepo nurseRepo = new NurseRepo();

    public void oldLoadInitialData(Hospital hospital) { nurseRepo.cargarData(hospital); }

    public void loadDatabaseData(Hospital hospital, Connection db) throws SQLException { nurseRepo.cargarDataDB(hospital, db); }

    public static void eliminarEnfermera(Hospital hospital, Enfermera enfermera) {
        nurseRepo.remover(hospital, enfermera);
    }

    public static void agregarEnfermera(Hospital hospital, Enfermera enfermera){
        nurseRepo.guardar(hospital, enfermera);
    }

    public static ArrayList<Enfermera> listarEnfermeras(Hospital hospital) {
        return nurseRepo.encontrarTodos(hospital);
    }
}
