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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

	<title>BuyItemComfirm画面</title>

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
	<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);
		$('form').submit();
	}
	</script>

</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItemConfirm</p>
		</div>
		<div>
			<s:form>
					<table border="1">
						<tr>
							<th>商品名</th>
							<th>値段</th>
							<th>購入個数</th>
							<th>支払い方法</th>
						</tr>
					<s:iterator value="buyItemConfirmList">
						<tr>
							<td><input type="hidden" name="buyItemId" value=<s:property value="buyItemId"/>><s:property value="buyItemName"/></td>
							<td><s:property value="buyItemPrice"/><input type="hidden" name="buyItemPrice" value=<s:property value="buyItemPrice"/>>円</td>
							<td><s:property value="buyItemCount"/><input type="hidden" name="buyItemCount" value=<s:property value="buyItemCount"/>>個</td>
							<td><s:property value="session.pay"/></td>
						</tr>
					</s:iterator>
					</table>
					<tr>
						<td>
							<input type="button" value="戻る" onclick="submitAction('HomeAction')"/>
						</td>
						<td>
							<input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/>
						</td>
					</tr>
			</s:form>
		</div>
		<div>
				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
		</div>
	</div>
	<div id="footer">
		<div id ="pr">
		</div>
	</div>
</body>
</html>