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
            <form action="carParkingaddress.htm" method="post" role="form" >
              <legend>Congratulations , you reservation is confirmed</legend>
                 <table class="table table-bordered">

                            <thead>

                                <tr class="tableheader">
                                	<th class="col-md-1">Reservation Details</th>
                                    </tr>
                             </thead>
                             <tbody>       
                               <tr>
                               <td class="availHeader">Car Maker</td>
                               <td>${requestScope.usercarReservation.userCar.carCompanyName}</td>
                               </tr>
                               
                                <tr>
                               <td class="availHeader">Car Model</td>
                               <td>${requestScope.usercarReservation.userCar.carModel}</td>
                               </tr>
                               
                                <tr>
                               <td class="availHeader">Car Type</td>
                               <td>${requestScope.usercarReservation.userCar.carDetails.carType}</td>
                               </tr>
                               <tr>
                               <td class="availHeader">Car Number</td>
                               <td>${requestScope.usercarReservation.userCar.carNumner}</td>
                               </tr>
                               
                                <tr>
                               <td class="availHeader">Booking Start Date</td>
                               <td>${requestScope.usercarReservation.reservationStartDate}</td>
                               </tr>
                               
                                <tr>
                               <td class="availHeader">Booking Start Time</td>
                               <td>${requestScope.usercarReservation.reservationStartTime}</td>
                               </tr>
                               
                                <tr>
                               <td class="availHeader">Booking End Date</td>
                               <td>${requestScope.usercarReservation.reservationEndDate}</td>
                               </tr>
                               
                                <tr>
                               <td class="availHeader">Booking end Time</td>
                               <td>${requestScope.usercarReservation.reservationEndTime}</td>
                               </tr>
                               <tr>
                               <td class="availHeader">Total Booking Hours</td>
                               <td>${requestScope.usercarReservation.totalTimereverVationTime}</td>
                               </tr>
                               
                               <tr>
                               <td class="availHeader">Total Cost</td>
                               <td>${requestScope.usercarReservation.totalReservationCost}</td>
                               </tr>
                               
                               <tr>
                               <td class="availHeader">Booking Rate</td>
                               <td>${requestScope.usercarReservation.rate}</td>
                               </tr>
                    
                    
                  			   <tr>
                               <td class="availHeader">parking address 1</td>
                               <td>${requestScope.usercarReservation.carParkingaddress.streetName}</td>
                               </tr>
                               
                               <tr>
                               <td class="availHeader">parking address 2</td>
                               <td>${requestScope.usercarReservation.carParkingaddress.city}</td>
                               </tr>
                               
                               <tr>
                               <td class="availHeader">parking address 3</td>
                               <td>${requestScope.usercarReservation.carParkingaddress.state}</td>
                               </tr>
  </tbody>
  </table>    
                   
            </form>          
          </div>
</div>            
</div>
</body>
</html>
