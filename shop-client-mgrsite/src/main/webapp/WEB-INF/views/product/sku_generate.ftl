<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>小码商城管理平台</title> <#include "../common/header.ftl"/>
	<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
	<script type="text/javascript">
		//生成SKU
		function genarateSku() {
			//清空sku的div
			var skuDiv = $("#skuDiv");
			skuDiv.empty();
			//获取sku属性
//			var skuPro = $(".label-success")
//			if (skuPro.length == 0) {
//				$.messager.alert("请选择sku属性");
//			}
			//遍历skuPro,得到shu属性对象
			var skuProArr = getSkuProArr();
//			$.each(skuPro, function (index, obj) {
//				console.debug(index);
//				console.debug(obj);
//				skuProArr.push({"id": $(obj).data("id"), "name": $(obj).html().trim()})
//			})
			//获取sku属性值
//			var skuProValues = $(".sku-pro-val");

			//获取sku属性值数组
			var skuProValuesArr = getSkuProValuesArr();
//			$.each(skuProValues, function (index, obj) {
//				var skuProId = $(obj).closest("table").attr("id");
//				skuProId = skuProId.substring(skuProId.length - 1);
//				skuProValuesArr.push({"value": $(obj).val(), "skuProperty": {"id": skuProId}})
//			})

			var obj = {
				"productId":${product.id},
				"skuPropertiesList": skuProArr,
				"skuPropertyValueList": skuProValuesArr
			};
			console.debug(JSON.stringify(obj));
			//分装数据,发送ajax请求
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/generateSkuList.do",
				data: JSON.stringify(obj),
				dataType: 'html',
				success: function (data) {
					$("#skuDiv").empty();
					$("#skuDiv").append(data);
				}
			})
		};
		function getSkuProArr() {
			var skuPro = $(".label-success")
			if (skuPro.length == 0) {
				$.messager.alert("请选择sku属性");
			}
			//遍历skuPro,得到shu属性对象
			var skuProArr = [];
			$.each(skuPro, function (index, obj) {
				skuProArr.push({"id": $(obj).data("id"), "name": $(obj).html().trim()})
			})
			return skuProArr;
		};

		function getSkuProValuesArr() {
			//获取sku属性值
			var skuProValues = $(".sku-pro-val");
			//获取sku属性值数组
			var skuProValuesArr = [];
			$.each(skuProValues, function (index, obj) {
				var skuProId = $(obj).closest("table").attr("id");
				console.debug(skuProId);
				skuProId = skuProId.substring(skuProId.length - 1);
				console.debug("---------------");
				skuProValuesArr.push({"value": $(obj).val(), "skuProperty": {"id": skuProId}})
			})
			return skuProValuesArr;
		};
        $(function(){
            $("#saveButton").click(function() {
                $("#productSkuSaveForm").ajaxSubmit({
                    dataType:"json",
                    type:"POST",
                    success:function (data) {
                        if (data.success){
                            $.messager.alert("温馨提示", "成功");
                            window.location.href = "/productList.do";
                        }else{
	                        $.messager.alert("温馨提示", "操作失败,请联系管理员");
                        }
                    }
                });
            });
        })

		//通过属性sku的id查询出sku的所有属性值
		function clickProperty(obj) {
			//---------------------teacher method----------------------
			//sku属性id
			var propertyId = $(obj).data("id")
			if ($(obj).attr("class") == "label label-success") {
				//取消选中sku属性
				$(obj).attr("class", "label label-default");
				//移除对应的sku属性
				removeSkuProperty(propertyId);
			} else {
				//选中sku属性
				$(obj).attr("class", "label label-success");
				//查询出sku的属性值并显示在页面
				selectSkuProperty(propertyId);
			}
		}

		//查询出sku的属性值并显示在页面
		function selectSkuProperty(id) {
			$.get("/listSkuPropertyValuesTableById.do?id=" + id, function (html) {
				$("#skuProValDiv").append(html);
			}, "html");
		}

		//移除对应的sku属性
		function removeSkuProperty(id) {
			$("#skuProValTable" + id).remove();
		}

		//移除具体的sku属性
		function deleteSkuPropertyTr(obj) {
			var self = $(obj);
			var tbody = self.closest("tbody");
			if (tbody.find("tr").length == 1) {
				self.closest("table").remove();
				var id = self.closest("table").attr("id");
				id = id.substring(id.length - 1);
				$('#skuProDiv ' + '[data-id=' + id + ']').attr("class", "label label-default");
			} else {
				self.closest("tr").remove();
			}
		}

		//添加一行
		function addSkuPropertyTr(skuPropertyId) {
			var $tr = $("#propertyTrTemplate").html();
			$("#skuProValTable" + skuPropertyId).find("tbody").append($tr);
		}
	</script>
</head>
<body>
<input type="hidden" id="productIdHidden"/>
<div class="container">
<#include "../common/top.ftl"/>
	<div class="row">
		<div class="col-sm-3"><#assign currentMenu="product_list" /> <#include "../common/menu.ftl" /></div>
		<div class="col-sm-9">
			<div class="page-header">
				<h3>生成SKU</h3>
			</div>
			<!-- 提交商品SKU表单 -->
			<form action="/productSkuSave.do" method="post" id="productSkuSaveForm">
				<table class="table table-bordered">
					<tr>
						<td><b>商品名：</b>${product.name}</td>
						<td><b>商品编号：</b>${product.code}</td>
					</tr>
				</table>
				<input name="productId" value="${product.id}" type="hidden"/>
            <#if (productSkuList?size=0)>
				<span style="color: red">该产品还没有生成过SKU,请选择SKU属性生成SKU</span>
            <#else>
				<span style="color: green" id="sku_details">产品已经生成SDK,点击查看详情</span>
            </#if>
				<script>
					$(function () {
						$("#sku_details").click(function () {
							$("#open_sku_details").toggle();
						});
					})
				</script>
            <#--商品已经生成的sku属性-->
				<div class="panel panel-default" style="display: none" id="open_sku_details">
					<table class="table table-hover">
						<thead>
						<tr>
							<th>SKU编码</th>
							<th>SKU价格</th>
						</tr>
						</thead>
						<tbody id="tbody">
                        <#list productSkuList as data>
						<tr data-id="${data.id}">
							<td>${data.code}</td>
							<td>${data.price}</a></td>
						</tr>
                        </#list>
						</tbody>
					</table>
					<div style="text-align: center;" id="pagination_container">

					</div>
				</div>

				<div id="skuProDiv">
                <#list skuPropertyList as data>
					<span style="cursor: pointer; font-size: 13px;margin-right: 10px;" class="label label-default"
					      onclick="clickProperty(this)" data-id="${data.id}">
                    ${data.name}
                    </span>
                </#list>
				</div>
				<div id="skuProValDiv" style="margin-top: 20px;"></div>

				<h2>
					<button type="button" class="btn btn-default" onclick="genarateSku()">生成SKU数据</button>
				</h2>
            <#--用于生成商品的sku-->
				<div id="skuDiv">

				</div>

				<div class="modal-footer">

					<button type="button" class="btn btn-primary" id="saveButton">保存</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- 每一行的模板 -->
<script type="text/x-template" id="propertyTrTemplate">
	<tr>
		<td>
			<button class="btn btn-default" type="button" onclick="deleteSkuPropertyTr(this)">
				— 移除
			</button>
		</td>
		<td><input type="text" class="form-control sku-pro-val"/></td>
		<td><input type="file"/></td>
	</tr>
</script>
<script>

</script>
</body>
</html>