package pantalla;

import javax.swing.JComponent;

import javax.swing.JPanel;

import javax.swing.ImageIcon;

import domain.Habitacion;

import frsf.cidisi.exercise.smarttoy.search.EnvironmentSmartToy;
import frsf.cidisi.exercise.smarttoy.search.EnvironmentSmartToyState;

import java.awt.Graphics;

import java.awt.Color;

public class Contenedor extends JComponent 
{
     static JPanel panel;
    
     static int columnaSmartToy = 0; //columna y fila se deberian iniciar en 0 
     
     static int filaSmartToy =0; 
     
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
    if(numeroHabitacion ==9 || numeroHabitacion == 7){ //porque las imagenes son mas chicas y tienen que entrar en el jpanel
  	  ampliacion =15;
   }else{
  	  ampliacion =30;
   }
    
    Habitacion h = environment.getPlano().get(numeroHabitacion-1);
    
    String nombre= null;
    
    filaSmartToy = environment.getUbicacionAgente().getSecond()[0]*ampliacion;
    columnaSmartToy = environment.getUbicacionAgente().getSecond()[1]*ampliacion;
    
    for (int fila = 0; fila < h.getPlanoHabitacion().length; fila++) {
         for (int col = 0; col < h.getPlanoHabitacion()[fila].length; col++) {
        nombre=h.getPlanoHabitacion()[fila][col];	
        if (nombre=="||"){
        	  ImageIcon imagen2 =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/smartToy.png")).getImage());
              g.drawImage(imagen2.getImage(), columnaSmartToy, filaSmartToy, ampliacion, ampliacion, null); 
        }
        else{
        ImageIcon imagen =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/"+nombre+".png")).getImage());
        g.drawImage(imagen.getImage(), col*ampliacion, fila*ampliacion, ampliacion, ampliacion, this); 
        }
        }
   }
    ImageIcon imagen2 =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/smartToy.png")).getImage());
    g.drawImage(imagen2.getImage(), columnaSmartToy, filaSmartToy, ampliacion, ampliacion, null); 
   
    if(environment.getUbicacionSmartPhone().getFirst().getIdHabitacion()==numeroHabitacion){
    	ImageIcon imagen3 =new ImageIcon(new ImageIcon(getClass().getResource("imagenes/smartphone.jpg")).getImage());
    	g.drawImage(imagen3.getImage(), environment.getUbicacionSmartPhone().getSecond()[1]*ampliacion,  environment.getUbicacionSmartPhone().
   		getSecond()[0]*ampliacion, ampliacion, ampliacion, null); 
}     

    
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
