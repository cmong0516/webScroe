<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, com.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
input {
	font-size: x-large;
}
</style>
</head>
<body>
	<%-- <% Score my_score = (Score) request.getAttribute("find"); %> --%>
	<%-- <c:set var="my_score" value="${requestScope.find}"/> --%>
	<form action="ScoreUpdate">
		<table border=1 width="70%"
			style="height: 400px; border-style: solid; font-size: x-large;">
			<tr>
				<th>�̸�</th>
				<td>${find.name}<input type="hidden" name="name"
					value="${find.name}" /></td>
				<%--
					<td>${my_score.getName()} 
				 <input type="hidden" name="name" value="${my_score.getName()}" /></td> --%>
			</tr>
			<tr>
				<th>����</th>
				<td><input type="text" name="kor" value="${find.kor}"></td>
				<%-- 				<td><input type="text" name="kor"
					value="${my_score.getKor()}"></td> --%>
			</tr>
			<tr>
				<th>����</th>
				<td><input type="text" name="eng" value="${find.eng}"></td>
				<%-- 					<td><input type="text" name="eng"
					value="${my_score.getEng()}"></td> --%>
			</tr>
			<tr>
				<th>����</th>
				<td><input type="text" name="mat" value="${find.mat}"></td>
				<%-- 					<td><input type="text" name="mat"
					value="${my_score.getMat()}"></td> --%>
			</tr>
			<tr>
				<th>�� ��</th>
				<td>${find.tot}</td>
				<%-- <td>${my_score.getTot()}</td> --%>
			</tr>
			<tr>
				<th>���</th>
				<td>${find.avg}</td>
				<%-- <td>${my_score.getAvg()}</td> --%>
			</tr>
			<tr>
				<th>����</th>
				<td>${find.grade}</td>
				<%-- <td>${my_score.getGrade()}</td> --%>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="����" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>



