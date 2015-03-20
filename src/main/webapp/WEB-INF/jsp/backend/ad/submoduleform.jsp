<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>长虹机顶盒后台管理系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/default/jquery-ui-1.8.22.custom.css" type="text/css"/>
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
            <spring-form:form id="subModuleForm" commandName="subModule" method="POST" cssClass="form">
                <table cellspacing="0" width="100%">
                    <input type="hidden" name="id" value="${subModule.id}"/>
                    <input type="hidden" name="current" value="${current}"/>
                    <input type="hidden" name="moduleAdvertisementId" value="${moduleAdvertisementId}"/>

                    <tr valign="top">
                        <td width="200px;">
                             子模块编号 <span class="required">*</span>
                        </td>
                        <td>
                            <c:if test="${subModule.sequence > 0}">
                                编号${subModule.sequence}
                            </c:if>
                            <c:if test="${subModule.sequence <= 0}">
                                新建子模块
                            </c:if>
                        </td>
                    </tr>

                    <tr valign="top">
                        <td width="200px;">
                             子模块名称 <span class="required">*</span>
                        </td>
                        <td>
                            <spring-form:input id="moduleTitle" path="moduleTitle" maxlength="110" cssStyle="width:300px;"/>&nbsp;
                            <spring-form:errors path="moduleTitle" cssClass="required"/>
                        </td>
                    </tr>

                    <tr valign="top"  id="address_eara">
                        <td width="200px;">
                             子模块地址 <span class="required">*</span
                        </td>
                        <td>
                            <spring-form:input id="moduleUrl" path="moduleUrl" maxlength="230" cssStyle="width:510px;"/>&nbsp;
                            如：http://www.baidu.com
                            <spring-form:errors path="moduleUrl" cssClass="required"/>
                        </td>
                    </tr>

                    <tr valign="top">
                        <td width="200px;">
                             子模块描述
                        </td>
                        <td>
                            <spring-form:textarea id="moduleDescription" path="moduleDescription" cols="80" rows="8"/>&nbsp;
                            <spring-form:errors path="moduleDescription" cssClass="required"/>
                        </td>
                    </tr>

                    <tr valign="top">
                        <td>
                        </td>
                        <td>
                            <button type="button" class="thoughtbotform" onclick="window.location.href='${pageContext.request.contextPath}/backend/submoduleoverview.html?moduleAdvertisementId=${moduleAdvertisementId}'">
                                返回
                            </button>
                        	<button name="" type="button" class="thoughtbotform" onclick="submitSubModuleForm(this.form)">保存</button>
                        </td>
                    </tr>
                </table>
            </spring-form:form>
        </td>
    </tr>
</table>

<script type="text/javascript">
    function submitSubModuleForm(form) {
        form.submit();
    }
</script>
</body>
</html>