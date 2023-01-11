package fr.epsi.jdbc.entites;

public class Fournisseur {

    private int id;
    private String name;


    {
        System.out.println("On crée un nouvel objet");
    }

    static {
        System.out.println("Chargement...");
    }

    public Fournisseur() {
        this(-1, "");
    }

    public Fournisseur(String name) {
        this(-1, name);
    }

    public Fournisseur(int id, String nom) {
        this.id = id;
        this.name = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}' +
                "";
    }

}
