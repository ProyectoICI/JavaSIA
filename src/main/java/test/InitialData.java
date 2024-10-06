package test;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Turno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InitialData {

    public static Map<Integer, Departamento> cargarDeptos() {
        Map<Integer, Departamento> deptosIniciales = new HashMap<>();

        Departamento depto1 = new Departamento("Cardiología", 001, 3);
        Departamento depto2 = new Departamento("Anestesiología", 002, 1);
        Departamento depto3 = new Departamento("Pediatría", 003, 2);
        Departamento depto4 = new Departamento("Cirugía general", 004, 4);
        Departamento depto5 = new Departamento("Cuidados intensivos", 005, 5);
        Departamento depto6 = new Departamento("Laboratorios clínicos", 006, 6);

        deptosIniciales.put(depto1.getDeptoID(), depto1);
        deptosIniciales.put(depto2.getDeptoID(), depto2);
        deptosIniciales.put(depto3.getDeptoID(), depto3);
        deptosIniciales.put(depto4.getDeptoID(), depto4);
        deptosIniciales.put(depto5.getDeptoID(), depto5);
        deptosIniciales.put(depto6.getDeptoID(), depto6);

        return deptosIniciales;
    }

    public static ArrayList<Enfermera> cargarEnfermeras() {
        ArrayList<Enfermera> enfermerasIniciales = new ArrayList<>();

        Enfermera enfermera1 = new Enfermera("Carolina", "Lopez", "Cardiología", "Dia", 1);
        Enfermera enfermera2 = new Enfermera("Patricia", "Gonzalez", "Cardiología", "Mañana", 2);
        Enfermera enfermera3 = new Enfermera("Carmen", "Gutierrez", "Cardiología", "Dia", 3);
        Enfermera enfermera4 = new Enfermera("Marcela", "Díaz", "Anestesiología", "Noche", 4);
        Enfermera enfermera5 = new Enfermera("Sandra", "Soto", "Pediatría", "Dia", 5);

        Enfermera enfermera6 = new Enfermera("Alicia", "Silva", "Pediatría", "Dia", 6);
        Enfermera enfermera7 = new Enfermera("Francisca", "Morales", "Pediatría", "Dia", 7);
        Enfermera enfermera8 = new Enfermera("Claudia", "Flores", "Cirugía general", "Noche", 8);
        Enfermera enfermera9 = new Enfermera("Isabela", "Rojas", "Cirugía general", "Noche", 9);
        Enfermera enfermera10 = new Enfermera("Daniela", "Torres", "Cirugía general", "Noche", 10);

        Enfermera enfermera11 = new Enfermera("Nicole", "Sepúlveda", "Cirugía general", "Mañana", 11);
        Enfermera enfermera12 = new Enfermera("Laura", "Castillo", "Cirugía general", "Dia", 12);
        Enfermera enfermera13 = new Enfermera("Gabriela", "Fuentes", "Cirugía general", "Noche", 13);
        Enfermera enfermera14 = new Enfermera("Sara", "Rodríguez", "Cirugía general", "Dia", 14);
        Enfermera enfermera15 = new Enfermera("Alejandra", "Araya", "Cirugía general", "Dia", 15);

        Enfermera enfermera16 = new Enfermera("Constanza", "Reyes", "Cuidados intensivos", "Dia", 16);
        Enfermera enfermera17 = new Enfermera("Katherine", "Espinoza", "Cuidados intensivos", "Dia", 17);
        Enfermera enfermera18 = new Enfermera("Barbara", "Hernández", "Cuidados intensivos", "Dia", 18);
        Enfermera enfermera19 = new Enfermera("Angela", "Ramírez", "Cuidados intensivos", "Dia", 19);
        Enfermera enfermera20 = new Enfermera("Victoria", "Álvarez", "Cuidados intensivos", "Dia", 20);

        Enfermera enfermera21 = new Enfermera("Javiera", "Vásquez", "Cuidados intensivos", "Dia", 21);
        Enfermera enfermera22 = new Enfermera("Evelyn", "Tapia", "Laboratorios clínicos", "Dia", 22);
        Enfermera enfermera23 = new Enfermera("Soledad", "Sanchez", "Laboratorios clínicos", "Dia", 23);
        Enfermera enfermera24 = new Enfermera("Ivonne", "Fernandez", "Laboratorios clínicos", "Dia", 24);
        Enfermera enfermera25 = new Enfermera("Sofia", "Carrasco", "Laboratorios clínicos", "Dia", 25);

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

    public static Hospital cargarHospital() {
        return new Hospital("Hospital Dr. Gustavo Fricke",
                "057",
                "Álvarez 1532, Viña del Mar, Valparaíso");
    }
}
