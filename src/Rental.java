import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rental{ 

  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;

//////////////////////////////////////////////////////////MAIN//////////////////////////////////////////
  public static void main(String[] args) {

    JFrame frame = new RentalView();
    ImageIcon img = new ImageIcon("\"D:\\CAPGEMINI TRAINING\\PROJECT\\ABC Car Rental\\/images/logo_1.GIF");
    frame.setIconImage(img.getImage());
    frame.setTitle("ABC Car Rental v.01");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true);
    frame.setResizable(false);
   }
}
