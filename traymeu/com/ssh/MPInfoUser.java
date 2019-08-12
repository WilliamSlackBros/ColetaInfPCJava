/*    */ package com.ssh;
/*    */ 
/*    */ import com.jcraft.jsch.UserInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MPInfoUser
/*    */   implements UserInfo
/*    */ {
/* 10 */   public String getPassphrase() { return null; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 16 */   public String getPassword() { return "professor"; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 22 */   public boolean promptPassphrase(String arg0) { return true; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 28 */   public boolean promptPassword(String arg0) { return true; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public boolean promptYesNo(String arg0) { return true; }
/*    */   
/*    */   public void showMessage(String arg0) {}
/*    */ }


/* Location:              /home/jango/Documentos/Estudando Programação/javadesligarmulyiterminal/00/traymeu/!/com/ssh/MPInfoUser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */