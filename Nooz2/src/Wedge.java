
public class Wedge {
	
	private double percent;
	private String text;
	
	public Wedge(double percent, String text){
		
		this.percent = percent;
		this.text = text;
		
	}
	
	public double getPercent(){
		
		return this.percent;
		
	}
	
	public void setPercent(double percent){
		
		this.percent = percent;
		
	}
	
	public String getText(){
		
		return this.text;
		
	}
	
	public void setText(String text){
		
		this.text = text;
		
	}

}
