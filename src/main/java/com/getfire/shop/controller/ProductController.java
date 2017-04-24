package com.getfire.shop.controller;

import com.getfire.shop.model.Product;
import com.getfire.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addProducts(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }


    @RequestMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateProduct(@ModelAttribute("product") Product product,
                                @PathVariable long id) {
        productService.updateProduct(product);
        return "redirect:/products/" + id;
    }

    @RequestMapping(value = "/{id}")
    public ModelAndView getProduct(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", productService.findProductById(id));
        modelAndView.setViewName("productDesc");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", productService.findAllProducts());
        modelAndView.setViewName("products");
        return modelAndView;
    }


}
