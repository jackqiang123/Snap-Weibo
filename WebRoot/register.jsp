<%@page pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Snap Weibo Register</title>
        <link rel="stylesheet" href="css/index.css" type="text/css">
    </head>
    <body background="http://static.wixstatic.com/media/a97014d3cac6454b822f786b7d1f2878.jpg_srz_p_1920_1064_85_22_0.50_1.20_0.00_jpg_srz">
         <div style="z-index: 1000;position: absolute;top:20%;left :50%;margin: 0 0 0 -190px;

">
        <div style="margin-left: auto;margin-right: auto;width: 300px;text-align: center;background-color: rgba(50,50,50,0.6);padding: 60px 40px;position: relative;">
            
             <div style="margin-top: 5px;margin-bottom: 20px;color:#ccc;font-size: 14px;font-weight: 600;">
        Input Registration Information
    
    </div> 
    
<%
    List<String> errors = (List<String>) request.getAttribute("errors");
    if(errors != null) {
%>
        <div style='color: rgb(255, 0, 0);'>
        

        <%= errors.get(0) %>

        </div><br>
<%                
    }
%>   
            <div style="display: block;height: 340px;margin-bottom: 10px;">
        <form action="register.do" method="post" id="login_form"> 
            <div style="float: left;">
                 <div style="width: 290px;float: left;line-height: 37px;text-align: left;padding-left: 5px;   font-family: Helvetica, STHeiti;
    font-size: 12px;">User name: </div>
                <input class="login-input all-radius" type="text" name="username" placeholder="2-12  Characters " value="fag">
            </div>
            <div style="float: left;">
                <div style="width: 290px;float: left;line-height: 37px;text-align: left;padding-left: 5px;   font-family: Helvetica, STHeiti;
    font-size: 12px;">Password: </div>
                <input class="login-input all-radius" type="password" name="password" placeholder="">
            </div>
            <div style="float: left;">
 			<div style="width: 290px;float: left;line-height: 37px;text-align: left;padding-left: 5px;   font-family: Helvetica, STHeiti;
    				font-size: 12px;">Re-enter Password: </div>
                <input class="login-input all-radius" type="password" name="confirmedPasswd" placeholder="">
            </div>
            <div style="float: left">
                <div style="width: 290px;float: left;line-height: 37px;text-align: left;padding-left: 5px;   font-family: Helvetica, STHeiti;
    font-size: 12px;">Email: </div>
                <input class="login-input all-radius" type="text" name="email" placeholder=" Used for Verification " value="g">
            </div>
            <div onclick="document.getElementById('login_form').submit()" type="submit" class="login-in-btn" style="margin-top: 20px;float: left;">
                Register
            </div>
        </form>
	</div>
        
        
        </div>
</div>
        
    </body>
</html>