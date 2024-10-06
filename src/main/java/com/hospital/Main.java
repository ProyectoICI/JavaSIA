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
import main.java.com.hospital.views.swing.MainFrame;

import javax.swing.*;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * boolean loadData        - Carga el programa con datos iniciales de ser verdadero
        * boolean randomizeShifts - De ser verdadero, crea turnos aleatorios iniciales para demostrar funcionalidad
        * */
        boolean loadData = false;
        boolean randomizeShifts = true;
        boolean conConsola = true;
        // TODO: Hacer que randomizeShifts habilite turnos aleatorios de mañana/día/noche de distintos departamentos.

        Hospital hospital = new Hospital();

        // Controladores
        DeptController deptController = new DeptController(loadData, hospital);
        HospitalController hospitalController = new HospitalController(loadData, hospital);
        NurseController nurseController = new NurseController(loadData, hospital);
        ShiftController shiftController = new ShiftController(loadData, hospital, randomizeShifts);

        connectDatabase();

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

    public static void connectDatabase() {
        Connection conn = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // db parameters
            String url = "jdbc:sqlite:src\\main\\resources\\database.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println(" --------------------------- ");
            System.out.println("** BASE DE DATOS CONECTADA **");
            System.out.println(" --------------------------- ");

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
