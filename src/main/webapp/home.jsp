<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Home Page</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }

        .main{
            width: 100%;
            background: linear-gradient(to top, rgba(0,0,0,0.5)50%,rgba(0,0,0,0.5)50%), url("hinh/TP.jpg");
            background-position: center;
            background-size: cover;
            height: 100vh;
        }

        .navbar{
            width: 1200px;
            height: 75px;
            margin: auto;
        }

        .icon{
            width: 200px;
            float: left;
            height: 70px;
        }

        .logo{
            color: #ff7200;
            font-size: 35px;
            font-family: Arial;
            padding-left: 20px;
            float: left;
            padding-top: 10px;
            margin-top: 5px
        }

        .menu{
            width: 400px;
            float: left;
            height: 70px;
        }

        ul{
            float: left;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        ul li{
            list-style: none;
            margin-left: 62px;
            margin-top: 27px;
            font-size: 14px;
        }

        ul li a{
            text-decoration: none;
            color: #fff;
            font-family: Arial;
            font-weight: bold;
            transition: 0.4s ease-in-out;
        }

        ul li a:hover{
            color: #ff7200;
        }

        .search{
            width: 330px;
            float: left;
            margin-left: 270px;
        }

        .srch{
            font-family: 'Times New Roman';
            width: 200px;
            height: 40px;
            background: transparent;
            border: 1px solid #ff7200;
            margin-top: 13px;
            color: #fff;
            border-right: none;
            font-size: 16px;
            float: left;
            padding: 10px;
            border-bottom-left-radius: 5px;
            border-top-left-radius: 5px;
        }

        .btn{
            width: 100px;
            height: 40px;
            background: #ff7200;
            border: 2px solid #ff7200;
            margin-top: 13px;
            color: #fff;
            font-size: 15px;
            border-bottom-right-radius: 5px;
            border-bottom-right-radius: 5px;
            transition: 0.2s ease;
            cursor: pointer;
        }
        .btn:hover{
            color: #000;
        }

        .btn:focus{
            outline: none;
        }

        .srch:focus{
            outline: none;
        }

        .content{
            width: 1200px;
            height: auto;
            margin: auto;
            color: #fff;
            position: relative;
        }

        .content .par{
            padding-left: 20px;
            padding-bottom: 25px;
            font-family: Arial;
            letter-spacing: 1.2px;
            line-height: 30px;
        }

        .content h1{
            font-family: 'Times New Roman';
            font-size: 50px;
            padding-left: 20px;
            margin-top: 9%;
            letter-spacing: 2px;
        }

        .content .cn{
            width: 160px;
            height: 40px;
            background: #ff7200;
            border: none;
            margin-bottom: 10px;
            margin-left: 20px;
            font-size: 18px;
            border-radius: 10px;
            cursor: pointer;
            transition: .4s ease;

        }

        .content .cn a{
            text-decoration: none;
            color: #000;
            transition: .3s ease;
        }

        .cn:hover{
            background-color: #fff;
        }

        .content span{
            color: #ff7200;
            font-size: 65px
        }

        .

        ::placeholder{
            color: #fff;
            font-family: Arial;
        }

        .btnn{
            width: 240px;
            height: 40px;
            background: #ff7200;
            border: none;
            margin-top: 30px;
            font-size: 18px;
            border-radius: 10px;
            cursor: pointer;
            color: #fff;
            transition: 0.4s ease;
        }
        .btnn:hover{
            background: #fff;
            color: #ff7200;
        }
        .btnn a{
            text-decoration: none;
            color: #000;
            font-weight: bold;
        }
        .liw{
            padding-top: 15px;
            padding-bottom: 10px;
            text-align: center;
        }
        .icons a{
            text-decoration: none;
            color: #fff;
        }
        .icons ion-icon{
            color: #fff;
            font-size: 30px;
            padding-left: 14px;
            padding-top: 5px;
            transition: 0.3s ease;
        }
        .icons ion-icon:hover{
            color: #ff7200;
        }
        .menu ul .dropdown {
            display: none;
        }

        .menu ul li.user-dropdown:hover .dropdown {
            display: block;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/home" method="post">
<div class="main">
    <div class="navbar">
        <div class="icon">
            <h2 class="logo">Nhà xin</h2>
        </div>

        <div class="menu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/home">HOME</a></li>
                <li><a href="department_list.jsp">SERVICE</a></li>
                <% if (session.getAttribute("user") == null) { %>
                <li><a href="${pageContext.request.contextPath}/login">LOGIN</a></li>
                <% } else { %>
                <li class="user-dropdown">
                    <a>Welcome ${user.userName}</a>
                    <ul class="dropdown">
                        <li><a href="/user?action=view&id=${user.getiD()}">User</a></li>
                        <li><a href="/department_list.jsp">Add</a></li>
                        <li><a href="/user-departments">View</a></li>
                        <% if (session.getAttribute("user") == null) { %>
                        <li><a href="${pageContext.request.contextPath}/login">LOGIN</a></li>
                        <% } else { %>
                                <li><a href="#" onclick="logoutUser()">Logout</a></li>
                            </ul>
                        </li>
                        <% } %>
                    </ul>
                </li>
                <% } %>

<%--            <c:if--%>
<%--            <li>--%>

            </li>

            </ul>
        </div>

        <div class="search">
            <input class="srch" type="search" name="" placeholder="Type To text">
            <a href="#"> <button class="btn">Search</button></a>
        </div>

    </div>
    <div class="content">
        <h1>Web<br><span>Nhà xin</span></h1>
        <p class="par">Tìm một ngôi nhà là một cuộc hành trình kỳ thú. Đó không chỉ là việc tìm kiếm một nơi ở, mà còn
            <br>là tìm một không gian thật sự thuộc về mình. Ngôi nhà hoàn hảo sẽ là nơi chúng ta tạo dựng ký ức,
            <br>xây dựng gia đình và chia sẻ những khoảnh khắc đáng nhớ. Hãy mở lòng và đón nhận cuộc phiêu lưu
            <br>tìm kiếm nhà của bạn - một nơi mà bạn có thể gọi là tổ ấm và xây dựng tương lai.</p>

        <button class="cn"><a href="#">THAM GIA VỚI CHÚNG TÔI</a></button>
    </div>
</div>
</form>
<script>
    function logoutUser() {
        var xhr = new XMLHttpRequest();
        xhr.open("DELETE", "${pageContext.request.contextPath}/login", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onload = function () {
            if (xhr.status === 200) {
                window.location.href = "${pageContext.request.contextPath}/home.jsp";
            } else {
            }
        };
        xhr.send();
    }
</script>

</body>
</html>
