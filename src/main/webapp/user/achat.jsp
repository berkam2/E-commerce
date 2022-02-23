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
<form action="<% request.getContextPath(); %> Achat" method="post"> 
			 
             
             
             <input type="hidden" value="${voiture.idVehicule }" name="vehicules">
             <input type="hidden" value="${joueur.idUser }" name="users">
             
             
             
             <label> Part<span class="color-red">*</span></label>
            <div class="row margin-bottom-20">
                 <div class="col-md-6 col-md-offset-0">
                      <select name="parts" class="form-control">
                      <c:forEach  var="part" begin="1" end="${voiture.partDispo }">
                     <option value="<c:out value="${part}" />"> <c:out value="${part}"/></option>
                     </c:forEach>
                     </select>
                 </div>
             </div>
             
             <input type="hidden" value="${voiture.partDispo }" name="partDispo">
             
             <p>
                 <button type="submit" value="Upload" class="btn btn-primary">Acheter </button>
             </p>
		</form>
		</div>

</c:if>

<c:import url="../nav/footer.jsp"></c:import>