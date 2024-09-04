package main.java.com.hospital.service;

import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;
import main.java.com.hospital.repository.ShiftRepo;

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

    public void loadInitialData(Hospital hospital) { shiftRepo.cargarData(hospital); }
}
