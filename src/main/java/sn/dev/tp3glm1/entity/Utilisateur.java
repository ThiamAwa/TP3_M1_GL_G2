package sn.dev.tp3glm1.entity;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String mdp;



    public Utilisateur() {}

    // Constructeur avec tous les champs
    public Utilisateur(int id, String nom, String prenom, String login, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;

    }

    // Getters et Setters pour chaque attribut
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    // Méthode pour afficher les informations de l'utilisateur (optionnelle)
    @Override
    public String toString() {
        return "Utilisateur{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "', login='" + login + "'}";
    }
}

