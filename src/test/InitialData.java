package test;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;

import java.time.LocalDate;
import java.util.ArrayList;

public class InitialData {
    // TODO: Agregar datos iniciales inicializando y poblando un ArrayList de departamentos y retornandolo
    // TODO:
    public static ArrayList<Departamento> cargarDeptos() {
        ArrayList<Departamento> deptosIniciales = new ArrayList<>();

        Departamento depto1 = new Departamento("Cardiología", 001, 3);
        Departamento depto2 = new Departamento("Anestesiología", 002, 1);
        Departamento depto3 = new Departamento("Pediatría", 003, 2);
        Departamento depto4 = new Departamento("Cirugía general", 004, 4);
        Departamento depto5 = new Departamento("Cuidados intensivos", 005, 5);
        Departamento depto6 = new Departamento("Laboratorios clínicos", 006, 6);

        deptosIniciales.add(depto1);
        deptosIniciales.add(depto2);
        deptosIniciales.add(depto3);
        deptosIniciales.add(depto4);
        deptosIniciales.add(depto5);
        deptosIniciales.add(depto6);

        return deptosIniciales;
    }
    // TODO: Agregar datos iniciales inicializando y poblando un ArrayList de enfermeras y retornandolo
    // TODO: Alrededor de 25 enfermeras distintas
    public static ArrayList<Enfermera> cargarEnfermeras() {
        ArrayList<Enfermera> enfermerasIniciales = new ArrayList<>();

        Enfermera enfermera1 = new Enfermera("Carolina", "Lopez", "Cardiología", "Dia", 001);
        Enfermera enfermera2 = new Enfermera("Patricia", "Gonzalez", "Cardiología", "Mañana", 002);
        Enfermera enfermera3 = new Enfermera("Carmen", "Gutierrez", "Cardiología", "Dia", 003);
        Enfermera enfermera4 = new Enfermera("Marcela", "Díaz", "Anestesiología", "Noche", 004);
        Enfermera enfermera5 = new Enfermera("Sandra", "Soto", "Pediatría", "Dia", 005);

        Enfermera enfermera6 = new Enfermera("Alicia", "Silva", "Pediatría", "Dia", 006);
        Enfermera enfermera7 = new Enfermera("Francisca", "Morales", "Pediatría", "Dia", 007);
        Enfermera enfermera8 = new Enfermera("Claudia", "Flores", "Cirugía general", "Noche", 8);
        Enfermera enfermera9 = new Enfermera("Isabela", "Rojas", "Cirugía general", "Noche", 9);
        Enfermera enfermera10 = new Enfermera("Daniela", "Torres", "Cirugía general", "Noche", 010);

        Enfermera enfermera11 = new Enfermera("Nicole", "Sepúlveda", "Cirugía general", "Mañana", 011);
        Enfermera enfermera12 = new Enfermera("Laura", "Castillo", "Cirugía general", "Dia", 012);
        Enfermera enfermera13 = new Enfermera("Gabriela", "Fuentes", "Cirugía general", "Noche", 013);
        Enfermera enfermera14 = new Enfermera("Sara", "Rodríguez", "Cirugía general", "Dia", 014);
        Enfermera enfermera15 = new Enfermera("Alejandra", "Araya", "Cirugía general", "Dia", 015);

        Enfermera enfermera16 = new Enfermera("Constanza", "Reyes", "Cuidados intensivos", "Dia", 016);
        Enfermera enfermera17 = new Enfermera("Katherine", "Espinoza", "Cuidados intensivos", "Dia", 017);
        Enfermera enfermera18 = new Enfermera("Barbara", "Hernández", "Cuidados intensivos", "Dia", 18);
        Enfermera enfermera19 = new Enfermera("Angela", "Ramírez", "Cuidados intensivos", "Dia", 19);
        Enfermera enfermera20 = new Enfermera("Victoria", "Álvarez", "Cuidados intensivos", "Dia", 020);

        Enfermera enfermera21 = new Enfermera("Javiera", "Vásquez", "Cuidados intensivos", "Dia", 021);
        Enfermera enfermera22 = new Enfermera("Evelyn", "Tapia", "Laboratorios clínicos", "Dia", 022);
        Enfermera enfermera23 = new Enfermera("Soledad", "Sanchez", "Laboratorios clínicos", "Dia", 023);
        Enfermera enfermera24 = new Enfermera("Ivonne", "Fernandez", "Laboratorios clínicos", "Dia", 024);
        Enfermera enfermera25 = new Enfermera("Sofia", "Carrasco", "Laboratorios clínicos", "Dia", 026);

        enfermerasIniciales.add(enfermera1);
        enfermerasIniciales.add(enfermera2);
        enfermerasIniciales.add(enfermera3);
        enfermerasIniciales.add(enfermera4);
        enfermerasIniciales.add(enfermera5);

        enfermerasIniciales.add(enfermera6);
        enfermerasIniciales.add(enfermera7);
        enfermerasIniciales.add(enfermera8);
        enfermerasIniciales.add(enfermera9);
        enfermerasIniciales.add(enfermera10);

        enfermerasIniciales.add(enfermera11);
        enfermerasIniciales.add(enfermera12);
        enfermerasIniciales.add(enfermera13);
        enfermerasIniciales.add(enfermera14);
        enfermerasIniciales.add(enfermera15);

        enfermerasIniciales.add(enfermera16);
        enfermerasIniciales.add(enfermera17);
        enfermerasIniciales.add(enfermera18);
        enfermerasIniciales.add(enfermera19);
        enfermerasIniciales.add(enfermera20);

        enfermerasIniciales.add(enfermera21);
        enfermerasIniciales.add(enfermera22);
        enfermerasIniciales.add(enfermera23);
        enfermerasIniciales.add(enfermera24);
        enfermerasIniciales.add(enfermera25);

        return enfermerasIniciales;
    }
    // TODO: Agregar datos iniciales inicializando y poblando un ArrayList de turnos y retornandolo
    // TODO: Aquí implementar los turnos aleatorios de ser verdadero en la clase Main.
    public static ArrayList<Turno> cargarTurnos() {
        ArrayList<Turno> turnosIniciales = new ArrayList<>();
        LocalDate localDateParse;

        localDateParse = LocalDate.parse("2024-05-20");
        Turno turno1 = new Turno("Dia", "Cardiología", localDateParse);
        localDateParse = LocalDate.parse("2024-07-20");
        Turno turno2 = new Turno("Dia", "Anestesiologia", localDateParse);
        localDateParse = LocalDate.parse("2024-06-20");
        Turno turno3 = new Turno("Noche", "Cirugia General", localDateParse);

        turnosIniciales.add(turno1);
        turnosIniciales.add(turno2);
        turnosIniciales.add(turno3);

        return turnosIniciales;

    }
    // TODO: Agregar datos iniciales inicializando y poblando los atributos de un hospital y retornandolo
    public static Hospital cargarHospital() {
        return new Hospital("Hospital Dr. Gustavo Fricke",
                "057",
                "Álvarez 1532, Viña del Mar, Valparaíso");
    }
}
