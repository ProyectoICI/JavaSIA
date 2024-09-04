package main.java.com.hospital.controller;

import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.service.ShiftService;

public class ShiftController {
    private ShiftService shiftService;

    public ShiftController(boolean loadData, Hospital hospital) {
        this.shiftService = new ShiftService();
        if (loadData) {
            shiftService.loadInitialData(hospital);
        }
    }
    // TODO: Hacer la lógica de ordenar la asignación de los turnos en base a las prioridades y necesidades de cada área.
    // TODO: Poblar los turnos basados en esa lógica
    public void calculoPrioridad() {
    }
}
