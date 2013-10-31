package foo;

import static junit.framework.Assert.*;

import org.junit.Test;

public class AppTest
{
	private BinaryTree tree;
    @Test
    public void testArea() 
    {
         tree = new BinaryTree(15);
         assertTrue(tree.add(10));
         assertTrue(tree.add(2));
         assertFalse(tree.add(15));
         assertTrue(tree.exists(15));
    }
}
