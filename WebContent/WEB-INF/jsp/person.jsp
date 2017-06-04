<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@page import="cn.domain.userInfo"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <script type="text/javascript" charset="utf-8">
      	mui.init();
    </script>
            <style>
        .mui-bar-nav{
      	font-family: "微软雅黑";
      	font-size: 20px;
      	height: 40px;
      	line-height: 40px;
      	text-align: center;
      	}
      	.a,.mui-navigate{
      		float:left;
      		font-size: 14px;
      	}
      	.a{
      		margin-left: 5%;
      	}
      	.mui-navigate-right{
      		font-size: 14px;
      	}
      	.mui-collapse-content{
      		color: #000;
      	}
      	.b{
          	margin: auto;
      	    margin-top: -40px;
      	}
      	.c{
      		margin-top: -30px;
      	}
    </style>
</head>
<body>
<div class="mui-bar-nav">个人信息</div>

 <c:choose>
		<c:when test="${empty usersList}">
			<p>个人信息为空</p>
		</c:when>
   <c:otherwise>
    <c:forEach var="userInfo" items="${usersList}"> 
    
    <div class="mui-content c">
		<div class="mui-card">
			<ul class="mui-table-view">
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">用户名  ：</div>
					<div class="a">${userInfo.account}</div>
				</li><li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">姓   名 ：</div>
					<div class="a">${userInfo.username}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">性　别  ：</div>
					<div class="a">${userInfo.sex}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">证 件 号：</div>
					<div class="a">${userInfo.zjh}</div>
				</li>
			</ul>
		</div>
	</div>
	<div class="mui-content b">
		<div class="mui-card">
			<ul class="mui-table-view">
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">用户IPv4 ：</div>
					<div class="a">${userInfo.userIPv4}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">接入方式 ：</div>
					<div class="a">${userInfo.connway}</div>
				</li>
			</ul>
		</div>
	</div>
		<div class="mui-content b">
		<div class="mui-card">
			<ul class="mui-table-view">
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">余  额  (元)：</div>
					<div class="a">${userInfo.balance}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">待扣款(元)：</div>
					<div class="a">${userInfo.withholding}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">状　  态   ：</div>
					<div class="a">${userInfo.status}</div>
				</li>
				
			</ul>
		</div>
	</div>
    
    
    
    
    
	    </c:forEach>
		</c:otherwise>
	</c:choose>
	
</body>
</html>

