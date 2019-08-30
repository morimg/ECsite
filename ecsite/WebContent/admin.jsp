<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolber" content="no"/>
	<meta name="description" content=""/>
	<meta name="Keywords" content=""/>

	<title>管理者画面</title>

	<style type="text/css">
	/*======TAG LAYOUT======*/
		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdane,Helvetica,sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		}

		table{
			text-align:center;
			margin:0 auto;
		}

	/*======ID LAYOUT======*/
		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}

		#header{
			width:100%;
			height: 80px;
			background-color: black;
		}

		#main{
			width:100%;
			height:500px;
			text-align:center;
		}

		#contents{
			margin:0 auto;
			width:90%;
			height:300px;
			text-align:center;
		}

		#itemside{
			float:left;
			width:40%;
			padding-bottom:40px;
			border:1px solid #333;
		}

		#userside{
			float:right;
			width:40%;
			padding-bottom:40px;
			border:1px solid #333;
		}

		#footer{
			clear:both;
			width:100%;
			height: 80px;
			background-color: black;
		}

		#text-center{
			display:inline-block;
			text-align: center;
		}

	</style>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>管理者TOP</p>
		</div>
		<div id="contents">
			<div id="itemside">
				<h3>商品</h3>
				<s:form action="ItemCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<br>
				<s:form action="ItemListAction">
					<s:submit value="一覧"/>
				</s:form>
			</div>
			<div id="userside">
				<h3>ユーザー</h3>
				<s:form action="UserCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<br>
				<s:form action="UserListAction">
					<s:submit value="一覧"/>
				</s:form>
			</div>
		</div>
		<div>
			<p>Homeへ戻る場合は
				<a href='<s:url action="GoHomeAction"/>'>こちら</a>
			</p>
		</div>
	</div>
	<div id="footer">
		<div id ="pr">
		</div>
	</div>
</body>
</html>