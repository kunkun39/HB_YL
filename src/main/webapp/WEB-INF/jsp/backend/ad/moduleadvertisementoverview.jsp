<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="ch" uri="http://www.chanhong.com" %>
<html>
<head>
    <title>长虹机顶盒后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/theme/default/module.css" type="text/css"/>
    <script type="text/javascript">

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
            <div class="tv_main">
                <div class="preview">
                    <div class="wrap">
                        <img src="${pageContext.request.contextPath}/theme/default/module/tv.jpg" />
                    </div>
                </div>

                <div class="channel">
                    <ul class="list">
                        <li class="c1">
                            <a class="flag">&nbsp;模块一</a>
                            <a class="edit" href="${pageContext.request.contextPath}/backend/moduleadvertisementform.html?moduleAdvertisementId=${ad1.id}">编辑</a>
                            <c:if test="${ad1.includeSub}">
                                <a class="edit1" href="${pageContext.request.contextPath}/backend/submoduleoverview.html?moduleAdvertisementId=${ad1.id}">子模块</a>
                            </c:if>
                            <c:if test="${!ad1.includeSub}">
                                <a class="edit2" href="${ad1.moduleUrl}" target="_blank">连接</a>
                            </c:if>
                                <p class="icon ico1"></p>
                                <p class="name">${ad1.moduleTitle}</p>
                            </a>
                        </li>

                        <li class="c2">
                            <a class="flag">&nbsp;模块二</a>
                            <a class="edit" href="${pageContext.request.contextPath}/backend/moduleadvertisementform.html?moduleAdvertisementId=${ad2.id}">编辑</a>
                            <c:if test="${ad2.includeSub}">
                                <a class="edit1" href="${pageContext.request.contextPath}/backend/submoduleoverview.html?moduleAdvertisementId=${ad2.id}">子模块</a>
                            </c:if>
                            <c:if test="${!ad2.includeSub}">
                                <a class="edit2" href="${ad2.moduleUrl}" target="_blank">连接</a>
                            </c:if>
                                <p class="icon ico2"></p>
                                <p class="name">${ad2.moduleTitle}</p>
                            </a>
                        </li>

                        <li class="c3">
                            <a class="flag">&nbsp;模块三</a>
                            <a class="edit" href="${pageContext.request.contextPath}/backend/moduleadvertisementform.html?moduleAdvertisementId=${ad3.id}">编辑</a>
                            <c:if test="${ad3.includeSub}">
                                <a class="edit1" href="${pageContext.request.contextPath}/backend/submoduleoverview.html?moduleAdvertisementId=${ad3.id}">子模块</a>
                            </c:if>
                            <c:if test="${!ad3.includeSub}">
                                <a class="edit2" href="${ad3.moduleUrl}" target="_blank">连接</a>
                            </c:if>
                                <p class="icon ico3"></p>
                                <p class="name">${ad3.moduleTitle}</p>
                            </a>
                        </li>

                        <li class="c4">
                            <a class="flag">&nbsp;模块四</a>
                            <a class="edit" href="${pageContext.request.contextPath}/backend/moduleadvertisementform.html?moduleAdvertisementId=${ad4.id}">编辑</a>
                            <c:if test="${ad4.includeSub}">
                                <a class="edit1" href="${pageContext.request.contextPath}/backend/submoduleoverview.html?moduleAdvertisementId=${ad4.id}">子模块</a>
                            </c:if>
                            <c:if test="${!ad4.includeSub}">
                                <a class="edit2" href="${ad4.moduleUrl}" target="_blank">连接</a>
                            </c:if>
                                <p class="icon ico4"></p>
                                <p class="name">${ad4.moduleTitle}</p>
                            </a>
                        </li>

                        <li class="c5">
                            <a class="flag">&nbsp;模块五</a>
                            <a class="edit" href="${pageContext.request.contextPath}/backend/moduleadvertisementform.html?moduleAdvertisementId=${ad5.id}">编辑</a>
                            <c:if test="${ad5.includeSub}">
                                <a class="edit1" href="${pageContext.request.contextPath}/backend/submoduleoverview.html?moduleAdvertisementId=${ad5.id}">子模块</a>
                            </c:if>
                            <c:if test="${!ad5.includeSub}">
                                <a class="edit2" href="${ad5.moduleUrl}" target="_blank">连接</a>
                            </c:if>
                                <p class="icon ico5"></p>
                                <p class="name">${ad5.moduleTitle}</p>
                            </a>
                        </li>

                        <li class="c6">
                            <a class="flag">&nbsp;模块六</a>
                            <a class="edit" href="${pageContext.request.contextPath}/backend/moduleadvertisementform.html?moduleAdvertisementId=${ad6.id}">编辑</a>
                            <c:if test="${ad6.includeSub}">
                                <a class="edit1" href="${pageContext.request.contextPath}/backend/submoduleoverview.html?moduleAdvertisementId=${ad6.id}">子模块</a>
                            </c:if>
                            <c:if test="${!ad6.includeSub}">
                                <a class="edit2" href="${ad6.moduleUrl}" target="_blank">连接</a>
                            </c:if>
                                <p class="icon ico6"></p>
                                <p class="name">${ad6.moduleTitle}</p>
                            </a>
                        </li>

                        <li class="c7">
                            <a class="flag">&nbsp;模块七</a>
                            <a class="edit" href="${pageContext.request.contextPath}/backend/moduleadvertisementform.html?moduleAdvertisementId=${ad7.id}">编辑</a>
                            <c:if test="${ad7.includeSub}">
                                <a class="edit1" href="${pageContext.request.contextPath}/backend/submoduleoverview.html?moduleAdvertisementId=${ad7.id}">子模块</a>
                            </c:if>
                            <c:if test="${!ad7.includeSub}">
                                <a class="edit2" href="${ad7.moduleUrl}" target="_blank">连接</a>
                            </c:if>
                                <p class="icon ico7"></p>
                                <p class="name">${ad7.moduleTitle}</p>
                            </a>
                        </li>

                        <li class="c8">
                            <a class="flag">&nbsp;模块八</a>
                            <a class="edit" href="${pageContext.request.contextPath}/backend/moduleadvertisementform.html?moduleAdvertisementId=${ad8.id}">编辑</a>
                            <c:if test="${ad8.includeSub}">
                                <a class="edit1" href="${pageContext.request.contextPath}/backend/submoduleoverview.html?moduleAdvertisementId=${ad8.id}">子模块</a>
                            </c:if>
                            <c:if test="${!ad8.includeSub}">
                                <a class="edit2" href="${ad8.moduleUrl}" target="_blank">连接</a>
                            </c:if>
                                <p class="icon ico8"></p>
                                <p class="name">${ad8.moduleTitle}</p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </td>
    </tr>
</table>
</body>
</html>