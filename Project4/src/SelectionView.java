import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

//TODO write methods
//TODO once he releases more UML make sure this code is right
//TODO read through comments to ensure accuracy
//TODO write Javadoc

/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/21
//all fields added by alex 4/22
public class SelectionView extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1688233997759941058L;
	
	/**
	 * 
	 */
	private NewsDataBaseModel newsDataBaseModel;

	/**
	 * 
	 */
	private JMenuBar jmb;
	
	/**
	 * 
	 */
	private JMenu jmFile;
	
	/**
	 * 
	 */
	private JMenuItem jmiLoad;
	
	/**
	 * 
	 */
	private JMenuItem jmiSave;
	
	/**
	 * 
	 */
	private JMenuItem jmiImport;
	
	/**
	 * 
	 */
	private JMenuItem jmiExport;
	
	/**
	 * 
	 */
	private JMenu jmNewsMaker;
	
	/**
	 * 
	 */
	private JMenuItem jmiAddNewsMaker;
	
	/**
	 * 
	 */
	private JMenuItem jmiEditNewsMaker;
	
	/**
	 * 
	 */
	private JMenuItem jmiDeleteNewsMaker;
	
	/**
	 * 
	 */
	private JMenuItem jmiDeleteNewsMakerList;
	
	/**
	 * 
	 */
	private JMenu jmNewsStory;
	
	/**
	 * 
	 */
	private JMenuItem jmiAddNewsStory;
	
	/**
	 * 
	 */
	private JMenuItem jmiEditNewsStory;
	
	/**
	 * 
	 */
	private JMenuItem jmiSortNewsStories;
	
	/**
	 * 
	 */
	private JMenuItem jmiDeleteNewsStory;
	
	/**
	 * 
	 */
	private JMenuItem jmiDeleteAllNewsStories;
	
	/**
	 * 
	 */
	private JMenu jmDisplay;
	
	/**
	 * 
	 */
	private JMenuItem jmiPieChart;
	
	/**
	 * 
	 */
	private JMenuItem jmiText;
	
	/**
	 * 
	 */
	private JList<NewsMakerModel> jlNewsMakerList;
	
	/**
	 * 
	 */
	private JScrollPane jspNewsMakerList;
	
	/**
	 * 
	 */
	private JPanel jpNewsMakerList;
	
	/**
	 * 
	 */
	private JList<NewsStory> jlNewsStoryList;
	
	/**
	 * 
	 */
	private JScrollPane jspNewsStoryList;
	
	/**
	 * 
	 */
	private JPanel jpNewsStoryList;
	
	/**
	 * 
	 */
	private JSplitPane splitPane;

	/**
	 * 
	 */
	//written by alex 4/16 in an attempt to mimic posted screenshot
	//added to class by alex 4/21
	//heavily edited by alex 4/22 to use class variables instead of method ones
	public SelectionView(){
	
		//File menu creation
		jmFile = new JMenu("File");
		jmiLoad = new JMenuItem("Load");
		jmiSave = new JMenuItem("Save");
		jmiImport = new JMenuItem("Import");
		jmiExport = new JMenuItem("Export");
		//File menu construction
		jmFile.add(jmiLoad);
		jmFile.add(jmiSave);
		jmFile.add(jmiImport);
		jmFile.add(jmiExport);
		//Set appropriate buttons inactive initially
		jmiSave.setEnabled(false);
		jmiExport.setEnabled(false);
		//Add methods here to turn buttons active when something happens
		
		
		//Newsmakers menu creation
		jmNewsMaker = new JMenu("Newsmakers");
		jmiAddNewsMaker = new JMenuItem("Add Newsmaker");
		jmiEditNewsMaker = new JMenuItem("Edit Newsmaker");
		jmiDeleteNewsMaker = new JMenuItem("Delete Newsmaker");
		jmiDeleteNewsMakerList = new JMenuItem("Delete Newsmaker List");
		//Newsmakers menu construction
		jmNewsMaker.add(jmiAddNewsMaker);
		jmNewsMaker.add(jmiEditNewsMaker);
		jmNewsMaker.add(jmiDeleteNewsMaker);
		jmNewsMaker.add(jmiDeleteNewsMakerList);
		//Set appropriate buttons inactive initially
		jmiEditNewsMaker.setEnabled(false);
		jmiDeleteNewsMaker.setEnabled(false);
		jmiDeleteNewsMakerList.setEnabled(false);
		//Add methods here to turn buttons active when something happens
		
		
		//News Stories menu creation
		jmNewsStory = new JMenu("News Stories");
		jmiAddNewsStory = new JMenuItem("Add News Story");
		jmiEditNewsStory = new JMenuItem("Edit News Story");
		jmiSortNewsStories = new JMenuItem("Sort News Stories");
		jmiDeleteNewsStory = new JMenuItem("Delete News Story");
		jmiDeleteAllNewsStories = new JMenuItem("Delete All News Stories");
		//News stories menu construction
		jmNewsStory.add(jmiAddNewsStory);
		jmNewsStory.add(jmiEditNewsStory);
		jmNewsStory.add(jmiSortNewsStories);
		jmNewsStory.add(jmiDeleteNewsStory);
		jmNewsStory.add(jmiDeleteAllNewsStories);
		//Set appropriate buttons inactive initially
		jmiEditNewsStory.setEnabled(false);
		jmiSortNewsStories.setEnabled(false);
		jmiDeleteNewsStory.setEnabled(false);
		jmiDeleteAllNewsStories.setEnabled(false);
		//Add methods here to turn buttons active when something happens
		
		
		//Display menu creation
		jmDisplay = new JMenu("Display");
		jmiPieChart = new JMenuItem("Pie Chart");
		jmiText = new JMenuItem("Text");
		//Display menu construction
		jmDisplay.add(jmiPieChart);
		jmDisplay.add(jmiText);
		//Set appropriate buttons inactive initially
		jmiPieChart.setEnabled(false);
		jmiText.setEnabled(false);
		//Add methods here to turn buttons active when something happens
		
		
		//Menubar creation
		jmb = new JMenuBar();
		//Menubar construction
		jmb.add(jmFile);
		jmb.add(jmNewsMaker);
		jmb.add(jmNewsStory);
		jmb.add(jmDisplay);
		
		
		//NewsMakers scroll pane creation & construction
		//TODO figure out how to get rid of this JLabel
		JLabel jlNewsmakers = new JLabel("Newsmakers");
		jlNewsMakerList = new JList<NewsMakerModel>(); //should be a class variable so that we can put stuff in it
		jspNewsMakerList = new JScrollPane(jlNewsMakerList);
		//Create a JPanel
		jpNewsMakerList = new JPanel();
		//Make layout for jpNewsMakerList and create a GridBagConstraints object to set layout constraints
		jpNewsMakerList.setLayout(new GridBagLayout());
		GridBagConstraints cNM = new GridBagConstraints();
		//this code puts the label in the top left of the panel
		cNM.anchor = GridBagConstraints.NORTHWEST;
		cNM.weightx = 0;
		cNM.weighty = 0;
		cNM.gridx = 0;
		cNM.gridy = 0;
		jpNewsMakerList.add(jlNewsmakers, cNM);
		/*This code puts the scrolling list directly underneath the label and allows it to resize
		 * itself horizontally/vertically
		 */
		cNM.fill = GridBagConstraints.BOTH;
		cNM.weightx = 1;
		cNM.weighty = 1;
		cNM.gridx = 0;
		cNM.gridy = 1;
		jpNewsMakerList.add(jspNewsMakerList, cNM);
		
		
		//News Stories scroll pane creation & construction
		//TODO figure out how to get rid of this JLabel
		JLabel jlNewsStories = new JLabel("News Stories");
		jlNewsStoryList = new JList<NewsStory>(); //should be a class variable so that we can put stuff in it
		jspNewsStoryList = new JScrollPane(jlNewsStoryList);
		//Create a JPanel
		jpNewsStoryList = new JPanel();
		//Make layout for newsStoriesPanel and create a GridBagConstraints object to set layout constraints
		jpNewsStoryList.setLayout(new GridBagLayout());
		GridBagConstraints cNS = new GridBagConstraints();
		//this code puts the label in the top left of the panel
		cNS.anchor = GridBagConstraints.NORTHWEST;
		cNS.weightx = 0;
		cNS.weighty = 0;
		cNS.gridx = 0;
		cNS.gridy = 0;
		jpNewsStoryList.add(jlNewsStories, cNS);
		/*This code puts the scrolling list directly underneath the label and allows it to resize
		 * itself horizontally/vertically
		 */
		cNS.fill = GridBagConstraints.BOTH;
		cNS.weightx = 1;
		cNS.weighty = 1;
		cNS.gridx = 0;
		cNS.gridy = 1;
		jpNewsStoryList.add(jspNewsStoryList, cNS);
		
		
		//puts the two JPanels into a single JPanel with a GridLayout to get easier spacing
		//Credit: Cavan Gary for the idea
		splitPane = new JSplitPane();
		splitPane.setLeftComponent(jpNewsMakerList);
		splitPane.setRightComponent(jpNewsStoryList);
		
		
		//Main window construction
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Nooz");
		setJMenuBar(jmb);
		add(splitPane);
		pack();
		setVisible(true);
	
	}
	
	/**
	 * 
	 * @param fileMenuListener
	 */
	//created by alex 4/22
	public void registerFileMenuListener(ActionListener fileMenuListener){
		
	}
	
	/**
	 * 
	 * @param newsMakerMenuListener
	 */
	//created by alex 4/22
	public void registerNewsMakerMenuListener(ActionListener newsMakerMenuListener){
		
	}
	
	/**
	 * 
	 * @param newsStoryMenuListener
	 */
	//created by alex 4/22
	public void registerNewsStoryMenuListener(ActionListener newsStoryMenuListener){
		
	}
	
	/**
	 * 
	 * @param displayMenuListener
	 */
	//created by alex 4/22
	public void registerDisplayMenuListener(ActionListener displayMenuListener){
		
	}
	
	/**
	 * 
	 * @param newsDataBaseModel
	 */
	//created by alex 4/22
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel){
		//sets class variable to given NewsDataBaseModel object
		this.newsDataBaseModel = newsDataBaseModel;
	}
	/**
	 * 
	 */
	//created by alex 4/22
	public void actionPerformed(ActionEvent actionEvent){
		
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/22
	public int[] getSelectedNewsMakers(){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/22
	public int[] getSelectedNewsStories(){
		return null;
	}

}


