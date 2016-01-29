<%@page pageEncoding="UTF-8"
	import="java.util.*, java.text.*, model.Blah"%>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>
<html>
<head>
<meta content='text/html;charset=UTF-8' http-equiv='content-type'>
<title>Snap Weibo</title>
<link rel='stylesheet' href='css/member.css' type='text/css'>
</head>
<body
	background="http://static.wixstatic.com/media/a97014d3cac6454b822f786b7d1f2878.jpg_srz_p_1920_1064_85_22_0.50_1.20_0.00_jpg_srz">
	<div class='leftPanel'>
		<img
			src='http://www2.psd100.com/ppp/2013/11/0601/user-icon-1106042328.png'
			alt='Weibo' height="80" width="80" /> <br> <br>
	
			<a href = 'javascript:void(0);'>
				<div class="sign-up-btn"	; style="margin-right: 10px;margin-top: 10px; text-align: center"; onclick="location = 'snapmessage.do'">	
					Read New Posts
				</div>
			</a>
		<a href='logout.do?username="${ sessionScope.login }'>
			<div class="sign-up-btn"	; style="margin-right: 10px;margin-top: 10px; text-align: center">
				Logout ${ sessionScope.login }</div>
		</a>



	</div>
	<form method='post' action='message.do'>
		<br>
		<%
			String blabla = (String) request.getAttribute("blabla");
			if (blabla != null) {
		%>


		Messages is limited to 140 chars<br>
		<%
			}
		%>


		<textarea cols='60' rows='4' name='blabla'> ${requestScope.blabla}</textarea>
		<br>
		<button type='submit'>Post My News</button>

	</form>

	<table style='text-align: left; width: 510px; height: 88px;' border='0'
		cellpadding='2' cellspacing='2'>
		<thead>
			<tr>
				<th><hr></th>
			</tr>
		</thead>
		<tbody>


			<%
		
				List<Blah> blahs = (List<Blah>) request.getAttribute("blahs");

				{
					for (Blah blah : blahs) {
			%>


			<tr>
				<td style='vertical-align: top;'> 
				
				<div style = "font-size:12px;font-family:sans serif; color = #FF0000"> Post Time: <%=new Date(blah.getDate().getTime()).toString()%> </div>
				<br>
				<div style = "font-size:14px; ">
					 <%=blah.getTxt()%>
				</div>
					<br> 
				 	
					<a
					href='delete.do?message=<%=blah.getDate().getTime()%>'>
						<div class="del-btn" style = "text-align: center">
							Delete
						</div>
					</a>
					<hr>
				</td>
			</tr>

			<%
				}
				}
			%>



		</tbody>
	</table>
	<hr style='width: 100%; height: 1px;'>
</body>
</html>
