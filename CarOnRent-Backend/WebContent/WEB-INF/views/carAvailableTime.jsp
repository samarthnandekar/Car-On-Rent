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
  
  
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
	<style>
  
  .container
  {
  	background-color:#f2f2f2;
  }
  </style>
	<script>
  $( function() {
    $("#availableFromDate").datepicker();
  } );
  
  $( function() {
	    $("#availableToDate").datepicker();
	  } );
  </script>
	
</head>
<body>

<div class="container">
<h1>  	Car on rent   </h1>
</br></br></br></br></br>

	  <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="availableTime.htm" method="post" role="form" >
              <legend>Enter the Time to post car</legend>
                    
                    <input type="text" name="availableFromDate" class="form-control input-lg" id="availableFromDate" placeholder="availableFrom Date" /></br>
                    <input type="text" name="availableFromTime" class="form-control input-lg" placeholder="availableFrom Time" /></br>
                    
                    <input type="text" name="availableToDate" class="form-control input-lg" id="availableToDate" placeholder="availableTo Date" /></br>
                    <input type="text" name="availableToTime" class="form-control input-lg" placeholder="availableto time" /></br>
                                     
                    <input type="text" name="hoursRate" class="form-control input-lg" placeholder="hoursRate" /></br>
                    <input type="text" name="dayRates" class="form-control input-lg" placeholder="dayRates" /></br>
                     
                    <input type="text" name="zipcode" class="form-control input-lg" placeholder="zipcode"  />
                    
     				</br>
     				<input type="hidden" name="carID" value="${requestScope.carID}"/>
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit"> Save availability</button>
            </form>          
          </div>
</div>            
</div>
</body>
</html>
