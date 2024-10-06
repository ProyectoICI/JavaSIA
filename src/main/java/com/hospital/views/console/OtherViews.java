package main.java.com.hospital.views.console;

import main.java.com.hospital.model.Hospital;

import java.io.BufferedReader;
import java.io.IOException;

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

    }

}
