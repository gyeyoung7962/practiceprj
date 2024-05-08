<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/css/bootstrap.min.css"
          integrity="sha512-jnSuA4Ss2PkkikSOLtYs8BlYIeeIK1h99ty4YfvRPAlzr377vr3CXDb7sb7eEEBYjDtcYj+AjBH3FLv5uSJuXg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<style>
    li {
        margin: 20px;
        padding: 10px;
        list-style: none;
        text-decoration: none;
    }
</style>
<body>
<div>
    <ul style="display: flex; justify-content: center">
        <sec:authorize access="isAnonymous()">
            <li>
                <a href="/member/join">회원가입</a>
            </li>
            <li>
                <a href="/member/login">로그인</a>
            </li>
        </sec:authorize>
        <li>
            <a href="/board/write">글쓰기</a>
        </li>
        <li>
            <a href="/member/list">회원목록</a>
        </li>
        <li>
            <a href="/board/list">글목록</a>
        </li>


        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal.member" var="member"/>
            <li>${member.nickName}</li>
            <li>
                <a href="/logout">로그아웃</a>
            </li>


        </sec:authorize>
    </ul>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
