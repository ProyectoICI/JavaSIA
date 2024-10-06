package main.java.com.hospital.repository;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Hospital;
import test.InitialData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DepartmentRepo {
    public void guardar(Hospital hospital, Departamento departamento) {
        hospital.addDepartment(departamento);
    }



    public void remover(Hospital hospital, Departamento departamento) {
        hospital.removeDepartment(departamento);
    }

    public HashMap<Integer,Departamento> encontrarTodos(Hospital hospital) {
        return new HashMap<>(hospital.getDepartments());
    }

    public Departamento buscarDepto(Hospital hospital, int id) {
        return hospital.getDepartment(id);
    }

    public void cargarData(Hospital hospital) {
        Map<Integer, Departamento> departamentosIniciales = InitialData.cargarDeptos();
        for (Departamento departamento : departamentosIniciales.values()) {
            hospital.addDepartment(departamento);
        }
    }
}
