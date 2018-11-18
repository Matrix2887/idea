<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

</head>
<body>

    <h3>盛利利照片上传</h3>

    <form action="/login/fileuploadOther" method="post" enctype="multipart/form-data">
        选择盛利照片:<input type="file" name="upload"/><br/>
        <input type="submit" value="上传">
    </form>

</body>
</html>