<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
	<title>湖北夷陵长虹机顶盒管理系统</title>
    <style>
        td{font-family:Verdana;font-size:10px;color:#000000}
        .cap{font-family:Arial;font-weight:bold;font-size:14px;padding-top:10px;}
        .title_bg{
            background-image: url("${pageContext.request.contextPath}/images/index_title.png");
            height: 30px;
            width: 458px;
            font-size:20px;
            font-weight: bold;
            padding-top:5px;
            padding-left:10px;
        }
        .content_bg{
            background-image: url("${pageContext.request.contextPath}/images/index_title_bg.png");
            height: 210px;
            padding-left: 15px;
        }
    </style>
</head>

<body topmargin="120px" leftmargin="0" bottommargin="0" rightmargin="0" bgcolor="#f0f8ff">
    <form id="reportForm" action="${pageContext.request.contextPath}/j_spring_security_check" method="post" name="form">
        <table cellpadding="0" cellspacing="0" border="0" align="center">
            <tr>
                <td>
                    <div class="title_bg">
                    湖北夷陵长虹机顶盒管理系统
                    </div>
                </td>
            </tr>
            <tr>
                <td class="content_bg" valign="top">
                    <div class="cap" style="height: 50px; float: left; padding-top: 25px" >
                        <img src="${pageContext.request.contextPath}/images/index_icon.png">
                    </div>
                    <div class="cap" style="height: 50px; float: left; padding-top: 40px; padding-left: 10px" >
                        用户名:
                        <input name="j_username" id="user_name" type="text" style="width: 200px">
                        <br/>
                        <br/>
                        <br/>
                        密 &nbsp;&nbsp;&nbsp;码:
                        <input name="j_password" id="user_password" type="password" style="width: 200px">
                        <br/>
                        <br/>
                        <br/>
                        <button type="submit" class="positive" name="Submit">
                            <img src="${pageContext.request.contextPath}/images/key.png" alt="Announcement">
                            登&nbsp;&nbsp;录
                        </button>
                        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                            <br/>
                            <div class="error">
                                 <span style="color:red;font-size:12px;" class="error">
                                    对不起, 用户名或者密码不正确!
                                 </span>
                            </div>
                        </c:if>
                    </div>
                </td>
		    </tr>
        </table>
    </form>

</body>
</html>
