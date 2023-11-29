package model;

public class Tarea {

    private String titulo;
    private boolean completada;

    public Tarea(String titulo){
        this.titulo = titulo;
        this.completada = false;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public boolean getCompletada(){
        return this.completada;
    }

    public void setCompletada(boolean completada){
        this.completada = completada;
    }

    @Override
    public String toString(){
        return this.titulo + " - " + this.completada;
    }

}
