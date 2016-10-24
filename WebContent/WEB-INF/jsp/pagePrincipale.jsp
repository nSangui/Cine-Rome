<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/TPCineRome/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>
<script src="/TPCineRome/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/TPCineRome/CSS/style.css" type="text/css"/>
<title>Page Principale CineRome</title>
</head>

<body>

<div class="container">

<header>
<aside class=pull-right>
<c:if test="${user==null}">
<form action="connexionClient.htm" method="post">
<input class="inlineblock" type="text" name="identifiant" placeholder="Nom d'utilisateur">
<input class="inlineblock" type="password" name="password" placeholder="Password">
<input class="inlineblock" type="submit" id="connexion" value="Connexion">	
</form>
${erreur}
<br>
<a href=afficherCreerClient.htm class=pull-right><button>Créer un compte</button></a>
</c:if>
<c:if test="${user!=null}">
<a href=deconnexionClient.htm><button>Déconnexion</button></a>
</c:if>
<br>
<br>
</aside>
<br>
<br>
<br>
<br>
<br>
<a href=allerpanier.htm class="btn btn-danger pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Voir panier (${panier.nbObjets})</a>
</header>
<br>
<br>
<div class="row">
<nav>
<form action="rechercherLivre.htm" method="post" class="col-lg-3" >
<input type="text" name="recherche" class="form-control" placeholder="Tapez un titre, auteur ou genre" style="width:250px"/>
<input type="submit" name="rechercher" value="Rechercher">
</form>
</nav>
<section class="col-lg-9">
<c:forEach var="liv" items="${livresModel}">
    <br>
    <li>${liv.designation} - ${liv.auteur} - ${liv.genre} - ${liv.prixHT} € <form action="ajouterObjet.htm" method="post" class="pull-right"><label>Quantité : </label><input type="hidden" value="${liv.reference}" name="reference"/><input type="text" name="qtesaisie" style="width:30px"/> - <input type="submit" name="commander" class="btn btn-primary btn-success" value="Ajouter au panier"></form></li>
    <br>
</c:forEach>
</section>
</div>
</div>
</body>
</html>