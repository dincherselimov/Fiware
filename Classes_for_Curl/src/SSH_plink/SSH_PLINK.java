package SSH_plink;

import java.io.InputStream;
import java.io.OutputStream;

public class SSH_PLINK {
    private static String host = "192.168.0.104";
    private static String userName = "root";
    private static String password = "root";

    public static void main(String args[]) throws Exception
    {
        SSH_PLINK test=new SSH_PLINK();
        System.out.println(test.getLimServerStatus());
    }

    public String getLimServerStatus() throws Exception {

        try {
            String command = " D:/University/MANIK_IT/plink.exe/plink -v "+host+" -l "+userName+" -pw "+password;
            Runtime r = Runtime.getRuntime ();
            Process p = r.exec (command);
            Thread.sleep (1000);
            InputStream std = p.getInputStream ();
            OutputStream out = p.getOutputStream ();
            //InputStream err = p.getErrorStream ();

            out.write (" mosquitto_pub -t /ul/ABCDEF/id_sen1/attrs -m 'h|80|t|20' -h 192.168.0.104 -p 1883 -u dincher -P root\n\n".getBytes ());
            out.flush ();

            Thread.sleep (3000);

            int value = 0;
            String otherString=null;
            if (std.available () > 0) {
                value = std.read();
                otherString=String.valueOf((char) value);
                while (std.available() > 0) {
                    value = std.read();
                    otherString+=String.valueOf((char) value);
                }
            }

            int count=0;
            String[] lines = otherString.split("\r\n|\r|\n");
            for (String string : lines) {
                System.out.println(string+" :"+count++);
            }
            p.destroy ();
            return lines[lines.length-2]; // needed output is in third line.

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}