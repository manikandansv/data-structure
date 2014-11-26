package in.sv.datastructure.trees.binaryTree.traversal;

import in.sv.datastructure.stack.LLStack;
import in.sv.datastructure.trees.binaryTree.BinaryTreeNode;

public class PostOrderTraversal {

	public void postOrderRecursive(BinaryTreeNode root){
		
		if (root != null){
			postOrderRecursive(root.getLeft());
			postOrderRecursive(root.getRight());
			System.out.println(root.getData());
		}
		
	}
	
	public void postOrderNonRecursive(BinaryTreeNode root){
		LLStack stack = new LLStack();
		while(true){
			if (root != null){
				stack.push(root);
				root = root.getLeft();
			}
			else{
				if (stack.isEmpty()){
					System.out.println("Stack is empty");
					return;
				}else{
					BinaryTreeNode currentNode = (BinaryTreeNode) stack.top();
					if (currentNode.getRight() == null){
						root = (BinaryTreeNode) stack.pop();
						System.out.println(root.getData());
						stack.pop();
						if (root == ((BinaryTreeNode)stack.top()).getRight()){
							System.out.println(((BinaryTreeNode)stack.top()).getData());
							stack.pop();
						}
					}
				}
				
				if (!stack.isEmpty()){
					root = ((BinaryTreeNode)stack.top()).getRight();					
				}
				else{
					root = null;
				}
			}
		}
		
	}
	
}
