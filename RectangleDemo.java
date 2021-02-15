import javax.swing.*;
import java.awt.*;

public class RectangleDemo extends JPanel
{

    public static void main(String [] a){
        JFrame jf = new JFrame();
        jf.setSize(700,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new RectangleDemo());
        jf.setVisible(true);
    }


    public RectangleDemo(){
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)
    {
        // Call the superclass paint method.
        super.paintComponent(g);

        g.setColor(Color.black);
        g.drawRect(20, 20, 120, 120);

        g.setColor(Color.red);
        g.fillRect(160, 160, 120, 120);

        g.drawString("Welcome to Java Programming",
                30, 30);

        g.drawArc(400, 200, 120, 120, 0, 90);
        g.fillArc(400, 20, 120, 120, 0, 90);


        // g.setColor(Color.blue);
        //g.fillOval(280, 280, 150, 150);
        g.setColor(Color.red);
        g.fillRect(300, 350, 100, 100);
        g.setColor(Color.blue);
        g.fillOval(300, 350, 100, 100);




    }
}