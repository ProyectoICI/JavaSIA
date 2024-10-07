package main.java.com.hospital.service;

import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;
import main.java.com.hospital.repository.ShiftRepo;

import java.sql.Connection;
import java.util.ArrayList;

public class ShiftService {
    private static final ShiftRepo shiftRepo = new ShiftRepo();

    public static void eliminarTurno(Hospital hospital, Turno turno) {
        shiftRepo.remover(hospital, turno);
    }

    public static void agregarTurno(Hospital hospital, Turno turno){
        shiftRepo.guardar(hospital, turno);
    }

    public static ArrayList<Turno> listarTurnos(Hospital hospital) {
        return shiftRepo.encontrarTodos(hospital);
    }

    public void oldLoadInitialData(Hospital hospital, boolean randomizeShifts) { shiftRepo.cargarData(hospital, randomizeShifts); }

    public void oldLoadInitialData(Hospital hospital) { shiftRepo.cargarData(hospital); }

    public void loadDatabaseData(Hospital hospital, Connection db) { shiftRepo.cargarDataDB(hospital, db); }
}
