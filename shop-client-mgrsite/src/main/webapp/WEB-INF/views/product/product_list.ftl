<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>小码商城管理平台</title>
<#include "../common/header.ftl"/>
	<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
	<script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
	<script type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="/js/plugins/uploadify/jquery.uploadify.min.js"></script>

	<script type="text/javascript">
		//console.error("Hello World")		
		$(function () {
			$("#query").click(function () {
				$("#currentPage").val(1);
				$("#searchForm").submit();
			});

			$("#pagination_container").twbsPagination({
				totalPages:${pageResult.totalPage},
				visiblePages: 5,
				startPage:${pageResult.currentPage},
				first: "首页",
				prev: "上一页",
				next: "下一页",
				last: "末页",
				onPageClick: function (event, page) {
					$("#currentPage").val(page);
					$("#searchForm").submit();
				}
			});

			$("table > tbody > tr").click(function () {
				$("table > tbody > tr").removeClass("active");

				$(this).addClass("active");

				$("#productIdHidden").val($(this).data("id"));
			});

			$(".edit-product").click(function () {
				if ($("#productIdHidden").val() && $("#productIdHidden").val() != "") {
					var productId = $("#productIdHidden").val();
					$.get("/getProductJson.do?productId=" + productId, function (data) {
						$("#id").val(data.id);
						$("#name").val(data.name);
						$("#code").val(data.code);
						$("#createdDate").html(data.createdDate);
						$("#lastModifiedDate").html(data.lastModifiedDate);
						$("#productBrand").val(data.productBrand);
						$("#catalog").val(data.catalog);
						$("#keyword").val(data.keyword);
						$("#marketPrice").val(data.marketPrice);
						$("#basePrice").val(data.basePrice);
						$("#image").attr("src", data.image)
						$("#product_image").val(data.image)
					}, "json");
					$("#productModal").modal("show");
				} else {

					$.messager.alert("请选择需要编辑的商品")
				}
			})
			//更新编辑产品信息
			$(".btn_save").click(function () {
				$("#editform").ajaxSubmit(function (data) {
					if (data.success) {
						$.messager.confirm("提示", "保存成功", function () {
							$("#productModal").modal("show");
							window.location.reload();
						})
					} else {
						$messager.alert("提示", data.msg);
					}
				})
			});
		});

		$(".show-product").click(function () {
			if ($("#productIdHidden").val() && $("#productIdHidden").val() != "") {

				window.location.href = "/showProduct.do?productId=" + $("#productIdHidden").val();
			} else {

				$.messager.alert("请选择需要查看的商品")
			}
		})

		$(".generate-sku").click(function () {
			if ($("#productIdHidden").val() && $("#productIdHidden").val() != "") {

				window.location.href = "/toGenerateSkuUI.do?productId=" + $("#productIdHidden").val();
			} else {

				$.messager.alert("请选择需要生成sku的商品")
			}
		})

		//showProduct.do
		})
		;
	</script>
</head>
<body>
<input type="hidden" id="productIdHidden"/>
<div class="container">
<#include "../common/top.ftl"/>
	<div class="row">
		<div class="col-sm-3">
        <#assign currentMenu="product_list" />
				<#include "../common/menu.ftl" />
		</div>
		<div class="col-sm-9">
			<div class="page-header">
				<h3>商品管理</h3>
			</div>
			<div class="row">
				<!-- 提交分页的表单 -->
				<form id="searchForm" class="form-inline" method="post" action="/productList.do">
					<input type="hidden" name="currentPage" id="currentPage" value=""/>
					<div class="form-group">
					</div>
					<div class="form-group">
						<label>关键字</label>
						<input class="form-control" type="text" name="keyword" value="${(qo.keyword)!''}">
					</div>
					<div class="form-group">
						<button id="query" type="button" class="btn btn-success"><i class="icon-search"></i> 查询</button>
						<a href="javascript:;" class="btn btn-success edit-product">编辑商品</a>
						<a href="javascript:;" class="btn btn-success show-product">查看商品</a>
						<a href="javascript:;" class="btn btn-success generate-sku">生成sku</a>
					</div>
				</form>
			</div>
			<div class="panel panel-default">
				<table class="table table-hover">
					<thead>
					<tr>
						<th>商品编号</th>
						<th>商品名称</th>
						<th>分类</th>
						<th>品牌</th>
						<th>市场价格</th>
						<th>基础价格</th>
					</tr>
					</thead>
					<tbody id="tbody">
                    <#list pageResult.listData as data>
					<tr data-id="${data.id}">
						<td>${data.code}</td>
						<td><a href="#">${data.name}</a></td>
						<td>${data.catalogName}</td>
						<td>${data.productBrand.chineseName}</td>
                    <#--<td>${data.loginTime?string("yyyy-MM-dd HH:mm:SS")}</td>-->
						<td>${(data.marketPrice)!''}</td>
						<td>${data.basePrice}</td>
					</tr>
                    </#list>
					</tbody>
				</table>
				<div style="text-align: center;" id="pagination_container">

				</div>
			</div>
		</div>
	</div>
