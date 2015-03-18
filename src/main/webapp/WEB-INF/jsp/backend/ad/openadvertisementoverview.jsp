<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>
<html>
<head>
    <title>长虹机顶盒后台管理系统</title>
    <script type="text/javascript">

        function openAdvertisementDeleteConfirm() {
            return confirm('确定要删除该开机广告吗?');
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
        <td valign="top">
            <div style="float: left; padding-right: 5px; padding-top: 5px; padding-left: 5px;">
                <a href="${pageContext.request.contextPath}/backend/openadvertisementform.html"><button class="thoughtbot">添加开机广告</button></a>
            </div>

            <form action="#" class="search_form" method="POST">
                <div class="search" style="height: 20px;">
                </div>
            </form>

            <table width="100%" cellpadding="0" cellspacing="0" class="list">
                <thead>
                    <td width="5%">&nbsp;&nbsp;编号</td>
                    <td width="25%">描述</td>
                    <td width="45%">广告地址</td>
                    <td>操作</td>
                </thead>
                <tbody>
                <c:set var="turns" value="true"/>
                <c:forEach items="${ads}" var="ad">
                    <c:set var="color" value="${turns ? 'r1' :'r2'}"/>
                    <tr class="${color}" onmouseover="this.className='over'" onmouseout="this.className='${color}'">
                    <c:set var="turns" value="${!turns}"/>
                        <td>&nbsp;&nbsp;${ad.sequence}</td>
                        <td>${ad.advertisementTitle} </td>
                        <td><a href="${applicationWebAddress}${ad.advertisementActualFileName}" target="_blank">${applicationWebAddress}${ad.advertisementActualFileName}</a></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/backend/openadvertisementform.html?openAdvertisementId=${ad.id}&current=${current}"><button class="thoughtbot">编辑</button></a>
                            <a href="${pageContext.request.contextPath}/backend/openadvertisementdelete.html?openAdvertisementId=${ad.id}&current=${current}" onclick="return openAdvertisementDeleteConfirm();"><button class="thoughtbot">删除</button></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="paging">
                <ch:paging urlMapping="${pageContext.request.contextPath}/backend/openadvertisementoverview.html" showGoTo="false" paging="${paging}"/>
            </div>
        </td>
    </tr>
</table>
</body>
</html>