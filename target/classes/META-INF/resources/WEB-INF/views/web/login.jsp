<%@ page contentType="text/html;charset=UTF-8" %>

<style>
    body {
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background: linear-gradient(135deg, #6a11cb 0%, #2575fc 100%);
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .login-card {
        width: 420px;
        background: #fff;
        border-radius: 1rem;
        padding: 2.5rem 2rem;
        box-shadow: 0 8px 25px rgba(0,0,0,0.2);
        animation: fadeIn 0.5s ease-in-out;
    }

    .login-icon {
        width: 80px;
        margin-bottom: 1rem;
        border-radius: 50%;
        background: #f9f9f9;
        padding: 12px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }

    .login-title {
        font-weight: 700;
        font-size: 1.4rem;
        color: #222;
        margin-bottom: 1.5rem;
        letter-spacing: 0.5px;
    }

    .form-label {
        font-weight: 600;
        color: #444;
    }

    .form-control-lg {
        border-radius: 0.6rem;
        border: 1px solid #ddd;
        padding: 0.75rem 1rem;
        font-size: 1rem;
        transition: all 0.3s ease;
    }
    .form-control-lg:focus {
        border-color: #2575fc;
        box-shadow: 0 0 6px rgba(37,117,252,0.4);
    }

    .btn-login {
        background: linear-gradient(135deg, #2575fc, #6a11cb);
        border: none;
        border-radius: 0.6rem;
        color: #fff;
        font-weight: 600;
        letter-spacing: 0.5px;
        transition: all 0.3s ease;
    }
    .btn-login:hover {
        background: linear-gradient(135deg, #1a5fd4, #5a0fbf);
        transform: translateY(-2px);
        box-shadow: 0 6px 14px rgba(0,0,0,0.2);
    }

    .btn-outline-secondary {
        border-radius: 0.6rem;
        font-weight: 600;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-15px); }
        to { opacity: 1; transform: translateY(0); }
    }
</style>


<div class="login-card text-center">
    <img src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png"
         alt="User Icon" class="login-icon"/>
    <h4 class="login-title">Đăng nhập hệ thống</h4>

    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="mb-3 text-start">
            <label for="username" class="form-label">Tên đăng nhập</label>
            <input type="text" id="username" name="username"
                   class="form-control form-control-lg" placeholder="Nhập tên đăng nhập" required/>
        </div>

        <div class="mb-3 text-start">
            <label for="password" class="form-label">Mật khẩu</label>
            <input type="password" id="password" name="password"
                   class="form-control form-control-lg" placeholder="Nhập mật khẩu" required/>
        </div>

        <button type="submit" class="btn btn-login btn-lg w-100 mb-3">Đăng nhập</button>
        <a href="${pageContext.request.contextPath}/" class="btn btn-outline-secondary btn-lg w-100">
            ⬅ Quay về Trang chủ
        </a>
    </form>
</div>
