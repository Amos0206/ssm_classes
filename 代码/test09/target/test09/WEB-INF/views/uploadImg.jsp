<%--
  Created by IntelliJ IDEA.
  User: zhch2
  Date: 2021/12/2
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片上传</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
    <script>
        function picChange() {
            console.log(1)
            $("#picUpForm").ajaxSubmit({
                url: 'uploadFile',
                method: 'post',
                dataType: 'json',
                success: function (res) {
                    //res : {"picUrl":"/upload/6b516848-b215-447f-bf20-a05f7c5ba416.png"};根据需要json的图片路径
                    console.log(res)
                    var path = res.picUrl;
                    console.log(path)
                    $("#imgBox").attr('src', path);
                    $("#imgBox").css('width', '100px');
                    $("#imgBox").css('height', '100px');
                }
            })
        }
    </script>
</head>
<body>
<form action="" method="post" id="picUpForm">
    <p>图片：
        <input type="file" name="picFile" onchange="picChange()">
    </p>
    <p>
        <img id="imgBox">
    </p>
    <p>
        <input type="hidden" name="picUrl">
    </p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>