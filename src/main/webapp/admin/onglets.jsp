<c:import url="../nav/enteteAdmin.jsp"/>



 <div class="container d-flex flex-wrap">
  <c:if test="${empty onglets}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  
  <table class="table caption-top">
	<caption> Vos onglets </caption>
<thead>
	<tr>
	<th scope="col">id</th>
	<th scope="col">Libelle</th>
	</tr>
</thead>
  <c:forEach items="${onglets}" var="onglet">
<tbody>
	<tr>
	<td><c:out value="${onglet.idOnglet }"></c:out></td>
	<td><c:out value="${onglet.libelle }"></c:out></td>
	<td> <a href="Edit?idOnglet=<c:out value='${onglet.idOnglet}'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?idOnglet=<c:out value='${onglet.idOnglet}'/>" class="btn btn-primary"> Supprimer </a></td>
	</tr>
</tbody>
  </c:forEach> 
 	</table>
 	
  </div>
  
  <div class ="container">
<form action="<% request.getContextPath(); %>Onglet" method="post" > 
			 <label>Onglets <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="onglet">
                 </div>
             </div>

             
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Ajouter Onglet</button>
             </p>
		</form>
		</div>