<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>(系统管理平台)</title>
<#include "../common/header.ftl"/>
    <link rel="stylesheet" href="/js/bootstrap-3.3.2-dist/css/bootstrap.css" type="text/css" />
    <link rel="stylesheet" href="/css/core.css" type="text/css" />
    <script type="text/javascript" src="/js/jquery/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="/js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/jquery.bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-validation/jquery.validate.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
		
		<style type="text/css">
			.el-userhead{
				width: 100px;
				height: 100px;
				display: block;
				margin: 0px auto;
				
			}
			.muted{
				color: #999;
			}
			.text-info{
				color: #09d;
			}
		</style>
    <script type="text/javascript">
       $(function () {
           $("#remark").click(function () {
                $("#textremark").val("");
               $("#orderRemark").modal('show');
           });
           $("#saveBtn").click(function () {
               $("#editForm").ajaxSubmit({
                   dataType:'json',
                   success:function(data) {
                       if(data.success){
                           window.location.reload();
                       }

                   }
               })
           });

           $("#status1").click(function () {
               $.ajax({
                   url:'/orderAudit1.do',
                   dataType:'json',
                   type:'post',
                   data: {status: 1, orderId:${orserInfo.id}},
                   success:function () {
                       window.location.reload();
                   }
               })
           })

           $("#status2").click(function () {
               $.ajax({
                   url:'/orderAudit2.do',
                   dataType:'json',
                   type:'post',
                   data: {status: 2, orderId:${orserInfo.id}},
                   success:function () {
                       window.location.reload();
                   }
               })
           })

           $("#status3").click(function () {
               $.ajax({
                   url:'/orderAudit3.do',
                   dataType:'json',
                   type:'post',
                   data: {status: 3, orderId:${orserInfo.id}},
                   success:function () {
                       window.location.reload();
                   }
               })
           })
           $(".btn-return").click(function () {
               window.location.href="/order_back_item.do?orderId=${orserInfo.id}";
           })
           $("#goBark").click(function () {
               window.location.href="/orderList.do";
           })


       })
    </script>

    <style>
        .div-right{ text-align:right;margin:0px auto 100px auto;}
    </style>
