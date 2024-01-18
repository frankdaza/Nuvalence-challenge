package com.frankdaza.nuvalence.rectangles.jframe;

import javax.swing.*;
import java.awt.*;

public class RectanglesDrawing extends JFrame {

        public RectanglesDrawing() {
            this.setTitle("Rectangles");
            this.setSize(1024, 800);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);

            JScrollPane scrollPane = new JScrollPane(this);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            this.add(scrollPane);
        }

        void drawRectangles(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLUE);
            g2d.drawString("INTERSECTION", 50, 50);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(30, 60, 220, 120);
            g2d.setColor(Color.BLUE);
            g2d.drawRect(120, 60, 160, 120);

            g2d.drawString("NO INTERSECTION", 50, 220);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(30, 230, 160, 120);
            g2d.setColor(Color.BLUE);
            g2d.drawRect(260, 230, 140, 120);

            g2d.drawString("CONTAINMENT", 50, 380);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(30, 390, 160, 120);
            g2d.setColor(Color.BLUE);
            g2d.drawRect(50, 410, 70, 60);

            g2d.drawString("NO CONTAINMENT", 50, 540);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(30, 550, 160, 120);
            g2d.setColor(Color.BLUE);
            g2d.drawRect(220, 550, 70, 60);

            g2d.drawString("ADJACENCY - SUB-LINE", 650, 50);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(630, 60, 220, 120);
            g2d.setColor(Color.BLUE);
            g2d.drawRect(850, 90, 160, 60);

            g2d.drawString("ADJACENCY - PROPER", 650, 240);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(630, 250, 220, 120);
            g2d.setColor(Color.BLUE);
            g2d.drawRect(850, 250, 160, 120);

            g2d.drawString("ADJACENCY - PARTIAL", 650, 400);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(630, 410, 220, 120);
            g2d.setColor(Color.BLUE);
            g2d.drawRect(850, 490, 160, 60);

            g2d.drawString("NO ADJACENCY", 650, 580);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(630, 600, 180, 120);
            g2d.setColor(Color.BLUE);
            g2d.drawRect(850, 600, 100, 60);
        }

        public void paint(Graphics g) {
            super.paint(g);
            drawRectangles(g);
        }
}
