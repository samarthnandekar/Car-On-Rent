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
            <form action="registercar.htm" method="post" role="form" >
              <legend>Enter your car details</legend>
                    
                    <input type="text" name="carCompanyName" class="form-control input-lg" placeholder="carCompanyName"/>
                    
                    <input type="text" name="carModel" class="form-control input-lg" placeholder="car Model Name"/>
                    
                  Car CompanyName:  <select name="makerName" id="carCompanyName">
                    <option name="" value="select">Select</option>
                    
                    </select>
                    </br>
                    Car Model Name:  <select name="carModelName" id="carModelName">
                    <option value="select">Select</option>
                    
                    </select></br>
                                     
                    <input type="text" name="carNumner" class="form-control input-lg" placeholder="carNumner" /></br>
                    <input type="text" name="carimageName" class="form-control input-lg" placeholder="carimageName" /></br>
                     
                    <input type="text" name="carDescription" class="form-control input-lg" placeholder="carDescription"  /></br>
                    
                    <input type="text" name="purchaseYear" class="form-control input-lg" placeholder="purchaseYear"  /></br>
                    <input type="text" name="autoGear" class="form-control input-lg" placeholder="autoGear"  /></br>
                    <input type="text" name="carAverage" class="form-control input-lg" placeholder="carAverage"  /></br>
                    
     				</br>
     				
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit"> save car</button>
            </form>          
          </div>
</div>            
</div>
<script>
alert("sam");
	$.ajax({
		type: 'Post',
	    url: 'carMakersList.htm',
	    async:false,
	    success: function (response) {
	    	alert(response);
	    	debugger;
	    	var carMakers=$.parseJSON(response);
	    	var selectID=$("#carCompanyName");
	    	var carMakerNames=carMakers.resultsortedMap;
	    	carMakerNames.forEach(function( index, value ) {
	    		  
	    		var option = $('<option/>');
	    		option.attr({ 'value': index }).text(index);
	    		selectID.append(option);
	    		});
	       
	    },
	    error: function () {
	        //your error code
	        alert(" error");
	        
	    }
	}); 
	
	$("#carCompanyName").change(function() {
		
		
		var selectedValue=$(this).val();
		var makerValue="makerName="+selectedValue;
		
		if(selectedValue != 'Select')
			{
			$.ajax({
				type: 'Post',
			    url: 'carModelsList.htm',
			    date:makerValue,
			    async:false,
			    success: function (response) {
			    	alert(response);
			    	debugger;
			    	var carModels=$.parseJSON(response);
			    	var selectID=$("#carModelName");
			    	var carModelNames=carModels.resultsortedMap;
			    	carModelNames.forEach(function( index, value ) {
			    		  
			    		var option = $('<option/>');
			    		option.attr({ 'value': index }).text(index);
			    		selectID.append(option);
			    		});
			       
			    },
			    error: function () {
			        //your error code
			        alert(" error");
			        
			    }
			}); 
			}
		
		});
	
	
	
	</script>
</body>
</html>
