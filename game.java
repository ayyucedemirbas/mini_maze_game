/*2018

@author: ayyuce
*/

import java.applet.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JOptionPane;


public class game extends Applet implements KeyListener, Runnable {
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	
	int counter; 
	Thread cd;
	private static final long serialVersionUID = 1L;
    public int size =100;

      public void start() { 
      counter = 60; cd = new Thread(this); cd.start();
       }
       public void stop() { cd = null;}
        public void run() { 
          while (counter>0 && cd!=null) {
          try{Thread.sleep(1000);} catch (InterruptedException e){}
                       --counter; repaint(); //update screen
                          }
                    }

	public void paint(Graphics g){
		//g.drawLine(200+10,150-10, 200+190, 150-10);
		//g.drawLine(200+30,200-30, 200+190, 200-30);
		g.setColor(Color.BLUE);
		
		//1.Nesne Yatay
		g.fillRect(200+10, 150-10, 200+40, 150-10);
		g.fillRect(300+40, 150-10, 300+70, 150-10);
		
		//1. Nesne Dikey
		g.fillRect(200+10, 200-10, 200+10, 200-10);
		g.fillRect(200+10, 230-10, 200+10, 230-10);
		g.fillRect(200+10, 260-10, 200+10, 260-10);
		g.fillRect(200+10, 290-10, 200+10, 290-10);
		g.fillRect(200+10, 320-10, 200+10, 320-10);
		g.fillRect(200+10, 350-10, 200+10, 350-10);
		g.fillRect(200+10, 380-10, 200+10, 380-10);
		
		
		//2.Nesne Dikey
		
		g.fillRect(600+300, 90-10, 100+100, 150-10);
		g.fillRect(600+300, 150-10, 100+100, 210-10);
		g.fillRect(600+300, 210-10, 100+100, 270-10);
		g.fillRect(600+300, 270-10, 100+100, 330-10);
		
		//2.Nesne Yatay
		g.fillRect(600+100,400, 200, 180);
		g.fillRect(600+30,400, 200, 180);
		
		//3.Nesne
		//g.fillRect(1000+300, 90-10, 100+100, 150-10);
		g.fillRect(1000+300, 30-10, 100+100, 90-10);
		g.fillRect(1000+300, 90-10, 100+100, 150-10);
		g.fillRect(1000+300, 150-10, 100+100, 210-10);
		g.fillRect(1000+300, 210-10, 100+100, 270-10);
		g.fillRect(1000+300, 270-10, 100+100, 330-10);
		g.fillRect(1000+300, 330-10, 100+100, 390-10);
		g.fillRect(1000+300, 390-10, 100+100, 350-10);
		g.fillRect(1000+300, 450-10, 100+100, 390-10);
		
		
		
		//g.setColor(Color.RED); //Topun rengi kirmizi olacak
		
		//g.fillOval(MoveX, MoveY, size, size); //Top ciziliyor
		player2.paint2(g);
		player.paint(g);
		g.drawString("Counter: "+String.valueOf(counter) +" seconds left",60,110);
		g.setColor(Color.MAGENTA);
		g.drawString("AYYUCE'S MINI MAZE GAME ",120,50);
		int x= player.x;
		int y=player.y;
		int x1=player.x1;
		int y1=player.y1;
	if(counter==0){
		infoBox("Time is up! Please try again","Sorry");
		
	}
              if(x==x1&&y==y1){
            	  g.setColor(Color.RED);
			 g.drawString("Congrats!", 60, 90);
			 stop();
			 if(counter>=30)
			 {
				 infoBox("You are successful!","Congrats :)");
				 
			 }
			 else if(counter<30&&counter>20)
			 {
				 infoBox("You win!","Congrats :)");
				 
			 }
			 else{
			 infoBox("Too slow!","Congrats :)");}
			 
		 }
		
	}

	 Player player, player2;

	    @Override
	    public void init() {
	        player = new Player(getImage(50));
	        player2=new Player(getImage2(50));
	        addKeyListener(this);
	        setFocusable(true);
	        requestFocusInWindow();
	    }

	   

	    public Image getImage(int size) {//Hedefe ulasacak top
	        Image img = createImage(size,size);
	        Graphics g = img.getGraphics();
	        g.setColor(Color.RED);
	        g.fillOval(0,0,size,size);
           
	        g.dispose();

	       
	        return img;
	    }
	    
	    public Image getImage2(int size) {//Hedef noktasi
	  	  
	        Image img2=  createImage(size, size);
	        Graphics g1=img2.getGraphics();
	        g1.setColor(Color.CYAN);
	        g1.fillOval(0, 0, size, size);
	        g1.dispose();
	        return img2;
	    }

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	
		 switch (e.getKeyCode()) {
         case KeyEvent.VK_LEFT:
             player.x -= 5;
             break;
         case KeyEvent.VK_RIGHT:
             player.x += 5;
             break;
         case KeyEvent.VK_DOWN:
             player.y += 5;
             break;
         case KeyEvent.VK_UP:
             player.y -= 5;
             break;
     }
		 
		
     repaint();
	}


	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		 return;
	}


	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		return;
		
	}

		
}

