package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
	private List<Products> store;

	public StoreService() {
		this.store = new ArrayList<>();
		store.add(new Products("Giacchetta Uomo", 25.80, "men's clothing", "Bella giacchetta da uomo"));
		store.add(new Products("Blazer Donna", 40.90, "women's clothing", "Blazer Elegante da donna "));
		store.add(new Products("Collana Argento", 80.90, "jewelery", "Collana da donna in argento con zirconi"));
		store.add(new Products("SSD 1 TB", 90.00, "electronics", "SSD per computer fissi  con 1 TB di spazio"));

	}

	public List<Products> getStore() {
		return store;
	}

	public void addProducts(Products products) {
		store.add(products);
	}
	
	public boolean updateProducts(String title, Products updatedProducts) {
		Optional<Products> existingProducts = store.stream().filter(d -> d.getTitle().equalsIgnoreCase(title)).findFirst();
		if (existingProducts.isPresent()) {  // Se il prodotto esistente viene trovato
            Products products = existingProducts.get();  // Ottieni il prodotto trovato
            
         // Aggiorna i dettagli del piatto
            products.setTitle(updatedProducts.getTitle());
            products.setPrice(updatedProducts.getPrice());
            products.setCategory(updatedProducts.getCategory());
            products.setDescription(updatedProducts.getDescription());
            
            
            
            // Restituisce true indicando che l'aggiornamento è stato completato con successo
            return true;
	}
		return false;
	}
	public boolean removeProducts(String title) {
        return store.removeIf(d -> d.getTitle().equalsIgnoreCase(title));
    }
}
