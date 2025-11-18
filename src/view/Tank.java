/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import controller.Controller;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import model.MainObserver;

/**
 *
 * @author pramuditha-lakshan
 */
public class Tank extends javax.swing.JFrame implements MainObserver {

    private Controller controller;
    private MainController mainController;
    private String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    private int soldierCount;
    private int ammoCount;
    private int fuel = 100;
    private Clip clip;
    private Thread engineThread;
    private boolean engineRunning;

    /**
     * Creates new form Tank
     */
    public Tank(Controller controller, MainController mainController) {
        initComponents();
        this.controller = controller;
        txtArea.setEditable(false);
        this.mainController = mainController;
        btnShoot.setEnabled(false);
        btnMissile.setEnabled(false);
        btnRotate.setEnabled(false);
        btnRedar.setEnabled(false);
        jSlider1.setEnabled(false);
        engineRunning();
        fuelSpiner.setValue(100);
        txtField.grabFocus();
    }

    @Override
    public void updateMessage(String message) {
        txtArea.append(message + "\n");
    }

    @Override
    public void clearArea(boolean clear) {
        if (clear == true) {
            lblArea.setText("Area Cleared");
        } else {
            lblArea.setText("Area Not Cleared");
        }
    }

    @Override
    public void buttonEnable(int value) {
        if (positionCheckBox.isSelected() == true) {
            jSlider1.setValue(value);
            jLabel3.setText(value + "");
            if (value >= 0 || 25 <= value) {
                btnShoot.setEnabled(true);
                btnMissile.setEnabled(false);
                btnRedar.setEnabled(false);
                btnRotate.setEnabled(false);
            }
            if (value >= 26 || 50 <= value) {
                btnShoot.setEnabled(false);
                btnMissile.setEnabled(true);
                btnRedar.setEnabled(false);
                btnRotate.setEnabled(false);
            }

            if (value >= 51 || 75 <= value) {
                btnShoot.setEnabled(false);
                btnMissile.setEnabled(false);
                btnRedar.setEnabled(true);
                btnRotate.setEnabled(false);
            }

            if (value >= 76) {
                btnShoot.setEnabled(false);
                btnMissile.setEnabled(false);
                btnRedar.setEnabled(false);
                btnRotate.setEnabled(true);
            }
        }
    }

    public String getSoldierCount() {
        return soldierCount + "";
    }

    public String getAmmoCount() {
        return ammoCount + "";
    }

    public String getFuel() {
        return fuel + "";
    }

    public String getPosition() {
        return jSlider1.getValue() + "";
    }

    public void playSound(String path) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(path));
            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendPrivateMessage(String message) {
        txtArea.append(message + "\n");
    }

    private void stopSound() {
        clip.stop();
    }

    public void engineRunning() {
        if (engineRunning) {
            return;
        }
        engineRunning = true;
        engineThread = new Thread(() -> {
            while (engineRunning) {
                fuelSpiner.setValue(--fuel);
                try {
                    if ((int) fuelSpiner.getValue() <= 0) {
                        engineRunning = false;
                        playSound("/sounds/lowFuel.wav");
                        mainController.getTankMessage("Tank - Need to refill");
                        JOptionPane.showMessageDialog(this, "Refill the tank", "Low Fuel", JOptionPane.WARNING_MESSAGE);
                        stopSound();
                        break;
                    }
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        engineThread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jSlider1 = new javax.swing.JSlider();
        ammoSpinner = new javax.swing.JSpinner();
        txtField = new javax.swing.JTextField();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        positionCheckBox = new javax.swing.JCheckBox();
        lblArea = new javax.swing.JLabel();
        btnShoot = new javax.swing.JButton();
        btnMissile = new javax.swing.JButton();
        btnRedar = new javax.swing.JButton();
        btnRotate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fuelSpiner = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jButton5.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jButton5.setText("Send");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider1.setValue(0);

        ammoSpinner.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        ammoSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ammoSpinnerStateChanged(evt);
            }
        });

        txtField.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N

        jSpinner2.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setText("Soldier Count");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel2.setText("Ammo Count");

        positionCheckBox.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        positionCheckBox.setText("Position");
        positionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionCheckBoxActionPerformed(evt);
            }
        });

        lblArea.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        lblArea.setText("Area Not Cleared");

        btnShoot.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnShoot.setText("Shoot");
        btnShoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShootActionPerformed(evt);
            }
        });

        btnMissile.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnMissile.setText("Missile Operations");
        btnMissile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMissileActionPerformed(evt);
            }
        });

        btnRedar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnRedar.setText("Redar Operatino");
        btnRedar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedarActionPerformed(evt);
            }
        });

        btnRotate.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        btnRotate.setText("Rotate Operation");
        btnRotate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRotateActionPerformed(evt);
            }
        });

        jLabel3.setText("Value");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel4.setText("Fuel ");

        fuelSpiner.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N

        jLabel5.setText("Current Position");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblArea)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnShoot, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMissile))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRedar)
                                .addGap(18, 18, 18)
                                .addComponent(btnRotate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpinner2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .addComponent(fuelSpiner)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(84, 84, 84)
                                .addComponent(ammoSpinner)))
                        .addGap(94, 94, 94))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtField)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(positionCheckBox))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)))
                        .addContainerGap(118, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArea)
                    .addComponent(jLabel2)
                    .addComponent(ammoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnShoot)
                        .addComponent(btnMissile))
                    .addComponent(jLabel1)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRotate)
                            .addComponent(btnRedar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fuelSpiner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(44, 44, 44)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(positionCheckBox)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)))))
                .addGap(43, 43, 43))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       if(txtField.getText().length()==0){
        JOptionPane.showMessageDialog(this, "Enter meessage to send");
       }else{
        playSound("/sounds/messageSend.wav");
        mainController.getTankMessage(time + " - " + txtField.getText());
        txtArea.append(time+" - "+ txtField.getText()+"\n");
        txtField.setText("");
       }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void ammoSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ammoSpinnerStateChanged
        playSound("/sounds/CheckBoxClick.wav");
        ammoCount++;
    }//GEN-LAST:event_ammoSpinnerStateChanged

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        playSound("/sounds/clickSound.wav");
        soldierCount++;
    }//GEN-LAST:event_jSpinner2StateChanged

    private void btnShootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShootActionPerformed
        int ammo = (int) ammoSpinner.getValue();
        if (ammo == 0) {
            JOptionPane.showMessageDialog(this, "Low Ammo");
        } else {
        playSound("/sounds/Shoot.wav");
        }
    }//GEN-LAST:event_btnShootActionPerformed

    private void btnMissileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMissileActionPerformed
        playSound("/sounds/missile.wav");
    }//GEN-LAST:event_btnMissileActionPerformed

    private void btnRedarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedarActionPerformed
         playSound("/sounds/Redar.wav");
    }//GEN-LAST:event_btnRedarActionPerformed

    private void btnRotateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRotateActionPerformed
          playSound("/sounds/TankRotate.wav");
    }//GEN-LAST:event_btnRotateActionPerformed

    private void positionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionCheckBoxActionPerformed
          playSound("/sounds/clickSound.wav");
    }//GEN-LAST:event_positionCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner ammoSpinner;
    private javax.swing.JButton btnMissile;
    private javax.swing.JButton btnRedar;
    private javax.swing.JButton btnRotate;
    private javax.swing.JButton btnShoot;
    private javax.swing.JSpinner fuelSpiner;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JLabel lblArea;
    private javax.swing.JCheckBox positionCheckBox;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtField;
    // End of variables declaration//GEN-END:variables
}
