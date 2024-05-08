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
<body>
<c:import url="../layout/navbar.jsp"></c:import>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"
        integrity="sha512-ykZ1QQr0Jy/4ZkvKuqWn4iF3lqPZyij9iRv6sGqLRdTPkY69YX6+7wvVGmsdBbiIfN/8OdsI7HABjvEok6ZopQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<h3>${board.id}번 글</h3>
<hr/>
글제목:${board.title}
<br/>
글내용
<br/>
<textarea cols="30" rows="10" readonly>${board.content}</textarea>
<br/>
글작성자:${board.writer}
<br/>
글작성일:${board.regDate}
<br/>


<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.member" var="member"/>
    <c:if test="${member.id eq board.memberId}">
        <button>
            <a href="/board/modify?id=${board.id}">수정</a>
        </button>

        <form action="/board/delete" method="post">
            <input type="hidden" name="id" value="${board.id}">
            <button>삭제</button>
        </form>
    </c:if>
</sec:authorize>

</body>
</html>
