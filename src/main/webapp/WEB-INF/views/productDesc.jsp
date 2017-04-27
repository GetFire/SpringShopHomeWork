<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Shop</title>


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
                    <a href="/products" >Products </a>

                </li>
                <li><a href="/user">Users</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <h3> Product: ${product.name}</h3>
        <table style="align-items: center">
            <tr>
                <th class="hidden">ID</th>
                <th>NAME</th>
                <th>MANUFACTURER</th>
                <th>PRICE</th>
                <th>DESCRIPTION</th>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <th>DELETE</th>
                </sec:authorize>
            </tr>
            <tr>
                <td hidden>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.manufacturer}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td>
                        <a href="/products/delete/${product.id}" class="btn">
                            <button class="btn btn-danger btn-sm btn-block">Delete</button>
                        </a>
                    </td>
                </sec:authorize>
            </tr>
            <tr>
                <td><img src="/products/photo/${product.id}"></td>
            </tr>
        </table>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <h3>Edit product</h3>
            <form action="/products/update/${product.id}" method="POST" enctype="multipart/form-data">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="id" value="${product.id}">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><label>
                            <input type="text" name="name" value="${product.name}">
                        </label></td>
                    </tr>
                    <tr>
                        <td>Manufacturer:</td>
                        <td><label>
                            <input type="text" name="manufacturer" value="${product.manufacturer}">
                        </label></td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td><label>
                            <input type="text" name="price" value="${product.price}">
                        </label></td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td><label>
                            <input type="text" name="description" value="${product.description}">
                        </label></td>
                    </tr>
                    <tr>
                        <td>Photo:</td>
                        <td><label>
                            <input name="file" type="file">
                        </label></td>
                    </tr>
                    <tr>
                        <td>
                            <div class="btn-group">
                                <button class="btn btn-success btn-lg " type="submit">Update</button>
                                <button class="btn btn-info btn-lg" type="reset">Reset</button>
                            </div>
                        </td>

                    </tr>
                </table>
            </form>
        </sec:authorize>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>