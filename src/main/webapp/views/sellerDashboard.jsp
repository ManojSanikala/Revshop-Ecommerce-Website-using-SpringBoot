<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% request.setAttribute("pageName", "adminHome" ); %>
      <%@page isELIgnored="false" %>
        <!DOCTYPE html>
        <html>

        <head>
          <meta charset="UTF-8">
          <title>Seller Home</title>
          <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
            integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

          <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"
            integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+"
            crossorigin="anonymous"></script>

          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
            integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
          <style>
            .container {
              margin-top: 50px;
            }

            .card {
              text-align: center;
              border: none;
              border-radius: 15px;
              box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
              transition: transform 0.3s, box-shadow 0.3s;
              cursor: pointer;
              background-color: #f8f9fa;
              margin: 10px;
            }

            .card:hover {
              transform: translateY(-10px);
              box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            }

            .card .fa {
              font-size: 3rem;
              color: #007bff;
              margin-bottom: 15px;
              transition: color 0.3s;
            }

            .card:hover .fa {
              color: #0056b3;
            }

            .card-title {
              font-weight: bold;
              color: #333;
            }

            .card-body {
              padding: 30px 20px;
            }
          </style>
        </head>

        <body>




          <div class="container text-center">
            <h1 class="mb-5">Hello Manoj</h1>
            <div class="row">
              <!-- Add Product Card -->
              <div class="col-md-3">
                <a href="/add">
                  <div class="card">
                    <div class="card-body">
                      <i class="fa fa-plus-square"></i>
                      <h5 class="card-title mt-3">Add Product</h5>
                    </div>
                  </div>
                </a>
              </div>

              <!-- All Products Card -->
              <div class="col-md-3">
                <a href="all_products.jsp">
                  <div class="card">
                    <div class="card-body">
                      <i class="fa fa-list"></i>
                      <h5 class="card-title mt-3">All Products</h5>
                    </div>
                  </div>
                </a>
              </div>

              <!-- Order Card -->
              <div class="col-md-3">
                <a href="orders.jsp">
                  <div class="card">
                    <div class="card-body">
                      <i class="fa fa-shopping-cart"></i>
                      <h5 class="card-title mt-3">All Orders</h5>
                    </div>
                  </div>
                </a>
              </div>

              <!-- View All Users Card -->
              <div class="col-md-3">
                <a href="./view_all_users.jsp">
                  <div class="card">
                    <div class="card-body">
                      <i class="fa fa-users"></i>
                      <h5 class="card-title mt-3">View All Users</h5>
                    </div>
                  </div>
                </a>
              </div>

              <!-- Logout Card -->
              <div class="col-md-3">
                <div class="card" onclick="return confirmLogout();">
                  <div class="card-body">
                    <i class="fa fa-sign-out-alt"></i>
                    <h5 class="card-title mt-3">Logout</h5>
                  </div>
                </div>
                <form id="logoutForm" action="/logout" method="post" style="display:none;">
                  <input type="hidden" name="logout" value="true">
                </form>
              </div>
            </div>
          </div>

          <script>
            function confirmLogout() {
              if (confirm("Are you sure you want to log out?")) {
                document.getElementById("logoutForm").submit();
              }
              return false;
            }
          </script>

        </body>

        </html>