<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<h1 style="color: blue; text-align: center;">Add/Modify new product in
	apnabazar</h1>
<div class="container" align="center">
	<c:choose>
		<c:when test="${reqMethod == 'POST'}">
			<c:set var="formAction" value="save" />
		</c:when>
		<c:when test="${reqMethod == 'PUT'}">
			<c:set var="formAction" value="/admin/editsave" />
		</c:when>
	</c:choose>
	<form:form method="POST" action="${formAction}">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Product Code :</td>
				<td><form:input path="productCode" /></td>
			</tr>
			<tr>
				<td>Product Name :</td>
				<td><form:input path="productName" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="productPrice" /></td>
			</tr>
			<tr>
				<td>Category :</td>
				<td>
					<form:select path="category_id" >
					<c:forEach var="category" items="${listCategory}">
					<form:option value="${category.id}">${category.categoryName} </form:option>
					</c:forEach>
					</form:select>
				</td>
			</tr>
		</table>
		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>

</div>

<%@ include file="common/footer.jspf"%>