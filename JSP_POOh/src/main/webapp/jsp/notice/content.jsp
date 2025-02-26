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
		<table id="content2Table">
	<form action="NoticeContentController" method="post" name="noticeForm" onsubmit="return noticeUpdateCheck();">
			<input name="no" value="${n.no }" type="hidden">
			<tr>
				<td align="right">
							작성날짜 : ${n.date}
				</td>
			</tr>
			<tr><td class="space"></td></tr>
			<tr>
				<td colspan="2">
					<table id="writerTable">
						<tr>
							<td align="center" rowspan="2">
								<img id="contentimg" src="member_photo/${profile }">
							</td>
							<td align="center">
								<input name="title" maxlength="40" placeholder="제목" 
									value="${n.title}" autofocus="autofocus" autocomplete="off">
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;작성자  &nbsp;&nbsp;|&nbsp;&nbsp;  ${n.writer}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr><td class="space"></td></tr>
			<tr>
				<td align="center">
					<textarea id="contentTxt" name="txt" placeholder="내용" 
							autocomplete="off" maxlength="450">${n.txt }</textarea>
				</td>
			</tr>
			<tr><td class="space" ></td></tr>
			<tr><td class="space"></td></tr>
			<!-- 자기 글만 수정 or 삭제 -->
			<c:choose>
				<c:when test="${n.writer == sessionScope.loginMember.id }">
					<tr>
						<td align="center">
							<button class="bntbtn">수정</button>
	</form>
							<button class="bntbtn" onclick="goNoticeDelete(${n.no});">글 삭제</button>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
			</form>
				</c:otherwise>
			</c:choose>
			<tr><td class="space"></td></tr>
			<tr><td class="space"></td></tr>
			<c:if test="${sessionScope.loginMember != null }">
			<tr>
				<td align="left">
					<table id="commentTable">
						<tr>
							<td id="line" colspan="3">
								댓글
							</td>
						</tr>
						
						<c:forEach var="c" items="${c}">
							<tr class="comments">
								<td align="center" class="commentWriter">${c.writer } &nbsp;&nbsp; :</td>
								<td>${c.txt }</td>
								<td align="right" class="date" >
									<fmt:formatDate value="${c.date }" type="date" dateStyle="short"/>
								</td>
							</tr>
						</c:forEach>
						<tr><td class="space"></td></tr>
						<tr>
							<td colspan="3">
								<form action="NoticeCommentWriteController?" name="commentForm" onsubmit="return noticeCommentCheck();">
									<input name="nno" value="${n.no }" type="hidden">
									<input name="comment" id="commentInput" placeholder="댓글을 입력하세용" autocomplete="off" maxlength="100"> 
									<button id="commentBnt" >등록</button>
								</form>	
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</c:if>
		</table>
</body>
</html>