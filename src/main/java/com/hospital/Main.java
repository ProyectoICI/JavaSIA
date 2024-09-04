package main.java.com.hospital;

/*
Gestión de turnos de enfermeras en un hospital: Sistema para la asignación de turnos de
enfermeras en un hospital, considerando disponibilidad, preferencias y necesidades por área.
Incluye gestión de cambios de turno, visualización de horarios y generación de reportes de
asistencia.
*/

import main.java.com.hospital.controller.DeptController;
import main.java.com.hospital.controller.HospitalController;
import main.java.com.hospital.controller.NurseController;
import main.java.com.hospital.controller.ShiftController;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.views.console.MenuViews;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boolean loadData        - Carga el programa con datos iniciales de ser verdadero
        * boolean randomizeShifts - De ser verdadero, crea turnos aleatorios iniciales para demostrar funcionalidad
        * */
        boolean loadData = false;
        boolean randomizeShifts = true;
        // TODO: Hacer que randomizeShifts habilite turnos aleatorios de mañana/día/noche de distintos departamentos.

        Hospital hospital = new Hospital();

        // Controladores
        DeptController deptController = new DeptController(loadData, hospital);
        HospitalController hospitalController = new HospitalController(loadData, hospital);
        NurseController nurseController = new NurseController(loadData, hospital);
        ShiftController shiftController = new ShiftController(loadData, hospital, randomizeShifts);
        
        // Menu de consola
        MenuViews menu = new MenuViews();

        MenuViews.menuPrincipal(hospital, deptController, hospitalController, nurseController, shiftController);



    }

}
