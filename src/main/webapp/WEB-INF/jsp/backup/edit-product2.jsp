<%-- <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 style="color: blue; text-align: center;">Add new product in
	apnabazar</h1>
<div class="container" align="center">

	<form >
		<table style="with: 50%">
				<c:forEach items="${productForUpdate}" var="productForUpdate">
					<tr>
						<td>Product Code</td>
						<td><input type="text" name="productCode" value=<c:if test="${not empty productForUpdate}">
						${productForUpdate.productCode}/</c:if>></td>
					</tr>
					<tr>
						<td>Product Name</td>
						<td><input type="text" name="productName" value=<c:if test="${not empty productForUpdate}">
						${productForUpdate.productName}/</c:if>></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="text" name="productPrice" value=<c:if test="${not empty productForUpdate}">
						${productForUpdate.productPrice}/</c:if>></td>
					</tr>
					<tr>
						<td>Category</td>
						<td><input type="text" name="productCategory" value=<c:if test="${not empty productForUpdate}">
						${productForUpdate.productCategory}/</c:if>></td>
					</tr>
				</c:forEach>

		</table>
		<!-- <button type="submit" class="btn btn-success" href="/admin/save">Submit</button> -->
		<c:choose>
			<c:when test="${reqMethod == 'POST'}">
				<button type="submit" class="btn btn-success" href="/admin/save">Submit</button>
			</c:when>
			<c:when test="${reqMethod == 'PUT'}">
				<button type="submit" class="btn btn-success"
					href="/admin/updatetProduct/save">Submit</button>
			</c:when>
		</c:choose>
	</form>
</div>

<%@ include file="common/footer.jspf"%> --%>