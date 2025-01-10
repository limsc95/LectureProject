<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<head>
    <title>수강신청</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery-3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
    <a href="${root}login" class="btn btn-warning float-right">로그아웃</a>

    <div class="container">
        <div class="card-body">
            <h3 class="card-title text-center">강의 목록</h3>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="text-center">과목번호</th>
                    <th class="text-center">과목명</th>
                    <th class="text-center">학점</th>
                    <th class="text-center">수강인원</th>
                    <th class="text-center">강의요일</th>
                    <th class="text-center">강의시간</th>
                    <th class="text-center">수강신청</th>
                </tr>
                </thead>
                <tbody>
                <!-- 강의 목록 반복 출력 -->
                <c:forEach var="lecture" items="${lectureList}">
                    <tr>
                        <td class="text-center">${lecture.lecture_idx}</td>
                        <td>${lecture.lecture_subject}</td>
                        <td class="text-center">${lecture.lecture_credit}</td>
                        <td class="text-center">${lecture.lecture_user_num}/${lecture.lecture_max_num}</td>
                        <td class="text-center">${lecture.lecture_day}</td>
                        <td class="text-center">${lecture.lecture_time}</td>
                        <td class="text-center">
                            <form action="${root}lecture_add" method="post">
                                <input type="hidden" name="lecture_index" value="${lecture.lecture_idx}">
                                <c:choose>
                                    <c:when test="${lecture.lecture_user_num<20}">
                                        <button type="submit" class="btn btn-primary">신청</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button type="submit" class="btn btn-primary" disabled>신청</button>
                                    </c:otherwise>
                                </c:choose>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="card-body">
            <h3 class="card-title text-center">내 강의 목록</h3>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="text-center">과목번호</th>
                    <th class="text-center">과목명</th>
                    <th class="text-center">학점</th>
                    <th class="text-center">수강인원</th>
                    <th class="text-center">강의요일</th>
                    <th class="text-center">강의시간</th>
                    <th class="text-center">수강신청</th>
                </tr>
                </thead>
                <tbody>
                <!-- 내 강의 목록 반복 출력 -->
                <c:forEach var="registeredLecture" items="${myLectureList}">
                    <tr>
                        <td class="text-center">${registeredLecture.lecture_idx}</td>
                        <td>${registeredLecture.lecture_subject}</td>
                        <td class="text-center">${registeredLecture.lecture_credit}</td>
                        <td class="text-center">${registeredLecture.lecture_user_num}/${registeredLecture.lecture_max_num}</td>
                        <td class="text-center">${registeredLecture.lecture_day}</td>
                        <td class="text-center">${registeredLecture.lecture_time}</td>
                        <td class="text-center">
                            <form action="${root}lecture_mul" method="post">
                                <input type="hidden" name="register_lecture_idx" value="${registeredLecture.lecture_idx}">
                                <button type="submit" class="btn btn-primary">신청</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
