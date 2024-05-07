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

<h3>회원목록</h3>
<hr/>
<table class="table">
    <thead>
    <th>아이디</th>
    <th>이메일</th>
    <th>비밀번호</th>
    <th>닉네임</th>
    <th>등록일</th>
    <th>설정</th>
    </thead>

    <tbody>
    <c:forEach items="${list}" var="list">
    <tr>
        <td>${list.id}</td>
        <td><a href="/member/select?id=${list.id}">${list.email}</a></td>
        <td>${list.password}</td>
        <td>${list.nickName}</td>
        <td>${list.regDate}</td>
        <td>
            <button>수정</button>
            <button>삭제</button>
        </td>
    </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
