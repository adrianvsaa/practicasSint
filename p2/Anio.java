import java.util.*;

public class Anio implements Comparable<Anio>{ 
    private String anio;
    private LinkedHashMap<String, Pelicula> peliculas;

    public Anio(String anio){
        this.anio = anio;
        peliculas = new LinkedHashMap<String, Pelicula>();
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