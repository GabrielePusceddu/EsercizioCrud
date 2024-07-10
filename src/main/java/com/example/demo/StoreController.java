package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

	@Autowired
    private StoreService storeService;
	
	@GetMapping
    public List<Products> getStore() {
        return storeService.getStore();
    }
	
	@PostMapping
    public ResponseEntity<String> addProducts(@RequestBody Products products) {
        storeService.addProducts(products);
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }
	
	@PutMapping("/{title}")
    public ResponseEntity<String> updateProducts(@PathVariable String title, @RequestBody Products updatedProducts) {
        boolean updated = storeService.updateProducts(title, updatedProducts);
        if (updated) {
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@DeleteMapping("/{title}")
    public ResponseEntity<String> removeProducts(@PathVariable String title) {
        boolean removed = storeService.removeProducts(title);
        if (removed) {
            return new ResponseEntity<>("Product removed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Products>> getMenuAsJson() {
        List<Products> store = storeService.getStore();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(store, headers, HttpStatus.OK);
    }

}
