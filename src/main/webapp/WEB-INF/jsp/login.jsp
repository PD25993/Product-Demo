<%@ include file="common/header.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Todo!!</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<!-- style="background-color:#ffd9b3;" -->
<h1 style="color: blue; text-align: center;">Login to Apnabazar</h1>
<div align="center"> 
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
	<font color="red">
   		<c:out value="Invalid Credentials !!!"/>
   	</font>
	</c:if>
</div>
<div class="container">
	<form method="POST" class="form-horizontal" action="/login">
		<div class="form-group">
			<fieldset class="form-group">
				<label class="control-label col-sm-2">Name :</label>
				<div class="col-sm-10">
					<input name="username" type="text" class="form-control" />
				</div>
			</fieldset>
		</div>
		<div class="form-group">
			<fieldset class="form-group">
				<label class="control-label col-sm-2">Password :</label>
				<div class="col-sm-10">
					<input name="password" type="password" class="form-control" />
				</div>
			</fieldset>
		</div>
		<!-- <input type="submit" /> -->
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="common/footer.jspf"%>