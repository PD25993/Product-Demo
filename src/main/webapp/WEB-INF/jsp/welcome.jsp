<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<h1 style="color: blue; text-align: center;">Welcome to apnabazar</h1>

<c:choose>
	<c:when test="${role == '[ROLE_ADMIN]'}">
		<h2 style="text-align: center;">You are authorized admin user to
			view and manage product</h2>
	</c:when>

	<c:when test="${role != '[ROLE_ADMIN]'}">
		<h2 style="text-align: center;">You are not a authorized admin
			user. Please view the list of product</h2>
	</c:when>
</c:choose>
<%-- <form action="/logout" method=post>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="logout">
</form> --%>
<%@ include file="common/footer.jspf"%>