package main.java.com.hospital.model;

public class Turno {
    private String enfermeraAsignada;
    private String horarioTurno;
    private String deptoTurno;

    public Turno(String nombreAsignado, String horarioTurno, String deptoTurno) {
        this.enfermeraAsignada = nombreAsignado;
        this.horarioTurno = horarioTurno;
        this.deptoTurno = deptoTurno;
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
}
