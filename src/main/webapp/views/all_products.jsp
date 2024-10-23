<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Your Products</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
      <style>
        body {
          background-color: #f8f9fa;
          padding: 20px;
        }

        .container {
          margin-top: 40px;
        }

        .heading {
          text-align: center;
          margin-bottom: 40px;
          color: #007bff;
        }

        .table-container {
          background-color: white;
          padding: 20px;
          border-radius: 10px;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        thead {
          background-color: #e9ecef;
        }

        th {
          text-align: center;
        }

        td {
          text-align: center;
        }
      </style>
    </head>

    <body>

      <!-- Redirect to login if user not logged in -->
      <c:if test="${empty sessionScope.loggedInUser}">
        <c:redirect url="/login" />
      </c:if>



      <div class="container">
        <!-- Heading -->
        <h1 class="heading">All Products</h1>

        <!-- Table -->
        <div class="table-container">
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">ID</th>
                <th scope="col">Image</th>
                <th scope="col">Product Name</th>
                <th scope="col">Description</th>
                <th scope="col">Price</th>
                <th scope="col">Category</th>
                <th scope="col">Stock</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="product" items="${products}">
                <tr>
                  <td>${product.product_id}</td>
                  <td>
                    <img src="/images/${product.product_image}" style="width: 50px; height: 50px;" alt="No Image">
                  </td>
                  <td>${product.product_name}</td>
                  <td>${product.product_description}</td>
                  <td>${product.product_price}</td>
                  <td>${product.product_category}</td>
                  <td>${product.product_stock}</td>
                  <td>
                    <a href="/edit/products?id=${product.product_id}" class="btn btn-sm btn-primary">Edit</a>
                    <form action="/delete/products" method="post" style="display:inline;">
                      <input type="hidden" name="product_id" value="${product.product_id}" />
                      <button type="submit" class="btn btn-sm btn-danger">Delete</button>
                    </form>
                  </td>
                </tr>
              </c:forEach>
              <c:if test="${empty products}">
                <tr>
                  <td colspan="8" class="text-center">No Products Available</td>
                </tr>
              </c:if>
            </tbody>
          </table>
        </div>
      </div>

      <!-- Bootstrap JS (including Popper.js) -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>

    </html>