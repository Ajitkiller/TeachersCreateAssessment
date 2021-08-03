package com.listeners.testNGlisteners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(com.listeners.testNGlisteners.TestNGListeners.class)
public class TestNGListenerDemo {
 
	@Test
	public void test1()
	{
		System.out.println("This is test 1, please come inside");
		throw new SkipException("This is skipped");
	}
	@Test
	public void test2()
	{
		System.out.println("This is test 2, please come inside");
		Assert.assertTrue(false);
	}
	@Test
	public void test3()
	{
		System.out.println("This is test 3, please come inside");
		
	}
	@Test
	public void test4()
	{
		System.out.println("This is test 4, please come inside");
		
	}
}
