<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<link
	href="/twitter-bootstrap/twitter-bootstrap-v2/docs/assets/css/bootstrap2.2.css"
	rel="stylesheet">
<link rel="stylesheet" href="demo.css">
<link rel="stylesheet" href="footer-distributed.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery.js"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="application/javascript"
	src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="application/javascript"
	src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Employee Manager</title>
</head>
<style>
#add {
	float: right;
	margin-right: 250px;
}
</style>
<body>
<nav role="navigation" class="navbar navbar-inverse">

	<div class="navbar-collapse container-fluid">
		<ul class="nav navbar-nav">
			<li class="nav-item active"><a href="/home">Home</a></li>
			<c:choose>
				<c:when test="${role == 'ROLE_ADMIN'}">
					<li class="nav-item "><a href="/admin/listproduct">List
							Product</a></li>
					<li class="nav-item"><a href="/admin/manageproduct">Manage
							Product</a></li>
				</c:when>
				<c:when test="${role == 'ROLE_USER'}">
					<li class="nav-item "><a href="/listproduct">List
							Product</a></li>
				</c:when>
			</c:choose>
			<li class="nav-item "><a href="/listproduct">List Product</a></li>
			<li class="nav-item"><a href="/manageproduct">Manage Product</a></li>

		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>User
			</a></li>
			<li><a href="/logout"><span
					class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</ul>
	</div>

</nav>
	<h1 style="color: blue; text-align: center;">List of Products in
		Apnabazar</h1>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
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
						<td>${product.productCode}</td>
						<td>${product.productName}</td>
						<td>${product.productPrice}</td>
						<td>${product.productCategory}</td>
						<c:choose>
							<c:when test="${role == 'ROLE_ADMIN'}">
								<td><a class="btn btn-success"
									href="/updatetProduct?id=${product.id}">Update</a> <a
									class="btn btn-danger" href="/deleteProduct?id=${product.id}">Delete</a>
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

					<a class="btn btn-success" href="/addproduct">Add</a>
				</c:when>
			</c:choose>
		</div>

	</div>
</body>
</html>