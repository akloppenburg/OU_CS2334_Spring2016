import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

//TODO fill methods
//TODO write Javadoc

/**
 * 
 * @author Alex
 *
 */
//class created by alex 4/22
//all fields created by alex 4/25
public class NewsController {
	
	/**
	 * 
	 */
	private NewsDataBaseModel newsDataBaseModel;
	
	/**
	 * 
	 */
	private SelectionView selectionView;
	
	/**
	 * 
	 */
	private EditNewsMakerView editNewsMakerView;
	
	/**
	 * 
	 */
	private JDialog viewDialog;
	
	/**
	 * 
	 */
	private AddEditNewsStoryView addEditNewsStoryView;
	
	/**
	 * 
	 */
	private NewsStory editedNewsStory;
	
	/**
	 * 
	 */
	private MediaTypeSelectionView mediaTypeSelectionView;
	
	/**
	 * 
	 */
	private List<NewsMedia> selectedMediaTypes;
	
	/**
	 * 
	 */
	//created by alex 4/25
	public NewsController(){
		
	}
	
	/**
	 * 
	 * @param newsDataBaseModel
	 */
	//created by alex 4/25
	//written by alex 4/26
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel){
		this.newsDataBaseModel = newsDataBaseModel;
	}
	
	/**
	 * 
	 * @param selectionView
	 */
	//created by alex 4/25
	//written by alex 4/26
	public void setSelectionView(SelectionView selectionView){
		this.selectionView = selectionView;
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void loadNewsData(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void saveNewsData(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void importNoozStories(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void exportNewsStories(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void addNewsMaker(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void editNewsMakers(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void deleteNewsMakers(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void deleteNewsMakerList(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	//written by alex 4/26
	//TODO test this and make sure it's right, may need to pack or set other stuff
	private void addNewsStory(){
		this.addEditNewsStoryView = new AddEditNewsStoryView(this.newsDataBaseModel, null);
		this.viewDialog = new JDialog();
		this.viewDialog.add(addEditNewsStoryView);
		this.viewDialog.setVisible(true);
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	//written by alex 4/26
	//TODO test this and make sure it's right, may need to pack or set other stuff
	private void editNewsStories(){
		this.addEditNewsStoryView = new AddEditNewsStoryView(this.newsDataBaseModel, null);
		this.viewDialog = new JDialog();
		this.viewDialog.add(addEditNewsStoryView);
		this.viewDialog.setVisible(true);
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void sortNewsStories(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void deleteNewsStories(){
		
	}
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void deleteAllNewsStories(){
		
	}
	
	/**
	 * This method is called to display pie charts when requested by the user.
	 * It gets the list of all selected news makers from the
	 * <code>SectionView</code> and displays one pie chart per news maker. For
	 * each pie chart it needs to determine the media type(s) to display, the
	 * news content type to display, and the news metric to use for display.
	 */
	private void displayPieCharts() {
		// Get the indices of the news makers selected in the selection view.
		int[] indices = selectionView.getSelectedNewsMakers();
		
		// If there are no selected news makers, alert the user and return.
		if (0 == indices.length) {
			JOptionPane.showMessageDialog(selectionView, "No newsmaker selected.", "Invalid Selection",
					JOptionPane.WARNING_MESSAGE);
		} else {
			// If there are selected news makers, go through the process for each.
			NewsMakerListModel newsMakerListModel = this.newsDataBaseModel.getNewsMakerListModel();
			for (int index : indices) {
				NewsMakerModel newsMakerModel = newsMakerListModel.get(index);
				String newsMakerName = newsMakerModel.getName();

				// Get media types using MediaTypeSelectionView.
				this.selectedMediaTypes = null;
				this.mediaTypeSelectionView = new MediaTypeSelectionView();
				MediaTypeSelectionListener mediaTypeSelectionListener = new MediaTypeSelectionListener();
				this.mediaTypeSelectionView.jbOkay.addActionListener(mediaTypeSelectionListener);
				this.mediaTypeSelectionView.jbCancel.addActionListener(mediaTypeSelectionListener);

				this.viewDialog = new JDialog(selectionView, newsMakerName, true);
				this.viewDialog.add(mediaTypeSelectionView);
				this.viewDialog.setResizable(false);
				this.viewDialog.pack();
				this.viewDialog.setVisible(true);

				// If no media types were selected, go on to next news maker.
				if (null == this.selectedMediaTypes) {
					continue;
				}

				// Get content type using JOptionPane.
				NewsContent selectedNewsContent = null;
				selectedNewsContent = (NewsContent) JOptionPane.showInputDialog(selectionView,
						"Graph news stories based on which content?", newsMakerName, JOptionPane.PLAIN_MESSAGE, null,
						NewsContent.values(), NewsContent.TOPIC);
				if (null == selectedNewsContent) {
					continue;
				}

				// Get metric type using JOPtionPane.
				NewsMetric selectedNewsMetric = null;
				selectedNewsMetric = (NewsMetric) JOptionPane.showInputDialog(selectionView,
						"Graph news stories based on which metric?", newsMakerName, JOptionPane.PLAIN_MESSAGE, null,
						NewsMetric.values(), NewsMetric.LENGTH);
				if (null == selectedNewsMetric) {
					continue;
				}

				// Create the pie chart.
				PieChartView pieChartView = new PieChartView(newsMakerModel, selectedMediaTypes, selectedNewsContent,
						selectedNewsMetric);
				
				//Make sure the pie chart listens for model changes so that it can update itself.
				newsMakerModel.addActionListener(pieChartView);
			}
		}
	}	
	
	/**
	 * 
	 */
	//created by alex 4/25
	private void displayTextViews(){
		
	}
	
	/**
	 * 
	 * @author Alex
	 *
	 */
	//created by alex 4/25
	private class FileMenuListener implements ActionListener{
		
		/**
		 * 
		 */
		//created by alex 4/25
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * 
	 * @author Alex
	 *
	 */
	//created by alex 4/25
	private class NewsMakerMenuListener implements ActionListener{
		
		/**
		 * 
		 */
		//created by alex 4/25
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * 
	 * @author Alex
	 *
	 */
	//created by alex 4/25
	private class NewsStoryMenuListener implements ActionListener{
		
		/**
		 * 
		 */
		//created by alex 4/25
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * 
	 * @author Alex
	 *
	 */
	//created by alex 4/25
	private class DisplayMenuListener implements ActionListener{
		
		/**
		 * 
		 */
		//created by alex 4/25
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * 
	 * @author Alex
	 *
	 */
	//created by alex 4/25
	public class EditNewsMakerNameListener implements ActionListener{
		
		/**
		 * 
		 */
		//created by alex 4/25
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * 
	 * @author Alex
	 *
	 */
	//created by alex 4/25
	public class RemoveNewsMakerFromNewStoriesListener implements ActionListener{
		
		/**
		 * 
		 */
		//created by alex 4/25
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * 
	 * @author Alex
	 *
	 */
	//created by alex 4/25
	public class AddEditNewsStoryListener implements ActionListener{
		
		/**
		 * 
		 */
		//created by alex 4/25
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * <code>MediaTypeSelectionListener</code> is an inner class (within
	 * <code>NewsController</code>) to listen for actions from a
	 * <code>MediaTypeSelectionView</code>. It has one method that does all the
	 * work -- the overridden <code>actionPerformed</code> method -- which is
	 * called when there is a relevant <code>actionEvent</code>.
	 * 
	 * @author Dean Hougen
	 * @version 1.0
	 *
	 */
	public class MediaTypeSelectionListener implements ActionListener {

		/**
		 * The overridden <code>actionPerformed</code> method that does all of
		 * the work. If the user indicates their selections are "OK" (the
		 * <code>actionCommand</code> is "OK"), it queries each
		 * <code>JCheckBox</code> of the <code>MediaTypeSelectionView</code> to
		 * see if it was selected. If so, it adds the corresponding
		 * <code>NewsMedia</code> type to the <code>selectedMediaTypes</code>
		 * list. If no check boxes were selected, it warns the user of this
		 * fact. Once it has extracted the relevant information from the
		 * <code>MediaTypeSelectionView</code>, it disposes of that view, which
		 * closes the modal window and allows the user to interact with other
		 * windows in <code>Nooz</code>.
		 */
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			selectedMediaTypes = new LinkedList<NewsMedia>();
			if ("OK".equals(actionEvent.getActionCommand())) {
				if (mediaTypeSelectionView.jcbNewspaper.isSelected()) {
					selectedMediaTypes.add(NewsMedia.NEWSPAPER);
				}
				if (mediaTypeSelectionView.jcbTVNews.isSelected()) {
					selectedMediaTypes.add(NewsMedia.TV);
				}
				if (mediaTypeSelectionView.jcbOnline.isSelected()) {
					selectedMediaTypes.add(NewsMedia.ONLINE);
				}
				if (null == selectedMediaTypes) {
					JOptionPane.showMessageDialog(selectionView, "No media type selected.", "Invalid Selection",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			viewDialog.dispose();
		}
	}
	
	
	
}
