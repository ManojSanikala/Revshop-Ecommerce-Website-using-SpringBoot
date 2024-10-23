<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page isELIgnored="false" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
      <style>
        body {
          background-color: #d7d9d7;
          /* Aluminium color */
        }

        .custom-card {
          width: 100%;
          margin: 10px;
          min-height: 350px;
          border-radius: 15px;
          /* Curved edges for cards */
        }

        .product-image {
          width: 100%;
          height: 200px;
          object-fit: contain;
          background-color: #f8f9fa;
          border-radius: 15px 15px 0 0;
          /* Curved edges on top */
        }

        .bg-custom {
          background-color: #f57c20;
          /* Tangerine color for the navbar */
        }

        .welcome-message {
          text-align: center;
        }

        /* Footer styling */
        .footer {
          background-color: #343a40;
          color: #ffffff;
          text-align: center;
          padding: 10px 0;
          margin-top: 20px;
          /* Space between content and footer */
          border-radius: 0 0 15px 15px;
          /* Curved edges for footer */
        }
      </style>
      <title>RevShop</title>
    </head>

    <body>

      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-dark bg-custom">
        <div class="container-fluid p-3">
          <a class="navbar-brand" href="index.jsp">
            <h3>RevShop</h3>
          </a>
          <c:if test="${not empty userRole && userRole == 'Buyer'}">
            <form class="form-inline my-2 my-lg-0 d-flex justify-content-center" action="search.jsp" method="post">
              <input class="form-control mr-sm-2" type="search" name="ch" placeholder="Search" aria-label="Search">
              <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
            </form>
          </c:if>

          <div class="d-flex justify-content-end">
            <c:if test="${empty userRole}">
              <a href="/login" class="btn btn-success ml-2">Login</a>
              <a href="/register" class="btn btn-primary ml-2">Register</a>
            </c:if>

            <c:if test="${not empty userRole && userRole == 'Buyer'}">
              <a href="cart.jsp" class="btn ml-2">
                <i class="fas fa-shopping-cart"></i>
              </a>
              <a href="myOrders.jsp" class="btn btn-secondary ml-2">
                <i class="fas fa-box"></i>
              </a>
              <a href="myAccount.jsp" class="btn btn-success ml-2">
                <i class="fas fa-user"></i>
              </a>
              <a href="wishlist.jsp" class="btn btn-info ml-2">
                <i class="fas fa-heart"></i>
              </a>
              <a href="logout" class="btn btn-danger ml-2" onclick="confirmLogout()">
                <i class="fas fa-sign-out-alt"></i>
              </a>
            </c:if>
          </div>
        </div>

        <div class="collapse navbar-collapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                Products
              </a>
              <div class="dropdown-menu">
                <a class="dropdown-item" href="all_electronicproduct.jsp">Electronics</a>
                <a class="dropdown-item" href="all_home.jsp">Home Appliances</a>
                <a class="dropdown-item" href="all_fashion.jsp">Fashion</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>

      <script>
        function confirmLogout() {
          if (confirm("Are you sure you want to log out?")) {
            window.location.href = 'logout'; // Modify this to your logout URL if necessary
          }
        }
      </script>

      <!-- Page Content -->
      <div class="container mt-4">
        <h2 class="welcome-message">Welcome to RevShop!</h2>

        <c:if test="${empty products}">
          <div class="alert alert-warning" role="alert">
            No products available at this time.
          </div>
        </c:if>

        <div class="card-columns">
          <c:forEach var="product" items="${products}">
            <div class="card custom-card">
              <img src="<c:url value='/images/${product.product_image}'/>" alt="${product.product_name}"
                class="product-image">
              <div class="card-body">
                <h5 class="card-title">${product.product_name}</h5>
                <p class="card-text">${product.product_description}</p>
                <c:if test="${product.product_stock == 0}">
                  <span class="text-danger">Out of Stock</span>
                </c:if>
                <c:if test="${product.product_stock > 0}">
                  <a href="cart.jsp?productId=${product.product_id}" class="btn btn-primary">Cart Now</a>
                  <a href="productDetails.jsp?productId=${product.product_id}" class="btn btn-secondary">View
                    Details</a>
                </c:if>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>

      <!-- Footer -->
      <footer class="footer">
        <p>© 2024 RevShop. All Rights Reserved.</p>
      </footer>

      <!-- Bootstrap JS and dependencies -->
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

    </html>