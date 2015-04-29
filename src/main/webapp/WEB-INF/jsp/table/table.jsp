<%@ page language="java"  contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>table操作</title>
<script src="/js/jquery-1.10.1.js" type="text/javascript"></script>
<link href="/css/table1.css" rel="stylesheet" type="text/css">

<style>
    /*table{border-collapse: collapse; border-spacing: 0;margin-right: auto;margin-left: auto;width: 800px;}*/
    /*th, td{border: 1px solid #b5d6e6;font-size: 12px; font-weight: normal;text-align: center;vertical-align: middle;height: 20px;}*/
    /*th {background-color: Gray;}*/
</style>
<script>
    $(document).ready(function(){
        $(".delete").click(function(){
            alert(123);
            var id = $(this).attr("tId");
            var url = baseurl + "/table/delete?userId=" + id;
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
                        if(date.code == "OK") {
                            alert("删除成功");
                        }else{
                            alert("删除成功");
                        }
                    }
                });
            }
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
                    <input type="checkbox">
                </td>
                <td>${var.userId}</td>
                <td>${var.userName}</td>
                <td><fmt:formatDate value="${var.lastVisit}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td>
                    <a href="javascript:void(0)" class="delete" tId="${var.userId}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>