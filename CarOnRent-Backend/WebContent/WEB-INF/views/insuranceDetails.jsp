<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
            <form action="insurance.htm" method="post" role="form" >
              <legend>Enter the details for Sign up</legend>
                    
                    <input type="text" name="carOwnerName" class="form-control input-lg" placeholder="car Owner Name" /></br>
                    
                    <input type="text" name="insuranceCmpName" class="form-control input-lg" placeholder="insurance Cmp Name"  />
                    
                    <input type="text" name="carOwnerLicenseNo" class="form-control input-lg" placeholder="car Owner LicenseNo" /></br>
                    
                     <input type="text" name="policyNumber" class="form-control input-lg" placeholder="policy Number"  />
                                  
                    <input type="text" name="insuranceStartDate" id="insuranceStartDate" class="form-control input-lg" placeholder="insurance Start Date" /></br>
                    <input type="text" name="insuranceEndDate" class="form-control input-lg" placeholder="insurance End Date" /></br>
                     
                    
                    <div id="anyError"></div>
     				</br>
     				
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit"> Sign In</button>
            </form>          
          </div>
</div>            
</div>

<script>
function myFunction() {
   // alert("sa");
    debugger;
	var inputValue="inputValue="+$("#eMailId").val();
	
	$.ajax({
		type: 'Post',
	    url: 'forcheckCredential.htm',
	    data:inputValue,
	    success: function (response) {
	    	var responseFromSev=JSON.parse(response); 
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
