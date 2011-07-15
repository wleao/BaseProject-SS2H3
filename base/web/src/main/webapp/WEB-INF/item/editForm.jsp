<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Edit Item</title>
</head>
<body>
 
<p>Edit Item</p>
 
<s:form name="editForm" method="post" action="editItem.action">
 
	<s:textfield name="name" label="Name" value="%{name}" />
	<s:textfield name="description" value="%{description}" />
 
	<s:submit type="button" name="Update" />
 
</s:form>
 
</body>
</html>