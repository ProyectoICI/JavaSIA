package main.java.com.hospital.views.console;

import main.java.com.hospital.controller.DeptController;
import main.java.com.hospital.controller.NurseController;
import main.java.com.hospital.model.Hospital;

import java.io.BufferedReader;
import java.io.IOException;

public class NurseViews extends MenuViews {

    @Override
    public void submenu(BufferedReader scanner, Hospital hospital) throws IOException {
        int opcion;
        int numEnfermeras = hospital.getNurses().size();

        do {
            System.out.println(" --------- ** ENFERMERAS ** ------- ");
            System.out.println("1. Crear nueva enfermera");
            System.out.println("2. Eliminar enfermera");
            System.out.println("3. Listar enfermeras");
            System.out.println("4. Volver atras");
            System.out.println(  "------------------------------------");
            opcion = Integer.parseInt(scanner.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Crear nuevo departamento");
                    NurseController.addEnfermera(hospital);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Eliminar departamento");
                    NurseController.removeEnfermera(hospital);
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Listar departamentos");
                    if (numEnfermeras != 0) {
                        NurseController.showEnfermeras(hospital);
                    } else {
                        NurseController.showEnfermeras();
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
