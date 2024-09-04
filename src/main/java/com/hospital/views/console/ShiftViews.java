package main.java.com.hospital.views.console;

import main.java.com.hospital.controller.DeptController;
import main.java.com.hospital.controller.ShiftController;
import main.java.com.hospital.model.Hospital;

import java.io.BufferedReader;
import java.io.IOException;

public class ShiftViews {
    // TODO: Hacer el submenu de los turnos (Hay que ver como funcionan los turnos en hospitales, aunque se que es "automatico")
    public static void submenuTurnos(BufferedReader scanner, Hospital hospital, ShiftController shiftController) throws IOException {
        int opcion;
        int cantTurnos = hospital.getShifts().size();

        do {
            System.out.println(" --------- ** TURNOS ** ------- ");
            System.out.println("1. Crear nuevo turno");
            System.out.println("2. Eliminar turno");
            System.out.println("3. Listar turnos");
            System.out.println("4. Volver atras");
            System.out.println(  "------------------------------------");
            opcion = Integer.parseInt(scanner.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Crear nuevo turno");
                    ShiftController.addTurno(hospital);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Eliminar turno");
                    ShiftController.removeTurno(hospital);
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Listar turnos");
                    if (cantTurnos != 0) {
                        ShiftController.listarTurnos(hospital);
                    } else {
                        ShiftController.listarTurnos();
                    }
                    break;
                case 4:
                    System.out.println("Volviendo atras...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println();
        } while(opcion !=4);

    }
}
