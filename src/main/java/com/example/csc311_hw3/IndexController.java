package com.example.csc311_hw3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final ProductListBean productListBean;

    public IndexController(ProductListBean productListBean) {
        this.productListBean = productListBean;
    }

    @GetMapping("/")
    public String productlist(Model model) {
        //add productList from ProductListBean and populate it within products.
        model.addAttribute("products", productListBean.getProductList());
        return "productlist";
    }

    @GetMapping("/product")
    public String product(Model model) {
        return "product";
    }

}