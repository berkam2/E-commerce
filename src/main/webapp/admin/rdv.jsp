<c:import url="../nav/enteteAdmin.jsp"></c:import>

<div class="container d-flex flex-wrap">
  
  <table class="table caption-top">
	<caption> Les Rendez Vous </caption>
<thead>

	<tr>
	<th scope="col">id</th>
	<th scope="col">Nom</th>
	<th scope="col">Prenom</th>
	<th scope="col">Modele</th>
	<th scope="col">Marque</th>
	<th scope="col">Immatriculation</th>
	<th scope="col">Date</th>
	<th scope="col">Heure</th>
	</tr>
</thead>

  <c:forEach items="${rdvs}" var="rdv">
<tbody>
	<tr>
	<td><c:out value="${rdv.idRdv}"></c:out></td>
	<td><c:out value="${rdv.user.nom }"></c:out></td>
	<td><c:out value="${rdv.user.prenom}"></c:out></td>
	<td><c:out value="${rdv.voiture.modele }"></c:out></td>
	<td><c:out value="${rdv.voiture.marque}"></c:out></td>
	<td><c:out value="${rdv.voiture.description}"></c:out></td>
	<td><c:out value="${rdv.date}"></c:out></td>
	<td><c:out value="${rdv.heure }"></c:out></td>
	
	<td> <a href="Edit?idRdv=<c:out value='${rdv.idRdv}'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?idRdv=<c:out value='${rdv.idRdv}'/>" class="btn btn-primary"> Supprimer </a></td>
	</tr>
</tbody>
  </c:forEach> 
 	</table>
  <c:if test="${empty rdvs}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  </div>	
	
<div class ="container">
<form action="<% request.getContextPath(); %> Rdvz" method="post"> 
			 
             
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
                     <input class="form-control" type="date" name="debut">
                 </div>
             </div>
             
             <label>Heure<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="time" min="09:00" max="18:00" name="heure">
                 </div>
             </div>
             

             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Générer location</button>
             </p>
		</form>
		</div>