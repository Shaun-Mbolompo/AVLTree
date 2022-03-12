/**
* A BinaryTree generic object
* 
* A BinaryTree generic object contains some operation methods for a binary tree
* and an attribute of the BinaryTreeNode class
*
* @author Shaun
* @version 1.0 28/02/2022
*
*/


public class BinaryTree<dataType>
{  
   /**
   * The instance variable of a parameterized BinaryTreeNode 
   */
   
   BinaryTreeNode<dataType> root;
   
   /**
   * Default BinaryTree constructor
   * The constructor initializes the root BinaryTreeNode to null
   *
   */
   
   public BinaryTree()
   {
      root = null;
   }
   
   /**
   * Helper method for finding the height of a binary tree
   * 
   *@return the getHeight method with a parameter of the root BinaryTreeNode 
   * 
   */
   
   public int getHeight()
   {
      return getHeight(root);
   } 
   
   /**
   *The actual method that calculates the height of a binary tree
   *
   *@param node the BinaryTreeNode
   *@return the actual height a Binary Tree
   */
  
   public int getHeight(BinaryTreeNode<dataType> node)
   {
      if(node == null)
         return -1;
      else
         return 1 + Math.max (getHeight(node.getLeft()), getHeight(node.getRight()));
   }
   
   /**
   * Helper method to get the size of Binary Tree
   * 
   * @return getSize(root) the method to actual count the size of a tree
   */

   public int getSize()
   {
      return getSize(root);
   }
   
   /**
   * The actual method that calculates the size of a Binary Tree
   * 
   * @param node the BinaryTreeNode
   * @return the size of the Binary Tree
   */
   
   public int getSize(BinaryTreeNode<dataType> node)
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize(node.getLeft()) + getSize(node.getRight());
   }
   
   /**
   * Visits a node and prints out its data
   * @param node the node that is traversed
   */

   public void visit(BinaryTreeNode<dataType> node)
   {
      System.out.println(node.data);
   }
   
   /**
   * Helper method to traverse the binary tree
   *
   */

   public void preOrder()
   {
      preOrder(root);
   }
   
   /**
   * Traverse the Binary Tree by visiting the node first, then the left
   * and finaly the right node recursively
   *
   *@param node receives the node to be traversed
   */

   public void preOrder(BinaryTreeNode<dataType> node)
   {
      if(node != null)
      {
         visit(node);
         preOrder(node.getLeft());
         preOrder(node.getRight());
      }   
   }
}
