package main.java.com.hospital.model;

import java.util.ArrayList;

public class Hospital {
    private String nombreHospital;
    private String numeroHospital;
    private String direccionHospital;
    private ArrayList<Enfermera> enfermerasHospital;
    private ArrayList<Departamento> deptosHospital;
    private ArrayList<Turno> turnosHospital;

    public Hospital() {
        this.nombreHospital = "Sin nombre";
        this.numeroHospital = "Sin número";
        this.direccionHospital = "Sin dirección";
        enfermerasHospital = new ArrayList<>();
        deptosHospital = new ArrayList<>();
        turnosHospital = new ArrayList<>();
    }

    // Metodos de añadir

    public void addNurse(Enfermera enfermera) {
        enfermerasHospital.add(enfermera);
    }

    public void addDepartment(Departamento departamento) {
        deptosHospital.add(departamento);
    }

    public void addShift(Turno turno) {
        turnosHospital.add(turno);
    }

    // Metodos para remover

    public void removeNurse(Enfermera enfermera) {
        enfermerasHospital.remove(enfermera);
    }

    public void removeDepartment(Departamento departamento) {
        deptosHospital.remove(departamento);
    }

    public void removeShift(Turno turno) {
        turnosHospital.remove(turno);
    }

    // Metodos de busqueda

    public ArrayList<Enfermera> getNurses() {
        return new ArrayList<>(enfermerasHospital);
    }

    public ArrayList<Departamento> getDepartments() {
        return new ArrayList<>(deptosHospital);
    }

    public ArrayList<Turno> getShifts() {
        return new ArrayList<>(turnosHospital);
    }

    // Getters & Setters

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getNumeroHospital() {
        return numeroHospital;
    }

    public void setNumeroHospital(String numeroHospital) {
        this.numeroHospital = numeroHospital;
    }

    public String getDireccionHospital() {
        return direccionHospital;
    }

    public void setDireccionHospital(String direccionHospital) {
        this.direccionHospital = direccionHospital;
    }

    public ArrayList<Enfermera> getEnfermerasHospital() {
        return enfermerasHospital;
    }

    public void setEnfermerasHospital(ArrayList<Enfermera> enfermerasHospital) {
        this.enfermerasHospital = enfermerasHospital;
    }
}
