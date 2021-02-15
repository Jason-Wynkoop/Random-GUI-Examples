import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RCPUltimate extends JPanel {
    private final int SPEED = 5;
    private final int R_WIDTH = 50;
    private final int R_HEIGHT = 30;
    private int rightBound;
    private int bottomBound;
    private int x_point;
    private int y_point;

    private ArrayList<String> pressedKeys;

    public RCPUltimate(int rb, int bb) {
        pressedKeys = new ArrayList<String>();
        rightBound = rb;
        bottomBound = bb;
        x_point = 0;
        y_point = 0;
        // This is an easy way to make our Panel focusable!
        this.setFocusable(true);
        this.requestFocus();
        setBackground(Color.WHITE);
        addKeyListener(new RectangleDriver());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(80, 0, 180));
        g.fillRect(x_point, y_point, R_WIDTH, R_HEIGHT);
    }

    public void movePoint() {
        if (pressedKeys.contains("Up")) {
            if (!(y_point <= 0)) {
                y_point -= SPEED;
            }
        }
        if (pressedKeys.contains("Down")) {
            if (!(y_point + R_HEIGHT >= bottomBound)) {
                y_point += SPEED;
            }
        }
        if (pressedKeys.contains("Left")) {
            if (!(x_point <= 0)) {
                x_point -= SPEED;
            }
        }
        if (pressedKeys.contains("Right")) {
            if (!(x_point + R_WIDTH >= rightBound)) {
                System.out.println(x_point + R_WIDTH);
                x_point += SPEED;
            }
        }

    }

    private class RectangleDriver extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    if (!pressedKeys.contains("Up")) {
                        pressedKeys.add("Up");
                    }
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    if (!pressedKeys.contains("Down")) {
                        pressedKeys.add("Down");
                    }
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    if (!pressedKeys.contains("Left")) {
                        pressedKeys.add("Left");
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    if (!pressedKeys.contains("Right")) {
                        pressedKeys.add("Right");
                    }
                    break;
            }
            movePoint();
            repaint();
        }

        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    pressedKeys.remove("Up");
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    pressedKeys.remove("Down");
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    pressedKeys.remove("Left");
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    pressedKeys.remove("Right");
                    break;
            }
        }
    }
}
