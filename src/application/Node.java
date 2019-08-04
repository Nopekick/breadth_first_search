package application;
import java.awt.Graphics;
import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Node extends Circle {
	public boolean visited;
	public int value;
	public ArrayList<Node> neighbors = new ArrayList<Node>();
	private int x;
	private int y;
	
	public Node(int value, int x, int y, Color c) {
		super(x, y, 20.0f, c);
		this.visited = false;
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
	public void visit() {
		this.visited = true;
		this.setFill(Color.BLACK);
	}
	
	public void addNeighbor(Node node) {
		this.neighbors.add(node);
		if(!node.contains(this)) {
			node.addNeighbor(this);
		}
	}
	
	public ArrayList<Node> getNeighbors(){
		return this.neighbors;
	}
	
	public boolean hasBeenVisited() {
		return this.visited;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public boolean contains(Node n) {
		for(Node neighbor : neighbors) {
			if(n.equals(neighbor)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return ""+this.value;
	}
	
	

	
}
