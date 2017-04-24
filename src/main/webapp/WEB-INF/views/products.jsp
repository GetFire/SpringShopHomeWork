<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>My Shop:All products</title>
    <link href="${contextPath}/resources/css/bootstrap.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="navbar navbar-inverse navbar-static-top">
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
                    <a href="/products" class="dropdown-toggle" data-toggle="dropdown">Products <b
                            class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/products">See all </a></li>
                        <li><a href="/products/update/">Update</a></li>
                    </ul>
                </li>
                <li><a href="/users">Users</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <h3>Products</h3>
        <table style="align-items: center">
            <tr>
                <th hidden>Id</th>
                <th>Name</th>
                <th>Manufacturer</th>
                <th>Price</th>
                <th>Description</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="products" items="${productList}">
                <tr>
                    <td hidden>${products.id}</td>
                    <td><a href="/products/${products.id}">${products.name}</a></td>
                    <td>${products.manufacturer}</td>
                    <td>${products.price}</td>
                    <td>${products.description}</td>
                    <td colspan="2">
                        <p><a href="/products/${products.id}"><button class="btn btn-warning btm-xs">Edit</button></a>
                            <a href="/products/delete/${products.id}"><button class="btn btn-danger btn-xs">Delete</button></a>
                        </p>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <h3>Add product</h3>
        <form action="/products/save" method="POST">
            <input type="hidden" name="id" value="">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Manufacturer:</td>
                    <td><input type="text" name="manufacturer"></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price"></td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="description"></td>
                </tr>
                <tr>
                    <td>
                        <button class="btn btn-success btn-lg btn-block" type="submit">Add</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>