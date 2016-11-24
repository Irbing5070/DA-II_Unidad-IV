<%@page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Bootstrap sample| Home </title>	
	<link href="/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/static/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="nav navbar-nav">
				<ul class="nav navbar-nav">
					<li><a href="new-employer">Manage Employers</a></li>
					<li><a href="all-employers">All Employers</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode == 'MODE_EMPLOYERS'}">
	<div class="container text-center" id="employerDiv">
		<h3>Employers Registered</h3>
		<hr />
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Street</th>		
						<th>City</th>
						<th>State</th>
						<th>Country</th>
						<th>Date</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employer" items="${employers}">
						<tr>
							<td>${employer.id}</td>
							<td>${employer.name}</td>
							<td>${employer.street}</td>
							<td>${employer.city}</td>
							<td>${employer.state}</td>
							<td>${employer.country}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${employer.date}"/></td>
							<td><a href="update-employer?id=${employer.id}">
							<span class="glyphicon glyphicon-pencil"></span>
							</a></td>
							<td><a href="delete-employer?id=${employer.id}">
							<span class="glyphicon glyphicon-trash"></span>
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
		<h3>Manager Employer</h3>	
		<hr />
			<form class="form-horizontal" method="POST" action="save-employer">
				<input type="hidden" name="id" value="${employer.id}" />
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control" 
						value="${employer.name}" name="name" /> 
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Street</label>
					<div class="col-md-7">
						<input type="text" class="form-control" 
						value="${employer.street}" name="street" /> 
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">City</label>
					<div class="col-md-7">
						<input type="text" class="form-control" 
						value="${employer.city}" name="city" /> 
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">State</label>
					<div class="col-md-7">
						<input type="text" class="form-control" 
						value="${employer.state}" name="state" /> 
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Country</label>
					<div class="col-md-7">
						<input type="text" class="form-control" 
						value="${employer.country}" name="country" /> 
					</div>
				</div>
				
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Save" />
				</div>
				
			</form>
	</div>
	</c:when>
	</c:choose>
<script type= "text/javascript" src="/static/js/bootstrap.min.js">
</script>
<script type = "text/javascript" src= "/static/js/jquery-3.1.1.min.js">
</script>

</body>
</html>