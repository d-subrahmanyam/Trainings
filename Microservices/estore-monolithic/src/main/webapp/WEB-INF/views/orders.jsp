<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shopping Cart</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/main.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${shoppingCart.user == null}">
                            <a class="nav-link" href="/login">Login</a>
                        </c:when>
                        <c:when test="${shoppingCart.user != null}">
                            <a class="nav-link" href="/logout">Logout</a>
                        </c:when>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${shoppingCart.previousOrder != true}">
                            <a class="nav-link" href="/cart">Cart(${shoppingCart.items.size()})</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="/cart">Cart(0)</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <c:choose>
                    <c:when test="${shoppingCart.user != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="/orders">Orders</a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <!-- Page Features -->
    <div class="row text-center">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Order Confirmation Number</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${orders}" varStatus="loopCounter">
                    <tr>
                        <th scope="row">${loopCounter.index+1}</th>
                        <td><a href="/order?orderId=${order.guid}">${order.guid}</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>

</body>

</html>
