import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * 
 * @author Alex
 *
 */
//class created by alex on 4/25
//all fields created by alex 4/25
public class EditNewsMakerView extends JPanel implements Serializable, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6954434123773420650L;
	
	/**
	 * 
	 */
	NewsMakerModel newsMakerModel = new NewsMakerModel();
	
	/**
	 * 
	 */
	private NewsDataBaseModel newsDataBaseModel = new NewsDataBaseModel();
	
	/**
	 * 
	 */
	private DefaultListModel<String> newsStoryStringList = new DefaultListModel<String>();
	
	/**
	 * 
	 */
	private JList<String> jlNewsStoryList = new JList<String>(newsStoryStringList);
	
	/**
	 * 
	 */
	private JScrollPane jspNewsStoryList = new JScrollPane(jlNewsStoryList);
	
	/**
	 * 
	 */
	private JPanel jpNewsStoryList = new JPanel();
	
	/**
	 * 
	 */
	JTextField jtfName = new JTextField();
	
	/**
	 * 
	 */
	private JLabel jlbName = new JLabel("Name:");
	
	/**
	 * 
	 */
	JButton jbtRemoveFromStory = new JButton("Remove From Story");
	
	/**
	 * 
	 */
	private JPanel jplName = new JPanel();
	
	/**
	 * 
	 * @param newsMakerModel
	 * @param newsDataBaseModel
	 */
	//created by alex 4/25
	//written by alex 4/26
	public EditNewsMakerView(NewsMakerModel newsMakerModel, NewsDataBaseModel newsDataBaseModel){
		//initialize variables
		this.newsMakerModel = newsMakerModel;
		this.newsDataBaseModel = newsDataBaseModel;
		
		//GUI stuff
		jpNewsStoryList.add(jspNewsStoryList);
		
		jplName.setLayout(new FlowLayout(FlowLayout.CENTER));
		jplName.add(jlbName);
		jplName.add(jtfName);
		jtfName.setColumns(5);
		
		//TODO Fix this layout here
		setLayout(new GridLayout(3, 1, 0, 0));
		add(jpNewsStoryList);
		add(jplName);
		add(jbtRemoveFromStory);
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/25
	//written by alex 4/26
	public int[] getSelectedNewsStoryIndices(){
		return jlNewsStoryList.getSelectedIndices();
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void populateNewsStoryJList(){
		
	}
	
	/**
	 * 
	 * @param actionEvent
	 */
	//created by alex 4/25
	@Override
	public void actionPerformed(ActionEvent actionEvent){
		
	}
	
	public static void main(String[] args){
		NewsMakerModel test1 = null;
		NewsDataBaseModel test2 = null;
		JFrame test = new JFrame();
		test.add(new EditNewsMakerView(test1, test2));
		test.pack();
		test.setVisible(true);
	}

}
