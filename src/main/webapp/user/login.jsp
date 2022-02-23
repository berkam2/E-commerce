<c:import url="../nav/enteteUtilisateur.jsp"></c:import>

<div class="container p-5">
    <form action="<% request.getContextPath(); %>Login" method="post">
	  <div class="mb-3">
	    <label for="exampleInputEmail1" class="form-label">Email:</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" name="email">
	  </div>
	  <div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
	    <input type="password" class="form-control" name="pwd">
	  </div>
	  <button type="submit" class="btn btn-primary">Se connecter</button>
	</form>
	
	<c:if test="${exist }">
		<div class="alert alert-danger" role="alert">
		  Oups, Veuillez vérifier vos identifiants de connexion
		</div>
	</c:if>
</div>

<c:import url="../nav/footer.jsp"></c:import>