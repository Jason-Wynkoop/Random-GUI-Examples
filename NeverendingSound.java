import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;



public class NeverendingSound extends JPanel{
    // Blank JPanels for spacing
    private JPanel northPanel;
    private JPanel eastPanel;
    private JPanel southPanel;
    private JPanel westPanel;

    private AudioClip sound;
    private boolean soundStatus; // Controls sound on or off.

    // Constructor that assembles the GUI.
    public NeverendingSound() {

        northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(200, 200));
        eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(200, 200));
        southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(200, 200));
        westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(200, 200));

        this.setPreferredSize(new Dimension(400, 400));
        this.addMouseMotionListener(new MouseMotionHandler());
        this.addMouseListener(new MouseHandler());

        soundStatus = false;

        // Prepare the sound!
        try {

            File soundFile = new File("trick.wav");
            URL url = soundFile.toURI().toURL();
            sound = Applet.newAudioClip(url);

        } catch (Exception e1) {
            System.out.println("File issue");
        }

        JFrame mainWindow = new JFrame();
        mainWindow.setTitle("Sound GUI");

        //IMPORTANT TO DISABLING THE 'X'
        mainWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);


        mainWindow.add(this, BorderLayout.CENTER);
        mainWindow.add(northPanel, BorderLayout.NORTH);
        mainWindow.add(eastPanel, BorderLayout.EAST);
        mainWindow.add(southPanel, BorderLayout.SOUTH);
        mainWindow.add(westPanel, BorderLayout.WEST);
        mainWindow.pack();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);

    }

    // Paints the rectangle.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 400, 400);

    }

    // Handles the event of the mouse leaving the rectangle.
    private class MouseHandler implements MouseListener {

        public void mouseClicked(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {

				/*sound.stop();
				soundStatus = false;*/

        }

    }

    // Handles the event of the mouse moving into the rectangle.
    //Could also move it to MouseEntered
    public class MouseMotionHandler implements MouseMotionListener {

        public void mouseDragged(MouseEvent e) {
        }

        public void mouseMoved(MouseEvent e) {

            if (soundStatus == false) {
                sound.play();
                soundStatus = true;
            }
        }

    }

    public static void main(String[] args) {
        new NeverendingSound();
    }

}
