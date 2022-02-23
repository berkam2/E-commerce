<c:import url="../nav/enteteUtilisateur.jsp"/>

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
<form action="<% request.getContextPath(); %> SELL" method="post" enctype="multipart/form-data"> 
<div class="row">
<div class="col-6">

			<input type = "hidden" value="${joueur.idUser}" name="idUser">
			
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
             
             <label> Parts proposées<span class="color-red">*</span> </label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="partDispo">
                 </div>
             </div>
            <input type="hidden" value="0" name="approved">
               
             
              <label> Couleur <span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="color">
                 </div>
             </div>
              </div>
             <div class="col-6">
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
             
             <label>Disponnibilité<span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                  <div class="col-md-6 col-md-offset-0">
                     <input class="form-control" type="text" name="availability">
                 </div>
             </div>
             
           </div>
             
             <p style="text-align:center;padding:20px">
                 <button type="submit" value="Upload" class="btn btn-primary">Publier le véhicule</button>
             </p>
             </div>
		</form>
		</div>
		</c:if>
<c:import url="../nav/footer.jsp"></c:import>