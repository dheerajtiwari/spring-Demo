<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<html>
<body>
	<h1>User Details</h1>

	<hr>
        <pre>
            <form:form id="userForm">
				<input type="hidden" name="id">
				UserName: <input type="text" name="userName">
				Passwrod:	<input type="password" name="password">
				Email:		<input type="text" name="email">
				Address:	<input type="text" name="address"/>
				<button value="Save-user" onclick="SaveUser()"/>
			</form:form>
			</pre>
	<hr>

</body>
</html>

<%--<script src="../js/jquery-1.9.1.min.js" type="text/javascript"></script>--%>
<script type="text/javascript">

	function SaveUser(){
		console.log("asdfasdf");
		console.log($('#userForm').serialize());
		$.ajax({
			url: 'insertUser',
			type: "GET",
			data:$('#userForm').serialize(),
			success: function (data)
			{
				console.log(data);
			}
		});
	}

	</script>