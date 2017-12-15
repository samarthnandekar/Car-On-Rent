<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
	<style>
  
  .container
  {
  	background-color:#f2f2f2;
  }
  </style>
	
	
</head>
<body>

<div class="container">
<h1>  	Car on rent   </h1>
</br></br></br></br></br>

	  <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="comfirmedPayReservation.htm" method="post" role="form" >
              <legend>Reservation Details</legend>
              <c:forEach var="availability" items="${requestScope.availabilityfromMaster}">
                    
                    <input type="text" name="carMaker" class="form-control input-lg" value=${availability.userCar.carDetails.carMaker}></br>
                    <input type="text" name="carModel" class="form-control input-lg" value=${availability.userCar.carDetails.carModel}></br>
                                     
                    <input type="text" name="carType" class="form-control input-lg" value=${availability.userCar.carDetails.carType}></br>
                     
                    <input type="text" name="availStartDate" class="form-control input-lg" value=${availability.availableDateFrom}>
                    <input type="text" name="availStartTime" class="form-control input-lg" value=${availability.availableTimeFrom}>
                    
                    <input type="text" name="endStartDate" class="form-control input-lg" value=${availability.availableDateTo}> 
                    <input type="text" name="endStartTime" class="form-control input-lg" value=${availability.availableTimeTo}>
                    
     				</br>
     				  <input type="hidden" value=${availability.masterAvailabilityID} name="selectedCArVail" />
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">Confirm And Payment</button>
                    </c:forEach>
            </form>          
          </div>
</div>            
</div>
</body>
</html>
