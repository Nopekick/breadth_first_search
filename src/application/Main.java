package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,850,780);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Breadth First Search JavaFX");
			primaryStage.show();
			
			Control control = new Control();
			root.setTop(control);
			initNodes(root, control);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void initNodes(BorderPane r, Control c) {
		ArrayList<DrawLine> lines = new ArrayList();
		ArrayList<Node> nodes = new ArrayList();
		Node node1 = new Node(1, 300, 200, Color.STEELBLUE); nodes.add(node1);
		Node node2 = new Node(2, 100, 200, Color.AQUAMARINE); nodes.add(node2);
		Node node3 = new Node(3, 750, 150, Color.BLUE); nodes.add(node3);
		Node node4 = new Node(4, 100, 600, Color.DEEPPINK); nodes.add(node4);
		Node node5 = new Node(5, 50, 700, Color.OLIVEDRAB); nodes.add(node5);
		Node node6 = new Node(6, 400, 50, Color.CADETBLUE); nodes.add(node6);
		Node node7 = new Node(7, 450, 550, Color.DARKCYAN); nodes.add(node7);
		Node node8 = new Node(8, 600, 600, Color.DARKGREEN); nodes.add(node8);
		Node node9 = new Node(9, 350, 600, Color.DARKGOLDENROD); nodes.add(node9);
		Node node10 = new Node(10, 300, 740, Color.DARKMAGENTA); nodes.add(node10);
		Node node11 = new Node(11, 300, 500, Color.GREEN); nodes.add(node11);
		Node node12 = new Node(12, 200, 600, Color.HOTPINK); nodes.add(node12);
		Node node13 = new Node(13, 200, 200, Color.DODGERBLUE); nodes.add(node13);
		Node node14 = new Node(14, 20, 300, Color.PEACHPUFF); nodes.add(node14);
		Node node15 = new Node(15, 200, 700, Color.CRIMSON); nodes.add(node15);
		
		node1.addNeighbor(node13); node1.addNeighbor(node6); node1.addNeighbor(node11);
		node13.addNeighbor(node2); node13.addNeighbor(node11);
		node6.addNeighbor(node3);
		node3.addNeighbor(node8); node3.addNeighbor(node7);
		node8.addNeighbor(node9); node8.addNeighbor(node15);
		node15.addNeighbor(node12); node15.addNeighbor(node4); node15.addNeighbor(node5);
		node5.addNeighbor(node10); node15.addNeighbor(node14);
		node14.addNeighbor(node2); node14.addNeighbor(node9);
		
		printNeighbors(nodes);
		
		nodes.forEach((node) -> {
			node.neighbors.forEach((neighbor) -> {
				DrawLine temp = new DrawLine(node, neighbor);
				lines.add(temp);
			});
		});
		
		lines.forEach((line) -> {
			r.getChildren().add(line);
		});
		
		c.setNode(node1);
		r.getChildren().addAll(node1, node2, node3, node4, node5, node6, 
				node7, node8, node9, node10, node11, node12, node13, node14, node15);
		
	}
	
	public static void printNeighbors(ArrayList<Node> nodes) {
		nodes.forEach((node) -> {
			System.out.print(node);
			System.out.println(node.getNeighbors());
		});
	}
}

