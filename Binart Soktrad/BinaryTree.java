


/**
 * 
 * @author Barry Al-Jawari
 *
 */
public class BinaryTree {
	private static TreeNode root;
	private int size;

	/**
	 * Metoden skall först kolla om det finns en root. Om det inte finns så skall det
	 * skapa en ny treenode som är rotens data och om det finns en root så kallar man
	 * på insert som har värdet data som parameter
	 * @param data
	 */
	public void add(int data){
		if(root == null){
			this.root = new TreeNode(data);
		} else {
			insert(root, new TreeNode(data));
		}
	}

	/**
	 * Main metoden där man lägger till själv siffor som skall
	 * vara med i trädet. 
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();

		//FÃ¶r underlÃ¤tta sÃ¥ anvÃ¤nde jag mig detta och matade in egna siffror direkt hÃ¤r.
		bTree.add(15); bTree.add(5); bTree.add(3); bTree.add(4); bTree.add(6); bTree.add(61);
		bTree.add(62); bTree.add(63); bTree.add(25); bTree.add(26); bTree.add(10); bTree.add(8);
		bTree.add(14); bTree.add(12); bTree.add(11); bTree.add(13); bTree.add(2); bTree.add(3);
		bTree.add(1); bTree.add(99); bTree.add(101); bTree.add(100); bTree.root.printTree();

		System.out.println("\n-----------------------------------\n");

		bTree.delete(10); bTree.delete(99); bTree.delete(15); bTree.delete(100); bTree.delete(13);
		bTree.delete(6); bTree.delete(3); bTree.delete(1); bTree.delete(2); bTree.delete(61);
		bTree.delete(62); bTree.delete(63); bTree.root.printTree();
		
		
		System.out.println();
		System.out.println();
		System.out.print("Ordning: ");
		inOrderPrint(root);

	}

	/**
	 * Först så gör metoden att den jämför current och newNode. Om newnode värde är större än
	 * current så kollar den ifall currents högra sida är null, om det är det så blir currents
	 * högra sida nya newNode. Annars om den inte är null så kallar den på insert metoden
	 * med currents högra sida värde som då blir den nya värdet för current.
	 * Sedan om newNode värde mindre än current så gör de samma process fast motsats sida.
	 * Och tillslut om det redan finns ett newNode i vår träd så kommer den att returneras.
	 * @param current
	 * @param newNode
	 * @return
	 */
	
	public int findHeight(TreeNode aNode) {
		if (aNode == null) {
			return -1;
		}
		int left = findHeight(aNode.getLeft());
		int rigth = findHeight(aNode.getRight());

		if (left > rigth) {
			return left + 1;
		} else {
			return rigth + 1;
		}
	}
	
	
	public void insert(TreeNode current, TreeNode newNode) {
		addValue(current, newNode);
		int heightNode = (findHeight(root.getLeft()) - (findHeight(root
				.getRight())));
		
	}


	/**
	 * I denna metoden kollar den om dataToFind är större än current så tar man ett steg
	 * till höger annars om inte så vänster sida tills den hittar värdet i dataToFind som 
	 * vidare kommer att returneras.
	 * @param current
	 * @param dataToFind
	 * @return
	 */

	public TreeNode addValue(TreeNode current, TreeNode newNode) {
		// Searches for higher integers then the current through the tree
		if (newNode.getData() > current.getData()) {
			if (current.getRight() != null) {
				this.addValue(current.getRight(), newNode);
			} else if (current.getRight() == null) {
				current.setRight(newNode);
			}
		}
		// Searches for lower integers then the current through the tree
		else if (newNode.getData() < current.getData()) {
			if (current.getLeft() != null) {
				this.addValue(current.getLeft(), newNode);
			} else if (current.getLeft() == null) {
				current.setLeft(newNode);
			}
		}
		// Value is already in the tree
		else if (newNode.getData() == current.getData()) {
			// JOptionPane.showMessageDialog(null, "Value already in Tree");
		}
		return current;
	}
	
