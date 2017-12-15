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
            <form action="carParkingaddress.htm" method="post" role="form" >
              <legend>Enter you current Address</legend>
                    
                    <input type="text" name="streetName" class="form-control input-lg" placeholder="streetName" /></br>
                    <input type="text" name="city" class="form-control input-lg" placeholder="city" /></br>
                                     
                    <input type="text" name="state" class="form-control input-lg" placeholder="state" /></br>
                    <input type="text" name="country" class="form-control input-lg" placeholder="country" /></br>
                     
                    <input type="text" name="zipcode" class="form-control input-lg" placeholder="zipcode"  />
                    
     				</br>
     				
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit"> Sign In</button>
            </form>          
          </div>
</div>            
</div>
</body>
</html>
