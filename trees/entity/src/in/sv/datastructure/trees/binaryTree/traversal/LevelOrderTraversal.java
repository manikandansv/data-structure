package in.sv.datastructure.trees.binaryTree.traversal;

import in.sv.datastructure.queue.LLQueue;
import in.sv.datastructure.trees.binaryTree.BinaryTreeNode;

public class LevelOrderTraversal {

	public void levelOrder(BinaryTreeNode root){
		BinaryTreeNode temp;
		LLQueue queue = new LLQueue();
		if (root == null)
			return;
		queue.enQueue(root);
		while (!queue.isEmpty()){
			temp = (BinaryTreeNode) queue.deQueue();
			System.out.println(temp.getData());
			if (temp.getLeft() != null)
				queue.enQueue(temp.getLeft());
			if (temp.getRight() != null)
				queue.enQueue(temp.getRight());
		}
	}
	
}
