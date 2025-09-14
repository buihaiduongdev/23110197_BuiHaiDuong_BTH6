<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8"><title>Tìm Video</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head><body>
<div class="container mt-4">
  <h2>Kết quả tìm Video</h2>
  <form action="${pageContext.request.contextPath}/admin/videos/search" method="get" class="mb-3">
    <input class="form-control d-inline-block" style="width:300px" name="keyword" value="${param.keyword}" placeholder="Tiêu đề..."/>
    <button class="btn btn-primary">Search</button>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/videos">Tất cả</a>
  </form>

  <table class="table table-bordered table-striped">
    <thead><tr><th>ID</th><th>Tiêu đề</th><th>Danh mục</th><th>URL</th><th>Hành động</th></tr></thead>
    <tbody>
      <c:forEach items="${videos}" var="v">
        <tr>
          <td>${v.id}</td>
          <td>${v.title}</td>
          <td><c:out value="${v.category != null ? v.category.categoryName : ''}"/></td>
          <td><a href="${v.url}" target="_blank">Link</a></td>
          <td>
            <a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/admin/videos/edit/${v.id}">Sửa</a>
            <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/admin/videos/delete/${v.id}">Xoá</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body></html>
