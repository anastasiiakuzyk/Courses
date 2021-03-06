<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="ex" uri="WEB-INF/tlds/mytags.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <title>Профіль</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/profile.css"/>
</head>
<body>
<main>
    <ex:Menu/>
    <div class="container-fluid platform__container__wrapper">
        <div class="platform__container">
            <div class="card profile__card">
                <svg width="50" height="50" class="rounded-circle me-2" version="1.1" id="Capa_1"
                     xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                     viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve">
<path style="fill:#303C42;"
      d="M256,0C114.844,0,0,114.844,0,256s114.844,256,256,256s256-114.844,256-256S397.156,0,256,0z"/>
                    <path style="fill:#E6E6E6;" d="M256,21.333c129.396,0,234.667,105.271,234.667,234.667c0,51.508-16.878,99.038-45.121,137.781
	c-2.467-1.605-4.905-3.069-7.379-4.344C395.417,367.49,329.104,341.333,256,341.333S116.583,367.49,73.823,389.448
	c-2.467,1.27-4.902,2.73-7.368,4.333C38.212,355.036,21.333,307.508,21.333,256C21.333,126.604,126.604,21.333,256,21.333z"/>
                    <path style="fill:#1E88E5;" d="M256,490.667c-70.161,0-133.056-31.108-176.095-80.073c1.227-0.743,2.464-1.551,3.678-2.177
	c40.656-20.875,103.573-45.75,172.417-45.75s131.76,24.875,172.406,45.74c1.22,0.63,2.46,1.439,3.69,2.186
	C389.056,459.557,326.161,490.667,256,490.667z"/>
                    <circle style="fill:#303C42;" cx="256" cy="192" r="128"/>
                    <linearGradient id="SVGID_1_" gradientUnits="userSpaceOnUse" x1="-33.5392" y1="631.086"
                                    x2="-28.0542" y2="625.6"
                                    gradientTransform="matrix(21.3333 0 0 -21.3333 996.3334 13791.667)">
                        <stop offset="0" style="stop-color:#000000;stop-opacity:0.1"/>
                        <stop offset="1" style="stop-color:#000000;stop-opacity:0"/>
                    </linearGradient>
                    <path style="fill:url(#SVGID_1_);" d="M352.73,469.59c30.467-13.922,57.497-34.118,79.366-58.997c-1.23-0.747-2.47-1.556-3.69-2.186
	c-40.646-20.865-103.563-45.74-172.406-45.74c-3.296,0-6.501,0.314-9.768,0.424L352.73,469.59z"/>
                    <circle style="fill:#1E88E5;" cx="256" cy="192" r="106.667"/>
                    <path style="opacity:0.1;enable-background:new    ;" d="M313.184,102.263c4.176,11.41,6.816,23.565,6.816,36.404
	c0,58.815-47.85,106.667-106.667,106.667c-21.077,0-40.621-6.339-57.184-16.93c14.956,40.861,53.872,70.263,99.85,70.263
	c58.816,0,106.667-47.852,106.667-106.667C362.667,154.26,342.841,121.229,313.184,102.263z"/>
                    <linearGradient id="SVGID_2_" gradientUnits="userSpaceOnUse" x1="-45.5784" y1="639.555"
                                    x2="-23.8278" y2="629.4138"
                                    gradientTransform="matrix(21.3333 0 0 -21.3333 996.3334 13791.667)">
                        <stop offset="0" style="stop-color:#FFFFFF;stop-opacity:0.2"/>
                        <stop offset="1" style="stop-color:#FFFFFF;stop-opacity:0"/>
                    </linearGradient>
                    <path style="fill:url(#SVGID_2_);"
                          d="M256,0C114.844,0,0,114.844,0,256s114.844,256,256,256s256-114.844,256-256S397.156,0,256,0z"
                    /></svg>
                <div class="profile__content">
                    <div class="name__tooltip text-muted">
                        Ім'я
                    </div>
                    <h5>
                        ${user.name}
                    </h5>

                    <div class="name__tooltip text-muted">
                        Пошта
                    </div>
                    <h5>
                        ${user.email}
                    </h5>

                    <div class="name__tooltip text-muted">
                        Роль
                    </div>
                    <h5>
                        ${user.getRole()}
                    </h5>
                </div>

            </div>
            <h1 style="margin-top: 40px;">Мої курси:</h1>
            <form>
                <select name="progress" class="form-select">
                    <option selected>Всі курси</option>
                    <option value="notStart" ${progress=="notStart"?"selected":""}>Не почалися</option>
                    <option value="inProgress" ${progress=="inProgress"?"selected":""}>Доступні</option>
                    <option value="ended" ${progress=="ended"?"selected":""}>Завершені</option>

                </select>
                <input type="submit" value="Обрати" class="w-100 btn btn-primary">
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
                                    <c:choose>
                                        <c:when test="${user.roleId==3}">
                                            ${course.getTeacher().getName()}
                                        </c:when>
                                        <c:otherwise>
                                            ${user.name}
                                        </c:otherwise>
                                    </c:choose>

                                </div>
                                <div class="card-text"><b>Початок:</b></div>
                                <div>${course.getStart()}</div>
                                <div class="card-text"><b>Кінець:</b></div>
                                <div>${course.getEnd()}</div>
                            </div>
                            <a href="course?id=${course.getId()}" class="card-link">переглянути</a>
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
