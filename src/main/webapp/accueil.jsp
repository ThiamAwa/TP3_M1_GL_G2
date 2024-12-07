<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/12/2024
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page d'accueil</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            max-width: 500px;
            width: 100%;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        p {
            font-size: 16px;
            margin: 10px 0;
        }

        button {
            padding: 10px 15px;
            background-color: #ff4d4d;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #cc0000;
        }
    </style>
</head>
<body>
<div class="container">

    <c:if test="${not empty utilisateur}">
        <h2>Bienvenue ${utilisateur.nom}</h2>
        <p><strong>Prenom : </strong>${utilisateur.prenom}</p>
        <p><strong>Email : </strong>${utilisateur.login}</p>
    </c:if>

    <%-- Bouton de déconnexion --%>
    <form action="LogoutServlet" method="POST">
        <button type="submit">Se déconnecter</button>
    </form>
</div>
</body>
</html>

