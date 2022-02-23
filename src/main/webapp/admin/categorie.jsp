<c:import url="../nav/enteteAdmin.jsp"/>



 <div class="container d-flex flex-wrap">
  <c:if test="${empty onglets}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  
  <table class="table caption-top">
	<caption> Vos catégories </caption>
<thead>
	<tr>
	<th scope="col">id</th>
	<th scope="col">Libelle</th>
	</tr>
</thead>
  <c:forEach items="${categories}" var="categorie">
<tbody>
	<tr>
	<td><c:out value="${categorie.idCategories }"></c:out></td>
	<td><c:out value="${categorie.libelle }"></c:out></td>
	<td> <a href="Edit?idCategorie=<c:out value='${categorie.idCategories }'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?idCategorie=<c:out value='${categorie.idCategories }'/>" class="btn btn-primary"> Supprimer </a></td>
	</tr>
</tbody>
  </c:forEach> 
 	</table>
 	
  </div>
  
  <div class ="container">
<form action="<% request.getContextPath(); %>Categorie" method="post" > 
			 <label>Categorie <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="categorie">
                 </div>
             </div>

             
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Ajouter Catégorie</button>
             </p>
		</form>
		</div>