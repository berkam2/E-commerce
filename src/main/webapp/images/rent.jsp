<c:import url="../nav/enteteUtilisateur.jsp"></c:import>



<div class="container d-flex flex-wrap">

<div class="row">
<c:forEach items="${voitures}" var="voiture">

<div class="card col-4">
  <img src="voitures/<c:out value="${voiture.image}"/>" class="card-img-top">
  <div class="card-body">
    <h3 class="card-title">
    <c:out value="${voiture.marque}"></c:out>
    </h3>
    <h5>
    <c:out value="${voiture.modele}"></c:out>
   	</h5>
   	<h2><c:out value="${voiture.price/10} Euros"></c:out></h2>
    <p class="card-text"><c:out value="${voiture.energy}"></c:out></p>
    <a href="Details?idVehicule=<c:out value='${voiture.idVehicule }'/>" class="btn btn-primary">C'est ma voiture</a>
  </div>
</div>
</c:forEach>
</div>


</div>



<c:import url="../nav/footer.jsp"></c:import>