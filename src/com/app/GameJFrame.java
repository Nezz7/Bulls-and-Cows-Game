package com.app;


import javax.swing.ImageIcon;


public class GameJFrame extends javax.swing.JFrame
{ 
    private String masterCode;
    private int nombreSecret;
    private int m,c,d,u,n,t,v;
    private int essM,essC,essD,essU;
  MessageJfram msg = new MessageJfram ();
  JMFrame JM= new JMFrame();
 
    private String masterTest;
    private boolean error;
   int xMouse;
   int yMouse;
    
    
    int buttonClick;
    public static int   count;
   ImageIcon filled = new ImageIcon (getClass().getResource("/Images/circle_filled.png"));
     ImageIcon unfilled = new ImageIcon (getClass().getResource("/Images/circle_unfilled.png"));
    public   void reboot(){
                 Code1.setIcon(unfilled); 
                 Code2.setIcon(unfilled); 
                 Code3.setIcon(unfilled);
                 Code4.setIcon(unfilled);
                 count = 0 ;
                    
        
    }
    public GameJFrame()
    { start ();
   

    System.out.println (nombreSecret);
        initComponents();
        reboot();
    }
   
   
   private void start () {
      
        do {
          m = 1 + (int)(Math.random() * (8 + 1));
          c = 1 + (int)(Math.random() * (8 + 1));
          d = 1 + (int)(Math.random() * (8 + 1));
          u = 1 + (int)(Math.random() * (8 + 1));
               
        }while (in (m,c,u,d)|| in (c,u,d,m)|| in (u,c,d,m)|| in (d,c,u,m));
        masterCode=m+""+c+""+d+""+u;
        nombreSecret = m*1000+c*100+d*10+u;
    }
    private boolean in (int a,int b , int c , int d){
        if (a==b || a==c || a==d)
            return true;
        else return false;
        
    }
   
    private void test () {
         v=0;
         t=0;
        if (essM==m)
            t++;
        if (essC==c)
            t++;
        if (essD==d)
            t++;
        if (essU==u)
            t++;
        if (in (essM,c,d,u))
            v++;
        if (in (essC,m,d,u))
            v++;
        if (in (essD,m,c,u))
            v++;
        if (in (essU,m,d,c))
            v++;
      
        
    }
    
    private void regle () {
          error = false ;
      
            
          
           if (in(essM,essD,essC,essU)||in(essC,essD,essM,essU)||in(essD,essM,essC,essU)||in(essU,essD,essC,essM)){
              
                error=true;
            }   
        
    }
    
    private void affichage() {
        
       
       ImageIcon score = new ImageIcon (getClass().getResource("/Images/"+t+"T"+v+"V.png"));
                
        if (!error){
            n++;
            switch(n) {
                case 1 :
                    JL1.setText(masterTest);
                   JL1.setIcon(score);
                    
                    break;
                case 2 :
                    JL2.setText(masterTest);
                    JL2.setIcon(score);
                    break;
                case 3 :
                    JL3.setText(masterTest);
                    JL3.setIcon(score);
                    break;
                case 4 :
                    JL4.setText(masterTest);
                    JL4.setIcon(score);
                    break;
                case 5 :
                    JL5.setText(masterTest);
                    JL5.setIcon(score);
                    break;
                case 6 :
                    JL6.setText(masterTest);
                    JL6.setIcon(score);
                    break;    
                case 7 :
                    JL7.setText(masterTest);
                    JL7.setIcon(score);
                    break;
                case 8 :
                    JL8.setText(masterTest);
                    JL8.setIcon(score);
                    break;    
                case 9 :
                    JL9.setText(masterTest);
                    JL9.setIcon(score);
                    break;   
                case 10 :
                    JL10.setText(masterTest);
                    JL10.setIcon(score);
                    break;    
            }
       }
    }
 
