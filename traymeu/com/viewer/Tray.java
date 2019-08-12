/*     */ package com.viewer;
/*     */ 
/*     */ import com.ssh.sshconect;
/*     */ import java.awt.AWTException;
/*     */ import java.awt.Image;
/*     */ import java.awt.MenuItem;
/*     */ import java.awt.PopupMenu;
/*     */ import java.awt.SystemTray;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.TrayIcon;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.net.InetAddress;
/*     */ import java.net.NetworkInterface;
/*     */ import java.net.SocketException;
/*     */ import java.util.Enumeration;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Tray
/*     */ {
/*     */   public static String meuip;
/*     */   
/*     */   public static void main(String[] args) {
/*  38 */     PopupMenu popup = new PopupMenu();
/*  39 */     JLabel lbldesligar = new JLabel("des");
/*  40 */     pegarip();
/*     */     
/*  42 */     if (!SystemTray.isSupported()) {
/*     */       
/*  44 */       System.out.println("não possível");
/*  45 */       System.err.println("System Tray não suportado nesta plataforma.");
/*     */     } 
/*  47 */     System.out.println("ok");
/*  48 */     SystemTray tray = SystemTray.getSystemTray();
/*     */     
/*  50 */     Image image = Toolkit.getDefaultToolkit().getImage("/opt/imagens/systrayicon.png");
/*     */     try {
/*  52 */       TrayIcon trayicon = new TrayIcon(image, "oi");
/*     */ 
/*     */       
/*  55 */       MenuItem info = new MenuItem("Info ip: " + meuip);
/*  56 */       MenuItem desligar = new MenuItem("Desligar");
/*  57 */       MenuItem reiniciar = new MenuItem("Reiniciar");
/*  58 */       MenuItem desligartodos = new MenuItem("Desligar Todos as Máquinas");
/*  59 */       MenuItem reiniciartodos = new MenuItem("Reiniciar Todos as Máquinas");
/*  60 */       MenuItem exitItem = new MenuItem("Sair");
/*     */ 
/*     */       
/*  63 */       popup.add(info);
/*     */       
/*  65 */       popup.add(desligar);
/*  66 */       popup.add(reiniciar);
/*  67 */       popup.addSeparator();
/*  68 */       popup.addSeparator();
/*  69 */       popup.add(desligartodos);
/*  70 */       popup.add(reiniciartodos);
/*  71 */       popup.addSeparator();
/*  72 */       popup.add(exitItem);
/*  73 */       trayicon.setPopupMenu(popup);
/*  74 */       tray.add(trayicon);
/*     */ 
/*     */ 
/*     */       
/*  78 */       reiniciartodos.addActionListener(new ActionListener()
/*     */           {
/*     */             
/*     */             public void actionPerformed(ActionEvent e)
/*     */             {
/*  83 */               sshconect reiniciartodos = new sshconect();
/*  84 */               reiniciartodos.getReiniciarTodas();
/*     */             }
/*     */           });
/*     */       
/*  88 */       desligartodos.addActionListener(new ActionListener()
/*     */           {
/*     */             
/*     */             public void actionPerformed(ActionEvent e)
/*     */             {
/*  93 */               sshconect desligartodos = new sshconect();
/*  94 */               desligartodos.getDeligarTodas();
/*     */             }
/*     */           });
/*     */       
/*  98 */       reiniciar.addActionListener(new ActionListener()
/*     */           {
/*     */             
/*     */             public void actionPerformed(ActionEvent e)
/*     */             {
/* 103 */               sshconect reiniciar = new sshconect();
/* 104 */               reiniciar.getReiniciar();
/*     */             }
/*     */           });
/*     */       
/* 108 */       desligar.addActionListener(new ActionListener()
/*     */           {
/*     */             
/*     */             public void actionPerformed(ActionEvent e)
/*     */             {
/* 113 */               JOptionPane.showMessageDialog(null, "Desligando");
/* 114 */               sshconect desligando = new sshconect();
/* 115 */               desligando.getDesligar();
/*     */             }
/*     */           });
/*     */       
/* 119 */       info.addActionListener(new ActionListener()
/*     */           {
/*     */             public void actionPerformed(ActionEvent e) {}
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 134 */       exitItem.addActionListener(new ActionListener()
/*     */           {
/*     */             public void actionPerformed(ActionEvent e)
/*     */             {
/* 138 */               System.exit(0);
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 147 */     catch (AWTException e) {
/*     */       
/* 149 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public void exibir() { JOptionPane.showMessageDialog(null, "message"); }
/*     */   
/*     */   public static void pegarip() {
/* 160 */     e1 = null;
/*     */     try {
/* 162 */       e1 = NetworkInterface.getNetworkInterfaces();
/* 163 */     } catch (SocketException e11) {
/*     */       
/* 165 */       e11.printStackTrace();
/*     */     } 
/* 167 */     while (e1.hasMoreElements()) {
/*     */       
/* 169 */       NetworkInterface n = (NetworkInterface)e1.nextElement();
/* 170 */       Enumeration ee = n.getInetAddresses();
/* 171 */       int cont = 0;
/* 172 */       while (ee.hasMoreElements()) {
/*     */         
/* 174 */         InetAddress i = (InetAddress)ee.nextElement();
/* 175 */         System.out.println(i.getHostAddress());
/* 176 */         if (i.getHostAddress().contains("1.") || i.getHostAddress().contains("19") || i.getHostAddress().contains("10.1."))
/*     */         {
/*     */           
/* 179 */           meuip = i.getHostAddress();
/*     */         }
/*     */ 
/*     */         
/* 183 */         cont++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              /home/jango/Documentos/Estudando Programação/javadesligarmulyiterminal/00/traymeu/!/com/viewer/Tray.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */