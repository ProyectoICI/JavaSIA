package test;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;

import java.util.ArrayList;

public class InitialData {
    // TODO: Agregar datos iniciales inicializando y poblando un ArrayList de departamentos y retornandolo
    public static ArrayList<Departamento> cargarDeptos() {
        ArrayList<Departamento> deptosIniciales = new ArrayList<>();
        return deptosIniciales;
    }
    // TODO: Agregar datos iniciales inicializando y poblando un ArrayList de enfermeras y retornandolo
    public static ArrayList<Enfermera> cargarEnfermeras() {
        ArrayList<Enfermera> enfermerasIniciales = new ArrayList<>();
        return enfermerasIniciales;
    }
    // TODO: Agregar datos iniciales inicializando y poblando un ArrayList de turnos y retornandolo
    public static ArrayList<Turno> cargarTurnos() {
        ArrayList<Turno> turnosIniciales = new ArrayList<>();
        return turnosIniciales;

    }
    // TODO: Agregar datos iniciales inicializando y poblando los atributos de un hospital y retornandolo
    public static Hospital cargarHospital() {
        Hospital hospital = new Hospital();
        return hospital;
    }
}
