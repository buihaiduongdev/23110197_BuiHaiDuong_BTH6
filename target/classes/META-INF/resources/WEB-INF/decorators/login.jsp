<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title><sitemesh:write property="title"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    
</head>
<body class="bg-light d-flex justify-content-center align-items-center" style="height:100vh;">
    <div class="card shadow p-4" style="width:400px; border-radius:1rem;">
        <sitemesh:write property="body"/>
    </div>
</body>
</html>
