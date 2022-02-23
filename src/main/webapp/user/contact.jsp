<c:import url="../nav/enteteUtilisateur.jsp"/>


<div class ="container">
<form action="<% request.getContextPath(); %> CONTACT" method="post"> 
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
             
             <label>Message <span class="color-red">*</span> </label>
             <div class="row margin-bottom-20">
                 <div class="col-md-8 col-md-offset-0">
                     <textarea rows="8" class="form-control" name="message"></textarea>
                 </div>
             </div>
             
  
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Envoyer votre message</button>
             </p>
		</form>
		</div>



<c:import url="../nav/footer.jsp"></c:import>