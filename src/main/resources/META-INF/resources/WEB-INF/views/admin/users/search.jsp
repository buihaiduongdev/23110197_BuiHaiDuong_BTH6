<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8"><title>Tìm User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head><body>
<div class="container mt-4">
  <h2>Kết quả tìm User</h2>
  <form action="${pageContext.request.contextPath}/admin/users/search" method="get" class="mb-3">
    <input class="form-control d-inline-block" style="width:300px" name="keyword" value="${param.keyword}" placeholder="Username..."/>
    <button class="btn btn-primary">Search</button>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/users">Tất cả</a>
  </form>

  <table class="table table-bordered table-striped">
    <thead><tr><th>ID</th><th>Username</th><th>Full name</th><th>Email</th><th>Role</th><th>Hành động</th></tr></thead>
    <tbody>
      <c:forEach items="${users}" var="u">
        <tr>
          <td>${u.id}</td><td>${u.username}</td><td>${u.fullName}</td><td>${u.email}</td><td>${u.role}</td>
          <td>
            <a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/admin/users/edit/${u.id}">Sửa</a>
            <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/admin/users/delete/${u.id}">Xoá</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body></html>
