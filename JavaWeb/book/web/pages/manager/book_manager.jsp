<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>图书管理</title>
    <%-- 静态包含base标签，css样式，jQuery文件--%>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">

        $(function () {
            var $deleteClass = $("a.deleteClass");
            $deleteClass.click(function () {
                return confirm("你确认要删除【" + $(this).parent().parent().find("td:first").text() + "】");
            })
        })
        /*
                $(function () {

                    $("a.deleteClass").click(function () {
                        /!**
                         * confirm确认提示框函数
                         * 参数是它的提示内容
                         * 它有两个按钮，一个是确认，一个是取消
                         *!/

                        return confirm("你确认要删除【"+ $(this).parent().parent().find("td:first").text() +"】");

                    });

                });*/
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%-- 静态包含manager管理模块的菜单--%>
    <%@include file="/pages/common/manager_menu.jsp" %>

</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>
    <%--静态包含分页体条--%>
    <%@include file="/pages/common/page_nav.jsp"%>

</div>

<%-- 静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>
</body>
</html>