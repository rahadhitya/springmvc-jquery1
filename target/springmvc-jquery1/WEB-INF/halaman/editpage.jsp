<%@include file="taglib_includes.jsp" %>

<html>
<head>
    <title>Template &middot; Bootstrap &middot; Sign In</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" type="text/css" media="screen" />
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-responsive.css" />" type="text/css" media="screen" />
    
    
    <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/jquery-1.9.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.10.3.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>
    
	<script type="text/javascript" src="js/contacts.js"></script>
	
	<style type="text/css">
		body {
			font-family : Calibri;
			font-size : smaller;
		}
		h3 {
			font-size : 12px;
		}
	</style>
</head>
<body>
<div class="container">
<table bgcolor="red" border-collapse="collapse"	border="1"	bordercolor="#006699" style="width:750;height:500;align: center;">
	<tr>
		<td align="center"><h3>Edit Contact Form</h3></td>
	</tr>
  <tr valign="top" align="center">
    <td align="center">
 		<form:form commandName="editpage" method="POST" action="edit">
				<table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">					
					
					<tr>
						<td width="100" align="right">ID</td>
						<td>
						<form:input path="departmentID"/></td>
						<td align="left">
						<form:errors path="departmentID" cssStyle="color:red"></form:errors> 
						</td>
					</tr>
					
					<tr>
						<td width="100" align="right">Description</td>
						<td width="150">
						<form:input path="description" readonly="true"/></td>
						<td align="left">
						<form:errors path="description" cssStyle="color:red"></form:errors>  </td>
					</tr>
					
					<tr>
						<td width="100" align="right">Title</td>
						<td><form:input path="title"/></td>
						<td align="left"><form:errors path="title" cssStyle="color:red"></form:errors>  </td>
					</tr>
					
					<tr valign="bottom">
						<td colspan="3" align="center">
						<input type="button"  value="Delete" onclick="javascript:deleteContact('deleteContact.do?id=${editContact.id}');">
						&nbsp;&nbsp;
						<input type="submit" name="" value="Save">						
						&nbsp;&nbsp;
						<input type="button"  value="Back" onclick="javascript:go('viewAllContacts.do');">
						</td>
					</tr>
					
				</table>				
		</form:form>
    </td>    
  </tr>
</table>

</div>
</body>
</html>
