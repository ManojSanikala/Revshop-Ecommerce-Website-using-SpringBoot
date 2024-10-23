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
          display: flex;
          flex-direction: column;
          min-height: 100vh;
          /* Ensures footer is at the bottom */
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
        input[type="text"],
        input[type="number"],
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
          /* Tangerine color */
        }

        .welcome-message {
          text-align: center;
        }

        .form-links {
          text-align: center;
          margin-top: 10px;
        }

        .form-links a {
          color: #007bff;
          text-decoration: none;
        }

        .form-links a:hover {
          text-decoration: underline;
        }

        /* Fix the footer to the bottom */
        .footer {
          margin-top: auto;
          /* Push footer to the bottom */
        }
      </style>
      <title>Register - RevShop</title>
    </head>

    <body>

      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-dark navbar-custom">
        <div class="container-fluid p-3">
          <a class="navbar-brand" href="/">
            <h3>RevShop</h3>
          </a>
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/login">Login</a>
            </li>
          </ul>
        </div>
      </nav>

      <!-- Registration Form -->
      <div class="form-container">
        <center>
          <h2>Register</h2>
        </center>
        <form action="/save" method="post">
          <input type="text" name="name" required placeholder="Full Name"
            value="${seller.name != null ? seller.name : buyer.name}">
          <input type="email" name="email" required placeholder="Email"
            value="${seller.email != null ? seller.email : buyer.email}">
          <input type="text" name="mobile" required placeholder="Mobile Number"
            value="${seller.mobile != null ? seller.mobile : buyer.mobile}">
          <input type="password" name="password" required placeholder="Password">
          <input type="password" name="confirm_password" required placeholder="Confirm Password">
          <select name="role" required>
            <option value="Seller">Seller</option>
            <option value="Buyer">Buyer</option>
          </select>
          <button type="submit">Register</button>

          <!-- Additional Links -->
          <div class="form-links">

            <a href="/login">Already have an account? Login</a>
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