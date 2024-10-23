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
          display: flex;
          flex-direction: column;
          min-height: 100vh;
        }

        .form-container {
          max-width: 400px;
          margin: 20px auto;
          padding: 15px;
          background-color: white;
          border-radius: 5px;
          box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="email"],
        input[type="password"],
        select {
          width: 100%;
          padding: 10px;
          margin: 10px 0;
          border: 1px solid #ccc;
          border-radius: 5px;
        }

        button {
          width: 100%;
          padding: 10px;
          background-color: #28a745;
          color: white;
          border: none;
          border-radius: 5px;
          cursor: pointer;
        }

        button:hover {
          background-color: #218838;
        }

        .navbar-custom {
          background-color: #f57c20;
        }

        .form-links {
          text-align: center;
          margin-top: 10px;
        }

        .footer {
          margin-top: auto;
        }
      </style>
      <title>Login - RevShop</title>
    </head>

    <body>

      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-dark navbar-custom">
        <div class="container-fluid p-3">
          <a class="navbar-brand" href="index.jsp">
            <h3>RevShop</h3>
          </a>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/register">Register</a>
            </li>
          </ul>
        </div>
      </nav>

      <!-- Display registration success message if coming from registration page -->
      <c:if test="${param.register eq 'true'}">
        <div class="alert alert-success text-center" role="alert">
          Registration complete, please login here.
        </div>
      </c:if>

      <!-- Login Form -->
      <div class="form-container">
        <center>
          <h2>Login</h2>
        </center>
        <form action="/loginpage" method="post">
          <input type="email" name="email" required placeholder="Email">
          <input type="password" name="password" required placeholder="Password">
          <select name="role" required>
            <option value="Buyer">Buyer</option>
            <option value="Seller">Seller</option>
          </select>
          <button type="submit">Login</button>

          <div class="form-links">
            <a href="/forgot-password">Forgot Password?</a>
            <br>
            <a href="/register">Don't have an account? Register</a>
          </div>
        </form>
      </div>

      <!-- Footer -->
      <footer class="footer bg-dark text-light text-center py-3">
        <p>© 2024 RevShop. All Rights Reserved.</p>
      </footer>

      <!-- Bootstrap JS and dependencies -->
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

    </html>