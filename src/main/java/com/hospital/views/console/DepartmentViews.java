package main.java.com.hospital.views.console;

import main.java.com.hospital.controller.DeptController;
import main.java.com.hospital.model.Hospital;

import java.io.BufferedReader;
import java.io.IOException;

public class DepartmentViews {
    // TODO: Hacer el submenu de los departamentos, añadir, remover, mostrar departamentos
    public static void submenuDepartamentos(BufferedReader scanner, Hospital hospital, DeptController deptController) throws IOException {
        int opcion;

        do {
            System.out.println(" --------- ** DEPARTAMENTOS ** ------- ");
            System.out.println("1. Crear nuevo departamento");
            System.out.println("2. Eliminar departamento");
            System.out.println("3. Listar departamentos");
            System.out.println("4. Volver atras");
            System.out.println(  "------------------------------------");
            opcion = Integer.parseInt(scanner.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Crear nuevo departamento");
                    DeptController.addDepartamento(hospital);

                    break;
                case 2:
                    System.out.println("Opción seleccionada: Eliminar departamento");
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Listar departamentos");
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
