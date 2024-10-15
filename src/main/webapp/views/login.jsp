<style>
  form {
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
</style>
<form action="Login" method="post">
  <center>
    <h2>Login</h2>
  </center>
  <input type="email" name="email" required placeholder="Email">
  <input type="password" name="password" required placeholder="Password">
  <select name="role">
    <option value="Buyer">Buyer</option>
    <option value="Seller">Seller</option>
  </select>
  <button type="submit">Login</button>
</form>