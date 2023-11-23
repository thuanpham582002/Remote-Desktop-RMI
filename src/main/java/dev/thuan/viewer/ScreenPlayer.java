package dev.thuan.viewer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dev.thuan.Commons;
import dev.thuan.utilities.ImageUtility;
import org.apache.commons.lang3.tuple.Pair;

/**
 * ScreenPlayer.java
 */

public class ScreenPlayer extends JLabel {

    private final Recorder recorder;

    private float screenScale = 1.0f;
    private float oldscreenScale = 1.0f;
    boolean PartialScreenMode = false;
    public boolean drawOverlay = false;
    private BufferedImage screenImage = null;
    private Rectangle selectionRect = Commons.emptyRect;
    private Rectangle oldselectionRect = Commons.diffRect;
    private Rectangle screenRect = Commons.emptyRect;
    private Rectangle oldScreenRect = Commons.diffRect;

    public void setDrawOverlay(boolean bool) {
        drawOverlay = bool;
    }

    private final List<Map.Entry<Point, Point>> points = new ArrayList<>();

    public boolean isSelecting = false;

    // mouse cordination for selection
    public int srcx, srcy, destx, desty;

    public ScreenPlayer(Recorder recorder) {
        this.recorder = recorder;
        setFocusable(true);
    }

    /*public void updateScreenRect(Rectangle rect) {
        if (rect.equals(Commons.emptyRect))
            screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        else
            screenRect = rect;
        if (!capture.getScreenRect().equals(screenRect)) {
            capture.updateScreenSize(screenRect);
            setNewScreenImage(screenRect, colorQuality);
        }
    }*/

