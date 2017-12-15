<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<!-- 
<script src="resources/jQuery/jquery.min.js" />
<script src="resources/jQuery/jquery-ui.min.js" />
<script src="resources/backBonejs/backbonemin.js" />
<script src="resources/backBonejs/underscoremin.js" />
<script src="resources/backBonejs/handlerbars.min.js" />
<script src="resources/backBonejs/json2.min.js" />

-->

 
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
  
  
<!-- <script src="resources/js/yourRegisteredcar.js" /> -->

<script>
debugger;



debugger;
var a="sa";

</script>
<script id="configTest" type="text/x">

<table>
  <tr>
    <th>Company</th>
    <th>Contact</th>
    <th>Country</th>
  </tr>
  <tr>
    <td>Alfreds Futterkiste</td>
    <td>Maria Anders</td>
    <td>Germany</td>
  </tr>
  <tr>
    <td>Centro comercial Moctezuma</td>
    <td>Francisco Chang</td>
    <td>Mexico</td>
  </tr>
  <tr>
    <td>Ernst Handel</td>
    <td>Roland Mendel</td>
    <td>Austria</td>
  </tr>
  <tr>
    <td>Island Trading</td>
    <td>Helen Bennett</td>
    <td>UK</td>
  </tr>
  <tr>
    <td>Laughing Bacchus Winecellars</td>
    <td>Yoshi Tannamuri</td>
    <td>Canada</td>
  </tr>
  <tr>
    <td>Magazzini Alimentari Riuniti</td>
    <td>Giovanni Rovelli</td>
    <td>Italy</td>
  </tr>
</table>

</script>

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
                                	<th class="col-md-1">Car Company Name</th>
                                    <th class="col-md-1">Model</th>
                                    <th class="col-md-1">Car Number</th>
                                    <th class="col-md-1">Car Image</th>
                                    <th class="col-md-1">car Description</th>
                                    <th class="col-md-1">Purchase year</th>
                                    <th class="col-md-1">auto gear</th>
                                    <th class="col-md-1">Car agverage</th>  
                                    <th>Post availability</th>
                                    <th>view all post</th>
                                    <th>delete </th>
                                    </tr>
                                    
                             </thead>
                             <tbody>
						<c:if test="${requestScope.isUsercarReg!=false}">
						 <c:forEach var="userCar" items="${requestScope.userRegistercar}">
							  <tr>
							   
							   <td>${userCar.carCompanyName}</td>
							   <td>${userCar.carModel}</td>
							   
							   <td>${userCar.carNumner}</td>
							   <td>${userCar.carimageName}</td>
							   <td>${userCar.carDescription}</td>
							   
							   <td>${userCar.purchaseYear}</td>
							   <td>${userCar.autoGear}</td>
							   <td>${userCar.carAverage}</td>
							   <td><a href="postavailableTime.htm?carID=${userCar.userCarID}"><span class=""></span>Post availability</a></td>
                               <td><a href="aCarviewallPost.htm?carID=${userCar.userCarID}"><span class=""></span>View Post</a></td>
                               <td>delete</td>
                               </tr>
							  
						</c:forEach>  
						</c:if>
						
  </tbody>
  <c:if test="${requestScope.isUsercarReg==false}">
  <h1>No Car registered</h1>
  </c:if>
  </table>
  
  
  <form action="addnewCar.htm" method="POST" role="form">
  
<div class="col-md-3"><button type="submit" class="btn btn-lg btn-info">Add new car</button></div>
  
  </form>
  </div>
</body>
</html>