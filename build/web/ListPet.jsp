<%-- 
    Document   : ListPet
    Created on : Mar 15, 2024, 3:49:40 PM
    Author     : DELL
--%>

<%@page import="dto.Pet"%>
<%@page import="dto.Cabin"%>
<%@page import="java.util.ArrayList"%>
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
                width: 90%;
                border-radius: 15px;
            }
            li a{
                text-decoration: none;
            }
            li:hover{
                background: bisque;
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
            h2 {text-align: center;
            color: #ed7811;
            font-size: 40px}
            .cc {margin: 0 17px;
            padding: 0 5px}
            td input {
                width: 90px;
                height: 30px;
                border-radius: 15px;
                margin-bottom: 5px;
                background-color:#e67e22;
                color: #fff;

            }
            td input

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
        <form action="CatergoryController" id="f1" >
            <!--c:set var="cid" value="${cid}" ${(cid==c.id)?'select':''}/-->

        </form >
        <h1>${requestScope.info}</h1>
        <form action="SizeContronller" id="f2">

            <div><a href="DividePageController"><i class="fa-solid fa-backward"></i></a></div>
            <div><a href="Pet.jsp">Create Pet</a></div>
           
            <br/>
        </select>
    </form>
    <h1>${requestScope.erorr}</h1>

        <h2>Danh sách thú cưng của bạn</h2>
        <table class="table cc">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">NO</th>
                    <th scope="col">Name</th>
                    <th scope="col">Gender</th>
                    <th scope="col">Color</th>
                    <th scope="col">Size</th>
                    <th>Choice</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                   
                    <%
                        ArrayList<Pet> list = (ArrayList<Pet>) request.getAttribute("listPet");
                        int count = 0;
                        if (list != null && list.size() > 0) {
                            for (Pet it : list) {
                                if (it.getStatus() > 0) {

                    %>
            <form action="addItemToCartController" >
                <input type="hidden" value="${requestScope.txtId}" name="txtId"/>
                <input type="hidden" value="<%= it.getPetID()%>" name="txtPetId"/>
                <br/>
                <div class="input">
                <td><%= ++count%></td>
                <td><%= it.getName()%></td>
                <td><%= it.getGender()%></td>
                <td><%= it.getColor()%></td>
                <td><%= it.getWeight()  %>*<%= it.getHeight() %>*<%= it.getWidth()%></td>
                <td> <input type="submit" value="CHOICE" name="action"/></td>
                </div>
            </form>
                
           
            </tr>
            <% }
                    }
                }
            %>
            

            </tbody>
        </table>



   
   

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
