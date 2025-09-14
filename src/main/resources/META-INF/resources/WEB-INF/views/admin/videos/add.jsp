<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8"><title>Lưu Video</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head><body>
<div class="container mt-4">
  <h2><c:if test="${empty video.id}">Thêm</c:if><c:if test="${not empty video.id}">Sửa</c:if> Video</h2>
  <form action="${pageContext.request.contextPath}/admin/videos/save" method="post">
    <input type="hidden" name="id" value="${video.id}"/>

    <div class="mb-3"><label class="form-label">Tiêu đề</label>
      <input class="form-control" name="title" value="${video.title}" required/></div>

    <div class="mb-3"><label class="form-label">Mô tả</label>
      <textarea class="form-control" name="description" rows="3">${video.description}</textarea></div>

    <div class="mb-3"><label class="form-label">URL</label>
      <input class="form-control" name="url" value="${video.url}"/></div>

    <div class="mb-3"><label class="form-label">Danh mục</label>
      <select class="form-select" name="category.id" required>
        <option value="">-- Chọn --</option>
        <c:forEach items="${categories}" var="c">
          <option value="${c.id}" ${video.category != null && video.category.id == c.id ? 'selected' : ''}>${c.categoryName}</option>
        </c:forEach>
      </select>
    </div>

    <button class="btn btn-success">Lưu</button>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/videos">Quay lại</a>
  </form>
</div>
</body></html>
