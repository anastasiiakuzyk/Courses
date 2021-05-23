<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Курси</title>

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <link href="css/profile.css" rel="stylesheet">
</head>
<body>
<main>
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
            <img  width="40" height="32" src="images/logo.svg" />
            <span class="fs-4" style="margin-left: 5px">TechPortal</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="/profile.html" class="nav-link text-white" aria-current="page">
                    <img class="bi me-2" width="16" height="16" src="images/users.svg" />
                    Профіль
                </a>
            </li>
            <li>
                <a href="/courses.html" class="nav-link active">
                    <img class="bi me-2" width="16" height="16" src="images/course.svg" />
                    Курси
                </a>
            </li>
            <li>
                <a href="/teachers.html" class="nav-link text-white">
                    <img class="bi me-2" width="16" height="16" src="images/teachers.svg" />
                    Викладачі
                </a>
            </li>
            <li>
                <a href="/students.html" class="nav-link text-white">
                    <img class="bi me-2" width="16" height="16" src="images/students.svg" />
                    Учні
                </a>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="images/user.svg" alt="" width="32" height="32" class="rounded-circle me-2">
                <strong>Nastya Kuzyk</strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a class="dropdown-item" href="#">Sign out</a></li>
            </ul>
        </div>
    </div>
    <div class="container-fluid platform__container__wrapper">
        <div class="platform__container">
            <h1>Курс Java</h1>
            <a href="/courses.html" class="btn btn-primary" tabindex="-1" role="button">Список курсів</a>
            <div class="card cource__page">
                <div class="card-body">
                    <h5 class="card-title">Програмування Java</h5>
                    <h6 class="card-subtitle mb-2 text-muted">ООП, Java EE, Початковий рівень</h6>
                    <p class="card-text">Цікавий туторіал по джава, для новочків, після курсу ви зможете..</p>
                    <div class="cource__data">
                        <div class="card-text"><b>Викладач:</b></div>
                        <div>Кузик А.В.</div>
                        <div class="card-text"><b>Початок:</b></div>
                        <div>10.06.2021</div>
                        <div class="card-text"><b>Кінець:</b></div>
                        <div>30.07.2021</div>
                    </div>
                </div>
            </div>
            <div class="card cource__page">
                <div class="card-body">
                    <h5 class="card-title">Щоденник</h5>
                    <h6 class="card-subtitle mb-2 text-muted">У цьому розділі ви можете виставити оцінки</h6>
                    <h5 class="card-title">Учні:</h5>
                    <div class="students">
                        <div class="card profile__card">
                            <img src="images/user.svg" />
                            <div class="profile__content">
                                <div class="name__tooltip text-muted">
                                    Ім'я
                                </div>
                                <h6>
                                    Nastya Kuzyk
                                </h6>

                                <div class="name__tooltip text-muted">
                                    Пошта
                                </div>
                                <h6>
                                    anastasiiakuzyk@gmail.com
                                </h6>
                            </div>
                            <div class="student__point">
                                <form>
                                    <input type="text" class="form-control" id="firstName" placeholder="Кількість балів" value="" required>
                                    <div class="invalid-feedback">
                                        Valid first name is required.
                                    </div>
                                    <button class="btn btn-primary">Поставити</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
