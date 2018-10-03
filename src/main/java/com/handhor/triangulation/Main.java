package com.handhor.triangulation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JPanel {
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;
    private final Vertex[] vertices;

    public Main(Vertex[] vertices) {
        this.vertices = vertices;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        for (Vertex i : vertices) {
            if (i.isBack) {
                g2d.setColor(Color.blue);
                g2d.drawOval((int) i.x - 2, PREF_H - (int) i.y - 2, 4, 4);
            }
            if (i.isFront) {
                g2d.setColor(Color.red);
                g2d.drawOval((int) i.x - 4, PREF_H - (int) i.y - 4, 8, 8);
            }
            g2d.setColor(Color.green);
            for (Vertex j : i.neig) {
                g2d.drawLine((int)i.x, PREF_H - (int)i.y, (int)j.x, PREF_H - (int)j.y);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui(Vertex[] vertices) {
        Main mainPanel = new Main(vertices);
        JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("vertex.txt"));

        in.useLocale(new Locale("US"));
        final int n = in.nextInt();
        Vertex vertices[] = new Vertex[n];
        for (int i = 0; i < n; i++) {
            float x = in.nextFloat();
            float y = in.nextFloat();

            vertices[i] = new Vertex(x, y);
        }

        TriangulationExecutor executor = new TriangulationExecutor(vertices);
        executor.execute();
        SwingUtilities.invokeLater(() -> createAndShowGui(vertices));
    }
}
