<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>backend</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstarp/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/bootstarp/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/userSetting.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
<div class="panel panel-default" id="userInfo" id="homeSet">
    <div class="panel-heading">
        <h3 class="panel-title">用户管理</h3>
    </div>
    <div class="panel-body">
        <div class="showusersearch">
            <form class="form-inline">
                <div class="form-group">
                    <label for="exampleInputName2">姓名:</label>
                    <input type="text" class="form-control" id="userName" placeholder="请输入姓名">
                </div>
                <div class="form-group">
                    <label for="exampleInputName2">帐号:</label>
                    <input type="text" class="form-control" id="loginName" placeholder="请输入帐号">
                </div>
                <div class="form-group">
                    <label for="exampleInputName2">电话:</label>
                    <input type="text" class="form-control" id="phone" placeholder="请输入电话">
                </div>
                <div class="form-group">
                    <label for="exampleInputName2">地址:</label>
                    <input type="text" class="form-control" id="address" placeholder="请输入地址">
                </div>
                <div class="form-group">
                    <label for="exampleInputName2">状态</label>
                    <select class="form-control" name="isValid">
                        <option value="-1">全部</option>
                        <option value="1">---有效---</option>
                        <option value="0">---无效---</option>
                    </select>
                </div>
                <input type="button" value="查询" class="btn btn-primary" id="doSearch">
            </form>
        </div>

        <div class="show-list" style="position: relative;top: 30px;">
            <table class="table table-bordered table-hover" style='text-align: center;'>
                <thead>
                <tr class="text-danger">
                    <th class="text-center">序号</th>
                    <th class="text-center">姓名</th>
                    <th class="text-center">帐号</th>
                    <th class="text-center">电话</th>
                    <th class="text-center">地址</th>
                    <th class="text-center">状态</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="tb">
                <tr>
                    <td>1</td>
                    <td>admin</td>
                    <td>admin</td>
                    <td>15996868058</td>
                    <td>江苏南京</td>
                    <td>有效</td>
                    <td class="text-center">
                        <input type="button" class="btn btn-warning btn-sm doModify" value="修改">
                        <input type="button" class="btn btn-danger btn-sm doDisable" value="禁用">
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>admin2</td>
                    <td>admin2</td>
                    <td>15996868058</td>
                    <td>江苏南京</td>
                    <td>无效</td>
                    <td class="text-center">
                        <input type="button" class="btn btn-warning btn-sm doModify" value="修改">
                        <input type="button" class="btn btn-success btn-sm doDisable" value="禁用">
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="modal fade" tabindex="-1" id="myModal">
            <!-- 窗口声明 -->
            <div class="modal-dialog modal-lg">
                <!-- 内容声明 -->
                <div class="modal-content">
                    <!-- 头部、主体、脚注 -->
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">用户修改</h4>
                    </div>
                    <div class="modal-body text-center">
                        <div class="row text-right">
                            <label for="N" class="col-sm-4 control-label">编号：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="N">
                            </div>
                        </div>
                        <br>
                        <div class="row text-right">
                            <label for="username" class="col-sm-4 control-label">姓名：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="username">
                            </div>
                        </div>
                        <br>
                        <div class="row text-right">
                            <label for="loginName" class="col-sm-4 control-label">帐号：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="loginName">
                            </div>
                        </div>
                        <br>
                        <div class="row text-right">
                            <label for="phone" class="col-sm-4 control-label">电话：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="phone">
                            </div>
                        </div>
                        <br>
                        <div class="row text-right">
                            <label for="adrees" class="col-sm-4 control-label">地址：</label>
                            <div class="col-sm-4">
                                <input type="email" class="form-control" id="adrees">
                            </div>
                        </div>
                        <br>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-warning updateOne">修改</button>
                        <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
