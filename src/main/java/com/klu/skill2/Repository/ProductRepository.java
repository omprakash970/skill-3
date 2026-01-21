package com.klu.skill2.Repository;


import com.klu.skill2.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p order by p.price ASC")
    List<Product> sortByPriceAsc();
    @Query("select p from Product p order by p.price DESC")
    List<Product> sortByPriceDesc();
    @Query("select p from Product p order by p.quantity DESC ")
    List<Product> sortByQuantityDesc();
    @Query("SELECT p FROM Product p")
    Page<Product> getAllProductsWithPagination(Pageable pageable);

    // 6a) Count total products
    @Query("SELECT COUNT(p) FROM Product p")
    long countTotalProducts();

    // 6b) Count products where quantity > 0
    @Query("SELECT COUNT(p) FROM Product p WHERE p.quantity > 0")
    long countProductsQtyGreaterThanZero();

    // 6c) Count grouped by description
    @Query("SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description")
    List<Object[]> countGroupedByDescription();

    // 6d) Min and Max price
    @Query("SELECT MIN(p.price), MAX(p.price) FROM Product p")
    Object[] minAndMaxPrice();

    // 8) Filter products within price range
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> filterByPriceRange(double minPrice, double maxPrice);

    // 9a) Names starting with prefix
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT(:prefix, '%')")
    List<Product> nameStartsWith(String prefix);

    // 9b) Names ending with suffix
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :suffix)")
    List<Product> nameEndsWith(String suffix);

    // 9c) Names containing pattern
    @Query("SELECT p FROM Product p WHERE p.name LIKE CONCAT('%', :pattern, '%')")
    List<Product> nameContains(String pattern);

    // 9d) Exact length
    @Query("SELECT p FROM Product p WHERE LENGTH(p.name) = :len")
    List<Product> nameWithExactLength(int len);
}
