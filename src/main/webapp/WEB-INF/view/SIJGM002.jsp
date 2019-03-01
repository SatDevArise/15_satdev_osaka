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
		<script src="<c:url value="/resources/js/SIJGM002.js" />"></script>
		<title>SIJGM002 社員情報新規登録・編集画面</title>
	</head>
	<header>
		<!-- タイトル  -->
		<div align="center">
		<h1>社員情報新規登録・編集画面</h1>
		</div>
	</header>
	<body>
	    <spring:url value="/initSijGm002" var="actionUrl"/>
	<form:form modelAttribute="SIJGM002Form" id=" register" name = "SIJGM002">
		<form:input type="hidden" path="user" />
		<p class ="right">
		<div id="error_hyoji"></div>

    		<p>

    		</p>
    		<p>社員ID:<form:input path="syain_id" type = "text" name="社員ID" maxlength="4" readonly="readonly" onFocus="this.blur()"/>
    		   現場ID：<form:input path="genba_id" type="hidden"/></p>
			<p>氏名：<form:input path="syain_na" type = "text" name = "氏名" maxlength="20" style="ime-mode:active"/>
			   生年月日：<form:input path="birth_dt" type ="text" name = "生年月日" maxlength="8" style="ime-mode:disabled"/></p>
			<p>住所：<form:input path ="syain_address" type = "text" name = "住所" maxlength="100" style="ime-mode:active"/></p>
    		<p>最寄り駅：<form:input path="moyori_eki_1" type = "text" name = "最寄り駅" maxlength="10" style="ime-mode:active"/>
    					 <form:input path="moyori_eki_2" type = "text" name = "最寄り駅2" maxlength="10" style="ime-mode:active"/>
    					 <form:input path="moyori_eki_3" type = "text" name = "最寄り駅3" maxlength="10" style="ime-mode:active"/></p>
    		<p>連絡先：<form:input path="syain_renrakusaki" type = "text" name = "連絡先" maxlength="11" style = "ime-mode:disabled"/></p>
    		<p>前職：<form:input path="zensyoku_na" type = "text" name = "前職" maxlength="20" style = "ime-mode:active"/>
    		   出身地：<form:input path="syussin_na" type = "text" name = "出身地" maxlength="20" style = "ime-mode:active"/></p>
    		<p>役職：<form:select path="yakusyoku_cd" type = "text" name ="役職" maxlength="2">
    				<option value=""></option>
    				<option value="01">01：メンバー</option>
    				<option value="02">02：サブリーダー</option>
    				<option value="03">03：リーダー</option>
    				<option value="04">04：マネージャー</option>
    				<option value="05">05：部長</option>
    				</form:select>
    		   入社日：<form:input path="nyusya_dt" type = "text" name = "入社日" maxlength="8" style = "ime-mode:disabled"/>
    		<p>チーム：<form:select path="syozoku_team" type = "text" name = "チーム" maxlength="30">
    				<option value=""></option>
    				<option value="Hチーム">Hチーム</option>
    				<option value="Kチーム">Kチーム</option>
    				<option value="Wチーム">Wチーム</option>
    				</form:select>
    		</p>
    		<p>フェーズ：<form:select path="phase_cd" type = "text" name = "フェーズ" maxlength="8" style = "ime-mode:disabled">
    				<option value=""></option>
    				<option value="評価">評価</option>
					<option value="開発">開発</option>
					<option value="設計">設計</option>
					<option value="運用">運用</option>
					<option value="構築">構築</option>
					</form:select>
    		   単価：<form:input path="tanka_vl" type = "text" name = "単価" maxlength="5" style = "ime-mode:disabled"/></p>
    		<p>現場名：<form:select path="genba_na" type = "text" name = "現場名" maxlength="30">
    					<option value =""></option>
    					<option value = "テスト"></option>
						</form:select>
			</p>
    		<p>参画日：<form:input path="genba_sankaku_dt" type = "text" name = "参画日" maxlength="8" style = "ime-mode:disabled"/></p>
    		<p>

    		</p>
    		<div align="right">
    		<%session.setAttribute("param","COMGM002");%>
    		<input type="submit" class="btn btn-default" value="新規登録" name="entrySijGm002" formaction="${actionUrl}">
    		<input type="submit" class="btn btn-success" value="更新" onclick="confirmUpload();" name="updateSijGm002" formaction="${actionUrl}" disabled>
    		<input type="submit" class="btn btn-success" value="削除" onclick="confirmDelete();" name="deleteSijGm002" formaction="${actionUrl}" disabled>
    		<input type="submit" class="btn btn-info" value="戻る" name="backComGm002" formaction="${actionUrl}">
    		<input type="submit" class="btn btn-warning" value="戻る" name="backSijGm001" formaction="${actionUrl}">
    		</div>
			<p class="red">
				<c:forEach var="error_hyoji" items="${SIJGM002Form.error_hyoji}">
					・<c:out value="${error_hyoji}" />
					<br>
				</c:forEach>
			</p>

	</form:form>
</body>
</html>
