<%-- 
    Document   : listRent
    Created on : Mar 4, 2024, 12:47:58 PM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.Cabin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./style1.css" />
        <style>

            #wrapper {
                margin-left: 10%;
                margin-right: 5%;
                font-family: arial;
            }
            h3{
                text-align: left;
                color: blue;
            }
            ul{
                list-style: none;

            }
            li{
                width: 25%;
                text-align: center;
                float:left;
                margin:25px;
                border:2px solid chocolate;
                border-radius: 20px;

            }
            li img{

                margin-top: 15px;
                width: 90%;
                border-radius: 15px;
            }
            li a{
                text-decoration: none;
            }
            li:hover{
                background: bisque;
                border: none;
                transition: 1.7s;
                cursor: pointer;
            }

            p{
                margin:5px;
                color: blue;
                font-size: 12px;
            }
            .old {
                text-decoration:line-through;
                color:red;
            }
            h3{
                text-align: center;
                color:#e67e22;
            }
            h3 span {
                color: #130f40}
            .input input {
                width: 100px;
                height: 40px;
                border-radius: 15px;
                margin-bottom: 5px;
                background-color:#e67e22;
                color: #fff;

            }
            .divide {
                max-width:  400rem;
                margin-top: 155rem;
                margin-left: 51rem;
                margin-bottom: 10rem;
            }
            .divide a {text-align: center;
                       color: black;
                       padding-left: 40px;
                       font-weight : bolder;
            }
            h2 {text-align: center;
                color: #130f40;
                font-family: "Poppins", sans-serif;
                font-size: 40px}
            .cc{
                color:red;
            }.mb{
                margin: 6px;
            }
            .email {
                margin-left: 25px;
            }
            .im {
                padding-top: 2rem;
                width: 25rem;
                height: 30rem;
            }
            label {font-size: 17px;}

        </style>
        <script>
            function change() {
                document.getElementById("f1").submit();
            }
            function change1() {
                document.getElementById("f2").submit();
            }
        </script>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div class="box_spa"></div>
        <div class="box_spa"></div>
        <h2>CABIN LIST</h2>
        <h1>${requestScope.info}</h1>
        <form action="CatergoryController" id="f1" >
            <div class="email"> <spa>Category:</spa>
                <input type="hidden" value="typecabin" name="action"/>
                <select  name="key" onclick="change()" >
                    <option value="All">All</option>                
                    <option value="Iron">Iron</option>
                    <option value="Plastic">Plastic</option>
                    <option value="Iron">Iron</option>
                    <option value="Assembled">Assembled</option>
                    <option value="Glass">Glass</option>               
                </select><br/>
            </div>
        </form >
        <form action="MainController" id="f2">
            <input type="hidden" name="action" value="sizepage"/>
            <div class="mb-3 container"   >

                <div class="row">
                    <div class="form-check form-check-country col-sm-1 " onclick="change1()">
                        <input
                            id="vietnam"
                            type="radio"
                            class="form-check-input"
                            value="1"
                            name="size"
                            />
                        <!--             form-check-input: giúp căn lề vào đẹp -->
                        <label for="vietnam" class="form-check-label">20-40kg</label>
                        <!--             name là dùng để chọn 1 trong hai không chọn đc 2 -->
                    </div>

                    <div class="form-check form-check-country col-sm-1" onclick="change1()">
                        <input
                            id="tt"
                            type="radio"
                            class="form-check-input"
                            value="2"
                            name="size"
                            />
                        <label for="tt" class="form-check-label">40-60kg</label>
                    </div>
                    <div class="form-check form-check-country col-sm-1 " onclick="change1()">
                        <input
                            id="other"
                            type="radio"
                            class="form-check-input"
                            value="3"
                            name="size"
                            />
                        <label for="other" class="form-check-label">60-80kg</label>
                    </div>
                </div>
            </div>


            <br/>
        </select>
    </form>


    <div id="wrapper">

        <ul>
            <%
                ArrayList<Cabin> list = (ArrayList<Cabin>) request.getAttribute("listCabin");
                if (list != null && list.size() > 0) {
                    for (Cabin it : list) {
                        if (it.getAmount() > 0) {

            %>

            <li>
                <!--                <form action="addItemToCartController">-->



                <form action="MainController">
                    <div class="input">
                        <input type="hidden" value="<%= it.getCabinId()%>" name="txtId"/>
                        <div class="im">
                            <img src="<%= it.getImage()%>"/>
                        </div>
                        <br/>
                        <h3><span>Name:</span> <%= it.getTypeCabin()%><h3>
                                <h3><span>Size:</span> <%= it.getSize()%></h3>
                                <h3><span>Price:</span> <%= it.getPrice()%></h3>

                                <input  type="submit" value="Choice" name="action"/>
                                </div>
                                </form>
                                </li>
                                <% }
                                    }
                                } else {
                                %>
                                <h1>
                                    Danh sách rỗng
                                </h1>
                                <%
                                    }
                                %>
                                </ul>
                                </div>
                                <div class="divide"></div>
                                <div class="divide"></div>
                                <div  class="divide">
                                    <c:if test="${tag > 1}">
                                        <a href="DividePageController?index=${tag-1}"><i class="fa-solid fa-arrow-left"></i></a>
                                        </c:if>
                                        <c:forEach begin="1" end="${endP}" var="i">

                                        <a  class=" ${tag == i? cc :""}" href="DividePageController?index=${i}">${i}</a>
                                    </c:forEach>

                                    <c:if test="${tag < endP}">
                                        <a href="DividePageController?index=${tag+1}"><i class="fa-solid fa-arrow-right"></i></a>
                                        </c:if>
                                </div>



                                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                                <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                                <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
                                </body>
                                </html>
