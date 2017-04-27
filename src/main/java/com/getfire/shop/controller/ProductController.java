package com.getfire.shop.controller;

import com.getfire.shop.model.Product;
import com.getfire.shop.service.ProductService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addProducts(@ModelAttribute("product") Product product,
                              BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest,
                              RedirectAttributes redirectAttributes,
                              @RequestParam(value = "file", required = false) Part file) {
        if (bindingResult.hasErrors()) {
            uiModel.addAttribute("message", "Wrong data");
            uiModel.addAttribute("product", product);
            return "/products";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", "Product successfully saved");
        if (file != null) {
            byte[] photo = null;
            try {
                InputStream inputStream = file.getInputStream();
                photo = IOUtils.toByteArray(inputStream);
                product.setPhoto(photo);
            } catch (IOException e) {
                System.err.println("Error saving uploaded file");
            }
            product.setPhoto(photo);
        }else {
            System.out.println("**************************");
            System.out.println("*******************************");
            System.out.println();
            System.out.println("NUL");
            System.out.println();
            System.out.println("************************************");
            System.out.println("*******************************");
        }
        productService.saveProduct(product);
        return "redirect: /products";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/update/{id}")
    public String editProduct(@ModelAttribute("product") Product product,
                              @PathVariable long id, @RequestParam(value = "file", required = false) Part file) {
        if (file != null) {
            byte[] photo = null;
            try {
                InputStream is = file.getInputStream();
                photo = IOUtils.toByteArray(is);
                product.setPhoto(photo);
            } catch (IOException e) {
                System.err.println("Error saving uploaded file");
            }
            product.setPhoto(photo);
        }
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public byte[] downloadPhoto(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        return product.getPhoto();
    }


}
