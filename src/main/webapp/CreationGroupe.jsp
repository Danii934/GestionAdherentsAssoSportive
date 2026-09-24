<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="pojo.Personne" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<h1>Création d'un groupe</h1>
<%List<Personne> pers = (List) request.getAttribute("users");%> 
<div class="container d-flex justify-content-center">
<form action="CreationGroupe" method="post">

  <div class="form-group">
    <label for="nomGroupe">Nom du Groupe:</label>
    <input type="text" class="form-control" id="nomGroupe" name="nomgroupe">
  </div>
  
  <div class="form-group">
 <table class="table table-bordered table-striped">
  <thead class="table-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">Date de Naissance</th>
      <th scope="col">Adresse Postale</th>
      <th scope="col">Code Postal</th>
      <th scope="col">Ville</th>
      <th scope="col">Adresse Couriel</th>
      <th scope="col">Numéro</th>
      <th scope="col">Date de cotisation</th>
      <th scope="col">Ajouter</th>
      
      
    </tr>
  </thead>
  <tbody>
   <% for(Personne p: pers){ %>
    <tr>
      <th scope="row"><%=p.getPersonID()%></th>
      <td><%=p.getNom()%></td>
      <td><%=p.getPrenom()%></td>
      <td><%=p.getDdn()%></td>
      <td><%=p.getAdressePostale()%></td>
      <td><%=p.getCodePostal()%></td>
      <td><%=p.getVille()%></td>
      <td><%=p.getAdresseCouriel() %></td>
      <td><%=p.getNumTel()%></td>
      <td><%=p.getDateCotisation()%></td>
      <td><input class="form-check-input" type="checkbox" name="selected" value="<%=p.getPersonID()%>"></td>
    </tr>
    <%} %>
  </tbody>
</table>
  </div>
  
<div class="d-flex flex-row mx-auto" style="justify-content: space-between; width:500px;">
  <button type="submit" class="btn btn-primary">Soumettre</button>
  <a class="btn btn-danger" href="AfficherGroupes">Retour à la liste des groupes</a>
</div>
  
</form>
</div>

</body>
</html>