package test;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;

import java.util.ArrayList;

public class InitialData {
    // TODO: Agregar datos iniciales inicializando y poblando un ArrayList de departamentos y retornandolo
    // TODO:
    public static ArrayList<Departamento> cargarDeptos() {
        ArrayList<Departamento> deptosIniciales = new ArrayList<>();

        Departamento depto1 = new Departamento("Cardiología", 001, 3);
        Departamento depto2 = new Departamento("Anestesiología", 002, 1);
        Departamento depto3 = new Departamento("Pediatría", 003, 2);
        Departamento depto4 = new Departamento("Cirugía general", 004, 4);
        Departamento depto5 = new Departamento("Cuidados intensivos", 005, 5);
        Departamento depto6 = new Departamento("Laboratorios clínicos", 006, 6);

        deptosIniciales.add(depto1);
        deptosIniciales.add(depto2);
        deptosIniciales.add(depto3);
        deptosIniciales.add(depto4);
        deptosIniciales.add(depto5);
        deptosIniciales.add(depto6);

        return deptosIniciales;
    }
    // TODO: Agregar datos iniciales inicializando y poblando un ArrayList de enfermeras y retornandolo
    // TODO: Alrededor de 25 enfermeras distintas
    public static ArrayList<Enfermera> cargarEnfermeras() {
        ArrayList<Enfermera> enfermerasIniciales = new ArrayList<>();
        return enfermerasIniciales;
    }
    // TODO: Agregar datos iniciales inicializando y poblando un ArrayList de turnos y retornandolo
    // TODO: Aquí implementar los turnos aleatorios de ser verdadero en la clase Main.
    public static ArrayList<Turno> cargarTurnos() {
        ArrayList<Turno> turnosIniciales = new ArrayList<>();
        return turnosIniciales;

    }
    // TODO: Agregar datos iniciales inicializando y poblando los atributos de un hospital y retornandolo
    public static Hospital cargarHospital() {
        return new Hospital("Hospital Dr. Gustavo Fricke",
                "057",
                "Álvarez 1532, Viña del Mar, Valparaíso");
    }
}
