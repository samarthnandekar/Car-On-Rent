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
  .errorword
  {
  color:red;
  font-size: 18px;
  }
  </style>
	
	
</head>
<body>

<div class="container">
<h1>  	Car on rent   </h1>
</br></br></br></br></br>

	  <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="senduserNamepassword.htm" method="post" role="form" >
              <legend>Enter the registered email id for password</legend>
                    
                    <input type="text" name="emailId" class="form-control input-lg" placeholder="Email ID" /></br>
                   
     				</br>
     				 <p class="successMsg">${requestScope.isValid}</p>
     				<p class="errorMsg">${requestScope.isValid}</p>
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit"> Submit</button>
            </form>          
          </div>
</div>            
</div>
</body>
</html>
