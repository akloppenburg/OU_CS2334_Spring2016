import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;

public class PieChart {
	
	private String title;
	private List<Wedge> wedges;
	
	class PieChartPanel extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -8558164812964485523L;

		public void paintComponent(Graphics g){
			
			double percent = 100.0;
			double degrees = 360.0;
			double currentPercent = 0.0;
		    int startAngle = 0;
		    int arcAngle = 0;
		    Rectangle area = new Rectangle(0, 0, 300, 300);
		    
		    for (int i = 0; i < wedges.size(); i++) {
		    	startAngle = (int) (currentPercent * degrees / percent);
		    	arcAngle = (int) ((currentPercent) * degrees / percent);
		    	
		    	Random rand = new Random();
		    	float red  = rand.nextFloat();
		    	float green = rand.nextFloat();
		    	float blue = rand.nextFloat();
		    	Color randColor = new Color(red, green, blue);
		    	
		    	g.setColor(randColor);
		        g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
		        currentPercent += wedges.get(i).getPercent();
		        g.drawString((wedges.get(i).getText() + wedges.get(i).getPercent() + "%"), 400, (0+15*(i)));
		    }
			
		}
		
	}

}
