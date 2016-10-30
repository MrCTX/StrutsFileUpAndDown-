<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="file" uri="file"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功界面</title>
</head>
<body>
恭喜您，上传文件成功，本次上传文件数量:<s:property value="photo.length"/><br>
文件属性如下(单击即可下载):<br>
<file:showAllFiles/>
</body>
</html>