<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
	<head>
		<meta charset="utf-8">
		<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
		<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
		<script src="<c:url value="/resources/js/GBJGM002.js" />"></script>
		<title>GBJGM002 現場情報新規登録・編集画面</title>
	</head>
	<body>
		<font size="2"style="position: absolute; right: 32.5%; top: 0px" color="blue">現場情報新規登録・編集画面</font><br>
	    <spring:url value="/initGbjGm002" var="actionUrl"/>
    	<form:form modelAttribute="GBJGM002Form">
    		<form:input path="user" />
    		<p>現場ID：<input type="text" name="ID"></p>
    		<p>現場名：<input type="text" name="現場名"></p>
    		<p>住所：<TEXTAREA cols="20" rows="2"></TEXTAREA></p>
    		最寄り駅：<input type="text" name="駅名">
    		<input type="text" name="駅名">
			<input type="text" name="駅名">
    		<p>作業内容：<input type="text" name="作業内容"></p>
    		<p>フェーズ：<select name="example2">
    		<option value="サンプル1">選択肢のサンプル1</option>
    		<option value="サンプル2">選択肢のサンプル2</option>
    		<option value="サンプル3" selected>選択肢のサンプル3</option>
    		<option value="サンプル4">選択肢のサンプル4</option>
    		<option value="サンプル5">選択肢のサンプル5</option>
    		</select>
			</p>
    		<p><input type="submit"style="position:  fixed; right: 32%; bottom: 0px" class="btn btn-default" value="新規作成" name="entryGbjGm002" formaction="${actionUrl}">
    		<input type="submit"style="position: absolute; right: 26.5%; bottom: 0px" class="btn btn-success" value="更新" name="updateGbjGm002" formaction="${actionUrl}">
    		<input type="submit"style="position: absolute; right: 21.5%; bottom: 0px" class="btn btn-success" value="削除" name="deleteGbjGm002" formaction="${actionUrl}">
    		<input type="submit"style="position: absolute;right: 0px; top: 0px" class="btn btn-info" value="戻る" name="backComGm002" formaction="${actionUrl}">
    		<input type="submit"style="position: absolute;right: 0px; bottom: 0px" class="btn btn-warning" value="戻る" name="backGbjGm001" formaction="${actionUrl}">
			</p>

    	</form:form>
	</body>
</html>
