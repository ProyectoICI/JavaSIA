package main.java.com.hospital.views.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// -- CONTROLADORES --
import main.java.com.hospital.controller.DeptController;
import main.java.com.hospital.controller.HospitalController;
import main.java.com.hospital.controller.NurseController;
import main.java.com.hospital.controller.ShiftController;
import main.java.com.hospital.model.Hospital;

// -- VISTAS DE SUBMENUS --
import static main.java.com.hospital.views.console.HospitalViews.submenuHospital;
import static main.java.com.hospital.views.console.OtherViews.*;
import static main.java.com.hospital.views.console.ShiftViews.submenuTurnos;
import static main.java.com.hospital.views.console.DepartmentViews.submenuDepartamentos;

public class MenuViews {
    public static void menuPrincipal(Hospital hospital,
                                     DeptController deptController,
                                     HospitalController hospitalController,
                                     NurseController nurseController,
                                     ShiftController shiftController) throws IOException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

        int opcion;

        do {
            System.out.println(" ** HOSPITAL '" + hospital.getNombreHospital() + "' N°" + hospital.getNumeroHospital() + " **");
            System.out.println("Dirección: " + hospital.getDireccionHospital());
            System.out.println();
            System.out.println(" ----- Menú principal -----");
            System.out.println("1. Administrar modelos");
            System.out.println("2. Visualizar Horarios");
            System.out.println("3. Reporte de Asistencia");
            System.out.println("4. Reporte de los modelos");
            System.out.println("5. Asistencia Crítica por Depto");
            System.out.println("6. Salir");
            System.out.println(" --------------------------");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Administrar modelos");
                    submenuModelos(scanner, hospital, deptController, hospitalController, nurseController, shiftController);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Visualizar Horarios");
                    shiftController.calculoPrioridad();
                    horariosVisual(scanner, hospital);
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Generar reporte de Asistencia");
                    reporteAsistencia(scanner, hospital);
                    break;
                case 4:
                    System.out.println("Opción seleccionada: Generar reporte de los modelos");
                    reporteModelos(scanner, hospital);
                    break;
                case 5:
                    System.out.println("Opción seleccionada: Asistencia crítica por Depto");
                    asistenciaCritica(scanner, hospital);
                    break;
                case 6:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println();
        } while(opcion != 6);

        scanner.close();
    }

    private static void submenuModelos(BufferedReader scanner, Hospital hospital,
                                       DeptController deptController,
                                       HospitalController hospitalController,
                                       NurseController nurseController,
                                       ShiftController shiftController) throws IOException
    {
        int subOpcion;
        NurseViews view = new NurseViews();
        do {
            System.out.println(" ---------- ** MODELOS ** -------- ");
            System.out.println("1. Hospital");
            System.out.println("2. Enfermeras");
            System.out.println("3. Departamentos");
            System.out.println("4. Turno");
            System.out.println("5. Volver atras");
            System.out.println(  "------------------------------------");

            subOpcion = Integer.parseInt(scanner.readLine());

            switch (subOpcion) {
                case 1:
                    System.out.println("Opción seleccionada: Hospital");
                    submenuHospital(scanner, hospital, hospitalController);
                    esperarVolver(scanner);
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Enfermeras");
                    view.submenu(scanner, hospital);
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
                case 5:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println();
        } while (subOpcion != 5);
    }


    private static void esperarVolver(BufferedReader scanner) throws IOException {
        System.out.println("Presione 0 para volver al menú anterior.");
        int volver = Integer.parseInt(scanner.readLine());
        while (volver != 0) {
            System.out.println("Por favor, presione 0 para volver al menú anterior.");
            volver = Integer.parseInt(scanner.readLine());
        }
    }

    public void submenu(BufferedReader scanner, Hospital hospital) throws IOException {
        int subopcion;

        do {
            System.out.println(" --------- ** SUBMENU ** ------- ");
            System.out.println("1. Opcion");
            System.out.println("2. Volver atras");
            System.out.println( "--------------------------------");
            subopcion = Integer.parseInt(scanner.readLine());

            switch (subopcion) {
                case 1:
                    System.out.println("Opcion seleccionada...");
                    break;
                case 2:
                    System.out.println("Volviendo atras...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
            System.out.println();
        } while(subopcion != 2);
    }

}
