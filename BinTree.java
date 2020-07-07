/* HW 1- Create a Binary Search Tree with methods to add to the tree
 * and traverse/print out the numbers in ascending order.
 * @author Colten Coffman
 * 7/7/2020
 */
public class BinTree {
	public static Node node;
	
	public BinTree() {
		BinTree.node = null;
	}
	
	/* Inserts ints into the nodes */
	public void insertNode(int id){
		Node newNode = new Node(id);
		if(node==null){
			node = newNode;
			return;
		}
		Node current = node;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
		

	}
	
	/* Traverses the tree and prints out the data */ 
	private void treeWalk(Node node) { 
		if (node == null) { 
			return; 
			} 
		treeWalk(node.left); 
		System.out.printf("%s ", node.data); 
		treeWalk(node.right); }

	/* Test for binary tree implementation (insertion and traversal) */
	public static void main(String[] args)
	{
		/* testcase 2 */
				System.out.println();
				System.out.println("testcase 1:");
				BinTree binTree2 = new BinTree();
				binTree2.insertNode(3);
				binTree2.insertNode(201);
				binTree2.insertNode(60);
				binTree2.insertNode(30);
				binTree2.insertNode(45);
				binTree2.treeWalk(node);
				
		/* testcase 3 */
				System.out.println();
				System.out.println("testcase 2_1:");
				BinTree binTree3 = new BinTree();
				binTree3.insertNode(-10);
				binTree3.insertNode(-150);
				binTree3.insertNode(4);
				binTree3.insertNode(300);
				binTree3.insertNode(45);
				binTree3.treeWalk(node);
				binTree3.insertNode(-50);
				binTree3.insertNode(200);
				System.out.println();
				System.out.println("testcase 2_2:");
				binTree3.treeWalk(node);

	}
}
