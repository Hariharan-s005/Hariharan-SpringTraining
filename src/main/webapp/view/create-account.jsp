<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<style>
			.container{
				width: 50%;
				margin-left: 25%;
				margin-top: 20%;
				display: flex;
				justify-content: center;
				border-style: solid;
				font-size: x-large;
			};
		</style>
	</head>
	<body>
		<div class="container">
			<form:form action="/bank/create-account" method="POST" modelAttribute="bank">	
				<div>User ID:<form:input path="uid"/></div>
				<div>Name:<form:input path="name"/></div>
				<div>Amount:<form:input path="amount"/></div>
			<input type="submit" value="Create Account">
			</form:form>
		</div>
	</body>
</html>