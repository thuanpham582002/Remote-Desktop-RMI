package dev.thuan.rmi.server;

import java.awt.*;
import java.net.InetAddress;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;
import java.util.List;

/**
 * ServerInterface.java
 */

public interface ServerInterface extends Remote {

    boolean isOptionsChanged(int index) throws RemoteException;

    void setOptionsChanged(int index, boolean bool) throws RemoteException;

    int startViewer(InetAddress inetAddress,
                    String username, String password, boolean isReversedConnection) throws RemoteException;

    void stopViewer(int index) throws RemoteException;

    void sendMessage(String message, InetAddress address) throws RemoteException;

    Queue<String> receiveMessage(InetAddress address) throws RemoteException;

    HashMap<String, byte[]> getChangedScreenBlocks(int index,
                                                   boolean isEmpty) throws RemoteException;

    void setChangedScreenBlocks(HashMap<String, byte[]> changedBlocks,
                                int index) throws RemoteException;

    byte[] getScreenCapture(int index) throws RemoteException;

    void setScreenCapture(byte[] data, int index) throws RemoteException;

    Rectangle getScreenRect(int index) throws RemoteException;

    void setScreenRect(Rectangle rect, int index) throws RemoteException;

    void setScreenResolution(int index) throws RemoteException;

    ArrayList getMouseEvents(int index) throws RemoteException;

    void setMouseEvents(int index, ArrayList events) throws RemoteException;

    ArrayList getKeyEvents(int index) throws RemoteException;

    void setKeyEvents(ArrayList events) throws RemoteException;

    void setDrawOverlayPoint(List<Map.Entry<Point, Point>> points, InetAddress address) throws RemoteException;

    Object getClipboardContent() throws RemoteException;

    void setClipboardContent(Object object) throws RemoteException;

    Object getClipboardContent(int index) throws RemoteException;

    void setClipboardContent(Object object, int index) throws RemoteException;

    Object getOptions(int index) throws RemoteException;

    void setOptions(Object data, int index) throws RemoteException;

    Object getOption(int index, int option) throws RemoteException;

    void setOption(Object data, int index, int option) throws RemoteException;

    ArrayList getFileList() throws RemoteException;

    byte[] ReceiveFile(String fileName, int index) throws RemoteException;

    void SendFile(byte[] filedata, String fileName, int index) throws RemoteException;

    ArrayList getConnectionInfos(int index) throws RemoteException;

    Hashtable getHostProperties() throws RemoteException;

    void setHostProperties(int index, Hashtable props) throws RemoteException;
}
