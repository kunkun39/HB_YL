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

    function bannerAdvertisementDeleteConfirm(adId, current) {
      jQuery("#openadvertisement-dialog-confirm").dialog({
        resizable: false,
        height:140,
        modal: true,
        buttons: {
          "确  认": function() {
            jQuery(this).dialog("close");

            window.location.href = '${pageContext.request.contextPath}/backend/banneradvertisementdelete.html?bannerAdvertisementId=' + adId + '&current=' + current;
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
    <td valign="top">
      <div style="float: left; padding-right: 5px; padding-top: 5px; padding-left: 5px;">
        <a href="#" onclick="window.location.href='${pageContext.request.contextPath}/backend/banneradvertisementform.html'"><button class="thoughtbot_null">添加Banner广告</button></a>
      </div>


      <form action="${pageContext.request.contextPath}/backend/banneradvertisementoverview.html" class="search_form" method="POST">
        <div class="search" >
          &nbsp;&nbsp;<span><label>频道号：</label><input type="text" id="serviceId" name="serviceId" class="text" value="${serviceId}"/></span>&nbsp;&nbsp;
          <a href="#" onclick="this.form.submit()"><button class="thoughtbot">查询</button></a>
        </div>

      </form>

      <table width="100%" cellpadding="0" cellspacing="0" class="list">
        <thead>
        <td width="5%">&nbsp;&nbsp;编号</td>
        <td width="25%">描述</td>
        <td width="5%">频道号</td>
        <td width="40%">广告地址</td>
        <td width="15%">&nbsp;&nbsp;&nbsp;操作</td>
        </thead>
        <tbody>
        <c:set var="turns" value="true"/>
        <c:forEach items="${bas}" var="ad">
          <c:set var="color" value="${turns ? 'r1' :'r2'}"/>
          <tr class="${color}" onmouseover="this.className='over'" onmouseout="this.className='${color}'">
            <c:set var="turns" value="${!turns}"/>
            <td>&nbsp;&nbsp;${ad.sequence}</td>
            <td>${ad.advertisementTitle} </td>
            <td>&nbsp;&nbsp;${ad.serviceId}</td>
            <td><a href="${applicationWebAddress}${ad.advertisementActualFileName}" target="_blank">${applicationWebAddress}${ad.advertisementActualFileName}</a></td>
            <td>
              <a href="#" onclick="window.location.href='${pageContext.request.contextPath}/backend/banneradvertisementform.html?bannerAdvertisementId=${ad.id}&current=${current}'" ><button class="thoughtbot">编辑</button></a>
              <a href="#" onclick="return bannerAdvertisementDeleteConfirm('${ad.id}', '${current}');"><button class="thoughtbot">删除</button></a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

      <div class="paging">
        <ch:paging urlMapping="${pageContext.request.contextPath}/backend/banneradvertisementoverview.html" showGoTo="false" paging="${paging}"/>
      </div>
    </td>
  </tr>
</table>

<div id="openadvertisement-dialog-confirm" title="确认对话框?">
  <p>
    <span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
    请确认你是否要删除该Banner广告？
  </p>
</div>

</body>
</html>