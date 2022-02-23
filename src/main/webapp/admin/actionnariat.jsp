
<c:import url="../nav/enteteAdmin.jsp"></c:import>


<div class="container d-flex flex-wrap">
  
  <table class="table caption-top">
	<caption> Les Actionnariats </caption>
<thead>
	<tr>
	<th scope="col">id Actionnariat</th>
	<th scope="col">id User</th>
	<th scope="col">Nom</th>
	<th scope="col">Prenom</th>
	<th scope="col">Age</th>
	<th scope="col">Telephone</th>
	<th scope="col">Vehicule</th>
	<th scope="col">Immatriculation</th>
	<th scope="col">Parts</th>
	<th scope="col">availableDay</th>

	
	</tr>
</thead>

  <c:forEach items="${listeAction}" var="action">
<tbody>
	<tr>
	<td><c:out value="${action.idActionnariat}"></c:out></td>
	<td><c:out value="${action.utilisateur.idUser}"></c:out></td>
	<td><c:out value="${action.utilisateur.nom}"></c:out></td>
	<td><c:out value="${action.utilisateur.prenom}"></c:out></td>
	<td><c:out value="${action.utilisateur.age}"></c:out></td>
	<td><c:out value="${action.utilisateur.telephone}"></c:out></td>
	<td><c:out value="${action.voiture.marque}"></c:out></td>
	<td><c:out value="${action.voiture.description }}"></c:out></td>
	<td><c:out value="${action.part}"></c:out></td>
	<td><c:out value="${action.availableDay}"></c:out></td>
	<td> <a href="Edit?idActionnariat=<c:out value='${action.idActionnariat }'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?idActionnariat=<c:out value='${action.idActionnariat }'/>" class="btn btn-primary"> Supprimer </a></td>
	
	
	</tr>
</tbody>
  </c:forEach> 
 	</table>
  <c:if test="${empty listeAction}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  </div>


<div class ="container">
<form action="<% request.getContextPath(); %> Actionnariat" method="post"> 
			 
             
             
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
             
             <label> Part<span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="parts" class="form-control">
                      <c:forEach  var="part" begin="1" end="10">
                     <option value="<c:out value="${part}" />"> <c:out value="${part}"/></option>
                     </c:forEach>
                     </select>
                 </div>
             </div>
             
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Ajouter Actionnariat</button>
             </p>
		</form>
		</div>