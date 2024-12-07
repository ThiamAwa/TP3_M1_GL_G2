package sn.dev.tp3glm1.dao;

import java.sql.*;

public class SingletonConnection {

    private Connection cnx;
    private PreparedStatement pstm;
    private ResultSet rs;
    private int ok;

    public void getConnection()
    {
        String host = "localhost";
        String database = "TP3GLM1";
        int port = 3306;
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useSSL=false&serverTimezone=UTC"; // Update for newer MySQL
        String user = "root";
        String password = "";

        try {
            // Use the correct driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.cnx = DriverManager.getConnection(url, user, password);
            // System.out.println("Connexion réussie");
        } catch (Exception var8) {
            var8.printStackTrace();
        }
    }

    public void initPrepar(String sql) {
        try {
            this.getConnection();
            this.pstm = this.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public ResultSet executeSelect() {
        this.rs = null;
        try {
            this.rs = this.pstm.executeQuery();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
        return this.rs;
    }

    public int executeMaj() {
        try {
            this.ok = this.pstm.executeUpdate();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
        return this.ok;
    }

    public void closeConnection() {
        try {
            if (this.cnx != null) {
                this.cnx.close();
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

    public PreparedStatement getPstm() {
        return this.pstm;
    }
}
