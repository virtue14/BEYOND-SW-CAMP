<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
</head>

<!--
    서블릿을 배울 때 요청은 크게 GET과 POST로 나눠서 진행한다.

    1. GET
     : GET 요청은 조회를 하게 될 때 요청하는 형식이고 URL 경로에 노출되는 방식으로 서버에 값을 넘기며,
       조회하게 된다.(쿼리스트링, PathVariable)

    2. POST
     : POST 요청은 조회를 제외한 나머지(DML)를 진행할 때 주로 사용하며, 경우에따라 조회 시
       URL 경로에 노출되지 않고 서버에 값을 넘기거나 조회를 위해 서버로 넘기는 값의 크기가 클 때(255byte 초과)
       POST 요청을 진행하게 된다.

    Rest API 방식으로 요청 시에는 더 세분화 된 Http Method들(7가지)을 사용하게 되겠지만 현재는
    이 두가지 방식의 요청에만 집중하자.

-->

<body>
    <h1 align="center">Service Method</h1>
    <h3>GET 방식의 요청</h3>
    <h4>a태그의 href 속성값 변경</h4>
    <a href="request-service">서비스 메소드 요청하기</a>

    <h3>Post 방식의 요청</h3>
    <h4>form 태그의 method 속성을 post로 설정</h4>
    <form action="request-service" method="post">
        <input type="submit" value="POST 방식 요청 전송">
    </form>
</body>
</html>