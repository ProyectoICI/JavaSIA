package main.java.com.hospital.views.console;

import main.java.com.hospital.controller.DeptController;
import main.java.com.hospital.model.Hospital;

import java.io.BufferedReader;
import java.io.IOException;

public class DepartmentViews extends MenuViews {

    public static void submenuDepartamentos(BufferedReader scanner, Hospital hospital, DeptController deptController) throws IOException {
        int opcion;
        int cantApartamentos = hospital.getDepartments().size();

        DepartmentViews view = new DepartmentViews(); // Create an instance of the subclass
        do {
            System.out.println(" --------- ** DEPARTAMENTOS ** ------- ");
            System.out.println("1. Crear nuevo departamento");
            System.out.println("2. Eliminar departamento");
            System.out.println("3. Listar departamentos");
            System.out.println("4. Editar departamento");
            System.out.println("5. Volver atras");
            System.out.println(  "------------------------------------");
            opcion = Integer.parseInt(scanner.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Crear nuevo departamento");
                    DeptController.addDepartamento(hospital);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Eliminar departamento");
                    DeptController.removeDepartamento(hospital);
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Listar departamentos");
                    if (cantApartamentos != 0) {
                        DeptController.showApartamentos(hospital);
                    } else {
                        DeptController.showApartamentos();
                    }
                    break;
                case 4:
                    System.out.println("Opción seleccionada: Editar departamento");
                    view.submenu(scanner, hospital);
                    break;
                case 5:
                    System.out.println("Volviendo atras...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println();
        } while(opcion !=5);

    }

    @Override
    public void submenu(BufferedReader scanner, Hospital hospital) throws IOException {

        int subopcion;

        do {
            System.out.println(" --------- ** EDITAR DEPTO ** ------- ");
            System.out.println("1. Asignar enfermeras");
            System.out.println("2. Desasignar enfermeras");
            System.out.println("3. Cambiar necesidad enfermeras");
            System.out.println("4. Volver atras");
            System.out.println(  "------------------------------------");
            subopcion = Integer.parseInt(scanner.readLine());

            switch (subopcion) {
                case 1:
                    System.out.println("Opción seleccionada: Asignar enfermeras");
                    DeptController.asignarEnfermera(hospital, scanner);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Desasignar enfermeras");
                    DeptController.desasignarEnfermera(hospital, scanner);
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Cambiar necesidad enfermeras");
                    DeptController.cambioNecesidad(hospital, scanner);
                    break;
                case 4:
                    System.out.println("Volviendo atras...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println();
        } while(subopcion !=4);
    }


}
