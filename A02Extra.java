//Code based on http://docs.oracle.com/javase/tutorial/uiswing/painting/refining.html

// Group  C


import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

public class A02Extra {
    
    // main
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    // startup our BackroundPanel which contain the line
    private static void createAndShowGUI() {
        JFrame f = new JFrame("DIS 2 = GROUP C = A02 Extra Credit Exercise");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new BackgroundPanel());
        f.setSize(350,200);
        f.setVisible(true);
    } 

}


// personalized panel, nothing special
class BackgroundPanel extends JPanel {

    // the line only grow in lenght, so it's starting position is declared fixed
    final private int xPos=70;
    final private int yPos=70;

    // create the line
    BlackLine blackLine = new BlackLine(xPos,yPos);
    // this is used when clicking and dragging as the 'OLD' position to detect direction
    private int startY = 0;

    //constructor
    public BackgroundPanel() {

        // used to initialize the startY position for detecting up or down on dragging
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                startY = e.getY();
            }
        });
        // on drag, resize the line
        addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                resizeLine(e.getY());
            }
        });

    }

    // method that resize the line
    private void resizeLine(int y){

        // Current line lenght, stored as final variables 
        // to avoid repeat invocations of the same methods.
        final int CURR_LENGHT = blackLine.getLenght() ;
        // offset or step by which the line grow every time
        // big enought to allow complete extension with small movement
        final int OFFSET = 5;
        // temporary variable to hold the new lenght
        int newLenght;

        // main logic
        // if draggin up, i can skip one repaint call for optimization 
        //(even though it would have been redrawn together by the system)

        // as boundaries the line will stop at 0
        // on dragging down (no negative lenght), and 150 on draggin up

        if (y < startY) {   // DRAGGIN UP
            // the line is extending, so there is no need to repaint background somewhere
            // update the line
            newLenght =  CURR_LENGHT+OFFSET < 150  ? CURR_LENGHT+OFFSET : 150;
            blackLine.setLenght(newLenght);
            // i only need to paint the new piece of line
            repaint(xPos,yPos,xPos+newLenght,yPos);
        } else if (y > startY ) {
            newLenght = CURR_LENGHT-OFFSET > 0  ? CURR_LENGHT-OFFSET : 0;
            // repaint background from the  NEW END of line to PREVIOUS END of line
            repaint(xPos+newLenght,yPos,newLenght,yPos);
            // update the line
            blackLine.setLenght(newLenght);
            // repaint the panel
            repaint(xPos,yPos,xPos+newLenght,yPos);

        }
        // in every case update the startY
        startY = y;
    }

    // set the dimension fo the panel
    public Dimension getPreferredSize() {
        return new Dimension(350,200);
    }
    

    // method that draw on the panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);   
        blackLine.paintLine(g);
    }  
}


// personalized line that extend JComponents
class BlackLine extends JComponent{

    //  local coordinates
    int x , y = 0;

    public BlackLine(int x, int y){
        this.x = x;
        this.y = y;
    }

    // the line only has a fixed starting point and a lenght
    private int lenght = 75;

    public int getLenght(){
        return lenght;
    } 

    public void setLenght( int l){
        this.lenght = l;
    }

    public void paintLine(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(x,y,x+lenght,y);
    }
}