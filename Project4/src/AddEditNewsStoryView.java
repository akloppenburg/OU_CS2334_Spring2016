import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/19
//most fields created by alex 4/19
//fields added/edited by alex 4/25
public class AddEditNewsStoryView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6485249234962550897L;
	
	String[] testValues = {"test1", "test2", "test3"};
	
	/**
	 * 
	 */
	private NewsDataBaseModel newsDataBaseModel;
	
	/**
	 * 
	 */
	private NewsStory newsStory;

	/**
	 * 
	 */
	private JLabel jlbNewsStoryType = new JLabel("Type:");
	
	/**
	 * 
	 */
	JComboBox<NewsMedia> jcbNewsStoryType = new JComboBox<NewsMedia>(NewsMedia.values());
	
	/**
	 * 
	 */
	private JPanel jpNewsStoryType = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStorySource = new JLabel("Source:");
	
	/**
	 * 
	 */
	JComboBox<String> jcbNewsStorySource = new JComboBox<String>(testValues);
	
	/**
	 * 
	 */
	private JPanel jpNewsStorySource = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStoryTopic = new JLabel("Topic:");
	
	/**
	 * 
	 */
	JComboBox<String> jcbNewsStoryTopic = new JComboBox<String>(testValues);
	
	/**
	 * 
	 */
	private JPanel jpNewsStoryTopic = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStorySubject = new JLabel("Subject:");
	
	/**
	 * 
	 */
	JComboBox<String> jcbNewsStorySubject = new JComboBox<String>(testValues);
	
	/**
	 * 
	 */
	private JPanel jpNewsStorySubject = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStoryNewsMaker1 = new JLabel("News Maker 1:");
	
	/**
	 * 
	 */
	JComboBox<String>jcbNewsStoryNewsMaker1 = new JComboBox<String>(testValues);
	
	/**
	 * 
	 */
	private JPanel jpNewsStoryNewsMaker1 = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStoryNewsMaker2 = new JLabel("News Maker 2:");
	
	/**
	 * 
	 */
	JComboBox<String> jcbNewsStoryNewsMaker2 = new JComboBox<String>(testValues);
	
	/**
	 * 
	 */
	private JPanel jpNewsStoryNewsMaker2 = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStoryLength = new JLabel("Length:");
	
	/**
	 * 
	 */
	private NumberFormat integerFieldFormatter = NumberFormat.getNumberInstance();
	
	/**
	 * 
	 */
	JFormattedTextField jftfNewsStoryLength = new JFormattedTextField(integerFieldFormatter);
	
	/**
	 * 
	 */
	private JPanel jplNewsStoryLength = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStoryYear = new JLabel("Year:");
	
	/**
	 * 
	 */
	private Integer[] years = {2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014,
			2015, 2016, 2017};
	
	/**
	 * 
	 */
	JComboBox<Integer> jcbNewsStoryYear = new JComboBox<Integer>(years);
	
	/**
	 * 
	 */
	private JPanel jplNewsStoryYear = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStoryMonth = new JLabel("Month:");
	
	/**
	 * 
	 */
	JComboBox<Month> jcbNewsStoryMonth = new JComboBox<Month>(Month.values());
	
	/**
	 * 
	 */
	private JPanel jplNewsStoryMonth = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStoryDay = new JLabel("Day:");
	
	/**
	 * 
	 */
	private Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
			26, 27, 28, 29, 30, 31};
	
	/**
	 * 
	 */
	JComboBox<Integer>jcbNewsStoryDay = new JComboBox<Integer>(days);
	
	/**
	 * 
	 */
	private JPanel jplNewsStoryDay = new JPanel();
	
	/**
	 * 
	 */
	private JLabel jlbNewsStoryPartOfDay = new JLabel("Part Of Day:");
	
	/**
	 * 
	 */
	JComboBox<PartOfDay> jcbNewsStoryPartOfDay = new JComboBox<PartOfDay>(PartOfDay.values());
	
	/**
	 * 
	 */
	private JPanel jplNewsStoryPartOfDay = new JPanel();
	
	/**
	 * 
	 */
	private JPanel jplNewsStoryWhen = new JPanel();
	
	/**
	 * 
	 */
	JButton jbtAddEditNewsStory = new JButton();
	
	/**
	 * 
	 */
	private JPanel jplAddEditNewsStory = new JPanel();
	
	/**
	 * 
	 * @param newsDataBaseModel
	 * @param newsStoryModel
	 */
	//created by alex 4/19
	//written by alex 4/25 & 4/26
	public AddEditNewsStoryView(NewsDataBaseModel newsDataBaseModel, NewsStory newsStory){
		
		//initialize variables
		this.newsDataBaseModel = newsDataBaseModel;
		this.newsStory = newsStory;
		
		
		//create GUI stuff
		jpNewsStoryType.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jpNewsStoryType.add(jlbNewsStoryType);
		jpNewsStoryType.add(jcbNewsStoryType);
		
		jpNewsStorySource.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jpNewsStorySource.add(jlbNewsStorySource);
		jpNewsStorySource.add(jcbNewsStorySource);
		
		jpNewsStoryTopic.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jpNewsStoryTopic.add(jlbNewsStoryTopic);
		jpNewsStoryTopic.add(jcbNewsStoryTopic);
		
		jpNewsStorySubject.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jpNewsStorySubject.add(jlbNewsStorySubject);
		jpNewsStorySubject.add(jcbNewsStorySubject);
		
		jpNewsStoryNewsMaker1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jpNewsStoryNewsMaker1.add(jlbNewsStoryNewsMaker1);
		jpNewsStoryNewsMaker1.add(jcbNewsStoryNewsMaker1);
		
		jpNewsStoryNewsMaker2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jpNewsStoryNewsMaker2.add(jlbNewsStoryNewsMaker2);
		jpNewsStoryNewsMaker2.add(jcbNewsStoryNewsMaker2);
		
		jplNewsStoryLength.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jplNewsStoryLength.add(jlbNewsStoryLength);
		jplNewsStoryLength.add(jftfNewsStoryLength);
		jftfNewsStoryLength.setEditable(true);
		jftfNewsStoryLength.setColumns(5);
		
		jplNewsStoryYear.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jplNewsStoryYear.add(jlbNewsStoryYear);
		jplNewsStoryYear.add(jcbNewsStoryYear);
		
		jplNewsStoryMonth.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jplNewsStoryMonth.add(jlbNewsStoryMonth);
		jplNewsStoryMonth.add(jcbNewsStoryMonth);
		
		jplNewsStoryDay.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jplNewsStoryDay.add(jlbNewsStoryDay);
		jplNewsStoryDay.add(jcbNewsStoryDay);
		
		jplNewsStoryPartOfDay.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		jplNewsStoryPartOfDay.add(jlbNewsStoryPartOfDay);
		jplNewsStoryPartOfDay.add(jcbNewsStoryPartOfDay);
		
		jplNewsStoryWhen.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		jplNewsStoryWhen.add(jplNewsStoryYear);
		jplNewsStoryWhen.add(jplNewsStoryMonth);
		jplNewsStoryWhen.add(jplNewsStoryDay);
		//TODO test this to make sure it works right
		if(newsStory instanceof TVNewsStory || newsStory instanceof OnlineNewsStory){
			jplNewsStoryWhen.add(jplNewsStoryPartOfDay);
		}
		
		jplAddEditNewsStory.add(jbtAddEditNewsStory);
		
		setLayout(new GridLayout(9, 1, 0, 0));
		add(jpNewsStoryType);
		add(jpNewsStorySource);
		add(jpNewsStoryTopic);
		add(jpNewsStorySubject);
		add(jpNewsStoryNewsMaker1);
		add(jpNewsStoryNewsMaker2);
		add(jplNewsStoryLength);
		add(jplNewsStoryWhen);
		add(jplAddEditNewsStory);
		
		
		
		//if null, you're adding a news story, change fields accordingly
		if(newsStory == null){
			jbtAddEditNewsStory.setText("Add News Story");
			jbtAddEditNewsStory.setActionCommand("Add News Story");
			
		}
		//otherwise, you're editing one, change fields accordingly
		else{
			//Set button name to edit
			jbtAddEditNewsStory.setText("Edit News Story");
			jbtAddEditNewsStory.setActionCommand("Edit News Story");
			//Set all entry fields to their current values
			jcbNewsStoryType.setSelectedItem(newsStory.getClass());	//TODO test this to see if it works right
			jcbNewsStorySource.setSelectedItem(newsStory.getSource());
			jcbNewsStoryTopic.setSelectedItem(newsStory.getTopic());
			jcbNewsStorySubject.setSelectedItem(newsStory.getSubject());
			jcbNewsStoryNewsMaker1.setSelectedItem(newsStory.getNewsMaker1());
			jcbNewsStoryNewsMaker2.setSelectedItem(newsStory.getNewsMaker2());
			jftfNewsStoryLength.setValue(newsStory.getLength());
			jcbNewsStoryYear.setSelectedItem(newsStory.getDate().getYear());
			jcbNewsStoryMonth.setSelectedItem(newsStory.getDate().getMonth());
			jcbNewsStoryDay.setSelectedItem(newsStory.getDate().getDayOfMonth());
			//TODO test this to make sure it works right
			if(newsStory instanceof TVNewsStory){
				jcbNewsStoryPartOfDay.setSelectedItem((TVNewsStory)newsStory);
			}
			if(newsStory instanceof OnlineNewsStory){
				jcbNewsStoryPartOfDay.setSelectedItem(((OnlineNewsStory)newsStory).getPartOfDay());
			}
		}
	}
	
	//TODO main method just for testing, delete later
	public static void main(String[] args){
		
		NewsDataBaseModel test1 = new NewsDataBaseModel();
		NewsStory test2 = null;
		
		JFrame test = new JFrame("Add/Edit News Story");
		test.add(new AddEditNewsStoryView(test1, test2));
		test.pack();
		test.setVisible(true);
		
	}

}
