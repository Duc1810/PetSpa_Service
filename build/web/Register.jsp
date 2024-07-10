<%-- 
    Document   : Register
    Created on : Mar 6, 2024, 2:27:16 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <meta charset="UTF-8"/>
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
            <div class="cotainer_login ">
                <div class="content_l">
                    <form action="RegisterController" class="form_login">
                        <!--                                    <input type="hidden" name="action" value="register"/>-->
                        <h3>Sign in</h3>
                        <p>${requestScope.error}</p>
                        <div class="email" >
                            <label for="fname">First name</label>
                            <input
                                type="text"
                                id="fname"
                                placeholder="Enter your firstname"
                                name="txtfname"
                                value="${requestScope.fname}"
                                required=""
                                />
                        </div>
                        <div class="email">
                            <label for="lname">Last name</label>
                            <input
                                type="text"
                                id="lname"
                                placeholder="Enter your lastname"
                                name="txtlname"
                                value="${requestScope.lname}"
                                required=""
                                />
                        </div>
                        <div class="email">
                            <label for="lname">User Name</label>
                            <input
                                type="text"
                                id="lname"
                                placeholder="Enter your username"
                                name="txtlusername"
                                value="${requestScope.username}"
                                required=""
                                />
                        </div>
                        <div class="email">
                            <label for="phone">Phone</label>
                            <input
                                type="number"
                                id="phone"
                                placeholder="Enter your phone"
                                name="txtphone"
                                value="${requestScope.phone}"
                                required=""
                                />
                        </div>
                        <div class="email">
                            <label for="email">Email</label>
                            <input
                                type="text"
                                id="email"
                                placeholder="Enter your email"
                                name="txtemail"
                                value="${requestScope.email}"
                                required=""
                                />
                        </div>
                        <div class="mb-3 email">
                            <label for= "gender" class="">Gender</label>
                            <select id="gender" name="txtgender">
                                <option value="">Choice</option>
                                <option value="Female">Female</option>
                                <option value="Male">Male</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>
                        <div class="email">
                            <label for="password" >Password</label>
                            <input
                                type="password"
                                id="password"
                                placeholder="Enter your password"
                                name="txtpassword"
                                value="${requestScope.password}"
                                required=""
                                />
                        </div>
                        <div class="email">
                            <label for="c_password">Confirmed</label>
                            <input
                                type="password"
                                id="c_password"
                                placeholder="Enter confirmed password"
                                name="txtc_password"
                                required=""
                                />
                        </div>
                        <div class="email">
                            <label for="address">Address</label>
                            <input
                                type="text"
                                id="address"
                                placeholder="Enter your address"
                                name="txtaddress"
                                value="${requestScope.address}"
                                required=""
                                />
                        </div>
                        <div class="submit"><input type="submit" value="Signup Now" /></div>
                        <div class="login_signup">
                            Already have an account? <a href="Login.jsp" >Login</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script src="./script.js"></script>
    </body>
</html>

</body>
</html>
