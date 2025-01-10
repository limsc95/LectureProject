<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value='/' var="root"/> <!-- 컨텍스트 루트를 생성해 root 라는 변수에 저장 -->

<head>
    <title>수강신청</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .form-box {
            width: 500px;
            height: 500px;
            outline: none;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            border: 1px solid grey;
        }
        .form-box .input-box {
            width: 300px;
            height: 30px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid grey;
            padding: 0 5px;
        }
        .form-box .btn-login {
            width: 60px;
            background-color: #fff;
            color: black;
        }
        .login_error {
            color: red;
        }
    </style>
</head>
<body>

    <div class="form-box">
        <h1>네이버 클라우드 수강신청</h1>
        <form:form action="${root}login" method="post" modelAttribute="loginBean">
            <div class="form-group">
                <form:label path="user_id">아이디</form:label> <br>
                <form:input type="text" path="user_id" class="form-control input-box" placeholder="아이디"/> <br>
                <form:errors path="user_id" style='color:red' />
            </div>
            <div class="form-group">
                <form:label path="user_pw">비밀번호</form:label> <br>
                <form:password path="user_pw" class="form-control input-box" placeholder="비밀번호" /> <br>
                <form:errors path="user_pw" style='color:red' />
            </div>

            <div>
                <c:if test="${fail == true}">
                    <span class="login_error">로그인에 실패하였습니다!</span>
                </c:if>
            </div>

            <div class="form-group">
                <div class="text-right">
                    <form:button class="btn btn primary input-box btn-login">로그인</form:button>
                </div>
            </div>
        </form:form>
    </div>

</body>
</html>