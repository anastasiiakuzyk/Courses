<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <title>Реєстрація</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/login.css"/>
</head>
<body>
<main class="form-signin">
    <form action="${pageContext.request.contextPath}/register" method="get">
        <svg width="40" height="32" viewBox="0 0 240 228" version="1.1" xmlns="http://www.w3.org/2000/svg"
             xmlns:xlink="http://www.w3.org/1999/xlink">
            <!-- Generator: Sketch 57.1 (83088) - https://sketch.com -->
            <title>Mobile</title>
            <desc>Created with Sketch.</desc>
            <g id="Mobile" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                <g id="Group">
                    <rect id="Rectangle" fill="#9B59B6" x="60" y="0" width="40" height="172"></rect>
                    <rect id="Rectangle" fill="#8E44AD"
                          transform="translate(80.000000, 20.000000) rotate(-90.000000) translate(-80.000000, -20.000000) "
                          x="60" y="-60" width="40" height="160"></rect>
                </g>
                <rect id="Rectangle" fill="#2980B9" x="120" y="56" width="40" height="172"></rect>
                <rect id="Rectangle" fill="#3498DB"
                      transform="translate(180.000000, 76.000000) rotate(-90.000000) translate(-180.000000, -76.000000) "
                      x="160" y="16" width="40" height="120"></rect>
                <rect id="Rectangle" fill="#2980B9" x="200" y="56" width="40" height="86"></rect>
                <rect id="Rectangle" fill="#3498DB"
                      transform="translate(200.000000, 152.000000) rotate(-90.000000) translate(-200.000000, -152.000000) "
                      x="180" y="112" width="40" height="80"></rect>
            </g>
        </svg>
        <h1 class="h3 mb-3 fw-normal text-center">Реєстрація</h1>

        <div class="form-floating top__part">
            <input type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
            <label for="floatingInput">Пошта</label>
        </div>
        <div class="form-floating">
            <input type="text" name="name" class="form-control" id="floatingName" placeholder="Ім'я">
            <label for="floatingName">Ваше ім'я</label>
        </div>
        <div class="form-floating bottom__part">
            <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Пароль">
            <label for="floatingPassword">Пароль</label>
        </div>
        <div class="form-floating new__user">
            Вже маєте обліковий запис? <a href="${pageContext.request.contextPath}/views/index.jsp">Увійти</a>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Уперед!</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2021</p>
    </form>
</main>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
