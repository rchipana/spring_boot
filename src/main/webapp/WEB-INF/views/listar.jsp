<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>"${titulo}"</title>

<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />

</head>
<body>
	${cliente.nombre} ${fecha}
	<div class="container">
		<button class="btn btn-success nBtn">New</button>
		<input id="filtrar" type="text" class="form-control"
			placeholder="Ingresa la canción de este Disco que deseas Buscar..." />

		<div class="card">
			<div class="card-block">
				<table class="table table-hover" id="clienteTableResponse">
					<thead>
						<tr>
							<th>id</th>
							<th>nombre</th>
							<th>apellido</th>
							<th>email</th>
							<th>fecha</th>
							<th>editar</th>
							<th>eliminar</th>
						</tr>
					</thead>

					<tbody class="buscar">

						<c:forEach var="cliente" items="${clientes}">
							<tr>
								<td>${cliente.id}</td>
								<td>${cliente.nombre}</td>
								<td>${cliente.apellido}</td>
								<td>${cliente.email}</td>
								<td>${cliente.edad}</td>
								<td><a href='/buscar_clientes/${cliente.id}'
									class="btn btn-primary eBtn">Edit</a> <a
									href='/buscar_clientes/${cliente.id}'> <input type="submit"
										value="Detalle" /></a></td>

							</tr>
						</c:forEach>

					</tbody>

				</table>
			</div>
		</div>

		<div class="myForm">
			<form id="saveCliente">
				<div class="modal fade" id="exampleModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Update or
									Create</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">

								<div class="form-group">
									<label for="id" class="col-form-label">Id:</label> <input
										type="text" class="form-control" id="id" name="id" value="" />
								</div>
								<div class="form-group">
									<label for="nombre" class="col-form-label">Nombre:</label> <input
										type="text" class="form-control" id="nombre" name="nombre"
										value="" />
								</div>
								<div class="form-group">
									<label for="apellido" class="col-form-label">Apellido:</label>
									<input type="text" class="form-control" id="apellido"
										name="apellido" value="" />
								</div>
								<div class="form-group">
									<label for="email" class="col-form-label">Email:</label> <input
										type="text" class="form-control" id="email" name="email"
										value="" />
								</div>
								<div class="form-group">
									<label for="createAt" class="col-form-label">Año:</label> <input
										type="text" class="form-control" id="createAt" name="createAt"
										value="" />
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Close</button>

									<input type="submit" class="btn btn-primary" value="save" />
								</div>

							</div>
						</div>
					</div>
				</div>
			</form>
		</div>

	</div>


	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript"
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

	<script type="text/javascript" src="/js/main.js"></script>



</body>

</html>