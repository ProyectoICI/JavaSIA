package main.java.com.hospital.controller;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.service.DepartmentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

import java.sql.Connection;

public class DeptController {
    private DepartmentService departmentService;

    public DeptController(boolean oldLoadData, Hospital hospital, Connection db) throws IOException {
        this.departmentService = new DepartmentService();
        if (oldLoadData) {
            DepartmentService.oldLoadInitialData(hospital);
        } else {
            DepartmentService.loadDatabaseData(hospital, db);
        }
    }

    public static void addDepartamento(Hospital hospital) throws IOException {
        Scanner scanner  = new Scanner(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre del departamento\n" +
                           "Puede ser por ejemplo 'Radiología'");

        String nombreDepto = scanner.nextLine();

        System.out.println("Ingrese el número de identificación del departamento 'ID'");

        int numeroID = scanner.nextInt();

        System.out.println("Ingrese la cantidad necesaria de enfermeras para el area");

        int cantEnfermeras = scanner.nextInt();

        Departamento departamento = new Departamento(nombreDepto, numeroID, cantEnfermeras);

        Departamento verificacionID = DepartmentService.buscarDepto(hospital, numeroID);

        if (verificacionID == null) {
            DepartmentService.agregarDepto(hospital, departamento);
            System.out.println("Depto agregado con exito.");
        } else {
            System.out.println("El ID " + numeroID + " ya esta en uso.");
        }

    }

    public static void removeDepartamento(Hospital hospital) throws IOException {
        Scanner scanner  = new Scanner(new InputStreamReader(System.in));
        System.out.println("Ingrese el ID del departamento a eliminar");
        int id = scanner.nextInt();

        Departamento departamentoBuscado = DepartmentService.buscarDepto(hospital, id);
        if (departamentoBuscado != null) {
            DepartmentService.eliminarDepto(hospital, departamentoBuscado);
        } else {
            System.out.println("No existe el departamento con el ID " + id);
        }
    }

    public static void showApartamentos(Hospital hospital) throws IOException {

        Map<Integer, Departamento> deptoObjeto = DepartmentService.listarDeptos(hospital);
        for (Departamento depto : deptoObjeto.values()) {
            System.out.println("Departamento: '" + depto.getNombreDepto() + "' con id '" + depto.getDeptoID() + "' y necesidad '" + depto.getNecesidadEnfermeras() + "'");
        }
    }

    public static void showApartamentos() {
        System.out.println("No se encontraron departamentos.");
    }

    public static void asignarEnfermera(Hospital hospital, BufferedReader scanner) throws IOException {
        System.out.println("Ingrese el número (ID) del departamento a asignar la enfermera");
        int id = Integer.parseInt(scanner.readLine());
        Departamento deptoFound = hospital.getDepartment(id);
        if (deptoFound != null) {
            System.out.println("Ingrese el número (ID) de la enfermera a asignar");
            int idEnfermera = Integer.parseInt(scanner.readLine());
            Enfermera enfermera = hospital.getNurse(idEnfermera);
            if (enfermera != null) {
                System.out.println("Enfermera asignada con éxito.");
                enfermera.setDeptoAsignado(deptoFound.getNombreDepto());
                deptoFound.addEnfermera(enfermera);
            } else {
                System.out.println("Enfermera con el ID " + idEnfermera + " no existe");
            }
        } else {
            System.out.println("No existe el departamento con el ID " + id);
        }
    }


    public static void desasignarEnfermera(Hospital hospital, BufferedReader scanner) throws IOException {
        System.out.println("Ingrese el número (ID) del departamento a desasignar la enfermera");
        int id = Integer.parseInt(scanner.readLine());
        Departamento deptoFound = hospital.getDepartment(id);
        if (deptoFound != null) {
            System.out.println("Ingrese el número (ID) de la enfermera a desasignar");
            int idEnfermera = Integer.parseInt(scanner.readLine());
            Enfermera enfermera = hospital.getNurse(idEnfermera);
            if (enfermera != null) {
                System.out.println("Enfermera asignada con éxito.");
                enfermera.setDeptoAsignado("Ninguno");
                deptoFound.removeEnfermera(enfermera);
            } else {
                System.out.println("Enfermera con el ID " + idEnfermera + " no existe");
            }
        } else {
            System.out.println("No existe el departamento con el ID " + id);
        }
    }

    public static void cambioNecesidad(Hospital hospital, BufferedReader scanner) throws IOException {
        System.out.println("Ingrese el número (ID) del departamento a cambiar la necesidad");
        int id = Integer.parseInt(scanner.readLine());
        Departamento deptoFound = hospital.getDepartment(id);
        if (deptoFound != null) {
            System.out.println("Ingrese la necesidad nueva del depto");
            System.out.println(" NECESIDAD ACTUAL : " + deptoFound.getNecesidadEnfermeras());
            int necesidad = Integer.parseInt(scanner.readLine());
            deptoFound.setNecesidadEnfermeras(necesidad);
        } else {
            System.out.println("No existe el departamento con el ID " + id);
        }
    }


}