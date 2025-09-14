<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="d-flex">
    <%@ include file="/commons/admin/sidebar.jsp" %>

    <!-- Cột bên phải: topbar + body + footer xếp dọc -->
    <div class="d-flex flex-column flex-grow-1 min-vh-100">
        <%@ include file="/commons/admin/topbar.jsp" %>

        <!-- Nội dung chính chiếm trọn khoảng trống còn lại -->
        <main class="flex-fill container mt-3">
            <sitemesh:write property="body"/>
        </main>

        <!-- Footer sẽ luôn dính đáy -->
        <footer class="bg-dark text-white text-center p-2 mt-auto">
            <%@ include file="/commons/admin/footer.jsp" %>
        </footer>
    </div>
</body>
</html>
