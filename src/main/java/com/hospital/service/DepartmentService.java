package main.java.com.hospital.service;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.repository.DepartmentRepo;
import test.InitialData;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DepartmentService {
    public static final DepartmentRepo departmentRepo = new DepartmentRepo();

    public static void oldLoadInitialData(Hospital hospital) {
        departmentRepo.cargarData(hospital);
    }

    public static void loadDatabaseData(Hospital hospital, Connection db) { departmentRepo.cargarDataDB(hospital, db); }

    public static void eliminarDepto(Hospital hospital, Departamento departamento) {
        departmentRepo.remover(hospital, departamento);
    }

    public static void agregarDepto(Hospital hospital, Departamento departamento) {
        departmentRepo.guardar(hospital, departamento);
    }

    public static Map<Integer, Departamento> listarDeptos(Hospital hospital) {
        return departmentRepo.encontrarTodos(hospital);
    }

    public static Departamento buscarDepto(Hospital hospital, int ID) {
        return departmentRepo.buscarDepto(hospital, ID);
    }
}
