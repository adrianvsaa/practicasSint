package practica3;

import java.util.*;

public class Pelicula implements Comparable<Pelicula>, java.io.Serializable{
    private String pais;
    private String paisLang;
    private String[] langs;
    private String ip;
    private String titulo;
    private String[] generos;
    private String duracion;
    private LinkedHashMap<String, Actor> reparto;

    public Pelicula(){
      reparto = new LinkedHashMap<String,Actor>();
    }

    public Pelicula(String pais, String paisLang, String langs, String ip, String titulo, String[] generos, String duracion){
        this.pais = pais;
        this.paisLang = paisLang;
        this.langs = new String[langs.split(" ").length];
        for(int i=0; i<langs.split(" ").length; i++)
            this.langs[i] = langs.split(" ")[i];
        this.ip = ip;
        this.titulo = titulo;
        this.generos = new String[generos.length];
        for(int i=0; i<generos.length; i++){
            this.generos[i] = generos[i];
        }
        this.duracion = duracion;
        reparto = new LinkedHashMap<String, Actor>();
    }

    public void setPais(String pais){
      this.pais = pais;
    }

    public void setPaisLang(String paisLang){
      this.paisLang = paisLang;
    }

    public void setLangs(String[] langs){
      this.langs = langs;
    }

    public void setIp(String ip){
      this.ip = ip;
    }

    public void setTitulo(String titulo){
      this.titulo = titulo;
    }

    public void setGeneros(String[] generos){
      this.generos = generos;
    }

    public void setDuracion(String duracion){
      this.duracion = duracion;
    }

    public void setReparto(LinkedHashMap<String, Actor> reparto){
      this.reparto = reparto;
    }

    public void addActor(Actor actor){
        reparto.put(actor.getNombre(), actor);
    }

    public String getPais() {
        return pais;
    }

    public String getPaisLang() {
        return paisLang;
    }

    public String getLangs() {
        String langs = "";
        for(int i=0; i<this.langs.length; i++){
            langs += this.langs[i];
            if((i+1)<this.langs.length)
                langs+=" ";
        }
        return langs;
    }

    public String getIp() {
        return ip;
    }

    public String getTitulo() {
        return titulo;
    }

    public String[] getGeneros() {
        return generos;
    }

    public String getDuracion() {
        return duracion;
    }

    public LinkedHashMap<String, Actor> getReparto() {
        return reparto;
    }

    public int compareTo(Pelicula p){
        if(Integer.parseInt(this.getDuracion())>Integer.parseInt(p.getDuracion()))
            return  1;
        else if(Integer.parseInt(this.duracion)==Integer.parseInt(p.getDuracion())){
            return 0;
        }
        else{
            return -1;
        }
    }

}

class ComparadorTitulo implements Comparator<Pelicula>{
    public int compare(Pelicula p1, Pelicula p2){
        return -(p1.getTitulo().compareTo(p2.getTitulo()));
    }
}
