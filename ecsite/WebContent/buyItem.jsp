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

	<title>BuyItem画面</title>

	<style type="text/css">
	/*======TAG LAYOUT======*/
		body{
			margin:0 auto;
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
			<p>BuyItem</p>
		</div>
		<div>
		<s:if test="errorMessage != ''">
				<s:property value="errorMessage" escape="false"/>
		</s:if>
			<s:form action="BuyItemAction">
				<table border="1">
						<tr>
							<th>#</th>
							<th>商品名</th>
							<th>値段</th>
							<th>在庫数</th>
							<th>購入個数</th>
						</tr>
					<s:iterator value="buyItemList">
						<tr>
							<td>
								<input type="hidden" name="id" value=<s:property value="id"/>>
								<input type="checkbox" name="checkItem" value=<s:property value="id"/>>
							</td>
							<td><s:property value="itemName"/><input type="hidden" name="itemName" value=<s:property value="itemName"/>></td>
							<td><s:property value="itemPrice"/><input type="hidden" name="itemPrice" value=<s:property value="itemPrice"/>></td>
							<td><s:property value="itemStock"/><input type="hidden" name="itemStock" value=<s:property value="itemStock"/>></td>
							<td><select name="count">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</td>
						</tr>
					</s:iterator>
				</table>
				<tr>
					<td>
						<input type="radio" name="pay" value="1"checked="checked">現金払い
						<input type="radio" name="pay" value="2">クレジットカード
					</td>
				</tr>
				<table>
				<tr>
					<td>
						<s:submit value="購入"/>
					</td>
				</tr>
				</table>
			</s:form>
			<div>
				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id ="pr">
		</div>
	</div>
</body>
</html>