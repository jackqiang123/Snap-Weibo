

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<meta content = 'text/html; charset=UTF-8; http-equiv="refresh"; content=3; url=index.jsp'>
	<title>Register Successful</title>
  </head>
  
    <body background="http://static.wixstatic.com/media/a97014d3cac6454b822f786b7d1f2878.jpg_srz_p_1920_1064_85_22_0.50_1.20_0.00_jpg_srz">
  <%response.setHeader("Refresh","3;url=index.jsp");%> 
		<div style="z-index:1000; position:absolute; top:20%; left:50%; margin: 0 0 0 -190px;">
        <div style="margin-left: auto;margin-right: auto;width: 300px;text-align: center;background-color: rgba(50,50,50,0.6);padding: 60px 40px;position: relative;">
    				<div>Member ${param.username} successfully register</div>
    				<div>Redirect to login page in 3 second automatically</div>
    				<a href='index.jsp'> Login Page</a>
  			 </div>
    	  	</div>
       
  </body>
</html>
