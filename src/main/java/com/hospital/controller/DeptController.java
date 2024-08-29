package main.java.com.hospital.controller;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.service.DepartmentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DeptController {
    private DepartmentService departmentService = new DepartmentService();


    public static void addDepartamento(Hospital hospital) throws IOException {
        Scanner scanner  = new Scanner(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre del departamento\n" +
                           "Puede ser por ejemplo 'Radiología'");

        String nombreDepto = scanner.nextLine();

        System.out.println("Ingrese el número de identificación del departamento 'ID'");

        int numeroID = scanner.nextInt();


        Departamento departamento = new Departamento(nombreDepto, numeroID);
        DepartmentService.agregarDepto(hospital, departamento);

    }
}