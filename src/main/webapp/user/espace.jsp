<c:import url="../nav/enteteUtilisateur.jsp"/>

<c:if test="${joueur!=null }">


<div class="container">
<div class=" row d-flex flex-wrap">

<div class="col-9 row">

<div class = "col-3">
<img src="../profile/<c:out value="${joueur.image }"/>">
</div>
<div >
Bienvenue <c:out value="${joueur.nom }"/>
</div>

<input type="hidden" value="<c:out value="${joueur.idUser }"/>" name="idJoueur">
<div>
<c:if test="${jointure==null }">
Vous ne disposez d'aucune action pour le moment
</c:if>
 <c:forEach items="${jointure}" var="action">
 <div>
<c:out value="${action.voiture.marque}"/>
<c:out value="${action.voiture.modele}"/>
<img alt="" src="voitures/<c:out value="${action.voiture.image}"/>">
<br>
<c:if test="${action.part>1}">
<c:out value="${action.part}"/> parts
</c:if>
<c:if test="${action.part==1}">
<c:out value="${action.part}"/> part
</c:if>
</div>
</c:forEach>
</div>
<div >

<c:if test="${loc==null }">
Vous n'avez aucune location pour le moment 
<br>
<a href="RENT">Louer un véhicule</a>
</c:if>
<c:forEach items="${loc}" var="location">
<c:out value="${location.idLocation }"/>
<c:out value="${location.debut }"/>
<c:out value="${location.duree }"/>
<c:out value="${location.mbela*location.duree }"/>
</c:forEach>
</div>
<div >
<c:if test="${rdvse==null }">
Vous n'avez aucun rendez vous pour le moment
<a href="RDVZs">Prendre un rendez vous</a>
</c:if>
<c:forEach items="${rdvse}" var="rdv">
<c:out value="${rdv.date }"/>
<c:out value="${rdv.heure }"/>
</c:forEach>
</div>
<div >
<c:if test="${sinistrees==null }">
Vous n'avez aucun sinistre pour le moment 
</c:if>
<c:forEach items="${sinistrees}" var="sinistre">
<c:out value="${sinistre.location.idLocation}"/>
</c:forEach>
</div>
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
    <a href="Rdvz?idUser=<c:out value='${user.idUser }'/>" class="btn btn-primary">Prendre Rendez Vous</a>
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


</c:if>



<c:if test="${joueur==null}">
<div class ="container center">
Vous devez être connecté pour accéder à ce contenu

<h1>Erreur 237</h1>
</div>

</c:if>		

<c:import url="../nav/footer.jsp"></c:import>