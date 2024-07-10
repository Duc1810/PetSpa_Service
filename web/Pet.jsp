<%-- 
    Document   : Pet
    Created on : Mar 19, 2024, 7:52:08 PM
    Author     : DELL
--%>

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
        <%@include file="header.jsp"%>
        <div class="box_spa"></div>
        <div class="form_container">
            <div class="content_login">
                <img src="./head.jpg" alt="" />
            </div>
            <div><a href="DividePageController"><i class="fa-solid fa-backward"></i></a></div>
            <div class="cotainer_login ">
                <h1>${requestScope.info}</h1>
                <div class="content_l">
                    <form action="CreatePetController" method="get" class="form_login">
                        <!--                                    <input type="hidden" name="action" value="register"/>-->
                        <h3>Pet</h3>
                        <p>${requestScope.error}</p>
                        <div class="email" >
                            <label for="pname">Pet name</label>
                            <input
                                type="text"
                                id="pname"
                                placeholder="Enter your pet name"
                                name="txtname"
                                value="${requestScope.pname}"
                                required=""
                                />
                        </div>
                        <div class="email">
                            <label for="pbirthday">Pet Birthday</label>
                            <input
                                type="date"
                                id="pbirthday"
                                placeholder="Enter your pet birthday"
                                name="txtbirthday"
                                value="${requestScope.pbirthday}"
                                required=""
                                />
                        </div>
                        <div class="mb-3 email">
                            <label for= "gender" class="">Gender</label>
                            <select id="gender" name="txtgender">
                                <option value="">Choice</option>
                                <option value="Female">Female</option>
                                <option value="Male">Male</option>
                            </select>
                        </div>
                        <div class="email">
                            <label for="pcolor" >Pet Color</label>
                            <input
                                type="text"
                                id="pcolor"
                                placeholder="Enter your pet color"
                                name="txtcolor"
                                value="${requestScope.pcolor}"
                                required=""
                                />
                        </div>
                        <div class="email" >
                            <label for="pheight">Pet Height</label>
                            <input
                                type="text"
                                id="pheight"
                                placeholder="Enter your pet height"
                                name="txtheight"
                                value="${requestScope.pheight}"
                                required=""
                                />
                        </div>
                        <div class="email" >
                            <label for="pwidth">Pet Width</label>
                            <input
                                type="text"
                                id="pwidth"
                                placeholder="Enter your pet height"
                                name="txtwidth"
                                value="${requestScope.pwidth}"
                                required=""
                                />
                        </div>
                        <div class="email" >
                            <label for="pweight">Pet Weight</label>
                            <input
                                type="text"
                                id="pweight"
                                placeholder="Enter your pet weight"
                                name="txtweight"
                                value="${requestScope.pweight}"
                                required=""
                                />
                        </div>
                        <div class="mb-3 email">
                            <label for= "ptype" class="">Pet Type</label>
                            <select id="ptype" name="txtType">
                                <option value="">Choice</option>
                                <option value="1">Dog</option>
                                <option value="2">Cat</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>


                        <div class="submit"><input type="submit" value="CREATE" /></div>
                    </form>
                </div>
            </div>
        </div>
        <script src="./script.js"></script>
    </body>
</html>
