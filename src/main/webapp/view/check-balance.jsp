<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<style>
		.container {
			width: 50%;
			margin-left: 25%;
			margin-top: 20%;
			display: flex;
			justify-content: center;
			border-style: solid;
			font-size: x-large;
		  }
		  .container div{
			margin-top: 23%;
	  	   }
		</style>
	</head>
	<body>
		<div class="container">
			<form:form action="/bank/check-balance" method="POST" modelAttribute="bank">
				User ID:<form:input path="uid"/><br>
				<div><input type="submit" value="Check Balance"></div>	
			</form:form>
		</div>
	</body>
</html>