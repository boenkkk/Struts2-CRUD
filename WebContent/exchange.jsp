<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Exchange</title>
</head>
<body>

	<div class="table-responsive">										
	  	<table id="dttable" class="display" width="100%">
			<thead>
			<tr>
				<th>ID</th>
				<th>SUBJECT</th>
				<th>To</th>
				<th>Cc</th>
				<th>Body</th>
				<th>Action</th>
			</tr>
			</thead>
			<tbody>												
			<s:iterator value="listEmail">
				<tr>
					<td><s:property value="id"/></td>
					<td><s:property value="subject"/></td>
					<td><s:property value="to"/></td>
					<td><s:property value="cc"/></td>
					<td><s:property value="body"/></td>
					<td width="10%">
						<button type="button" id="btnUpd" class="btn btn-success" data-toggle="modal" data-target="#modalUpd">Update</button>
						<a href="hapusJudulSummary.action?id=<s:property value="Id"/>"><button type="button" class="btn btn-danger">Delete</button></a>
					</td>
				</tr>
			</s:iterator>
			</tbody>
	  	</table>
	</div>
	
</body>
</html>