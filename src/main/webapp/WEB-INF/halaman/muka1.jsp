<%@include file="taglib_includes.jsp" %>

<html>
<head>
	<title>AntarMuka</title>
</head>


<body>
	<h3>Welcome to Spring MVC ${serverTime}</h3>

	<div align="center"><br/>
		<div style="width: 320px;" align="center"><br/><br/>
		Login with "admin" - "admin"
		<br/><br/>
		</div>
	</div>
	
	<table  bgcolor="lightblue" width="250" height="110" align="center" 
		style="border-collapse: collapse;" border="1" bordercolor="#006699" >
		<tr><td align="center"><h3>Insert your ID</h3></td></tr>
  		<tr valign="top" align="center">
    		<td align="center">
								
		<form method="post" action="add" >
			<table width="200" style="border-collapse: collapse;" border="0" 
							bordercolor="#006699" cellspacing="2" cellpadding="2">
			<tr>
				<td>
					UserName :
				</td>
				<td>
					<input type="text" style="width: 185px;font:Tahoma;" 
                                              maxlength="30" name="name" id="name" />
				</td>
			</tr>
			<tr>
				<td>
					Password :
				</td>
				<td>
					<input type="text" style="width: 185px;" 
                                            maxlength="30" name="password" id="password" />
				</td>
			</tr>
		</table>
			<a href="<c:url value="/department" />">Login</a>
			<!--  <input type="submit" class="save" title="Login" value="login" /> -->
		</form>
    	</td>    
  	</tr>
</table>
</body>
</html>