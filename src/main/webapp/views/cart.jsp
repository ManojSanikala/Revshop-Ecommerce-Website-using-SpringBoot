<%@page import="com.revshop.model.Cart" %>
  <%@page import="com.revshop.model.Buyer" %>
    <%@page import="java.util.List" %>
      <%@page import="com.revshop.model.Product" %>
        <%@page import="org.springframework.web.servlet.ModelAndView" %>
          <%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

              <!DOCTYPE html>
              <html>

              <head>
                <meta charset="UTF-8">
                <title>Your Cart</title>
                <style>
                  /* Add your existing styles here */
                  .container {
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    margin: 20px;
                  }

                  .cart {
                    width: 60%;
                    padding: 20px;
                    box-sizing: border-box;
                    margin-bottom: 20px;
                    border: 1px solid #ccc;
                    border-radius: 10px;
                    background-color: #f9f9f9;
                  }

                  h2 {
                    text-align: center;
                    color: #333;
                  }

                  .table-responsive {
                    width: 100%;
                    overflow-x: auto;
                  }

                  table {
                    width: 100%;
                    border-collapse: collapse;
                  }

                  th,
                  td {
                    padding: 10px;
                    text-align: center;
                  }

                  th {
                    background-color: #f2f2f2;
                  }

                  .remove-btn {
                    color: white;
                    background-color: red;
                    border: none;
                    padding: 5px 10px;
                    cursor: pointer;
                    border-radius: 5px;
                  }

                  .quantity-btn {
                    border: none;
                    padding: 5px 10px;
                    cursor: pointer;
                    border-radius: 5px;
                  }

                  .quantity-btn.minus {
                    background-color: red;
                    color: white;
                  }

                  .quantity-btn.plus {
                    background-color: green;
                    color: white;
                  }

                  .btn {
                    padding: 10px 20px;
                    cursor: pointer;
                    border: none;
                    color: white;
                    border-radius: 5px;
                  }
                </style>
              </head>

              <body>
                <c:if test="${empty loggedInUser}">
                  <c:redirect url="login.jsp"></c:redirect>
                </c:if>

                <c:if test="${not empty succMsg}">
                  <div class="alert alert-success" role="alert">${succMsg}</div>
                  <c:remove var="succMsg" scope="session" />
                </c:if>

                <c:if test="${not empty failedMsg}">
                  <div class="alert alert-danger text-center" role="alert">${failedMsg}</div>
                  <c:remove var="failedMsg" scope="session" />
                </c:if>

                <div class="container">
                  <div class="cart">
                    <h2>Your Items in Cart</h2>
                    <div class="table-responsive">
                      <table>
                        <thead>
                          <tr>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Action</th>
                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach var="cartItem" items="${cartItems}">
                            <tr>
                              <td>${cartItem.product_name}</td>
                              <td>
                                <form action="updateCartQuantity" method="post" class="quantity-form">
                                  <input type="hidden" name="productId" value="${cartItem.productId}">
                                  <input type="hidden" name="buyerId" value="${loggedInUser.buyer_id}">
                                  <button type="submit" name="action" value="decrement"
                                    class="quantity-btn minus">-</button>
                                  <span>${cartItem.quantity}</span>
                                  <button type="submit" name="action" value="increment"
                                    class="quantity-btn plus">+</button>
                                </form>
                              </td>
                              <td>${cartItem.price * cartItem.quantity}</td>
                              <td>
                                <a href="removeFromCart?productId=${cartItem.productId}&buyerId=${loggedInUser.buyer_id}"
                                  class="remove-btn">Remove</a>
                              </td>
                            </tr>
                          </c:forEach>
                          <tr>
                            <td>Total Price</td>
                            <td></td>
                            <td></td>
                            <td>${totalPrice}</td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                  <div class="text-center form-buttons">
                    <a href="checkout.jsp"><button type="button" class="btn btn-warning">Order Now</button></a>
                    <a href="index.jsp" class="btn btn-success">Continue Shopping</a>
                  </div>
                </div>
              </body>

              </html>