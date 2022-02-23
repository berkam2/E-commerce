<c:import url="../nav/enteteUtilisateur.jsp"></c:import>

<h1> Céder, acheter des parts de véhicules ou profitez de véhicules d'exception</h1>


<c:if test="${exist == 'false' }">
		<div class="alert alert-success" role="alert">
		  Votre compte a bien été crée
		</div>
	
	</c:if>
	
	<c:if test="${exist }">
		<div class="alert alert-danger" role="alert">
		  Oups, le mail existe deja !
		</div>
	
	</c:if> 

<div class ="container">
<form action="<% request.getContextPath(); %> SignUp" method="post" enctype="multipart/form-data"> 
			 <label>Nom <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="nom">
                 </div>
             </div>
             
             <label>Prenom <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="prenom">
                 </div>
             </div>
          
             
             <label>Email<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="email">
                 </div>
             </div>
             
             <label> Age <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="age">
                 </div>
             </div>
             
              <label> Telephone <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="telephone">
                 </div>
             </div>
             
             <label>Adresse<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="adresse">
                 </div>
             </div>
             
               <label>Obtention Permis<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="obtentionPermis">
                 </div>
             </div>
     
             
             <label>Mot de Passe<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="password" name="mdp">
                 </div>
             </div>
             
                          <label>Confirmation du mot de Passe<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="password" name="mdp2">
                 </div>
             </div>
             
             <label>Permis<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="permis">
                 </div>
             </div>
             
              <label>Photo de profil<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image">
                 </div>
             </div>
  
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Créer mon compte</button>
             </p>
		</form>
		</div>

<c:import url="../nav/footer.jsp"></c:import>