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
		</style>
	</head>
	<body>
		<div class="container">
			<form:form action="/bank/transfer" method="POST" modelAttribute="transfer">
				CreditID:<form:input path="credit"/><br>
				DebitID:<form:input path="debit"/><br>
				Amount:<form:input path="amount"/><br>

				<input type="submit" value="Make Transaction">
				
			</form:form>
		</div>
	</body>
</html>



	