

import java.util.ArrayList;	

public class Node extends Move{
		
		
	private Node parent;
	private ArrayList<Node> children = new ArrayList<Node>();
	
	public Node(  ){
		
	}
	
	public Node ( Node parent, Move move ){
		this.parent = parent;
		super.set(move);
	}
	
	public void addChild(Node node){
		this.children.add( node );
	}
	
	public Node getParent(){
		return this.parent;
	}
	
	public void setParent( Node node ){
		this.parent = node;
	}
	
	public ArrayList< Node > getChildren(){
		return this.children;
	}
}