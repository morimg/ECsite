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

	<title>ItemDeleteConfirm画面</title>

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
			<p>ItemDelete</p>
		</div>
		<div>
			<h3>商品ID[<s:property value="session.ItemId"/>]の商品を削除します。よろしいですか？</h3>
				<s:form>
						<td>
							<input type="button" value="ＯＫ" onclick="submitAction('ItemDeleteCompleteAction')"/>
						</td>
						<td>
							<input type="button" value="キャンセル" onclick="submitAction('ItemListAction')"/>
						</td>
				</s:form>
		</div>
	</div>
	<div id="footer">
		<div id ="pr">
		</div>
	</div>
</body>
</html>