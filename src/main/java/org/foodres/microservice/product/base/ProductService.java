package org.foodres.microservice.product.base;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Optional<Product> add(Map<String, String> map) {
		Product product = new Product();
		if (!map.containsKey("name")) {
			return Optional.<Product>of(null);
		}
		product.setName(map.get("name"));
		if (map.containsKey("description")) {
			product.setDescription(map.get("description"));
		}
		productRepository.save(product);
		return Optional.<Product>of(product);
	}

	public Iterable<Product> getAll() {
		return productRepository.findAll();
	}

	public Optional<Product> get(long id) {
		return productRepository.findById(id);
	}

	public Optional<Product> update(long id, Map<String, String> map) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isEmpty()) {
			return optional;
		}

		Product product = optional.get();

		if (map.containsKey("name")) {
			product.setName(map.get("name"));
		}
		if (map.containsKey("description")) {
			product.setDescription(map.get("description"));
		}
		productRepository.save(product);
		return optional;
	}
}
