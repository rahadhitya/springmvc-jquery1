<%@include file="taglib_includes.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="title" /></title>
<title>Template &middot; Bootstrap &middot; Sign In</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css" />" type="text/css" media="screen" />
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap-responsive.css" />" type="text/css" media="screen" />
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/jquery-ui-1.10.3.css" />"></link>
    
    <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/jquery-1.9.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/jquery-ui-1.10.3.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/bootstrap/js/bootstrap.js" />"></script>	

</head>
<body>
<div class="container">
<div class="container-fluid">
<h1>Department</h1>

<c:url var="addUrl" value="/persons/add" />
<table>
	<thead>
		<tr>
			<th>title</th>
			<th>description</th>
			<th colspan="2"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${persons}" var="person">
			<c:url var="editUrl" value="/persons/edit?id=${person.departmentID}" />
			<c:url var="deleteUrl" value="/persons/delete?id=${person.departmentID}" />
		
		<tr>
			<td><c:out value="${person.title}" /></td>
			<td><c:out value="${person.description}" /></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
			<td><a href="${addUrl}">Add</a></td>
    		<td><a href="#" onclick="getDepartment('${person.title}', '${person.description}')">modal dialog</a></td>
		</tr>

	</c:forEach>
	</tbody>
</table>

<c:if test="${empty persons}">
	There are currently no persons in the list. <a href="${addUrl}">Add</a> a person.
</c:if>

	<div id="BusinessBill" style="display:none;">
    	<h2>Department Details</h2>
    	<em>Department Database</em>
    	<div class="row">
        	<span class="spanAsLabel">Title</span>
        	<span id="dlg-title" class="spanAsLabel"></span>
    	</div>
    	<div class="row">
        	<span class="spanAsLabel">Description</span>
        	<span id="dlg-desc" class="spanAsLabel"></span>
    	</div>
	</div>
	
	<div id="my-modal-div" style="display:none;">
            <span class="spanAsLabel">Description</span>
        </div>
	
	<button id="click-for-modal">modal else</button>
	
	<script type="text/javascript">
	
	$(function(){
		  $('#click-for-modal').click(function(){
		    $('#my-modal-div').dialog();
		  });
		});
	
    function getDepartment(title, description) {

    $.post("/MVCStandard/department", {
        tit: title,
        desc: description
    }, function (data) {

        /* You can implement more validations for 'data', in my case I just used these 'if' conditionals but can vary. */

        if(data != null) { //returned 'data' is not 'null'

            /* parse 'data' as 'json' object
             * will be good to console.log(data) and take a look. */
            var obj = $.parseJSON(data);

            if(obj != {}) { //check if 'data' is not an empty 'json' object once transformed

               //set the 'data' in the dialog
               $('#dlg-title').text(obj.title);
               $('#dlg-desc').text(obj.description);

               /* open modal dialog, you can simulate it this way (for this case)
                * but the correct way is to use 'jquery-ui' dialog or any plugin you prefer.
                * At this point you will see the hidden 'div' in a visible way with your 'data'.
                */
                
                $( "#BusinessBill" ).dialog({
                    height: 300,
                    width: 350,
                    modal: true,
                    buttons: {
                                            "Ok": function() { 
                                                $(this).dialog("close"); 
                                            }, 
                                            "Cancel": function() { 
                                                $(this).dialog("close"); 
                                            } 
                                        }
                    });
               /* $('#BusinessBill').fadeIn(); */ /*  dialog();*/
            } else {
               //show 'generic' message
               alert('No results found.');
            }
        } else {
           //show 'generic' message
           alert('An error occurred, try again.');
        }
    });

    }
    
    
     </script>

</div>
</div>
</body>
</html>