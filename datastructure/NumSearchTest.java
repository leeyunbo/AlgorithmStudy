package datastructure;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumSearchTest {

	@Test
	public void testSearch() {
		NumSearch ns = new NumSearch();
		int result = ns.binarySearchN(0, 4, 3);
		assertEquals(result,1);
	}
	
	@Test
	public void testSearch2() {
		NumSearch ns = new NumSearch();
		int result = ns.binarySearchN(0, 4, 4);
		assertEquals(result,1);
	}

	
	@Test
	public void testSearch3() {
		NumSearch ns = new NumSearch();
		int result = ns.binarySearchN(0, 4, 5);
		assertEquals(result,1);
	}


}
