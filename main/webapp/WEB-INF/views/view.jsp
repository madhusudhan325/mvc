<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#customerStatus')
								.change(
										function() {
											var customerId = $(this).val();
											$
													.ajax({
														type : 'GET',
														url : window.location.origin
																+ '/rest/loadSourcesByCustomer/'
																+ customerId,
														success : function(
																result) {
															var s = '';
															for (var i = 0; i < result.length; i++) {
																s += '<option value="' +result[i].travelId+'">'
																		+ result[i].source
																		+ '</option>';
															}

															$('#travelStatus')
																	.html(s);
														}

													});

										});
					});
</script>
</head>
<body>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="container">
				<form action="/getdata" method="get" onsubmit="return validate()"
					id="form">
					<div>
						<label>Select Customer :</label> <select name="customerStatus"
							id="customerStatus" data-toggle="dropdown" style="width: 200px"
							size="1">
							<option value=" ">select Customer Name
								<c:forEach var="customer" items="${ customers}">
									<option value="${customer.customerId}">${customer.customerName}</option>
								</c:forEach>
						</select>
					</div>
					<br>
					<div>
						<label>Select Source :</label> <select name="travelStatus"
							id="travelStatus" data-toggle="dropdown" style="width: 200px"
							size="1">

						</select>
					</div>
					<br>
					<div>
						<button type="submit" class="btn-success create button">Submit</button>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
	<br>
	<c:if test="${travels!=null}">
		<table class="table-active" border="2" width="70%" cellpadding="2">
			<tr>
				<th class="table-success">SOURCE</th>
				<th class="table-warning">DESTINATION</th>
				<th class="table-primary">FOOD TYPE</th>
				<th class="table-danger">DATE OF JOURNEY</th>
				<th class="table-danger">UPDATE</th>

			</tr>
			<c:forEach var="branch" items="${travels}">
				<tr class="info">
					<td>${branch.source}</td>
					<td>${branch.destination}</td>
					<td>${branch.foodType}</td>
					<td>${branch.dateOfJourney}</td>
					<td><a href="/update/${branch.travelId}">Update</a>
				</tr>

			</c:forEach>
		</table>
	</c:if>
	<div>
		<a href="/">Back</a><br>
	</div>
</body>
</html>