</div>

<div class="modal fade " id="productModal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<form class="form-horizontal" id="editform" method="post" action="/updateProduct.do">
					<fieldset>
						<div id="legend" class="">
							<legend>商品编辑</legend>
						</div>
						<input type="hidden" name="id" id="id" value=""/>
						<div class="row">
							<label class="col-sm-2 control-label" for="name">产品名称</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="name" id="name">
							</div>
						</div>
						<div class="row">
							<label class="col-sm-2 control-label" for="name">创建时间</label>
							<div class="col-sm-4">
								<label class="form-control" name="createdDate" id="createdDate"></label>
							</div>
						</div>
						<div class="row">
							<label class="col-sm-2 control-label" for="name">上次修改时间</label>
							<div class="col-sm-4">
								<label class="form-control" name="lastModifiedDate" id="lastModifiedDate"></label>
							</div>
						</div>
						<div class="row">
							<label class="col-sm-2 control-label" for="name">产品品牌</label>
							<div class="col-sm-4">
                            <#--<label class="form-control" name="idNumber" id="idNumber"></label>-->
								<select id="productBrand" class="form-control" name="productBrand.id">
                                <#list brands as brand>
									<option value="${brand.id}">${brand.chineseName}</option>
                                </#list>
								</select>
							</div>
						</div>

						<div class="row">
							<label class="col-sm-2 control-label" for="name">产品分类</label>
							<div class="col-sm-3">
                            <#--<label class="form-control" name="idNumber" id="idNumber"></label>-->
								<select id="catalog" class="form-control" name="catalog.id">
                                <#list catalogs as catalog>
									<option value="${catalog.id}">${catalog.name}</option>
                                </#list>
								</select>
							</div>
						</div>

						<div class="row">
							<label class="col-sm-2 control-label" for="name">关键字</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="keyword" id="keyword">
							</div>
						</div>

						<div class="row">
							<label class="col-sm-2 control-label" for="name">商品编码</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" name="code" id="code">
							</div>
						</div>

						<div class="row">
							<label class="col-sm-2 control-label" for="name">市场价</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="marketPrice" id="marketPrice">
							</div>
						</div>

						<div class="row">
							<label class="col-sm-2 control-label" for="name">成本价</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="basePrice" id="basePrice">
							</div>
						</div>

						<div class="row">
							<label class="col-sm-2 control-label" for="name">商品图片</label>
							<div class="image-div">
								<div>
									<a href="javascript:;" id="uploadImage" class="js-upload">上传</a>
								</div>
								<img class="uploadImg" src="" id="image" alt="无图片">
								<input type="hidden" name="image" id="product_image">
							</div>
						</div>
                    <#--更新图片-->
						<script type="text/javascript">
							$("#uploadImage").uploadify(
									{
										buttonText: "更新/添加图片",
										fileObjName: "file",
										fileTypeDesc: "商品图片",
										fileTypeExts: "*.gif; *.jpg; *.png",
										swf: "/js/plugins/uploadify/uploadify.swf",
										uploader: "/productImgUpload.do;jsessionid=${(sessionid)}",
										overrideEvents: ["onUploadSuccess", "onUploadProgress",
											"onSelect"],
										onUploadSuccess: function (file, data) {
//                                        console.debug(data);
											var $wrapper = this.wrapper;
											var $div = $wrapper.parent('div').parent('div');
											//data = JSON.parse(data);
											$div.find('img').attr('src', data);
											$div.find('input').val(data);
										}
									}
							);
						</script>
					</fieldset>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				<button type="button" class="btn btn-success btn_save">保存</button>
			</div>
		</div>
	</div>
</div>
</body>
</html>