<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head>
<meta charset="UTF-8"><title>Tìm Category</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head><body>
<div class="container mt-4">
  <h2>Kết quả tìm kiếm</h2>
  <form action="${pageContext.request.contextPath}/admin/categories/search" method="get" class="mb-3">
    <input class="form-control d-inline-block" style="width:300px" name="keyword" value="${param.keyword}" placeholder="Từ khoá..."/>
    <button class="btn btn-primary">Search</button>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/admin/categories">Tất cả</a>
  </form>

  <table class="table table-bordered table-striped">
    <thead><tr><th>ID</th><th>Tên</th><th>Ảnh</th><th>Hành động</th></tr></thead>
    <tbody>
      <c:forEach items="${categories}" var="c">
        <tr>
          <td>${c.id}</td>
          <td>${c.categoryName}</td>
          <td><img src="${c.images}" width="80"/></td>
          <td>
            <a class="btn btn-warning btn-sm" href="${pageContext.request.contextPath}/admin/categories/edit/${c.id}">Sửa</a>
            <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/admin/categories/delete/${c.id}">Xoá</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body></html>
