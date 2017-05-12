/**
 * Lab 5 CS 2334, Section 010, 21 March 2017
 * <p>
 * This program allows information on episodes for the original Star Trek series
 * to be entered through a GUI window and adds each to a list, and displays the
 * episode list in a second GUI window. Note that the classes are quite simple,
 * sometimes using String when another data type would be more appropriate,
 * because the focus of this lab is GUI's and event handling. Also, some data is
 * hard coded that should be input.
 * </p>
 * 
 * @author Dean Hougen
 * @version 2.0
 */

public class Lab5Driver {
	/** The MVC model for our program. */
	static SeriesModel theSeriesModel = new SeriesModel("Star Trek", 1966, 1969);

	/** An MVC view allowing for user input. */
	static SeriesInputWindow theInputWindow = new SeriesInputWindow();

	/** An MVC view for displaying data to user. */
	static SeriesDisplayWindow theDisplayWindow = new SeriesDisplayWindow();

	/** The MVC controller for our program. */
	static SeriesController theController = new SeriesController();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Any view displaying data from the model to the user needs to know
		// about the model.
		theDisplayWindow.setModel(theSeriesModel);

		// Any controller sending updates to the model needs to know about the
		// model.
		theController.setModel(theSeriesModel);

		// Any controller interacting with a view needs to know about that view.
		theController.setInputWindow(theInputWindow);
	}
}
