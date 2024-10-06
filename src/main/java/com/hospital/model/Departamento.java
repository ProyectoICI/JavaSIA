package main.java.com.hospital.model;

import java.util.ArrayList;

public class Departamento {
    private String nombreDepto;
    private int deptoID;
    private int necesidadEnfermeras;
    private ArrayList<Enfermera> enfermerasDepto;
    private ArrayList<Turno> turnosDepto;

    public Departamento(String nombreDepto, int deptoID, int necesidadEnfermeras) {
        this.nombreDepto = nombreDepto;
        this.deptoID = deptoID;
        this.necesidadEnfermeras = necesidadEnfermeras;
        enfermerasDepto = new ArrayList<>();
        turnosDepto = new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Departamento: ").append(nombreDepto).append(", ID: ").append(deptoID).append(", NecesidadEnfermeras: ").append(necesidadEnfermeras).append("\n");
        sb.append("Enfermeras: \n");
        for (Enfermera e : enfermerasDepto) {
            sb.append(e.toString()).append("\n");
        }
        sb.append("Turnos: \n");
        for (Turno t : turnosDepto) {
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }

    public int getNecesidadEnfermeras() {
        return necesidadEnfermeras;
    }

    public void setNecesidadEnfermeras(int necesidadEnfermeras) {
        this.necesidadEnfermeras = necesidadEnfermeras;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public int getDeptoID() {
        return deptoID;
    }

    public void setDeptoID(int deptoID) {
        this.deptoID = deptoID;
    }

}
