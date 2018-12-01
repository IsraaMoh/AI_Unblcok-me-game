
package board;
import java.awt.Adjustable;
import java.awt.event.ActionEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LayoutStyle;


    public class gameFrame extends javax.swing.JFrame {

     final board Greedy;
     final board DFS;
     final board AStar;
    private int i = 0;

    /////////////////////////////////////////////
    private javax.swing.JButton jButton1; // NEXT STATE
    private javax.swing.JButton jButton2; // DFS
    private javax.swing.JButton jButton3; // GREEDY
    private javax.swing.JButton jButton4; //A*
    private javax.swing.JLabel jLabel1; // Title
    private javax.swing.JLabel jLabel0;
    private javax.swing.JLabel jLabel2; 
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.ImageIcon jImage1;
    private javax.swing.JButton jButton5;
    private javax.swing.JTextArea jText1;
    private javax.swing.JScrollPane Scroll;
    private String goalSeq = "";
    
    
     public gameFrame() {

        initComponents();
        setLocationRelativeTo(null);
       // setSize(780, 970);
        jButton1.setVisible(false);
        fillStates();
        Scroll.setAutoscrolls(true);
        Scroll.setBounds(100, 100, 50, 100);
        Scroll.setEnabled(true);
        Scroll.setVisible(true);

        Greedy = new board();
        DFS = new board();
        AStar = new board();

    }
    private final TreeMap<String, String> state = new TreeMap();

    private void fillStates() {
        
        /////////////////////////////////////
        // easy
        state.put("E", "esay1.png");
        state.put("Ea", "esy2.png");
        state.put("Eas", "esay3.png");
        state.put("Easy", "esay4.png");
     
    }
    
     private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel(); 
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Scroll = new javax.swing.JScrollPane();
        jText1 = new javax.swing.JTextArea();

        //////////////////////////////////////////////////
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Unblock-me Game");
        setBackground(new java.awt.Color(255, 255, 255));

        ///////////////////////////////////////////////////////////
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 40));
        jLabel1.setForeground(new java.awt.Color(43, 24, 50));
        jLabel1.setText("Unblock-me");
        jLabel2.setSize(1000, 1000);
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jLabel7.setText("Select game Level (easy , medium , hard) ");
        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jText1.setFont(new java.awt.Font("Comic Sans MS", 1, 20));
        jText1.setBounds(250, 250, 200, 2); 
        ////////////////////////////////////////////////////////////
        jButton1.setText("Next Move");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

        });
        jButton2.setText("DFS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        jButton4.setText("Greedy");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton3ActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        jButton3.setText("A*");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton4ActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("esay1.png"))); 

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, javax.swing.GroupLayout.DEFAULT_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(100, 100, 100)
                                                        .addComponent(jButton2)
                                                        .addGap(20, 20, 20)
                                                        .addComponent(jButton3)
                                                        .addGap(20, 20, 20)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.SIZE)
                                                        .addComponent(jButton4))))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(205, 205, 205)
                                        .addComponent(jLabel7)
                                )
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(220, 220, 220)
                                        .addComponent(jText1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, 300))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(170, 170, 170)
                                        .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, javax.swing.GroupLayout.DEFAULT_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(108, 108, 108))
                .addComponent(Scroll)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jButton3)
                                .addComponent(jButton4)
                        )
                        .addComponent(jLabel7)
                        .addComponent(jText1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, javax.swing.GroupLayout.DEFAULT_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGap(28, 28, 28))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                .addComponent(Scroll)
        );

        jButton1.getAccessibleContext().setAccessibleName("");
        pack();
    }
  private void jButton1ActionPerformed(ActionEvent evt) {

        if (jButton1.getText().equalsIgnoreCase("Back")) {
            jButton1.setVisible(false);
            jLabel2.setText("");
            jLabel5.setText("");
            jText1.setVisible(true);
            jLabel7.setVisible(true);
            jText1.setText("");
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("esay1.png")));
        } else {
            jButton1.setText("Next Move");
            if (i == 0) {
                if (jText1.getText().equalsIgnoreCase("Easy")) {
                    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("esay1.png")));
                } 

            } else if (goalSeq.length() != 0 && goalSeq.length() > i) {

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(state.get(goalSeq.substring(0, i + 1)))));
                if (i == goalSeq.length() - 1) {
                    jButton1.setText("Finished");

                }

            } else if (i == goalSeq.length()) {
                jButton1.setVisible(false);
                jLabel2.setText("");
                jLabel5.setText("");
                jText1.setVisible(true);
                jLabel7.setVisible(true);
                jText1.setText("");
                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("esay1.png")));
            }
            i++;
        }
    }

    private void jButton2ActionPerformed(ActionEvent evt) throws FileNotFoundException {
        goalSeq = "";
        jText1.setVisible(false);
        jLabel7.setVisible(false);
        if (jText1.getText().equalsIgnoreCase("Easy")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("esay1.png")));
        }

      
            jButton1.setVisible(true);
            jButton1.setText("Start");
            i = 0;
        
    }
    
    
     private void jButton4ActionPerformed(ActionEvent evt) throws FileNotFoundException {
        goalSeq = "";
        jText1.setVisible(false);
        jLabel7.setVisible(false);
        if (jText1.getText().equalsIgnoreCase("easy")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("esay1.png")));
        }
           
       

        jButton1.setVisible(true);
        jButton1.setText("Start");
        i = 0;

    }
    
    private void jButton3ActionPerformed(ActionEvent evt) throws FileNotFoundException {
        goalSeq = "";
        jText1.setVisible(false);
        jLabel7.setVisible(false);
        if (jText1.getText().equalsIgnoreCase("esay")) {
            jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("esay1.png")));
        } else {
            jLabel2.setText("Unvailed input");

        }


            jButton1.setVisible(true);
            jButton1.setText("Start");
            i = 0;
        }
    

    //----------------------
     public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(gameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new gameFrame().setVisible(true);
            }
           
        }
           );      }
    }
       
