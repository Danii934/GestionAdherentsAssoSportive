<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="pojo.Groupe" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Devoir PWA 2024-2025 Affichage Utilisateurs</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">Liste des utilisateurs/adhérents</h1>
<%List<Groupe> groups = (List) request.getAttribute("groups");%> 
<table class="table table-bordered table-striped">
  <thead class="table-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nom</th>
      <th scope="col">Nombre de membres</th>
      <th scope="col"> </th>
      <th scope="col"> </th>
      
      
      
    </tr>
  </thead>
  <tbody>
   <% for(Groupe g: groups){ %>
    <tr>
      <th scope="row"><%=g.getIdGroupe()%></th>
      <td><%=g.getNomGroupe()%></td>
      <td><%=g.getNbMembres()%></td>
      <td><a class="btn btn-danger" href="SupprimeGroupe?id=<%=g.getIdGroupe()%>">Supprimer</a></td>
      <td><a class="btn btn-info" href="AfficheGroupe?id=<%=g.getIdGroupe()%>">Afficher</a></td>
    </tr>
    <%} %>
  </tbody>
</table>

<div class="d-flex flex-row mx-auto" style="justify-content: space-between; width:500px;">
    <a class="btn btn-success" href="CreationGroupe">Ajouter un nouveau Groupe</a>
  <a class="btn btn-danger" href="AfficheUsers">Retour à la liste des adhérents</a>
</div>

</body>
</html>