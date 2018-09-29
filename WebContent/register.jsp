<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Register</title>
<style type="text/css">
.button-register {background-color: green;color: white;}
.button-report {background-color: #000000;color: white;margin-left: 30%;}
</style>
</head>
<body>
	<h2>Struts 2 Create, Read, Update and Delete (CRUD) Example using JDBC</h2>
	<a href="report"><button class="button-report" type="button">Report</button></a>
	<s:form action="register" method="post">
		<s:textfield label="Full Name" name="uname" />
		<s:textfield label="Email" name="uemail" />
		<s:password label="Password" name="upass" />
		<s:select label="Designation"
			headerValue="Select Your Designation"
			headerKey="-1" 
			list="#{'Sa':'S', 'Te':'T', 'Ud':'U'}"
			name="udeg">
		</s:select>
		<s:submit cssClass="button-register" value="Resgister" />
	</s:form>
	
	<a href="exchange"><button type="button" class="button-register">Exchange</button></a>
	
	<s:if test="ctr>0">
		<span style="color: green;"><s:property value="msg" /></span>
	</s:if>
	<s:else>
		<span style="color: red;"><s:property value="msg" /></span>
	</s:else>
</body>
</html>