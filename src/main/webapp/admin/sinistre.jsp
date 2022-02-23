<c:import url="../nav/enteteAdmin.jsp"></c:import>

<div class="container d-flex flex-wrap">
  
  <table class="table caption-top">
	<caption> Les sinistres </caption>
<thead>

	<tr>
	<th scope="col">id</th>
	<th scope="col">Nom</th>
	<th scope="col">Prenom</th>
	<th scope="col">Modele</th>
	<th scope="col">Marque</th>
	<th scope="col">Immatriculation</th>
	<th scope="col">Location</th>
	<th scope="col">Date</th>
	<th scope="col">Description</th>
	</tr>
</thead>

  <c:forEach items="${sinistres}" var="sinistre">
<tbody>
	<tr>
	<td><c:out value="${sinistre.idSinistre}"></c:out></td>
	<td><c:out value="${sinistre.user.nom }"></c:out></td>
	<td><c:out value="${sinistre.user.prenom}"></c:out></td>
	<td><c:out value="${sinistre.voiture.modele }"></c:out></td>
	<td><c:out value="${sinistre.voiture.marque}"></c:out></td>
	<td><c:out value="${sinistre.voiture.description}"></c:out></td>
	<td><c:out value="${sinistre.location.idLocation}"></c:out></td>
	<td><c:out value="${sinistre.date }"></c:out></td>
	<td><c:out value="${sinistre.description}"></c:out></td>
	
	<td> <a href="Edit?idSinistre=<c:out value='${sinistre.idSinistre }'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?idSinistre=<c:out value='${sinistre.idSinistre }'/>" class="btn btn-primary"> Supprimer </a></td>
	</tr>
</tbody>
  </c:forEach> 
 	</table>
  <c:if test="${empty sinistres}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  </div>	
	
<div class ="container">
<form action="<% request.getContextPath(); %> Sinistres" method="post"> 
			 
             
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
             
              <label> Location<span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="locations" class="form-control">
                      <c:forEach items="${locations}" var="location">
                     <option value="<c:out value="${location.idLocation}" />"> <c:out value="${location.voiture.marque }${location.voiture.modele }${location.priseEnCharge }"/></option>
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
             
             <label>Date<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="date">
                 </div>
             </div>
             
             <label>Description<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="description">
                 </div>
             </div>
           
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Enregistrer le sinistre</button>
             </p>
		</form>
		</div>