<%@ include file="common/header.jspf"%>
<!-- style="background-color:#ffd9b3;" -->
	<h1 style="color:blue;text-align:center;">Login to Apnabazar</h1>
	<p align="center">
		<font color="red">${errorMessage}</font>
	</p>
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
						<input name="userpassword" type="password" class="form-control" />
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