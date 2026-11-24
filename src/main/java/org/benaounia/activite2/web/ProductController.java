
package org.benaounia.activite2.web;

import org.benaounia.activite2.entities.Product;
import org.benaounia.activite2.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Consulter tous les produits
    @GetMapping("/products")
    public List<Product> products() {
        return productRepository.findAll();
    }

    // Consulter un produit par ID
    @GetMapping("/products/{id}")
    public Product productById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    // Ajouter un produit
    @PostMapping("/products")
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Chercher des produits par nom
    @GetMapping("/products/search/{kw}")
    public List<Product> search(@PathVariable String kw) {
        return productRepository.findByNameContainsIgnoreCase(kw);
    }

    // Modifier un produit
    @PutMapping("/products/{id}")
    public Product update(
            @PathVariable Long id,
            @RequestBody Product product) {

        product.setId(id);
        return productRepository.save(product);
    }

    // Supprimer un produit
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
