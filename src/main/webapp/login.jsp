<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" /><style>
    body{
        background-image: url("hinh/TP.jpg");
        background-size: cover;
    }
    form{
        height: 520px;
        width: 400px;
        background-color: rgba(255,255,255,0.130);
        position: absolute;
        transform: translate(-50%, -50%);
        top: 50%;
        left: 50%;
        border-radius: 10px;
        backdrop-filter: blur(10px);
        border: 2px solid rgba(255,255,255,0.1);
        box-shadow: 0 0 40px rgba(8,7,16,0.6);
        padding: 50px 35px;

    }
    form h3{
        color:#23a2f6;
        font-size: 32px;
        font-weight: 500;
        line-height: 42px;
        text-align: center;
    }
    .input-bx{
        position: relative;
        width: 300px;
    }
    .input-bx input{
        display: block;
        height: 30px;
        width: 100%;
        background-color: rgba(255,255,255,0.07);
        border-radius: 3px;
        padding: 0 10px;
        margin-top: 30px;
        font-size: 14px;
        font-weight: 300;
    }
    .input-bx span{
        position: absolute;
        left: 0;
        padding: 10px;
        font-size: 1rem;
        color: Black;
        text-transform: uppercase;
        pointer-events: none;
        transition: 0.6s;
    }
    .input-bx input:valid ~ span,
    .input-bx input:focus ~ span{
        color: #23a2f6;
        transform: translateX(10px) translateY(-40px);
        font-size: 0.65rem;
        font-weight: 600;
        padding: 0 10px;
        background: #fff;
        letter-spacing: 0.1rem;
    }
    .input-bx input:valid,
    .input-bx input:focus{
        color: #23a2f6;
        border: 2px solid #1845ad;
    }
    button {
        margin-top: 30px;
        margin-left: auto;
        margin-right: auto;
        width: 100px;
        background-color: #ffffff;
        color: #080710;
        padding: 10px 0;
        font-size: 20px;
        font-weight: 600;
        border-radius: 5px;
        cursor: pointer;
    }
    .social {
        justify-content: space-between;
    }
    .social {
        margin-top: 70px;
        display: flex;
        justify-content: space-between;
    }
    .social div {
        width: 100px;
        border-radius: 5px;
        padding: 5px 10px 10px 5px;
        color: white;
        text-align: center;
    }
    .social div:hover {
        background-color: rgba(255, 255, 255, 0.47);
    }

</style>
</head>
<body>
<form action="/login" method="post">
    <h3>Login Here</h3>
    <div class="input-bx">
        <input type="text" name="username" required="required"/>
        <span>Username</span>
    </div>
    <div class="input-bx">
        <input type="password" name="password" required="required">
        <span>Password</span>
    </div>
    <button type="submit">Login</button>
    <p class="link" style="font-size: 25px;">Don't have an account<br>
        <a href="/register">Sign up </a> here</a>
    </p>
    </div>
</form>
</body>
</html>