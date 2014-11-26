package in.sv.datastructure.trees.binaryTree.traversal;

import in.sv.datastructure.stack.LLStack;
import in.sv.datastructure.trees.binaryTree.BinaryTreeNode;

public class InOrderTraversal {

	public void inOrderRecursive(BinaryTreeNode root){
		
		if (root != null){
			inOrderRecursive(root.getLeft());
			System.out.println(root.getData());
			inOrderRecursive(root.getRight());
		}
		
	}
	
	public void inOrderNonRecursive(BinaryTreeNode root){
		if (root == null)
			return;
		LLStack stack = new LLStack();
		while(true){
			while (root!=null){
				stack.push(root);
				root = root.getLeft();				
			}
			if (stack.isEmpty())
				break;
			root = (BinaryTreeNode) stack.pop();
			System.out.println(root.getData());
			root = root.getRight();				
		}
		return;
	}
}
