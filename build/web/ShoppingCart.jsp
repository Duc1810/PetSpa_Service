<%-- 
    Document   : ShoppingCart
    Created on : Mar 20, 2024, 2:12:45 AM
    Author     : DELL
--%>

<%@page import="java.util.HashMap"%>
<%@page import="dto.Service"%>
<%@page import="dto.Cabin"%>
<%@page import="dto.Cabin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="./style.css">
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
        <link rel="stylesheet"  href="./style1.css">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <style>
            h2 {text-align: center;
                color: #ed7811;
                font-size: 40px}
            </style></head>
        <div class="container">
        <%@include file="header.jsp"%>
        <div class="box_spa"></div>
        <div class="box_spa"></div>
        <h2>Shopping Cart</h2>
        <%
            HashMap<Cabin, String> giohang = (HashMap<Cabin, String>) session.getAttribute("cartCabin");
            HashMap<Service, String> giohangservice = (HashMap<Service, String>) session.getAttribute("cartService");

            if (giohang != null || giohangservice != null) {
        %>
        <div class="cart">

            <div class="products">
                <%
                    double total1 = 0;
                    if (giohang != null) {
                        for (Cabin it : giohang.keySet()) {
                %>


                <div class="product">

                    <img src="<%= it.getImage()%>">

                    <div class="product-info">
                        <form action="removeCartController">
                            <input type="hidden" value="<%= it.getCabinId()%>"  name="txtitItemId">

                            <h3 class="product-name"><%= it.getTypeCabin()%></h3>

                            <h4 class="product-price"><%= it.getPrice()%></h4>

                            <h4 class="product-offer">50%</h4>

                            <p class="product-remove">

                                <i class="fa fa-trash" aria-hidden="true"></i>

                                <input type="submit" value="Remove" name="action"/>

                            </p>
                        </form>

                    </div>

                </div>
                <%
                            total1 = total1 + it.getPrice();
                        }
                    }
                %>

                <% double total2 = 0;
                    if (giohangservice != null) {
                        for (Service se : giohangservice.keySet()) {%>



                <div class="product">

                    <img src="<%= se.getImageURL()%>">

                    <div class="product-info">
                        <form action="removeCartController">
                            <input type="hidden" value="<%= se.getServiceID()%>"  name="txtitItemId">
                            <h3 class="product-name"><%= se.getName()%></h3>

                            <h4 class="product-price"><%= se.getPrice()%></h4>

                            <h4 class="product-offer">40%</h4>



                            <p class="product-remove ">

                                <i class="fa fa-trash" aria-hidden="true"></i>

                                <input type="submit" value="Remove" name="action"/>

                            </p>
                        </form>

                    </div>

                </div>
                <% total2 = total2 + se.getPrice();
                        }
                    }

                %>

            </div>
            <%            double total = 0;
                total = total1 + total2;
            %>



            <div class="cart-total">


                <form action="PaymentController">
                    <p>

                        <span>Total Price</span>

                        <span><%=total%></span>

                    </p>

                    <p>

                        <span>Number of Items</span>

                        <span>2</span>

                    </p>

                    <input type="hidden" value="<%=total%>" name="txttotal">
                    <input type="submit" value="Payment">
                </form>
            </div>
                    

        </div>
        <%            } else {
                out.print("gio hang dang trong");
            }
        %>

    </div>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>
