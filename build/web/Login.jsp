<%-- 
    Document   : Login
    Created on : Mar 3, 2024, 10:11:50 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
            />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="./style1.css" />
    </head>
    <body>


        <%@include file="header.jsp"%>
        <div class="box_spa"></div>
        <div class="form_container">
            <div class="content_login">
                <img src="./head.jpg" alt="" />
            </div>

            <div class="cotainer_login login_form">
                <div class="content_l">
                    <c:if test="${sessionScope.User == null}">
                    <form action="MainController" method="get" class="form_login">                        
                        
                        <h3>Sign in</h3>
                        <p>${requestScope.error}</p>
                        
                        <div class="email">
                            <label for="email">Email</label>
                            <input type="email" id="email" name="txtemail" placeholder="Enter your email" value="${requestScope.email}" required="" />
                        </div>
                        <div class="email">
                            <label for="password" >Password</label>
                            <input
                                type="password"
                                id="password"
                                placeholder="Enter your password"
                                name="txtpassword" required=""
                                />
                        </div>
                        <div class="submit"><input  type="submit" value="Login" name="action" /></div>
                        
                        <div class="login_signup">
                            Don't have an account? <a href="MainController?action=Signup" >Signup</a>
                            <a href="#" id="signup">Forgetpassword</a>
                        </div>
                         </form>
                        </c:if>
                        
                            <h1>Welcome, ${sessionScope.User.getUserName()}</h1>
                   
                </div>
            </div>

          

        </div>


        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="./script.js"></script>
    </body>
</html>
