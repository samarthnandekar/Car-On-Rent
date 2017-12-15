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
                                	<th class="col-md-1">Car Details</th>
                                    </tr>
                             </thead>
                             <tbody>
						
						 <c:forEach var="userCar" items="${requestScope.userCars}">
							  <tr>
							   
							   <td class="carInfoHeader">${userCar.carCompanyName}</td>
							   <td class="carInfoHeader">${userCar.carModel}</td>
							   <td class="carInfoHeader">${userCar.carNumner}</td>
                               </tr>
                               
                               <tr>
                               <td class="availHeader">Avail From Date</td>
                               <td class="availHeader">avail from time</td>
                               <td class="availHeader">avail to date</td>
                               <td class="availHeader">avail to time</td>
                               <td class="availHeader">hour rate</td>
                               <td class="availHeader">Day rate</td>
                               
                               </tr>
                                <c:forEach var="availability" items="${userCar.availabilities}">
                                <tr>
                                <td>${availability.availableFrom}</td>
							   <td>${availability.availableFromTime}</td>
							   <td>${availability.availableTo}</td> 
							   <td>${availability.availableToTime}</td>
							   <td>${availability.hoursRate}</td>
							   <td>${availability.dayRates}</td>
							   
                               </tr>
                                
                                </c:forEach>
							  
						</c:forEach>  
  </tbody>
  </table>
</body>
</html>