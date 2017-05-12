import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 * Lab 5, CS 2334, Section 010, 21 March 2017
 * <p>
 * Each object of this class represents a GUI input window (MVC view).
 * </p>
 * 
 * @author Dean Hougen
 * @version 2.0
 */
public class SeriesInputWindow extends JFrame {
	/**
	 * Version number to allow for correct serialization. Because this version
	 * will not be binary compatible with the previous version, we have changed
	 * the serialVersionUID for it.
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Button to click to add new episode to the episode list based on filled
	 * text fields.
	 */
	JButton jbtAddEpisode = new JButton("Add Episode");

	/** Button to clear text fields of episode info. */
	JButton jbtClearInput = new JButton("Clear Input Fields");

	/** Button to clear episode list. */
	JButton jbtClearEpisodes = new JButton("Clear Episode List");

	/** TextField to input new episode title. */
	JTextField jtfTitle = new JTextField(20);

	/** Label to mark where the title goes. */
	JLabel lblTitle = new JLabel("Episode Title", JLabel.RIGHT);

	/** TextField to input episode's season number. */
	JTextField jtfSeasonNumber = new JTextField(20);

	/** Label to mark where the season number goes. */
	JLabel lblSeasonNumber = new JLabel("Season Number", JLabel.RIGHT);

	/** TextField to input episode's episode number. */
	JTextField jtfEpisodeNumber = new JTextField(20);

	/** Label to mark where the episode number goes. */
	JLabel lblEpisodeNumber = new JLabel("Episode Number", JLabel.RIGHT);

	/** TextField to input episode's year. */
	JTextField jtfYear = new JTextField(20);

	/** Label to mark where the year goes. */
	JLabel lblYear = new JLabel("Year", JLabel.RIGHT);

	// DONE: Declare variables and create objects for file menu and its contents
	// and for toolbar
	// Make these package private (default) so that they can be directly
	// accessed in SeriesController.

	/** Menu item for loading data. */
	JMenuItem jmiLoad = new JMenuItem("Load");

	/** Menu item for saving data. */
	JMenuItem jmiSave = new JMenuItem("Save");

	/** Menu item for exiting. */
	JMenuItem jmiExit = new JMenuItem("Exit");

	/** File menu (for loading, saving, and exiting.) */
	JMenu jmFile = new JMenu("File");

	/** Menu bar. */
	JMenuBar jmb = new JMenuBar();

	/** Print button for toolbar. */
	JButton jbtPrint = new JButton("Print");

	/** Tool bar. */
	JToolBar jtb = new JToolBar();

	/**
	 * Constructor to create the window by putting all the pieces together and
	 * setting it visible.
	 */
	SeriesInputWindow() {
		setTitle("Add Episodes to Series");

		// TODO: Put menu items in menu, put menu in menu bar, set menu bar.
		jmFile.add(jmiLoad);
		jmFile.add(jmiSave);
		jmFile.add(jmiExit);

		jmb.add(jmFile);

		setJMenuBar(jmb);

		// TODO: Similar for toolbar.
		jtb.add(jbtPrint);

		add(jtb, BorderLayout.NORTH);

		// Create panels for name, season number, episode number, and command
		// buttons
		JPanel jplTitle = new JPanel(new GridLayout(1, 0, 5, 5));
		jplTitle.add(lblTitle);
		jplTitle.add(jtfTitle);

		JPanel jplSeasonNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplSeasonNumber.add(lblSeasonNumber);
		jplSeasonNumber.add(jtfSeasonNumber);

		JPanel jplEpisodeNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplEpisodeNumber.add(lblEpisodeNumber);
		jplEpisodeNumber.add(jtfEpisodeNumber);

		JPanel jplYear = new JPanel(new GridLayout(1, 0, 5, 5));
		jplYear.add(lblYear);
		jplYear.add(jtfYear);

		JPanel jplButton = new JPanel(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtAddEpisode);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtClearEpisodes);

		// Set up the content pane and add all the panels to it.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplTitle);
		add(jplSeasonNumber);
		add(jplEpisodeNumber);
		add(jplYear);
		add(jplButton);
		pack();
		setVisible(true);
	}

	/**
	 * Method to clear the input fields of the window for the user.
	 */
	public void clearInputFields() {
		jtfTitle.setText("");
		jtfSeasonNumber.setText("");
		jtfEpisodeNumber.setText("");
		jtfYear.setText("");
	}

	/**
	 * Method to add a listener to the "Add Episode" button, so that the program
	 * will take appropriate action when the button is pressed.
	 * 
	 * @param addEpisodeListener
	 *            The listener to add to the button.
	 */
	public void addAddEpisodeButtonListener(ActionListener addEpisodeListener) {
		jbtAddEpisode.addActionListener(addEpisodeListener);
	}

	/**
	 * Method to add a listener to the "Clear Episode List" button, so that the
	 * program will take appropriate action when the button is pressed.
	 * 
	 * @param clearEpisodeListener
	 *            The listener to add to the button.
	 */
	public void addClearEpisodesButtonListener(ActionListener clearEpisodeListener) {
		jbtClearEpisodes.addActionListener(clearEpisodeListener);
	}

	/**
	 * Method to add a listener to the "Clear Input Fields" button, so that the
	 * program will take appropriate action when the button is pressed.
	 * 
	 * @param clearInputFieldsListener
	 *            The listener to add to the button.
	 */
	public void addClearInputButtonListener(ActionListener clearInputFieldsListener) {
		jbtClearInput.addActionListener(clearInputFieldsListener);
	}
}