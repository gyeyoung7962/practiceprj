<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<h3>회원정보 수정</h3>
<form action="/member/modify" method="post">
    <input type="hidden" name="id" value="${member.id}">
    이메일:
    <input type="email" name="email" value="${member.email}" readonly>
    <br/>
    비밀번호:
    <input type="password" name="password" value="${member.password}">
    <br/>
    닉네임:
    <input type="text" name="nickName" value="${member.nickName}">
    <br/>
    등록일:${member.regDate}
    <br/>
    <button>수정</button>
    <button>취소</button>
</form>
</body>
</html>
