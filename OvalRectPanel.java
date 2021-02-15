import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class OvalRectPanel extends JPanel{

    private int SIZE = 300;

    public static void main(String potatoes[]){
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new OvalRectPanel());
        frame.setVisible(true);
    }

    public OvalRectPanel(){
        setBackground(Color.WHITE);
    }


    public void paintComponent(Graphics g)
    {
        int shape;
        int noOfFigures;
        int x, y;
        int width, height;
        int sangle, angle;
        int red, green, blue;
        int i;

        //determines no. of figures
        noOfFigures = 5 + (int)(Math.random() * 10);

        for(i = 0; i < noOfFigures; i++)
        {
            //red component
            red = (int)(Math.random() * 256);
            //green component
            green = (int)(Math.random() * 256);
            //blue component
            blue = (int)(Math.random() * 256);

            //color for drawing object
            g.setColor(new Color(red, green, blue));

            x = (int)(Math.random() * SIZE);         //x value
            y = (int)(Math.random() * SIZE);         //y value
            width = (int)(Math.random() * SIZE);     //width
            height = (int)(Math.random() * SIZE);    //height

            shape = (int)(Math.random() * 4);

	     	/*    	0 : Rectangle
				 	 *    	1 : Oval
	     	 *    	2 : Filled Rectangle
	     	 *    	3 : Filled Arc    **/

            switch (shape)
            {
                case 0: g.drawRect(x, y, width, height);
                    break;
                case 1: g.drawOval(x, y, width, height);
                    break;
                case 2: g.fillRect(x, y, width, height);
                    break;
                case 3:
                    sangle = (int)(Math.random() * 360);
                    angle  = (int)(Math.random() * 360);
                    g.fillArc(x, y, width, height,
                            sangle, angle);
                    break;
            }
        }//end for
    }

}