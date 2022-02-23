<c:import url="nav/enteteUtilisateur.jsp"/>

<div class="container">
<div class=" row d-flex flex-wrap">

<div class="col-9 row">
<c:forEach items="${voitures}" var="voiture">


<div class="card col-4">
  <img src="voitures/<c:out value="${voiture.image}"/>" class="card-img-top">
  <div class="card-body">
    <h3 class="card-title">
    <c:out value="${voiture.marque}"></c:out>
    </h3>
    <h5>
    <c:out value="${voiture.modele}"></c:out>
   	</h5>
   	<h2><c:out value="${voiture.price/10} Euros"></c:out></h2>
    <p class="card-text"><c:out value="${voiture.energy}"></c:out></p>
    <a href="Details?idVehicule=<c:out value='${voiture.idVehicule }'/>" class="btn btn-primary">C'est ma voiture</a>
  </div>
</div>
</c:forEach>
</div>

<div class="col-3 row">

<div class="card col-12">
  <img src="voitures/<c:out value="${post.image}"/>" class="card-img-top">
  <div class="card-body">
    <h3 class="card-title">
    <c:out value="${post.resume}"></c:out>
    </h3>
    <h5>
    <c:out value="${post.auteur}"></c:out>
   	</h5>
    <p class="card-text"><c:out value="${post.titre}"></c:out></p>
    <a href="Details?id=<c:out value='${post.id }'/>" class="btn btn-primary">Lire plus ...</a>
  </div>
</div>

<div class="card col-12">
  
  <div class="card-body">
    <h3 class="card-title">
Votre rendez vous personnalisé
    </h3>
    <h5>
    Vous souhaitez obtenir plus de renseignements sur votre projet auto ? C'est avec plaisir que l'un de nos conseillers vous rappellera. 
   	</h5>
    <a href="RDVZs?idUser=<c:out value='${user.idUser }'/>" class="btn btn-primary">Prendre Rendez Vous</a>
  </div>
  <img src="images/calendrier.jpg" class="card-img-bottom">
</div>

<c:forEach items="${actions}" var="action">
<div class="col-12">
<div class="card mb-3" style="max-width: 540px; max-height:100px; font-size:10px">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="voitures/<c:out value="${action.voiture.image}"/>" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h6 class="card-title"><c:out value="${action.voiture.marque} ${action.voiture.modele}"/></h6>
        <c:out value="${action.utilisateur.nom} purchased ${action.part} part du vehicule ${action.voiture.marque} ${action.voiture.modele}"/>
        <p class="card-text"><small class="text-muted"><c:out value="${action.date}"/></small></p>
      </div>
    </div>
  </div>
</div>

</div>
</c:forEach>

<img src="images/financement.png" class="img-fluid rounded-start">
</div>

</div>
</div>

<c:import url="nav/footer.jsp"></c:import>