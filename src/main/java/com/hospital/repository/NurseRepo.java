package main.java.com.hospital.repository;

import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import test.InitialData;

import java.util.ArrayList;

public class NurseRepo {

    public void guardar(Hospital hospital, Enfermera enfermera) {
        hospital.addNurse(enfermera);
    }


    public void remover(Hospital hospital, Enfermera enfermera) {
        hospital.removeNurse(enfermera);
    }

    public ArrayList<Enfermera> encontrarTodos(Hospital hospital) {
        return new ArrayList<>(hospital.getNurses());
    }

    public void cargarData(Hospital hospital) {
        ArrayList<Enfermera> enfermerasIniciales = InitialData.cargarEnfermeras();
        for(Enfermera enfermera : enfermerasIniciales) {
            hospital.addNurse(enfermera);
        }
    }
}

