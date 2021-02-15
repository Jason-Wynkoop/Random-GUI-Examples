import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;  // For the File class
import java.net.*; // For URL class and MalformedURLException

/*  This application uses the AudioClip class to play a sound. */

public class AudioFrame extends JFrame
{
    private JLabel credit;
    private JButton playButton;
    private JButton loopButton;
    private JButton stopButton;
    private AudioClip sound;       // Holds the sound clip

    public AudioFrame() throws MalformedURLException
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("JFrame Audio Demo");
        setLayout(new FlowLayout());

        credit = new JLabel("Audio source: Some Google search");
        add(credit);

        makeButtons();


        // Create a file object for the step.wav file.
        File file = new File("laugh.wav");

        // Get a URI object for the audio file.
        URI uri = file.toURI();

        // Get a URL for the audio file.
        URL url = uri.toURL();

        // Get an AudioClip object for the sound file using
        // the Applet class's static newAudioClip method.
        sound = Applet.newAudioClip(url);

        pack();
        setVisible(true);
    }

    private void makeButtons()
    {
        playButton  = new JButton("Play");
        loopButton  = new JButton("Loop");
        stopButton  = new JButton("Stop");

        playButton.addActionListener(new ButtonListener());
        loopButton.addActionListener(new ButtonListener());
        stopButton.addActionListener(new ButtonListener());

        add(playButton);
        add(loopButton);
        add(stopButton);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Determine which button was clicked and
            // perform the selected action.
            if (e.getSource() == playButton) sound.play();
            else if (e.getSource() == loopButton) sound.loop();
            else if (e.getSource() == stopButton) sound.stop();
        }
    }

    public static void main(String[] args) throws MalformedURLException
    {
        new AudioFrame();
    }
}