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
    	   Qrcode qe=new Qrcode();
    	 //  qe.setQrcodeVersion(10);
    	   qe.setQrcodeEncodeMode('B');
String base="iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAMAAADXqc3KAAACDVBMVEUAAAArMToqLzgqMDknKzAoKSwiJi0qMDkjKC4/SFU3PkklKjIoLTUtMz0uNT4aHCALCgo7NjgjJy4ODg5TXGkyOkQtKyqkiW8zMTGoeF05Qk8uND2jnJ0oLTU/OTMzO0VoWEjgtIsmLDMxN0EbGhozMTGdfGUyKieFVkE/SFVsV0QlJCQ/SVUsMjsWFRRSUVEwN0EzOkQ5LCciJy0kIiJOTU0pLzcjKC85QU0kKTCMdmvTtJclJSQwKyohHx8sKyvtyJ9xeIMiICBJR0cWFBQuLCx0VEUsMjsQDxBJS08WFRUUFBf5z6AqLzgpLjY0O0YyOUMtND1DTFoxOEInLDQwLS1BSlg5QUw2PUkwNkApLzccGxq2trw+R1Q9RVJBR1E7Q1A/PDwsMjs7OTkrMTkmJCMkIyLFytKwtL3x0Krnw57nv5aHiZFscXldZGzKjGebeWZFT11aWllNS0tJRkZEODMjKC8sKyshHx8ZGBjh5u/W19nLy9C6ub+qsLjsz66lpayenqblw6GWk5m5o5fHq5LiuJDQrY/csY3er4vHpYvarIl5f4mYi4jSooNxeIPVpoHNm3y7lHdpbXbOmXW8kXSjhHKdfXCCdXCDdHDEjWyjh2xrampMV2eEa1+Qc156Z1xUVFRSUFCDYk2WY0lCQUFaQTZKPTZ6SjVMNzBaOCocICYtJyQsJiQVFBS44Ku9AAAAT3RSTlMAFQxQHA/8+ufZ2dKAWUU6LiwsIfz8/Pr6+Pj49/f18u/u7Orq5+Hg3NPMyMfHx8XEw8C9ube2sKynmZaTi4qGg3l3dXFsZmZZVVRMNyYIMLd0OQAAAVxJREFUKM9lz1N3A1EUBeAkTY0ktW3btsexbbO2bdv6jX3qmsz0PO5v3XvOpvwNta+uopURSCEPszZR5njOLekhUUy514Mp7PdqWQcRegUCNaZwXtkVeUwCtKt9AszpeLhLSB8kQDcm+FHJMNeyLnOEAMPxKp/X8307e1lMJy4veFV9ud4f926aSee2vXw8WbdPjzZaSECvfrOs6Nc2DZ3khqxCi0Gn38ka/de9P2l9YfU4f4hOyqldqScHF/vnyWGRhDygMlajPbMuGWFOFQ2PaREZMHtrQrso3BUBOSwcBuLga7ZkRiOcMkm5KVE4NIptMBswTwqnzRwkOAD/qRQWi2xSwDQ3L+FCafgLahEb4HLEXPDQyEH4IWM4hIpAEERAEJAAcrRp3A+kPB7CgyCIh6Dh0X7lwgC+EpIrlXwouMEvpwSWyd1uPoqi2fWRNGLv8KDPoJCaCAYe/wKVBF1ksOhW+QAAAABJRU5ErkJggg==";

          String str = "BEGIN:VCARD\n" + 
		  "PHOTO;ENCODING=b:"+base+"\n"+
		  "N:杨\n"+
		  "FN:旭\n" + 
		  "ORG:河北科技师范学院\n" + 
		  "TITLE:java开发工程师\n" + 
		  "ADR;WORK:秦皇岛金梦海湾第嘉传媒\n" + 
		   "ADR;HOME:\n" + 
		  "TEL;CELL,VOICE:136915564002\n" + 
		  "TEL;WORK,VOICE:0335-1111111\r\n" + 
		  "URL;WORK;:http://www.so.com\n" + 
		  "EMAIL;INTERNET,HOME:1943053456@qq.com\n" + 
		  "END:VCARD";
    	 //  int ver=5;
          boolean[][] find=qe.calQrcode(str.getBytes());
    	   int nx=67+12*(qe.getQrcodeVersion()-1); 
    
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
    	  
     
    	  
    	  for(int i=0;i<find.length;i++) {
    		  for(int j=0;j<find.length;j++) {
    			  if(find[i][j]) {
    					 int num1 = startR + (endR - startR) * (i+1)/find.length;
    					 int num2 = startG + (endG - startG) * (i+1)/find.length;
    					 int num3 = startB + (endB - startB) * (i+1)/find.length;
  					 g2.setColor(new Color(num1,num2,num3));
    				  g2.fillRect(i*3+2, j*3+2, 3, 3);
    			  }
    		  }
    	  }
     
        
    	   Image image=ImageIO.read(new File("girl.png"));
           g2.drawImage(image, (nx-30)/2,(nx-30)/2,30,30,null);
           g2.dispose();
     	  bimage.flush();
    	  ImageIO.write(bimage, "png", new File("D:\\二维码.png"));
    	   
    	  System.out.println("ok");
       }
}
