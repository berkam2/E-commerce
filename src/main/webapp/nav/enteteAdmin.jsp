<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Metwa - Soyez rémunérés en prennant le volant d'un véhicule de Prestige</title>
<link href="./css/bootstrap.min.css">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>

  
<header class="p-3 mb-3 border-bottom">
    <div class="container">
      <div class="row">
        <a href="HOME" class="col-2">
         <img alt=""  width="80" height="64" src="images/voitures/Bugatti/bugattiChiron2016.jpg">
          <br>07-58-79-96-35
         <br> Monday-Friday
           <br>10am-3pm
        </a>

        <div class="col-8 me-lg-auto mb-2 justify-content-center mb-md-0">
         
         <h2>The car of your dream 10 times cheaper</h2>
         <h4>Car up to 10% average capital gain</h4>
        </div>

		<div class="col-2">
                 <c:if test="${joueur!=null }">
        
       <c:out value ="Bonjour ${joueur.nom} ${joueur.prenom }"/>
       <br>
          
        <a href="Logout">Se déconnecter</a>
        </c:if>
        
       
	</div>
        
      </div>
    </div>
  </header>
 
 <div class="container">
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
    <a class="nav-link" href="Auto">Cars</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Onglet">Onglets</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Categorie">Categorie</a>
  </li>
  
  <li class="nav-item">
    <a class="nav-link" href="Blog">Articles</a>
  </li>
  
  <li class="nav-item">
    <a class="nav-link" href="Locations">Locations</a>
  </li>
  
  <li class="nav-item">
    <a class="nav-link" href="Rdvz">Call-Agenda</a>
  </li>
   <li class="nav-item">
    <a class="nav-link" href="Tarif">Tarification</a>
  </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="Utilisateurs" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Utilisateurs
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
           <li class="nav-item">
    <a class="nav-link" href="Utilisateurs">All</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Driver</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Owner</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Renter</a>
  </li>
          </ul>
        </li>
       
		 <li class="nav-item">
    <a class="nav-link" href="Sinistres">Sinistres</a>
  </li>
    
  <li class="nav-item">
    <a class="nav-link" href="Garages">Garage</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="Statuts">Statut</a>
  </li>
   


      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
</div>
 