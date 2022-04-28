package com.example.ciclodevida3.Datos;

public class Datos {
    String nombre;
    int edad;

    public Datos(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Datos() {
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
}
