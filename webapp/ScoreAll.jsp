<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, com.entity.*"%>
<!-- Jstl쓰려면 이거 필요함 -->
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
		c:set sm이라는 이름으로 requestAttribute의 "all"을 저장하겠다.
		<c:set var="sm" value="${requestScope.all}" />
	 -->

	<table border=1 width="90%">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총 점</th>
			<th>평균</th>
			<th>학점</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		
		<%-- 
			JSTL forEach : JSTL for loop (반복문)
			items : 대상 배열 또는 컬렉션
			var : 요소를 저장할 변수
			varStatus : 상태용 변수 index(0부터) or count(1부터)
			<c:forEach var="res" items="${sm}" varStatus="status">
 		--%>
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
				<td><a href="ScoreFind?name=${score.name }"> 수정 </a></td>
				<td><a href="ScoreDelete?name=${score.name }"> 삭제 </a></td>
			</tr>
		</c:forEach>
		
<%-- 		<!-- <c:forEach var="res" items="${sm}" varStatus="status">
			<tr>
				<!--  ${res.name}와 동일-->
				<td>${res.getName()}</td>
				<td>${res.getKor()}</td>
				<td>${res.getEng()}</td>
				<td>${res.getMat()}</td>
				<td>${res.getTot()}</td>
				<td>${res.getAvg()}</td>
				<td>${res.getGrade()}</td>
				<td><a href="ScoreFind?name=${res.getName()}"> 수정 </a></td>
				<td><a href="ScoreDelete?name=${res.getName()}"> 삭제 </a></td>
			</tr>
		</c:forEach> --> --%>


		<tr>
			<td align="center" colspan="9"><a href="ScoreInsert.html">입력
			</a></td>
		</tr>
	</table>
</body>
</html>













