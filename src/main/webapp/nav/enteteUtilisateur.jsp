  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Metwa - Soyez rémunérés en prennant le volant d'un véhicule de Prestige</title>
<link href="./css/bootstrap.min.css">
<link href="./css/signup.css">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>

<body>
  
  
<header class="p-3 mb-3 border-bottom">
    <div class="container">
      <div class="row">
        <a href="HOME" class="col-2">
         <img alt=""  width="80" height="64" src="images/voitures/Bugatti/bugattiChiron2016.jpg">
          	
          <br>Monday-Friday
           <br>10am-3pm
        </a>

        <div class="col-7 me-lg-auto mb-2 justify-content-center mb-md-0">
         
         <h2>The car of your dream 10 times cheaper</h2>
         <h4>Car up to 10% average capital gain </h4>
         Appelez nous au <a href="">07-58-79-96-35</a> 
        </div>
        
        <div class="col-1">
        <c:if test="${joueur!=null }">
         <a href="Espace?idUser=<c:out value="${joueur.idUser }"/>" >
            <img src="https://github.com/mdo.png" alt="mdo" width="32" height="32" class="rounded-circle">
          </a>	
          </c:if>
        </div>
		<div class= "col-2">
						
		
        <br>
        <c:if test="${joueur==null}">
        <ul class="nav">
        	<li class="nav-item"><a href="Login" class="nav-link link-dark px-3"> Login </a></li>
        	<li class="nav-item"><a href="SignUp" class="nav-link link-dark px-3"> SignUp </a></li>
        </ul>
        </c:if>
        
        <c:if test="${joueur!=null }">
         
       <c:out value ="Bienvenue ${joueur.nom} ${joueur.prenom }"/>
       <c:if test="${pro==true}">
       <a href="Auto"> ADMIN</a>
       </c:if>
         
<br><a href="Logout">Se déconnecter</a>
        </c:if>
        </div>	
      </div>
    </div>
    
  </header>
  <nav class="py-2 bg-ligt border-bottom">
  <div class="container d-flex flex-wrap">
  <c:if test="${empty onglets}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  <c:forEach items="${onglets}" var="onglet">
  <ul class="nav me-auto">
  <li class= "nav-item"><a href="${onglet.libelle}"><c:out value="${onglet.libelle}"/></a></li>
  </ul>
  </c:forEach> 
  <ul class="nav me-auto">
  <li class= "nav-item"><c:out value="${cars} Véhicules disponnibles"/></li>
  </ul>
  </div>
  </nav>
  
  <div class="container">

<div id="carouselExampleCaptions " class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="container">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="voitures/${carsPromo.image}" class="img-fluid rounded-start" alt="...">
      <div class="carousel-caption d-none d-md-block">
        <h5>${carsPromo.marque} ${carsPromo.modele }</h5>
        <p><c:out value="${carsPromo.price} $"/></p>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="voitures/${carsPromo1.image}" class="img-fluid rounded-start">
      <div class="carousel-caption d-none d-md-block">
        <h5>${carsPromo1.marque} ${carsPromo1.modele }</h5>
        <p><c:out value="${carsPromo1.price} $"/></p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="voitures/${carsPromo2.image}" class="img-fluid rounded-start">
      <div class="carousel-caption d-none d-md-block">
        <h5>${carsPromo2.marque} ${carsPromo2.modele }</h5>
        <p><c:out value="${carsPromo2.price} $"/></p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
  </div>
</div>
</div>
 <nav class="py-2 bg-ligt border-bottom">
  <div class="container d-flex flex-wrap">
  <c:if test="${empty onglets}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  <c:forEach items="${categories}" var="categorie">
  <ul class="nav me-auto">
  <li class= "nav-item"><a href="${categorie.libelle}"><c:out value="${categorie.libelle}"/></a></li>
  </ul>
  </c:forEach> 
  </div>
  </nav>
  
  
