<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Dashboard</title>

    <!-- Fontfaces CSS-->
    <link href="/project-demoweb/resources/css/font-face.css" rel="stylesheet" media="all">
    <link href="/project-demoweb/resources/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="/project-demoweb/resources/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="/project-demoweb/resources/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="/project-demoweb/resources/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="/project-demoweb/resources/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="/project-demoweb/resources/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="/project-demoweb/resources/vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="/project-demoweb/resources/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="/project-demoweb/resources/vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="/project-demoweb/resources/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="/project-demoweb/resources/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="/project-demoweb/resources/css/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <jsp:include page="/WEB-INF/views/modules/mobile-header.jsp" />
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <jsp:include page="/WEB-INF/views/modules/menu-sidebar.jsp" />
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <jsp:include page="/WEB-INF/views/modules/desktop-header.jsp" />
            <!-- HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                    </div>
                </div>
            </div>
            <!-- END MAIN CONTENT-->
            <!-- END PAGE CONTAINER-->
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="/project-demoweb/resources/vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="/project-demoweb/resources/vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="/project-demoweb/resources/vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="/project-demoweb/resources/vendor/slick/slick.min.js">
    </script>
    <script src="/project-demoweb/resources/vendor/wow/wow.min.js"></script>
    <script src="/project-demoweb/resources/vendor/animsition/animsition.min.js"></script>
    <script src="/project-demoweb/resources/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="/project-demoweb/resources/vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="/project-demoweb/resources/vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="/project-demoweb/resources/vendor/circle-progress/circle-progress.min.js"></script>
    <script src="/project-demoweb/resources/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="/project-demoweb/resources/vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="/project-demoweb/resources/vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="/project-demoweb/resources/js/main.js"></script>

</body>

</html>
<!-- end document-->
