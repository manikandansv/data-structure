package in.sv.datastructure.trees.binaryTree.traversal;

import in.sv.datastructure.trees.binaryTree.BinaryTreeNode;

public class InOrderTraversal {

	public void inOrderRecursive(BinaryTreeNode root){
		
		if (root != null){
			inOrderRecursive(root.getLeft());
			System.out.println(root.getData());
			inOrderRecursive(root.getRight());
		}
		
	}
	
}
