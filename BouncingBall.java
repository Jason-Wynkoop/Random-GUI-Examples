import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BouncingBall extends JPanel
{
    private int X = 109;         // Ball's X coordinate
    private final int WIDTH = 40;      // Ball's width
    private final int HEIGHT = 40;     // Ball's height
    //For normal people
    private final int TIME_DELAY = 1; // Time delay
    //use TIME_DELAY = 0 for the speed force, MOVE = 20
    private final int MOVE = 5;       // Pixels to move ball
    private final int MINIMUM_Y = 30;  // Max height of ball
    private final int MAXIMUM_Y = 470; // Min height of ball
    private final int MAXIMUM_X = 470;
    private final int MINIMUM_X = 30;
    private int y = 400;               // Ball's Y coordinate
    private boolean goingUp = true;    // Direction indicator
    private boolean goingRight = true;
    private Timer timer;               // Timer object


    public BouncingBall()
    {
        timer = new Timer(TIME_DELAY, new TimerListener());
        timer.start();
    }

    public static void main(String fish[]){
        JFrame j = new JFrame();
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(500, 500);
        j.add(new BouncingBall());
        j.setVisible(true);
    }



    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.fillOval(X, y, WIDTH, HEIGHT);
        g.setColor(Color.yellow);
        g.drawLine(X,y, X+WIDTH, y + HEIGHT);
    }


    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Update the ball's Y coordinate.
            if (goingUp)
            {
                if (y > MINIMUM_Y) y -= MOVE;
                else { goingUp = false;  y +=MOVE;}
            }
            else
            {
                if (y < MAXIMUM_Y) y += MOVE;
                else { goingUp = true;  y -= MOVE;}
            }


            if(goingRight){
                if(X < MAXIMUM_X) X += MOVE;
                else{
                    goingRight = false;
                }
            }
            else{
                if(X > MINIMUM_X) X -= MOVE;
                else{
                    goingRight = true;
                }
            }

            // Force a call to the paint method.
            repaint();
        }
    }
}
