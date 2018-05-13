
package pantalla;

import javax.swing.JScrollPane;

import frsf.cidisi.exercise.smarttoy.search.EnvironmentSmartToy;
import frsf.cidisi.exercise.smarttoy.search.EnvironmentSmartToyState;

public class Ventana extends javax.swing.JFrame {

    
    public Ventana( EnvironmentSmartToyState environmentSmartToyState) 
    {
        initComponents();
        panel.add(new Contenedor(panel, environmentSmartToyState));
        
     }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

       panel = new javax.swing.JPanel();
       
       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(205, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        
        //EnvironmentSmartToy environment = new EnvironmentSmartToy();
        EnvironmentSmartToyState environment = null;
        new Ventana(environment).setVisible(true);
            
    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JPanel panel;
    // End of variables declaration                   
}
