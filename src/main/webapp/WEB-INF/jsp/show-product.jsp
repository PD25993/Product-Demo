<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
     <!-- ============== Table with population of data ================= -->    
 <h1 style="color: blue; text-align: center;">List of Products in
		Apnabazar</h1>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th style="visibility:hidden;">ID</th>
					<th>Product Code</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Category</th>
					<c:choose>
						<c:when test="${role == 'ROLE_ADMIN'}">
							<th>Actions</th>
						</c:when>
					</c:choose>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${listProducts}" var="product">
					<tr>
					<td style="visibility:hidden;">${product.id}</td> 
						<td>${product.productCode}</td>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productCategory}</td>
						<c:choose>
							<c:when test="${role == 'ROLE_ADMIN'}">
								<td><a class="btn btn-success"
									href="/admin/edit/${product.id}">Update</a> <a
									class="btn btn-danger" href="/admin/deleteProduct/${product.id}">Delete</a>
								</td>

							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="add" class="w3-container">
			<c:choose>
				<c:when test="${role == 'ROLE_ADMIN'}">

					<a class="btn btn-success" href="/admin/addproduct">Add</a>
					
				</c:when>
			</c:choose>
		</div>

	</div>
<%@ include file="common/footer.jspf"%>