package sn.dev.tp3glm1.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sn.dev.tp3glm1.dao.UtilisateurImplDao;
import sn.dev.tp3glm1.entity.Utilisateur;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UtilisateurImplDao utilisateurDao = new UtilisateurImplDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");


        Utilisateur utilisateur = utilisateurDao.findByLoginAndPassword(login, mdp);

        if (utilisateur != null) {
            // Connexion réussie : créer une session
            HttpSession session = request.getSession();
            session.setAttribute("utilisateur", utilisateur);

            // Rediriger vers une page d'accueil
            response.sendRedirect("accueil.jsp");
        } else {
            // Connexion échouée : message d'erreur
            request.setAttribute("errorMessage", "Login ou mot de passe incorrect !");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
