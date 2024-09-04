package main.java.com.hospital.repository;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Hospital;
import test.InitialData;

import java.util.ArrayList;

public class DepartmentRepo {
    public void guardar(Hospital hospital, Departamento departamento) {
        hospital.addDepartment(departamento);
    }

    public void remover(Hospital hospital, Departamento departamento) {
        hospital.removeDepartment(departamento);
    }

    public ArrayList<Departamento> encontrarTodos(Hospital hospital) {
        return new ArrayList<>(hospital.getDepartments());
    }

    public Departamento buscarDepto(Hospital hospital, int id) {
        return hospital.getDepartment(id);
    }

    public void cargarData(Hospital hospital) {
        ArrayList<Departamento> departamentosIniciales = InitialData.cargarDeptos();
        for (Departamento departamento : departamentosIniciales) {
            hospital.addDepartment(departamento);
        }
    }
}
