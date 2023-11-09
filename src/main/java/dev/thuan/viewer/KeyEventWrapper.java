package dev.thuan.viewer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.Serializable;

public class KeyEventWrapper implements Serializable {
    private final int keyCode;
    private final char keyChar;
    private final int keyLocation;
    private final int id;
    private final boolean isActionKey;

    public KeyEventWrapper(KeyEvent keyEvent) {
        this.keyCode = keyEvent.getKeyCode();
        this.keyChar = keyEvent.getKeyChar();
        this.keyLocation = keyEvent.getKeyLocation();
        this.id = keyEvent.getID();
        this.isActionKey = keyEvent.isActionKey();
    }

    // getters
    public int getKeyCode() {
        return keyCode;
    }

    public char getKeyChar() {
        return keyChar;
    }

    public int getKeyLocation() {
        return keyLocation;
    }

    public int getId() {
        return id;
    }

    public boolean isActionKey() {
        return isActionKey;
    }

    public KeyEvent toKeyEvent() {
        return new KeyEvent(
                new Button(),
                this.id,
                System.currentTimeMillis(),
                0,
                this.keyCode,
                this.keyChar
        );
    }
}