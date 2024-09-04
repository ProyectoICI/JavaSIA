package main.java.com.hospital.repository;

import main.java.com.hospital.model.Hospital;

public class HospitalRepo {
    public void cambioNombre(Hospital hospital, String nombre) {
        hospital.changeName(nombre, hospital);
    }

    public void cambioDireccion(Hospital hospital, String direccion) {
        hospital.changeLocation(direccion, hospital);
    }

    public void cambioNumero(Hospital hospital, int numero) {
        hospital.changeNumber(numero, hospital);
    }
}
