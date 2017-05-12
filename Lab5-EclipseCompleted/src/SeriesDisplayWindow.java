import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Lab 4, CS 2334, Section 010, 07 March 2017
 * <P>
 * Each object of this class represents a GUI display window (MVC view).
 * </P>
 * 
 * @author Dean Hougen
 * @version 1.0
 */
public class SeriesDisplayWindow extends JFrame implements ActionListener {
	/** Version number to allow for correct serialization. */
	private static final long serialVersionUID = 1L;

	/**
	 * The Java Swing component for GUI lists. This one will be a list of
	 * Episodes.
	 */
	private JList<Episode> displayEpisodeList;

	/** A reference to our MVC model. */
	private SeriesModel model;

	/**
	 * Constructor to create a series display window.
	 */
	public SeriesDisplayWindow() {
		// intentionally empty
	}

	/**
	 * Method to respond when an event happens. All listeners should override
	 * this method to take appropriate action based on their type.
	 * 
	 * @param e
	 *            The action event for which we were listening.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		displayEpisodeList.setListData(model.getEpisodeArray());
		pack();
	}

	/**
	 * Mutator method that sets the model for this view.
	 * 
	 * @param model
	 *            The model that holds the data we want to display.
	 */
	public void setModel(SeriesModel model) {
		this.model = model;

		if (model != null) {
			model.addActionListener(this);
			setTitle("Episodes in " + model.getTitle() + " (" + model.getStartYear() + ")");
			add(new JLabel("Episode Title (Season Number, Episode Number) Year"), BorderLayout.NORTH);
			displayEpisodeList = new JList<Episode>(model.getEpisodeArray());
			add(displayEpisodeList, BorderLayout.CENTER);
			pack();
			setVisible(true);
		}
	}
}