<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>(系统管理平台)</title>
<#include "../common/header.ftl"/>
    <link rel="stylesheet" type="text/css" href="/js/plugins/flipcountdown/jquery.flipcountdown.css"/>
    <script type="text/javascript" src="/js/plugins/flipcountdown/jquery.flipcountdown.js"></script>
    <script type="text/javascript" src="/js/plugins/uploadify/jquery.uploadify.min.js"></script>

    <style type="text/css">
        .el-userhead {
            width: 100px;
            height: 100px;
            display: block;
            margin: 0px auto;

        }

        .muted {
            color: #999;
        }

        .text-info {
            color: #09d;
        }
    </style>
    <script>
        $(function () {
            /* $("#commitBtn").click(function () {
                 window.location.href = "/order_back_list.do";
             });*/
            $("#backBtn").click(function () {
                window.location.href = "/order_back_list.do";
            });
            $("#backBtn2").click(function () {
                window.location.href = "/orderList.do";
            });
        });
    </script>


</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
        </div>
        <div class="col-sm-9">
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
                                <td>${orderItem['userId']}</td>
                                <td>${orderItem['email']}</td>
                                <td>${orderItem['nickName']}</td>
                                <td>${orderItem['userMoney']}</td>
                                <td>xx</td>
                                <td>xx</td>
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
                                <td>xxx</td>
                                <td>${orderItem['orderAmount']}</td>
                                <td>xxx</td>
                                <td>xxx</td>
                                <td>xx</td>
                                <td>xx</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <h3 class="text-info">
                            订单详情
                        </h3>
                        <div>
                            <table width="100%" height="250px">
                                <tr>
                                    <td class="muted" width="80px">订单号</td>
                                    <td class="text-info" style="padding-left: 10px;">${orderItem['orderSn']}</td>
                                </tr>
                                <tr>
                                    <td class="muted">订单状态</td>
                                    <td class="text-info" style="padding-left: 10px;">${orderItem['orderStatus']}</td>
                                </tr>
                                <tr>
                                    <td class="muted ">付款状态</td>
                                    <td class="text-info"
                                        style="padding-left: 10px;">${orderItem['payStatusDisplay']}</td>
                                </tr>
                                <tr>
                                    <td class="muted">要求发票</td>
                                    <td class="text-info" style="padding-left: 10px;">xx</td>
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
                                    ${orderItem['actionTime']?string("yyyy-MM-dd")}
                                    </td>
                                <tr/>
                                <tr>
                                    <td class="muted" width="80px">付款时间</td>
                                    <td class="text-info" style="padding-left: 10px;">xx</td>
                                </tr>
                                <tr>
                                    <td class="muted ">发货时间</td>
                                    <td class="text-info" style="padding-left: 10px;">xx</td>
                                </tr>
                                <tr>
                                    <td class="muted">完成时间</td>
                                    <td class="text-info" style="padding-left: 10px;">xx</td>
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
                                    <td class="text-info" width="120px" style="padding-left: 10px;">积分兑换</td>
                                </tr>
                                <tr>
                                    <td class="muted" width="80px">付款状态</td>
                                    <td class="text-info"
                                        style="padding-left: 10px;">${orderItem['payStatusDisplay']}</td>
                                </tr>
                                <tr>
                                    <td class="muted ">订单价格</td>
                                    <td class="text-info" style="padding-left: 10px;">${orderItem['orderAmount']}</td>
                                </tr>
                                <tr>
                                    <td class="muted">减免金额</td>
                                    <td class="text-info" style="padding-left: 10px;">xx</td>
                                </tr>
                                <tr>
                                    <td class="muted">付款IP</td>
                                    <td class="text-info" style="padding-left: 10px;">127.xx.xx</td>
                                </tr>

                            </table>
                        </div>
                    </div>

                </div>


                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div style="font-size: 16px;">订单商品详情</div>
                        <div>订单号:</div>
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
                            </tr>
                            </thead>
                            <tbody>
                            <tr style="cursor: pointer;" lid="2101" st="1" class="more">
                                <td>${orderItem['productName']}</td>
                                <td>${orderItem['skuAttr']}</td>
                                <td>${orderItem['productPrice']}</td>
                                <td>${orderItem['productNumber']}</td>
                                <td>${orderItem['orderAmount']}</td>
                                <td>${orderItem['skuId']}</td>
                                <td>xx</td>
                            </tr>
                            </tbody>
                        </table>
                        121
                    </div>
                </div>
            <#if orderItem['collectId']??>
                <table>
                    <tr>
                        <td>退货原因:</td>
                        <#if orderItem['backCause']=="1">
                            <td>
                                <span style="color: #0000aa">物流太慢</span>
                            </td>
                        </#if>
                        <#if orderItem['backCause'] == "2">
                            <td>
                                <span style="color: #0000aa">货不对板</span>
                            </td>
                        </#if>
                        <#if orderItem['backCause'] == "3">
                            <td>
                                <span style="color: #0000aa">卖家态度恶劣</span>
                            </td>
                        </#if>
                        <#if orderItem['backCause'] == "4">
                            <td>
                                 <span style="color: #0000aa">个人原因</span>
                            </td>
                        </#if>
                        <td>是否由平台导致:</td>
                        <td><#if orderItem['systemMake']==1>
                            <span style="color: #0000aa">是</span>
                        <#else ><span style="color: #0000aa">否</span>
                        </#if></td>
                    </tr>
                    <tr>
                        <td>退货原因说明:</td>
                        <td><span style="color: #0000aa">${orderItem['backNote']}</span></td>
                    </tr>
                    <tr>
                        <td>退货图片:</td>
                        <td><span style="color: #0000aa">${orderItem['backImgPath']}</span></td>
                    </tr>
                </table>
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">联系人:</label>
                    <div class="col-sm-10"><span style="color: #0000aa">${orderItem['linkMan']}</span></div>
                </div>
                <br>
                <div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">联系方式:</label>
                        <div class="col-sm-10"><span style="color: #0000aa">${orderItem['linkTel']}</span></div>
                    </div>
                </div>
                <button class="btn btn-primary" id="backBtn">返回</button>
            <#else >
                <form action="/order_back.do" method="post" id="backForm">
                    <input type="hidden" name="orderId" value="${orderId}">
                    <table>
                        <tr>
                            <td>退货原因</td>
                            <td><select class="form-control" name="backCause">
                                <option value="-1">请选择</option>
                                <option value="1">物流太慢</option>
                                <option value="2">货不对板</option>
                                <option value="3">卖家态度恶劣</option>
                                <option value="4">个人原因</option>
                            </select></td>
                            <td>是否由平台导致:</td>
                            <td><label class="radio-inline">
                                <input type="radio" name="systemMake" id="inlineRadio1" value="1"> 是
                            </label>
                                <label class="radio-inline">
                                    <input type="radio" name="systemMake" id="inlineRadio2" value="2"> 否
                                </label></td>
                        </tr>
                        <tr>
                            <td>退货原因说明</td>
                        </tr>
                        <tr>
                            <td colspan="3"><textarea name="backNote"
                                                      style="margin: 0px; width: 439px; height: 64px;">
                        </textarea></td>
                        </tr>
                        <tr>
                            <td>退货图片</td>
                            <td>
                                <label>
                                    <input type="file" name="backImgPath">
                                </label>
                            </td>
                        </tr>
                    </table>
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">联系人</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputEmail3" name="linkMan">
                        </div>
                    </div>
                    <br>
                    <div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">联系方式</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputPassword3" name="linkTel">
                            </div>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-primary" id="commitBtn" value="提交"></input>
                </form>
                <button class="btn btn-primary" id="backBtn2">返回</button>
            </#if>
            </div>
        </div>
</body>
</html>