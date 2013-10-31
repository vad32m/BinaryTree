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
         assertFalse(tree.exists(3));
         assertTrue(tree.remove(15));
         assertFalse(tree.remove(10));
         assertTrue(tree.exists(10));
    }
}
