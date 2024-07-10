<%-- 
    Document   : spa
    Created on : Mar 11, 2024, 3:07:32 PM
    Author     : DELL
--%>

<%@page import="dto.Service"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="./style1.css" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
            crossorigin="anonymous"
            />
         <link rel="stylesheet" href="./style1.css" />
         <style>
             td input {
                 margin-top: 5px;
                width: 90px;
                height: 50px;
                border-radius: 8px;
                margin-bottom: 5px;
                background-color:#e67e22;
                color: #fff;
                

            }
         </style>
    </head>
    <body>

        <%@include file="header.jsp"%>
        <div class="box_spa"></div>
        <div class="box_spa"></div>
        <div class="container_spa">
            <h3>DỊCH VỤ TẮM SPA TRỌN GÓI - CẠO LÔNG CHÓ MÈO 5⭐️</h3>
            <div class="header_spa">
                <div class="left">
                    <div class="image_spa">
                        <img src="./images/8344616.jpg" alt="" />
                    </div>
                </div>
                <div class="right">
                    <h5>⚠️ VÌ SAO NÊN SPA CHO CHÓ MÈO ĐỊNH KỲ VÀ THƯỜNG XUYÊN?</h5>
                    <p>
                        Còn niềm vui và hạnh phúc nào hơn khi những người bạn bốn chân được
                        khoác trên mình bộ lông mềm mượt, thơm lâu và sạch sẽ.
                    </p>
                    <p>
                        Mỗi người bạn nhỏ đều có những thói quen và sở thích khác nhau.
                        Chính vì vậy, Pet Mart luôn có những sự lựa chọn dịch vụ spa cho chó
                        mèo phù hợp nhất với những dòng sản phẩm sữa tắm trị liệu đảm bảo an
                        toàn cho sức khỏe của thú cưng.
                    </p>
                    <p>
                        Với tình yêu thương với thú cưng vô bờ bến, chúng tôi chắc chắn sẽ
                        mang tới cho thú cưng và khách hàng những trải nghiệm thoải mái nhất
                        tại Pet Mart.
                    </p>
                </div>
            </div>
            
                <div class="media">
                    <img class="mr-3" src="./images/ig2.jpg" alt="Generic placeholder image">
                    <div class="media-body">
                        <h1 class="mt-0">Dog</h1>
                        <p>Chó có các giác quan nhạy bén như thị giác, thính giác và khứu giác. 
                            Chúng có mắt to, tai dựng và mũi nhạy, giúp theo dấu con mồi thành công. 
                            Chân dài giúp chúng chạy nhanh khi săn đuổi. Bàn chân đặc trưng với năm ngón ở chân trước và bốn ngón ở chân sau,
                            đôi khi có móng thứ năm gọi là móng huyền. 
                            Chó rừng thường có đuôi dài, lông dày, màu đồng màu và không có đốm sọc.</p>
                    </div>
                </div>
            <div class="media">
                    <img class="mr-3" src="./images/ig1.jpg" alt="Generic placeholder image">
                    <div class="media-body">
                        <h1 class="mt-0">Cat</h1>
                        <p>Mèo thông thường nặng từ 2,5 đến 7 kg, nhưng Maine Coon có thể vượt quá 30,4 kg. 
                            Việc nuôi quá nhiều có thể gây hại cho sức khỏe, dẫn đến tiểu đường và các vấn đề khác.
                            Mèo nuôi trong nhà thường sống từ 14 đến 25 năm. Triệt sản kéo dài tuổi thọ và giảm nguy cơ mắc bệnh ung thư. 
                            Mèo có khả năng chạy nước rút và nhảy cao, nhưng không có xương đòn cứng, cho phép chúng đi qua các lỗ nhỏ.</p>
                    </div>
                </div>
            <h1>${requestScope.info}</h1>
            <div class="service">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">Service ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Price</th>
                            <th scope="col">Image</th>
                            <th scope="col">button</th>
                        </tr>
                    </thead>
                    <tbody>
                       <%
                           int count =0;
                ArrayList<Service> list = (ArrayList<Service>) request.getAttribute("ListService");
                if (list != null && list.size() > 0) {
                    for (Service it : list) {
                        if (it.getStatus()>0) {

            %>
          
                            
                            
                    
                        <tr>
                    <form action="ChoicePetCabinController"> 
                            <input type="hidden" value="<%= it.getServiceID() %>" name="txtId"/>
                            <th scope="row"><%= ++count %></th>
                            <td><%= it.getName() %></td>
                            <td><%= it.getPrice() %></td>
                            <td class="img_service"><img src="<%= it.getImageURL() %>"></td>
                            <td><input type="submit" value="choice" name="action"/></td>
                            </form>
                        </tr>
                    
                       <% }
                    }
                }
            %>
                       
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
