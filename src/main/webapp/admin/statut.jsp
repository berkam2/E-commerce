<c:import url="../nav/enteteAdmin.jsp"></c:import>


<div class="container d-flex flex-wrap">
  
  <table class="table caption-top">
	<caption> Les Statuts </caption>
<thead>
	<tr>
	<th scope="col">id</th>
	<th scope="col">Libelle<th>
	
	
	</tr>
</thead>

  <c:forEach items="${statuts}" var="statut">
<tbody>
	<tr>
	<td><c:out value="${statut.idStatut}"></c:out></td>
	<td><c:out value="${statut.libelle}"></c:out></td>
	<td> <a href="Edit?idStatut=<c:out value='${statut.idStatut }'/>" class="btn btn-primary"> Modifier </a></td>
	
	</tr>
</tbody>
  </c:forEach> 
 	</table>
  <c:if test="${empty statuts}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  </div>



<div class ="container">
<form action="<% request.getContextPath(); %>Statuts" method="post" > 
			 <label>Statut <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="statut">
                 </div>
             </div>

             
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Ajouter Statut</button>
             </p>
		</form>
		</div>