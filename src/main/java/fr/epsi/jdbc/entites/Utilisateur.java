package fr.epsi.jdbc.entites;

public class Utilisateur {
    private int id;
    private String nom;
    private String identifiant;
    private  String MotDePasse;

    public Utilisateur() {
    }

    public Utilisateur(String identifiant, String MotDePasse) {
        this.identifiant = identifiant;
        this.MotDePasse = MotDePasse;
    }

    public Utilisateur(String nom, String identifiant, String MotDePasse) {
        this.nom = nom;
        this.identifiant = identifiant;
        this.MotDePasse = MotDePasse;
    }

    public Utilisateur(int id, String nom, String identifiant, String MotDePasse) {
        this.id = id;
        this.nom = nom;
        this.identifiant = identifiant;
        this.MotDePasse = MotDePasse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.MotDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", identifiant='" + identifiant + '\'' +
                ", MotDePasse='" + MotDePasse + '\'' +
                '}' +
                "";
    }
}
