package project3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;


public class GeneralTreeNode<T extends Comparable<? super T>> implements Comparable<GeneralTreeNode>{

 
  private String name;

  private ArrayList<GeneralTreeNode> Children;

  
  
  public GeneralTreeNode() {
    this("default GeneralTreeNode");
  }

  
  public GeneralTreeNode(String name) {
    this.name = name;
    this.Children = new ArrayList<GeneralTreeNode>();
  }

  
  public String getName() {
    return this.name;
  }

  
  public void setName(String name) {
    this.name = name;
  }

 
  public ArrayList<GeneralTreeNode> getChildren() {
    return this.Children;
  }

  
  public GeneralTreeNode addChild(String GeneralTreeNodeName) {
    GeneralTreeNode newGeneralTreeNode = new GeneralTreeNode(GeneralTreeNodeName);
    Children.add(newGeneralTreeNode);
    return newGeneralTreeNode;
  }
  
  public GeneralTreeNode deletes(String GeneralTreeNodeName) {
	    GeneralTreeNode newGeneralTreeNode = new GeneralTreeNode(GeneralTreeNodeName);
	    Children.remove(newGeneralTreeNode);
	    return newGeneralTreeNode;
	    
	  }
  

 
  public void printchildren() {
    for (int i = 0; i < Children.size(); i++) {
      System.out.print(Children.get(i).getName() + " ");
    }
    System.out.println();
  }
  
  
  public <T> void sort() {
	 
	 Collections.sort(Children, (p1, p2) -> p1.getName().compareTo(p2.getName()));
	  
    }


@Override
public int compareTo(GeneralTreeNode arg0) {
	// TODO Auto-generated method stub
	return 0;
}




}


