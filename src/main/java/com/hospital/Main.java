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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // Controladores
        DeptController deptController = new DeptController();
        HospitalController hospitalController = new HospitalController();
        NurseController nurseController = new NurseController();
        ShiftController shiftController = new ShiftController();

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Hospital hospital = new Hospital();

        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Administrar modelos");
            System.out.println("2. Visualizar Horarios");
            System.out.println("3. Reporte de Asistencia");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Administrar modelos");
                    submenuModelos(scanner, hospital, deptController, hospitalController, nurseController, shiftController);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Visualizar Horarios");
                    horariosVisual(scanner, hospital);
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Generar reporte de Asistencia");

                    break;
                case 4:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 4);

        scanner.close();
    }

    private static void submenuModelos(BufferedReader scanner, Hospital hospital,
                                       DeptController deptController,
                                       HospitalController hospitalController,
                                       NurseController nurseController,
                                       ShiftController shiftController) throws IOException
    {
        int subOpcion;

        do {
            System.out.println(" ---------- ** MODELOS ** -------- ");
            System.out.println("1. Hospital");
            System.out.println("2. Enfermeras");
            System.out.println("3. Departamentos");
            System.out.println("4. Turno");
            System.out.println("5. Salir");
            System.out.print(  "------------------------------------");

            subOpcion = Integer.parseInt(scanner.readLine());

            switch (subOpcion) {
                case 1:
                    System.out.println("Opción seleccionada: Hospital");
                    submenuHospital(scanner, hospital, hospitalController);
                    esperarVolver(scanner);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Enfermeras");
                    submenuEnfermeras(scanner, hospital, nurseController);
                    esperarVolver(scanner);
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Departamentos");
                    submenuDepartamentos(scanner, hospital, deptController);
                    esperarVolver(scanner);
                    break;
                case 4:
                    System.out.println("Opción seleccionada: Turnos");
                    submenuTurnos(scanner, hospital, shiftController);
                    esperarVolver(scanner);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println();
        } while (subOpcion != 5);

    }

    public static void reporteAsistencia(BufferedReader scanner, Hospital hospital) throws IOException {

    }

    // TODO: Hacer el menú visual para ver los horarios asignados a cada turno
    private static void horariosVisual(BufferedReader scanner, Hospital hospital) throws IOException {

    }

    // TODO: Hacer el submenu del hospital, editar sus atributos
    private static void submenuHospital(BufferedReader scanner, Hospital hospital, HospitalController hospitalController) {

    }

    // TODO: Hacer el submenu de las enfermeras, añadir, remover, mostrar enfermeras
    private static void submenuEnfermeras(BufferedReader scanner, Hospital hospital, NurseController nurseController) {

    }

    // TODO: Hacer el submenu de los departamentos, añadir, remover, mostrar departamentos
    private static void submenuDepartamentos(BufferedReader scanner, Hospital hospital, DeptController deptController) {

    }

    // TODO: Hacer el submenu de los turnos (Hay que ver como funcionan los turnos en hospitales, aunque se que es "automatico")
    private static void submenuTurnos(BufferedReader scanner, Hospital hospital, ShiftController shiftController) {

    }

    private static void esperarVolver(BufferedReader scanner) throws IOException {
        System.out.println("Presione 0 para volver al menú anterior.");
        int volver = Integer.parseInt(scanner.readLine());
        while (volver != 0) {
            System.out.println("Por favor, presione 0 para volver al menú anterior.");
            volver = Integer.parseInt(scanner.readLine());
        }
    }

}
