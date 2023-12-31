package dev.thuan.viewer.draw;

import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.util.*;
import java.util.List;

public class Overlay extends JWindow {
    private List<Map.Entry<Point, Point>> points = new ArrayList<>();

    public Overlay(Window owner, List<Map.Entry<Point, Point>> points) {
        super(owner);
        this.points = points;
        this.setAlwaysOnTop(true);
        this.setBounds(this.getGraphicsConfiguration().getBounds());
        this.setBackground(new Color(0, true));
        this.setVisible(true);
    }

    public void destroy() {
        this.dispose();
    }

    public Overlay(Window owner) {
        super(owner);
        this.setAlwaysOnTop(true);
        this.setBounds(this.getGraphicsConfiguration().getBounds());
        this.setBackground(new Color(0, true));
        this.setVisible(true);
    }

    public void updatePoints(List<Map.Entry<Point, Point>> points) {
        this.points = points;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        for (Map.Entry<Point, Point> entry : points) {
            Point start = entry.getKey();
            Point end = entry.getValue();
            g.drawLine(start.x, start.y, end.x, end.y);
        }
        System.out.println("Painting overlay");
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
        System.out.println("Updating overlay");
    }

    /**
     * Only for testing
     *
     * @param args
     */
    public static void main(String[] args) {
        Overlay overlay = new Overlay(null);

        overlay.updatePoints(List.of(
                new AbstractMap.SimpleEntry(new Point(0, 0), new Point(100, 100)),
                new AbstractMap.SimpleEntry(new Point(100, 100), new Point(200, 200)),
                new AbstractMap.SimpleEntry(new Point(200, 200), new Point(300, 300)),
                new AbstractMap.SimpleEntry(new Point(300, 300), new Point(400, 400))
        ));

        overlay.updatePoints(List.of(
                new AbstractMap.SimpleEntry(new Point(0, 0), new Point(100, 100)),
                new AbstractMap.SimpleEntry(new Point(100, 100), new Point(200, 200)),
                new AbstractMap.SimpleEntry(new Point(200, 200), new Point(300, 300)),
                new AbstractMap.SimpleEntry(new Point(300, 300), new Point(400, 400))
        ));

        overlay.updatePoints(List.of(
                new AbstractMap.SimpleEntry(new Point(0, 0), new Point(100, 100)),
                new AbstractMap.SimpleEntry(new Point(100, 100), new Point(200, 200)),
                new AbstractMap.SimpleEntry(new Point(200, 200), new Point(300, 300)),
                new AbstractMap.SimpleEntry(new Point(300, 300), new Point(400, 400))
        ));
    }

    public void setOverlays(Hashtable<InetAddress, List<Map.Entry<Point, Point>>> overlays) {
        points.clear();
        for (List<Map.Entry<Point, Point>> overlay : overlays.values()) {
            points.addAll(overlay);
        }
        System.out.println("Setting overlays" + points.size());
        repaint();
    }
}