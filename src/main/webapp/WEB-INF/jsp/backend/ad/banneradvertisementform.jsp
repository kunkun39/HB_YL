<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>长虹机顶盒后台管理系统</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui/jquery-ui-1.8.16.custom.min.js"
            type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/default/jquery-ui-1.8.22.custom.css"
          type="text/css"/>
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
            <spring-form:form id="bannerAdvertisementForm" commandName="bannerAdvertisement" method="POST"
                              cssClass="form" enctype="multipart/form-data">
                <table cellspacing="0" width="100%">
                    <input type="hidden" name="id" value="${bannerAdvertisement.id}"/>
                    <input type="hidden" name="advertisementFileId" value="${bannerAdvertisement.advertisementFileId}"/>

                    <tr valign="top">
                        <td width="200px;">
                            广告描述 <span class="required">*</span>
                        </td>
                        <td>
                            <spring-form:input id="advertisementTitle" path="advertisementTitle" maxlength="100"
                                               cssStyle="width:300px;"/>&nbsp;
                            <spring-form:errors path="advertisementTitle" cssClass="required"/>
                        </td>
                    </tr>

                    <tr valign="top">
                        <td width="200px;">
                            广告对应频道 <br/>
                            (请输入数字)
                        </td>

                        <td>
                            <spring-form:input id="serviceId" path="serviceId" maxlength="8" cssStyle="width:300px;"/>&nbsp;
                            <spring-form:errors path="serviceId" cssClass="required"/>
                        </td>
                    </tr>

                    <tr valign="top">
                        <td width="200px;" valign="top">
                            选择广告图片 <span class="required">*</span><br/>(支持PNG, JEPG, JPG, BMP格式上传)
                        </td>
                        <td>
                            <input type="file" id="advertisementFile" name="advertisementFile" class="file"
                                   style="width:300px;"/>
                            <c:if test="${bannerAdvertisement.advertisementFileId > 0}">
                                <br/>
                                <br/>
                                已上传文件:${bannerAdvertisement.advertisementUploadFileName}
                                <br/>
                                <br/>
                                <img src="${applicationWebAddress}${bannerAdvertisement.advertisementActualFileName}"
                                     style="width: 600px;"/>
                            </c:if>
                            <spring-form:errors path="advertisementFile" cssClass="required"/>
                        </td>
                    </tr>

                    <tr>
                        <td>
                        </td>
                        <td>
                            <button type="button" class="thoughtbotform"
                                    onclick="window.location.href='${pageContext.request.contextPath}/backend/banneradvertisementoverview.html?current=${current}'">
                                返回
                            </button>
                            <button name="" type="button" class="thoughtbotform"
                                    onclick="submitOpenAdvertisementForm(this.form)">保存
                            </button>
                        </td>
                    </tr>
                </table>
            </spring-form:form>
        </td>
    </tr>
</table>

<script type="text/javascript">
    function submitOpenAdvertisementForm(form) {
        var advertisementFilename = jQuery("#advertisementFile").val();

        if (advertisementFilename != undefined && advertisementFilename != '') {
            var endDot = advertisementFilename.lastIndexOf('.');
            var fileSuffix = advertisementFilename.substring(endDot, advertisementFilename.length).toUpperCase();
            if (fileSuffix != '.BMP' && fileSuffix != '.PNG' && fileSuffix != '.GIF' && fileSuffix != '.JPG' && fileSuffix != '.JPEG') {
                alert("请选择正确的图片文件");
            } else {
                form.submit();
            }
        } else {
            form.submit();
        }
    }
</script>
</body>
</html>