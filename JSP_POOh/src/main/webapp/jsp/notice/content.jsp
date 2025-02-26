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
							�ۼ���¥ : ${n.date}
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
								<input name="title" maxlength="40" placeholder="����" 
									value="${n.title}" autofocus="autofocus" autocomplete="off">
							</td>
						</tr>
						<tr>
							<td>&nbsp;&nbsp;�ۼ���  &nbsp;&nbsp;|&nbsp;&nbsp;  ${n.writer}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr><td class="space"></td></tr>
			<tr>
				<td align="center">
					<textarea id="contentTxt" name="txt" placeholder="����" 
							autocomplete="off" maxlength="450">${n.txt }</textarea>
				</td>
			</tr>
			<tr><td class="space" ></td></tr>
			<tr><td class="space"></td></tr>
			<!-- �ڱ� �۸� ���� or ���� -->
			<c:choose>
				<c:when test="${n.writer == sessionScope.loginMember.id }">
					<tr>
						<td align="center">
							<button class="bntbtn">����</button>
	</form>
							<button class="bntbtn" onclick="goNoticeDelete(${n.no});">�� ����</button>
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
								���
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
									<input name="comment" id="commentInput" placeholder="����� �Է��ϼ���" autocomplete="off" maxlength="100"> 
									<button id="commentBnt" >���</button>
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