<%--
  Created by IntelliJ IDEA.
  User: zhch2
  Date: 2021/12/4
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户管理</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <link rel="stylesheet" href="../../static/layui/css/layui.css">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
</head>
<body>
    <div style="width:1000px;margin: 100px auto">
        <h2>客户管理</h2>
        <button type="button" class="btn btn-primary" onclick="showAddModel()">添加</button>
        <table class="table table-bordered" style="width: 900px;">
            <tr>
                <th>编号</th>
                <th>客户名</th>
                <th>客户职业</th>
                <th>联系方式</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${customers}" var="customer" varStatus="s">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.username}</td>
                    <td>${customer.jobs}</td>
                    <td>${customer.phone}</td>
                    <td>
                        <button type="button" class="btn btn-success" onclick="edit('${customer.id}')">修改</button>
                        <button type="button" class="btn btn-danger delBtn" onclick="del('${customer.id}')">删除</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <%--s-添加模态框--%>
        <!--Modal -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加客户</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">客户名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="username" value="" placeholder="客户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="job" class="col-sm-2 control-label">职业</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="job" value="" placeholder="职业">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">手机号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone" value="" placeholder="手机号">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="save()">保存</button>
                </div>
            </div>
        </div>
    </div>
    <%--e-添加模态框--%>


    <%--s-修改模态框--%>
    <!-- Modal -->
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel1">修改</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <input type="hidden" value="" id="cid">
                        <div class="form-group">
                            <label for="username1" class="col-sm-2 control-label">客户名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="username1" value="" placeholder="客户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="job1" class="col-sm-2 control-label">职业</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="job1" value="" placeholder="职业">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone1" class="col-sm-2 control-label">手机号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="phone1" value="" placeholder="手机号">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="update()">修改</button>
                </div>
            </div>
        </div>
    </div>
    </div>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"
            integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
            crossorigin="anonymous"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
            integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
            crossorigin="anonymous"></script>
    <script type="text/javascript" src="../../static/layui/layui.js"></script>
    <script type="text/javascript">
        function showAddModel(){
            $("#addModal").modal({
                backdrop:'static'
            })
        }
        /*添加*/
        function save(){
            var username = $("#username").val();
            var jobs   = $("#job").val();
            var phone = $("#phone").val();
            $.ajax({
                type:'post',
                url: '${pageContext.request.contextPath}/customer/save',
                dataType:'json',
                data:{
                    'username':username,
                    'jobs':jobs,
                    'phone':phone,
                },
                success: function (data){
                    console.log(data)
                    if(data.code===1000){
                        window.location.href = "${pageContext.request.contextPath}/customer/index"
                    }else{
                        layer.msg("添加失败!")
                    }
                }
            })
        }

        /*删除*/
        function del(id){
            layer.confirm("确定删除?",{
                title:'提示',
                icon:5,
            },function (index){
                $.ajax({
                    type: 'get',
                    url:'${pageContext.request.contextPath}/customer/del?id='+id,
                    dataType: 'json',
                    success:function (data){
                        if(data.code===1000){
                            layer.msg("删除成功!")
                            window.location.href = "${pageContext.request.contextPath}/customer/index"
                        }else{
                            layer.msg("删除失败!")
                        }
                    }
                })
            });
        }

        /*数据回填*/
        function edit(id){
            $.ajax({
                type:'get',
                url:'${pageContext.request.contextPath}/customer/queryById?id='+id,
                dataType:'json',
                success:function (data){
                    if(data.code===1000){
                        $("#editModal").modal({
                            backdrop:'static'
                        });
                        $("#cid").val(id);
                        $("#username1").val(data.data.username)
                        $("#job1").val(data.data.jobs)
                        $("#phone1").val(data.data.phone)
                    }
                }
            })
        }

        /*修改*/
        function update(){
            var id = $("#cid").val();
            var username = $("#username1").val();
            var job = $("#job1").val();
            var phone = $("#phone1").val();
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/customer/update',
                data:{
                    'id':id,
                    'username':username,
                    'jobs':job,
                    'phone':phone
                },
                success:function(data){
                    if(data.code ===1000){
                        layer.msg("修改成功!")
                        window.location.href = "${pageContext.request.contextPath}/customer/index"
                    }else{
                        layer.msg("修改失败!")
                    }
                }
            })
        }
    </script>
    </body>
</html>
