package project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GeneralTree<T extends Comparable<? super T>> {
	private GeneralTreeNode root;

	public GeneralTree() {
		this("default");
	}

	public GeneralTree(String rootGeneralTreeNodeName) {// Q1.a
		root = new GeneralTreeNode(rootGeneralTreeNodeName);
	}

	public GeneralTreeNode ToNode(String NodeName) { // turns a string to a node

		return ToNode(root, NodeName);
	}

	private GeneralTreeNode ToNode(GeneralTreeNode root, String NodeName) {

		GeneralTreeNode searchedGeneralTreeNode = null;

		boolean found = false;

		if (root != null) {
			if (root.getName().equals(NodeName)) {

				searchedGeneralTreeNode = root;
			} else {

				for (int i = 0; i < root.getChildren().size() && !found; i++) {
					searchedGeneralTreeNode = ToNode((GeneralTreeNode) root.getChildren().get(i), NodeName);
					if (searchedGeneralTreeNode != null) {

						found = true;
					}
				}
			}
		}
		return searchedGeneralTreeNode;
	}

	public GeneralTreeNode insert(String parent, String Child) {// Q1.b
		GeneralTreeNode parentNode = ToNode(parent);
		GeneralTreeNode ChildNode = ToNode(Child);

		if (parentNode != null && ChildNode == null) {
			ChildNode = parentNode.addChild(Child);
		} else {
			ChildNode = null;
			if (parentNode == null) {
				System.out.println("Parent doesn't exist");
			} else {
				System.out.println("this file is already in the folder");
			}
		}
		return ChildNode;
	}

	public String search(String string) {
		GeneralTreeNode myNode = ToNode(string);
		return search(root, myNode);
	}

	public String search(GeneralTreeNode root1, GeneralTreeNode myNode) { // Q1.c
		String path = "";
		try {
			if (root1.getChildren().isEmpty()) {
				return "";
			}
			if (root1.getChildren().contains(myNode)) {
				path = root1.getName() + "-->" + myNode.getName();
			} else if (!root1.getChildren().contains(myNode)) {
				int i = 0;
				while (!(path.contains(myNode.getName())) && i < root1.getChildren().size()) {
					path = root1.getName() + "-->" + search((GeneralTreeNode) root1.getChildren().get(i), myNode);
					i++;
				}
			}

		} catch (NullPointerException e) {
			System.out.println("NullPointerException thrown!,,, File doesn't exsist !");
		}

		return path;

	}

	public void delete(String Node) {

		GeneralTreeNode deletedNode = ToNode(Node);
		if (deletedNode == root) {
			root.getChildren().clear();
			root.setName("");
			System.out.println("Whole tree is deleted!");
		}
		delete(deletedNode, root);

	}

	public void delete(GeneralTreeNode deletedNode, GeneralTreeNode root) {

		if (root.getChildren().contains(deletedNode))
			root.getChildren().remove(deletedNode);
		else {
			for (int i = 0; i < root.getChildren().size(); i++) {
				delete(deletedNode, (GeneralTreeNode) root.getChildren().get(i));
			}
		}
	}

	public void printTree() {

		printTree(0, root);
	}

	private void printTree(int level, GeneralTreeNode root) {

		if (root != null) {
			if (level > 0) {

				for (int i = 0; i < level; i++) {

					System.out.print(" ");
				}

				System.out.print("|_");
			}

			System.out.println(root.getName());
			for (int j = 0; j < root.getChildren().size(); j++) {

				printTree(level + 1, (GeneralTreeNode) root.getChildren().get(j));
			}
		}
	}
	
	public void sort() {// Q2

		root.sort();

	}

	public void preordercall() {
		preorder(root);
		System.out.println(".");
	}

	private void preorder(GeneralTreeNode node) {
		System.out.print(node.getName() + " ");
		for (int i = 0; i < node.getChildren().size(); i++)
			preorder((GeneralTreeNode) node.getChildren().get(i));
	}

	public void postordercall() {
		postorder(root);
		System.out.println(".");
	}

	private void postorder(GeneralTreeNode node) {
		for (int i = 0; i < node.getChildren().size(); i++)
			postorder((GeneralTreeNode) node.getChildren().get(i));
		System.out.print(node.getName() + " ");
	}

	public int NumOfFolders() {
		return NumOfFolders(root);
	}

	public int NumOfFolders(GeneralTreeNode node) {
		int num = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < node.getChildren().size(); i++) {
			if (((GeneralTreeNode) node.getChildren().get(i)).getChildren().size() == 0) {
				arr.add(i);
				// node.getChildren().remove(i);
				// i--;
			} else
				removeleaves((GeneralTreeNode) node.getChildren().get(i));
		}
		for (int i = arr.size() - 1; i >= 0; i--) {
			node.getChildren().remove(arr.get(i) + 0);

		}
		if (node.getChildren().size() != 0) {
			num = node.getChildren().size();
		}

		return num;
	}

	public int NumOfFiles() {
		return NumOfFiles(root);
	}

	public static int NumOfFiles(GeneralTreeNode root) {

		int leaves = 0;
		if (root == null) {

			return 0;
		}
		if (root.getChildren().isEmpty()) {

			return 1;
		}

		for (int i = 0; i < root.getChildren().size(); i++) {

			leaves += NumOfFiles((GeneralTreeNode) root.getChildren().get(i));
		}

		return leaves;
	}

	// ------------------------------------- Extra methods for fun-------------------------------------------------------
	public void removeleavescall() {
		removeleaves(root);
	}

	private void removeleaves(GeneralTreeNode node) {

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < node.getChildren().size(); i++) {
			if (((GeneralTreeNode) node.getChildren().get(i)).getChildren().size() == 0) {
				arr.add(i);
				// node.getChildren().remove(i);
				// i--;
			} else
				removeleaves((GeneralTreeNode) node.getChildren().get(i));
		}
		for (int i = arr.size() - 1; i >= 0; i--) {
			node.getChildren().remove(arr.get(i) + 0);

		}
		if (node.getChildren().size() != 0) {

		}

	}

	public String hasChildren(String string) {
		GeneralTreeNode Node = ToNode(string);

		if (Node.getChildren().isEmpty()) {
			return "The folder ( " + string + " ) does not have files in it :(";
		} else
			return "The folder (" + string + ") has files inside it";

	}

}