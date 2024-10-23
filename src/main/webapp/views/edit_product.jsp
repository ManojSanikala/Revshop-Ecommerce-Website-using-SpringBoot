<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Edit Product</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>

    <body>
      <div class="container">
        <h1 class="mt-5">Edit Product</h1>
        <form action="/edit/products" method="post">
          <input type="hidden" name="product_id" value="${product.product_id}" />
          <div class="row mb-3">
            <div class="col-md-6">
              <label for="productName" class="form-label">Product Name</label>
              <input type="text" class="form-control" id="productName" name="product_name"
                value="${product.product_name}" required>
            </div>

          </div>
          <div class="mb-3">
            <label for="productDescription" class="form-label">Description</label>
            <textarea class="form-control" id="productDescription" name="product_description"
              required>${product.product_description}</textarea>
          </div>
          <div class="mb-3">
            <label for="productPrice" class="form-label">Price</label>
            <input type="number" class="form-control" id="productPrice" name="product_price"
              value="${product.product_price}" required>
          </div>
          <div class="mb-3">
            <label for="productCategory" class="form-label">Category</label>
            <input type="text" class="form-control" id="productCategory" name="product_category"
              value="${product.product_category}" required>
          </div>
          <div class="mb-3">
            <label for="productStock" class="form-label">Stock</label>
            <input type="number" class="form-control" id="productStock" name="product_stock"
              value="${product.product_stock}" required>
          </div>
          <button type="submit" class="btn btn-primary">Update Product</button>
          <a href="/products" class="btn btn-secondary">Cancel</a>
        </form>
      </div>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>

    </html>