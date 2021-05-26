<%@ taglib prefix="ex" uri="WEB-INF/tlds/mytags.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Додати курс</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/profile.css"/>
</head>
<body>
<main>
    <ex:Menu/>
    <div class="container-fluid platform__container__wrapper">
        <div class="platform__container">
            <h1>Додати курс</h1>
            <a href="courses" class="btn btn-secondary" tabindex="-1"
               role="button">Повернутися до курсів</a>
            <div class="col-md-7 col-lg-8 from__wrapper">
                <form action="addCourse" method="post" class="needs-validation">
                    <input name="id" type="hidden" value="${course.id.toString()}">
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">Назва курсу</label>
                            <input name="name" type="text" class="form-control" id="firstName" placeholder="" value="${course.name}"
                                   required>
                            <div class="invalid-feedback">
                                Valid first name is required.
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Тема</label>
                            <input name="theme" type="text" class="form-control" id="lastName" placeholder="" value="${course.theme}"
                                   required>
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="description" class="form-label">Опис:</label>
                            <textarea name="description" class="form-control" id="description">${course.description}</textarea>
                            <div class="invalid-feedback">
                                Please enter a valid email address for shipping updates.
                            </div>
                        </div>

                        <div class="col-md-5">
                            <label for="country" class="form-label">Викладач:</label>
                            <select name="teacher_id" class="form-select" id="country" required>
                                <option value="">Обрати...</option>
                                <c:forEach items="${teachers}" var="teacher">
                                    <option ${teacher.getId()==course.teacher_id?"selected":""} value="${teacher.getId()}">${teacher.getName()}</option>
                                </c:forEach>
                            </select>
                            <div class="invalid-feedback">
                                Please select a valid country.
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label for="start" class="form-label">Початок</label>
                            <input name="start" value="${course.start}" type="date" class="form-control" id="start" placeholder="" required>
                            <div class="invalid-feedback">
                                Please provide a valid state.
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="end" class="form-label">Кінець</label>
                            <input name="end" value="${course.end}" type="date" class="form-control" id="end" placeholder="" required>
                            <div class="invalid-feedback">
                                Zip code required.
                            </div>
                        </div>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary" type="submit">Додати курс</button>
                </form>
            </div>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
</body>
</html>
