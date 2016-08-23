package com.niit.ShoppingcartServer;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.Supplier;

public class TestCaseSupplier {

	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	Supplier supplier;
	AnnotationConfigApplicationContext context;
	@Before
	public void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO =(SupplierDAO) context.getBean("supplierDAO");
		supplier= (Supplier) context.getBean("supplier");
	}
	@Test
	public void categoryListTestCase()
	{
		List<Supplier> list = supplierDAO.list();
		int rowCount= list.size();
		assertEquals("category Lisi Test case", rowCount,5);
     }
	@Test
	public void categoeyAddTestcase()
	{

		supplier.setId("surfthjg");
		supplier.setName("njsgd");
		supplier.setDescription("werfcg");
		boolean flag= supplierDAO.save(supplier);
		assertEquals(flag, true);
	}
	@Test
	public void categoryGetTestCase()
	{
		supplier = supplierDAO.get("SUP001");
		
		System.out.println(supplier.getDescription());
		System.out.println(supplier.getName());
		assertEquals(supplier.getName(),"asdfadge");
		
	}
}
