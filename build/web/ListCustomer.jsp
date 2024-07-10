<%-- 
    Document   : ListPet
    Created on : Mar 15, 2024, 3:49:40 PM
    Author     : DELL
--%>

<%@page import="dto.Customer"%>
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
            input {
                width: 100px;
            }

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

    <h1>${requestScope.erorr}</h1>

    <h2>Danh sách khách hàng </h2>
    
   
    
    
    <table class="table table-bordered ">
        <thead>
            <tr>
                <th scope="col">NO</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Birthday</th>
                <th scope="col">Gender</th>
                <th scope="col">Phone</th>
                <th scope="col">Address</th>
                <th scope="col">Status</th>
                <th scope="col">Choice</th>
            </tr>
        </thead>
        <tbody>


            <%
                ArrayList<Customer> list = (ArrayList<Customer>) request.getAttribute("ListCustomer");
                int count = 0;
                if (list != null && list.size() > 0) {
                    for (Customer it : list) {


            %>
            <form action="MainController" >
            <tr>
        
            <input type="hidden" value="${requestScope.txtId}" name="txtId"/>
            <input type="hidden" value="<%= it.getCussId()%>" name="txtCusId"/>
            <br/>
            <td><%= ++count%></td>

            <td><input type="text" value="<%= it.getFirstName()%>" name="txtfirst"/></td>

            <td><input type="text" value="<%= it.getLastName()%>" name="txtlast"/></td>          
            <td><input type="text" value="<%= it.getBirthday()%>" name="txtbirthday"/></td>
            <td><input type="text" value="<%= it.getGender()%>" name="txtgender"/></td>
            <td><input type="text" value="<%= it.getPhoneNumber()%>" name="txtphone"/></td>
            <td><input type="text" value="<%= it.getAddress()%>" name="txtaddress"/></td>
            <td> <input type="submit" value="updateCus" name="action"/>
                
            </td>
            <br/>
            
    </tr>
                </form>

        
        <% }

            } else {
                out.print("<h1>Lỗi</h1>");
            }
        %>





    </tbody>
</table>






<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
