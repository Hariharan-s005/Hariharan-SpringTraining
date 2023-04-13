
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<style>
		.container {
			width: 50%;
			margin-left: 25%;
			margin-top: 20%;
			padding-top: 20px;
			display:flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			border-style: solid;
		  }
		</style>
	</head>
	<body>
		<div class="container">
		<form:form action="/bank/create-account" method="GET" >
			<input type="submit" value="CreateAccount">	
		</form:form>
		<form:form action="/bank/check-balance" method="GET" >
			<input type="submit" value="Check Balance">	
		</form:form>
		<form:form action="/bank/transfer" method="GET" >
			<input type="submit" value="Transfer Money">
		</form:form>
		</div>
	</body>
</html>