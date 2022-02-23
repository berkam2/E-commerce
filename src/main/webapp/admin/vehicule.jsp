<c:import url="../nav/enteteAdmin.jsp"></c:import>

<div class="container d-flex flex-wrap">
  
  <table class="table caption-top">
	<caption> Les véhicules </caption>
<thead>
	<tr>
	<th scope="col">id</th>
	<th scope="col">Marque</th>
	<th scope="col">Modèle</th>
	<th scope="col">Prix</th>
	<th scope="col">Emplacement</th>
	<th scope="col">Siège</th>
	<th scope="col">Etat</th>
	<th scope="col">OneOff</th>
	<th scope="col">Couleur</th>
	<th scope="col">Energy</th>
	<th scope="col">Miles</th>
	<th scope="col">Year</th>
	<th scope="col">Mechanic</th>
	<th scope="col">Intérieur</th>
	<th scope="col">Image</th>
	<th scope="col">Description</th>
	<th scope="col">Promo</th>
	<th scope="col">En ligne</th>
	<th scope="col">part dispo</th>
	<th scope="col">A louer</th>
	<th scope="col">Approuvé</th>
	</tr>
</thead>

  <c:forEach items="${auto}" var="voiture">
<tbody>
	<tr>
	<td><c:out value="${voiture.idVehicule}"></c:out></td>
	<td><c:out value="${voiture.marque }"></c:out></td>
	<td><c:out value="${voiture.modele}"></c:out></td>
	<td><c:out value="${voiture.price }"></c:out></td>
	<td><c:out value="${voiture.emplacement}"></c:out></td>
	<td><c:out value="${voiture.siege }"></c:out></td>
	<td><c:out value="${voiture.etat}"></c:out></td>
	<td><c:out value="${voiture.oneOff }"></c:out></td>
	<td><c:out value="${voiture.color}"></c:out></td>
	<td><c:out value="${voiture.energy}"></c:out></td>
	<td><c:out value="${voiture.miles}"></c:out></td>
	<td><c:out value="${voiture.year }"></c:out></td>
	<td><c:out value="${voiture.mechanic}"></c:out></td>
	<td><c:out value="${voiture.interieur }"></c:out></td>
	<td><c:out value="${voiture.image }"></c:out></td>
	<td><c:out value="${voiture.description }"></c:out></td>
	<td><c:out value="${voiture.promo }"></c:out></td>
	<td><c:out value="${voiture.approved }"></c:out></td>
	<td><c:out value="${voiture.partDispo }"></c:out></td>
	<td><c:out value="${voiture.forRent }"></c:out></td>
	<td><c:out value="${voiture.approved }"></c:out></td>
	<td> <a href="Edit?idVehicule=<c:out value='${voiture.idVehicule }'/>" class="btn btn-primary"> Modifier </a></td>
	<td> <a href="Delete?idVehicule=<c:out value='${voiture.idVehicule }'/>" class="btn btn-primary"> Supprimer </a></td>
	<c:if test="${voiture.approved==false}">
	<td> <a href="Approuve?idVehicule=<c:out value='${voiture.idVehicule }'/>" class="btn btn-primary"> Approuver </a></td>
	</c:if>
	</tr>
</tbody>
  </c:forEach> 
 	</table>
  <c:if test="${empty auto}">
  <div class="alert alert-info" role="alert">
  Erreur 237 (pas encore configuré)
  </div>
  </c:if>
  </div>



<div class ="container">
<form action="<% request.getContextPath(); %> Auto" method="post" enctype="multipart/form-data"> 
			 <label>Marque <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="marque">
                 </div>
             </div>
             
             <label>Modele <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="modele">
                 </div>
             </div>
             
             <label>Prix <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="prix">
                 </div>
             </div>
             
             <label>Emplacement<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="emplacement">
                 </div>
             </div>
             
             <label> Siege <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="siege" class="form-control">
                     <option value="1">1</option>
                     <option value="2">2</option>
                     <option value="4">4</option>
                     </select>
                 </div>
             </div>
             
             <label>Etat<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <select name="etat" class="form-control">
                     <option value="0">Occasion</option>
                     <option value="1">Neuf</option>
                     </select>
                 </div>
             </div>
             
             <label>One-off <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                    <select name="oneOff" class="form-control">
                    <option value="0">Non</option>
                    <option value="1">Oui</option>
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
             
            <input type="hidden" value="1" name="approved">
                <input type="hidden" value="10" name="partDispo">
             
              <label> Couleur <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="color">
                 </div>
             </div>
             
              <label> Energy<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="energy">
                 </div>
             </div>
             
              <label> Miles<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="miles">
                 </div>
             </div>
             
               <label> Year<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="year">
                 </div>
             </div>
             
               <label> Mechanic <span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                  <div class="col-md-6 col-md-offset-0">
                    <select name="mechanic" class="form-control">
                    <option value="Automatic">Automatic</option>
                    <option value="Manuel">Manual</option>
                    </select>
                 </div>
             </div>
             
               <label> Intérieur <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="interieur">
                 </div>
             </div>
             
              <label>Image<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image">
                 </div>
             </div>
             <label>Image<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image1">
                 </div>
             </div>
             
             <label>Image<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image2">
                 </div>
             </div>
             
             <label>Image<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="file" name="image3">
                 </div>
             </div>
             
             <label>Description <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="description">
                 </div>
                 
             </div>
             
             <label>Disponnibilité <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="availability">
                 </div>
                 
             </div>
             
           
             
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Publier le véhicule</button>
             </p>
		</form>
		</div>