import java.awt.BorderLayout;
import java.util.concurrent.ThreadLocalRandom;


import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;
	private JButton btnRandom;
		int min = 1;
		int max = 5;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		
		// Text pane
		textPane = new JPanel();
		textPane.setBackground(Color.lightGray);
		textPane.setBounds(140, 470, 500, 45);
		textPane.setVisible(true);
		
		// Buttons
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		btnRandom = new JButton();
		
		// Labels
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		// Previous button 
		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);
		
		// Random Button
		btnRandom.setText("Random");
		btnRandom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goRandom();
			}
		});
		buttonPane.add(btnRandom);

		// Next button
		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Random Button Functionality
	 * Make sure min is less than max, gets random number, then uses for loop
	 */
	private void goRandom() {
		// Ensures min is not more than max value
	    if (min > max) {
	        throw new IllegalArgumentException("min cannot be greater than max");
	    }
	    // Generates random number
		int random_int = ThreadLocalRandom.current().nextInt(min, max + 1);
		// Limits loop to avoid excessive looping
		int maxSteps = Math.min(random_int, 10);
		// For loop 
		for (int i = 0; i < maxSteps; i++) {
			card.next(slidePane);
			cardText.next(textPane);
		}
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	// added new images for all 5 destinations. 
	
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + 
		getClass().getResource("/resources/TestImage1.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + 
		getClass().getResource("/resources/thailand.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + 
		getClass().getResource("/resources/colorado.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + 
		getClass().getResource("/resources/tahiti.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + 
		getClass().getResource("/resources/elpaso.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
	    String text = ""; 
	    if (i == 1) {
	        // reworded text for all five destinations
	        text = "<html><body style='text-align:center; padding-left: 115px;'><font size='5'"
	        		+ ">#1 The Grand Canyon.</font> <br>"
	                + "Perfect views, great for self reflection.</body></html>";
	    } else if (i == 2) {
	        text = "<html><body style='text-align:center; padding-left: 135px;'><font size='5'>"
	        		+ "#2 Thailand.</font> <br>Clear "
	                + "your mind on the beach.</body></html>";
	    } else if (i == 3) {
	        text = "<html><body style='text-align:center; padding-left: 110px;'><font size='5'"
	        		+ ">#3 Colorado Mountains.</font> "
	                + "<br>Let the cool mountain air revitalize you.</body></html>";
	    } else if (i == 4) {
	        text = "<html><body style='text-align:center; padding-left: 110px;'><font size='5'"
	        		+ ">#4 Tahiti.</font> <br>Get away "
	                + "from everything and recharge.</body></html>";
	    } else if (i == 5) {
	        text = "<html><body style='text-align:center; padding-left: 100px;'><font size='5'>"
	        		+ "#5 El Paso.</font> <br>Get back "
	                + "to nature. Enjoy mindful nature hikes.</body></html>";
	    }
	    return text;
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}