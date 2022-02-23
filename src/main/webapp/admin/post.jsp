<c:import url="../nav/enteteAdmin.jsp"></c:import>


<div class="container d-flex flex-wrap">
  
  <table class="table caption-top">
	<caption> Les véhicules </caption>
<thead>
	<tr>
	<th scope="col">id</th>
	<th scope="col">Titre</th>
	<th scope="col">Resume</th>
	<th scope="col">Auteur</th>
	</tr>
</thead>

  <c:forEach items="${posts}" var="post">
<tbody>
	<tr>
	<td><c:out value="${post.id}"></c:out></td>
	<td><c:out value="${post.titre }"></c:out></td>
	<td><c:out value="${post.resume}"></c:out></td>
	<td><c:out value="${post.auteur }"></c:out></td>
	<td> <a href="Edit?id=<c:out value='${post.id}'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?id=<c:out value='${post.id}'/>" class="btn btn-primary"> Supprimer </a></td>
	
	</tr>
</tbody>
  </c:forEach> 
 	</table>
  <c:if test="${empty post}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  </div>



<div class ="container">
<form action="<% request.getContextPath(); %> Blog" method="post" enctype="multipart/form-data"> 
			 <label>Titre <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="titre">
                 </div>
             </div>
             
             <label>Resume <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="resume">
                 </div>
             </div>
             
             <label>Contenu <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="contenu">
                 </div>
             </div>
             
             <label>Auteur<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="auteur">
                 </div>
             </div>
             
             
              <label>Image<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image">
                 </div>
             </div>
               
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Publier le véhicule</button>
             </p>
		</form>
		</div>