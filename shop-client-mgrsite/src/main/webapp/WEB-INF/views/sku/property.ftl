<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小码商城管理平台</title> <#include "../common/header.ftl"/>
<link rel="stylesheet"
	href="/js/plugins/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript"
	src="/js/plugins/ztree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript"
	src="/js/plugins/ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript">
	var setting = {
		async : {
			enable : true,
			url : "/getCatalog.do",
			autoParam : [ "id" ]
		},
		callback : {
			onClick : zTreeOnClick
		}
	};

	function zTreeOnClick(event, treeId, treeNode) {

		//给新增分类的模态框的父分类名设值
		$("#parentCatalog").val(treeNode.name);
		//给新增分类的模态框的父分类id设值
		$("#parentCatalogId").val(treeNode.id);
		
		//清空分类属性面板内容
		$("#skuPropertyPanel").empty();
		
		//重新通过分类ID加载分类属性面板内容
		$("#skuPropertyPanel").load("/getSkuProperty.do?catalogId="+treeNode.id)
		
	};
	var treeObj;
	$(document).ready(function() {
		
		treeObj = $.fn.zTree.init($("#catalogTree"), setting);
		
	});
	
	//打开分类属性值的模态框
	function showProperty(id){
		$("#propertyValueModal").modal("show");
		
		//情况分类属性值模态框内容
		$("#skuPropertyValueForm").empty();
		
		//重新通过分类属性ID或者分类属性值模态框内容
		$("#skuPropertyValueForm").load("/getSkuPropertyValue.do?skuPropertyId="+id)
		
	}
	
	//添加分类属性值的input元素
	function addValue(){
		$("#valueDiv").append('<input type="text" class="form-control" name="value" style="width: 200px;margin-bottom: 5px;">');
	}
	
	//提交分类属性值表单
	function submitValueForm(){
		var form = $("#skuPropertyValueForm");
		$("#propertyValueModal").modal("hide");
		var $input = $("input[name='value']")
		if($input.val()){
			form.ajaxSubmit(function(data) {
                if (data.success) {
                    $.messager.confirm("提示", "操作成功!", function() {
                        window.location.reload();
                    });
                } else {
                    $.messager.alert("提示", data.msg);
                }
			});
		}
		return false;
	}
	
	//打开添加分类属性模态框
	function addSkuProperty(propertyId){
		//获取当前选择的分类
		var sNodes = treeObj.getSelectedNodes();
		$("#propertyFormContent").load("/toSkuPropertySave.do?id="+propertyId+"&catalogId="+sNodes[0].id);
		
		$("#propertyModal").modal("show");
	}
	
	function saveSkuProperty(){
		var form = $("#skuPropertyForm");
		$("#propertyModal").modal("hide");
		form.ajaxSubmit(function(data) {
			if (data.success) {
				$.messager.confirm("提示", "保存成功!", function() {
					window.location.reload();
				});
			} else {
				$.messager.alert("提示", data.msg);
			}
		});
	}
	
	function deleteSkuProper(id,catalogId){
		$.messager.confirm("提示", "确定删除吗？", function() {
			//删除分类属性，并重新通过分类ID加载分类属性面板内容
			$("#skuPropertyPanel").load("/deleteSkuProperty.do?id="+id+"&catalogId="+catalogId);
		});
		/* $.get("/deleteCatalogProper.do?id="+catalogId,function(data){
			if(data.success){
				$(obj).parent().parent().remove();
			}else{
				$.messager.alert("提示", data.msg);
			}
		}) */
	}
</script>
</head>
<body>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3"><#assign currentMenu="skuProperty" />
				<#include "../common/menu.ftl" /></div>
			<div class="col-sm-9">


				<div class="page-header">
					<h3>sku属性管理</h3>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<ul id="catalogTree" class="ztree"></ul>
					</div>
					<div class="col-sm-8"  id="skuPropertyPanel">
						
					</div>
				</div>
			</div>
		</div>
		
		
		<!-- 新增分类属性值模态框 -->
		<div class="modal fade" id="propertyValueModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">分类属性值</h4>
					</div>
					
					<!-- 提交添加分类属性值的表单 -->
					<form action="/addSkuPropertyValue.do" method="post" id="skuPropertyValueForm">
						
					</form>
				</div>
			</div>
		</div>
		
		<!-- 新增分类属性模态框 -->
		<div class="modal fade" id="propertyModal">
			<div class="modal-dialog" >
				<div class="modal-content" id="propertyFormContent"></div>
			</div>
		</div>
	</div>
</body>
</html>







