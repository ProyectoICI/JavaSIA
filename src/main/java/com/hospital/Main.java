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
            System.out.println("1. Editar Turnos");
            System.out.println("2. Visualizar Horarios");
            System.out.println("3. Registro de Asistencia");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.readLine());

            switch (opcion) {
                case 1:
                    mostrarSubmenu(scanner);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Visualizar Horarios");
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Registro de Asistencia");
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

    private static void mostrarSubmenu(BufferedReader scanner) throws IOException {
        int subOpcion;

        do {
            System.out.println("Submenú - Editar Turnos:");
            System.out.println("1. Añadir enfermera");
            System.out.println("2. Eliminar enfermera");
            System.out.println("3. Añadir departamento");
            System.out.println("4. Eliminar departamento");
            System.out.println("5. Modificar turno entre enfermeras");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            subOpcion = Integer.parseInt(scanner.readLine());

            switch (subOpcion) {
                case 1:
                    System.out.println("Opción seleccionada: Añadir enfermera");
                    esperarVolver(scanner);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Eliminar enfermera");
                    esperarVolver(scanner);
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Añadir departamento");
                    esperarVolver(scanner);
                    break;
                case 4:
                    System.out.println("Opción seleccionada: Eliminar departamento");
                    esperarVolver(scanner);
                    break;
                case 5:
                    System.out.println("Opción seleccionada: Modificar turno entre enfermeras");
                    esperarVolver(scanner);
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println();
        } while (subOpcion != 6);
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