</head>
	<body>
		<div class="container">
			<div class="row">
				<#--<div class="col-sm-3">
				</div>-->
				<div class="col-sm-12">
					<div class="row">

					
					<div class="panel panel-default">
						<div class="panel-heading">
							<div style="font-size: 16px;">用户详情</div>
						</div>
						<div class="panel-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>用户ID</th>
										<th>邮箱</th>
										<th>昵称</th>
										<th>平台账户余额</th>
										<th>注册时间</th>
										<th>最后登入时间</th>
									</tr>
								</thead>
								<tbody>

							    	<tr style="cursor: pointer;" lid="2101" st="1" class="more">
								        <td>${user.id}</td>
								        <td>${user.email}</td>
								        <td>${user.nickName}</td>
								        <td>${user.userMoney}</td>
								        <td>${(user.registerTime?string("yyyy-MM-dd"))!""}</td>
								        <td>${(user.endTime?string("yyyy-MM-dd"))!""}</td>
								    </tr>

								</tbody>
							</table>
						</div>
					</div>
					
					<div class="panel panel-default">
						<div class="panel-heading">
							用户交易汇总
						</div>
						<div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>有效订单</th>
                                    <th>成功交易金额</th>
                                    <th>退货次数</th>
                                    <th>退货金额</th>
                                    <th>发货后退货率</th>
                                </tr>
                                </thead>
                                <tbody>

                                <tr style="cursor: pointer;" lid="2101" st="1" class="more">
								 <td>${collect.validOrder}</td>
								        <td>${collect.account}</td>
								        <td>${collect.backOrder}</td>
								        <td>${collect.backMoney}</td>
								        <td>${collect.backRate}%</td>
                                </tr>

                                </tbody>
                            </table>
						</div>
					</div>
					
					<div class="panel panel-default">
						<div class="panel-heading">
							<div style="font-size: 16px;">订单备注</div>
                            <button id="remark" class="btn btn-success"><i class="icon-search"></i> 添加备注</button>
						</div>
						<div class="panel-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>UID</th>
										<th>添加人</th>
										<th>时间</th>
										<th>内容</th>
									</tr>
								</thead>
								<tbody>

							    	<tr style="cursor: pointer;" lid="2101" st="1" class="more">
								        <th>${(remark.sn)!""}</th>
								        <th>${(remark.addUser)!""}</th>
								        <th>${(remark.remarkTime?string("yyyy-MM-dd"))!""}</th>
								        <th>${(remark.content)!""}</th>
								    </tr>

								</tbody>
							</table>
						</div>
					</div>
					<!--三个表-->

                            <div class="row">
                                <div  class="col-sm-4">
                                    <h3 class="text-info">
                                        订单详情
                                    </h3>
                                    <div>
                                        <table width="100%" height="250px">
                                            <tr>
                                                <td class="muted" width="80px">订单号</td>
                                                <td class="text-info"  style="padding-left: 10px;">
                                                ${orserInfo.orderSn}
                                                </td>
											</tr>
											<tr>
                                                <td class="muted">订单状态</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                    ${orserInfo.orderStatus}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="muted ">付款状态</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                    ${orserInfo.payStatus}
                                                </td>

											</tr>
											<tr>
                                                <td class="muted">要求发票</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                    否
                                                </td>
                                            </tr>

                                        </table>
                                    </div>
                                </div>

                                <div class="col-sm-4">
                                    <h3 class="text-info">
                                        订单时间
                                    </h3>
                                    <div>
                                        <table width="100%" height="250px">
                                            <tr>
                                                <td class="muted" width="80px">创建时间</td>
                                                <td class="text-info" width="120px" style="padding-left: 10px;">
                                                    ${(orderTime.crateTime?string("yyyy-MM-dd"))!""}
                                                </td>
											<tr/>
											<tr>
                                                <td class="muted" width="80px">付款时间</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                ${(orderTime.payTime?string("yyyy-MM-dd"))!""}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="muted ">发货时间</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                ${(orderTime.deliveryTime?string("yyyy-MM-dd"))!""}
                                                </td>
											</tr>
											<tr>
                                                <td class="muted">完成时间</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                ${(orderTime.finishTime?string("yyyy-MM-dd"))!""}
                                                </td>
                                            </tr>

                                        </table>
                                    </div>
                                </div>

                                <div class="col-sm-4">
                                    <h3 class="text-info">
                                        付款详情
                                    </h3>
                                    <div>
                                        <table width="100%" height="250px">
                                            <tr>
                                                <td class="muted" width="80px">支付方式</td>
                                                <td class="text-info" width="120px" style="padding-left: 10px;">
                                                    积分支付
                                                </td>
											</tr>
											<tr>
                                                <td class="muted" width="80px">付款状态</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                ${orserInfo.payStatus}
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="muted ">订单价格</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                    ${orserInfo.orderAmount}
                                                </td>
											</tr>
											<tr>
                                                <td class="muted">减免金额</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                    无
                                                </td>
											</tr>
											<tr>
                                                <td class="muted">付款IP</td>
                                                <td class="text-info" style="padding-left: 10px;">
                                                    127.168.9.140
                                                </td>
                                            </tr>

                                        </table>
                                    </div>
                                </div>

							</div>



					<div class="panel panel-default">
						<div class="panel-heading">
							<div style="font-size: 16px;">订单商品详情</div>
							<div>订单号:${orserInfo.orderSn}</div>
						</div>
						<div class="panel-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>商品名称</th>
										<th>SKU</th>
										<th>单价</th>
										<th>数量</th>
										<th>总价</th>
										<th>商品类型</th>
										<th>组套信息</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
                                <#list item as it>
                                <tr >
                                    <th>${(it.op_productName)!""}</th>
                                    <th>${(it.op_sku)!""}</th>
                                    <th>${(it.op_productPrice)!""}</th>
                                    <th>${(it.op_productNumber)!""}</th>
                                    <th>${(it.oi_amount)!""}</th>
                                    <th>网购</th>
                                    <th>无</th>
                                    <th>
                                        <#if orserInfo.shippingStatus==0>
                                            <button id="status1" class="btn btn-success"><i class="icon-search"></i>确认订单</button>
                                            <button  class="btn btn-return" data-status="${orserInfo.shippingStatus}"><i class="icon-search"></i>创建退货单</button>
                                        </#if>
                                        <#if orserInfo.shippingStatus==1>
                                            <button id="status2" class="btn btn-success"><i class="icon-search"></i>发货</button>
                                            <button id="returnGood" class="btn btn-return" data-status="${orserInfo.shippingStatus}"><i class="icon-search"></i>创建退货单</button>
                                        </#if>
                                        <#if orserInfo.shippingStatus==2>
                                            <button  class="btn btn-return" data-status="${orserInfo.shippingStatus}"><i class="icon-search"></i>创建退货单</button>
                                            <button id="status3" class="btn btn-success"><i class="icon-search"></i>已完成</button>
                                        </#if>
                                        <#if orserInfo.shippingStatus==3>
                                            <font color="#7fff00">正常完成</font>
                                        </#if>
                                        <#if orserInfo.shippingStatus==4>
                                            <font color="#ff00ff">退货</font>
                                        </#if>


                                    </th>
                                    <th><input type="hidden" name="id" value="${it.oi_id}" ></th>
                                </tr>
                                </#list>

								</tbody>
							</table>
						</div>
					</div>
					<div class="col-sm-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div style="font-size: 16px;">地址详情</div>
                            </div>
                            <div class="panel-body">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>邮编</th>
                                        <th>收货人 </th>
                                        <th>手机</th>
                                        <th>用户邮箱</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                        <tr>
                                            <td>${orserInfo.zipcode}</td>
                                            <td>${orserInfo.consignee}</td>
                                            <td>${user.phone}</td>
                                            <td>${user.email}</td>

                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>

					</div>


					<div class="col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div style="font-size: 16px;">操作记录</div>
                            </div>
                            <div class="panel-body">
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>操作时间</th>
                                        <th>动作</th>
                                        <th>操作前订单状态</th>
                                        <th>操作后订单状态</th>
                                        <th>操作人</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list action as a>
                                    <tr>
                                        <td>${(a.actionTime?string("yyyy-MM-dd"))!""}</td>
                                        <td>${(a.orderStatusDisplay)!""}</td>
                                        <td>${(a.beforeStatusDisplay)!""}</td>
                                        <td>${(a.orderStatusDisplay)!""}</td>
                                        <td>${(a.opreator)!""}</td>
                                    </tr>
                                        </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
					</div>
					
				</div>
			</div>
		</div>

            <div id="orderRemark" class="modal" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                        </div>
                        <div class="modal-body">
                            <form id="editForm" class="form-horizontal" method="post" action="/orderRemark.do" style="margin: -3px 118px">
                                <input id="systemDictionaryId" type="hidden" name="id" value="${user.id}" />
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">备注内容</label>
                                    <div class="col-sm-6">
                                        <textarea  id="textremark" rows="8" cols="16" name="sn"></textarea>
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
            <div class="div-right"><button id="goBark" class="btn btn-success"><i class="icon-search"></i>返回订单列表</button></div>
	</body>
</html>