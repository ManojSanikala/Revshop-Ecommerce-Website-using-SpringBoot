<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Product Details</title>
</head>

<body>
  <h2>Product Details</h2>

  <!-- Display product details -->
  <c:if test="${not empty product}">
    <p><strong>Name:</strong> ${product.product_name}</p>
    <p><strong>Description:</strong> ${product.product_description}</p>
    <p><strong>Price:</strong> ${product.product_price}</p>
    <p><strong>Stock:</strong> ${product.product_stock}</p>
    <p><strong>Category:</strong> ${product.product_category}</p>
    <p><strong>Company:</strong> ${product.product_company}</p>

    <!-- Product Image -->
    <img src="/images/${product.product_image}" alt="${product.product_name}" />
  </c:if>

  <!-- Error message if no product found -->
  <c:if test="${not empty errorMsg}">
    <p>${errorMsg}</p>
  </c:if>
</body>

</html>