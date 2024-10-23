<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <title>Buyers List</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
      <style>
        body {
          background-color: #f8f9fa;
          padding: 20px;
        }

        .table-container {
          margin-top: 20px;
          background-color: white;
          padding: 20px;
          border-radius: 10px;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
      </style>
    </head>

    <body>
      <div class="container">
        <h1 class="mt-5">List of Buyers</h1>
        <div class="table-container">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="buyer" items="${buyers}">
                <tr>
                  <td>${buyer.buyer_id}</td>
                  <td>${buyer.name}</td>
                  <td>${buyer.email}</td>
                  <td>${buyer.mobile}</td>
                </tr>
              </c:forEach>
              <c:if test="${empty buyers}">
                <tr>
                  <td colspan="4" class="text-center">No Buyers Available</td>
                </tr>
              </c:if>
            </tbody>
          </table>
        </div>
      </div>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>

    </html>