	public TreeNode find(TreeNode current, int dataToFind) {
		if (current == null) {
			return null;
		}
		TreeNode foundNode = null;
		if (current.getData() == dataToFind) {
			foundNode = current;
		} else if (current.getData() > dataToFind) {
			foundNode = find(current.getLeft(), dataToFind);
		} else if (current.getData() < dataToFind) {
			foundNode = find(current.getRight(), dataToFind);
		}
		return foundNode;
	}

	/**
	 * Denna metoden kollar upp får noden som sedan blir tilldelad den nya värdet root
	 * får att förenkla det till metoden TreeNode remove.
	 * @param data
	 */
	public void delete(int data) {
		root = remove(root, data);
	}

	/**
	 *	Metoden här kollar efter noden som skall tas bort. Den är väldigt likt som vi har haft
	 * både med Find metoden och insert metoden. då den kollar om datatoRemove är större än current
	 * då går dne till vänster annars tvärt om. Sedan går den höger sida ifall den är mindre än current
	 * Om noden inte hittas så returneras null värde. Om det har hittats så letar den efter sucessor
	 * till noden.
	 * @param current
	 * @param dataToRemove
	 * @return
	 */
	private TreeNode remove(TreeNode current, int dataToRemove) {
		if (current == null) {
			return null;
		} else {
			if (current.getData() > dataToRemove) {
				current.setLeft(remove(current.getLeft(), dataToRemove));
			} 
			else if (current.getData() < dataToRemove) {
				current.setRight(remove(current.getRight(), dataToRemove));
			} 
			else if (current.getData() == dataToRemove) {
				TreeNode successor = null;
				TreeNode successorChild = null;
				TreeNode rightChild = current.getRight();
				TreeNode rightNode = current.getRight();
				TreeNode leftChild = current.getLeft();
				
				if (current.getLeft() == null && current.getRight() != null) {
					if(rightChild.getLeft() == null) {
						current.setRight(rightChild.getRight());
						current = rightChild;
						
						return current;
					}
					else while(rightChild.getLeft() != null) {
						rightChild = rightChild.getLeft();
						if(rightChild.getLeft() == null) {
							successor = rightChild;
							if(successor.getRight() != null) {
								successorChild = successor.getRight();
							}
						}
					}
				}
				
				else if(current.getRight() == null) {
					return current.getLeft();
					
				}
				else if(current.getLeft() == null && current.getRight() == null) {
					return current.getRight();
				}
				
				else if (current.getLeft() != null && current.getRight() != null) {
					if(rightChild.getLeft() == null) {
						current.setRight(rightChild.getRight());
						current = rightChild;
						current.setLeft(leftChild);
						return current;
					}
					else while(rightChild.getLeft() != null) {
					rightChild = rightChild.getLeft();
					if(rightChild.getLeft() == null) {
						successor = rightChild;
						if(successor.getRight() != null) {
							successorChild = successor.getRight();;
						}
					}
				}
				}
				while(rightNode.getLeft() != successor) {
					rightNode = rightNode.getLeft();
				}
				current.setData(successor.getData());
				if(successorChild != null) {
					successor.setData( successorChild.getData());
					successor.setRight(null);
				}
				else {
					rightNode.setLeft(null);
				}
			}
		return current;
		}
	}

	/**
	 * Den här metoden kollar upp efter sucessor för current. Om den har hittat så skall
	 * den returneras succesor på högra subträdets vänstraste nod.
	 * @param current
	 * @return
	 */
	private TreeNode findSuccessor(TreeNode current) {
		if(current == null){
			return null;
		}
		findSuccessor(current.getLeft());
		return current;
	}
	
	/**
	 * Skriver ut order som finns i noderna
	 * @param current
	 * @return
	 */
	public static TreeNode inOrderPrint(TreeNode current){
		if(current==null){
			return null;
		}
		inOrderPrint(current.getLeft());
		System.out.print(current.getData() + " ");
		inOrderPrint(current.getRight());
		return current;
	}

}
