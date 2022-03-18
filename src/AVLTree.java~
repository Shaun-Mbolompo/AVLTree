/**
* Hussein's AVL Tree extends the Comaparable interface
* 2 April 2017 
* reference: kukuruku.co/post/avl-trees/
*
* @author Hussein Suleman
*/

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{

   int opCount = 0;
   int insertOpCount = 0;
   
   /**
   * Obtain the height of the node
   *
   * @param node the node who's height is checked
   * @return -1 if node does not exist or its height if it exists
   */
   
   public int height ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   /**
   * Obtain the difference between siblings subtrees
   * 
   * @param node the node who's subtress are checked
   * @return the height difference 
   */
   
   public int balanceFactor ( BinaryTreeNode<dataType> node )
   {
      return height (node.right) - height (node.left);
   }
   
   /**
   * Fix the height of the node's subtrees
   *
   * @param node the node who's height is being fixed
   */
   
   public void fixHeight ( BinaryTreeNode<dataType> node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   /**
   * Fixes the tree by rotating right
   * 
   * @param p the node that is being rotated
   * @return the node in the rotated position
   */
   
   public BinaryTreeNode<dataType> rotateRight ( BinaryTreeNode<dataType> p )
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }
   
   /**
   * Fixes the tree by rotating left
   *
   * @param q the node that is being rotated
   * @return the node in the rotated position
   */

   public BinaryTreeNode<dataType> rotateLeft ( BinaryTreeNode<dataType> q )
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   /**
   * Balances the tree 
   *
   * @param p the nodes subtree to be balanced
   * @return the node in the balanced position
   */
   
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
   
   /**
   * A helper insert method to insert a BinaryTreeNode using a data tupe
   *
   * @param d insert the data type to create a node 
   */
   
   public void insert ( dataType d )
   {	
      root = insert (d, root);
   }
   
   /**
   * Insert a node by comparing it to existing nodes, using the convention of inserting
   * a node to the left is less than a root node or else right recursively  
   * 
   * @param d the type parameter datatype
   * @param node the node of a binary tree  
   */
   
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
      insertOpCount++;
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   
   
   /**
   * Find helper method to find a node using a parameter type
   * 
   * @param d the parameter type
   * @return the method find(d, root)
   */
   
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   
   /**
   * Finds the given type parameter recursively going through the nodes
   *
   * @param d the type parameter
   * @param node the binary tree node of the tree
   * @return the parameterized BinaryTreeNode of the type parameter found
   */
   
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      opCount++;
      if (d.compareTo (node.data) == 0){
         return node;}
      opCount++;
      if (d.compareTo (node.data) < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
}

