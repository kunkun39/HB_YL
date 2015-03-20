<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>
<html>
<head>
    <title>长虹机顶盒后台管理系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/default/jquery-ui-1.8.22.custom.css" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/default/module.css" type="text/css"/>

    <script type="text/javascript">
        function moduleDeleteConfirm(subModuleId, moduleId, current) {
            jQuery("#submodule-dialog-confirm").dialog({
                    resizable: false,
                    height:140,
                    modal: true,
                    buttons: {
                        "确  认": function() {
                            jQuery(this).dialog("close");

                            window.location.href = '${pageContext.request.contextPath}/backend/submoduledelete.html?subModuleId=' + subModuleId + '&moduleAdvertisementId=' + moduleId + '&current=' + current;
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
            <jsp:include page="../adtype.jsp"/>
        </td>

        <td valign="top" class="tv_main_bg">

            <div class="tv_header">
                <p class="title">
                    ${moduleAdvertisement.moduleTitle}
                    <a href="${pageContext.request.contextPath}/backend/submoduleform.html?moduleAdvertisementId=${moduleAdvertisement.id}"><button class="thoughtbot">添加子模块</button></a>
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
                        <a class="flag" href="#">子模块${module.sequence}</a>
                        <a class="edit" href="${pageContext.request.contextPath}/backend/submoduleform.html?subModuleId=${module.id}&moduleAdvertisementId=${moduleAdvertisement.id}&current=${current}">编辑</a>
                        <a class="edit1" href="#" onclick="return moduleDeleteConfirm('${module.id}','${moduleAdvertisement.id}','${current}');">删除</a>
                        <a href="${module.moduleUrl}" target="_blank">
                            <p class="title">${module.moduleTitle}</p>
                        </a>
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

<div id="submodule-dialog-confirm" title="确认对话框?">
    <p>
        <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
        请确认你是否要删除该子模块吗？
    </p>
</div>

</body>
</html>