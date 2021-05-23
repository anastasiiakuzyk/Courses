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
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
        <a href="${pageContext.request.contextPath}/"
           class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
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
            <span class="fs-4" style="margin-left: 5px">TechPortal</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/views/profile.jsp" class="nav-link text-white"
                   aria-current="page">
                    <svg class="bi me-2" width="16" height="16" viewBox="0 0 512 512" version="1.1"
                         xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <!-- Generator: Sketch 57.1 (83088) - https://sketch.com -->
                        <title>user (1)</title>
                        <desc>Created with Sketch.</desc>
                        <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                            <g id="user-(1)" fill="#FFFFFF" fill-rule="nonzero">
                                <path d="M437.019531,74.980469 C388.667969,26.628906 324.378906,0 256,0 C187.617188,0 123.332031,26.628906 74.980469,74.980469 C26.628906,123.332031 -2.84217094e-14,187.617188 -2.84217094e-14,256 C-2.84217094e-14,324.378906 26.628906,388.667969 74.980469,437.019531 C123.332031,485.371094 187.617188,512 256,512 C324.378906,512 388.667969,485.371094 437.019531,437.019531 C485.371094,388.667969 512,324.378906 512,256 C512,187.617188 485.371094,123.332031 437.019531,74.980469 Z M128.339844,442.386719 C139.046875,380.738281 192.46875,335.265625 256,335.265625 C319.535156,335.265625 372.953125,380.738281 383.660156,442.386719 C347.3125,467.359375 303.335938,482 256,482 C208.664062,482 164.6875,467.359375 128.339844,442.386719 Z M174.601562,223.867188 C174.601562,178.980469 211.117188,142.46875 256,142.46875 C300.882812,142.46875 337.398438,178.984375 337.398438,223.867188 C337.398438,268.75 300.882812,305.265625 256,305.265625 C211.117188,305.265625 174.601562,268.75 174.601562,223.867188 Z M409.644531,421.578125 C401.570312,392.878906 385.535156,366.839844 363.058594,346.5 C349.269531,334.019531 333.574219,324.171875 316.699219,317.230469 C347.199219,297.335938 367.402344,262.917969 367.402344,223.867188 C367.402344,162.441406 317.425781,112.46875 256,112.46875 C194.574219,112.46875 144.601562,162.441406 144.601562,223.867188 C144.601562,262.917969 164.804688,297.335938 195.300781,317.230469 C178.429688,324.171875 162.730469,334.015625 148.941406,346.496094 C126.46875,366.835938 110.429688,392.875 102.355469,421.578125 C57.882812,380.273438 30,321.335938 30,256 C30,131.382812 131.382812,30 256,30 C380.617188,30 482,131.382812 482,256 C482,321.339844 454.117188,380.277344 409.644531,421.578125 Z"
                                      id="Shape"></path>
                            </g>
                        </g>
                    </svg>
                    Профіль
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/views/courses.jsp" class="nav-link active">
                    <svg class="bi me-2" width="16" height="16" viewBox="0 0 496 384" version="1.1"
                         xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <!-- Generator: Sketch 57.1 (83088) - https://sketch.com -->
                        <title>online-course</title>
                        <desc>Created with Sketch.</desc>
                        <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                            <g id="online-course" fill="#FFFFFF" fill-rule="nonzero">
                                <path d="M456,-2.84217094e-14 L104,-2.84217094e-14 C84.7419119,0.0270455913 68.2285534,13.7540872 64.683,32.683 C48.4414382,35.7366277 35.7366277,48.4414382 32.683,64.683 C13.7540872,68.2285534 0.0270455913,84.7419119 0,104 L0,344 C0.0247994227,366.08111 17.9188904,383.975201 40,384 L392,384 C411.258088,383.972954 427.771447,370.245913 431.317,351.317 C447.558562,348.263372 460.263372,335.558562 463.317,319.317 C482.245913,315.771447 495.972954,299.258088 496,280 L496,40 C495.975201,17.9188904 478.08111,0.0247994227 456,-2.84217094e-14 Z M16,104 C16.0148797,90.7513343 26.7513343,80.0148797 40,80 L392,80 C405.248666,80.0148797 415.98512,90.7513343 416,104 L416,112 L16,112 L16,104 Z M416,344 C415.98512,357.248666 405.248666,367.98512 392,368 L40,368 C26.7513343,367.98512 16.0148797,357.248666 16,344 L16,128 L416,128 L416,344 Z M448,312 C447.987195,322.165923 441.58074,331.224651 432,334.624 L432,104 C431.975201,81.9188904 414.08111,64.0247994 392,64 L49.376,64 C52.7753495,54.4192598 61.8340767,48.0128048 72,48 L424,48 C437.248666,48.0148797 447.98512,58.7513343 448,72 L448,312 Z M480,280 C479.987195,290.165923 473.58074,299.224651 464,302.624 L464,72 C463.975201,49.9188904 446.08111,32.0247994 424,32 L81.376,32 C84.7753495,22.4192598 93.8340767,16.0128048 104,16 L456,16 C469.248666,16.0148797 479.98512,26.7513343 480,40 L480,280 Z"
                                      id="Shape"></path>
                                <circle id="Oval" cx="40" cy="96" r="8"></circle>
                                <circle id="Oval" cx="72" cy="96" r="8"></circle>
                                <circle id="Oval" cx="104" cy="96" r="8"></circle>
                                <path d="M128,296 L304,296 C308.418278,296 312,292.418278 312,288 L312,160 C312,155.581722 308.418278,152 304,152 L128,152 C123.581722,152 120,155.581722 120,160 L120,288 C120,292.418278 123.581722,296 128,296 Z M136,168 L296,168 L296,280 L136,280 L136,168 Z"
                                      id="Shape"></path>
                                <path d="M196.1,238.983 C198.629928,240.39681 201.726658,240.331777 204.195,238.813 L243.195,214.813 C245.560733,213.356957 247.001788,210.777905 247.001788,208 C247.001788,205.222095 245.560733,202.643043 243.195,201.187 L204.195,177.187 C201.726606,175.666879 198.628995,175.601038 196.098238,177.0149 C193.56748,178.428762 192,181.10108 192,184 L192,232 C192.000719,234.898539 193.569219,237.569962 196.1,238.983 Z M208,198.316 L223.736,208 L208,217.684 L208,198.316 Z"
                                      id="Shape"></path>
                                <path d="M272,248 L256,248 C256,243.581722 252.418278,240 248,240 C243.581722,240 240,243.581722 240,248 L160,248 C155.581722,248 152,251.581722 152,256 C152,260.418278 155.581722,264 160,264 L240,264 C240,268.418278 243.581722,272 248,272 C252.418278,272 256,268.418278 256,264 L272,264 C276.418278,264 280,260.418278 280,256 C280,251.581722 276.418278,248 272,248 Z"
                                      id="Path"></path>
                                <path d="M128,320 L304,320 C308.418278,320 312,316.418278 312,312 C312,307.581722 308.418278,304 304,304 L128,304 C123.581722,304 120,307.581722 120,312 C120,316.418278 123.581722,320 128,320 Z"
                                      id="Path"></path>
                                <path d="M128,344 L240,344 C244.418278,344 248,340.418278 248,336 C248,331.581722 244.418278,328 240,328 L128,328 C123.581722,328 120,331.581722 120,336 C120,340.418278 123.581722,344 128,344 Z"
                                      id="Path"></path>
                                <path d="M272,328 L264,328 C259.581722,328 256,331.581722 256,336 C256,340.418278 259.581722,344 264,344 L272,344 C276.418278,344 280,340.418278 280,336 C280,331.581722 276.418278,328 272,328 Z"
                                      id="Path"></path>
                            </g>
                        </g>
                    </svg>
                    Курси
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/views/teachers.jsp" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16" viewBox="0 0 512 512" version="1.1"
                         xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <!-- Generator: Sketch 57.1 (83088) - https://sketch.com -->
                        <title>class</title>
                        <desc>Created with Sketch.</desc>
                        <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                            <g id="class" fill="#FFFFFF" fill-rule="nonzero">
                                <path d="M135,0 C101.642,0 75,28.006 75,61 C75,94.084 101.916,121 135,121 C168.084,121 195,94.084 195,61 C195,27.98 168.324,0 135,0 Z M135,91 C118.458,91 105,77.542 105,61 C105,44.196 118.738,30 135,30 C151.262,30 165,44.196 165,61 C165,77.542 151.542,91 135,91 Z"
                                      id="Shape"></path>
                                <path d="M467,0 L255,0 C230.187,0 210,20.187 210,45 L210,147.365 L196.817,134.183 C188.317,125.682 177.017,121 165,121 L135,121 C128.641,121 81.359,121 75,121 C33.645,121 0,154.645 0,196 C0,204.529 0,273.68 0,286 C0,310.813 20.187,331 45,331 C50.257,331 55.307,330.094 60,328.43 L60,467 C60,491.813 80.187,512 105,512 C116.515,512 127.033,507.653 135,500.514 C142.967,507.653 153.485,512 165,512 C189.813,512 210,491.813 210,467 L210,268.444 C221.469,272.489 234.174,271.71 245.126,266.253 L295.631,241 L467,241 C491.813,241 512,220.813 512,196 L512,45 C512,20.187 491.813,0 467,0 Z M291.709,209.419 L231.727,239.41 C226.1,242.214 219.111,241.32 214.394,236.604 L205.608,227.817 C196.332,218.541 180.041,224.85 180.001,238.377 C180.001,238.392 179.999,238.406 179.999,238.421 L179.999,467 C179.999,475.271 173.27,482 164.999,482 C156.728,482 149.999,475.271 149.999,467 L149.999,316 C149.999,307.716 143.283,301 134.999,301 C126.715,301 119.999,307.716 119.999,316 L119.999,467 C119.999,475.271 113.27,482 104.999,482 C96.728,482 89.999,475.271 89.999,467 L89.999,286 C89.999,274.69 89.999,205.244 89.999,196 C89.999,187.716 83.283,181 74.999,181 C66.715,181 59.999,187.716 59.999,196 C59.999,204.529 59.999,273.68 59.999,286 C59.999,294.271 53.27,301 44.999,301 C36.728,301 29.999,294.271 29.999,286 C29.999,274.69 29.999,205.244 29.999,196 C29.999,171.187 50.187,151 75,151 C86.31,151 155.756,151 165,151 C169.004,151 172.77,152.561 175.604,155.396 L220.311,200.103 C224.875,204.668 231.851,205.799 237.625,202.913 L278.294,182.578 C285.738,178.853 294.709,181.864 298.418,189.29 C302.128,196.711 299.13,205.709 291.709,209.419 Z M482,196 C482,204.271 475.271,211 467,211 L327.419,211 C327.51,210.743 327.61,210.491 327.696,210.232 C329.856,203.752 330.504,197.014 329.678,190.432 L411.708,149.417 C419.118,145.712 422.121,136.702 418.416,129.292 C414.711,121.882 405.7,118.878 398.291,122.584 L316.266,163.597 C303.124,150.885 282.653,146.85 264.873,155.748 L240,168.185 L240,45 C240,36.729 246.729,30 255,30 L467,30 C475.271,30 482,36.729 482,45 L482,196 Z"
                                      id="Shape"></path>
                            </g>
                        </g>
                    </svg>
                    Викладачі
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/views/students.jsp" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16" viewBox="0 0 430 512" version="1.1"
                         xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <!-- Generator: Sketch 57.1 (83088) - https://sketch.com -->
                        <title>reading-book</title>
                        <desc>Created with Sketch.</desc>
                        <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                            <g id="reading-book" transform="translate(-1.000000, 0.000000)" fill="#FFFFFF"
                               fill-rule="nonzero">
                                <path d="M430.994,330 C430.994,305.854 413.789,285.652 390.994,281.006 L390.994,227 C390.994,222.08 388.582,217.474 384.538,214.671 C380.494,211.868 375.332,211.226 370.727,212.955 L342.098,223.691 C323.298,204.146 300.446,189.425 275.404,180.388 C300.012,162.154 315.994,132.91 315.994,100 C315.994,44.859 271.135,-5.68434189e-14 215.994,-5.68434189e-14 C160.853,-5.68434189e-14 115.994,44.859 115.994,100 C115.994,132.91 131.976,162.154 156.584,180.388 C131.541,189.426 108.69,204.147 89.89,223.691 L61.261,212.955 C56.655,211.226 51.493,211.868 47.45,214.671 C43.406,217.474 40.994,222.08 40.994,227 L40.994,281.006 C18.199,285.652 0.994,305.853 0.994,330 C0.994,354.147 18.199,374.348 40.994,378.994 L40.994,437 C40.994,443.253 44.873,448.85 50.727,451.045 L210.727,511.045 C214.101,512.303 217.886,512.303 221.26,511.045 L381.26,451.045 C387.114,448.85 390.993,443.253 390.993,437 L390.993,378.994 C413.789,374.348 430.994,354.146 430.994,330 Z M145.994,100 C145.994,61.402 177.396,30 215.994,30 C254.592,30 285.994,61.402 285.994,100 C285.994,138.598 254.592,170 215.994,170 C177.396,170 145.994,138.598 145.994,100 Z M215.994,200 C251.137,200 284.703,212.701 310.893,235.393 L215.994,270.98 L121.095,235.393 C147.286,212.701 180.852,200 215.994,200 L215.994,200 Z M30.994,330 C30.994,318.972 39.966,310 50.994,310 L60.994,310 L60.994,350 L50.994,350 C39.966,350 30.994,341.028 30.994,330 Z M70.994,379.497 C82.391,377.174 90.994,367.073 90.994,355 L90.994,305 C90.994,292.927 82.391,282.826 70.994,280.503 L70.994,248.645 L200.994,297.395 L200.994,475.356 L70.994,426.606 L70.994,379.497 Z M230.994,475.355 L230.994,297.395 L360.994,248.645 L360.994,280.503 C349.597,282.826 340.994,292.927 340.994,305 L340.994,355 C340.994,367.073 349.597,377.174 360.994,379.497 L360.994,426.605 L230.994,475.355 Z M380.994,350 L370.994,350 L370.994,310 L380.994,310 C392.022,310 400.994,318.972 400.994,330 C400.994,341.028 392.023,350 380.994,350 Z"
                                      id="Shape"></path>
                            </g>
                        </g>
                    </svg>
                    Учні
                </a>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
               id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <svg width="32" height="32" class="rounded-circle me-2" version="1.1" id="Capa_1"
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
                <strong>Nastya Kuzyk</strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a class="dropdown-item" href="#">Sign out</a></li>
            </ul>
        </div>
    </div>
    <div class="container-fluid platform__container__wrapper">
        <div class="platform__container">
            <h1>Додати курс</h1>
            <a href="${pageContext.request.contextPath}/views/courses.jsp" class="btn btn-secondary" tabindex="-1"
               role="button">Повернутися до курсів</a>
            <div class="col-md-7 col-lg-8 from__wrapper">
                <form class="needs-validation">
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">Назва курсу</label>
                            <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
                            <div class="invalid-feedback">
                                Valid first name is required.
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Категорії</label>
                            <input type="text" class="form-control" id="lastName" placeholder="" value="" required>
                            <div class="invalid-feedback">
                                Valid last name is required.
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="description" class="form-label">Опис:</label>
                            <textarea class="form-control" id="description">
                            </textarea>
                            <div class="invalid-feedback">
                                Please enter a valid email address for shipping updates.
                            </div>
                        </div>

                        <div class="col-md-5">
                            <label for="country" class="form-label">Викладач:</label>
                            <select class="form-select" id="country" required>
                                <option value="">Обрати...</option>
                                <option>Кузик А.В.</option>
                            </select>
                            <div class="invalid-feedback">
                                Please select a valid country.
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label for="start" class="form-label">Початок</label>
                            <input type="date" class="form-control" id="start" placeholder="" required>
                            <div class="invalid-feedback">
                                Please provide a valid state.
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="end" class="form-label">Кінець</label>
                            <input type="date" class="form-control" id="end" placeholder="" required>
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