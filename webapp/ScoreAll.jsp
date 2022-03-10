<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, com.entity.*"%>
<!-- Jstl������ �̰� �ʿ��� -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%-- <%ArrayList<Score> sm = (ArrayList<Score>) request.getAttribute("all");%> --%>
	<!-- 
		c:set sm�̶�� �̸����� requestAttribute�� "all"�� �����ϰڴ�.
		<c:set var="sm" value="${requestScope.all}" />
	 -->
	
	<table border=1 width="90%">
		<tr>
			<th>�̸�</th>
			<th>����</th>
			<th>����</th>
			<th>����</th>
			<th>�� ��</th>
			<th>���</th>
			<th>����</th>
			<th>����</th>
			<th>����</th>
		</tr>
		<c:forEach var="score" items="${all}">
	${score.name}
		<tr>
				<td>${score.name }</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.mat }</td>
				<td>${score.tot }</td>
				<td>${score.avg }</td>
				<td>${score.grade }</td>
				<td><a href="ScoreFind?name=${score.name }"> ���� </a></td>
				<td><a href="ScoreDelete?name=${score.name }"> ���� </a></td>
			</tr>
		</c:forEach>
		<tr>
			<td align="center" colspan="9"><a href="ScoreInsert.html">�Է�
			</a></td>
		</tr>
	</table>
</body>
</html>













