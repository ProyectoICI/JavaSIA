package main.java.com.hospital.controller;

import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.service.HospitalService;

import java.io.InputStreamReader;
import java.util.Scanner;

public class HospitalController {
    private HospitalService hospitalService;

    public HospitalController(boolean loadData, Hospital hospital) {
        this.hospitalService = new HospitalService();
        if (loadData) {
            hospitalService.loadInitialData(hospital);
        }
    }

    public static void changeNombre(Hospital hospital) {
        Scanner scanner  = new Scanner(new InputStreamReader(System.in));
        System.out.println("Ingrese el nombre nuevo del hospital:");
        String nombre = scanner.nextLine();
        HospitalService.cambioNombre(hospital, nombre);
    }

    public static void changeNumero(Hospital hospital) {
        Scanner scanner  = new Scanner(new InputStreamReader(System.in));
        System.out.println("Ingrese el numero nuevo del hospital:");
        int numero = scanner.nextInt();
        HospitalService.cambioNumero(hospital, numero);
    }

    public static void changeDireccion(Hospital hospital) {
        Scanner scanner  = new Scanner(new InputStreamReader(System.in));
        System.out.println("Ingrese la direccion nueva del hospital:");
        String direccion = scanner.nextLine();
        HospitalService.cambioDireccion(hospital, direccion);
    }
}
