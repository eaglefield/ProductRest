package com.jo.productrest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("products")
public class ProductResource {
	
	ProductRepository repo = new ProductRepository();

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Product> getProducts() {
    	System.out.println("getProducts called");
    	return repo.getProducts();
	}
    
    @GET
    @Path("product/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Product getProduct(@PathParam("id")int id) {
    	System.out.println("getProduct called");
    	return repo.getProduct(id);
	}
    
    //post request (create new product)
    @POST
    @Path("product")
    public Product createProduct(Product p) {
    	System.out.println("Creating Product: " + p);
    	repo.create(p);
    	return p;
    }
    
    @GET
    @Path("name/{name}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Product> getProduct(@PathParam("name")String name) {
    	System.out.println("getProductName called");
    	return repo.getProductName(name);
	}
}
