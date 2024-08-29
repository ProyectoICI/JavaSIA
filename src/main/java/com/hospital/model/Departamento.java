package main.java.com.hospital.model;

import java.util.ArrayList;

public class Departamento {
    private String nombreDepto;
    private int deptoID;
    private int necesidadEnfermeras;
    private ArrayList<Enfermera> enfermerasDepto;
    private ArrayList<Turno> turnosDepto;

    public Departamento(String nombreDepto, int deptoID) {
        this.nombreDepto = nombreDepto;
        this.deptoID = deptoID;
        enfermerasDepto = new ArrayList<>();
        turnosDepto = new ArrayList<>();
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
