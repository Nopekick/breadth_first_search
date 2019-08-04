package application;
import javafx.scene.shape.Line;

public class DrawLine extends Line {
	public DrawLine(Node one, Node two) {
		setStartX(one.getX());
		setStartY(one.getY());
		setEndX(two.getX());
		setEndY(two.getY());
		
	}
}
