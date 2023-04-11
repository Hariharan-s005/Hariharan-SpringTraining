<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/bank/checkBalance" method="POST" modelAttribute="bank">
	UID:<form:input path="uid"/><br>
	<input type="submit" value="Check Balance">
	
</form:form>