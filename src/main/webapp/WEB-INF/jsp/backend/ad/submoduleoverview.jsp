<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>
<html>
<head>
    <title>长虹机顶盒后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/default/module.css" type="text/css"/>
    <script type="text/javascript">
        function moduleDeleteConfirm() {
            return confirm('确定要删除该子连接吗?');
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
            <jsp:include page="../adtype.jsp"/>
        </td>

        <td valign="top" class="tv_main_bg">

            <div class="tv_header">
                <p class="title">
                    ${moduleAdvertisement.moduleTitle}
                    <a href="${pageContext.request.contextPath}/backend/submoduleform.html"><button class="thoughtbot">添加子连接</button></a>
                </p>
            </div>
            <div class="tv_main">
                <c:forEach items="${modules}" var="module" varStatus="counter">
                    <c:if test="${counter.count == 1}">
                        <ul class="sub_channel">
                    </c:if>
                    <c:if test="${counter.count == 7}">
                        </ul>
                        <ul class="sub_channel">
                    </c:if>
                    <li class="bg${counter.count}" <c:if test="${counter.count == 1 || counter.count == 7}">style="margin-left:0;"</c:if>>
                        <a class="edit" href="${pageContext.request.contextPath}/backend/submoduleform.html?subModuleId=${module.id}&moduleAdvertisementId=${moduleAdvertisement.id}&current=${current}">编辑</a>
                        <a class="edit1" href="${pageContext.request.contextPath}/backend/submoduledelete.html?subModuleId=${module.id}&moduleAdvertisementId=${moduleAdvertisement.id}&current=${current}" onclick="return moduleDeleteConfirm();">删除</a>
                        <p class="title">${module.moduleTitle}</p>
                    </li>
                    <c:if test="${counter.count == 12}">
                        </ul>
                    </c:if>
                </c:forEach>
            </div>

            <div class="paging">
                <ch:paging urlMapping="${pageContext.request.contextPath}/backend/submoduleoverview.html" showGoTo="false" paging="${paging}"/>
            </div>
        </td>
    </tr>
</table>
</body>
</html>