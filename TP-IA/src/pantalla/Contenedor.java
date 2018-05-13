package pantalla;

import javax.swing.JComponent;

import javax.swing.JPanel;

import javax.swing.ImageIcon;

import frsf.cidisi.exercise.smarttoy.search.EnvironmentSmartToy;
import frsf.cidisi.exercise.smarttoy.search.EnvironmentSmartToyState;

import java.awt.Graphics;

import java.awt.Color;

public class Contenedor extends JComponent 
{
     static JPanel panel;
    
     static int columna = 0; //columna y fila se deberian iniciar en 0 
     
     static int fila =0; 
     
     static int numeroHabitacion =1; //1..15
     
     static int ampliacion;
     
     static EnvironmentSmartToyState environment;
     

     
        
  public Contenedor(JPanel panel,  EnvironmentSmartToyState environmentSmartToyState)
  {
      Contenedor.panel = panel;
      Contenedor.environment = environmentSmartToyState;

      
      setBounds(0, 0,panel.getWidth() , panel.getHeight());
      
      
 }
    
  public void paint(Graphics g){
    numeroHabitacion = environment.getUbicacionAgente().getFirst().getIdHabitacion();

    ImageIcon imagen =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/"+numeroHabitacion+".png")).getImage());
    g.drawImage(imagen.getImage(), 0, 0, imagen.getIconWidth(),imagen.getIconHeight(), this); 
     
     if(numeroHabitacion ==9 || numeroHabitacion == 7){ //porque las imagenes son mas chicas y tienen que entrar en el jpanel
    	  ampliacion =15;
     }
     else{
    	  ampliacion =30;
     }
     
  	 fila = environment.getUbicacionAgente().getSecond()[0]*ampliacion;
     columna = environment.getUbicacionAgente().getSecond()[1]*ampliacion;
    
     ImageIcon imagen2 =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/smartToy.png")).getImage());
     g.drawImage(imagen2.getImage(), columna, fila, ampliacion, ampliacion, null); 
    

     ImageIcon imagen3 =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/smartphone.jpg")).getImage());
     g.drawImage(imagen3.getImage(), environment.getUbicacionSmartPhone().getSecond()[0]*ampliacion,  environment.getUbicacionSmartPhone().getSecond()[1]*ampliacion, ampliacion, ampliacion, null); 
     

     setOpaque(false);
     super.paintComponent(g);
  
  }       
  
  static Thread hilo = new Thread(){
       @Override
        public void run()
        {
            try
            {
                while(true)
                { 
                 panel.repaint();  
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
   }
}










