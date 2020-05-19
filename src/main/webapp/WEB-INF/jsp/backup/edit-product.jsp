<%-- <%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div align="center">
	<h1>Edit Employee</h1>
	<form:form method="POST" action="/admin/editsave">
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
				<td><form:input path="productCategory" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</div>
<%@ include file="common/footer.jspf"%> --%>