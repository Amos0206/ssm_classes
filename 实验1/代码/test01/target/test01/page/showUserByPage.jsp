<%@ page import="java.util.List" %>
<%@ page import="com.zc.domain.User" %>
<%@ page import="com.zc.utils.PageInfo" %><%--
  Created by IntelliJ IDEA.
  User: zhch2
  Date: 2021/11/2
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户数据分页列表</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <link rel="stylesheet" href="../static/layui/css/layui.css">

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

</head>
<body>
<%
    //获取分页的所有数据
    PageInfo<User> pageInfo = (PageInfo<User>)request.getAttribute("pageInfo");
    List<User> list = pageInfo.getList();
//    out.print(list);
    request.setAttribute("userPageList",list);
    request.setAttribute("pageNum",request.getParameter("pageNum"));
    request.setAttribute("count",pageInfo.getCount());
    request.setAttribute("pageCount",pageInfo.getPageCount());
%>
<div style="width:1000px;margin: 100px auto">
    <button type="button" class="btn btn-primary" onclick="showAddModel()">添加</button>
    <table class="table table-bordered" style="width: 900px;">
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>生日</th>
            <th>性别</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${userPageList}" var="user" varStatus="s">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.birthday}</td>
                <td>${user.sex}</td>
                <td>
                    <button type="button" class="btn btn-success" onclick="upUser('${user.id}')">修改</button>
                    <button type="button" class="btn btn-danger delBtn" onclick="delUser('${user.id}')">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        <span>共${pageCount}页</span>
        <a href="${pageContext.request.contextPath}/pageList.user?pageNum=1">首页</a>
        <a href="${pageContext.request.contextPath}/pageList.user?pageNum=${pageNum-1<=1?1:pageNum-1}">上一页</a>
        <a href="${pageContext.request.contextPath}/pageList.user?pageNum=${pageNum+1>=pageCount?pageCount:pageNum+1}">下一页</a>
        <a href="${pageContext.request.contextPath}/pageList.user?pageNum=${pageCount}">末页</a>
    </div>

    <%--s-添加模态框--%>
    <!-- Modal -->
    <div class="modal fade" id="proAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加用户</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="username" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="username"  value="" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="password"  value="" placeholder="密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday" class="col-sm-2 control-label">生日</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="birthday"  value="" placeholder="格式如2020-01-02">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sex" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="sex"  value="" placeholder="性别">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="addUser()">保存</button>
                </div>
            </div>
        </div>
    </div>
    <%--e-添加模态框--%>


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
                        <input type="hidden" value="" id="uid">
                        <div class="form-group">
                            <label for="username1" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="username1"  value="" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password1" class="col-sm-2 control-label">密码</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="password1"  value="" placeholder="密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="birthday1" class="col-sm-2 control-label">生日</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="birthday1"  value="" placeholder="格式如2020-01-02">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sex" class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" id="sex1"  value="sex" placeholder="性别">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="updateUser()">修改</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="../static/layui/layui.js"></script>
<script type="text/javascript">
    var layer;
    layui.use('layer',function(){
        layer = layui.layer;
    });

    /*展示商品添加model*/
    function showAddModel() {
        $("#proAddModal").modal({
            backdrop: "static"
        })
    }

    /*添加*/
    function addUser(){
        var username = $("#username").val();
        var password = $("#password").val();
        var birthday = $("#birthday").val();
        var sex  = $("#sex").val();

        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath}/add.user',
            dataType: 'json',
            data:{
                'username':username,
                'password':password,
                'birthday':birthday,
                'sex':sex,
            },
            success:function (data){
                if(data.code==1000){
                    layer.confirm("添加成功",{
                        title:"提示",
                        icon:1
                    },function(index){
                        window.location.href="${pageContext.request.contextPath}/pageList.user"
                    })
                }else{
                    layer.open({
                        title: '提示'
                        ,content: "添加失败!"
                        ,icon:2});
                }
            }
        })
    }

    /**
     * 根据id编号删除数据
     * @param id
     */
    function delUser(id){
        $.ajax({
            url:'${pageContext.request.contextPath}/del.user?id='+id,
            type:'get',
            dataType:'json',
            success:function (data){
                console.log(data)
                if(data.code==1000){
                    layer.confirm("删除成功",{
                        title:"提示",
                        icon:1
                    },function(index){
                        window.location.href="${pageContext.request.contextPath}/pageList.user"
                    })
                }else{
                    layer.open({
                        title: '提示'
                        ,content: "删除失败!"
                        ,icon:2});
                }
            }
        })
    }

    /*展示商品修改数据回填模态框*/
    function upUser(id){
        $.ajax({
            url:'${pageContext.request.contextPath}/listByUid.user',
            type:'get',
            data:{
                'id':id,
            },
            dataType:'json',
            success:function (data){
                console.log(data)
                if(data.code==1000){
                    $("#proUpModal").modal({
                        backdrop: "static"
                    });
                    console.log(data.data.username)
                    $("#uid").val(data.data.id);
                    $("#username1").val(data.data.username);
                    $("#password1").val(data.data.password);
                    $("#birthday1").val(data.data.birthday);
                    $("#sex1").val(data.data.sex);
                }
            }
        })
    }
    function updateUser(){
        var id =$("#uid").val();
        var username = $("#username1").val();
        var password = $("#password1").val();
        var birthday = $("#birthday1").val();
        var sex  = $("#sex1").val();
        // console.log(username)
        // console.log(password)
        // console.log(birthday)
        // console.log(sex)
        $.ajax({
            type: 'get',
            url: '${pageContext.request.contextPath}/update.user',
            dataType: 'json',
            data:{
                'id':id,
                'username':username,
                'password':password,
                'birthday':birthday,
                'sex':sex,
            },
            success:function (data){
                if(data.code==1000){
                    layer.confirm("修改成功",{
                        title:"提示",
                        icon:1
                    },function(index){
                        window.location.href="${pageContext.request.contextPath}/pageList.user"
                    })
                }else{
                    layer.open({
                        title: '提示'
                        ,content: "修改失败!"
                        ,icon:2});
                }
            }
        })
    }

</script>
</html>
