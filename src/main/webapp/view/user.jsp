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
			<form:form action="/bank/menu" method="GET" >
				<h1>Account created successfully</h1>
				<input type="submit" value="menu">		
			</form:form>
		</div>
	</body>
</html>