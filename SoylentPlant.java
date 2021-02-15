import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class SoylentPlant extends JFrame {
    private ArrayList<String> cattle;
    private JTextArea cattleList;
    public SoylentPlant(){
        cattle = new ArrayList<String>();
        setTitle("Processing Plant");
        setBounds(100,100,400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        cattleList = new JTextArea();
        cattleList.setEditable(false);
        JScrollPane jsp = new JScrollPane(cattleList);
        jsp.setLocation(20, 20);
        jsp.setSize(200, 300);
        //jsp.setPreferredSize(new Dimension(200,300));
        getContentPane().add(jsp);

        JButton processButton = new JButton("Process Cattle");
        processButton.setBounds(238, 193, 136, 23);
        getContentPane().add(processButton);

        //The new part
        Timer t = new Timer(1000, null);
        t.addActionListener(new QueueCattle());

        t.start();

        processButton.addActionListener(new DequeueCattle());
    }
    public static void main(String[] args) {
        SoylentPlant sp = new SoylentPlant();
        sp.setVisible(true);

    }

    public void updateListing(){
        String catString = "";
        for(int i = 0; i < cattle.size(); i++){
            catString += cattle.get(i) + "\n";
        }

        cattleList.setText(catString);
    }

    private class QueueCattle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int randomID = (int) (Math.random() * 5000);
            cattle.add("Cattle CN"+randomID);
            updateListing();
        }

    }

    private class DequeueCattle implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(cattle.size() != 0){
                cattle.remove(0);
                updateListing();
            }

        }

    }
}
