package pantalla;

import javax.swing.JComponent;

import javax.swing.JPanel;

import javax.swing.ImageIcon;

import frsf.cidisi.exercise.smarttoy.search.EnvironmentSmartToy;

import java.awt.Graphics;

import java.awt.Color;

public class Contenedor extends JComponent 
{
     static JPanel panel;
    
     static int columna = 0;
     
     static int fila =0;
     
     static int numeroHabitacion =1; //1..15
     

     
        
  public Contenedor(JPanel panel,  EnvironmentSmartToy environment)
  {
      this.panel = panel;
      
      numeroHabitacion = environment.getEnvironmentState().getUbicacionAgente().getFirst().getIdHabitacion();
      fila = environment.getEnvironmentState().getUbicacionAgente().getSecond()[0]*30;
      columna = environment.getEnvironmentState().getUbicacionAgente().getSecond()[1]*30;
      
      setBounds(0, 0,panel.getWidth() , panel.getHeight());
      
      
 }
    
  public void paint(Graphics g)
  {
    ImageIcon imagen =new ImageIcon(new ImageIcon(getClass().getResource("imagenes"+numeroHabitacion+".png")).getImage());
       
     g.drawImage(imagen.getImage(), 0, 0, imagen.getIconWidth()+100,imagen.getIconHeight()+100, this); 
     
     ImageIcon imagen2 =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/smartToy.png")).getImage());
     
     g.drawImage(imagen2.getImage(), columna, fila, 50, 30, null); 
    
     

     setOpaque(false);
     super.paintComponent(g);
  
  }       
  
  static Thread hilo = new Thread()
    {
       @Override
        public void run()
        {
            try
            {
                while(true)
                {
               //   numero++;
                  
                 // if(numero==8)
                  {
                   // numero=1;
                  }
                  
                 panel.repaint();  
                 
                 columna+=10;
                 
                  hilo.sleep(100);
                }
                
            } catch (java.lang.InterruptedException ex) {
                                                           System.out.println(ex.getMessage()); 
                                                         }
        }
    };
   
   public static void mover()
  {
     if(!hilo.isAlive())
    {
      hilo.start();
    }
      columna = 3;
    }
}










