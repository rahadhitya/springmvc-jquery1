<%@include file="taglib_includes.jsp" %>
<html>
<head>
 <meta charset="utf-8" />
<title>jQuery UI Dialog - Basic modal</title>
 <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/jquery-ui-1.10.3.css" />"></link>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/jquery-1.9.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/bootstrap/js/jquery-ui-1.10.3.js" />"></script>
<script>
$(function() {
$( "#dialog-modal" ).dialog({
height: 140,
modal: true
});
});
</script>
</head>
<body>
<div id="dialog-modal" title="Basic modal dialog">
<p>Adding the modal overlay screen makes the dialog look more prominent because it dims out the page content.</p>
</div>
<p>Sed vel diam id libero <a href="http://example.com">rutrum convallis</a>. Donec aliquet leo vel magna. Phasellus rhoncus faucibus ante. Etiam bibendum, enim faucibus aliquet rhoncus, arcu felis ultricies neque, sit amet auctor elit eros a lectus.</p>
</body>
</html>