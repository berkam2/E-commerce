<c:import url="../nav/enteteAdmin.jsp"></c:import>

<div class="container d-flex flex-wrap">
  
  <table class="table caption-top">
	<caption> Les interventions en Garage </caption>
<thead>

	<tr>
	<th scope="col">id</th>
	<th scope="col">Marque</th>
	<th scope="col">Modele</th>
	<th scope="col">Immatriculation</th>
	<th scope="col">Date sinistre</th>
	<th scope="col">id Sinistre</th>
	<th scope="col">Entrée</th>
	<th scope="col">Sortie</th>
	<th scope="col">Pannes</th>
	<th scope="col">Réparations</th>
	<th scope="col">Cout</th>
	</tr>
</thead>

  <c:forEach items="${garages}" var="garage">
<tbody>
	<tr>
	<td><c:out value="${garage.idGarage}"></c:out></td>
	<td><c:out value="${garage.sinistre.voiture.marque}"></c:out></td>
	<td><c:out value="${garage.sinistre.voiture.modele}"></c:out></td>
	<td><c:out value="${garage.sinistre.voiture.description }"></c:out></td>
	<td><c:out value="${garage.sinistre.date}"></c:out></td>
	<td><c:out value="${garage.sinistre.idSinistre}"></c:out></td>
	<td><c:out value="${garage.entree}"></c:out></td>
	<td><c:out value="${garage.sortie }"></c:out></td>
	<td><c:out value="${garage.sinistre.description }"></c:out></td>
	<td><c:out value="${garage.intervention}"></c:out></td>
	<td><c:out value="${garage.cout }"></c:out></td>
	
	<td> <a href="Edit?idGarage=<c:out value='${garage.idGarage }'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?idGarage=<c:out value='${garage.idGarage }'/>" class="btn btn-primary"> Supprimer </a></td>
	</tr>
</tbody>
  </c:forEach> 
 	</table>
  <c:if test="${empty garages}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  </div>	
	
<div class ="container">
<form action="<% request.getContextPath(); %> Garages" method="post"> 
		
             
              <label> Sinistre<span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="sinistres" class="form-control">
                      <c:forEach items="${sinistres}" var="sinistre">
                     <option value="<c:out value="${sinistre.idSinistre}" />"> <c:out value="${sinistre.voiture.marque }${sinistre.voiture.modele }${sinistre.description }"/></option>
                     </c:forEach>
                     </select>
                 </div>
             </div>
          
             
             <label>Date de prise en charge<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="entree">
                 </div>
             </div>
             
              <label>Date de retour<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="sortie">
                 </div>
             </div>
             
             <label>Description<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="description">
                 </div>
             </div>
             
              <label>Cout<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="cout">
                 </div>
             </div>
           
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Envoyer en répartation</button>
             </p>
		</form>
		</div>