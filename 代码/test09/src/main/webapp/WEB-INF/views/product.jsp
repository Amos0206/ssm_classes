<%--
  Created by IntelliJ IDEA.
  User: zhch2
  Date: 2021/11/30
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商品管理</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="stylesheet" href="../static/layui/css/layui.css">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-4">
            <input type="text" class="form-control" id="pName" placeholder="商品名称">
        </div>
        <div class="col-xs-4">
            <input type="text" class="form-control" id="pPrice" placeholder="最低价格">
        </div>
        <div class="col-xs-1">
            <button type="button" class="btn btn-info" onclick="query()">查询</button>
        </div>
        <div class="col-xs-1">
            <button type="button" class="btn btn-danger" onclick="batch_del()">批量删除</button>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <table class="table table-bordered">
                <tr>
                    <th>商品id</th>
                    <th>名称</th>
                    <th>价格</th>
                    <th>描述</th>
                    <th>图片</th>
                    <th>创建时间</th>
                    <th>操作</th>
                </tr>

                <c:forEach items="${productList}" var="item" varStatus="s">
                <tr>
                    <td>
                        <input type="checkbox" name="test" value="${item.id}">
                            <%--${item.id}--%>
                    </td>
                    <td>${item.name}</td>
                    <td>${item.price}</td>
                    <td>${item.detail}</td>
                        <%--                    <td>${item.pic}</td>--%>
                    <td>
                        <img src="../images/${item.pic}" width="80px" height="80px">
                    </td>
                    <td>
                            <%--                        ${item.createTime}--%>
                        <fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm"/>
                    </td>
                    <td>
                        <button type="button" class="btn btn-success" onclick="upItem('${item.id}')">修改</button>
                        <button type="button" class="btn btn-danger" onclick="del(${item.id})">删除</button>
                    </td>
                <tr>
                    </c:forEach>
            </table>
        </div>
    </div>

    <%--s-修改模态框--%>
    <!-- Modal -->
    <div class="modal fade" id="proUpModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel1">修改</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <input type="hidden" value="" id="pid">
                        <div class="form-group">
                            <label for="product_name" class="col-sm-2 control-label">商品名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="product_name"  value="" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product_price" class="col-sm-2 control-label">价格</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="product_price"  value="" placeholder="密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="product_desc" class="col-sm-2 control-label">描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="product_desc"  value="" placeholder="描述">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="updateItem()">修改</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"
        integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
        crossorigin="anonymous"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
<script src="../../static/layui/layui.js"></script>
<script type="text/javascript">
    var layer;
    layui.use('layer', function () {
        layer = layui.layer;
    })

    /*删除*/
    function del(id) {
        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath}/item/del/' + id,
            dataType: 'json',
            success: function (data) {
                if (data.code == 1000) {
                    layer.confirm("删除成功", {
                        title: "提示",
                        icon: 1
                    }, function (index) {
                        window.location.href = "${pageContext.request.contextPath}/item/index"
                    })
                } else {
                    layer.open({
                        title: '提示'
                        , content: "删除失败!"
                        , icon: 2
                    });
                }
            }
        })
    }

    /*数据回填*/
    function upItem(id){
        $.ajax({
            type:'get',
            url:'${pageContext.request.contextPath}/item/query?id='+id,
            dataType:'json',
            success: function (data){
                if(data.code == 1000){
                    $("#proUpModal").modal({
                        backdrop: "static"
                    });
                    $("#pid").val(id)
                    $("#product_name").val(data.data.name);
                    $("#product_price").val(data.data.price);
                    $("#product_desc").val(data.data.detail);
                }
            }
        })

    }
    /*编辑修改*/
    function updateItem(){
        var id  = $("#pid").val();
        var name = $("#product_name").val();
        var price  = $("#product_price").val();
        var desc = $("#product_desc").val();
        console.log(name+''+price+''+desc)
        $.ajax({
            type:'get',
            url:'${pageContext.request.contextPath}/item/update',
            dataType:'json',
            data:{
                'id':id,
                'name':name,
                'price':price,
                'detail':desc
            },
            success:function (data){
                console.log(data)
                if (data.code == 1000) {
                    layer.confirm("修改成功", {
                        title: "提示",
                        icon: 1
                    }, function (index) {
                        window.location.href = "${pageContext.request.contextPath}/item/index"
                    })
                } else {
                    layer.open({
                        title: '提示'
                        , content: "修改失败!"
                        , icon: 2
                    });
                }
            }

        })
    }

    /*多条件查询*/
    function query(){
        var name = $("#pName").val();
        var price = $("#pPrice").val();
        var map = {
            'name':name,
            'price':price
        };
        console.log(map);
        // console.log(data)
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/item/queryByMany',
            dataType:'json',
            data:map,
            success: function (data){
                console.log(data)
                if(data.code == 1000){
                    lay.msg("多条件查询成功!")
                }else{
                    layer.msg('没有符合条件的数据')
                }
            }
        });
    }



    /*批量删除*/
    function batch_del() {
        var arr = [];
        $('input[name="test"]:checked').each(function () {
            arr.push($(this).val());
        });
        // console.log(pids)
        var pids = arr.join(',');
        console.log(typeof (pids))
        console.log(pids)
        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath}/item/batch_del',
            dataType: 'json',
            data:{
                pids:pids
            },
            success:function (data){
                if (data.code == 1000) {
                    layer.confirm("删除成功", {
                        title: "提示",
                        icon: 1
                    }, function (index) {
                        window.location.href = "${pageContext.request.contextPath}/item/index"
                    })
                } else {
                    layer.open({
                        title: '提示'
                        , content: "删除失败!"
                        , icon: 2
                    });
                }
            }
        })
    }
</script>
</body>
</html>
