<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Buyer Dashboard</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
      }

      header {
        background-color: #007bff;
        color: white;
        padding: 10px;
        text-align: center;
      }

      section {
        margin: 20px;
      }
    </style>
  </head>

  <body>
    <header>
      <h1>Welcome, Buyer</h1>
    </header>

    <section>
      <h2>Your Orders</h2>
      <p>View your recent orders here.</p>
      <!-- Add content to display buyer-specific orders -->
    </section>

    <section>
      <h2>Browse Products</h2>
      <p>Explore available products.</p>
      <!-- Add content to display a product catalog for buyers -->
    </section>

    <section>
      <h2>Account Settings</h2>
      <p>Update your account details and preferences.</p>
      <!-- Add content for account management -->
    </section>

    <a href="/logout">Logout</a>
  </body>

  </html>