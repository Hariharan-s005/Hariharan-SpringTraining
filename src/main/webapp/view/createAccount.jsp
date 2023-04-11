<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank/createAccount" method="POST" modelAttribute="bank">
	UID:<form:input path="uid"/><br>
	Name:<form:input path="name"/><br>
	Amount:<form:input path="amount"/><br>

	
	<input type="submit" value="Create Account">
	
</form:form>