<c:import url="../nav/enteteAdmin.jsp"></c:import>

<c:if test="${joueur==null }">

<div class="container text-center">
Vous devez être connecté pour avoir accès à ce contenu
<br>

<a href="Login" class="btn btn-primary">Se connecter</a>
<a href="SignUp" class="btn btn-primary">S'inscrire</a>
</div>

</c:if>
  
  <c:if test="${joueur!=null }">
	<c:if test="${voiture!=null }">
<div class ="container">
<form action="<% request.getContextPath(); %> RDVZs" method="post"> 
			 
             
            <input type="hidden" value="${voiture.idVehicule }" name="vehicules">
             
             
             
             <input type="hidden" value="${joueur.idUser}" name="users">
             
             <label>Date<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="debut">
                 </div>
             </div>
             
             <label>Heure<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="time" min="09:00" max="18:00" name="heure">
                 </div>
             </div>
             

             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Prendre rendez vous</button>
             </p>
		</form>
		</div>
		</c:if>
		<c:if test="${voiture==null }">
		
			
<div class ="container">
<form action="<% request.getContextPath(); %> Rdvz" method="post"> 
			 
             
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
             
              <input type="hidden" value="${joueur.idUser}" name="users">
             
            
             
             <label>Date<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="date" name="debut">
                 </div>
             </div>
             
             <label>Heure<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="time" min="09:00" max="18:00" name="heure">
                 </div>
             </div>
             

             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Générer location</button>
             </p>
		</form>
		</div>
		
		</c:if>
		</c:if>