<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table id="noticeBBSArea">
		<tr>
			<th>게시판</th>
		</tr>
		<tr>
			<td align="right">
				<c:if test="${sessionScope.loginMember != null }">
					<a href="NoticeWriteController">글쓰기</a>
				</c:if>
			</td>
		</tr>
		<tr> 
			<td>
				<table id="contentTable">
					<tr class="contextMenu">
						<td align="center" class="no">번호</td>
						<td align="center">제목</td>
						<td align="center" class="date">날짜</td>
					</tr>
					<c:forEach var="n" items="${notices }">
						<tr class="dataTR" onclick="goNoticeGet(${n.no});">
							<td align="center" class="no">${n.no }</td>
							<td>&nbsp;&nbsp;&nbsp;${n.title }</td>
							<td align="center" class="date">
								<fmt:formatDate value="${n.date }" type="date" dateStyle="short"/>
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr><td class="space"></td></tr>
		<tr>
			<td align="center" id="page">
				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="NoticePageController?page=${p }">${p }</a>
				</c:forEach>
			</td>
		</tr>
		<tr><td class="space"></td></tr>
		<tr>
			<td align="right">
				<form action="NoticeController" method="post">
					<input id="noticeSearchInput" name="search" placeholder="&nbsp;검색어를 입력하세요">
					<button id="noticeSearchBtn" >검색</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>