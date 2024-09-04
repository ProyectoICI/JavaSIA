package main.java.com.hospital.repository;

import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;
import test.InitialData;

import java.util.ArrayList;

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

    public void cargarData(Hospital hospital) {
        ArrayList<Turno> turnosIniciales = InitialData.cargarTurnos();
        for (Turno turno : turnosIniciales) {
            hospital.addShift(turno);
        }
    }
}
