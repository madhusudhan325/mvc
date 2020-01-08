<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Debit Card Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>
<!-- <style>
<!--
body {
	background-image:
		url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkR5h129ptZesuCkRuuS-HycxXJcLo-ITVv4GD1IIByuwz_vZ-iw&s');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	background-size: 100% 100%;
}
</style>
-->
<style>
.container {
	max-width: 800px;
	padding: 50px 70px;
	background-color: beige;
	border-radius: 10px;
	opacity: 0.9;
}

.error {
	color: red;
	font-style: italic;
}
</style>
</head>
<body>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="container">
				<form action="/addtravelData" method="post"
					onsubmit="return validate()" id="form">
					<h2>Travel Application</h2>
					<div>
						<label>Select Customer :</label> <select name="customerId">
							<c:forEach var="customer" items="${ customers}">
								<option value="${customer.customerId}">${customer.customerName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="source">Source Name:</label> <input type="text"
							class="form-control item" name="source" id="source"><span>${alert}</span>
					</div>
					<div class="form-group">
						<label for="destination">Destination Name:</label> <input
							type="text" class="form-control item" name="destination"
							id="destination">
					</div>
					<div class="form-group">
						<label>Date Of Journey</label> <input type="date"
							class="form-control" name="dateOfJourney" id="dateOfJourney"><span>${alert}</span>
					</div>
					<div class="form-group">
						<label for="distance">Distance :</label> <input type="number"
							class="form-control item" name="distance" id="distance">
					</div>
					<div class="form-group">
						<div class="radio">
							<label>Food Preferance :</label><label></label> <label><input
								type="radio" name="foodType" id="foodType" value="Veg">Veg</label>
							<label><input type="radio" name="foodType" id="foodType"
								value="Non-Veg">Non-Veg</label>
							<!-- <span id="rad2" class="text-danger font-weight-bold"></span> -->
						</div>
					</div>
					<div class="travel">
						<label>Traveling with :</label>
						<div class="form-check">
							<label><input type="checkbox" value="Visa"
								id="travelType" name="travelType">Visa</label>
						</div>
						<div class="form-check">
							<label><input type="checkbox" value="Passport"
								id="travelType" name="travelType">Passport</label>
						</div>
					</div>

					<div>
						<button type="submit" class="btn-success create button">Register</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/">Back</a><br>
					</div>

				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
	<script>
		$.validator.addMethod("dateOfJourney", function(value, element) {
			var curDate = new Date();
			var inputDate = new Date(value);
			if (inputDate > curDate)
				return true;
			return false;
		}, "Invalid Date!");
		$.validator.addMethod("alphabetsnspace", function(value, element) {
			return this.optional(element) || /^[a-zA-Z ]*$/.test(value);
		});
		$('form').validate({

			rules : {
				source : {
					required : true,
					alphabetsnspace : true,
				},
				destination : {
					required : true,
					alphabetsnspace : true,
				},
				dateOfJourney : {
					required : true,
					expiryDate : true
				},
				distance : {
					required : true,
					range : [ 200, 10000 ]
				},
				foodType : {
					required : true
				},
				travelType : {
					required : true
				}

			},
			errorPlacement : function(error, element) {
				if (element.is(":radio")) {
					error.appendTo(element.parents('.form-group'))
				} else if (element.is(":checkbox")) {
					error.appendTo(element.parents('.travel'))
				} else {
					error.insertAfter(element);
				}
			}

		});
	</script>
</body>
</html>