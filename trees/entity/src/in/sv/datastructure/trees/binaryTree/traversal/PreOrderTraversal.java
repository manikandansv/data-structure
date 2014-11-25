package in.sv.datastructure.trees.binaryTree.traversal;

import in.sv.datastructure.trees.binaryTree.BinaryTreeNode;

public class PreOrderTraversal {

	public void preOrderRecursive(BinaryTreeNode root){
		System.out.println(root.getData());
		preOrderRecursive(root.getLeft());
		preOrderRecursive(root.getRight());
	}
	
	public void preOrderNonRecursive(BinaryTreeNode root){
		
	}
	
	
}
