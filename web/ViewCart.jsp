<%-- 
    Document   : ViewCart
    Created on : Mar 11, 2024, 1:06:44 PM
    Author     : DELL
--%>
<%@page import="dto.Service"%>
<%@page import="dto.Account"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.HashMap"%>
<%@page import="dto.Cabin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    <session>
        <H1> Thong tin gio hang cua ban</h1>
            <%
                HashMap<Cabin, String> giohang = (HashMap<Cabin, String>) session.getAttribute("cartCabin");
                HashMap<Service, String> giohangservice = (HashMap<Service, String>) session.getAttribute("cartService");

                if (giohang != null || giohangservice != null) {
            %>
        <h1>${ERROR}</h1>
        <table>
            <tr><th>ID</th>
                <th>NAME</th>
                <th>IMAGE</th>
                <th>PRICE</th>
                <th>QUANTITY</th>
                <th>ACTION</th>
            </tr>
            <%
                double total1 = 0;
                if (giohang != null) {
                    for (Cabin it : giohang.keySet()) {
            %>
            <tr><form action="removeCartController">
                <input type="hidden" value="<%= it.getCabinId()%>"  name="txtitItemId">
                <td><%= it.getCabinId()%></td>
                <td><%= it.getTypeCabin()%></td>
                <td><img src=""></td>
                <td><%= it.getPrice()%></td>
                <td><%= giohang.get(it)%></td>

                <td>                  
                    <input type="submit" value="remove" name="action" />

                </td>

            </form>
            </tr>
            <br>

            <%
                        total1 = total1 + it.getPrice();
                    }
                }
            %>
            <tr>

                <% double total2 = 0;
                    if (giohangservice != null) {
                        for (Service se : giohangservice.keySet()) {%>
            <form action="removeCartController">
                <input type="hidden" value="<%= se.getServiceID()%>"  name="txtitItemId">
                <td><%= se.getServiceID()%></td>
                <td><%= se.getName()%></td>
                <td><img src=""></td>
                <td><%= se.getPrice()%></td>
                <td><%= giohangservice.get(se)%></td>

                <td>
                   
                    <input type="submit" value="remove" name="action" />

                </td>
                <br>
            </form>

            </tr>
            <br/>
            <% total2 = total2 + se.getPrice();
                    }
                }

            %>
        </table>
        <%            double total = 0;
            total = total1 + total2;
        %>
        <form action="PaymentController">
        <input type="hidden" value="<%=total%>" name="txttotal">
        <h4>Tong tien thanh toan:  <%=total%> dong </h4>
        <h4>Ngay dat: <%= (new Date()).toString()%></h4>
        <h4>Ngay giao du kien: 7 ngay</h4>
        
            <input type="submit" value="thanh toan">
        </form>

        <%
            } else {
                out.print("gio hang dang trong");
            }
        %>
    </session> 
    <h3>${ERROR}</h3>
    <h3>${id}</h3>
</body> 
</html>
