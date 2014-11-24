package in.sv.datastructure.trees.binaryTree.traversal;

import in.sv.datastructure.trees.binaryTree.BinaryTreeNode;

public class PostOrderTraversal {

	public void postOrderRecursive(BinaryTreeNode root){
		
		if (root != null){
			postOrderRecursive(root.getLeft());
			postOrderRecursive(root.getRight());
			System.out.println(root.getData());
		}
		
	}
	
}
