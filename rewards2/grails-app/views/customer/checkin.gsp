<!doctype html>
<html>

<head>
	<title>Kiosk</title>
	<link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.min.css')}" type="text/css">
	<asset:javascript src="respond.js"></asset:javascript>
</head>

<body>
	<g:form url="[resource:customerInstance, action:'customerLookup']" >
			<g:render template="kioskForm"/>
	</g:form>
	
	
	<g:javascript library="jquery"/>
	<asset:javascript src="bootstrap.min.js"></asset:javascript>
</body>
</html>