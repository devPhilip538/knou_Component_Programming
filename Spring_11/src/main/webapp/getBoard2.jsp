<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@page contentType="text/html; charset=EUC-KR"%>
<%
	/* 오승필/202184-010073 */
	// HttpSession board Get
	BoardVO board = (BoardVO) session.getAttribute("board");
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 상세</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
				<%
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
		%>
		<h2><%=formatter.format(date)%></h2>
		<h3>오승필/202184-010073</h3>
		<a href="/boardWeb/logout.do">Log-out</a>
		<hr>
		<form action="/boardWeb/updateBoard.do" method="post">
			<input name="seq" type="hidden" value="<%=board.getSeq()%>" />
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input name="title" type="text"
						value="<%=board.getTitle()%>" /></td>
				</tr>
				<tr>
					<td bgcolor="orange">작성자</td>
					<td align="left"><%=board.getWriter()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">내용</td>
					<td align="left"><textarea name="content" cols="40" rows="10">
						<%=board.getContent()%></textarea></td>
				</tr>
				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left"><%=board.getRegDate()%></td>
				</tr>
				<tr>
					<td bgcolor="orange">조회수</td>
					<td align="left"><%=board.getCnt()%></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="글 수정" /></td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard2.jsp">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="/boardWeb/deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList2.jsp">글목록</a>
	</center>
</body>
</html>