    public void updateScreenRect() {
        screenScale = recorder.viewerOptions.getScreenScale();
        if (!PartialScreenMode) {
            screenRect = recorder.viewerOptions.getScreenRect();
            if (!screenRect.equals(oldScreenRect)) {
                oldScreenRect = screenRect;
                setSize(screenRect.getSize());
                setPreferredSize(screenRect.getSize());
                if (!recorder.viewerOptions.capture.getScreenRect().equals(screenRect)) {
                    recorder.viewerOptions.capture.updateScreenSize(screenRect);
                    recorder.viewerOptions.setNewScreenImage(screenRect,
                            recorder.viewerOptions.getColorQuality());
                }
            }

            if (oldscreenScale != screenScale) {
                Dimension dimension = new Dimension(
                        (int) (screenScale * screenRect.getWidth()),
                        (int) (screenScale * screenRect.getHeight())
                );
                setSize(dimension);
                setPreferredSize(dimension);
                oldscreenScale = screenScale;
            }
        } else {
            if (!isSelecting)
                if (!selectionRect.equals(oldselectionRect)) {
                    //screenRect = selectionRect;
                    oldselectionRect = selectionRect;
                    setSize(selectionRect.getSize());
                    setPreferredSize(selectionRect.getSize());
                    if (!recorder.viewerOptions.capture.getScreenRect().equals(selectionRect)) {
                        recorder.viewerOptions.capture.updateScreenSize(selectionRect);
                        recorder.viewerOptions.setNewScreenImage(selectionRect,
                                recorder.viewerOptions.getColorQuality());
                    }
                }

            if (screenScale != screenScale) {
                Dimension dimension = new Dimension(
                        (int) (screenScale * selectionRect.getWidth()),
                        (int) (screenScale * selectionRect.getHeight())
                );
                setSize(dimension);
                setPreferredSize(dimension);
                oldscreenScale = screenScale;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        if (screenScale == 0f) {
            g.drawImage(screenImage, 0, 0,
                    (int) (recorder.viewerOptions.getCurrentScreenRect().width),
                    recorder.viewerOptions.getCurrentScreenRect().height, this);
        } else {
            g.drawImage(screenImage, 0, 0,
                    (int) (screenRect.width * screenScale),
                    (int) (screenRect.height * screenScale), this);
//        DrawSelectingRect(g);
        }
        if (drawOverlay) {
            drawOverlay(g);
        } else {
            points.clear();
        }
    }

    private void drawOverlay(Graphics g) {
        float _scaleX = screenScale;
        float _scaleY = screenScale;
        if (screenScale == 0f) {
            _scaleX = (float) recorder.viewerOptions.getCurrentScreenRect().width / screenRect.width;
            _scaleY = (float) recorder.viewerOptions.getCurrentScreenRect().height / screenRect.height;
        }

        System.out.println("scaleX: " + _scaleX + " scaleY: " + _scaleY);
        g.setColor(Color.RED);
        g.setPaintMode();
        if (srcx == destx && srcy == desty) {
        } else {
            Point src = new Point((int) (srcx * (1 / _scaleX)), (int) (srcy * (1 / _scaleY)));
            Point dest = new Point((int) (destx * (1 / _scaleX)), (int) (desty * (1 / _scaleY)));
            points.add(new AbstractMap.SimpleEntry<>(src, dest));
        }
        for (Map.Entry<Point, Point> point : points) {
            g.drawLine((int) (point.getKey().x * _scaleX), (int) (point.getKey().y * _scaleY),
                    (int) (point.getValue().x * _scaleX), (int) (point.getValue().y * _scaleY));
        }
        srcx = destx;
        srcy = desty;
    }

    public void UpdateScreen(byte[] data) {
        updateScreenRect();
        screenImage = ImageUtility.toBufferedImage(data);

        recorder.viewerOptions.setScreenImage(screenImage);
        repaint();
    }

    public void UpdateScreen(HashMap<String, byte[]> changedBlocks) {
        updateScreenRect();

        screenImage = recorder.viewerOptions.getScreenImage();

        screenImage = recorder.viewerOptions.getCapture().
                setChangedBlocks(screenImage, changedBlocks);

        recorder.viewerOptions.setScreenImage(screenImage);

        repaint();
    }

    /*public void clearScreen() {
        setSize(new Dimension(1, 1));
        setPreferredSize(new Dimension(1, 1));
        //recorder.viewerOptions.getCapture().clearScreen();
        screenRect = Commons.emptyRect;
        oldScreenRect = Commons.diffRect; 
        recorder.viewerOptions.setScreenRect(Commons.emptyRect);
        recorder.viewer.setOption(Commons.RECT_OPTION);
        repaint();
    }*/


    public void DrawSelectingRect(Graphics g) {
        if (isSelecting)
            if (srcx != destx || srcy != desty) {
                // Compute upper-left and lower-right coordinates for selection
                // rectangle corners.

                int x1 = (srcx < destx) ? srcx : destx;
                int y1 = (srcy < desty) ? srcy : desty;

                int x2 = (srcx > destx) ? srcx : destx;
                int y2 = (srcy > desty) ? srcy : desty;

                // Establish selection rectangle origin.
                selectionRect.x = x1;
                selectionRect.y = y1;

                // Establish selection rectangle extents.
                selectionRect.width = (x2 - x1) + 1;
                selectionRect.height = (y2 - y1) + 1;

                // Draw selection rectangle.
                Graphics2D g2d = (Graphics2D) g;
//                g2d.setStroke(bs);
//                g2d.setPaint(gp);
                g2d.draw(selectionRect);

                PartialScreenMode = true;
            }
    }

    public boolean isPartialScreenMode() {
        return PartialScreenMode;
    }

    public void startSelectingMode() {
        isSelecting = true;
        Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
        setCursor(cursor);
    }

    public void stopSelectingMode() {
        PartialScreenMode = false;
        selectionRect = Commons.emptyRect;
        oldselectionRect = Commons.diffRect;
        //screenRect = Commons.emptyRect;
        recorder.viewerOptions.setScreenRect(new Rectangle(0, 0, 0, 0));
        if (recorder.config.reverseConnection)
            recorder.viewerOptions.setChanged(true);
        else
            recorder.viewer.setOption(Commons.RECT_OPTION);
    }

    public void doneSelecting() {
        if (isSelecting) {
            isSelecting = false;
            oldselectionRect = Commons.emptyRect;

            if (PartialScreenMode) {
                float screenScale = 1.0f / recorder.viewerOptions.getScreenScale();
                Rectangle rect = new Rectangle(selectionRect);
                rect.x = (int) (rect.x * screenScale);
                rect.y = (int) (rect.y * screenScale);
                rect.height = (int) (rect.height * screenScale);
                rect.width = (int) (rect.width * screenScale);
                recorder.viewerOptions.setScreenRect(rect);
                if (recorder.config.reverseConnection)
                    recorder.viewerOptions.setChanged(true);
                else
                    recorder.viewer.setOption(Commons.RECT_OPTION);
                recorder.viewerGUI.jBtnPartialComplete.setIcon(
                        new ImageIcon(Commons.DEFAULT_SCREEN_ICON));
            }

            srcx = destx;
            srcy = desty;

            Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
            setCursor(cursor);
        }
    }

    public List<Map.Entry<Point, Point>> getDrawOverlayPoints() {
        return points;
    }
}