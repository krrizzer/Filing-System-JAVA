package project3;

import java.util.Scanner;



public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralTree tree = new GeneralTree("File");
		
		tree.insert("File", "Work");
		tree.insert("File", "Home");
		tree.insert("File", "System");
		tree.insert("Work", "docs");
		tree.insert("Home", "Music");
		tree.insert("Home", "Pictrues");
		tree.insert("System", "Exe");
		tree.insert("System", "Bat");
		tree.insert("System", "Com");
		
	     Scanner scanner = new Scanner(System.in);
	     int choice;
	   
	    
	    do{
	        System.out.println("\nPlease select the operation: ");
	        System.out.println("1. insert");
	        System.out.println("2. search for a file");
	        System.out.println("3. Delete a file");
	        System.out.println("4. Print the whole tree");
	        System.out.println("5. Preorder");
	        System.out.println("6. Postorder");
	        System.out.println("7. PrintNumber of Files");
	        System.out.println("8. PrintNumber of Folders");
	        System.out.println("9. Remove all Files and keeb Folders");
	        System.out.println("10. Check if a folder has files inside it");
	        System.out.println("11. Sort");
	        System.out.println("12. Exit");
	        
	         choice = scanner.nextInt();   
	         if(choice < 1 || choice > 11)   
	              System.out.println("Error: Wrong operation!"); 
	                      
	         
	         else  if( choice ==1 ) {  
	        	 String parent, child = null;
	        	 System.out.println("enter Folder name");
	        	 parent = scanner.next();
	        	 System.out.println("enter the name of the file you want to add");
	        	 child = scanner.next();
	        	 tree.insert(parent,child);
	        	 System.out.println(child + " hass been added to "+ parent);
	        	 }
	         else  if( choice ==2) {
	        	 String child;
	        	 System.out.println("enter name of the file");
	        	 child = scanner.next();
	        	 
	        	 System.out.println( tree.search(child));
	        	 
	         }
	         else     if( choice ==3) {
	        	String child;
	        	System.out.println("insert the File's name");
	        	child = scanner.next();
	        	tree.delete(child);
	        	System.out.println(child+ " has been deleted");
	        	
	         }
	         else     if( choice ==4) {
	        	 tree.printTree();
	         }
	         else   if ( choice == 5) {
	        	tree.preordercall();
	         }
	         else     if(choice == 6) {
	        	tree.postordercall();
	        	 }
	         else     if(choice == 7 ) {
	        	System.out.println("Number of Files = "+ tree.NumOfFiles());
	        	
	         }
	         else    if ( choice == 8)
	        	 System.out.println("Number of Folders = "+ tree.NumOfFolders()); 
	         
	         else    if( choice ==9) {
	        	 tree.removeleavescall();
	        	 	System.out.println("Files has been deleted");
	         }
	         
	         else    if( choice ==10) {
	        	 String parent;
	        	 System.out.println("Enter the name of the file");
	        	 parent = scanner.next();
	        	 
	        	 System.out.println(tree.hasChildren(parent));
	         }
	         else    if( choice ==11) {
	        	 tree.sort();
	        	 System.out.println("Files has been sorted");
	         }
	        	 	
	    }while(choice!=12);
	}

}