    public void circleControl()
    {
        count++;
        switch (count)
        {
            case 1 :
                Code1.setIcon(filled);
                essM=buttonClick;
                break;
            case 2 :
                Code2.setIcon(filled);
                essC=buttonClick;
                break;
            case 3 :
                Code3.setIcon(filled);
                essD=buttonClick;
                break;
            case 4 :
                 Code4.setIcon(filled); 
                 essU=buttonClick;
                 
                  masterTest = essM + "" +essC+ "" + essD + "" + essU;
                 //Supprimer 
                  System.out.println (masterTest);
                 regle();
                 test();
                 affichage();
                 
                 if (error){
                   
                     JM.setLocationRelativeTo (null);
                     JM.setVisible(true);
                 }
          
                 else if (masterTest.equals(masterCode))
                 { 
                     this.dispose (); 
                    ImageIcon mIcon = new ImageIcon (getClass().getResource("/Images/"+m+".png"));
                     ImageIcon II = new ImageIcon (getClass().getResource("/Images/53227.gif"));
                    ImageIcon cIcon = new ImageIcon (getClass().getResource("/Images/"+c+".png"));
                    ImageIcon dIcon = new ImageIcon (getClass().getResource("/Images/"+d+".png"));
                    ImageIcon uIcon = new ImageIcon (getClass().getResource("/Images/"+u+".png"));
                    ScoreJFrame SJF = new ScoreJFrame ();
                    SJF.getM().setIcon(mIcon);
                    SJF.getC().setIcon(cIcon);
                    SJF.getD().setIcon(dIcon);
                    SJF.getU().setIcon(uIcon);
                    SJF.getNbr().setText(String.valueOf(n));
                    SJF.getIcon().setIcon (II);
                    SJF.setVisible(true);
                    
                    
                 }else if (n>=10){
                     ImageIcon triste = new ImageIcon (getClass().getResource("/Images/triste.gif"));
                     ImageIcon youLose = new ImageIcon (getClass().getResource("/Images/youLose.png"));
                      ImageIcon mIcon = new ImageIcon (getClass().getResource("/Images/"+m+".png"));
                    ImageIcon cIcon = new ImageIcon (getClass().getResource("/Images/"+c+".png"));
                    ImageIcon dIcon = new ImageIcon (getClass().getResource("/Images/"+d+".png"));
                    ImageIcon uIcon = new ImageIcon (getClass().getResource("/Images/"+u+".png"));
                    ScoreJFrame SJF = new ScoreJFrame ();
                    SJF.getM().setIcon(mIcon);
                    SJF.getC().setIcon(cIcon);
                    SJF.getD().setIcon(dIcon);
                    SJF.getU().setIcon(uIcon);
                    SJF.getBack().setIcon (youLose);
                    SJF.getIcon1().setIcon (triste);
                    SJF.getIcon2().setIcon (triste);
                    SJF.setVisible (true);
                    this.dispose();
                     
                 }
                 else 
                 {
                  
                    msg.setLocationRelativeTo(null);
                    msg.setVisible(true);
                    String te=""+t;
                    String ve=String.valueOf(v);
                    msg.getT().setText(te);
                    msg.getV().setText(ve);
                  
                    
                  
                   
                    
                 }
                 
                   
             
                  
                


                
               break;
        }
    }
                                    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        defaultJl = new javax.swing.JLabel();
        Exit = new javax.swing.JLabel();
        Button0 = new javax.swing.JLabel();
        Button9 = new javax.swing.JLabel();
        Button8 = new javax.swing.JLabel();
        Button7 = new javax.swing.JLabel();
        Button6 = new javax.swing.JLabel();
        Button5 = new javax.swing.JLabel();
        Button4 = new javax.swing.JLabel();
        Button3 = new javax.swing.JLabel();
        Button2 = new javax.swing.JLabel();
        Button1 = new javax.swing.JLabel();
        Code4 = new javax.swing.JLabel();
        Code3 = new javax.swing.JLabel();
        Code2 = new javax.swing.JLabel();
        Code1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        move = new javax.swing.JLabel();
        JL1 = new javax.swing.JLabel();
        JL2 = new javax.swing.JLabel();
        JL4 = new javax.swing.JLabel();
        JL3 = new javax.swing.JLabel();
        JL5 = new javax.swing.JLabel();
        JL6 = new javax.swing.JLabel();
        JL7 = new javax.swing.JLabel();
        JL8 = new javax.swing.JLabel();
        JL9 = new javax.swing.JLabel();
        JL10 = new javax.swing.JLabel();
        BarBackground = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        Heading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lockscreen");
        setMinimumSize(new java.awt.Dimension(760, 460));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(760, 460));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        defaultJl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/defaultsimple.png"))); // NOI18N
        defaultJl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        defaultJl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                defaultJlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                defaultJlMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                defaultJlMouseReleased(evt);
            }
        });
        getContentPane().add(defaultJl, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 10, 30, 30));

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ExitSimple.png"))); // NOI18N
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ExitMouseReleased(evt);
            }
        });
        getContentPane().add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 10, 30, 30));

        Button0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button0MouseReleased(evt);
            }
        });
        getContentPane().add(Button0, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 342, 60, 60));

        Button9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button9MouseReleased(evt);
            }
        });
        getContentPane().add(Button9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 60, 60));

        Button8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button8MouseReleased(evt);
            }
        });
        getContentPane().add(Button8, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 270, 60, 60));

        Button7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button7MouseReleased(evt);
            }
        });
        getContentPane().add(Button7, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 270, 60, 60));

        Button6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button6MouseReleased(evt);
            }
        });
        getContentPane().add(Button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 60, 60));

        Button5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button5MouseReleased(evt);
            }
        });
        getContentPane().add(Button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 199, 60, 60));

        Button4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button4MouseReleased(evt);
            }
        });
        getContentPane().add(Button4, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 199, 60, 60));

        Button3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button3MouseReleased(evt);
            }
        });
        getContentPane().add(Button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 60, 60));

        Button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button2MouseReleased(evt);
            }
        });
        getContentPane().add(Button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 130, 60, 60));

        Button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Button1MouseReleased(evt);
            }
        });
        getContentPane().add(Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 130, 60, 60));

        Code4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle_unfilled.png"))); // NOI18N
        getContentPane().add(Code4, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 70, 15, 15));

        Code3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle_unfilled.png"))); // NOI18N
        getContentPane().add(Code3, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 70, 15, 15));

        Code2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle_unfilled.png"))); // NOI18N
        getContentPane().add(Code2, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 70, 15, 15));

        Code1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/circle_unfilled.png"))); // NOI18N
        getContentPane().add(Code1, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 70, 15, 15));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/numbers1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 295, 290));

        move.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        move.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                moveMouseDragged(evt);
            }
        });
        move.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                moveMousePressed(evt);
            }
        });
        getContentPane().add(move, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 40));

        JL1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        JL2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        JL4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        JL3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        JL5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        JL6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL6.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        JL7.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL7.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        JL8.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL8.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        JL9.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL9.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        JL10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        JL10.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(JL10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, -1, -1));

        BarBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BarBackground.png"))); // NOI18N
        getContentPane().add(BarBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 840, 430));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 460));

        Heading.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        Heading.setForeground(new java.awt.Color(255, 255, 255));
        Heading.setText("Enter Passcode");
        getContentPane().add(Heading, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 120, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Button1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseReleased
        buttonClick = 1 ;
        circleControl ();
    }//GEN-LAST:event_Button1MouseReleased

    private void Button2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button2MouseReleased
        buttonClick = 2 ;
        circleControl ();
    }//GEN-LAST:event_Button2MouseReleased

    private void Button3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button3MouseReleased
        buttonClick = 3 ;
        circleControl ();
    }//GEN-LAST:event_Button3MouseReleased

    private void Button4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button4MouseReleased
        buttonClick = 4 ;
        circleControl ();
    }//GEN-LAST:event_Button4MouseReleased

    private void Button5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button5MouseReleased
       buttonClick = 5 ;
       circleControl ();
    }//GEN-LAST:event_Button5MouseReleased

    private void Button6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button6MouseReleased
       buttonClick = 6 ;
       circleControl ();
    }//GEN-LAST:event_Button6MouseReleased

    private void Button7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button7MouseReleased
        buttonClick = 7 ;
        circleControl ();
    }//GEN-LAST:event_Button7MouseReleased

    private void Button8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button8MouseReleased
        buttonClick = 8 ;
        circleControl ();
    }//GEN-LAST:event_Button8MouseReleased

    private void Button9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button9MouseReleased
        buttonClick = 9 ;
        circleControl ();
    }//GEN-LAST:event_Button9MouseReleased

    private void Button0MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button0MouseReleased
        reboot();

    }//GEN-LAST:event_Button0MouseReleased

    private void defaultJlMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_defaultJlMouseReleased
     this.setExtendedState(GameJFrame.ICONIFIED);
    }//GEN-LAST:event_defaultJlMouseReleased

    private void ExitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseReleased
         System.exit(0);
    }//GEN-LAST:event_ExitMouseReleased

    private void moveMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveMouseDragged
         int x=evt.getXOnScreen();
     int y=evt.getYOnScreen();
    this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_moveMouseDragged

    private void moveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moveMousePressed
        // TODO add your handling code here:
         xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_moveMousePressed

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
      
        ImageIcon exitIcon = new ImageIcon (getClass().getResource("/Images/exitnt.png"));
        Exit.setIcon(exitIcon);
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
      
        ImageIcon exitIcon = new ImageIcon (getClass().getResource("/Images/ExitSimple.png"));
        Exit.setIcon(exitIcon);
    }//GEN-LAST:event_ExitMouseExited

    private void defaultJlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_defaultJlMouseEntered
        // TODO add your handling code here:
         ImageIcon exitIcon = new ImageIcon (getClass().getResource("/Images/defaultIN.png"));
        defaultJl.setIcon(exitIcon);
    }//GEN-LAST:event_defaultJlMouseEntered

    private void defaultJlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_defaultJlMouseExited
         ImageIcon exitIcon = new ImageIcon (getClass().getResource("/Images/defaultsimple.png"));
        defaultJl.setIcon(exitIcon);
    }//GEN-LAST:event_defaultJlMouseExited

    public static void main(String args[])
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(GameJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(GameJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(GameJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(GameJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new GameJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel BarBackground;
    private javax.swing.JLabel Button0;
    private javax.swing.JLabel Button1;
    private javax.swing.JLabel Button2;
    private javax.swing.JLabel Button3;
    private javax.swing.JLabel Button4;
    private javax.swing.JLabel Button5;
    private javax.swing.JLabel Button6;
    private javax.swing.JLabel Button7;
    private javax.swing.JLabel Button8;
    private javax.swing.JLabel Button9;
    public static javax.swing.JLabel Code1;
    public static javax.swing.JLabel Code2;
    public static javax.swing.JLabel Code3;
    public static javax.swing.JLabel Code4;
    private javax.swing.JLabel Exit;
    private javax.swing.JLabel Heading;
    private javax.swing.JLabel JL1;
    private javax.swing.JLabel JL10;
    private javax.swing.JLabel JL2;
    private javax.swing.JLabel JL3;
    private javax.swing.JLabel JL4;
    private javax.swing.JLabel JL5;
    private javax.swing.JLabel JL6;
    private javax.swing.JLabel JL7;
    private javax.swing.JLabel JL8;
    private javax.swing.JLabel JL9;
    private javax.swing.JLabel defaultJl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel move;
    // End of variables declaration//GEN-END:variables
}
