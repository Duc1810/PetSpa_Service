<%-- 
    Document   : header
    Created on : Mar 6, 2024, 10:19:22 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <header class="header">
            <a href="MainController?action=home" class="logo"><i class="fas fa-paw"></i>Dean</a>
            <nav class="navbar">
                 <a href="MainController?action=home">Home</a>             
                <a href="MainController?action=serviceMenu">Services</a>
                <c:if test="${sessionScope.User != null}">
                    <a href="MainController?action=signin">${sessionScope.User.userName}</a>
                </c:if>
                <a href="MainController?action=cabinMenu">Cabins</a>
                <a href="MainController?action=viewcart">cart</a>
                <a href="#contact">contact</a>
            </nav>
            
            <div class="dropdown">
                <div class="icons">
                    <a class="fas fa-bars ico " type="button" 
                       id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="MainController?action=serviceMenu" >List Services</a>
                        <a class="dropdown-item" href="MainController?action=cabinMenu">List Cabins</a>
                        <c:if test="${sessionScope.User != null}">
                            <a class="dropdown-item" href="MainController?action=listpetCus">List Pet Of Cust</a>
                        </c:if>
                        <a class="dropdown-item" href="MainController?action=logout">Log Out</a>
                    </div>
                    <a href="MainController?action=viewcart" class="fas fa-shopping-cart"></a>
                    <a  href="MainController?action=signin"class="fas fa-user ico" id="login-btn"></a>
                    <form class="find" action="FindCabinController">                    
                        <input type="text" id="find" name="txtCabin" value="${requestScope.key}"/>
                        <label for="find"><i class="fa-solid fa-magnifying-glass"></i></label>
                        <!--                  <input type="submit" value="find" name="action"/>-->
                    </form>
                </div>
            </div>

        </header>
    </body>
</html>
