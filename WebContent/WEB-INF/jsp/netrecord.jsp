<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="cn.domain.netRecord"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title></title>
<script src="js/mui.min.js"></script>
<link href="css/mui.min.css" rel="stylesheet" />
<script type="text/javascript" charset="utf-8">
	mui.init();
</script>
<style>
.mui-bar-nav {
	font-family: "微软雅黑";
	font-size: 20px;
	height: 40px;
	line-height: 40px;
	text-align: center;
}

.a, .mui-navigate {
	float: left;
	font-size: 14px;
}

.a {
	margin-left: 10%;
}

.mui-navigate-right {
	font-size: 14px;
}

.mui-collapse-content {
	color: #000;
}

.b {
	margin: auto;
	margin-top: -40px;
}

.c {
	margin-top: -30px;
}
</style>
</head>

<body>
	<div class="mui-bar-nav">上网记录</div>

	<c:choose>
		<c:when test="${empty netrecordList}">
			<p>上网记录为空</p>
		</c:when>
		<c:otherwise>
			<c:forEach var="netRecord" items="${netrecordList}">
				<div class="mui-content c">
					<div class="mui-card">
						<ul class="mui-table-view">
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">上线时间 ：</div>
								<div class="a">${netRecord.ontime}</div>
							</li>
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">下线时间 ：</div>
								<div class="a">${netRecord.offtime}</div>
							</li>
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">用户IPv4 ：</div>
								<div class="a">${netRecord.userIPv4}</div>
							</li>
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">服 务 ：</div>
								<div class="a">${netRecord.service}</div>
							</li>
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">上网费用(元)</div>
								<div class="a">${netRecord.oncost}</div>
							</li>
							<li class="mui-table-view-cell mui-collapse"><a
								class="mui-navigate-right" href="#">下线原因 ：</a>
								<div class="mui-collapse-content">
									<p>${netRecord.offreason}</p>
								</div></li>
						</ul>
					</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>

</body>
</html>

