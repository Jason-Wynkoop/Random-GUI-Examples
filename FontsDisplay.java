import java.awt.*;


import javax.swing.JFrame;

public class FontsDisplay extends JFrame
{
    public void paint( Graphics g)
    {
        super.paint(g);
        g.setFont(new Font("Courier", Font.BOLD, 24));
        g.drawString("Courier bold 24pt font",30,70);

        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Arial plain 30pt font",30,200);

        g.setFont(new Font("Dialog", Font.BOLD+Font.ITALIC, 36));
        g.drawString("Dialog italic bold 36pt font",30,300);

        g.setFont(new Font("Serif", Font.ITALIC, 30));
        g.drawString("Serif italic 42pt font",30,400);

        g.setColor(Color.RED);
        g.setFont(new Font("Papyrus", Font.ITALIC, 42));
        g.drawString("PAPYRUS", 30, 450);

        g.setColor(Color.PINK);;
        g.setFont(new Font("Comic Sans", Font.PLAIN, 42));
        g.drawString("COMIC SAAAAANS", 50, 500);

        g.setColor(new Color(255,0,255));
        g.setFont(new Font("Bradley Hand ITC", Font.PLAIN, 42));
        g.drawString("Fancy", 50, 600);

        g.setColor(Color.YELLOW);
        g.fillArc(400,  100, 200, 200, 40, 260);


    }

    public FontsDisplay(){
        setTitle("Font Zone");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
    }

    public static void main(String ApplesauceAlligators[]){
        FontsDisplay fd = new FontsDisplay();
        fd.setVisible(true);
    }
}