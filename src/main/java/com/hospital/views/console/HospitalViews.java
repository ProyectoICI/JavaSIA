package main.java.com.hospital.views.console;

import main.java.com.hospital.controller.DeptController;
import main.java.com.hospital.controller.HospitalController;
import main.java.com.hospital.model.Hospital;

import java.io.BufferedReader;
import java.io.IOException;


public class HospitalViews {
    // TODO: Hacer el submenu del hospital, editar sus atributos
    public static void submenuHospital(BufferedReader scanner, Hospital hospital, HospitalController hospitalController) throws IOException {
        int opcion;

        do {
            System.out.println(" --------- ** HOSPITAL ** ------- ");
            System.out.println("1. Cambio de nombre");
            System.out.println("2. Cambio de número");
            System.out.println("3. Cambio de dirección");
            System.out.println("4. Volver atras");
            System.out.println(  "------------------------------------");
            opcion = Integer.parseInt(scanner.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Cambio de nombre");
                    HospitalController.changeNombre(hospital);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Cambio de número");
                    HospitalController.changeNumero(hospital);
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Cambio de dirección");
                    HospitalController.changeDireccion(hospital);
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
