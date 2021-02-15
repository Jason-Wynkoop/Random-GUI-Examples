import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
public class JumpBall extends JFrame{

    private int ballx;
    private int bally;
    private int ceiling = 50;
    private int floor = 100;
    private Timer jumper;
    private Timer faller;

    public static void main(String args[]){
        JumpBall jb = new JumpBall();
        jb.setVisible(true);
    }

    public JumpBall(){
        ballx = 100;
        bally = 100;
        setSize(300,300);
        setTitle("Jump");
        this.setFocusable(true);
        this.requestFocus();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jumper = new Timer(10, new JumpAct());
        faller = new Timer(10, new FallAct());
        addKeyListener(new Jump());
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.green);
        g.fillOval(ballx,bally,40,40);
        g.setColor(Color.red);
        g.fillRect(50,140, 200, 50);
    }


    private class JumpAct implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(bally != ceiling){
                bally-=2;
            }else{
                jumper.stop();
                faller.start();
            }
            repaint();
        }


    }

    private class FallAct implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(bally != floor){
                bally+=2;
            }else{
                faller.stop();
            }
            repaint();
        }
    }


    private class Jump implements KeyListener{
        public void keyPressed(KeyEvent e){
            int keycode = e.getKeyCode();
            if(keycode == KeyEvent.VK_W){
                jumper.start();
            }
        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }
    }
}
