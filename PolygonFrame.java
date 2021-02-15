import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class PolygonFrame extends JFrame{
    private int[] xc;
    private int[] yc;
    private int cOP;
    public static void main(String[] args) {
        PolygonFrame pf = new PolygonFrame();
        pf.setVisible(true);

    }

    public PolygonFrame(){
        setSize(500,500);
        setTitle("Polygons");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        xc = new int[100];
        yc = new int[100];
        cOP = 0;
        addMouseListener(new PointHandler());
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(new Color(150,0,150));
        if(cOP <= 1 || cOP >= 100){
            //Do nothing
        }else if(cOP == 2){
            g.drawLine(xc[0], yc[0], xc[1], yc[1]);
        }else{
            g.drawPolygon(xc, yc, cOP);
        }
    }

    private class PointHandler extends MouseAdapter{

        public void mouseClicked(MouseEvent e){
            xc[cOP] = e.getX();
            yc[cOP] = e.getY();
            cOP++;
            repaint();
        }
    }

}