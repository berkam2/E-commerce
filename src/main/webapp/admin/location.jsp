<c:import url="../nav/enteteAdmin.jsp"></c:import>

<div class="container d-flex flex-wrap">
  
  <table class="table caption-top">
	<caption> Les locations </caption>
<thead>

	<tr>
	<th scope="col">id</th>
	<th scope="col">Nom</th>
	<th scope="col">Prenom</th>
	<th scope="col">Modele</th>
	<th scope="col">Marque</th>
	<th scope="col">Immatriculation</th>
	<th scope="col">Début</th>
	<th scope="col">Fin</th>
	<th scope="col">Nombre de Jours</th>
	<th scope="col">prix Journalier</th>
	<th scope="col">Prix total</th>
	<th scope="col">Adresse de Prise en charge</th>
	</tr>
</thead>

  <c:forEach items="${locations}" var="location">
<tbody>
	<tr>
	<td><c:out value="${location.idLocation}"></c:out></td>
	<td><c:out value="${location.user.nom }"></c:out></td>
	<td><c:out value="${location.user.prenom}"></c:out></td>
	<td><c:out value="${location.voiture.modele }"></c:out></td>
	<td><c:out value="${location.voiture.marque}"></c:out></td>
	<td><c:out value="${location.voiture.description}"></c:out></td>
	<td><c:out value="${location.debut}"></c:out></td>
	<td><c:out value="${location.fin }"></c:out></td>
	<td><c:out value="${location.nbreJour}"></c:out></td>
	<td><c:out value="${location.mbela.prixJour}"></c:out></td>
	<td><c:out value="${location.mbela.prixJour}"></c:out></td>
	<td><c:out value="${location.priseEnCharge }"></c:out></td>
	<td> <a href="Edit?idLocation=<c:out value='${location.idLocation }'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?idLocation=<c:out value='${location.idLocation }'/>" class="btn btn-primary"> Supprimer </a></td>
	</tr>
</tbody>
  </c:forEach> 
 	</table>
  <c:if test="${empty locations}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  </div>	
	
<div class ="container">
<form action="<% request.getContextPath(); %> Locations" method="post"> 
			 
             
             <label> Vehicule<span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="vehicules" class="form-control">
                      <c:forEach items="${vehicules}" var="vehicule">
                     <option value="<c:out value="${vehicule.idVehicule}" />"> <c:out value="${vehicule.marque }${vehicule.modele }"/></option>
                     </c:forEach>
                     </select>
                 </div>
             </div>
             
              <label> Tarification<span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="tarifs" class="form-control">
                      <c:forEach items="${tarifs}" var="tarif">
                     <option value="<c:out value="${tarif.idTariff}" />"> <c:out value="${tarif.voiture.marque }${tarif.voiture.modele }${tarif.prixJour }"/></option>
                     </c:forEach>
                     </select>
                 </div>
             </div>
             
             <label> Utilisateur<span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="users" class="form-control">
                      <c:forEach items="${users}" var="user">
                     <option value="<c:out value="${user.idUser}" />"> <c:out value="${user.nom }${user.prenom }"/></option>
                     </c:forEach>
                     </select>
                 </div>
             </div>
             
             <label>Début<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="debut">
                 </div>
             </div>
             
             <label>Fin<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="fin">
                 </div>
             </div>
             
           
             
             <label>Durée de la location<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="duree">
                 </div>
             </div>
            
             <label>Adresse de prise en charge<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="priseEnCharge">
                 </div>
             </div>
           
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Générer location</button>
             </p>
		</form>
		</div>
		<c:import url="../nav/footer.jsp"></c:import>