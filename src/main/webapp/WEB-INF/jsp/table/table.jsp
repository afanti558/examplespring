<%@ page language="java"  contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>table操作</title>
<script type="text/javascript" src="/js/jquery-2.1.3.js"></script>
<link rel="stylesheet" type="text/css" href="/css/table1.css">

<style>

</style>
<script>
    var checkArray= new Array();
    $(document).ready(function(){
        $(".delete").click(function(){
            var id = $(this).attr("tId");
            var url = "/table/delete?userId=" + id;
            alert(url);
            if(confirm("确定删除吗？")) {
                $.ajax({
                    url:url,
                    type:"POST",
                    contentType : "application/json;charset=UTF-8",
                    dataType:"json",
                    timeout: "10000",
                    data:
                    {
                        "userId":id
                    },
                    success:function(data){
                        alert(1);
                    },
                    error:function(){
                        alert(2);
                        $("." + id).remove();//删除表格当前行

                    }
                });
            }
        });

        $(".update").click(function(){
            var id = $(this).attr("tId");
            $("." + id).find(".name").html("new name");
        });


        //全选   反选
        $('.checkAll,.reCheckAll').click(function(){
            $('INPUT[name=id]').attr("checked","checked");
            checkArray.push($(this).val());
        });

        //取消
        $('.unCheckAll').click(function(){
            $("input[name=id]").each(function(){
                alert($(this).attr("checked"));
                if (true==$(this).attr("checked")) {//如果为选中状态
                    $(this).click();
                }
            });
        });




    });

</script>
</head>
<body>
    <table>
        <tr>
            <th style="width: 160px;">选择</th>
            <th style="width: 160px;">编号</th>
            <th style="width: 160px;">姓名</th>
            <th style="width: 160px;">访问日期</th>
            <th style="width: 160px;">操作</th>
        </tr>
        <c:forEach items="${list}" var="var">
            <tr class="${var.userId}">
                <td>
                    <input type="checkbox" name="id" value="${var.userId}">
                </td>
                <td class="id">${var.userId}</td>
                <td class="name">${var.userName}</td>
                <td class="date"><fmt:formatDate value="${var.lastVisit}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td class="option">
                    <a href="javascript:void(0)" class="delete" tId="${var.userId}">删除</a>
                    <a href="javascript:void(0)" class="update" tId="${var.userId}">改名</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" class="checkAll" value="全选"/>
    <input type="button" class="unCheckAll" value="取消"/>
    <input type="button" class="reCheckAll" value="反选"/>
    <h2>${handlingTime}</h2>
</body>
</html>