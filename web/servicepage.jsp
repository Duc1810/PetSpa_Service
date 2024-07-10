<%-- 
    Document   : servicepage
    Created on : Mar 9, 2024, 12:59:49 AM
    Author     : LONG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Services</title>
        <link rel="stylesheet" href="./style1.css" />
    </head>
    <body>
       
            
<!--            <table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
   
  </tbody>
</table>-->
            
             <table class="table table-bordered ">
                <thead>
                    <tr>
                        <th scope="col">Service ID</th>
                        <th scope="col">Service Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Service Status</th>
                        <th scope="col">Image</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sv" items="${requestScope.list}">
                        <tr><form action="MainController">
                           
                        <input type="hidden" value="${sv.serviceID}" name="txtServiceID"/>
                        <td>${sv.serviceID}</td>
                        <td>${sv.name}</td>
                        <td><input type="number" value="${sv.price}" name="txtPrice"/></td>
                        <input type="hidden" value="${sv.status}" name="txtStatus"/>
                        <td >${sv.status}</td>
                        <td class="img_service"><img src="${sv.imageURL}"></td>                       
                        <td>
                            <input type="submit" value="Update" name="action"/>
                            <input type="submit" value="UnabkeS" name="action"/>
                        </td>
                    </form>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>


             
</body>
</html>
