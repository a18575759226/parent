<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- html <head>标签部分  -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>订单管理</title>
    <link rel="stylesheet" href="/js/bootstrap-3.3.2-dist/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="/css/core.css" type="text/css"/>
    <script type="text/javascript" src="/js/jquery/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="/js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/jquery.bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-validation/jquery.validate.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js" ></script>
    <script type="text/javascript">
        $(function () {

               $("#beginDate,#endDate").click(function() {
                    WdatePicker();
                });

            $('#pagination').twbsPagination({
               totalPages : ${pageResult.totalPage}||1,
               startPage : ${pageResult.currentPage},
                visiblePages : 5,
                    first : "首页",
                    prev : "上一页",
                    next : "下一页",
                    last : "最后一页",
                    onPageClick : function(event, page) {
                $("#currentPage").val(page);
                $("#searchForm").submit();
            }
        });
            //数据字典分组,选中目录将其的值通过qo,来查询出明细,所以用高级查询来提交表单
            $(".group_item").click(function () {
                $("#parentId").val($(this).data("dataid"));
                $("#currentPage").val(1);
                $("#searchForm").submit();
            })
            //选择在相应的目录下进行增加明细操作
            $("#addSystemDictionaryItemBtn").click(function () {
                if (parentId) {
                    $("#editForm")[0].reset();
                    $("#systemDictionaryId").val("");
                    $("#editFormParentId").val(parentId);
                    $("#systemDictionaryItemModal").modal('show');
                } else {
                    $.messager.popup("请选择目录")
                }
            });
            /*$("#query").click(function () {
                $("#editForm").ajaxSubmit({
                    dataType: 'json',
                    success: function (data) {
                        if (data.success) {
                            $("#searchForm").submit();
                        }
                    }
                })
            });*/
                    $("#query").click(function(){
                        $("#currentPage").val(1);
                        $("#searchForm").submit();
                    })

        });
    </script>
</head>
<body>
<div class="container">
<#include "../common/top.ftl"/>
    <div class="row">
        <div class="col-sm-3">
        <#assign currentMenu="product_list" />
				<#include "../common/menu.ftl" />
        </div>
        <div class="col-sm-9">
            <div class="page-header">
                <h3 align="left">订单列表 </h3>
            </div>
            <div class="col-sm-12">
                <!-- 提交分页的表单 -->
                <form id="searchForm" class="form-inline" method="post" action="/orderList.do">
                    <input type="hidden" id="currentPage" name="currentPage" value="${(qo.currentPage)!1}"/>

                    <div class="form-group">
                        <label>订单号</label>
                        <input class="form-control" type="text" name="keyword" value="${(qo.keyword!'')}">
                    </div>
                   <#-- <div class="form-group">
                        <label>收货人</label>
                        <input class="form-control" type="text" name="consigneeUser" value="${(qo.consigneeUser!'')}">
                    </div>-->
                    <div class="form-group">
                        <label>订单状态</label>
                        <select class="form-control" name="state" size="1">
                            <option value="-1">全部</option>
                            <option value="0">未确认</option>
                            <option value="1">已确认</option>
                            <option value="2">已完成</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>订单时间</label>
                        <input class="form-control" type="text" name="beginDate" id="beginDate"
                               value="${(qo.beginDate?string('yyyy-MM-dd'))!''}"/>到
                        <input class="form-control" type="text" name="endDate" id="endDate"
                               value="${(qo.endDate?string('yyyy-MM-dd'))!''}"/>
                    </div>
                    <div class="form-group">
                        <button id="query" class="btn btn-success"><i class="icon-search"></i> 查询</button>
                    </div>
                </form>
                <div class="row" style="margin-top:20px;">
                    <div class="col-sm-12">
                        <ul id="menu" class="list-group">
                            <li class="list-group-item">
                            </li>
                        </ul>
                    </div>
                    <div class="col-sm-12">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>订单号</th>
                                <th>付款方式</th>
                                <th>状态</th>
                                <th>商品明细</th>
                                <th>价格</th>
                                <th>订单创建时间</th>
                                <th>发货仓库</th>
                                <th>收货人</th>
                                <th>收货地址</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list pageResult.listData as vo>

                            <tr>
                                <td>
                                   <#-- <a target="_blank" href="orderitem.do?id=${vo.oi_userId}"
                                       id="searchSn">${(vo.orderSn)!""}</a>-->
                                    ${(vo.orderSn)!""}
                                </td>
                                <td>积分支付</td>
                                <td>${(vo.orderStatusDisplay)!""}</td>
                                <#--<td>${(vo.op_sku)!""}</td>-->
                                <td>没有明细</td>
                                <td>${(vo.orderAmount)!""}</td>
                               <td>${(vo.ordertime)?string('yyyy-MM-dd')}</td>
                               <#-- <td>时间还没处理</td>-->
                                <td>天河仓库</td>
                               <#-- <td>${(vo.u_name)!""}</td>-->
                                <td>马云</td>
                                <td>${(vo.address)!""}</td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>

                        <div style="text-align: center;">
                            <ul id="pagination" class="pagination"></ul>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="systemDictionaryItemModal" class="modal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">编辑/增加</h4>
            </div>
            <div class="modal-body">
                <form id="editForm" class="form-horizontal" method="post" action="systemDictionaryItem_update.do"
                      style="margin: -3px 118px">
                <#--<input id="systemDictionaryId" type="hidden" name="id" value="" />-->
                    <input type="hidden" id="editFormParentId" name="parentId" value=""/>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">名称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="title" name="title" placeholder="字典值名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">顺序</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="sequence" name="sequence" placeholder="字典值显示顺序">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <a href="javascript:void(0);" class="btn btn-success" id="saveBtn" aria-hidden="true">保存</a>
                <a href="javascript:void(0);" class="btn" data-dismiss="modal" aria-hidden="true">关闭</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>