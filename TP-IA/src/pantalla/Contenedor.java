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
    
     static int columna = 60; //columna y fila se deberian iniciar en 0 
     
     static int fila =60; 
     
     static int numeroHabitacion =7; //1..15
     
     static int ampliacion;
     

     
        
  public Contenedor(JPanel panel,  EnvironmentSmartToy environment)
  {
      this.panel = panel;
      

      
      setBounds(0, 0,panel.getWidth() , panel.getHeight());
      
      
 }
    
  public void paint(Graphics g){
    //numeroHabitacion = environment.getEnvironmentState().getUbicacionAgente().getFirst().getIdHabitacion();

    ImageIcon imagen =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/"+numeroHabitacion+".png")).getImage());
    g.drawImage(imagen.getImage(), 0, 0, imagen.getIconWidth(),imagen.getIconHeight(), this); 
     
     if(numeroHabitacion ==9 || numeroHabitacion == 7){ //porque las imagenes son mas chicas y tienen que entrar en el jpanel
    	  ampliacion =15;
     }
     else{
    	  ampliacion =30;
     }
     
  	 //fila = environment.getEnvironmentState().getUbicacionAgente().getSecond()[0]*ampliacion;
     //columna = environment.getEnvironmentState().getUbicacionAgente().getSecond()[1]*ampliacion;
    
     ImageIcon imagen2 =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/smartToy.png")).getImage());
     g.drawImage(imagen2.getImage(), columna, fila, ampliacion, ampliacion, null); 
    
     

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










