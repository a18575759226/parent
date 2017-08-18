<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>蓝源Eloan-P2P平台(系统管理平台)</title>
<#include "../common/header.ftl"/>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>

    <script type="text/javascript">
        $(function () {
            $(".beginDate,.endDate").click(function () {
                WdatePicker();
            });
            $("#query").click(function () {
                $("#currentPage").val(1);
                $("#searchForm").submit();
            });
            //分页
            $("#pagination").twbsPagination({
                totalPages:${PageResult.totalPage},
                visiblePages: 10,
                startPage:${qo.currentPage},   //设置回显
                first: "首页",
                prev: "上一页",
                next: "下一页",
                last: "尾页",
                onPageClick: function (event, page) {
                    $("#currentPage").val(page);
                    $("#searchForm").submit();
                }
            });
            //确认发货
            $("#confirm_order").click(function () {
                var oid = $(this).data("json");
                $.ajax({
                    url: "/order_ship.do",
                    dataType: "json",
                    type: "POST",
                    data: {orderId: oid},
                    success: function () {
                        window.location.reload();
                    },
                    error: function () {
                        window.location.reload();
                    }
                });
            });
        })
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
            <form id="searchForm" class="form-inline" method="POST" action="/order_ship_list.do">
                <input type="hidden" id="currentPage" name="currentPage" value=""/>
                <div class="form-group">
                    <label>订单号</label>
                    <input class="form-control" type="text" name="keyword" value='${qo.keyword!""}'/>
                </div>
                <div class="form-group">
                    <label>客户</label>
                    <input class="form-control" type="text" name="consigneeUser" value='${qo.consigneeUser!""}'/>
                </div>
                <div class="form-group">
                    <label>订单时间</label>
                    <input class="form-control beginDate" type="text" name="beginDate"
                           value='${(qo.beginDate?string("yyyy-MM-dd"))!""}'/>到
                    <input class="form-control endDate" type="text" name="endDate"
                           value='${(qo.endDate?string("yyyy-MM-dd"))!""}'/>
                </div>
                <div class="form-group">
                    <button id="query" type="button" class="btn btn-success"><i class="icon-search"></i>过滤</button>
                </div>
            </form>
            <table class="table">
                <thead>
                <tr>
                    <th>订单号</th>
                    <th>付款方式</th>
                    <th>商品明细</th>
                    <th>价格</th>
                    <th>订单的创建时间</th>
                    <th>收货人</th>
                    <th>收货地址</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="tbody">
                <#list PageResult.listData as map >
                <tr>
                    <td>${map['orderSn']}</td>
                    <td>积分付款</td>
                    <td>${map['skuAttr']}</td>
                    <td>${map['orderAmount']}</td>
                    <td>${map['actionTime']?string("yyyy-MM-dd")}</td>
                    <td>${map['consignee']}</td>
                    <td>${map['address']}</td>
                    <td><a href="javascript:;" id="confirm_order" data-json="${map['orderId']}">发货</a></td>
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
</body>
</html>