import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class TempConverter extends JApplet
{
    private JPanel fPanel;
    private JPanel cPanel;
    private JPanel buttonPanel;
    private JTextField fahrenheit;
    private JTextField celsius;

    public void init()
    {
        // Build the panels.
        buildFpanel();
        buildCpanel();
        buildButtonPanel();

        // Create a layout manager.
        setLayout(new GridLayout(3, 1));

        // Add the panels to the content pane.
        add(fPanel);
        add(cPanel);
        add(buttonPanel);
    }

    private void buildFpanel()
    {
        fPanel = new JPanel();
        JLabel message1 =
                new JLabel("Fahrenheit Temperature: ");
        fahrenheit = new JTextField(10);

        fPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        fPanel.add(message1);
        fPanel.add(fahrenheit);
    }
    private void buildCpanel()
    {
        cPanel = new JPanel();
        JLabel message2 =
                new JLabel("Celsius Temperature: ");
        celsius = new JTextField(10);
        celsius.setEditable(false);

        cPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        cPanel.add(message2);
        cPanel.add(celsius);
    }

    private void buildButtonPanel()
    {
        buttonPanel = new JPanel();

        JButton convButton = new JButton("Convert");
        convButton.addActionListener(new ButtonListener());
        buttonPanel.add(convButton);
    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            double ftemp, ctemp;
            DecimalFormat formatter = new
                    DecimalFormat("0.0");

            ftemp = Double.parseDouble(fahrenheit.getText());

            ctemp = (5.0 / 9.0) * (ftemp - 32);

            celsius.setText(formatter.format(ctemp));
        }
    }
}