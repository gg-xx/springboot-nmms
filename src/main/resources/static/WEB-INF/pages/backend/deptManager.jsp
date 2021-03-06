<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>backend</title>
    <link rel="stylesheet" type="text/css" href="../bootstarp/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/index.css" />
    <script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script src="../bootstarp/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script src="../js/userSetting.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>

<!-- 部门管理 -->
<div class="panel panel-default" id="departmentSet">
    <div class="panel-heading">
        <h3 class="panel-title">部门管理</h3>
    </div>
    <div class="panel-body">
        <input type="button" value="添加部门" class="btn btn-primary" id="doAddDept">
        <br>
        <br>
        <div class="modal fade" tabindex="-1" id="Dept">
            <!-- 窗口声明 -->
            <div class="modal-dialog modal-lg">
                <!-- 内容声明 -->
                <div class="modal-content">
                    <!-- 头部、主体、脚注 -->
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">添加部门</h4>
                    </div>
                    <div class="modal-body text-center">
                        <div class="row text-right">
                            <label for="dept-name" class="col-sm-4 control-label">部门名称：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="dept-name">
                            </div>
                        </div>
                        <br>
                        <div class="row text-right">
                            <label for="dept-duty" class="col-sm-4 control-label">部门职能：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="dept-duty">
                            </div>
                        </div>
                        <br>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary addDept">添加</button>
                        <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- 添加子部门模态框 -->
        <div class="modal fade" tabindex="-1" id="sonDept">
            <!-- 窗口声明 -->
            <div class="modal-dialog modal-lg">
                <!-- 内容声明 -->
                <div class="modal-content">
                    <!-- 头部、主体、脚注 -->
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">添加子部门</h4>
                    </div>
                    <div class="modal-body text-center">
                        <div class="row text-right">
                            <label for="dept-name" class="col-sm-4 control-label">父部门名称：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="dept-name" value="市场部" readonly="readonly">
                            </div>
                        </div>
                        <br>
                        <div class="row text-right">
                            <label for="dept-name" class="col-sm-4 control-label">部门名称：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="dept-name">
                            </div>
                        </div>
                        <br>
                        <div class="row text-right">
                            <label for="dept-duty" class="col-sm-4 control-label">部门职能：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="dept-duty">
                            </div>
                        </div>
                        <br>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary addSonDept">添加</button>
                        <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>


        <!-- 修改部门模态框 -->
        <div class="modal fade" tabindex="-1" id="modifyDept">
            <!-- 窗口声明 -->
            <div class="modal-dialog modal-lg">
                <!-- 内容声明 -->
                <div class="modal-content">
                    <!-- 头部、主体、脚注 -->
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">修改部门</h4>
                    </div>
                    <div class="modal-body text-center">
                        <div class="row text-right">
                            <label for="dept-name" class="col-sm-4 control-label">id：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="dept-name" value="1" readonly="readonly">
                            </div>
                        </div>
                        <br>
                        <div class="row text-right">
                            <label for="dept-name" class="col-sm-4 control-label">部门名称：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="dept-name">
                            </div>
                        </div>
                        <br>
                        <div class="row text-right">
                            <label for="dept-duty" class="col-sm-4 control-label">部门职能：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="dept-duty">
                            </div>
                        </div>
                        <br>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary modifyDept">修改</button>
                        <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="show-list">
            <table class="table table-bordered table-hover" style='text-align: center;'>
                <thead>
                <tr class="text-danger">
                    <th class="text-center">序号</th>
                    <th class="text-center">部门编号</th>
                    <th class="text-center">部门名称</th>
                    <th class="text-center">部门职能</th>
                    <th class="text-center">所属部门</th>
                    <th class="text-center">部门状态</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="tb">
                <tr>
                    <td>1</td>
                    <td>BM20180114000001</td>
                    <td>市场部</td>
                    <td>管理市场</td>
                    <td>--</td>
                    <td>有效</td>
                    <td class="text-center">
                        <input type="button" class="btn btn-info btn-sm doAddSonDept" value="添加子部门">
                        <input type="button" class="btn btn-warning btn-sm doModifyDept" value="修改">
                        <input type="button" class="btn btn-danger btn-sm doDisable" value="禁用">
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>BM20180114000002</td>
                    <td>营销部</td>
                    <td>管理营销</td>
                    <td>市场部</td>
                    <td>无效</td>
                    <td class="text-center">
                        <input type="button" class="btn btn-info btn-sm doAddSonDept" value="添加子部门">
                        <input type="button" class="btn btn-warning btn-sm doModifyDept" value="修改">
                        <input type="button" class="btn btn-success btn-sm doDisable" value="启用">
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>