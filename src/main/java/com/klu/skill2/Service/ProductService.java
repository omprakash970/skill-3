package com.klu.skill2.Service;

import com.klu.skill2.Entity.Product;
import com.klu.skill2.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public void insertMultipleProducts(List<Product> products) {
        repo.saveAll(products);
    }

    public void printSortedByPriceAsc() {
        repo.sortByPriceAsc().forEach(System.out::println);
    }

    public void printSortedByPriceDesc() {
        repo.sortByPriceDesc().forEach(System.out::println);
    }

    public void printSortedByQuantityDesc() {
        repo.sortByQuantityDesc().forEach(System.out::println);
    }

    public void printFirst3() {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Product> page = repo.getAllProductsWithPagination(pageable);
        page.getContent().forEach(System.out::println);
    }

    public void printNext3() {
        Pageable pageable = PageRequest.of(1, 3);
        Page<Product> page = repo.getAllProductsWithPagination(pageable);
        page.getContent().forEach(System.out::println);
    }

    public void printAggregates() {
        System.out.println("Total Products = " + repo.countTotalProducts());
        System.out.println("Quantity > 0 = " + repo.countProductsQtyGreaterThanZero());

        Object[] minMax = repo.minAndMaxPrice();
        System.out.println("Min Price = " + minMax[0]);
        System.out.println("Max Price = " + minMax[1]);

        System.out.println("Grouped By Description:");
        for (Object[] row : repo.countGroupedByDescription()) {
            System.out.println("Description = " + row[0] + " | Count = " + row[1]);
        }
    }

    public void printPriceRange(double min, double max) {
        repo.filterByPriceRange(min, max).forEach(System.out::println);
    }

    public void printLikeExamples() {
        System.out.println("Starts with M:");
        repo.nameStartsWith("M").forEach(System.out::println);

        System.out.println("Ends with d:");
        repo.nameEndsWith("d").forEach(System.out::println);

        System.out.println("Contains 'cam':");
        repo.nameContains("cam").forEach(System.out::println);

        System.out.println("Name length = 5:");
        repo.nameWithExactLength(5).forEach(System.out::println);
    }
}
