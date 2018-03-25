<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		${error}
		<div class="form-group form">
			<form action='login' method="post">

				<h4>Welcome back.</h4>

				<input type="text" id="nombre" name="nombre" class="form-control" />

				<input type="text" id="apellido" name="apellido"
					class="form-control" />

				<button id="login" class="form-control">Login</button>

			</form>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript"
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>