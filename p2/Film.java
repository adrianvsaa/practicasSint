import java.util.*;
public class Film implements Comparable<Film>{
    private String titulo;
    private String oscar;

    public Film(String titulo){
        this.titulo = titulo;
    }

    public Film(String titulo, String oscar){
        this.titulo = titulo;
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
class ComparadorTituloFilms implements Comparator<Film>{
	public int compare(Film f1, Film f2){
		return f1.getTitulo().compareTo(f2.getTitulo());
	}
}
