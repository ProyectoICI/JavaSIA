package main.java.com.hospital.model;

import java.time.LocalDate;


public class Turno {
    private String enfermeraAsignada;
    private String horarioTurno;
    private LocalDate diaTurno;
    private String deptoTurno;

    public Turno(String nombreAsignado, String horarioTurno, String deptoTurno, LocalDate diaTurno) {
        this.enfermeraAsignada = nombreAsignado;
        this.horarioTurno = horarioTurno;
        this.deptoTurno = deptoTurno;
        this.diaTurno = diaTurno;
    }

    public Turno(String horarioTurno, String deptoTurno, LocalDate diaTurno) {
        this.horarioTurno = horarioTurno;
        this.deptoTurno = deptoTurno;
        this.diaTurno = diaTurno;
        this.enfermeraAsignada = "";
    }

    public Turno() {
        this.enfermeraAsignada = "";
        this.horarioTurno = "";
        this.deptoTurno = "";
        this.diaTurno = null;
    }

    public String getEnfermeraAsignada() {
        return enfermeraAsignada;
    }

    public void setEnfermeraAsignada(String enfermeraAsignada) {
        this.enfermeraAsignada = enfermeraAsignada;
    }

    public String getHorarioTurno() {
        return horarioTurno;
    }

    public void setHorarioTurno(String horarioTurno) {
        this.horarioTurno = horarioTurno;
    }

    public String getDeptoTurno() {
        return deptoTurno;
    }

    public void setDeptoTurno(String deptoTurno) {
        this.deptoTurno = deptoTurno;
    }

    public LocalDate getDiaTurno() {
        return diaTurno;
    }

    public void setDiaTurno(LocalDate diaTurno) {
        this.diaTurno = diaTurno;
    }
}
