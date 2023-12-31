/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.thuan.viewer;

import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import dev.thuan.viewer.FileMng.FilesDropTargetListener;

/**
 *
 */
public class EventsListener {

    private final ScreenPlayer player;
    private boolean isActive = false;

    private final KeyAdapter keyAdapter;
    private final MouseAdapter mouseAdapter;
    private final MouseWheelListener mouseWheelListener;
    private final MouseMotionAdapter mouseMotionAdapter;
    private final FilesDropTargetListener filesDropTargetListener;
    private final DropTarget dropTarget;

    private ArrayList<KeyEventWrapper> keyEvents = new ArrayList<KeyEventWrapper>();
    private ArrayList<MouseEvent> mouseEvents = new ArrayList<MouseEvent>();

    public EventsListener(Recorder recorder) {
        player = recorder.screenPlayer;

        keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keyEvents.add(new KeyEventWrapper(e));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keyEvents.add(new KeyEventWrapper(e));
            }
        };

        mouseWheelListener = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                mouseEvents.add(e);
            }
        };

        mouseMotionAdapter = new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseEvents.add(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (player.isSelecting || player.drawOverlay) {
                    player.destx = e.getX();
                    player.desty = e.getY();
                    player.repaint();
                } else
                    mouseEvents.add(e);
            }
        };

        mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (player.isSelecting || player.drawOverlay) {
                    player.destx = player.srcx = e.getX();
                    player.desty = player.srcy = e.getY();
                } else
                    mouseEvents.add(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                player.doneSelecting();
                mouseEvents.add(e);
            }
        };

        filesDropTargetListener = new FilesDropTargetListener(recorder);
        dropTarget = new DropTarget();
        dropTarget.setComponent(player);
    }

    public ArrayList<MouseEvent> getMouseEvents() {
        ArrayList<MouseEvent> _mouseEvents = new ArrayList<MouseEvent>();

        synchronized (mouseEvents) {
            _mouseEvents = mouseEvents;
            mouseEvents = new ArrayList<MouseEvent>();
        }

        return _mouseEvents;
    }

    public ArrayList<KeyEventWrapper> getKeyEvents() {
        ArrayList<KeyEventWrapper> _keyEvents = new ArrayList<KeyEventWrapper>();

        synchronized (keyEvents) {
            _keyEvents = keyEvents;
            keyEvents = new ArrayList<KeyEventWrapper>();
        }

        return _keyEvents;
    }

    public boolean isActive() {
        return isActive;
    }

    public void addAdapters() {
        addAdapters(false);
    }

    public void addAdapters(boolean all) {
        if (isActive) return;
        player.addKeyListener(keyAdapter);
        player.addMouseWheelListener(mouseWheelListener);
        player.addMouseMotionListener(mouseMotionAdapter);
        player.addMouseListener(mouseAdapter);
        if (all)
            try {
                dropTarget.addDropTargetListener(filesDropTargetListener);
            } catch (Exception e) {
                e.printStackTrace();
            }
        isActive = true;
    }

    public void removeAdapters() {
        removeAdapters(false);
    }

    public void removeAdapters(boolean all) {
        if (!isActive) return;
        player.removeKeyListener(keyAdapter);
        player.removeMouseWheelListener(mouseWheelListener);
        player.removeMouseMotionListener(mouseMotionAdapter);
        player.removeMouseListener(mouseAdapter);
        if (all)
            dropTarget.removeDropTargetListener(filesDropTargetListener);
        isActive = false;
    }
}
