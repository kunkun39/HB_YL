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
                            <a class="edit" href="${pageContext.request.contextPath}/backend/moduleadvertisementform.html">编辑</a>
                            <a class="c" href="${ad1.moduleUrl}">
                                <p class="icon ico1"></p>
                                <p class="name">${ad1.moduleTitle}</p>
                            </a>
                        </li>
                        <li class="c2">
                            <a class="edit" href="javascript:;">编辑</a>
                            <a class="c" href="${ad2.moduleUrl}">
                                <p class="icon ico2"></p>
                                <p class="name">${ad2.moduleTitle}</p>
                            </a>
                        </li>
                        <li class="c3">
                            <a class="edit" href="javascript:;">编辑</a>
                            <a class="c" href="${ad3.moduleUrl}">
                                <p class="icon ico3"></p>
                                <p class="name">${ad3.moduleTitle}</p>
                            </a>
                        </li>
                        <li class="c4">
                            <a class="edit" href="javascript:;">编辑</a>
                            <a class="c" href="${ad4.moduleUrl}">
                                <p class="icon ico4"></p>
                                <p class="name">${ad4.moduleTitle}</p>
                            </a>
                        </li>
                        <li class="c5">
                            <a class="edit" href="javascript:;">编辑</a>
                            <a class="c" href="${ad5.moduleUrl}">
                                <p class="icon ico5"></p>
                                <p class="name">${ad5.moduleTitle}</p>
                            </a>
                        </li>
                        <li class="c6">
                            <a class="edit" href="javascript:;">编辑</a>
                            <a class="c" href="${ad6.moduleUrl}">
                                <p class="icon ico6"></p>
                                <p class="name">${ad6.moduleTitle}</p>
                            </a>
                        </li>
                        <li class="c7">
                            <a class="edit" href="javascript:;">编辑</a>
                            <a class="c" href="${ad7.moduleUrl}">
                                <p class="icon ico7"></p>
                                <p class="name">${ad7.moduleTitle}</p>
                            </a>
                        </li>
                        <li class="c8">
                            <a class="edit" href="javascript:;">编辑</a>
                            <a class="c" href="${ad8.moduleUrl}">
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