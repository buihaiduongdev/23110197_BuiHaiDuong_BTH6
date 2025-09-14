<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8"><title>Lưu User</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head><body>
<div class="container mt-4">
  <h2><c:if test="${empty user.id}">Thêm</c:if><c:if test="${not empty user.id}">Sửa</c:if> User</h2>
  <form action="${pageContext.request.contextPath}/admin/users/save" method="post">
    <input type="hidden" name="id" value="${user.id}"/>

    <div class="mb-3"><label class="form-label">Username</label>
      <input class="form-control" name="username" value="${user.username}" required/></div>

    <div class="mb-3"><label class="form-label">Password</label>
      <input class="form-control" type="password" name="password" value="${user.password}" required/></div>

    <div class="mb-3"><label class="form-label">Full name</label>
      <input class="form-control" name="fullName" value="${user.fullName}"/></div>

    <div class="mb-3"><label class="form-label">Email</label>
      <input class="form-control" type="email" name="email" value="${user.email}"/></div>

    <div class="mb-3"><label class="form-label">Role</label>
      <select class="form-select" name="role">
        <option ${user.role=='ADMIN'?'selected':''}>ADMIN</option>
        <option ${user.role=='USER'?'selected':''}>USER</option>
      </select>
    </div>

    <button class="btn btn-success">Lưu</button>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/users">Quay lại</a>
  </form>
</div>
</body></html>
