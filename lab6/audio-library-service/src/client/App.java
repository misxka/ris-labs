package client;

import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import javax.xml.rpc.ServiceException;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ServiceException, MalformedURLException {
        String endpoint = "http://localhost:8080/axis/AudioLibrary.jws";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new URL(endpoint));

        System.out.println("1 - Enter the musician name");
        System.out.println("2 - Enter the album name");
        System.out.println("3 - Exit");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            line = in.readLine();
            while(!line.equals("3")) {
          	if (line.equals("3")) break;
                if (line.equals("1")) {
                    String musician = in.readLine();
                    Object[] param = new Object[]{musician};
                    String response = (String) call.invoke("musician_album", param);
                    System.out.println("MUSICIAN = " + musician + "\n" + "ALBUM = " + response);
                }
                if (line.equals("2")) {
                    String album = in.readLine();
                    Object[] param = new Object[]{album};
                    String response = (String) call.invoke("album_musician", param);
                    System.out.println("ALBUM = " + album + "\n" + "MUSICIAN = " + response);
                }
                System.out.println("1 - Enter the musician name");
                System.out.println("2 - Enter the album name");
                System.out.println("3 - Exit");
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
