package main.java.com.hospital.controller;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.service.DepartmentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeptController {
    private DepartmentService departmentService = new DepartmentService();
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void addDepartamento() throws IOException {
        System.out.println("Ingrese el número o nombre del hospital en el cual reside este departamento");

        String respuestaHospital = br.readLine();

        System.out.println("Ingrese el nombre del departamento\n" +
                           "Puede ser por ejemplo 'Radiología'");

        String nombreDepto = br.readLine();

        System.out.println("Ingrese el número de identificación del departamento 'ID'");

        int numeroID = Integer.parseInt(br.readLine());

        Departamento departamento = new Departamento(nombreDepto, numeroID);
        DepartmentService.agregarDepto(hospital, departamento);
        br.close();
    }
}