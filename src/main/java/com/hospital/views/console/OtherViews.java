package main.java.com.hospital.views.console;

import main.java.com.hospital.model.Hospital;
import main.java.com.hospital.model.Departamento;
import main.java.com.hospital.model.Enfermera;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class OtherViews {

    public static void reporteAsistencia(BufferedReader scanner, Hospital hospital) throws IOException {

    }

    public static void reporteModelos(BufferedReader scanner, Hospital hospital) throws IOException {
        try {
            hospital.writeToFile("hospital_data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void horariosVisual(BufferedReader scanner, Hospital hospital) throws IOException {

    }

    public static void asistenciaCritica(BufferedReader scanner, Hospital hospital) throws IOException {
        System.out.println("Escriba el número (ID) del depto a verificar");
        int id = Integer.parseInt(scanner.readLine());

        // Ahora checkeamos la lista  de enfermeras asociada al depto
        Departamento deptoEncontrado = hospital.getDepartment(id);
        ArrayList<Enfermera> arrayEnfermeras = deptoEncontrado.getEnfermerasDepto();

        for (Enfermera enfermera : arrayEnfermeras) {
            if (enfermera.getAsistencia() < 70) {
                System.out.println("Enfermera " + enfermera.getEnfermeraID() + " tiene asistencia de un " + enfermera.getAsistencia());
            }
        }

    }

}
