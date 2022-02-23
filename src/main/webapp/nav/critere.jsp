 <nav class="py-2 bg-ligt border-bottom">
  <div class="container d-flex flex-wrap">
  <c:forEach items="${categories}" var="categorie">
  <ul class="nav me-auto">
  <li class= "nav-item"><a href="${categorie.libelle}"><c:out value="${categorie.libelle}"/></a></li>
  </ul>
  </c:forEach> 
  </div>
  </nav>
  
  