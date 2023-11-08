package dev.thuan;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import dev.thuan.utilities.FileUtility;
import dev.thuan.utilities.ImageUtility;
import dev.thuan.utilities.InetAdrUtility;

/**
 * Commons.java
 *
 * @author PPU, benbac
 */

public class Commons {
    public static final String rmiBindingName = "noRoom2013";

    public static final boolean serverSide = true;
    public static final boolean viewerSide = false;

    public static String defaultServerAddress = "127.0.0.1";
    public static final int defaultHttpPort = 6666;
    public static final int defaultServerPort = 1099;
    public static final String defaultUsername = "admin";
    public static final String defaultPassword = "admin";
    public static final boolean defaultSSL = false;
    public static final boolean defaultMultihome = false;
    public static final boolean defaultAddress = true;
    public static final boolean reverseConnection = false;
    public static final boolean hideMainWindow = false;
    public static final boolean noSysTray = false;
    public static final int proxyPort = 80;
    public static final String proxyServer = "127.0.0.1";

    public static final URL IDLE_ICON = Main.class.getResource("images/idle.png");
    public static final URL ALIVE_ICON = Main.class.getResource("images/background.png");
    public static final URL WAIT_ICON = Main.class.getResource("images/display.png");
    public static final URL START_ICON = Main.class.getResource("images/player_play.png");
    public static final URL STOP_ICON = Main.class.getResource("images/player_stop.png");
    public static final URL PAUSE_ICON = Main.class.getResource("images/player_pause.png");
    public static final URL INPUTS_ICON = Main.class.getResource("images/input_devices.png");
    public static final URL LOCKED_INPUTS_ICON = Main.class.getResource("images/locked_inputs.png");
    public static final URL FULL_SCREEN_ICON = Main.class.getResource("images/view_fullscreen.png");
    public static final URL NORMAL_SCREEN_ICON = Main.class.getResource("images/view_nofullscreen.png");
    public static final URL DEFAULT_SCREEN_ICON = Main.class.getResource("images/default_screen.png");
    public static final URL CUSTOM_SCREEN_ICON = Main.class.getResource("images/custom_screen.png");

    public static final String DEFAULT_CONFIG = "<default config>";
    public static String HOME_DIR = "./";
    public static String CONFIG_FILE = "noRoom2013.conf";
    public static String downloadsLocation = "./";

    public static String KEY_STORE = "keystore";
    public static String TRUST_STORE = "truststore";

    public static float java_version = 1.5f;
    public static final String noRoom2013_version = "week 2";
    public static String noRoom2013_build_date = "2009-09-16";

    public static final byte RECT_OPTION = 0;
    public static final byte IMAGE_OPTION = 1;
    public static final byte COLOR_OPTION = 2;
    public static final byte CLIPBOARD_OPTION = 3;

    public static final Rectangle emptyRect = new Rectangle(0, 0, 0, 0);
    public static final Rectangle diffRect = new Rectangle(-1, -1, -1, -1);

    public static final byte defaultColorQuality = BufferedImage.TYPE_INT_RGB;
    public static final byte cqFull = BufferedImage.TYPE_INT_RGB;
    public static final byte cq16Bit = BufferedImage.TYPE_USHORT_555_RGB;
    public static final byte cq256 = BufferedImage.TYPE_BYTE_INDEXED;
    public static final byte cqGray = BufferedImage.TYPE_BYTE_GRAY;

    final static public byte SERVER_STARTED = 1;
    final static public byte SERVER_STOPPED = 2;
    final static public byte CONNECTION_FAILED = 3;
    final static public byte SERVER_RUNNING = 4;
    final static public byte SERVER_NOT_RUNNING = 5;

    final static public String LOOK_AND_FILL_SYSTEM = "System";
    final static public String LOOK_AND_FILL_WINDOWS = "Windows";
    final static public String LOOK_AND_FILL_WINDOWS_CLASSIC = "Windows Classic";
    final static public String LOOK_AND_FILL_GTK = "GTK+";
    final static public String LOOK_AND_FILL_MOTIF = "CDE/Motif";
    final static public String LOOK_AND_FILL_METAL = "Metal";
    final static public String LOOK_AND_FILL_MACOSX = "Mac OS X";

    final static public byte DISPLAY_MODE_FRAME = 0;
    final static public byte DISPLAY_MODE_APPLET = 1;
    final static public byte DISPLAY_MODE_EXTENSION = 2;

    public static void init() {
        if (System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityMng());

        ImageUtility.init();

        SystemProperties.clear();
        defaultServerAddress = InetAdrUtility.getLocalHost().getHostAddress();
        HOME_DIR = SystemProperties.getHomeDirectory() + File.separatorChar;
        downloadsLocation = HOME_DIR + "Downloads" + File.separatorChar;
        HOME_DIR += ".noRoom2013" + File.separatorChar;
        CONFIG_FILE = HOME_DIR + "noRoom2013.conf";
        TRUST_STORE = HOME_DIR + "truststore";
        KEY_STORE = HOME_DIR + "keystore";
        java_version = SystemProperties.getJavaVersion();
        noRoom2013_build_date = FileUtility.getBuiltDate();
    }
}