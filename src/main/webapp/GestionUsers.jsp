<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="pojo.Personne" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Devoir PWA 2024-2025 Affichage Utilisateurs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">Liste des utilisateurs/adhérents</h1>
<%List<Personne> pers = (List) request.getAttribute("users");%> 
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
      <th scope="col">Groupe</th>
      <th scope="col"> </th>
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
      <td><%=p.getGroupe() == null ? "Non" : "Oui"%></td>
      <td><a class="btn btn-danger" href="Supprime?id=<%=p.getPersonID()%>">Supprimer</a></td>
      <td><a class="btn btn-primary" href="Modifie?id=<%=p.getPersonID()%>">Modifier</a></td>
    </tr>
    <%} %>
  </tbody>
</table>

<div class="d-flex flex-row mx-auto" style="justify-content: space-between; width:500px;">
  <a class="btn btn-success" href="Test.jsp">Ajouter un nouvel adhérent</a>
  <a class="btn btn-success" href="AfficherGroupes">Voir les groupes</a>
</div>

</body>
</html>