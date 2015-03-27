<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>
<html>
<head>
    <title>长虹机顶盒后台管理系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/default/jquery-ui-1.8.22.custom.css" type="text/css"/>
    <script type="text/javascript">

        function userDeleteConfirm(userId, filername, current) {
            jQuery("#userenable-dialog-confirm").dialog({
                    resizable: false,
                    height:140,
                    modal: true,
                    buttons: {
                        "确  认": function() {
                            jQuery(this).dialog("close");

                            window.location.href = '${pageContext.request.contextPath}/backend/userchangeenable.html?userId=' + userId + '&filername=' + filername + '&current=' + current;
                        },
                        "取  消": function() {
                            jQuery(this).dialog("close");
                        }
                    }
                });
        }

        function userEnableConfirm(userId, filername, current) {
            jQuery("#userdisable-dialog-confirm").dialog({
                    resizable: false,
                    height:140,
                    modal: true,
                    buttons: {
                        "确  认": function() {
                            jQuery(this).dialog("close");
                            window.location.href = '${pageContext.request.contextPath}/backend/userchangeenable.html?userId=' + userId + '&filername=' + filername + '&current=' + current;
                        },
                        "取  消": function() {
                            jQuery(this).dialog("close");
                        }
                    }
                });
        }
    </script>
</head>
<body>
<div class="action">
    &nbsp;
</div>
<table cellpadding="0" cellspacing="0" width="100%" class="box">
    <tr>
        <td width="200" valign="top" style="background: #e8e8e8;border-right: 1px solid #CCC;">
            <jsp:include page="../systemtype.jsp"/>
        </td>
        <td valign="top">
            <div style="float: left; padding-right: 5px; padding-top: 5px; padding-left: 5px;">
                <a href="#" onclick="window.location.href='${pageContext.request.contextPath}/backend/userform.html'"><button class="thoughtbot">添加用户</button></a>
            </div>
            <form action="${pageContext.request.contextPath}/backend/useroverview.html" class="search_form" method="POST">
                <div class="search">
                    <span><label>姓名:</label><input type="text" name="filername" class="text" value="${paging.name}"/></span>
                    <input type="button" value="查询" onclick="this.form.submit();"/>
                </div>
            </form>

            <table width="100%" cellpadding="0" cellspacing="0" class="list">
                <thead>
                <td width="10%">&nbsp;&nbsp;姓名</td>
                <td width="10%">编号</td>
                <td width="10%">密码</td>
                <td width="45%">联系方式</td>
                <td width="5%">状态</td>
                <td>操作</td>
                </thead>
                <tbody>
                <c:set var="turns" value="true"/>
                <c:forEach items="${users}" var="user">
                    <c:set var="color" value="${turns ? 'r1' :'r2'}"/>
                    <tr class="${color}" onmouseover="this.className='over'" onmouseout="this.className='${color}'">
                    <c:set var="turns" value="${!turns}"/>
                        <td>&nbsp;&nbsp;${user.name}</td>
                        <td>${user.username} </td>
                        <td>${user.password}</td>
                        <td>${user.contactWay}</td>
                        <td>
                            <c:if test="${user.enabled}">
                                在用
                            </c:if>
                            <c:if test="${!user.enabled}">
                                停止使用
                            </c:if>
                        </td>
                        <td>
                            <a href="#" onclick="window.location.href='${pageContext.request.contextPath}/backend/userform.html?userId=${user.id}&filername=${filername}&current=${current}'"><button class="thoughtbot">编辑</button></a>

                            <c:if test="${user.username != 'hbyladmin'}">
                                <c:if test="${user.enabled}">
                                    <a href="#" onclick="return userDeleteConfirm('${user.id}', '${filername}', '${current}');"><button class="thoughtbot">停用</button></a>
                                </c:if>
                                <c:if test="${!user.enabled}">
                                    <a href="#" onclick="return userEnableConfirm('${user.id}', '${filername}', '${current}');"><button class="thoughtbot">激活</button></a>
                                </c:if>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="paging">
                <ch:paging urlMapping="${pageContext.request.contextPath}/backend/useroverview.html" showGoTo="false" paging="${paging}"/>
            </div>
        </td>
    </tr>
</table>

<div id="userenable-dialog-confirm" title="确认对话框?">
    <p>
        <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
        请确认你是否要停止该用户使用本系统？
    </p>
</div>

<div id="userdisable-dialog-confirm" title="确认对话框?">
    <p>
        <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
        请确认你是否要激活该用户使用本系统？
    </p>
</div>

</body>
</html>