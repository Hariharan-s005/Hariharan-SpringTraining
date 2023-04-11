
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank/createAccount" method="GET" >
	<input type="submit" value="CreateAccount">
    
	
</form:form>
<form:form action="/bank/checkBalance" method="GET" >
	<input type="submit" value="Check Balance">
	
</form:form>

<form:form action="/bank/transfer" method="GET" >
	<input type="submit" value="Transfer Money">
	
</form:form>
