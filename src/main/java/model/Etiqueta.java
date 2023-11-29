package model;

import java.util.Objects;

public class Etiqueta {

    private String nombre;
    private String color;

    public Etiqueta(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etiqueta etiqueta = (Etiqueta) o;

        return Objects.equals(nombre, etiqueta.nombre);
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