class Player {
	 public int count=0;

    Image image;
    int x;
    int y;
    int x1;
    int y1;

    public Player(Image image) {
        x = 210;
        y = 800;
        x1= 1600;
        y1=100;
        this.image = image;
       
    }

    public void paint(Graphics g) {//Metot icindeki if yapilari, top cisimlere carptiginda topu baslangic noktasina atar
    	//if yapilari icindeki esitlikler asagidaki C# kodunun ciktisi ile elde edildi. Tek Tek yazmadim :P
    	/*for (int i = 115; i <= 260; i += 5) {
				Console.Write ("y=="+i+"||");
			}
*/
        g.drawImage(image, x, y, null);
        String ValueX=Integer.toString(x);
		String ValueY=Integer.toString(y);
		g.drawString("X: "+ ValueX, 60, 50);
		g.drawString("Y: "+ValueY, 60, 70);
		//Top bloklara carparsa veya yolun disina cikarsa baslangic noksasina doner,  The ball returns to the starting point if it hits the blocks or gets out of the window .
		if(y==735){
		if(x==195||x==200||x==205||x==210||x==215||x==220||x==225||x==230||x==235||x==240||x==245||x==250||x==255||x==260||x==265||x==270||x==275||x==280||x==285||x==290||x==295||x==300||x==305||x==310||x==315||x==320||x==325||x==330||x==335||x==340||x==345||x==350||x==355||x==360||x==365||x==370||x==375){
			
			x=210;
		    y=800;
		
		
		g.drawImage(image, x, y, null);
		}
		else{
			g.drawImage(image, x, y, null);
		}
		}
		
		if(x==1065 && y!=10){
			if(y==15){g.drawImage(image, x, y, null);}
			else if(y==5){g.drawImage(image, x, y, null);}
			else if(y==20){g.drawImage(image, x, y, null);}
			else if(y==25){g.drawImage(image, x, y, null);}
			else if(y==30){g.drawImage(image, x, y, null);}
			else{
			g.setColor(Color.WHITE);
			g.drawImage(image, x, y, null);
		      x=210;
		      y=800;
		      
		
		g.drawImage(image, x, y, null);}
		}
		
		if(x==585){
			if(y==350||y==355 ||y==360 ||y==365 ||y==370 ||y==375||y==380||y==385||y==390||y==395||y==400||y==405||y==410||y==415||y==420||y==425||y==430||y==435||y==440||y==445||y==450||y==455||y==460||y==465||y==470||y==475||y==480||y==485||y==490||y==495||y==500||y==505||y==510||y==515||y==520||y==525||y==530||y==535||y==540||y==545||y==550||y==555||y==560||y==565||y==570){
				x=210;
			      y=800;
			
			
			g.drawImage(image, x, y, null);
			}
			else{
				g.drawImage(image, x, y, null);
			}
			
		}
		
		if(y==270){
			if(x==415||x==420||x==425||x==430||x==435||x==440||x==445||x==450||x==455||x==460||x==465||x==470||x==475||x==480||x==485||x==490||x==495||x==500||x==505||x==510||x==515||x==520||x==525||x==530||x==535||x==540||x==545||x==550||x==555||x==560||x==565||x==570||x==575||x==580||x==585||x==590||x==595||x==600||x==605||x==610||x==615||x==620||x==625||x==630||x==635||x==640||x==645||x==650||x==655||x==660||x==665||x==670||x==675){
				x=210;
			      y=800;
			
			
			g.drawImage(image, x, y, null);
			}
			
			else{
				g.drawImage(image, x, y, null);
				
			}
			
		}
		
		
		if(x==165){
			if(y==740||y==745||y==750||y==755||y==760||y==765||y==770||y==775||y==780||y==785||y==790||y==795||y==800||y==805||y==810||y==815||y==820||y==825||y==830||y==835||y==840||y==845||y==850||y==855||y==860||y==865||y==870||y==875||y==880||y==885||y==890||y==895||y==900||y==905||y==910||y==915||y==920||y==925||y==930||y==935||y==940||y==945||y==950||y==955||y==960||y==965){
				g.drawImage(image, x, y, null);
			}
			
			else{
				x=210;
			    y=800;

			g.drawImage(image, x, y, null);
				
				
			}
			
		}
		
		if(x==850){
			if(y==75||y==80||y==85||y==90||y==95||y==100||y==105||y==110||y==115||y==120||y==125||y==130||y==135||y==140||y==145||y==150||y==155||y==160||y==165||y==170||y==175||y==180||y==185||y==190||y==195||y==200||y==205||y==210||y==215||y==220||y==225||y==230||y==235||y==240||y==245||y==250||y==255||y==260||y==265||y==270||y==275||y==280||y==285||y==290||y==295||y==300||y==305||y==310||y==315||y==320||y==325||y==330||y==335||y==340||y==345||y==350){
				x=210;
			    y=800;

			g.drawImage(image, x, y, null);
			}
			
			else{
				g.drawImage(image, x, y, null);
				
			}
		}
		
		
		if(y==350){
			
			if(x==610||x==615||x==620||x==625||x==630||x==635||x==640||x==645||x==650||x==655||x==660||x==665||x==670||x==675||x==680||x==685||x==690||x==695||x==700||x==705||x==710||x==715||x==720||x==725||x==730||x==735||x==740||x==745||x==750||x==755||x==760||x==765||x==770||x==775||x==780||x==785||x==790||x==795||x==800||x==805||x==810||x==815||x==820||x==825||x==830||x==835||x==840||x==845){
				x=210;
			    y=800;

			g.drawImage(image, x, y, null);
			
				
				
				
			}
			
			
			
			else{
				g.drawImage(image, x, y, null);
				
			}
		}
		
		
		if(x==410){
			
			if(y==740||y==745||y==750||y==755||y==760||y==765||y==770||y==775||y==780||y==785||y==790||y==795||y==800||y==805||y==810||y==815||y==820||y==825||y==830||y==835||y==840||y==845||y==850||y==855||y==860||y==865||y==870||y==875||y==880||y==885||y==890||y==895||y==900||y==905||y==910||y==915||y==920||y==925||y==930||y==935||y==940||y==945||y==950||y==955||y==960||y==965){
				g.drawImage(image, x, y, null);
			}
			
			else{
				x=210;
			    y=800;

			g.drawImage(image, x, y, null);
				
				
			}
			
		}
		
		if(y==575){
			if(x==595||x==600||x==605||x==610||x==615||x==620||x==625||x==630||x==635||x==640||x==645||x==650||x==655||x==660||x==665||x==670||x==675||x==680||x==685||x==690||x==695||x==700||x==705||x==710||x==715||x==720||x==725||x==730||x==735||x==740||x==745||x==750||x==755||x==760||x==765||x==770||x==775||x==780||x==785||x==790||x==795||x==800||x==805||x==810||x==815||x==820||x==825||x==830||x==835||x==840||x==845||x==850||x==855||x==860||x==865||x==870||x==875||x==880||x==885||x==890||x==895||x==900||x==905||x==910||x==915||x==920||x==925||x==930||x==935||x==940||x==945||x==950||x==955||x==960||x==965||x==970||x==975||x==980||x==985||x==990||x==995||x==1000||x==1005||x==1010||x==1015||x==1020||x==1025||x==1030||x==1035||x==1040||x==1045||x==1050||x==1055||x==1060){
				x=210;
			    y=800;

			g.drawImage(image, x, y, null);
			}
			else{
				g.drawImage(image, x, y, null);
			}
		}
		
		
		if(x==710){
			if(y==0||y==5||y==10||y==15||y==20||y==25||y==30||y==35||y==40||y==45||y==50||y==55||y==60||y==65||y==70||y==75||y==80||y==85||y==90||y==95||y==100){
				x=210;
			    y=800;

			g.drawImage(image, x, y, null);
			}
			else{
				g.drawImage(image, x, y, null);
			}
		}
		
		if(x==710){
			if(y==115||y==120||y==125||y==130||y==135||y==140||y==145||y==150||y==155||y==160||y==165||y==170||y==175||y==180||y==185||y==190||y==195||y==200||y==205||y==210||y==215||y==220||y==225||y==230||y==235||y==240||y==245||y==250||y==255||y==260){
				
				x=210;
			    y=800;

			g.drawImage(image, x, y, null);
			}
			else{
				g.drawImage(image, x, y, null);
			}
		}
		
		if(x==1500){
			
			if(y==815||y==820||y==825||y==830||y==835||y==840||y==845||y==850||y==855||y==860||y==865||y==870||y==875||y==880||y==885||y==890||y==895||y==900||y==905||y==910||y==915||y==920||y==925||y==930||y==935||y==940||y==945||y==950||y==955||y==960||y==965||y==970){
				g.drawImage(image, x, y, null);
			}
			
			else{
				x=210;
			    y=800;

			g.drawImage(image, x, y, null);
			}
		}
		
		
		if(x==1250){
		      if(y==815||y==820||y==825||y==830||y==835||y==840||y==845||y==850||y==855||y==860||y==865||y==870||y==875||y==880||y==885||y==890||y==895||y==900||y==905||y==910||y==915||y==920||y==925||y==930||y==935||y==940||y==945||y==950||y==955||y==960){
		    	  g.drawImage(image, x, y, null);
		    	  
		      }
			
		      else{
		    	  x=210;
			      y=800;
			
			
			g.drawImage(image, x, y, null);
		    	  
		      }
		
		
		}
		
		 
		
		g.setColor(Color.RED);
		
    }
   

    public void paint2(Graphics g) {//Hedef Noktasi icin
    	
        g.drawImage(image, x1, y1, null);
    }

}	
		
		
		
		
		
		
	


