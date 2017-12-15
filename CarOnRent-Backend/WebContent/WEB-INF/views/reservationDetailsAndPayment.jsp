<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.2.1/backbone-min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/json2/20160511/json2.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.8.24/themes/base/jquery-ui.css">

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.availHeader
{
background-color:#f4cb42;
}
th{
background-color:#62f442;
}
.carInfoHeader
{
background-color:#42f4ee;
}

</style>
</head>
<body>
<div class="container-fluid"> 
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
                            <form action="payAndfinalBooking.htm" method="post" role="form" >
              <legend>Payment Information</legend>
                    
                    <input type="text" name="cardNo" class="form-control input-lg" placeholder="Card Number" /></br>
                    <input type="text" name="bankName" class="form-control input-lg" placeholder="Bank Name" /></br>
                                     
                    <input type="text" name="expdate" class="form-control input-lg" placeholder="expdate" /></br>
                    <input type="text" name="cardHolderName" class="form-control input-lg" placeholder="cardHolderName" /></br>
                     
                    <input type="text" name="Amount" class="form-control input-lg" placeholder="enterAmount" />
                    <input type="text" name="bookingEmailID" class="form-control input-lg" placeholder="bookingEmailID" />    
                    <input type="text" name="reservationMemo" class="form-control input-lg" placeholder="Memo" />
     				</br>	
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">Confirm Payment</button>
            </form>  
                            
                            
                            
                              
                               
  </tbody>
  </table>
</body>
</html>