package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        Product product = new Product();
                        ProductValidationService productValidationService = new ProductValidationService();

                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        product.setName(name);
                        productValidationService.validateName(product);

                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        product.setPrice(price);
                        productValidationService.validatePrice(product);

                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        product.setCategory(category);

                        System.out.println("Enter product discount: ");
                        BigDecimal discount = new BigDecimal(scanner.nextLine());
                        product.setDiscount(discount);
                        productValidationService.validateDiscount(product);
                        product.setPrice(product.getPrice().multiply(product.getDiscount()));


                        System.out.println("Enter product description: ");
                        String description = scanner.nextLine();
                        product.setDescription(description);

                        product.setId(productIdSequence);
                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                        break;
                    case 2:
                        System.out.println("Enter product id: ");
                        Long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
