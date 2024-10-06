package main.java.com.hospital.model;

import main.java.com.hospital.model.Exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hospital {
    private String nombreHospital;
    private String numeroHospital;
    private String direccionHospital;
    private ArrayList<Enfermera> enfermerasHospital;
    private Map<Integer, Departamento> deptosHospital;
    private ArrayList<Turno> turnosHospital;

    public Hospital() {
        this.nombreHospital = "Sin nombre";
        this.numeroHospital = "001";
        this.direccionHospital = "Sin dirección";
        enfermerasHospital = new ArrayList<>();
        deptosHospital = new HashMap<>();
        turnosHospital = new ArrayList<>();
    }

    // Sobrecarga de constructor
    public Hospital(String nombreHospital, String numeroHospital, String direccionHospital) {
        this.nombreHospital = nombreHospital;
        this.numeroHospital = numeroHospital;
        this.direccionHospital = direccionHospital;
        enfermerasHospital = new ArrayList<>();
        deptosHospital = new HashMap<>();
        turnosHospital = new ArrayList<>();
    }

    // Metodos del hospital
    public void changeNumber(int numero, Hospital hospital) {
        hospital.setNumeroHospital(String.valueOf(numero));
    }

    public void changeLocation(String direccion, Hospital hospital) {
        hospital.setDireccionHospital(direccion);
    }

    public void changeName(String nombre, Hospital hospital) {
        hospital.setNombreHospital(nombre);
    }

    // Metodos de añadir

    public void addNurse(Enfermera enfermera) {
        enfermerasHospital.add(enfermera);
    }

    public void addDepartment(Departamento departamento) {
        deptosHospital.put(deptosHospital.size(), departamento);
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

    public Map<Integer, Departamento> getDepartments() {
        return new HashMap<>(deptosHospital);
    }

    public ArrayList<Turno> getShifts() {
        return new ArrayList<>(turnosHospital);
    }

    public Enfermera getNurse(int id) {
        for (Enfermera enfermera : enfermerasHospital) {
            if (enfermera.getEnfermeraID() == id) {
                return enfermera;
            }
        }
        return null;
    }

    public Enfermera getNurse(String nombre) {
        Enfermera enfermeraCopia = new Enfermera();
        int contador = 0;

        for (Enfermera enfermera : enfermerasHospital) {
            if (enfermera.getNombre().equals(nombre)) {
                contador++;

                enfermeraCopia = enfermera;
            }
        }
        if (contador > 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Se han encontrado más de dos enfermeras con el mismo nombre");
            System.out.println("Ingrese el apellido para más precisión");
            String apellido = scanner.nextLine();
            for (Enfermera enfermera : enfermerasHospital) {
                if (enfermera.getApellido().equals(apellido)) {
                    return enfermera;
                }
            }
            System.out.println("No se ha encontrado una enfermera con ese apellido.");
        } else if (enfermeraCopia != null) {
            return enfermeraCopia;
        }

        return null;
    }

    public Departamento getDepartment(int id)  {
        for (Departamento departamento : deptosHospital.values()) {
            if (departamento.getDeptoID() == id) {
                return departamento;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hospital: ").append(nombreHospital).append("\n");
        sb.append("Numero: ").append(numeroHospital).append("\n");
        sb.append("Direccion: ").append(direccionHospital).append("\n");
        sb.append(" ----- Enfermeras: ----- \n");
        for (Enfermera e : enfermerasHospital) {
            sb.append(e.toString()).append("\n");
        }
        sb.append(" ----- Departamentos: ----- \n");
        for (Map.Entry<Integer, Departamento> entry : deptosHospital.entrySet()) {
            sb.append(entry.getValue().toString()).append("\n");
        }
        sb.append(" ----- Turnos: ----- \n");
        for (Turno t : turnosHospital) {
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }

    public void writeToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(this.toString());
        }
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

}
