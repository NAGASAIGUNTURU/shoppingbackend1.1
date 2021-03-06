package com.niit.ShoppingcartServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit.shoppingcart");
		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category) context.getBean("category");

		category.setId("CG022");
		category.setName("mappy");
		category.setDescription("this is maptop category");

		if (categoryDAO.save(category) == true) {
			System.out.println("category created successfully");
		} else {
			System.out.println("not able to create category");
		}

	}
}
