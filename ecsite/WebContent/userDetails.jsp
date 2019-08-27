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

	<title>UserDetails画面</title>

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

		#footer{
			width:100%;
			height: 80px;
			background-color: black;
			clear:both;
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
			<p>UserDetails</p>
		</div>
		<div>
				<h3>ユーザーの詳細情報は以下になります。</h3>
				<table>
					<tr>
						<td>
							ＩＤ
						</td>
						<td>
							<s:property value="session.Id"/>
						</td>
					</tr>
					<tr>
						<td>
							管理者フラグ
						</td>
						<td>
							<s:property value="session.AdminFlg"/>
						</td>
					</tr>
					<tr>
						<td>
							ログインＩＤ
						</td>
						<td>
							<s:property value="session.LoginId"/>
						</td>
					</tr>
					<tr>
						<td>
							パスワード
						</td>
						<td>
							<s:property value="session.LoginPass"/>
						</td>
					</tr>
					<tr>
						<td>
							氏名
						</td>
						<td>
							<s:property value="session.UserName"/>
						</td>
					</tr>
					<tr>
						<td>
							登録日時
						</td>
						<td>
							<s:property value="session.InsertDate"/>
						</td>
					</tr>
					<tr>
						<td>
							更新日時
						</td>
						<td>
							<s:property value="session.UpdateDate"/>
						</td>
					</tr>
				</table>
			<s:form action="UserDeleteConfirmAction">
			<s:submit value="削除"/>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id ="pr">
		</div>
	</div>
</body>
</html>