<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="d-flex flex-column min-vh-100">
    <%@ include file="/commons/web/header.jsp" %>
    <%@ include file="/commons/web/topbar.jsp" %>

    <!-- Nội dung chính chiếm toàn bộ khoảng trống -->
    <main class="flex-fill container mt-3">
        <sitemesh:write property="body"/>
    </main>

    <!-- Footer sẽ luôn dính cuối màn hình -->
    <footer class="bg-dark text-white text-center p-2 mt-auto">
        <%@ include file="/commons/web/footer.jsp" %>
    </footer>
</body>
</html>
