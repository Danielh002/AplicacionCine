package com.example.daniel.aplicacioncine;

/**
 * Created by Daniel on 19/03/2017.
 * Clase que representa la existencia de una Pelicula
 */

public class Pelicula{
    private String nombre;
    private int idDrawable;
    private String genero;
    private String actores;
    private String sinopsis;

    public Pelicula(String nombre, int idDrawable, String genero, String actores, String sinopsis) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
        this.genero = genero;
        this.actores = actores;
        this.sinopsis = sinopsis;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getActores() {
        return actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    /*

    public static Pelicula[] ITEMS = {
            new Pelicula("Buscando a Dory", R.drawable.finding_dory," Animation, Adventure, Comedy" ," Ellen DeGeneres, Albert Brooks, Ed O'Neill" , "LOREM"),
            new Pelicula("Rapidos y furiosos 8", R.drawable.the_fate_of_the_furious, "Action, Crime, Thriller", "Charlize Theron, Dwayne Johnson, Kurt Russell" , "LOREM"),
            new Pelicula("La La Land", R.drawable.lalaland," Comedy, Drama, Music" , "Ryan Gosling, Emma Stone, Rosemarie DeWitt", "LOREM"),
            new Pelicula("Logan", R.drawable.logan ,"Action, Drama, Sci-Fi" ," Hugh Jackman, Patrick Stewart, Dafne Keen" , "LOREM" ),
            new Pelicula("Alien: Convenant", R.drawable.alien_convenant , "Horror, Sci-Fi, Thriller" , "Michael Fassbender, Katherine Waterston, James Franco" ,"LOREM"),
            new Pelicula("MoonLight", R.drawable.moonlight, "Drama", "Mahershala Ali, Shariff Earp, Duan Sanderson" , "LOREM" ),
            new Pelicula("Power Rangers", R.drawable.power_ranger, "Action, Adventure, Sci-Fi","Dacre Montgomery, Naomi Scott, RJ Cyler" , "LOREM"),
            new Pelicula("Kimi Your Name", R.drawable.kimi_your_name, "Animation, Drama, Fantasy", "Ryûnosuke Kamiki, Mone Kamishiraishi, Ryô Narita", "LOREM"),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Pelicula

    public static Pelicula getItem(int id) {
        for (Pelicula item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    public static Pelicula cargarPeliculas(){
        return null;
    }
    */
}

