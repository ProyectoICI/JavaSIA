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
import main.java.com.hospital.model.Database;
import main.java.com.hospital.views.console.MenuViews;
import main.java.com.hospital.views.swing.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        boolean oldLoadData;
        Connection db = null;


        /*
        * boolean cargaBaseDatos        - Carga el programa con datos de la base de datos de ser verdadero
        * boolean randomizeShifts       - De ser verdadero, crea turnos aleatorios iniciales para demostrar funcionalidad
        * boolean conConsola            - Carga la interfaz con consola, de lo contrario usa JavaSwing
        * */
        boolean cargaBaseDatos = true;
        boolean randomizeShifts = true;
        boolean conConsola = true;
        // TODO: Hacer que randomizeShifts habilite turnos aleatorios de mañana/día/noche de distintos departamentos.

        Hospital hospital = new Hospital();

        if (cargaBaseDatos) {
            db = Database.connectDatabase();
            oldLoadData = false;
        } else {
            oldLoadData = true;
        }

        // Controladores
        DeptController deptController = new DeptController(oldLoadData, hospital, db);
        HospitalController hospitalController = new HospitalController(oldLoadData, hospital, db);
        NurseController nurseController = new NurseController(oldLoadData, hospital, db);
        ShiftController shiftController = new ShiftController(oldLoadData, hospital, randomizeShifts, db);

        // ** IMPORTANTE **
        // Esto te permite guardar la información antes de cerrar el programa.
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("\n");
                Database.closeDatabase();
                System.out.println("\nApagandose...");

            }
        });

        if (conConsola) {
            MenuViews menu = new MenuViews();
            MenuViews.menuPrincipal(hospital, deptController, hospitalController, nurseController, shiftController);
        } else {
            JFrame javaSwing = new JFrame("Gestión de turnos");
            MainFrame mainPanel = new MainFrame();

            javaSwing.setContentPane(mainPanel.getContentPane());

            javaSwing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            javaSwing.setSize(800, 600);
            javaSwing.setLocationRelativeTo(null);
            javaSwing.setResizable(false);
            javaSwing.setVisible(true);

        }


    }



}
