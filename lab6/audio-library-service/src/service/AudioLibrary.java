package service;

import java.io.*;
import java.util.*;

public class AudioLibrary {
    public String musician_album(String musician){
        String name = new String();
        String line;
        try {
            FileReader fr = new FileReader("D:/jakarta-tomcat-5.0.28/audio-library.txt");
            BufferedReader in = new BufferedReader(fr);
            while ((line = in.readLine()) != null){
                String[] str = line.split(",");
                if (str[0].equals(musician)){ 
                    name = str[1]; 
                    break;
                }
                else 
                    name="NO SUCH MUSICIAN";			
            }						
	}
        catch (IOException e){
            e.printStackTrace();
        }
	return name;		
    }

    public String album_musician(String album){
	String phone = new String();
	String line;
	try {
            FileReader fr = new FileReader("D:/jakarta-tomcat-5.0.28/audio-library.txt");
            BufferedReader in = new BufferedReader(fr);
            while ((line = in.readLine()) != null){
                String[] str = line.split(",");
                if (str[1].equals(album)){ 
                    phone = str[0]; 
                    break;
                } else
                    phone="NO SUCH ALBUM";			
            }			
        } catch (IOException e) {
            e.printStackTrace();
        }		
        return phone;		
    }
}
