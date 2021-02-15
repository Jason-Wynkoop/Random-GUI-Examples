import javax.swing.JFrame;

public class SimpleTestFrame extends JFrame{

    private int WINDOW_HEIGHT = 500;
    private int WINDOW_WIDTH = 500;

    public static void main(String[] args) {
        SimpleTestFrame stf = new SimpleTestFrame();
        stf.setVisible(true);

    }

    public SimpleTestFrame(){
        setBounds(300,100,WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Test Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //add(new RectangleCarPanel(WINDOW_WIDTH, WINDOW_HEIGHT));

        add(new RCPUltimate(WINDOW_WIDTH-15, WINDOW_HEIGHT-40));
    }

}