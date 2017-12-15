<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
th{
background-color:#62f442;
}
</style>
</head>
<body>

<div class="container-fluid"> 
  <table class="table table-bordered">

                            <thead>

                                <tr class="tableheader">
                                	<th class="col-md-1">Available From</th>
                                    <th class="col-md-1">Avail Time</th>
                                    <th class="col-md-1">Avail TO</th>
                                    <th class="col-md-1">Avail Time</th>
                                    <th class="col-md-1">Total time</th>
                                    <th class="col-md-1">Reservation Cost</th>
                                    <th class="col-md-1">Booking Date</th>
                                    <th class="col-md-1">Booking Status</th>
                                    <th class="col-md-1">car parking address</th>
                                    <th class="col-md-1">Action</th>
                                    </tr>
                                    
                             </thead>
                             <tbody>
						
						 <c:forEach var="userReservation" items="${requestScope.usereservationsList}">
							  <tr>
							   
							   <td>${userReservation.reservationStartDate}</td>
							   <td>${userReservation.reservationStartTime}</td>
							   
							   <td>${userReservation.reservationEndDate}</td>
							   <td>${userReservation.reservationEndTime}</td>
							   <td>${userReservation.totalTimereverVationTime}</td>
							   
							   <td>${userReservation.totalReservationCost}</td>
							   <td>${userReservation.bookingDate}</td>
							   <td>${userReservation.bookingStatus}</td>
							   <td>${userReservation.carParkingaddress.streetName}</td>
							   <form action="cancelReservation.htm" method="post" role="form" >
                               <input type="hidden" value=${userReservation.usercarReservationID} name="selectedReservation" />
							   <td><button class="btn btn-lg btn-success btn-block signup-btn" type="submit"> Cancel</button></td>
							   </form> 
                               </tr>
							  
						</c:forEach>  
  </tbody>
  </table>
  
</body>
</html>