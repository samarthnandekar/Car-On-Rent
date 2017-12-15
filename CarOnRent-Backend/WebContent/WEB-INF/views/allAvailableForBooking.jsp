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
  th{
background-color:#62f442;
}
  </style>
	
	
</head>
<body>

<div class="container-fluid">
<h1>  	Car on rent   </h1>

         <h1>All Available cars Details</h1>    
 
         
</div>

<div class="container">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="#section1">Filters</a></li>
        <li><a href="#section2">Hotel Star</a>
        <form role="form">
    		<div class="checkbox">
      		<label><input type="checkbox" value="Compact" onchange="filterHotelsonStar()" class="chk">
      		 Compact </label>
   		 </div>
   		 <div class="checkbox">
   			   <label><input type="checkbox" value="Economy" onchange="filterHotelsonStar()" class="chk">
   			   <span class="glyphicon glyphicon-star">
      		 Economy </label>
   			   </label>
   		 </div>
   		 <div class="checkbox">
    		  <label><input type="checkbox" value="Intermediate" onchange="filterHotelsonStar()" class="chk">
      		 Intermediate </label>
    		  </label>
    	</div>
    	
    	<div class="checkbox">
    		  <label><input type="checkbox" value="Standard" onchange="filterHotelsonStar()" class="chk">
      		 Standard </label>
    		  </label>
    	</div>
    	<div class="checkbox">
    		  <label><input type="checkbox" value="Full-Size" onchange="filterHotelsonStar()" class="chk">
      		 Full-Size </label>
    		  </label>
    	</div>
        
        </li>
        
      </ul><br>
      
    </div>
			<div id="maindiv1">
			            

<table class="table table-bordered">

                            <thead>

                                <tr class="tableheader">
                                    <th class="col-md-1">Car Image</th>
                                	<th class="col-md-1">Available From</th>
                                    <th class="col-md-1">Time</th>
                                    <th class="col-md-1">Avail TO</th>
                                    <th class="col-md-1">Avail Time</th>
                                    <th class="col-md-1">Car Company Name</th>
                                    <th class="col-md-1">Model Name</th>
                                    <th class="col-md-1">Car Type</th>
                                     <th class="col-md-1">doors</th>
                                      <th class="col-md-1">passengers</th>
                                       <th class="col-md-1">Car facility</th>
                                        <th class="col-md-1">Car full tank capacity</th>
                                    <th class="col-md-1">Action</th>
                                    
                                    </tr>  
                             </thead>
                             <tbody>
						
						 <c:forEach var="carAvail" items="${requestScope.allAvailCars}">
							  <tr>
							   
							   <td>${carAvail.availableDateFrom}</td>
							   <td>${carAvail.availableTimeFrom}</td>
							   
							   <td>${carAvail.availableDateTo}</td>
							   <td>${carAvail.availableTimeTo}</td>
							   
							   <td>${carAvail.userCar.carDetails.carMaker}</td>
							   <td>${carAvail.userCar.carDetails.carModel}</td>
							   
							   <td>${carAvail.userCar.carDetails.carType}</td>
							   <td>${carAvail.userCar.carDetails.doors}</td>
							   <td>${carAvail.userCar.carDetails.passengers}</td>
							   
							   <td>${carAvail.userCar.carDetails.fuelTankCapacity}</td>
							   <form action="reservationConfirmation.htm" method="post" role="form" >
							   
							   <input type="hidden" value=${carAvail.masterAvailabilityID} name="selectedCArVail" />
							   <td><button class="btn btn-lg btn-success btn-block signup-btn" type="submit"> Reserve</button></td>
							   </form>  
							   
                               </tr>
							  
						</c:forEach>  
  </tbody>
			
			</div>
			
		</div>
</div>
</div>
<script>
	
function filterHotelsonStar() {
	//alert("s");
	
	
	var chkArray = [];
	$(document).ready(function(){
	$(".chk:checked").each(function() {
		chkArray.push($(this).val());
	});
	});
	
	var selected;
	selected = chkArray.join(',');
	//alert(selected);
	var inputValue="selectedType="+selected;
	
	$.ajax({
		type: 'Post',
	    url: 'getCarFilteredValueByType.htm',
	    data:inputValue,
	    success: function (response) {
	    	var responseFromSev=JSON.parse(response); 
	    	debugger;
	    	if(responseFromSev.isValid!=true)
	    		{
	    		$("#anyError").html("User Name is already registered");
	    		}
	       
	    },
	    error: function () {
	        //your error code
	        alert("sasas");
	    }
	});
	
}
	
	</script>
</body>
</html>
