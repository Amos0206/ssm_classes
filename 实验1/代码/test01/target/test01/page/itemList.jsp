<%--
  Created by IntelliJ IDEA.
  User: zhch2
  Date: 2021/11/3
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"
            integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
            crossorigin="anonymous"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>
    <script type="text/javascript">
        function getCate() {
            $.ajax({
                type: 'get',
                url: "${pageContext.request.contextPath}/list.cate",
                dataType: 'json',
                success: function (data) {
                    // console.log(data)
                    if (data.code == 1000) {
                        for (var i = 0; i < data.data.length; i++) {
                            console.log(data.data[i].cateName)
                            $("#cate").append("<option value='" + data.data[i].cateName + "'>" + data.data[i].cateName + "</option>");
                        }
                    }
                }
            })
        }
    </script>
</head>
<body onload="getCate()">
<%--<%--%>
<%--    Object items = request.getAttribute("items");--%>
<%--    out.print(items);--%>
<%--%>--%>
<div class="container">
    <div class="row">
        <div class="col-xs-3"></div>
        <div class="col-xs-3">
            <select id="cate" class="form-control cateName"></select>
        </div>
        <div class="col-xs-6">
            <button type="button" class="btn btn-primary" onclick="query()">查询</button>
        </div>
    </div>
<%--    <c:if test="${items}!=null">--%>

    <div class="row">
        <div class="col-xs-12">
            <table class="table table-bordered">
                <tr>
                    <th>商品id</th>
                    <th>名称</th>
                    <th>价格</th>
                    <th>描述</th>
                    <th>图片</th>
                    <th>操作</th>
                </tr>

                <c:forEach items="${items}" var="item" varStatus="s">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.detail}</td>
                    <td>${item.pic}</td>
                    <td>
                        <button type="button" class="btn btn-success">修改</button>
                        <button type="button" class="btn btn-danger">删除</button>
                    </td>
                <tr>
                    </c:forEach>
            </table>
        </div>
<%--        </c:if>--%>
    </div>
</div>
<script type="text/javascript">
    function query() {
        var cname = $(".cateName").val();
        console.log(cname);
        window.location.href = "${pageContext.request.contextPath}/queryByName.item?name=" + cname;
    }
</script>
</body>
</html>
