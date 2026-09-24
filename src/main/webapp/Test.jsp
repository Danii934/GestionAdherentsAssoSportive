<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Devoir PWA 2024-2025</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">Formulaire D'inscription</h1>
<div class="container d-flex justify-content-center">
<form action="TestServlet" method="post">

  <div class="form-group">
    <label for="nom">Nom:</label>
    <input type="text" class="form-control" id="nom" name="nom">
    <label for="prenom">Prenom:</label>
    <input type="text" class="form-control" id="prenom" name="prenom">
     <label for="ddn">Date de naissance:</label>
     <input type="date" class="form-control" id="ddn" name="ddn">
  </div>
  
  <div class="form-group">
    <label for="adresse">Adresse:</label>
    <input type="text" class="form-control" id="adresse" name="adresse">
    <label for="cp">Code Postal</label>
    <input type="text" class="form-control" id="cp" name="cp" placeholder="12345">
     <label for="ville">Ville</label>
     <input type="text" class="form-control" id="ville" name="ville">
  </div>
  
  <div class="form-group">
    <label for="mail">Adresse courriel:</label>
    <input type="email" class="form-control" id="mail" name="mail">
    <label for="tel">Numéro de Téléphone</label>
    <input type="text" class="form-control" id="tel" name="tel" placeholder="0123456789">
    <label for="date_cotisation">Date Cotisation</label>
    <input type="date" class="form-control" id="date_cotisation" name="date_cotisation" >
  </div>
  
  <button type="submit" class="btn btn-primary">Soumettre</button>
</form>
</div>
 <script>
	document.getElementById("date_cotisation").valueAsDate = new Date();
</script> 
</body>
</html>