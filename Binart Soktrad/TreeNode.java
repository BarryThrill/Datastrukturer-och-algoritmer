
/**
 * 
 * @author Barry Al-Jawari
 *
 */
public class TreeNode {
	private int data;
	private TreeNode left = null;
	private TreeNode right = null;

	/**
	 * Lägger till värdet till data
	 * @param data
	 */
	public TreeNode(int data){
		this.data = data;
	}
	/**
	 * returnerar värdet data
	 * @return
	 */
	public int getData() {
		return data;
	}

	/**
	 * Lägger till värdet till data
	 * @param data
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * Returnerar vänstra noden
	 * @return
	 */
	public TreeNode getLeft() {
		return left;
	}

	/**
	 * Lägger till värdet i vänstra nod
	 * @param left
	 */

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	/**
	 * Returnerar värdet right
	 * @return
	 */

	public TreeNode getRight() {
		return right;
	}
	
	/**
	 * Lägger till värde i högra nod.
	 * @param right
	 */

	public void setRight(TreeNode right) {
		this.right = right;
	}


	public void printTree() {
		if (this.right != null) {
			right.printTree(true, "");
		}
		printNodeValue();
		if (left != null) {
			left.printTree(false, "");
		}
	}

	private void printTree(boolean isRight, String indent) {
		if (right != null) {
			right.printTree(true, indent + (isRight ? "        " : " |      "));
		}
		System.out.print(indent);
		if (isRight) {
			System.out.print(" /");
		} else {
			System.out.print(" \\");
		}
		System.out.print("----- ");
		printNodeValue();
		if (left != null) {
			left.printTree(false, indent + (isRight ? " |      " : "        "));
		}
	}

	private void printNodeValue() {
		System.out.print(data);
		System.out.print('\n');
	}



}
