<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>backend</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstarp/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nmms.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/bootstarp/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/userSetting.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap-paginator.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">

        let options = {
            bootstrapMajorVersion: 3, // 指定bootstrap版本号,3之前不需要指定
            currentPage: "${pageTypes.pageNum == 0 ? 1 : pageTypes.pageNum}", // 当前页
            totalPages: "${pageTypes.pages == 0 ? 1 : pageTypes.pages}", // 总页数
            size:"normal",
            alignment: "center",
            pageUrl:function(type,page,current){
                return "${pageContext.request.contextPath}/productType/findAllType?pageNo="+page;
            }
        };
        $("#productTypePage").bootstrapPaginator(options);

        let res = null;
        $(function () {
            if(res==null){
                res = $.ajax({
                    type: "post",
                    url:"${pageContext.request.contextPath}/productType/findAllType",
                    // data: {"pageNo": res.data.pageNum,"pageSize": res.data.pageSize},
                    dataType: "json",
                    success:function(results){
                        res = results;
                        loadJson(results.data.list);
                    }});
            }else {
                res = $.ajax({
                    type: "post",
                    url:"${pageContext.request.contextPath}/productType/findAllType",
                    data: {"pageNo": res.data.pageNum,"pageSize": res.data.pageSize},
                    dataType: "json",
                    success:function(results){
                        res = results;
                        loadJson(results.data.list);
                    }});
            }

        });

        function addProductType() {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/productType/addProductType",
                data: {"name": $("#productTypeName").val()},
                dataType: "json",
                success: function (result) {
                    if (result.code == 2001) {
                        window.location.reload();
                    } else {
                        $("#errorMsg").tooltip({
                            title: "error",
                            placement: "center",
                            template: "<div class='tooltip errorMsg'>" + result.message + "</div>",
                            tigger: "manual"
                        }).tooltip("show");
                    }
                }
            });
        }

        function loadJson(results) {
            $.each(results, function (index, result) {
                index+=1;
                let statusTxt = "启用";
                let statusCss ="btn-danger";
                let statusButton ="禁用";
                if(result.status==1){
                    statusTxt = "禁用";
                    statusCss = "btn-success";
                    statusButton ="启用";
                }
                let tr = $('<tr></tr>').append($('<td>'+index+'</td>'))
                    .append($('<td>'+result.name+'</td>'))
                    .append($('<td>'+statusTxt+'</td>'))
                    .append($('<td class="text-center">'+
                        '<input type="button" onclick="doProTypeModify('+result.id+','+index+')" class="btn btn-warning btn-sm" value="修改">' +
                        '<input type="button" onclick="doProTypeDisable('+result.id+','+result.status+')" class="btn '+statusCss+' btn-sm" value='+statusButton+'>'+'</td>'))
                    .append($('<td>'+"<input type='hidden' value='+result.id+'>"+'</td>'));

                $("#tb").append(tr);
            });
        }
        function doProTypeModify(id,index) {
            $("#myProductType").modal("show");
            $("#hiddeId").val(id);
            $("#proTypeNum").val(index);
            $("#alterProductType").click(function () {
                let params = $("#productTypeForm").serializeArray();
                $.post("${pageContext.request.contextPath}/productType/alterProductType",
                    params,function (results) {
                        window.location.reload();
                    })
            });
        }
        function doProTypeDisable(id,status) {
            if(status==0)
                status=1;
            else
                status =0;
            $.ajax({
                url:"${pageContext.request.contextPath}/productType/alterProductTypeStatus?id="+id+"&status="+status,
                success:function (results) {
                    window.location.reload();
                }
            });
        }

    </script>
</head>

<body>
<div class="panel panel-default" id="userSet">
    <div class="panel-heading">
        <h3 class="panel-title">商品类型管理&nbsp;<span id="errorMsg"></span></h3>
    </div>
    <div class="panel-body">
        <input type="button" value="添加商品类型" class="btn btn-primary" id="doAddProTpye">
        <div class="modal fade" tabindex="-1" id="ProductType">
            <!-- 窗口声明 -->
            <div class="modal-dialog modal-lg">
                <!-- 内容声明 -->
                <div class="modal-content">
                    <!-- 头部、主体、脚注 -->
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">添加商品类型信息</h4>
                    </div>
                    <div class="modal-body text-center">
                        <div class="row text-right">
                            <label for="productTypeName" class="col-sm-4 control-label">类型名称：</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="productTypeName" name="name">
                            </div>
                        </div>
                        <br>
                    </div>
                    <div class="modal-footer">
                        <button onclick="addProductType()" class="btn btn-primary addProductType">添加</button>
                        <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
        <div class="show-list">
            <table id="tb2" class="table table-bordered table-hover" style='text-align: center;'>
                <thead>
                <tr class="text-danger">
                    <th class="text-center">编号</th>
                    <th class="text-center">类型名称</th>
                    <th class="text-center">状态</th>
                    <th class="text-center">操作</th>
                </tr>
                </thead>
                <tbody id="tb"></tbody>
            </table>
            <ul id="productTypePage"></ul>
        </div>
        <div class="modal fade" tabindex="-1" id="myProductType">
            <!-- 窗口声明 -->
            <div class="modal-dialog modal-lg">
                <!-- 内容声明 -->
                <div class="modal-content">
                    <!-- 头部、主体、脚注 -->
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">商品修改</h4>
                    </div>
                    <form id="productTypeForm">
                        <div class="modal-body text-center">
                            <div class="row text-right">
                                <label for="proTypeNum" class="col-sm-4 control-label">编号：</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control" id="proTypeNum" readonly="true">
                                </div>
                            </div>
                            <input type="hidden" id="hiddeId" name="id" >
                            <br>
                            <div class="row text-right">
                                <label for="proTypeName" class="col-sm-4 control-label">类型名称</label>
                                <div class="col-sm-4">
                                    <input type="text" name="name" class="form-control" id="proTypeName">
                                </div>
                            </div>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button id="alterProductType" class="btn btn-warning updateProType">修改</button>
                        <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>