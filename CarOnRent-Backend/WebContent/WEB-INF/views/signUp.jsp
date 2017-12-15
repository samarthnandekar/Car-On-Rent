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
            <form action="signup.htm" method="post" role="form" >
              <legend>Enter the details for Sign up</legend>
                    
                    <input type="text" name="fName" class="form-control input-lg" placeholder="first Name" /></br>
                    <input type="text" name="lName" class="form-control input-lg" placeholder="Last Name" /></br>
                    
                     <input type="text" name="license" class="form-control input-lg" placeholder="License Number"  />
                                  
                    <input type="text" name="eMailId" id="eMailId" class="form-control input-lg" placeholder="Your Email" onkeyup="myFunction()"/></br>
                    <input type="text" name="cNumber" class="form-control input-lg" placeholder="contact Number" /></br>
                     
                    <input type="password" name="userPassword" class="form-control input-lg" placeholder="Password"  />
                    <div id="anyError"></div>
                    <p class="errorword">${requestScope.isValid}</p>
     				</br>
     				<a href="forgetUserName.htm">Forget userName/password</a>
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit"> Sign Up</button>
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
