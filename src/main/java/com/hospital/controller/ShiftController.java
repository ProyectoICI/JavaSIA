package main.java.com.hospital.controller;

import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;
import main.java.com.hospital.service.ShiftService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.Connection;

public class ShiftController {
    private static ShiftService shiftService;

    public ShiftController(boolean oldLoadData, Hospital hospital, boolean randomizeShifts, Connection db) throws SQLException {
        shiftService = new ShiftService();
        if (oldLoadData && randomizeShifts) {
            shiftService.oldLoadInitialData(hospital, randomizeShifts);
        } else if (oldLoadData) {
            shiftService.oldLoadInitialData(hospital);
        } else {
            shiftService.loadDatabaseData(hospital, db);
        }
    }

    public static void addTurno(Hospital hospital) throws IOException {
        Turno turnoNuevo = new Turno();
        ShiftService.agregarTurno(hospital, turnoNuevo);
    }

    public static void removeTurno(Hospital hospital) throws IOException {
        Turno turnoEliminar = new Turno();
        ShiftService.eliminarTurno(hospital, turnoEliminar);
    }

    public static void listarTurnos(Hospital hospital) throws IOException {
        ArrayList<Turno> turnosHospital = ShiftService.listarTurnos(hospital);
        for (Turno turno : turnosHospital) {
            System.out.println("------------");
            System.out.println("Turno horario: '" + turno.getHorarioTurno() + "'");
            System.out.println("Día a concretarse: '" + turno.getDiaTurno() + "'");
            System.out.println("Departamento: '" + turno.getDeptoTurno() + "'");
            System.out.println("Enfermera asignada: " + turno.getEnfermeraAsignada());
        }
        System.out.println("------------");
    }

    public static void listarTurnos() {
        System.out.println("No se encontraron turnos.");
    }

    public void calculoPrioridad() {

    }
}
