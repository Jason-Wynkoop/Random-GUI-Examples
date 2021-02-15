import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class RectangleCarPanel extends JPanel {

    private final int SPEED = 5;
    private final int R_WIDTH = 50;
    private final int R_HEIGHT = 30;
    private int rightBound;
    private int bottomBound;
    private int x_point;
    private int y_point;
    public RectangleCarPanel(int rb, int bb){
        rightBound = rb - R_WIDTH;
        bottomBound = bb - R_HEIGHT;
        x_point = 0;
        y_point = 0;
        //This is an easy way to make our Panel focusable!
        this.setFocusable(true);
        this.requestFocus();
        setBackground(Color.WHITE);
        addKeyListener(new RectangleDriver());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(80,0,180));
        g.fillRect(x_point, y_point, R_WIDTH, R_HEIGHT);
    }

    private class RectangleDriver extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            System.out.println(x_point + "," + y_point);
            //Handle both the WASD and arrow control style
            switch(keyCode){
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if(!(y_point <= 0)){
                        y_point-= SPEED;
                    }
                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if(!(y_point >= bottomBound)){
                        y_point+= SPEED;
                    }
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if(!(x_point <= 0)){
                        x_point-= SPEED;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if(!(x_point >= rightBound)){
                        x_point+= SPEED;
                    }
                    break;
            }

            repaint();
        }
    }
}