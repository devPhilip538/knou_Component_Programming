<%@page contentType="text/html; charset=EUC-KR"%>
<%
	//����� �������а� 201784020043
	// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
	session.invalidate();
	// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
	response.sendRedirect("login.jsp");
%>