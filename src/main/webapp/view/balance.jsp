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
		margin-top: 25%;
	  }
    </style>
  </head>
  <body>
    <div class="container">
      <form:form action="/bank/menu" method="GET" modelAttribute="Balance">
        <h1>Account Balance:-</h1>
        <span><strong>User ID: </strong>${balance.uid}</span>
        <span> <strong>Name: </strong>${balance.name}</span>
        <span> <strong>Balance: </strong>${balance.amount}</span>
		<div><input type="submit" value="Return to Menu"/></div>
      </form:form>
    </div>
  </body>
</html>
