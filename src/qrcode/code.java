package qrcode;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;
public class code {
       public static void main(String[] args) throws IOException
       {


    	   int ver=5;
    	   int nx=(21+(ver-1)*4)*3+8;
    	   Qrcode qe=new Qrcode();
    	   qe.setQrcodeVersion(5);
    	  BufferedImage bimage=new BufferedImage(nx,nx,BufferedImage.TYPE_INT_BGR);
    	  
    	  Graphics2D g2=bimage.createGraphics();
    	  g2.setColor(Color.BLACK);
    	  //

    	 g2.setBackground(Color.WHITE);
    	 

 		int startR = 220;
 		int startG = 40;
 		int startB = 60;
 		
 		int endR = 200;
 		int endG = 62;
 		int endB = 250;
 		
    	  g2.clearRect(0, 0, nx,nx);
    	  
    	  String str="http://www.baidu.com/";
    	  boolean[][] find=qe.calQrcode(str.getBytes());
    	  for(int i=0;i<find.length;i++) {
    		  for(int j=0;j<find.length;j++) {
    			  if(find[i][j]) {
    					 int num1 = startR + (endR - startR) * (i+1)/find.length;
    					 int num2 = startG + (endG - startG) * (i+1)/find.length;
    					 int num3 = startB + (endB - startB) * (i+1)/find.length;
  					 g2.setColor(new Color(num1,num2,num3));
    				  g2.fillRect(i*3+4, j*3+4, 3, 3);
    			  }
    		  }
    	  }
     
          Image image=ImageIO.read(new File("girl.png"));
          g2.drawImage(image, (nx-30)/2,(nx-30)/2,30,30,null);
    	  g2.dispose();
    	  bimage.flush();
    	  ImageIO.write(bimage, "png", new File("D:\\二维码.png"));
       }
}
