package sn.dev.tp3glm1.dao;

import sn.dev.tp3glm1.entity.Utilisateur;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class UtilisateurImplDao implements IUserDao{
    private SingletonConnection  db = new SingletonConnection();
    private ResultSet rs;

    @Override
    public Utilisateur save(Utilisateur u) {
        String sql = "INSERT INTO utilisateur (nom, prenom, login, mdp) VALUES (?, ?, ?, ?)";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, u.getNom());
            db.getPstm().setString(2, u.getPrenom());
            db.getPstm().setString(3, u.getLogin());
            db.getPstm().setString(4, u.getMdp());


            int rowsAffected = db.executeMaj();
            if (rowsAffected > 0) {
                rs = db.getPstm().getGeneratedKeys();
                if (rs.next()) {
                    u.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return u;
    }

    public Utilisateur findByLoginAndPassword(String login, String mdp) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateur WHERE login = ? AND mdp = ?";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, login);
            db.getPstm().setString(2, mdp);
            rs = db.executeSelect();
            if (rs.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setLogin(rs.getString("login"));


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.closeConnection();
        }
        return utilisateur;
    }



    @Override
    public List<Utilisateur> list() {
        return null;
    }

    @Override
    public List<Utilisateur> UTILISATEURSByMc(String mc) {
        return null;
    }

    @Override
    public Utilisateur utilisateurById(int id) {
        return null;
    }

    @Override
    public int update(Utilisateur u) {
        return 0;
    }

    @Override
    public int delete(Utilisateur u) {
        return 0;
    }
}
