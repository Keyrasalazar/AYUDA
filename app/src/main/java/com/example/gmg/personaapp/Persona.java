package com.example.gmg.personaapp;

import java.io.Serializable;

public class Persona implements Serializable {

    private String cedula;
    private String nombre;
    private int edad;
    private float peso;
    private String tipoSangre;

    public Persona(String cedula, String nombre, int edad, float peso, String tipoSangre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.tipoSangre = tipoSangre;
    }

    public Persona() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
}
