package application;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.scene.control.Button;

public class Control extends Button {
	Node first;
	int num = 0;
	
	public Control() {
		super("Begin Traversal");
		
		setOnAction((event) -> {
			first.visit();
			LinkedList<Node> frontier = new LinkedList();
			for(Node n: first.neighbors) {
				frontier.offer(n);
			}
			int time = 700;
			while(!frontier.isEmpty()) {
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						Node n = frontier.poll();
						n.visit();
						n.neighbors.forEach((node) -> {
						if(!node.hasBeenVisited()) {
							frontier.offer(node);
									}
						});
					}
				}, time);
				time += 700;
			}
			System.out.println("Graph Traversed");
		});
		
	}
	
	public void setNode(Node node) {
		this.first = node;
	}
}
