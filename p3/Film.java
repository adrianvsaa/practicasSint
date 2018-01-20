package practica3;

import java.util.*;
public class Film implements Comparable<Film>, java.io.Serializable{
    private String titulo;
    private String oscar;

    public Film(){

    }

    public Film(String titulo){
        this.titulo = titulo;
    }

    public Film(String titulo, String oscar){
        this.titulo = titulo;
        this.oscar = oscar;
    }

    public void setTitulo(String titulo){
      this.titulo = titulo;
    }

    public void setOscar(String oscar){
      this.oscar = oscar;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getOscar(){
        return this.oscar;
    }
    private static Comparator<String> nullSafeStringComparator = Comparator.nullsFirst(String::compareToIgnoreCase);
    public int compareTo(Film f){
        return nullSafeStringComparator.compare(this.getOscar(), f.getOscar());
    }
}
