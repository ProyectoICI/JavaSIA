package main.java.com.hospital.controller;

import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;
import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.service.NurseService;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class NurseController {
    private NurseService nurseService;

    public NurseController(boolean loadData, Hospital hospital) {
        this.nurseService = new NurseService();
        if (loadData) {
            nurseService.loadInitialData(hospital);
        }
    }
    
    public static void addEnfermera(Hospital hospital) throws IOException {
        Enfermera enfermera = new Enfermera();

        String[] horarios = {"Mañana", "Dia", "Noche"};
        String nombre;
        String apellido;
        String preferenciaDepto = null;
        String preferenciaHorario = null;

        int codigoEnfermera = -1;

        Map<Integer, Departamento> departamentosHospital = hospital.getDepartments();
        ArrayList<Enfermera> enfermerasHospital = hospital.getNurses();
        Scanner scanner  = new Scanner(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre de la enfermera");
        nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido de la enfermera");
        apellido = scanner.nextLine();
        System.out.println("Ingrese su preferencia de departamento");
        while (preferenciaDepto == null) {
            int hit = 0;
            String texto = scanner.nextLine();
            for (Map.Entry<Integer, Departamento> entry : departamentosHospital.entrySet()) {
                Departamento deptoIndice = entry.getValue();
                if (deptoIndice.getNombreDepto().equals(texto)) {
                    hit++;
                    preferenciaDepto = texto;
                    break;
                }
            }
            if (hit == 0) {
                System.out.println("Departamento no encontrado, pruebe denuevo.");
            }

        }
        System.out.println("Ingrese su preferencia de horario");
        while (preferenciaHorario == null) {
            int hit = 0;
            String fecha = scanner.nextLine();
            for (String horario : horarios) {
                if (horario.equals(fecha)) {
                    hit++;
                    preferenciaHorario = fecha;
                    break;
                }
            }
            if (hit == 0) {
                System.out.println("Horario invalido, pruebe denuevo.");
            }
        }
        System.out.println("Ingrese el código de la enfermera");

        while (codigoEnfermera == -1) {
            int codigo = scanner.nextInt();
            int cont = 0;
            for (Enfermera indiceEnfermera : enfermerasHospital) {
                if (indiceEnfermera.getEnfermeraID() == codigo) {
                    cont++;
                    System.out.println("Código en uso, intente otro.");
                }
            }
            if (cont == 0) {
                codigoEnfermera = codigo;
            }

        }

        enfermera.setNombre(nombre);
        enfermera.setApellido(apellido);
        enfermera.setPrefDepto(preferenciaDepto);
        enfermera.setPrefTurno(preferenciaHorario);
        enfermera.setEnfermeraID(codigoEnfermera);

        NurseService.agregarEnfermera(hospital, enfermera);

    }
    public static void removeEnfermera(Hospital hospital) throws IOException {
        Scanner scanner  = new Scanner(new InputStreamReader(System.in));
        ArrayList<Enfermera> enfermerasHospital = hospital.getNurses();

        System.out.println("Ingrese el código de la enfermera a eliminar");
        int codigo = scanner.nextInt();

        for (Enfermera enfermera : enfermerasHospital) {
            if (enfermera.getEnfermeraID() == codigo) {
                NurseService.eliminarEnfermera(hospital, enfermera);
                System.out.println("Enfermera eliminada.");
                break;
            }
        }
        System.out.println("No se ha encontrado una enfermera con ese código.");
    }

    public static void showEnfermeras(Hospital hospital) throws IOException {
        ArrayList<Enfermera> enfermerasHospital = hospital.getNurses();
        for (Enfermera enfermera : enfermerasHospital) {
            System.out.println("--------------");
            System.out.println("Nombre: " + enfermera.getNombre());
            System.out.println("Apellido: " + enfermera.getApellido());
            System.out.println("Pref. Depto: " + enfermera.getPrefDepto());
            System.out.println("Pref. Horario: " + enfermera.getPrefTurno());
            System.out.println("Código: " + enfermera.getEnfermeraID());
        }
        System.out.println("--------------");
    }

    public static void showEnfermeras() {
        System.out.println("No se encontraron enfermeras.");
    }
}
