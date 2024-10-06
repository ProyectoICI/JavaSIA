package main.java.com.hospital.model;

public class Enfermera {
    private String nombre;
    private String apellido;
    private String prefDepto;
    private String prefTurno;
    private int enfermeraID;

    private String deptoAsignado;
    private int asistencia;
    private boolean ocupado;

    public Enfermera(String nombre, String apellido, String prefDepto, String prefTurno, int enfermeraID) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.enfermeraID = enfermeraID;
        this.prefDepto = prefDepto;
        this.prefTurno = prefTurno;

        this.asistencia = 100;
        this.deptoAsignado = "Ninguno";
        this.ocupado = false;
    }

    public Enfermera() {
        this.nombre = "";
        this.apellido = "";
        this.enfermeraID = 0;
        this.prefDepto = "";
        this.prefTurno = "";
        this.asistencia = 100;
        this.deptoAsignado = "Ninguno";
        this.ocupado = false;
    }

    public String toString() {
        return "Enfermera: " + nombre + " " + apellido + ", ID: " + enfermeraID + ", PrefDepto: " + prefDepto + ", PrefTurno: " + prefTurno + ", DeptoAsignado: " + deptoAsignado + ", Asistencia: " + asistencia + ", Ocupado: " + ocupado;
    }

    // Getters & Setters

    public String getDeptoAsignado() { return deptoAsignado; }

    public void setDeptoAsignado(String deptoAsignado) { this.deptoAsignado = deptoAsignado; }

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
