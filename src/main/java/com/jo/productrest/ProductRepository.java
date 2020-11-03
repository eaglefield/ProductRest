package com.jo.productrest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author Jonas Ornfelt This is a repository for product objects. Currently without a real database.
 *
 */

public class ProductRepository {

	List<Product> products;
	List<Product> specificProducts;

	/**
	 * Create some products
	 * Add the products to the list products
	 */
	public ProductRepository() {
		products = new ArrayList<>();

		String[] myProducts = {"Blue Scarf", "Green T-shirt", "Brown Pants", "Purple Socks", "White shoes"};
		int[] myQuantities = {5, 10, 15, 20, 25};
		double[] myPrices = {100, 100, 150, 20, 200};
		
		//add products to repository
		for(int i = 0; i < myProducts.length; i++) {
			//Product(int id, String name, int quantity, double price)
			Product product = new Product(i, myProducts[i], myQuantities[i], myPrices[i]);
			products.add(product);
		}
	}
	
	/**
	 * Converts the response to JSONArray
	 */
	private JsonArray parseJson(String[] response) {
		
		JsonParser parser = new JsonParser();
		JsonElement rootElement = parser.parse(response[0]);
		JsonObject object = rootElement.getAsJsonObject();
		JsonArray jsonArray = object.getAsJsonArray("reservations");
		
		return jsonArray;
	}
	
	/**
	 * Fills the list with Java Objects 
	 */
	private void fillList(JsonArray jsonArray) {
		
		Gson gson = new Gson();
		String jsonString = jsonArray.toString();

		Type productListType = new TypeToken<ArrayList<Product>>() {
		}.getType();
		List<Product> productList = gson.fromJson(jsonString, productListType);
		for (Product p : productList) {
			products.add(p);
			System.out.println(p.toString());
		}
		
	}


	/**
	 * Get list of all the products
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Get product by booking-id
	 */
	public Product getProduct(int id) {
		// search list for specific product
		for (Product p : products) {
			if (p.getId() == id) {
				return p;
			}
		}
		String[] tempString = { "Test", "Booking" };
		// return new product if no product is found with given id
		return new Product(id, "", 1, 2);
	}

	
	public void create(Product p) {
		products.add(p);
	}

	/**
	 * Method which returns bookings with given product name
	 */
	public List<Product> getProductName(String name) {
		specificProducts = new ArrayList<>();
		try {
			for (Product p : products) {
				if (p.getName().toLowerCase().equals(name.toLowerCase())) {
					specificProducts.add(p);
				}
			}
		} catch (NullPointerException e) {
			// test products/bookings with no name will cast exception
			System.out.println("Nullpointer when getting products with specific name.");
		}
		return specificProducts;
	}
}

