<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container mt-4">
		<h2>Danh sách Category</h2>
		<a href="${pageContext.request.contextPath}/admin/categories/add"
			class="btn btn-primary mb-3">Thêm mới</a>

		<form
			action="${pageContext.request.contextPath}/admin/categories/search"
			method="get" class="mb-3">
			<input class="form-control d-inline-block" style="width: 300px"
				name="keyword" placeholder="Tìm kiếm..." />
			<button class="btn btn-secondary">Search</button>
		</form>

		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên</th>
					<th>Ảnh</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="c">
					<tr>
						<td>${c.id}</td>
						<td>${c.categoryName}</td>
						<td><img src="${c.images}" width="80" /></td>
						<td><a class="btn btn-warning btn-sm"
							href="${pageContext.request.contextPath}/admin/categories/edit/${c.id}">Sửa</a>
							<a class="btn btn-danger btn-sm"
							href="${pageContext.request.contextPath}/admin/categories/delete/${c.id}"
							onclick="return confirm('Xoá?')">Xoá</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
