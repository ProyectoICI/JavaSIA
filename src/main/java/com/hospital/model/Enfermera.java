package main.java.com.hospital.model;

import java.util.ArrayList;

public class Enfermera {
    private String nombre;
    private String apellido;
    private String prefDepto;
    private String prefTurno;
    private int deptoAsignado;
    private int asistencia;
    private int enfermeraID;
    private boolean ocupado;

    public Enfermera(String nombre, String apellido, String prefDepto, String prefTurno, int enfermeraID, boolean ocupado, int asistencia, int deptoAsignado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.prefDepto = prefDepto;
        this.prefTurno = prefTurno;
        this.deptoAsignado = deptoAsignado;
        this.asistencia = asistencia;
        this.enfermeraID = enfermeraID;
        this.ocupado = ocupado;
    }

    // Getters & Setters

    public int getDeptoAsignado() { return deptoAsignado; }

    public void setDeptoAsignado(int deptoAsignado) { this.deptoAsignado = deptoAsignado; }

    public int getAsistencia() { return asistencia; }

    public void setAsistencia(int asistencia) { this.asistencia = asistencia; }

    public int getEnfermeraID() {
        return enfermeraID;
    }

    public void setEnfermeraID(int enfermeraID) {
        this.enfermeraID = enfermeraID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPrefDepto() {
        return prefDepto;
    }

    public void setPrefDepto(String prefDepto) {
        this.prefDepto = prefDepto;
    }

    public String getPrefTurno() {
        return prefTurno;
    }

    public void setPrefTurno(String prefTurno) {
        this.prefTurno = prefTurno;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
