package com.revshop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.revshop.ProductService.ProductServiceImpl;
import com.revshop.model.Products;
import com.revshop.model.Seller;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;
	
	@GetMapping("/add")
	public String add() {
		return "add_products";
	}

	// Path to save the images on the server
	public String UPLOAD_DIR = "src/main/resources/static/images/";

	@PostMapping("/add_products")
	public String addProduct(@RequestParam("product_name") String productName,
	                         @RequestParam("product_image") MultipartFile file,
	                         @RequestParam("product_description") String description,
	                         @RequestParam("product_stock") int stock,
	                         @RequestParam("product_category") String categories,
	                         @RequestParam("product_price") String price,
	                         @RequestParam("product_company") String company,
	                         HttpSession session) {

	    // Retrieve the seller from the session
	    Seller seller = (Seller) session.getAttribute("loggedInUser"); // Ensure correct attribute name

	    // Check if the seller is logged in
	    if (seller == null) {
	        session.setAttribute("failedMsg", "Please log in as a seller to add a product.");
	        return "redirect:/login"; // Redirect to the login page if the seller is not logged in
	    }

	    // Save the product image and get the filename
	    String fileName = null;
	    try {
	        if (!file.isEmpty()) {
	            fileName = file.getOriginalFilename();
	            Path filePath = Paths.get(UPLOAD_DIR + fileName);
	            Files.write(filePath, file.getBytes());
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        session.setAttribute("failedMsg", "An error occurred while uploading the image");
	        return "add_products"; // Return early on error
	    }

	    // Create the product object
	    Products product = new Products();
	    product.setProduct_name(productName);
	    product.setProduct_image(fileName); // Set the filename here
	    product.setProduct_description(description);
	    product.setProduct_stock(stock);
	    product.setProduct_category(categories);
	    product.setProduct_price(Double.parseDouble(price));
	    product.setProduct_company(company);

	    // Set the seller who is adding the product
	    product.setSeller(seller); // Link the seller to the product

	    // Save the product to the database using the service
	    Products success = productService.addproducts(product);

	    // Set success or failure messages in session
	    if (success != null) {
	        session.setAttribute("succMsg", "Product Added Successfully");
	    } else {
	        session.setAttribute("failedMsg", "Something went wrong");
	    }

	    return "add_products"; // Return to the add products page
	}

	
	@GetMapping("/products")
	public String getAllProducts(HttpSession session, Model model) {
	    // Retrieve the logged-in seller's ID from the session
	    Seller loggedInSeller = (Seller) session.getAttribute("loggedInUser");

	    if (loggedInSeller != null) {
	        System.out.println("Logged in seller ID: " + loggedInSeller.getId());

	        // Fetch products associated with the logged-in seller
	        List<Products> sellerProducts = productService.getProductsBySellerId(loggedInSeller.getId());
	        System.out.println("Retrieved products: " + sellerProducts);

	        // Add products to the model
	        model.addAttribute("products", sellerProducts);
	        return "all_products"; // Correctly returns the JSP view name
	    } else {
	        System.out.println("No seller logged in, redirecting to login.");
	        return "redirect:/login"; // Redirect to login if no seller is logged in
	    }
	}





  
	@GetMapping("/edit/products")
	public String showEditProductForm(@RequestParam("id") int productId, Model model) {
	    Products product = productService.getProductById(productId); // Method to retrieve product by ID
	    model.addAttribute("product", product);
	    return "edit_product"; // Return the view name for editing
	}

	@PostMapping("/edit/products")
	public String updateProduct(@ModelAttribute Products product, RedirectAttributes redirectAttributes) {
	    Products updatedProduct = productService.updateProduct(product); // Method to update product details
	    if (updatedProduct != null) {
	        redirectAttributes.addFlashAttribute("succMsg", "Product updated successfully!");
	    } else {
	        redirectAttributes.addFlashAttribute("failedMsg", "Failed to update product.");
	    }
	    return "redirect:/products"; // Redirect to all products page
	}


	@PostMapping("/delete/products")
	public String deleteProduct(@RequestParam("product_id") int productId, RedirectAttributes redirectAttributes) {
	    productService.deleteProduct(productId); // Call to your service to delete the product
	    redirectAttributes.addFlashAttribute("succMsg", "Product deleted successfully!");
	    return "redirect:/products"; // Redirect back to the products page
	}




}
