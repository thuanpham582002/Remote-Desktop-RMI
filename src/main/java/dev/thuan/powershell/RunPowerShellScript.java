package dev.thuan.powershell;

import dev.thuan.Commons;
import dev.thuan.viewer.ViewerGUI;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class RunPowerShellScript {

    private static String COMMAND = "Function Set-ScreenResolution { \n" +
            "\n" +
            "<# \n" +
            "    .Synopsis \n" +
            "        Sets the Screen Resolution of the primary monitor \n" +
            "    .Description \n" +
            "        Uses Pinvoke and ChangeDisplaySettings Win32API to make the change \n" +
            "    .Example \n" +
            "        Set-ScreenResolution -Width 1024 -Height 768         \n" +
            "    #> \n" +
            "param ( \n" +
            "[Parameter(Mandatory=$true, \n" +
            "           Position = 0)] \n" +
            "[int] \n" +
            "$Width, \n" +
            "\n" +
            "[Parameter(Mandatory=$true, \n" +
            "           Position = 1)] \n" +
            "[int] \n" +
            "$Height \n" +
            ") \n" +
            "\n" +
            "$pinvokeCode = @\" \n" +
            "\n" +
            "using System; \n" +
            "using System.Runtime.InteropServices; \n" +
            "\n" +
            "namespace Resolution \n" +
            "{ \n" +
            "\n" +
            "    [StructLayout(LayoutKind.Sequential)] \n" +
            "    public struct DEVMODE1 \n" +
            "    { \n" +
            "        [MarshalAs(UnmanagedType.ByValTStr, SizeConst = 32)] \n" +
            "        public string dmDeviceName; \n" +
            "        public short dmSpecVersion; \n" +
            "        public short dmDriverVersion; \n" +
            "        public short dmSize; \n" +
            "        public short dmDriverExtra; \n" +
            "        public int dmFields; \n" +
            "\n" +
            "        public short dmOrientation; \n" +
            "        public short dmPaperSize; \n" +
            "        public short dmPaperLength; \n" +
            "        public short dmPaperWidth; \n" +
            "\n" +
            "        public short dmScale; \n" +
            "        public short dmCopies; \n" +
            "        public short dmDefaultSource; \n" +
            "        public short dmPrintQuality; \n" +
            "        public short dmColor; \n" +
            "        public short dmDuplex; \n" +
            "        public short dmYResolution; \n" +
            "        public short dmTTOption; \n" +
            "        public short dmCollate; \n" +
            "        [MarshalAs(UnmanagedType.ByValTStr, SizeConst = 32)] \n" +
            "        public string dmFormName; \n" +
            "        public short dmLogPixels; \n" +
            "        public short dmBitsPerPel; \n" +
            "        public int dmPelsWidth; \n" +
            "        public int dmPelsHeight; \n" +
            "\n" +
            "        public int dmDisplayFlags; \n" +
            "        public int dmDisplayFrequency; \n" +
            "\n" +
            "        public int dmICMMethod; \n" +
            "        public int dmICMIntent; \n" +
            "        public int dmMediaType; \n" +
            "        public int dmDitherType; \n" +
            "        public int dmReserved1; \n" +
            "        public int dmReserved2; \n" +
            "\n" +
            "        public int dmPanningWidth; \n" +
            "        public int dmPanningHeight; \n" +
            "    }; \n" +
            "\n" +
            "\n" +
            "\n" +
            "    class User_32 \n" +
            "    { \n" +
            "        [DllImport(\"user32.dll\")] \n" +
            "        public static extern int EnumDisplaySettings(string deviceName, int modeNum, ref DEVMODE1 devMode); \n" +
            "        [DllImport(\"user32.dll\")] \n" +
            "        public static extern int ChangeDisplaySettings(ref DEVMODE1 devMode, int flags); \n" +
            "\n" +
            "        public const int ENUM_CURRENT_SETTINGS = -1; \n" +
            "        public const int CDS_UPDATEREGISTRY = 0x01; \n" +
            "        public const int CDS_TEST = 0x02; \n" +
            "        public const int DISP_CHANGE_SUCCESSFUL = 0; \n" +
            "        public const int DISP_CHANGE_RESTART = 1; \n" +
            "        public const int DISP_CHANGE_FAILED = -1; \n" +
            "    } \n" +
            "\n" +
            "\n" +
            "\n" +
            "    public class PrmaryScreenResolution \n" +
            "    { \n" +
            "        static public string ChangeResolution(int width, int height) \n" +
            "        { \n" +
            "\n" +
            "            DEVMODE1 dm = GetDevMode1(); \n" +
            "\n" +
            "            if (0 != User_32.EnumDisplaySettings(null, User_32.ENUM_CURRENT_SETTINGS, ref dm)) \n" +
            "            { \n" +
            "\n" +
            "                dm.dmPelsWidth = width; \n" +
            "                dm.dmPelsHeight = height; \n" +
            "\n" +
            "                int iRet = User_32.ChangeDisplaySettings(ref dm, User_32.CDS_TEST); \n" +
            "\n" +
            "                if (iRet == User_32.DISP_CHANGE_FAILED) \n" +
            "                { \n" +
            "                    return \"Unable To Process Your Request. Sorry For This Inconvenience.\"; \n" +
            "                } \n" +
            "                else \n" +
            "                { \n" +
            "                    iRet = User_32.ChangeDisplaySettings(ref dm, User_32.CDS_UPDATEREGISTRY); \n" +
            "                    switch (iRet) \n" +
            "                    { \n" +
            "                        case User_32.DISP_CHANGE_SUCCESSFUL: \n" +
            "                            { \n" +
            "                                return \"Success\"; \n" +
            "                            } \n" +
            "                        case User_32.DISP_CHANGE_RESTART: \n" +
            "                            { \n" +
            "                                return \"You Need To Reboot For The Change To Happen.\\n If You Feel Any Problem After Rebooting Your Machine\\nThen Try To Change Resolution In Safe Mode.\"; \n" +
            "                            } \n" +
            "                        default: \n" +
            "                            { \n" +
            "                                return \"Failed To Change The Resolution\"; \n" +
            "                            } \n" +
            "                    } \n" +
            "\n" +
            "                } \n" +
            "\n" +
            "\n" +
            "            } \n" +
            "            else \n" +
            "            { \n" +
            "                return \"Failed To Change The Resolution.\"; \n" +
            "            } \n" +
            "        } \n" +
            "\n" +
            "        private static DEVMODE1 GetDevMode1() \n" +
            "        { \n" +
            "            DEVMODE1 dm = new DEVMODE1(); \n" +
            "            dm.dmDeviceName = new String(new char[32]); \n" +
            "            dm.dmFormName = new String(new char[32]); \n" +
            "            dm.dmSize = (short)Marshal.SizeOf(dm); \n" +
            "            return dm; \n" +
            "        } \n" +
            "    } \n" +
            "} \n" +
            "\n" +
            "\"@ \n" +
            "\n" +
            "Add-Type $pinvokeCode -ErrorAction SilentlyContinue \n" +
            "[Resolution.PrmaryScreenResolution]::ChangeResolution($width,$height) \n" +
            "}\n";


    private static String getCommandFilePath(Rectangle rectangle) {
        try {
            // Create temp file
            Path tempFile = Files.createTempFile(null, ".ps1");

            // Open BufferedWriter on the file
            try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
                // Write COMMAND to the file
                writer.write(COMMAND);

                // Write invocation of Set-ScreenResolution with width and height
                writer.write("\nSet-ScreenResolution -Width " + rectangle.width + " -Height " + rectangle.height);
            }

            // Return the path of the temp file as a string
            return tempFile.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        RunPowerShellScript runPowerShellScript = new RunPowerShellScript();
        String path = runPowerShellScript.getCommandFilePath(new Rectangle(1920, 1080));
//        String path = runPowerShellScript.getCommandFilePath(new Rectangle(1366, 768));
        System.out.println(path);
    }

    public static void runPowerShellCommand(Rectangle rectangle) {
        String path = getCommandFilePath(rectangle);
        try {
            // Command to run PowerShell with the script
//            String path = System.getProperty("user.dir");
//            path += "\\src\\main\\java\\dev\\thuan\\powershell\\command_" + path + ".ps1";
            String command1 = "powershell.exe -ExecutionPolicy Bypass -File " + path;
            System.out.println(command1);
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command1);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            String output = readInputStream(process.getInputStream());
            int exitCode = process.waitFor();
            System.out.println("Output:\n" + output);
            System.out.println("Exit Code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runPowerShellCommand(int index) {
        Rectangle rectangle = null;
        if (index == -1) {
            rectangle = Commons.screenRect;
        } else {
            rectangle = Commons.SCREENREACTS.get(index);
        }
        String path = getCommandFilePath(rectangle);
        try {
            // Command to run PowerShell with the script
//            String path = System.getProperty("user.dir");
//            path += "\\src\\main\\java\\dev\\thuan\\powershell\\command_" + path + ".ps1";
            String command1 = "powershell.exe -ExecutionPolicy Bypass -File " + path;
            System.out.println(command1);
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command1);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            String output = readInputStream(process.getInputStream());
            int exitCode = process.waitFor();
            System.out.println("Output:\n" + output);
            System.out.println("Exit Code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String readInputStream(InputStream inputStream) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }
        return result.toString();
    }
}
