<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8"><title>Lưu Category</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head><body>
<div class="container mt-4">
  <h2><c:if test="${empty category.id}">Thêm</c:if><c:if test="${not empty category.id}">Sửa</c:if> Category</h2>
  <form action="${pageContext.request.contextPath}/admin/categories/save" method="post">
    <input type="hidden" name="id" value="${category.id}"/>

    <div class="mb-3">
      <label class="form-label">Tên</label>
      <input class="form-control" name="categoryName" value="${category.categoryName}" required/>
    </div>

    <div class="mb-3">
      <label class="form-label">Ảnh (URL)</label>
      <input class="form-control" name="images" value="${category.images}"/>
    </div>

    <button class="btn btn-success">Lưu</button>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/categories">Quay lại</a>
  </form>
</div>
</body></html>
