<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="cn.domain.mainpage"%>

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

.mui-card {
	width: 90%;
}

.a, .mui-navigate {
	float: left;
	font-size: 14px;
}

.a {
	margin-left: 5%;
}

.mui-navigate-right {
	font-size: 14px;
}

.mui-collapse-content {
	color: #000;
}

.b {
	margin-top: -40px;
}

.c {
	margin-top: -30px;
}

.d {
	margin-left: 0%;
	font-size: 14px;
	color: #909090;
}
</style>
</head>
<body>
	<div class="mui-bar-nav">基本信息</div>


	<c:choose>
		<c:when test="${empty mainpageList}">
			<p>基本信息为空</p>
		</c:when>
		<c:otherwise>
			<c:forEach var="mainpage" items="${mainpageList}">
				<div class="mui-content c">
					<div class="mui-card">
						<ul class="mui-table-view">
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">用户状态：</div>
								<div class="a">${mainpage.status}</div>
							</li>
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">用户策略：</div>
								<div class="a">${mainpage.accountway}</div>
							</li>
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">周期时间范围</div>
							</li>
							<li class="mui-table-view-cell mui-collapse">
								<div class="d">${mainpage.cycleTime}</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="mui-content b">
					<div class="mui-card">
						<ul class="mui-table-view">
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">余 额：</div>
								<div class="a">${mainpage.balance}</div>
							</li>
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">套餐流量（已用量/总免费量）</div>
							</li>
							<li class="mui-table-view-cell mui-collapse">
								<div class="d">${mainpage.packageflow}</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="mui-content b">
					<div class="mui-card">
						<ul class="mui-table-view">
							<li class="mui-table-view-cell mui-collapse">
								<div class="mui-navigate">待扣款余额：</div>
								<div class="a">${mainpage.withhold}</div>
							</li>
						</ul>
					</div>
				</div>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>
