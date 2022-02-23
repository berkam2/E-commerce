<c:import url="../nav/enteteAdmin.jsp"/>



 <div class="container d-flex flex-wrap">
  <c:if test="${empty tarifs}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  
  <table class="table caption-top">
	<caption> Vos Tarifs </caption>
<thead>
	<tr>
	<th scope="col">id</th>
	<th scope="col">vehicule</th>
	<th scope="col">prix</th>
	</tr>
</thead>
  <c:forEach items="${tarifs}" var="tarif">
<tbody>
	<tr>
	<td><c:out value="${tarif.idTariff }"></c:out></td>
	<td><c:out value="${tarif.voiture.marque }${tarif.voiture.modele }"></c:out></td>
	<td><c:out value="${tarif.prixJour }"></c:out></td>
	<td> <a href="Edit?idTariff=<c:out value='${tarif.idTariff }'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Edit?idTariff=<c:out value='${tarif.idTariff }'/>" class="btn btn-primary"> Supprimer </a></td>
	</tr>
</tbody>
  </c:forEach> 
 	</table>
 	
  </div>
  
  <div class ="container">
<form action="<% request.getContextPath(); %>Tarif" method="post" > 
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
 	<label>Prix<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="prixJour">
                 </div>
             </div>
             
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Ajouter Tarification</button>
             </p>
		</form>
		</div>