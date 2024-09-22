<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<style type="text/css">
/* Extra style for the cancel button (red) */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}
/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>
	<h1>Welcome Manager!</h1>
	<c:choose>
		<c:when test="${sessionScope.account == null}">
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li>
						<a href="${pageContext.request.contextPath }/login">Đăng nhập</a> | 
						<a href="${pageContext.request.contextPath }/register">Đăng	ký</a>
					</li>
					<li><i class="search fa fa-search search-button"></i></li>
				</ul>
			</div>
		</c:when>
		<c:otherwise>
			<div class="col-sm-6">
				<ul class="list-inline right-topbar pull-right">
					<li>
						<a href="${pageContext.request.contextPath}/member/myaccount">
						${sessionScope.account.fullname}
						</a>|
						<a href="${pageContext.request.contextPath }/logout">Đăng Xuất</a>
					</li>
					<li><i class="search fa fa-search search-button"></i></li>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>