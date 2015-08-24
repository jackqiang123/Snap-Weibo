<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Snap Weibo</title>
        <link rel="stylesheet" href="css/index.css" type="text/css">
    </head>
    <body background="http://static.wixstatic.com/media/a97014d3cac6454b822f786b7d1f2878.jpg_srz_p_1920_1064_85_22_0.50_1.20_0.00_jpg_srz">

	  
    <div style="z-index: 1000;position: absolute;top:20%;left :50%;margin: 0 0 0 -190px;">
        <div style="margin-left: auto;margin-right: auto;width: 300px;text-align: center;background-color: rgba(50,50,50,0.6);padding: 60px 40px;position: relative;">
        <div style="margin-top: 5px;margin-bottom: 20px;color:#ccc;font-size: 14px;font-weight: 600;">Snap Weibo</div>
	     
		<form action="login.do" id="login_form" method="post" style="font-size: 12px;"> 
		    <input name="username" type="text" placeholder="Username" style="width:300px;border-bottom: 1px solid rgb(227,227,227);" class="login-input top-radius" value="" required="">
		    <input name="password" type="password" style="width:300px;margin-bottom:20px;" class="login-input bottom-radius" placeholder="Password" value="" required="">
		   <div style="margin-left: 0px;margin-bottom: 5px;color:#ec3627">
		     
		        
		    </div>
		    <div class="login-in-btn" onclick="document.getElementById('login_form').submit()" style="margin-right: 10px;">
		        Login
		    </div>
		   	<a href = "register.jsp">
		    <div class="sign-up-btn" ; style="margin-right: 10px;margin-top: 10px;">
		        Create Your Snap Weibo Account
		    </div>
		    </a>
		
		    
		</form>

        
        </div>
    </div>


        
        
        
        
    </body>
</html>