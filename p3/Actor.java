package practica3;

import java.util.*;
public class Actor implements Comparable<Actor>, java.io.Serializable{
    private String nombre;
    private String personaje;
    private String oscar;
    private String direccion;
    private String[] otraPelicula;
    private String[] otroMML;
    private LinkedList<Film> films;

    public void setFilms(LinkedList<Film> films){
        this.films = films;
    }

    public void setNombre(String nombre){
      this.nombre = nombre;
    }

    public void setPersonaje(String personaje){
      this.personaje = personaje;
    }

    public void setOscar(String oscar){
      this.oscar = oscar;
    }

    public void setDireccion(String direccion){
      this.direccion = direccion;
    }

    public void setOtroMML(String[] otroMML){
      this.otroMML = otroMML;
    }

    public void setOtraPelicula(String[] otraPelicula){
      this.otraPelicula = otraPelicula;
    }

    public LinkedList<Film> getFilms(){
        return this.films;
    }
    public String getNombre() {
        return nombre;
    }

    public String getPersonaje() {
        return personaje;
    }

    public String getOscar() {
        return oscar;
    }

    public String getDireccion() {
        return direccion;
    }

    public String[] getOtraPelicula() {
        return otraPelicula;
    }

    public String[] getOtroMML() {
        return otroMML;
    }

    public Actor(){
    }

    public Actor(String nombre, String personaje, String oscar, String direccion, String[] otraPelicula, String[] otroMML){
        this.nombre = nombre;
        this.personaje = personaje;
        if(oscar!=null){
            this.oscar = oscar;
        }
        this.direccion = direccion;
        this.otraPelicula = otraPelicula;
        this.otroMML = otroMML;
    }

    public Actor(String anombre){
        this.nombre = nombre;
    }

    public int compareTo(Actor a){
        return this.nombre.compareTo(a.getNombre());
    }

}
