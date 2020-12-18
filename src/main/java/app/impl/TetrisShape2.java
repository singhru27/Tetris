package app.impl;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import util.Constants;

/*
 * This is a subclass that creates a specific type of tetris shape
 */

public class TetrisShape2 extends TetrisShape {

	public TetrisShape2(Rectangle[][] array, Pane pane) {

		super(array, pane);
		this.setUpInitialLocation();

	}

	/*
	 * This method is used to set the color and the location of the individual
	 * rectangles for this shape, and add it to the pane
	 */

	public void setUpInitialLocation() {
		this.getRectangle1().setFill(Color.PURPLE);
		this.getRectangle2().setFill(Color.PURPLE);
		this.getRectangle3().setFill(Color.PURPLE);
		this.getRectangle4().setFill(Color.PURPLE);
		this.getRectangle1().setX(Constants.TETRIS_SHAPE_LOCATION_SET[4][0]);
		this.getRectangle1().setY(Constants.TETRIS_SHAPE_LOCATION_SET[4][1]);
		this.getRectangle2().setX(Constants.TETRIS_SHAPE_LOCATION_SET[5][0]);
		this.getRectangle2().setY(Constants.TETRIS_SHAPE_LOCATION_SET[5][1]);
		this.getRectangle3().setX(Constants.TETRIS_SHAPE_LOCATION_SET[6][0]);
		this.getRectangle3().setY(Constants.TETRIS_SHAPE_LOCATION_SET[6][1]);
		this.getRectangle4().setX(Constants.TETRIS_SHAPE_LOCATION_SET[7][0]);
		this.getRectangle4().setY(Constants.TETRIS_SHAPE_LOCATION_SET[7][1]);

		this.getPane().getChildren().addAll(this.getRectangle1(), this.getRectangle2(), this.getRectangle3(),
				this.getRectangle4());

	}

	/*
	 * This method is a shape specific concrete rotation method. It stores the
	 * original center of location for each of the shapes within local variables,
	 * and uses those variables to sequentially rotate the shape. Since this shape
	 * does not rotate the method is void
	 */

	@Override
	public void Rotate() {

	}

	/*
	 * This method is used to check if a given rotation can occur. It checks the
	 * spot on the array that each rectangle in the shape will be moved to, and if
	 * there is nothing in that space it returns a true value. If there is something
	 * in that space, it returns a false value. Since this shape never rotates, the
	 * method always returns a value of false
	 */

	@Override

	public boolean checkRotationValidity() {

		return false;

	}

}
