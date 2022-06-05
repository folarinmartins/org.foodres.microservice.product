package org.foodres.microservice.product.base;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.StackWalker.Option;
import java.util.Map;
import java.util.Optional;

import org.foodres.microservice.product.common.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = { "/api/v1/products", "/api/v1/products/" })
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("")
	public RestResponse<Iterable<Product>> index() {
		return new RestResponse<Iterable<Product>>(productService.getAll());
	}

	@GetMapping(value = { "{id}", "{id}/" })
	public RestResponse<Optional<Product>> get(@PathVariable long id) {
		return new RestResponse<Optional<Product>>(productService.get(id));
	}

	@PostMapping()
	public RestResponse<Optional<Product>> create(@RequestParam Map<String, String> map) {
		return new RestResponse<Optional<Product>>(productService.add(map));
	}

	@PatchMapping(value = { "{id}", "{id}/" })
	public RestResponse<Optional<Product>> update(@PathVariable long id, @RequestParam Map<String, String> map) {
		return new RestResponse<Optional<Product>>(productService.update(id, map));
	}
}
