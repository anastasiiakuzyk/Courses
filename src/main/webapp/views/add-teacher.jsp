<%@ taglib prefix="ex" uri="WEB-INF/tlds/mytags.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Додати викладача</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/profile.css"/>
</head>
<body>
<main>
    <ex:Menu/>
    <div class="container-fluid platform__container__wrapper">
        <div class="platform__container">
            <h1>Додати викладача</h1>
            <a href="teachers" class="btn btn-secondary" tabindex="-1"
               role="button">Повернутися до викладачів</a>
            <div class="col-md-7 col-lg-8 from__wrapper">
                <form action="${pageContext.request.contextPath}/addTeacher" method="post" class="needs-validation">

                    <div class="row g-3">
                        <div class="col-sm-12">
                            <label for="firstName" class="form-label">Ім'я викладача</label>
                            <input name="name" type="text" class="form-control" id="firstName" placeholder="" value=""
                                   required>
                            <div class="invalid-feedback">
                                Valid first name is required.
                            </div>
                        </div>

                        <div class="col-sm-12">
                            <label for="lastName" class="form-label">Email</label>
                            <input name="email" type="email" class="form-control" id="lastName" placeholder="" value=""
                                   required>
                            <div class="invalid-feedback">
                                Valid email is required.
                            </div>
                        </div>

                        <div class="col-sm-12">
                            <label for="password" class="form-label">Пароль</label>
                            <input name="password" type="password" class="form-control" id="password" placeholder=""
                                   value="" required>
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>

                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-primary" type="submit">Додати викладача</button>
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
