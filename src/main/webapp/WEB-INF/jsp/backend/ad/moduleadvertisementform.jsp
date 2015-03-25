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
            <spring-form:form id="moduleAdvertisementForm" commandName="moduleAdvertisement" method="POST" cssClass="form">
                <table cellspacing="0" width="100%">
                    <input type="hidden" name="id" value="${moduleAdvertisement.id}"/>

                    <tr valign="top">
                        <td width="200px;">
                             模块编号 <span class="required">*</span>
                        </td>
                        <td>
                            <spring-form:input id="sequence" path="sequence" maxlength="10" cssStyle="width:300px;" readonly="true"/>&nbsp;
                        </td>
                    </tr>

                    <tr valign="top">
                        <td width="200px;">
                             模块名称 <span class="required">*</span>
                        </td>
                        <td>
                            <spring-form:input id="moduleTitle" path="moduleTitle" maxlength="110" cssStyle="width:300px;"/>&nbsp;
                            <spring-form:errors path="moduleTitle" cssClass="required"/>
                        </td>
                    </tr>

                    <tr valign="top">
                        <td width="200px;">
                             包含子模块 <span class="required">*</span>
                        </td>
                        <td>
                            <spring-form:checkbox id="includeSub" path="includeSub"/>&nbsp;
                            如果选中，模块地址可以为空; 如果没勾选，那么模块地址不能为空
                        </td>
                    </tr>

                    <tr valign="top"  id="address_eara">
                        <td width="200px;">
                             模块地址
                        </td>
                        <td>
                            <spring-form:input id="moduleUrl" path="moduleUrl" maxlength="230" cssStyle="width:510px;"/>&nbsp;
                            如：http://www.baidu.com
                            <spring-form:errors path="moduleUrl" cssClass="required"/>
                        </td>
                    </tr>

                    <tr valign="top">
                        <td width="200px;">
                             模块描述
                        </td>
                        <td>
                            <spring-form:textarea id="moduleDescription" path="moduleDescription" cols="105" rows="8"/>&nbsp;
                            <spring-form:errors path="moduleDescription" cssClass="required"/>
                        </td>
                    </tr>

                    <tr valign="top">
                        <td>
                        </td>
                        <td>
                            <button type="button" class="thoughtbotform" onclick="window.location.href='${pageContext.request.contextPath}/backend/moduleadvertisementoverview.html'">
                                返回
                            </button>
                        	<button name="" type="button" class="thoughtbotform" onclick="submitModuleAdvertisementForm(this.form)">保存</button>
                        </td>
                    </tr>
                </table>
            </spring-form:form>
        </td>
    </tr>
</table>

<script type="text/javascript">
    function submitModuleAdvertisementForm(form) {
        form.submit();
    }
</script>
</body>
</html>