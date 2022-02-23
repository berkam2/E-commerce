<c:import url="../nav/enteteUtilisateur.jsp"></c:import>


<c:if test="${vehicule!=null}">
<input type="hidden" value="<c:out value="${vehicule.idVehicule}" />">

<div class="container" align="center">
       
       <h1>
       <c:out value="${vehicule.marque}"/>
       </h1>
       
       <h3>
       <c:out value="${vehicule.modele}"/>
       </h3>
       
       <p>
       <c:out value="${vehicule.energy}"/>
       <p>
       <img src="voitures/<c:out value="${vehicule.image}"/>" >
      
       
        <p>
       <c:out value="${vehicule.year }"/>
       </p>
       <p>
       <c:out value="${vehicule.mechanic }"/>
       </p>
       
        <img src="voitures/<c:out value="${vehicule.image1}"/>" >
        
        <p>
       <c:if test="${vehicule.etat==false}">
       Occasion
       </c:if>
        <c:if test="${vehicule.etat!=false}">
       Neuve
       </c:if>
       <p>
        <p>
       <em><c:out value="${vehicule.miles } kilomètres au compteur"/></em>
       </p>
        
        <div class="row">
        
        <div class="col-4">
        <img src="voitures/<c:out value="${vehicule.image2}"/>" class="img-fluid rounded-start">
        </div>
	
         <div class="col-4">
         <p> Localisation du véhicule : <c:out value="${vehicule.emplacement }"/></p>
         <p> Nombre de siège : <c:out value="${vehicule.siege}"/> siège(s) en <c:out value="${vehicule.interieur}"/></p>         
        </div>
        
        <div class="col-4">
        <img src="voitures/<c:out value="${vehicule.image3}"/>" class="img-fluid rounded-start" >
        </div>
        
        </div>
         <h3><c:out value="${vehicule.price} Euros"/></h3>
         <p> Valeur de la part : <c:out value="${vehicule.price/10} Euros"/></p>
         
         <div class="row">
         
         <div class="col-3">
          <a href="Achat?idVehicule=<c:out value='${vehicule.idVehicule }'/>" class="btn btn-primary">
          Acheter 
          <p>
          A partir de <c:out value="${vehicule.price/10} Euros"/>
          </p>
          </a>
          </div>
          <div class="col-6">
          <h3>Les véhicules sont livrés peu importe votre emplacement à l'intérieur de cargos sécurisés.</h3>
          </div>
          
          <c:if test="${vehicule.forRent==true }">
          <div class="col-3">
           <a href="FORENT?idVehicule=<c:out value='${vehicule.idVehicule }'/>" class="btn btn-primary">Louer</a>
           </div>
           </c:if>
           </div>
                      <a href="RDVZs?idVehicule=<c:out value='${vehicule.idVehicule }'/>" class="btn btn-primary">Etre rappelé</a>
    </div>
    
    </c:if>
   
   <c:if test="${post!=null}">
   <div class="container" align="center">
   
   <h1>
       <c:out value="${post.titre}"/>
       </h1>
       
       <h3>
       <c:out value="${post.created_at}"/>
       </h3>
       
     
      <img src="actualite/<c:out value="${post.image}"/>"  class="img-fluid rounded-start" >
      
      <p>
       <c:out value="${post.resume }"/>
       </p>
   	<p>
       <c:out value="${post.contenu }"/>
       </p>
   
   <em>
      Auteur : <c:out value="${post.auteur}"/>
      </em>
   
   </div>
   
   </c:if>


<c:import url="../nav/footer.jsp"></c:import>