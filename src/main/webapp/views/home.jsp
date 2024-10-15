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


<form action="/success" method="post">
  <input type="text" name="name" required placeholder="Full Name">
  <input type="email" name="email" required placeholder="Email">
  <input type="text" name="mobile" required placeholder="Mobile Number">
  <input type="password" name="password" required placeholder="Password">
  <input type="password" name="confirm_password" required placeholder="Confirm Password">
  <select name="role">
    <option value="Seller">Seller</option>
    <option value="Buyer">Buyer</option>
  </select>
  <button type="submit">Register</button>
</form>