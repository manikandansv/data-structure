package in.sv.datastructure.trees.binaryTree.traversal;

import in.sv.datastructure.stack.LLStack;
import in.sv.datastructure.trees.binaryTree.BinaryTreeNode;

public class PreOrderTraversal {

	public void preOrderRecursive(BinaryTreeNode root) {
		System.out.println(root.getData());
		preOrderRecursive(root.getLeft());
		preOrderRecursive(root.getRight());
	}

	public void preOrderNonRecursive(BinaryTreeNode root) {
		if (root == null)
			return;
		LLStack stack = new LLStack();
		while (true) {
			while (root != null) {
				Integer data = (Integer) root.getData();
				System.out.println(data);
				stack.push(root);
				root = root.getLeft();				
			}
			if (stack.isEmpty())
				break;
			root = (BinaryTreeNode) stack.pop();
			root = root.getRight();
		}
		return;
	}

}
