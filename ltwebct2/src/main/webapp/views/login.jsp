<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<style type="text/css">
/* Bordered form */
form {
	border: 3px solid #f1f1f1;
}

/* Full-width inputs */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
	opacity: 0.8;
}

/* Extra style for the cancel button (red) */
.registerbtn {
	width: auto;
	padding: 10px 18px;
}

/* Center the avatar image inside this container */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

/* Avatar image */
img.avatar {
	width: 40%;
	border-radius: 50%;
}

/* Add padding to containers */
.container {
	padding: 16px;
}

/* The "Forgot password" text */
span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>
	<form action="/ltwebct2/login" method="post">
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
		<div class="container">
			<h1>Login</h1>
			<hr>
			<label for="uname"><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="username" required> 
			<label for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="password" required>

			<button type="submit">Login</button>
			<label> <input type="checkbox" name="remember">
				Remember me
			</label>
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<span class="registerbtn">Don't have an account? <a href="/ltwebct2/register">Register</a></span>
			<span class="psw"><a href="/ltwebct2/forgotpasswrd">Forgot password?</a></span>
		</div>
	</form>

</body>
</html>