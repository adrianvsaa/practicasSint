package practica3;

import java.util.*;

public class Anio implements Comparable<Anio>, java.io.Serializable{
    private String anio;
    private LinkedHashMap<String, Pelicula> peliculas;

    public Anio(){
      peliculas = new LinkedHashMap<String, Pelicula>();
    }

    public Anio(String anio){
        this.anio = anio;
        peliculas = new LinkedHashMap<String, Pelicula>();
    }


    public void setAnio(String anio){
      this.anio = anio;
    }

    public void setPeliculas(LinkedHashMap<String, Pelicula> peliculas){
      this.peliculas = peliculas;
    }


    public String getAnio(){
        return this.anio;
    }

    public void addPelicula(Pelicula p){
        peliculas.put(p.getTitulo(), p);
    }

    public LinkedHashMap<String, Pelicula> getPeliculas(){
        return this.peliculas;
    }

    public int compareTo(Anio a){
        return this.anio.compareTo(a.getAnio());
    }
}
