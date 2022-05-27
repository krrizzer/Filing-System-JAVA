package project3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;



public class test {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		File directoryPath = new File("File");
	      //List of all files and directories
	      String contents[] = directoryPath.list();
	      System.out.println("List of files and directories in the specified directory:");
	      GeneralTree tree = new GeneralTree("File");
	      
	      
	    for(int i=1; i<contents.length; i++) {
	       //  System.out.println(contents[i]);
	         tree.insert("File", contents[i]);
	        // for(int i=0; )
	    }
	    directoryPath = new File("File//Work");
	    contents = directoryPath.list();
	    for(int i=0; i<contents.length; i++) {
		       //  System.out.println(contents[i]);
		         tree.insert("Work", contents[i]);
		        // for(int i=0; )
		    }
		//System.out.println();
	  //  tree.printTree();
		/*GeneralTree tree = new GeneralTree("File");
		
		tree.insert("File", "Work");
		tree.insert("File", "Home");
		tree.insert("File", "System");
		tree.insert("Work", "docs");
		tree.insert("Home", "Music");
		tree.insert("Home", "Pictrues");
		tree.insert("System", "Exe");
		tree.insert("System", "Bat");
		tree.insert("System", "Com");*/
		
		
		
		//	tree.delete("Bat");
		
		
		//	tree.printTree();
		
	//	tree.delete("File");
		
		//tree.search("Work");
	//	tree.printTree();
		
	//	tree.preordercall();
		//tree.postordercall();
		
	//	tree.removeleavescall();
		
	//System.out.println(tree.NumOfFiles());
	//System.out.println(tree.NumOfFolders());
		//tree.printTree();
	//	System.out.println(tree.heightcall());
		//System.out.println(tree.hasChildren("Com"));
		tree.sort();
		tree.printTree();
		//System.out.println(tree.search("Bat"));
		//tree.preordercall();
	
	//	System.out.println(tree.hasChild("Work"));
		//ArrayList<String> ar = new ArrayList<String>();
		//ar.add("A");
		//ar.add("B"); 
		//ar.add("C");
		
		//System.out.println(ar.get(1));
		
		
		
		
	}

	
	

}
