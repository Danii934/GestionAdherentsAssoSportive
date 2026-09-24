<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="pojo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Devoir PWA 2024-2025 Affichage Groupe</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%List<Personne> pers = (List) request.getAttribute("users");
  Groupe g = (Groupe) request.getAttribute("group");%> 
<h1 class="text-center">Groupe : <%= g.getNomGroupe()%></h1>

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
      <th scope="col"> </th>
      
      
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
      <td><a class="btn btn-danger" href="SupprimerMembre?id=<%=p.getPersonID()%>&groupID=<%=g.getIdGroupe()%>">Supprimer</a></td>
    </tr>
    <%} %>
  </tbody>
</table>
<div class="d-flex flex-row mx-auto" style="justify-content: space-between; width:500px;">
  <a class="btn btn-success" href="AjouterMembre?id=<%=g.getIdGroupe()%>">Ajouter un nouveau membre</a>
  <a class="btn btn-danger" href="AfficherGroupes">Retour à la liste des groupes</a>
</div>

</body>
</html>