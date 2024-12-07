package sn.dev.tp3glm1.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.dev.tp3glm1.dao.IUserDao;
import sn.dev.tp3glm1.dao.UtilisateurImplDao;
import sn.dev.tp3glm1.entity.Utilisateur;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns={"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    private IUserDao metier = new UtilisateurImplDao();

    public void init(ServletConfig config) throws ServletException {
        metier=new UtilisateurImplDao();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirection vers la page d'inscription
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        recupererlesdonnes
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");


        if (nom == null || prenom == null || login == null || mdp == null ||
                nom.isEmpty() || prenom.isEmpty() || login.isEmpty() || mdp.isEmpty()) {
            request.setAttribute("error", "Tous les champs sont obligatoires.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
//        creerunobjet
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setLogin(login);
        utilisateur.setMdp(mdp);


        // Enregistrer l'utilisateur

        metier.save(utilisateur);
        request.setAttribute("utilisateur", "Utilisateur ajouté avec succès !");



        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}

