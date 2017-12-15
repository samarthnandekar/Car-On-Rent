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
                                    <th class="col-md-1">Hours rate</th>
                                    <th class="col-md-1">day Rate</th>
                                    <th class="col-md-1"><a href="">cancel</a></th>
                                    
                                    </tr>
                                    
                             </thead>
                             <tbody>
						
						 <c:forEach var="carAvail" items="${requestScope.aCarAvailList}">
							  <tr>
							   
							   <td>${carAvail.availableFrom}</td>
							   <td>${carAvail.availableFromTime}</td>
							   
							   <td>${carAvail.availableTo}</td>
							   <td>${carAvail.availableToTime}</td>
							   <td>${carAvail.hoursRate}</td>
							   
							   <td>${carAvail.dayRates}</td>
                               <td>delete</td>
                               </tr>
							  
						</c:forEach>  
  </tbody>
  </table>
  
</body>
</html>