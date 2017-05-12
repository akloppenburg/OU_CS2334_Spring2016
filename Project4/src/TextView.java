import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/25
//all fields created by alex 4/25
public class TextView implements ActionListener{
	
	/**
	 * 
	 */
	private JFrame jfText = new JFrame("Text View");
	
	/**
	 * 
	 */
	private NewsMakerModel newsMakerModel;
	
	/**
	 * 
	 */
	private List<NewsMedia> newsMedia;
	
	/**
	 * 
	 */
	private List<SortCriterion> sortCriteria;
	
	/**
	 * 
	 */
	private String listOfStories = "test string story list \n\n\n\n\n";
	
	/**
	 * 
	 */
	private String summaryLine = "test string summary line";
	
	/**
	 * 
	 */
	private JTextArea jtaNewsStoryList = new JTextArea(listOfStories);
	
	/**
	 * 
	 */
	private JScrollPane jspNewsStoryList = new JScrollPane(jtaNewsStoryList);
	
	/**
	 * 
	 */
	private JTextArea jtaSummaryLine = new JTextArea(summaryLine);
	
	/**
	 * 
	 * @param newsMakerModel
	 * @param newsMedia
	 * @param sortCriteria
	 */
	//created by alex 4/25
	//graphical part of method body written by alex 4/26
	public TextView(NewsMakerModel newsMakerModel, List<NewsMedia> newsMedia, List<SortCriterion> sortCriteria){
		
		/*fill strings with info, will populate into text fields bc of initializations above.  When initialized,
		 * the Strings are added into their respective JTextAreas an simply need to be added to the JFrame.
		 */
		
		
		//GUI stuff
		//TODO find right layout to make this look good
		this.jfText.setLayout(new GridLayout(2, 1, 0, 0));
		this.jfText.add(jspNewsStoryList);
		this.jfText.add(jtaSummaryLine);
		this.jfText.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jfText.pack();
		this.jfText.setVisible(true);
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void constructNewsStoriesAndSummary(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void constructTitle(){
		
	}
	
	/**
	 * 
	 * @param e
	 */
	//created by alex 4/25
	@Override
	public void actionPerformed(ActionEvent e){
		
	}
	
	//TODO min method just for testing, delete later
	public static void main(String[] args){
		NewsMakerModel test1 = null;
		List<NewsMedia> test2 = NewsMedia.VALUES_LIST;
		List<SortCriterion> test3 = null;
		new TextView(test1, test2, test3);
	}

}
