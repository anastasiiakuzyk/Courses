<%@ page import="models.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="ex" uri="WEB-INF/tlds/mytags.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Курси</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/profile.css"/>
</head>
<body>
<main>
    <ex:Menu/>
    <div class="container-fluid platform__container__wrapper">
        <div class="platform__container">
            <h1>Доступні курси:</h1>
            <a href="addCourse?edit=0" class="btn btn-primary" tabindex="-1"
               role="button">Додати курс</a>
            <form>
                <select name="sort" class="form-select">
                    <option selected>Сортування</option>
                    <option value="nameAsc" ${sort=="nameAsc"?"selected":""}>
                        Відсортувати по імнені (за зростанням)
                    </option>
                    <option value="nameDesc" ${sort=="nameDesc"?"selected":""}>
                        Відсортувати по імнені (за спаданням)
                    </option>
                    <option value="durationAsc" ${sort=="durationAsc"?"selected":""}>
                        Відсортувати за тривалістю (за
                        зростанням)
                    </option>
                    <option value="durationDesc" ${sort=="durationDesc"?"selected":""}>
                        Відсортувати за тривалістю (за
                        спаданням)
                    </option>
                    <option value="studNumbAsc" ${sort=="studNumbAsc"?"selected":""}>
                        Відсортувати за кількістю студентів
                        (за зростанням)
                    </option>
                    <option value="studNumbDesc" ${sort=="studNumbDesc"?"selected":""}>
                        Відсортувати за кількістю
                        студентів (за спаданням)
                    </option>
                </select>
                <select name="theme" class="form-select" required>
                    <option value="default" selected>Тема не вибрана</option>
                    <c:forEach items="${themes}" var="them">
                        <option ${selectedTheme==them?"selected":"" } >${them}</option>
                    </c:forEach>
                </select>
                <select name="teacher" class="form-select" required>
                    <option value="default" selected>Вкладач не вибраний</option>
                    <c:forEach items="${teachers}" var="teache">
                        <option ${selectedTeacher==teache.getId().toString()?"selected":""} value="${teache.getId().toString()}">${teache.getName()}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="Сортувати" class="w-100 btn btn-primary">
            </form>
            <div class="cources">
                <c:forEach items="${courses}" var="course">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">
                                <c:out value="${course.getName()}"/>
                            </h5>
                            <h6 class="card-subtitle mb-2 text-muted">
                                <c:out value="${course.getTheme()}"/>
                            </h6>
                            <p class="card-text">
                                <c:out value="${course.getDescription()}"/>
                            </p>
                            <div class="cource__data">
                                <div class="card-text"><b>Викладач:</b></div>
                                <div>
                                    <c:out value="${course.getTeacherName()}"/>
                                </div>
                                <div class="card-text"><b>Початок:</b></div>
                                <div>
                                    <c:out value="${course.getStart()}"/>
                                </div>
                                <div class="card-text"><b>Кінець:</b></div>
                                <div>
                                    <c:out value="${course.getEnd()}"/>
                                </div>
                            </div>
                            <a href="course/join?id=${course.getId()}" class="card-link">Приєднатися</a>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>

    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
