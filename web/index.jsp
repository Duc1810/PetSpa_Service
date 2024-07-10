<%-- 
    Document   : index
    Created on : Mar 3, 2024, 10:01:51 PM
    Author     : DELL
--%>
<%@page import="dto.Account"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
            />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="./style1.css" />
    </head>
    <body>
        <form>
           Email <input type="text"/>
            Password <input type="text"/>
        </form>
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

                        <% HttpSession sesion = request.getSession();
                            Account acc = (Account) sesion.getAttribute("User");
                            if (acc != null) {
                                if (acc.getRole().equals("Admin")) {
                        %>
                        <a class="dropdown-item" href="MainController?action=manageSV">List Service Of Admin</a>
                        <a class="dropdown-item" href="ManageCustomerController">List Customer</a>
                        <%
                                }
                            }
                        %>
                        
                        

                        <c:if test="${sessionScope.User != null}">
                        <a class="dropdown-item" href="MainController?action=logout">Log Out</a>
                        </c:if>
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

        <section class="home" id="home">
            <div class="content">
                <h3><span>Hi</span> Welcome to our pet shop</h3>
                <a href="MainController?action=cabinMenu" class="btn-demo">Shop now</a>
            </div>
        </section>

        <!-- services section starts -->
        <section class="services" id="services">
            <h1 class="heading">our <span>services</span></h1>
            <div class="box-container">
                <div class="top">
                    <div class="box">
                        <i class="fas fa-shield-dog"></i>
                        <h3>Cabins List</h3>
                        <a href="MainController?action=cabinMenu" class="btn">See more</a>
                    </div>
                    <div class="box">
                        <i class="fas fa-bath"></i>
                        <h3>Service List</h3>
                        <a href="MainController?action=serviceMenu" class="btn">See more</a>
                    </div>
                    <div class="box">
                        <i class="fas fa-cat"></i>
                        <h3>cat boarding</h3>
                        <a href="listServiceController" class="btn">read more</a>
                    </div>
                </div>
                <div class="bottom">
                    <div class="box">
                        <i class="fas fa-drumstick-bite"></i>
                        <h3>healthy meal</h3>
                        <a href="#" class="btn">read more</a>
                    </div>
                    <div class="box">
                        <i class="fas fa-baseball-ball"></i>
                        <h3>activity exercise</h3>
                        <a href="#" class="btn">read more</a>
                    </div>
                    <div class="box">
                        <i class="fas fa-heartbeat"></i>
                        <h3>health care</h3>
                        <a href="#" class="btn">read more</a>
                    </div>
                </div>
            </div>
        </section>
        <section class="contact" id="contact">
            <div class="image">
                <img src="./images/5664315.jpg" alt=""/>
            </div>
            <div class="box_contact"></div>
            <form  class="form_contact" action="">
                <h3>contact us</h3>
                <input type="number" placeholder="your number" class="box-c">
                <input type="text" placeholder="your name" class="box-c"/>       
                <input type="email" placeholder="your name" class="box-c"/>
                <textarea name="" placeholder="your message" id="" cols="30" rows="10"></textarea>
                <input type="submit" value="send message" class="btn" />
            </form>
        </section>
        <!-- contact end -->
        <!-- footer -->
        <%@include file="Footer.jsp"%>
        <!-- footer end -->

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
