package sn.dev.tp3glm1.dao;

import sn.dev.tp3glm1.entity.Utilisateur;

import java.util.List;

public interface IUserDao {
    public Utilisateur save(Utilisateur u);

    public List<Utilisateur> list();

    public List<Utilisateur> UTILISATEURSByMc(String mc);

    public Utilisateur utilisateurById(int id);

    public int update(Utilisateur u) ;

    public int delete(Utilisateur u);
    public Utilisateur findByLoginAndPassword(String login, String mdp);
}
