<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
    li {
        margin: 20px;
        padding: 10px;
        list-style: none;
        text-decoration: none;
    }
</style>
<div>
    <sec:authentication property="principal"/>
</div>
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


