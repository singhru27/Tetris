package util;

/*
 * This class containts constants for the pane size, the size of the rectangles, the size of the offset for each rectangle
 * The initial position for each of the different rectangle shapes, and for the duration of the timeline
 */
public class Constants {

	public static final double PANE_SIZE_X = 608;
	public static final double PANE_SIZE_Y = 912;
	public static final double RECTANGLE_INITIAL_X_POSITION = 0;
	public static final double RECTANGLE_INITIAL_Y_POSITION = 0;
	public static final double RECTANGLE_SIZE = 38;
	public static final double RECTANGLE_OFFSET = 38;
	public static final double DURATION = .20;
	public static final double[][] TETRIS_SHAPE_LOCATION_SET = {
			// Shape 1 Coordinates
			{ 8 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 4 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 5 * Constants.RECTANGLE_OFFSET },

			// Shape 2 Coordinates
			{ 8 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },
			{ 9 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },
			{ 9 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },

			// Shape 3 Coordinates
			{ 8 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 4 * Constants.RECTANGLE_OFFSET },
			{ 9 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },

			// Shape 4 Coordinates
			{ 8 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 4 * Constants.RECTANGLE_OFFSET },
			{ 9 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },

			// Shape 5 Coordinates
			{ 7 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 4 * Constants.RECTANGLE_OFFSET },
			

			// Shape 6 Coordinates
			{ 8 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },
			{ 9 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },
			{ 9 * Constants.RECTANGLE_OFFSET, 4 * Constants.RECTANGLE_OFFSET },

			// Shape 7 Coordinates
			{ 8 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET },
			{ 8 * Constants.RECTANGLE_OFFSET, 4 * Constants.RECTANGLE_OFFSET },
			{ 9 * Constants.RECTANGLE_OFFSET, 2 * Constants.RECTANGLE_OFFSET },
			{ 9 * Constants.RECTANGLE_OFFSET, 3 * Constants.RECTANGLE_OFFSET } };

}
