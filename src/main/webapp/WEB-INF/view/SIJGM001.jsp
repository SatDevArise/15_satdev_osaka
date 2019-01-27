<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<meta charset="utf-8">
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/SIJGM001.js" />"></script>

<title>SIJGM001 社員情報一覧表示画面</title>
</head>
<body>
	<!-- タイトル -->
	<div align="center">
		<h1>社員情報一覧表示画面</h1>

		<spring:url value="/initSijGm001" var="actionUrl" />

		<form:form modelAttribute="SIJGM001Form" class="text-center"
			style="margin-top: 30px;">
			<input type="button" class="btn btn-default" value="検索"
				onclick="openCOMGM003();" style="margin-left: 10px;">
			<input type="submit" class="btn btn-warning" value="戻る"
				name="backComGm002" formaction="${actionUrl}"
				style="margin-left: 10px;">
			<br>

			<!-- 社員情報一覧表示 -->
			<div align="center">
				<table class="table-bordered" style="margin-top: 30px;">

					<!-- ヘッダ -->
					<thead style="color: #FFFFFF; background-color: #191970;">
						<tr>
							<th>社員ID</th>
							<th>氏名</th>
							<th>役職</th>
							<th>生年月日</th>
							<th>チーム</th>
							<th>現場名</th>
							<th>経過年数</th>
							<th>フェーズ</th>
							<th>使用路線</th>
							<th>単価</th>
						</tr>
					</thead>

					<!-- 明細 -->


					<c:forEach var="syainInfoList" items="${SIJGM001Form}">
						<tr>
							<th><a href="./SIJGM002?syainId=${syainInfoList.syainId}"><c:out value="${syainInfoList.syainId}"/></a></th>
							<th><c:out value="${syainInfoList.syainNa}" /></th>
							<th><c:out value="${syainInfoList.yakusyokuNa}" /></th>
							<th><c:out value="${syainInfoList.birthDt}" /></th>
							<th><c:out value="${syainInfoList.syozokuTeam}" /></th>
							<th><c:out value="${syainInfoList.genbaNa}" /></th>
							<th><c:out value="${syainInfoList.keikaYm}" /></th>
							<th><c:out value="${syainInfoList.phaseCd}" /></th>
							<th><c:out value="${syainInfoList.siyoRosenNa}" /></th>
							<th><c:out value="${syainInfoList.tankaVal}" /></th>
						</tr>
					</c:forEach>


				</table>
			</div>
		</form:form>

	</div>
</body>
</html>
