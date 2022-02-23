<c:import url="../nav/enteteUtilisateur.jsp"></c:import>
<c:if test="${joueur==null }">

<div class="container text-center">
Vous devez être connecté pour avoir accès à ce contenu
<br>

<a href="Login" class="btn btn-primary">Se connecter</a>
<a href="SignUp" class="btn btn-primary">S'inscrire</a>
</div>

</c:if>

<c:if test="${joueur!=null }">

<div class ="container">
<form action="<% request.getContextPath(); %> FORENT" method="post"> 
			 
             
             <input type="hidden" value="${voiture.idVehicule }" name="vehicules">
              <input type="hidden" value="${joueur.idUser }" name="users">
             
             <input type="hidden" value="${tariff.idTariff}" name="tariff">
             
             
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
		<c:import url="../nav/footer.jsp"></c:import>