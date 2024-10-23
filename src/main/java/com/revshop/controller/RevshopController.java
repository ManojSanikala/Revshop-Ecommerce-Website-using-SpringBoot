package com.revshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revshop.BuyerService.BuyerServiceImpl;
import com.revshop.ProductService.ProductServiceImpl;
import com.revshop.SellerService.SellerServiceImpl;
import com.revshop.emailService.EmailServiceImpl;
import com.revshop.model.Buyer;
import com.revshop.model.Products;
import com.revshop.model.Seller;

import jakarta.servlet.http.HttpSession;

@Controller
public class RevshopController {

    @Autowired
    private BuyerServiceImpl buyerService;

    @Autowired
    private SellerServiceImpl sellerService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private EmailServiceImpl emailService;

    // Home page handler
    @GetMapping("/")
    public String homePage(Model model) {
        List<Products> allProducts = productService.getAllProducts(); // Fetch all products
        model.addAttribute("products", allProducts); // Add products to the model
        return "index"; // Return to the index view
    }

    // Registration page handler
    @RequestMapping("/register")
    public String registerPage() {
        return "register";
    }

    @RequestMapping("/save")
    public String save(Buyer buyer, Seller seller, HttpSession session, Model model) {
        String emailError = null;
        String usernameError = null;
        String mobileError = null;
        String passwordError = null; // New variable for password error

        try {
            if (buyer.getRole().equalsIgnoreCase("Buyer")) {
                // Validate buyer details
                if (buyerService.emailExists(buyer.getEmail())) {
                    emailError = "Email already exists";
                }
                if (buyerService.usernameExists(buyer.getName())) {
                    usernameError = "Username already exists";
                }
                if (buyerService.mobileExists(buyer.getMobile())) {
                    mobileError = "Mobile number already exists";
                }
                if (!buyerService.isPasswordStrong(buyer.getPassword())) { // Check password strength
                    passwordError = "Password is too weak. It must contain at least 8 characters, including 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character.";
                }

                // Check if there are any errors
                if (emailError != null || usernameError != null || mobileError != null || passwordError != null) {
                    model.addAttribute("emailError", emailError);
                    model.addAttribute("usernameError", usernameError);
                    model.addAttribute("mobileError", mobileError);
                    model.addAttribute("passwordError", passwordError); // Add password error
                    model.addAttribute("buyer", buyer); // Retain buyer info in the form
                    return "register"; // Return to registration form with errors
                }
                buyerService.register(buyer);

                // Set success message in session
                session.setAttribute("succMsg", "Registration successful! You can now log in as a " + buyer.getRole() + ". Please login.");
                emailService.sendRegistrationEmail(buyer.getEmail(), buyer.getName(), buyer.getRole());

            } else if (seller.getRole().equalsIgnoreCase("Seller")) {
                // Validate seller details
                if (sellerService.emailExists(seller.getEmail())) {
                    emailError = "Email already exists";
                }
                if (sellerService.usernameExists(seller.getName())) {
                    usernameError = "Username already exists";
                }
                if (sellerService.mobileExists(seller.getMobile())) {
                    mobileError = "Mobile number already exists";
                }
                if (!sellerService.isPasswordStrong(seller.getPassword())) { // Check password strength
                    passwordError = "Password is too weak. It must contain at least 8 characters, including 1 uppercase letter, 1 lowercase letter, 1 number, and 1 special character.";
                }

                // Check if there are any errors
                if (emailError != null || usernameError != null || mobileError != null || passwordError != null) {
                    model.addAttribute("emailError", emailError);
                    model.addAttribute("usernameError", usernameError);
                    model.addAttribute("mobileError", mobileError);
                    model.addAttribute("passwordError", passwordError); // Add password error
                    model.addAttribute("seller", seller); // Retain seller info in the form
                    return "register"; // Return to registration form with errors
                }
                sellerService.register(seller);
                // Set success message in session
                session.setAttribute("succMsg", "Registration successful! You can now log in as a " + seller.getRole() + ". Please login.");
                emailService.sendRegistrationEmail(seller.getEmail(), seller.getName(), seller.getRole());
            }
        } catch (RuntimeException e) {
            // Set error message in the session
            session.setAttribute("errorMessage", e.getMessage());
            return "register"; // Redirect back to the registration page
        }

        // Redirect to login page with a parameter to indicate successful registration
        return "redirect:/login?register=true";

    }

    // Login page handler
    @GetMapping("/login")
    public String login() {
        return "login"; // Show login page
    }

    // Login handler for both Buyer and Seller
    @RequestMapping("/loginpage")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("role") String role, HttpSession session) {
        // Handle Buyer login
        if (role.equalsIgnoreCase("Buyer")) {
            Buyer buyer = buyerService.login(email, password); // Attempt buyer login
            if (buyer != null) {
                session.setAttribute("loggedInUser", buyer); // Store buyer in session
                session.setAttribute("userRole", "Buyer"); // Mark role as 'Buyer'
                session.setAttribute("succMsg", "Login successful! Welcome " + buyer.getName());
                return "redirect:/buyerDashboard"; // Redirect to Buyer dashboard
            } else {
                session.setAttribute("failedMsg", "Invalid email or password for Buyer. Please try again.");
                return "login"; // Redirect back to login on failure
            }
        }
        // Handle Seller login
        else if (role.equalsIgnoreCase("Seller")) {
            Seller seller = sellerService.login(email, password); // Attempt seller login
            if (seller != null) {
                session.setAttribute("loggedInUser", seller); // Store seller in session
                session.setAttribute("userRole", "Seller"); // Mark role as 'Seller'
                session.setAttribute("succMsg", "Login successful! Welcome " + seller.getName());
                return "redirect:/sellerDashboard"; // Redirect to Seller dashboard
            } else {
                session.setAttribute("failedMsg", "Invalid email or password for Seller. Please try again.");
                return "login"; // Redirect back to login on failure
            }
        }

        // If no role matches or login fails, redirect back to home page
        return "index";
    }

    // Buyer dashboard handler
    @RequestMapping("/buyerDashboard")
    public String showBuyerDashboard(HttpSession session, Model model) {
        // Retrieve the logged-in buyer from the session
        Buyer loggedInBuyer = (Buyer) session.getAttribute("loggedInUser");

        if (loggedInBuyer != null) {
            List<Products> buyerProducts = productService.getAllProducts(); // Fetch products for the buyer
            model.addAttribute("products", buyerProducts); // Add products to the model
            return "buyerDashboard"; // Show Buyer dashboard
        } else {
            session.setAttribute("failedMsg", "Please log in to access your dashboard.");
            return "redirect:/login"; // Redirect to login page if not logged in
        }
    }

    // Seller dashboard handler
    @RequestMapping("/sellerDashboard")
    public String showSellerDashboard(HttpSession session, Model model) {
        // Retrieve the logged-in seller from the session
        Seller loggedInSeller = (Seller) session.getAttribute("loggedInUser");

        if (loggedInSeller != null) {
            // Fetch products specific to the logged-in seller using their seller ID
            List<Products> sellerProducts = productService.getProductsBySellerId(loggedInSeller.getId());

            // Add products to the model
            model.addAttribute("products", sellerProducts);

            // Show Seller dashboard
            return "sellerDashboard";
        } else {
            // If the seller is not logged in, redirect to the login page
            session.setAttribute("failedMsg", "Please log in to access the seller dashboard.");
            return "redirect:/login";
        }
    }

    // Logout handler
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate session to log out the user
        return "redirect:/"; // Redirect to home page after logout
    }
}
