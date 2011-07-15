<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<html>
<head>
<title>Item List</title>
<sx:head debug="true" cache="false" compressed="false" />
</head>
<body>

	<p>Item List</p>
	<div>

		<s:url id="addItem" value="addItemForm.action">
		</s:url>
		<s:a href="%{addItem}">Add</s:a>

	</div>
	<s:if test="items.size > 0">
		<table id="items">
			<s:iterator value="items">
				<tr>
					<td><s:property value="id" />
					</td>				
					<td><s:property value="name" />
					</td>
					<td><s:property value="description" />
					</td>
					<td>
						<s:url id="deleteItem" value="deleteItem.action">
							<s:param name="id" value="id" />
						</s:url> 
						<s:a href="%{deleteItem}">Delete</s:a>
					</td>
					<td>
						<s:url id="editItem" value="editItemForm.action">
							<s:param name="id" value="id" />
							<s:param name="name" value="name" />
							<s:param name="description" value="description" />
						</s:url> 
						<s:a href="%{editItem}">Edit</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:if>

</body>
</html>