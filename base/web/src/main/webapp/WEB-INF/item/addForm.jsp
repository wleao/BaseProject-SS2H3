<%@ taglib prefix="s" uri="/struts-tags"%>
 
<html>
<head>
<title>Add Item</title>
</head>
<body>
 
<p>Add Item</p>
 
<s:form name="addForm" method="post" action="addItem.action">
 
	<s:textfield name="name" label="Name" />
	<s:textfield name="description" label="Description" />
 
	<s:submit type="button" name="Add" />
 
</s:form>
 
</body>
</html>