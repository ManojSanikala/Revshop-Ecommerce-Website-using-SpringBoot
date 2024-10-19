package com.revshop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.revshop.SellerService.SellerServiceImpl;
import com.revshop.model.Products;

import jakarta.servlet.http.HttpSession;

@Controller
public class SellerControl 
{
	@Autowired
	private SellerServiceImpl sellerService;
	
	
	@GetMapping("/add")
	public String add()
	{
		return "add_products";
	}
	

    // Path to save the images on the server
    private final String UPLOAD_DIR = "src/main/resources/static/images/";

    @PostMapping("/add_products")
    public String addProduct(
            @RequestParam("product_name") String productName,
            @RequestParam("product_image") MultipartFile file,
            @RequestParam("product_description") String description,
            @RequestParam("product_stock") int stock,
            @RequestParam("product_category") String categories,
            @RequestParam("product_price") String price,
            @RequestParam("product_company") String company,
            HttpSession session) {
        
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

        // Save product to database using service
        Products success = sellerService.addproducts(product);

        // Set success or failure messages in session
        if (success != null) {
            session.setAttribute("succMsg", "Product Added Successfully");
        } else {
            session.setAttribute("failedMsg", "Something went wrong");
        }

        return "add_products";
    }
    
 // Method to retrieve product details
    @GetMapping("/product/{id}")
    public String getProductDetails(@PathVariable("id") int productId, Model model) {
        // Fetch product by id using the service layer
        Products product = sellerService.getProductById(productId);
        
        // Check if product exists
        if (product == null) {
            model.addAttribute("errorMsg", "Product not found.");
            return "product_details"; // Error page
        }

        // Add the product details to the model
        model.addAttribute("product", product);
        
        return "product_details"; // JSP page to display product details
    }

}


