<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>蓝源Eloan-P2P平台(系统管理平台)</title>
<#include "../common/header.ftl"/>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/plugins/uploadify/jquery.uploadify.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#addButton").click(function () {
                $("#myModal").modal("show");
                $("#code").val("");
                $("#name").val("");
            });
            /*	$("#query").click(function(){
                    $("#currentPage").val(1);
                    $("#searchForm").submit();
                });*/

            $(".auditClass").click(function () {
                $("#myModal").modal("show");
                var data = $(this).data("json");
                $("#myModal [name=id]").val(data.id);
                $("#myModal [name=name]").html(data.name);
                $("#myModal [name=englishName]").html(data.englishName);
                $("#myModal [name=url]").html(data.url);
                $("#myModal [name=describe]").html(data.describe);
                $("#myModal [name=sort]").html(data.sort);
                $("#myModal [name=state]").html(data.state);
            });
            /*  $("#uploadBtn2").uploadify({
                  swf: "/js/plugins/uploadify/uploadify.swf",
                  uploader:"/uploadImg.do",
                  buttonText:"上传LOGO",
                  fileObjName:"img",
                  fileTypeExts:"*.jpg;*.bmp;*.png;*.jpeg",
                  multi:false,
                  ovverrideEvents:["onUploadSuccess","onSelect"],
                  onUploadSuccess:function(file,data){
                      $("#uploadImg2").attr("src",data);
                  }
              });*/
            $("#asubmit").click(function () {
                var form = $("#editform");
//            form.find("[name=state]").val($(this).val());
                $("#myModal").modal("hide");
                form.ajaxSubmit(function (data) {
                    if (data.success) {
                        $.messager.confirm("提示", "增加成功!", function () {
                            window.location.reload();
                        });
                    }
                });
                return false;
            });


        });
        //删除分类
        function deleteTrademark(id){
            $.get("/deletetrademark.do?trademarkId="+id,
                    function(data){
                        if (data.success) {
                            $.messager.confirm("提示", "删除成功!", function() {
                                window.location.reload();
                            });
                        } else {
                            $.messager.alert("提示", data.msg);
                        }
                    }
            );
        }

    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
        </div>
        <div class="col-sm-9">
            <div class="page-header">
                <h3>品牌管理</h3>
                <button type="button" class="btn btn-primary" id="addButton">新增</button>

            </div>
            <form id="searchForm" class="form-inline" method="post" action="/trademark.do">
                <input type="hidden" id="currentPage" name="currentPage" value=""/>
            </form>
            <div class="panel panel-default">
                <table class="table">
                    <thead>
                    <tr>
                        <th>品牌名称</th>
                        <th>品牌英文名称</th>
                        <th>品牌网址</th>
                        <th>备注</th>
                        <th>序号</th>
                        <th>显示</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list pageResult as data>
                    <tr>
                        <td>${data.name!""}</td>
                        <td>${data.englishName!""}</td>
                        <td>${data.url!""}</td>
                        <td>${data.describe!""}</td>
                        <td>${data.sort!""}</td>
                        <td>${data.stateDisplay!""}</td>
                        <td>
                            <a href="javascript:void(-1);" class="auditClass" data-json='${data.jsonString}'>编辑</a>
                            |
                            <button type="button" class="auditClass"
                                    data-dismiss="modal"  onclick="deleteTrademark(${data.id})">删除</button>
                        </td>
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
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <form class="form-horizontal" id="editform" method="post" action="/trademarkSave.do"
                          novalidate="novalidate">
                        <fieldset>
                            <div id="legend" class="">
                                <legend>商品管理</legend>
                            </div>

                            <input type="hidden" name="id" value=""/>
                            <div class="form-group">
                                <label class="col-sm-2  control-label" for="name">品牌中文名称</label>
                                <div class="col-sm-6">
                                    <input id="" class="form-control" name="name" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2  control-label" for="englishName">品牌英文名称</label>
                                <div class="col-sm-6">
                                    <input id="" class="form-control" name="englishName" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2  control-label" for="url">品牌网址</label>
                                <div class="col-sm-6">
                                    <input id="" class="form-control" name="url" type="text">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="img">品牌LOGO</label>
                                <div class="col-sm-6">
                                    <div class="form-group">
                                        <label class="col-sm-4  control-label" for="address"></label>
                                        <div class="col-sm-8">
                                        <#--    <div class="idCardItem">
                                                    <div>
                                                        <a href="javascript:;" id="uploadBtn2">品牌LOGO</a>
                                                    </div>
                                                    <img alt="" src="" class="uploadImg" id="uploadImg2"/>
                                                    <input type="hidden" name="img" id="uploadImage2"/>
                                                </div>-->
                                            <div class="image-div">
                                                <div>
                                                    <a href="javascript:;" id="uploadImage-btn"
                                                       class="js-upload">上传LOGO</a>
                                                </div>
                                                <img class="uploadImg"> <input type="hidden" name="img">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <#--更新图片-->

                <div class="form-group">
                    <label class="col-sm-2  control-label" for="describe">品牌描述</label>
                    <div class="col-sm-6">
                        <input id="" class="form-control" name="describe" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2  control-label" for="sort">排序</label>
                    <div class="col-sm-6">
                        <input id="" class="form-control" name="sort" type="text">
                    </div>
                </div>
                </fieldset>
                </form>
            </div>
            <div class="form-group">

                <button type="submit" id="asubmit" class="btn btn-primary col-sm-offset-4" data-loading-text="正在提交">
                    <i class="icon-ok"></i> 提交
                </button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="reset" id="rre" class="btn btn-primary col-sm-offset-4">重置</button>
            </div>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">
    $("#uploadImage-btn").uploadify(
            {
                buttonText: "上传LOGO",
                fileObjName: "file",
                fileTypeDesc: "商品图片",
                fileTypeExts: "*.gif; *.jpg; *.png",
                swf: "/js/plugins/uploadify/uploadify.swf",
                uploader: "/trademarkImgUpload.do",
                overrideEvents: ["onUploadSuccess", "onUploadProgress",
                    "onSelect"],
                onUploadSuccess: function (file, data) {
                    console.debug(data);
                    var $wrapper = this.wrapper;
                    var $div = $wrapper.parent('div').parent('div');
                    //data = JSON.parse(data);
                    $div.find('img').attr('src', data);
                    $div.find('input').val(data);
                }
            }
    );

</script>
</body>
</html>
