<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap sample| Home</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="/static/css/styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="nav navbar-nav">
				<ul class="nav navbar-nav">
					<li><a href="new-user">Manage Users</a></li>
					<li><a href="all-users">All Users</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${mode == 'MODE_USERS'}">
			<div class="container text-center" id="userDiv">
				<h3>Users Registered</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Username</th>
								<th>Password</th>
								<th>Email</th>
								<th>Date Registered</th>
								<th>Status</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									<td>${user.id}</td>
									<td>${user.username}</td>
									<td>${user.password}</td>
									<td>${user.email}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${user.dateCreated}" /></td>
									<td>${user.status==true?'Active': 'Inactive'}</td>
									<td><a href="update-user?id=${user.id}"> <span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-user?id=${user.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manager User</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-user">
					<input type="hidden" name="id" value="${user.id}" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" value="${user.username}"
								name="username" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control"
								value="${user.password}" name="password" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-7">
							<input type="text" class="form-control" value="${user.email}"
								name="email" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-3">Status</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="status" value="true" />
							<div class="col-sm-1">Active</div>
							<input type="radio" class="col-sm-1" name="status" value="false"
								checked="checked" />
							<div class="col-sm-1">Inactive</div>
						</div>
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
	</c:choose>
	<script type="text/javascript" src="/static/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js">
		
	</script>

</body>
</html>