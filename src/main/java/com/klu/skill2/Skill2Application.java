package com.klu.skill2;

import com.klu.skill2.Entity.Product;
import com.klu.skill2.Service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Skill2Application {

    public static void main(String[] args) {
        SpringApplication.run(Skill2Application.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService service) {
        return args -> {

            // Insert products
            service.insertMultipleProducts(List.of(
                    new Product("Laptop", "Gaming laptop", 75000, 5),
                    new Product("Mouse", "Wireless mouse", 1200, 30),
                    new Product("Keyboard", "Mechanical keyboard", 3500, 15),
                    new Product("Monitor", "4K Display", 18000, 8),
                    new Product("Headphones", "Noise cancel", 4500, 25),
                    new Product("Webcam", "HD webcam", 2500, 12),
                    new Product("Chair", "Ergonomic chair", 9000, 3),
                    new Product("PenDrive", "USB storage", 700, 40)
            ));

            System.out.println("\n--- SORT BY PRICE ASC ---");
            service.printSortedByPriceAsc();

            System.out.println("\n--- SORT BY PRICE DESC ---");
            service.printSortedByPriceDesc();

            System.out.println("\n--- SORT BY QUANTITY DESC ---");
            service.printSortedByQuantityDesc();

            System.out.println("\n--- PAGINATION (FIRST 3) ---");
            service.printFirst3();

            System.out.println("\n--- PAGINATION (NEXT 3) ---");
            service.printNext3();

            System.out.println("\n--- AGGREGATES ---");
            service.printAggregates();

            System.out.println("\n--- PRICE RANGE 1000 to 10000 ---");
            service.printPriceRange(1000, 10000);

            System.out.println("\n--- LIKE EXAMPLES ---");
            service.printLikeExamples();
        };
    }
}
