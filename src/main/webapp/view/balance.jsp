<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank/menu" method="GET" modelAttribute="Balance">
	<h1>Balance is:-</h1>
   
<h3>UID</h3>${balance.uid}
<h3>Name</h3>${balance.name}
<h3>Balance</h3>${balance.amount}
<br><br>



	<input type="submit" value="menu">
	
</form:form>