import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class lockButton extends JButton {
    public lockButton(){
        this.setSize(140, 140);
        this.setLayout(null);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusable(false);

        // this.add(new Circle(App.playerColor[App.player], 140, 100, 20, 20));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(new Color(30, 0, 130, 100));
        g2.fillRoundRect(5, 5, 130, 130, 20, 20);
    }
}
