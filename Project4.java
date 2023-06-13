import java.net.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Project4 extends JFrame{

  JPanel jp = new JPanel();
  JLabel jlA = new JLabel();
  JLabel jlOutput = new JLabel();
  JTextArea jtA = new JTextArea(10,40);
  JButton jb = new JButton("Update");

  public Project4() throws IOException{

    setTitle("Radford Traffic Incidents");
    setVisible(true);
    setSize(800,200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

  jp.add(jtA);
  jtA.add(jlA);
  jp.add(jlA);
  jp.add(jb);

    jb.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          action();
          //String inputA = jtA.getText();

        }
    });
    add(jp);
  }

  public void action(){

try{
  URL oracle = new URL("https://www.mapquestapi.com/traffic/v2/incidents?&outFormat=json&boundingBox=37.6000882015635%2C-79.54513549804688%2C36.73558251123296%2C-81.16012573242188&key=Q5MjXeUeOsl8QwXQwkE3MUwB5dAXNxuw");
    BufferedReader in = new BufferedReader(
    new InputStreamReader(oracle.openStream()));

    String inputLine;
    File path = new File("output.txt");
    OutputStream outStream = new FileOutputStream(path);
    while ((inputLine = in.readLine()) != null){
        outStream.write(inputLine.getBytes());
        outStream.close();
        in.close();
      }
    }
      catch(Exception e){
        System.out.println("failed");
      }

  }

    public static void main(String[] args)throws IOException{

      Project4 A = new Project4();

    }
}
