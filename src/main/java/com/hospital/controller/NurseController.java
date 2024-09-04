package main.java.com.hospital.controller;

import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.service.NurseService;

import java.io.IOException;

public class NurseController {
    private NurseService nurseService;

    public NurseController(boolean loadData, Hospital hospital) {
        this.nurseService = new NurseService();
        if (loadData) {
            nurseService.loadInitialData(hospital);
        }
    }
    
    public static void addEnfermera(Hospital hospital) throws IOException {
        
    }
    public static void removeEnfermera(Hospital hospital) throws IOException {

    }
    public static void showEnfermeras(Hospital hospital) throws IOException {

    }
}
