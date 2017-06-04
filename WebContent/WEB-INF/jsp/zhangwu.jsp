<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<%@page import="cn.domain.zhangWu"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
      		margin-left: 10%;
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
<div class="mui-bar-nav">财务流水</div>

	<c:choose>
	<c:when test="${empty zhangwuList}">
			<p>帐务流水为空</p>
		</c:when>
		<c:otherwise>
		<c:forEach var="zhangWu" items="${zhangwuList}"> 
		
	<div class="mui-content b">
		<div class="mui-card">
			<ul class="mui-table-view">
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate"> 用  户  名 ：</div>
					<div class="a">${zhangWu.username}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">计  费  来  源 ：</div>
					<div class="a">${zhangWu.billsource}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">费  用 （元）：</div>
					<div class="a">${zhangWu.fee}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">当前余额(元) ：</div>
					<div class="a">${zhangWu.nowbalance}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">待扣款 (元)：</div>
					<div class="a">${zhangWu.nowwithhold}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">生 成 时 间：</div>
					<div class="a">${zhangWu.generatedtime}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<div class="mui-navigate">业务量(MB):</div>
					<div class="a">${zhangWu.businessvolume}</div>
				</li>
				<li class="mui-table-view-cell mui-collapse">
					<a class="mui-navigate-right" href="#">扣费规则：</a>
					<div class="mui-collapse-content">
						<p>${zhangWu.withholdrole}</p>
					</div>
				</li>
			</ul>
		</div>
	</div>
		
	
	</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>


