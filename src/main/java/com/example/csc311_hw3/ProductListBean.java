package com.example.csc311_hw3;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Service registers the class an Object(bean in spring terms)
@Service
public class ProductListBean {

    List<Product> productList;

    public ProductListBean() {
        productList = new ArrayList<>();
        try {
            String resourceName = "Products.csv";
            Resource resource = new ClassPathResource(resourceName);
            File file = null;
            file = resource.getFile();
            FileReader fr = new FileReader(file);
            Scanner infile = new Scanner(fr);
            while (infile.hasNextLine()) {
                String line = infile.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    String stock_status = parts[3].trim();
                    double rating = Double.parseDouble(parts[4].trim());
                    String description = parts[5].trim();
                    String customer_review = parts[6].trim();
                    productList.add(new Product(id, name, price, stock_status, rating, description, customer_review));
                }
            }
            infile.close();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Product> getProductList() {
        return productList;
    }


}
