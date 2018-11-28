package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * A JLabel class for views with an image
 * 
 * @author Jaeger, Schmidt
 * @version 2017-10-27
 */
@SuppressWarnings("serial")
public abstract class ImageView extends JLabel {
	private ImageIcon imageIcon ;

	/** Creates a new view with an image (JLabel)
	 * 
	 * @param image image of the view
	 * @param xPos x position of the view
	 * @param yPos y position of the view
	 */


	protected ImageView(String image, int xPos, int yPos) {

		super();

		//set up the image
		imageIcon = new ImageIcon(image);
		//ImageIcon imageIcon = new ImageIcon(image);
		this.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
		this.setIcon(imageIcon);

		this.setLocation(xPos, yPos);

		//add the image label to the simulation view
		SimulationView.addActorView(this);


	}
	public void setImageIcon(String image)
	{
		this.imageIcon = new ImageIcon(image);
		this.repaint();
		this.revalidate();
	}

}
