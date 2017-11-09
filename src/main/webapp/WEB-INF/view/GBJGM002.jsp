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
    		<p>
    現場ID：<form:input path="genba_id" />
    		</p>
    		<p>
	現場名：<form:input path ="genba_na"  />
    		</p>
    		住所：<form:textarea path ="address"  cols="20" rows="3" />
    		<p>
  最寄り駅：<form:input path ="moyori_1_station" type="text" name="駅名"/>
    		<form:input path ="Moyori_2_station" />
			<form:input path ="Moyori_3_station" />
			</p>
    		<p>
  作業内容：<form:input path ="work" />
    		</p>
    		<p>
  フェーズ：<form:select path="optionValues" multiple="false">
 				<form:option value="-" label="--Please Select"/>
 				<form:options items="${form.phase}" />
			</form:select><br>
			</p>
    		<p>
    		<input style="position: absolute; right: 31.5%; bottom: 0px" class="btn btn-default" value="新規作成" name="entryGbjGm002" formaction="${actionUrl}"/>
    		<input style="position: absolute; right: 26.5%; bottom: 0px" class="btn btn-success" value="更新" name="updateGbjGm002" formaction="${actionUrl}"/>
    		<input style="position: absolute; right: 21.5%; bottom: 0px" class="btn btn-success" value="削除" name="deleteGbjGm002" formaction="${actionUrl}"/>
    		<input style="position: absolute;right: 0px; top: 0px" class="btn btn-info" value="戻る" name="backComGm002" formaction="${actionUrl}"/>
    		<input style="position: absolute;right: 0px; bottom: 0px" class="btn btn-warning" value="戻る" name="backGbjGm001" formaction="${actionUrl}"/>
			</p>

    	</form:form>
	</body>
</html>
