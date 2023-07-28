<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>
    	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload Test</title>
</head>
<body>

	<h3>폼 데이터와 파일 전송</h3>
	<form action="file-upload" method="post" enctype="multipart/form-data">
		DATA 1 : <input type="text" name="data1"><br>
		DATA 2 : <input type="text" name="data2"><br>
		<!-- FILE 1 : <input type="file" name="attach" accept="image/*" multiple><br> -->
		FILE 1 : <input type="file" name="attach"><br>
		<!-- FILE 2 : <input type="file" name="attach2"><br> -->
		<input type="submit" value="전송">
	</form>

</body>
</html>