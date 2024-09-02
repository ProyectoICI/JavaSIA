package main.java.com.hospital.controller;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.service.DepartmentService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DeptController {
    private DepartmentService departmentService = new DepartmentService();

    /*
    TODO: Agregar los checkeos correspondientes a cada funcion, esta el elemento? si no está que hacer?
     */
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

        ArrayList<Departamento> deptoObjeto = DepartmentService.listarDeptos(hospital);
        for (Departamento depto : deptoObjeto) {
            System.out.println("Departamento: " + depto.getNombreDepto() + " con id " + depto.getDeptoID() + " y necesidad " + depto.getNecesidadEnfermeras());
        }
    }

}