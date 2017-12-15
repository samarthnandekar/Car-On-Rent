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
            <form action="account.htm" method="post" role="form" >
              <legend>Enter Bank details</legend>
                    
                    <input type="text" name="bankName" class="form-control input-lg" placeholder="bank Name" /></br>
                    <input type="text" name="accountHolderName" class="form-control input-lg" placeholder="accountHolderName" /></br>
                                     
                    <input type="text" name="accounttype" class="form-control input-lg" placeholder="accounttype" /></br>
                    <input type="text" name="accountNumber" class="form-control input-lg" placeholder="accountNumber" /></br>
                     
                    <input type="text" name="routingNumber" class="form-control input-lg" placeholder="routingNumber"  />
                    
     				</br>
     				
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit"> Sign In</button>
            </form>          
          </div>
</div>            
</div>
</body>
</html>
