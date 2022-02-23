<c:import url="../nav/enteteAdmin.jsp"></c:import>

<c:if test="${statut!=null }">
<form method="post" action="<%request.getContextPath(); %>Edit">
	  <div class="form-group">
	  	
	  	<input type="hidden" name="idUpdated" value="<c:out value="${statut.idStatut}" />" />
	    
	   
	  <div class="form-group">
	    <label for="exampleInputEmail1">Libelle</label>
	    <input type="text" class="form-control" name="libelle" value="<c:out value="${statut.libelle }" />">
	  </div>

	  <div>
		  <button type="submit" class="btn btn-primary" name="submit">Modifier le statut</button>
	  </div>
	   </div>
	</form>

 </c:if>
 
 <c:if test="${onglet!=null }">
<form method="post" action="<%request.getContextPath(); %>Edit">
 <div class="form-group">
	  	
	  	<input type="hidden" name="idOngletUpdated" value="<c:out value="${onglet.idOnglet}" />" />
	    
	   
	  <div class="form-group">
	    <label for="exampleInputEmail1">Libelle</label>
	    <input type="text" class="form-control" name="libelle" value="<c:out value="${onglet.libelle }" />">
	  </div>

	  <div>
		  <button type="submit" class="btn btn-primary" name="submit">Modifier l'onglet</button>
	  </div>
	  </div>
	</form>
 
 </c:if>
 
 <c:if test="${voiture!=null }">


<div class ="container">
<form action="<% request.getContextPath(); %>Edit" method="post" enctype="multipart/form-data"> 
	
		<input type="hidden" name="idVehiUpdated" value="<c:out value="${voiture.idVehicule}" />" />
	
			 <label>Marque <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="marque" value="<c:out value="${voiture.marque }"/>">
                 </div>
             </div>
             
             <label>Modele <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="modele" value="<c:out value="${voiture.modele }"/>">
                 </div>
             </div>
             
             <label>Prix <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="prix" value="<c:out value="${voiture.price }"/>">
                 </div>
             </div>
             
             <label>Emplacement<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="emplacement" value="<c:out value="${voiture.emplacement }"/>">
                 </div>
             </div>
             
             <label> Siege <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="siege" class="form-control">
                     <option value="<c:out value='${voiture.siege }'/>"> <c:out value="${voiture.siege }"/></option>
                     <option value="1">1</option>
                     <option value="2">2</option>
                     <option value="4">4</option>
                     </select>
                 </div>
             </div>
             
              <label>A louer <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                    <select name="forRent" class="form-control">
                    <option value="0">Non</option>
                    <option value="1">Oui</option>
                    </select>
                 </div>
             </div>
             
             <label>Approuvé <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                    <select name="approved" class="form-control">
                    <option value="0">Non</option>
                    <option value="1">Oui</option>
                    </select>
                 </div>
             </div>
           
                <input type="hidden" value="10" name="partDispo">
             
             <label>Etat<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <select name="etat" class="form-control">
                     <option value="<c:out value='${voiture.etat }'/>">
                      <c:if test="${voiture.etat==False}">
                      <c:out value="non"/>
                      Non
                      </c:if>
                     <c:if test="${voiture.etat==True}">Oui</c:if>
                     </option>
                     <option value="0">Occasion</option>
                     <option value="1">Neuf</option>
                     </select>
                 </div>
             </div>
             
             <label>One-off <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                    <select name="oneOff" class="form-control">
                    <option value="${voiture.oneOff}"> 
                     <c:if test="${voiture.oneOff==False}">Non</c:if>
                     <c:if test="${voiture.oneOff==True}">Oui</c:if>
                     </option>
                    <option value="0">Non</option>
                    <option value="1">Oui</option>
                    </select>
                 </div>
             </div>
             
              <label>isPromo <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                    <select name="isPromo" class="form-control">

                    <option value="${voiture.promo}"> 
                     <c:if test="${voiture.promo==False}">Non</c:if>
                    <c:if test="${voiture.promo==True}">Oui</c:if>
                     </option>
                    
                    <option value="0">Non</option>
                    <option value="1">Oui</option>
                    </select>
                 </div>
             </div>
             
              <label> Couleur <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="color" value="${voiture.color}">
                 </div>
             </div>
             
              <label> Energy<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="energy" value="${voiture.energy }">
                 </div>
             </div>
             
              <label> Miles<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="miles" value="${voiture.miles}">
                 </div>
             </div>
             
               <label> Year<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="year" value="${voiture.year }">
                 </div>
             </div>
             
               <label> Mechanic <span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                  <div class="col-md-6 col-md-offset-0">
                    <select name="mechanic" class="form-control">
                    <option value="<c:out value='${voiture.mechanic }'/>"> <c:out value="${voiture.mechanic }"/></option>
                    <option value="Automatic">Automatic</option>
                    <option value="Manuel">Manual</option>
                    </select>
                 </div>
             </div>
             
               <label> Intérieur <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="interieur" value="${voiture.interieur }">
                 </div>
             </div>
             
              <label>Image<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image" value="${voiture.image }">
                 </div>
             </div>
             
             <label>Image<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image1" value="${voiture.image1 }">
                 </div>
             </div>
             
             <label>Image<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image2" value="${voiture.image2 }">
                 </div>
             </div>
             
             <label>Image<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image3" value="${voiture.image3 }">
                 </div>
             </div>
             
             <label>Description <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-8 col-md-offset-0">
                     <input class="form-control" name="description" value="${voiture.description }">
                 </div>
             </div>
             
           
             
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Modifier le véhicule</button>
             </p>
		</form>
		</div>
 </c:if>
 
 <c:if test="${tarif!=null }">

 <div class="container">
