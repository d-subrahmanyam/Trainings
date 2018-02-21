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
    <link href="css/cart.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">EStore</a>
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

    <div class="wrap cf">
        <div class="heading cf">
            <h1>My Cart</h1>
            <a href="/" class="continue">Continue Shopping</a>
        </div>
        <div class="cart">
            <!--    <ul class="tableHead">
                  <li class="prodHeader">Product</li>
                  <li>Quantity</li>
                  <li>Total</li>
                   <li>Remove</li>
                </ul>-->
            <c:if test="${orderConfirmationId != null}">
                <div class="success alert-success" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                    <span class="sr-only">Success:</span>
                    <a href="/order?orderId=${orderConfirmationId}">Please click here to view this order</a>
                </div>
            </c:if>
            <ul class="cartWrap">
                <c:forEach var="lineItem" items="${shoppingCart.items}" varStatus="loopCounter">
                    <c:choose>
                        <c:when test="${loopCounter.index%2 != 0}">
                            <li class="items odd">
                        </c:when>
                        <c:otherwise>
                            <li class="items even">
                        </c:otherwise>
                    </c:choose>
                        <div class="infoWrap">
                            <div class="cartSection">
                                <img src="http://lorempixel.com/output/technics-q-c-300-300-4.jpg" alt="" class="itemImg" />
                                <p class="itemNumber">#QUE-007544-002</p>
                                <h3>${lineItem.item.name}</h3>

                                <p> <input type="text"  class="qty" placeholder="${lineItem.quantity}"/> x ${lineItem.item.price}</p>
                            </div>


                            <div class="prodTotal cartSection">
                                <p>$${lineItem.item.price*lineItem.quantity}</p>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div class="promoCode"><label for="promo">Have A Promo Code?</label><input type="text" name="promo" placholder="Enter Code" />
            <a href="#" class="btn"></a></div>

        <div class="subtotal cf">
            <ul>
                <li class="totalRow"><span class="label">Subtotal</span><span class="value">${shoppingCart.total}</span></li>

                <li class="totalRow"><span class="label">Shipping</span><span class="value">$5.00</span></li>

                <li class="totalRow"><span class="label">Tax</span><span class="value">$4.00</span></li>
                <li class="totalRow final"><span class="label">Total</span><span class="value">$${shoppingCart.total+5.00+4.00}</span></li>
                <c:choose>
                    <c:when test="${shoppingCart.previousOrder != true}">
                        <li class="totalRow"><a href="/checkout" class="btn continue">Checkout</a></li>
                    </c:when>
                </c:choose>

            </ul>
        </div>
    </div>

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
<script src="js/cart.js"></script>

</body>

</html>
