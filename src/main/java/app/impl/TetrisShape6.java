package app.impl;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import util.Constants;

/*
 * This is a subclass that creates a specific type of tetris shape
 */

public class TetrisShape6 extends TetrisShape {

	public TetrisShape6 (Rectangle[][] array, Pane pane) {

		super(array, pane);
		this.setUpInitialLocation();

	}

	/*
	 * This method is used to set the color and the location of the individual
	 * rectangles for this shape, and add it to the pane
	 */

	public void setUpInitialLocation() {
		this.getRectangle1().setFill(Color.AQUA);
		this.getRectangle2().setFill(Color.AQUA);
		this.getRectangle3().setFill(Color.AQUA);
		this.getRectangle4().setFill(Color.AQUA);
		this.getRectangle1().setX(Constants.TETRIS_SHAPE_LOCATION_SET[20][0]);
		this.getRectangle1().setY(Constants.TETRIS_SHAPE_LOCATION_SET[20][1]);
		this.getRectangle2().setX(Constants.TETRIS_SHAPE_LOCATION_SET[21][0]);
		this.getRectangle2().setY(Constants.TETRIS_SHAPE_LOCATION_SET[21][1]);
		this.getRectangle3().setX(Constants.TETRIS_SHAPE_LOCATION_SET[22][0]);
		this.getRectangle3().setY(Constants.TETRIS_SHAPE_LOCATION_SET[22][1]);
		this.getRectangle4().setX(Constants.TETRIS_SHAPE_LOCATION_SET[23][0]);
		this.getRectangle4().setY(Constants.TETRIS_SHAPE_LOCATION_SET[23][1]);

		this.getPane().getChildren().addAll(this.getRectangle1(), this.getRectangle2(), this.getRectangle3(),
				this.getRectangle4());

	}
	
	
	/*
	 * This method is a shape specific concrete rotation method. It stores the
	 * original center of location for each of the shapes within local variables,
	 * and uses those variables to sequentially rotate the shape
	 */

	@Override
	public void Rotate() {

		double centerOfLocationX = this.getRectangle2().getX();
		double centerOfLocationY = this.getRectangle2().getY();

		double originalLocationX1 = this.getRectangle1().getX();
		double originalLocationY1 = this.getRectangle1().getY();
		double originalLocationX2 = this.getRectangle2().getX();
		double originalLocationY2 = this.getRectangle2().getY();
		double originalLocationX3 = this.getRectangle3().getX();
		double originalLocationY3 = this.getRectangle3().getY();
		double originalLocationX4 = this.getRectangle4().getX();
		double originalLocationY4 = this.getRectangle4().getY();

		this.getRectangle1().setX(centerOfLocationX - centerOfLocationY + originalLocationY1);
		this.getRectangle1().setY(centerOfLocationX + centerOfLocationY - originalLocationX1);
		this.getRectangle2().setX(centerOfLocationX - centerOfLocationY + originalLocationY2);
		this.getRectangle2().setY(centerOfLocationX + centerOfLocationY - originalLocationX2);
		this.getRectangle3().setX(centerOfLocationX - centerOfLocationY + originalLocationY3);
		this.getRectangle3().setY(centerOfLocationX + centerOfLocationY - originalLocationX3);
		this.getRectangle4().setX(centerOfLocationX - centerOfLocationY + originalLocationY4);
		this.getRectangle4().setY(centerOfLocationX + centerOfLocationY - originalLocationX4);
	}

	/*
	 * This method is used to check if a given rotation can occur. It checks the
	 * spot on the array that each rectangle in the shape will be moved to, and if
	 * there is nothing in that space it returns a true value. If there is something
	 * in that space, it returns a false value
	 */

	@Override

	public boolean checkRotationValidity() {

		double centerOfLocationX = this.getRectangle2().getX();
		double centerOfLocationY = this.getRectangle2().getY();

		double originalLocationX1 = this.getRectangle1().getX();
		double originalLocationY1 = this.getRectangle1().getY();
		double originalLocationX2 = this.getRectangle2().getX();
		double originalLocationY2 = this.getRectangle2().getY();
		double originalLocationX3 = this.getRectangle3().getX();
		double originalLocationY3 = this.getRectangle3().getY();
		double originalLocationX4 = this.getRectangle4().getX();
		double originalLocationY4 = this.getRectangle4().getY();

		double newLocationX1 = (centerOfLocationX - centerOfLocationY + originalLocationY1);
		double newLocationY1 = (centerOfLocationX + centerOfLocationY - originalLocationX1);

		double newLocationX2 = (centerOfLocationX - centerOfLocationY + originalLocationY2);
		double newLocationY2 = (centerOfLocationX + centerOfLocationY - originalLocationX2);
		double newLocationX3 = (centerOfLocationX - centerOfLocationY + originalLocationY3);
		double newLocationY3 = (centerOfLocationX + centerOfLocationY - originalLocationX3);
		double newLocationX4 = (centerOfLocationX - centerOfLocationY + originalLocationY4);
		double newLocationY4 = (centerOfLocationX + centerOfLocationY - originalLocationX4);

		if (this.getArray()[(int) (newLocationY1/ Constants.RECTANGLE_SIZE) ][(int) (newLocationX1
				/ Constants.RECTANGLE_SIZE)] == null
				&& this.getArray()[(int) (newLocationY2/ Constants.RECTANGLE_SIZE) ][(int) (newLocationX2
						/ Constants.RECTANGLE_SIZE)] == null
				&& this.getArray()[(int) (newLocationY3/ Constants.RECTANGLE_SIZE) ][(int) (newLocationX3
						/ Constants.RECTANGLE_SIZE)] == null
				&& this.getArray()[(int) (newLocationY4/ Constants.RECTANGLE_SIZE) ][(int) (newLocationX4
						/ Constants.RECTANGLE_SIZE)] == null) {

			return true;

		}
		return false;
	
	
	
	}

}
