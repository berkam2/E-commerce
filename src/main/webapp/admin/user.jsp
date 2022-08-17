<c:import url="../nav/enteteAdmin.jsp"></c:import>



  <c:if test="${empty users}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  </div>


<div class ="container">
<form action="<% request.getContextPath(); %> Utilisateurs" method="post"> 
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
             
             <label> Statut<span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="statut" class="form-control">
                      <c:forEach items="${statuts}" var="statut">
                     <option value="<c:out value="${statut.idStatut}" />"> <c:out value="${statut.libelle }"/></option>
                     </c:forEach>
                     </select>
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
                 <button type="submit" value="Upload" class="btn btn-primary">Ajouter l'utilisateur</button>
             </p>
		</form>
		</div>