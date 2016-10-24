<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/TPCineRome/bootstrap-3.3.6-dist/css/bootstrap.min.css"/>
<script src="/TPCineRome/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/TPCineRome/CSS/style.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panier</title>
</head>
<body>
<div class="container">
<header>
<h1>Vos articles séléctionnés</h1>
<h2>Vous avez ${panier.nbObjets} articles avec une valeur totale de ${panier.prixTotalHT} euros</h2>
</header>
<br>
<br>
<div class="row">

<nav class="col-lg-3">

<form class="full-left" action="rechercherLivre.htm" method="post" class="col-lg-3" >
<input type="text" name="recherche" class="form-control" placeholder="Tapez un titre, auteur ou genre" style="width:250px"/>
<input type="submit" name="rechercher" value="Rechercher">
</form>
<br>
<a href=retourprincipal.htm class="btn btn-primary"><span class="glyphicon glyphicon-home"></span> Retour à la page principale</a>
</nav>
<section class="col-lg-9">
<c:forEach var="ligne" items="${livresPanier}">
    <br>
    <li>${ligne.a.designation} - ${ligne.a.auteur} - ${ligne.a.prixHT} - Quantite : ${ligne.qteComm} - <form class="inlineblock pull-right" action="modifierObjet.htm" method="post"> <input type="hidden" value="${ligne.a.reference}" name="reference"/> <label>Quantité : </label><input type="text" name="qtesaisiemodif" style="width:30px"/> - <input class="btn btn-primary btn-success" type="submit" name="commandermodif" value="Actualiser"> <a href=eliminerObjet.htm class="btn btn-warning"><span class="glyphicon glyphicon-remove"></span> Eliminer </a></form></li>
    <br>
</c:forEach>
<br>
<br>
<br>
<br>
<div class="pull-right">
<a href=commande.htm class="pull-right btn btn-primary"><span class="glyphicon glyphicon-ok"></span> Valider le panier</a> <a href=reset.htm class="pull-right btn btn-danger"><span class="glyphicon glyphicon-remove"></span> Reset panier</a>
</div>
<br>
<br>
</section>
</div>
</div>
</body>
</html>