<form method="post" action="<%request.getContextPath(); %>Edit">
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
                 <button type="submit" value="Upload" class="btn btn-primary">Modifier la Tarification</button>
             </p>
	</form>
 </div>
 </c:if>
 
 <c:if test="${post!=null }">
<div class ="container">
<form action="<% request.getContextPath(); %> Blog" method="post" enctype="multipart/form-data"> 

<input type="hidden" name="idPostUpdated" value="<c:out value="${post.id}" />" />

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
                 <button type="submit" value="Upload" class="btn btn-primary">Modifier le Post</button>
             </p>
		</form>
		</div>
 </c:if>
 
 
 <c:if test="${location!=null }">
 <div class ="container">
<form action="<% request.getContextPath(); %> Edit" method="post"> 
			 
			 <input type="hidden" name="idLocation" value="<c:out value="${location.idLocation}" />" />
             
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
             
              <label> Tarification<span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="tarifs" class="form-control">
                      <c:forEach items="${tarifs}" var="tarif">
                     <option value="<c:out value="${tarif.idTariff}" />"> <c:out value="${tarif.voiture.marque }${tarif.voiture.modele }${tarif.prixJour }"/></option>
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
             
             <label>Début<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="debut">
                 </div>
             </div>
             
             <label>Fin<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="fin">
                 </div>
             </div>
             
           
             
             <label>Durée de la location<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="duree">
                 </div>
             </div>
            
             <label>Adresse de prise en charge<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="priseEnCharge">
                 </div>
             </div>
           
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Générer location</button>
             </p>
		</form>
		</div>
		</c:if>
		
		<c:if test="${user!=null}">
		
		
<div class ="container">
<form action="<% request.getContextPath(); %> Utilisateurs" method="post">

				 <input type="hidden" name="idUser" value="<c:out value="${user.idUser}" />" />

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
             
             <label>Visible <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                    <select name="isVisible" class="form-control">

                    <option value="${user.visible}"> 
                     <c:if test="${user.visible==false}">Non</c:if>
                    <c:if test="${user.visible==true}">Oui</c:if>
                     </option>
                    
                    <option value="0">Non</option>
                    <option value="1">Oui</option>
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
            
             <label>Disponnibilité<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="availability">
                 </div>
             </div>
             
             <label>Photo de Profil<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image">
                 </div>
             </div>
             
  
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Mettre à jour l'utilisateur</button>
             </p>
		</form>
		</div>
		
		</c:if>