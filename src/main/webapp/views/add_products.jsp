<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@page isELIgnored="false" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>Add Products</title>
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

				<link rel="stylesheet" href="all_component/style.css">
				<style>
					/* Form-Specific Styles */
					.form-container {
						max-width: 90%;
						margin: 20px auto;
						background-color: white;
						padding: 20px;
						border-radius: 10px;
						box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
					}

					.form-title {
						text-align: center;
						margin-bottom: 20px;
						font-weight: bold;
						color: #007bff;
						font-size: 24px;
					}

					.form-label {
						font-weight: bold;
						color: #495057;
					}

					.form-control,
					.form-select {
						height: 40px;
						border-radius: 8px;
						margin-bottom: 15px;
						padding: 8px;
						font-size: 14px;
					}

					.form-control:focus,
					.form-select:focus {
						box-shadow: none;
						border-color: #007bff;
					}

					textarea.form-control {
						height: auto;
						resize: none;
					}

					button {
						height: 45px;
						border-radius: 8px;
						font-size: 16px;
						font-weight: bold;
					}

					@media (min-width: 768px) {
						.form-container {
							max-width: 60%;
							padding: 30px;
						}
					}
				</style>

			</head>

			<body>

				<div class="form-container">
					<h2 class="form-title">Add New Product</h2>

					<form action="/add_products" method="post" enctype="multipart/form-data">
						<!-- Product Name -->
						<div class="form-group mb-3">
							<label for="productName" class="form-label">Product Name</label>
							<input name="product_name" type="text" class="form-control" id="productName"
								placeholder="Enter product name" required>
						</div>

						<!-- Product Description -->
						<div class="mb-3">
							<label for="description" class="form-label">Product Description</label>
							<textarea name="product_description" class="form-control" id="product_description" rows="3"
								maxlength="100" placeholder="Enter product description (max 100 words)" required></textarea>
						</div>

						<!-- Price -->
						<div class="form-group mb-3">
							<label for="price" class="form-label">Price</label>
							<input name="product_price" type="number" class="form-control" id="price"
								placeholder="Enter product price" step="0.01" min="0" required>
						</div>

						<!-- Product Category -->
						<div class="form-group mb-3">
							<label for="category" class="form-label">Product Category</label>
							<select class="form-select" name="product_category" id="category" required>
								<option selected disabled>Choose a category</option>
								<option value="electronics">Electronics</option>
								<option value="home">Home Appliances</option>
								<option value="fashion">Fashion</option>
								<option value="others">Others</option>
							</select>
						</div>

						<!-- Product Stock -->
						<div class="form-group mb-3">
							<label for="stock" class="form-label">Product Stock</label>
							<input type="number" class="form-control" name="product_stock" id="stock" min="0" required>
						</div>

						<!-- Product Company -->
						<div class="form-group mb-3">
							<label for="company" class="form-label">Product Company</label>
							<input type="text" class="form-control" name="product_company" id="company" required>
						</div>

						<!-- Upload Photo -->
						<div class="form-group mb-3">
							<label for="photo" class="form-label">Upload Photo</label>
							<input name="product_image" type="file" class="form-control" id="photo" accept="image/*" required>
						</div>

						<!-- Submit Button -->
						<button type="submit" class="btn btn-primary w-100">Add Product</button>
					</form>
				</div>

				<!-- Bootstrap JS (including Popper.js) -->
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
			</body>

			</html>