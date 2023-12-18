import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

public class Circle extends JLabel {
    
    private Color c;
    private int diameter, stroke, gap;
    
    public Circle(Color c, int diamention, int diameter, int stroke, int gap){
        this.c = c;
        this.diameter = diameter;
        this.stroke = stroke;
        this.gap = gap;

        setBounds(0, 0, diamention, diamention);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(stroke));
        g2.setColor(c);
        g2.drawRoundRect(gap, gap, diameter, diameter, diameter, diameter);
    }
}
