<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GetFire</title>

    <link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/font-awesome.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#responsive-menu">
                <span class="sr-only">Menu</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">GetFireShop</a>
        </div>
        <div class=" collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="/products">Products </a>

                </li>
                <li><a href="/user">Users</a></li>
            </ul>
            <button type="button" class="btn btn-primary navbar-right" data-toggle="modal" data-target="#modal-login">
                <i class="fa fa-sign-in"></i> Login
            </button>

        </div>
    </div>
</div>

<div class="container">
    <div class="col-lg-12">
        <div id="carousel" class="carousel slide">
            <!--Индикаторы слайдов-->
            <ol class="carousel-indicators">
                <li class="active" data-target="#carousel" data-slide-to="0"></li>
                <li data-target="#carousel" data-slide-to="1"></li>
                <li data-target="#carousel" data-slide-to="2"></li>
            </ol>

            <!--Слайды-->
            <div class="carousel-inner">
                <div class="item active" id="1slide">
                    <img src="http://welcome.stpaulsenglewood.org/wp-content/uploads/2017/04/JNTU-EXPRESS-Welcome.jpg"
                         alt="">
                    <div class="carousel-caption">
                        <h3>Welcome to my Shop</h3>
                        <p>The BEST shop</p>
                    </div>
                </div>
                <div class="item" id="2slide">
                    <img src="http://welcome.stpaulsenglewood.org/wp-content/uploads/2017/04/JNTU-EXPRESS-Welcome.jpg"
                         alt="">
                    <div class="carousel-caption">
                        <h3>We LOVE</h3>
                        <p>our customers</p>
                    </div>
                </div>
                <div class="item" id="3slide">
                    <img src="http://welcome.stpaulsenglewood.org/wp-content/uploads/2017/04/JNTU-EXPRESS-Welcome.jpg"
                         alt="">
                    <div class="carousel-caption">
                        <h3>Take a look</h3>
                        <p>You`ll find a grate deal!</p>
                    </div>
                </div>

            </div>

            <!--Стрелки переключения слайдов-->
            <a href="#carousel" class="left carousel-control" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a href="#carousel" class="right carousel-control" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
    </div>
</div>

<div class="modal fade" id="modal-login">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Registration
                    <button class="close" type="button" data-dismiss="modal">
                        <i class="fa fa-close"></i>
                    </button>
                </h4>

            </div>
            <div class="modal-body">
                <form action="" method="POST">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="login" value="">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="password" value="">
                    </div>
                    <button type="submit" class="btn btn-success">Login</button>

                    <form action="/registration">
                        <button class="btn btn-primary" type="submit">
                            <i class="fa fa-user-circle-o"></i> Create an account
                        </button>
                    </form>

                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>
