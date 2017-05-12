import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//TODO write constructor
//TODO write methods
//TODO write Javadoc
/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/21
//all fields created by alex 4/21
public class PieChartView implements ActionListener{
	
	/**
	 * 
	 */
	private PieChart pieChart;
	
	/**
	 * 
	 */
	private NewsMakerModel newsMakerModel;
	
	/**
	 * 
	 */
	private String media;
	
	/**
	 * 
	 */
	private String content;
	
	/**
	 * 
	 */
	private String measure;
	
	/**
	 * 
	 * @param newsMakerModel
	 * @param media
	 * @param content
	 * @param measure
	 */
	//created by alex 4/21
	//method body written by alex 4/22
	public PieChartView(NewsMakerModel newsMakerModel, String media, String content, String measure){
		//TODO look at the UML and such and figure out what else needs to be done here/if this is correct
		this.newsMakerModel = newsMakerModel;
		this.media = media;
		this.content = content;
		this.measure = measure;
		
		String title = constructTitle();
		List<Wedge> wedges = constructWedges();
		
		this.pieChart = new PieChart(title, wedges);
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/21
	private String constructTitle(){
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	//created by alex 4/21
	private List<Wedge> constructWedges(){
		return null;
	}
	
	/**
	 * 
	 * @param actionEvent
	 */
	//created by alex 4/21
	public void actionPerformed(ActionEvent actionEvent){
		
	}
	
}
