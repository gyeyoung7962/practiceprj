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
<style>
    .active {
        background-color: forestgreen;
    }
</style>
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<table class="table">
    <thead>
    <th>번호</th>
    <th>글제목</th>
    <th>작성자</th>
    <th>작성일</th>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>
                <a href="/board/read?id=${list.id}">${list.title}</a>
            </td>
            <td>${list.writer}</td>
            <td>${list.regDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${pageInfo.prevPage}">
    <c:url var="link" value="/board/list">
        <c:param name="page" value="${pageInfo.prevPageNumber}"/>
    </c:url>
    <a href="${link}">이전</a>
</c:if>

<ul>
    <c:forEach begin="${pageInfo.currentStartPage}" end="${pageInfo.currentEndPage}" var="page">
        <c:url var="link" value="/board/list">
            <c:param name="page" value="${page}"/>
        </c:url>
        <a href="${link}" class="${pageInfo.currentPage eq page ? 'active': ''}">${page}</a>
    </c:forEach>
</ul>

<c:if test="${pageInfo.nextPage}">
    <c:url var="link" value="/board/list">
        <c:param name="page" value="${pageInfo.nextPageNumber}"/>
    </c:url>
    <a href="${link}">다음</a>
</c:if>

</body>
</html>
