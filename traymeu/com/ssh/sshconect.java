/*     */ package com.ssh;
/*     */ 
/*     */ import com.jcraft.jsch.ChannelExec;
/*     */ import com.jcraft.jsch.JSch;
/*     */ import com.jcraft.jsch.JSchException;
/*     */ import com.jcraft.jsch.Session;
/*     */ import com.viewer.Tray;
/*     */ import java.sql.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class sshconect
/*     */ {
/*  17 */   GregorianCalendar calendar = new GregorianCalendar();
/*  18 */   int hora = this.calendar.get(11);
/*  19 */   int min = this.calendar.get(12);
/*  20 */   int seg = this.calendar.get(13);
/*  21 */   Date data = new Date(System.currentTimeMillis());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getDesligar() {
/*  27 */     JSch jsch = new JSch();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  32 */       Session session = jsch.getSession("root", "127.0.0.1", 22);
/*  33 */       session.setUserInfo(new MPInfoUser());
/*  34 */       session.setPassword("qwe123!");
/*  35 */       session.connect();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  44 */       ChannelExec channels0 = (ChannelExec)session.openChannel("exec");
/*  45 */       channels0.setCommand("echo  'Executado Desligamento do Desktop " + this.data + " - " + this.hora + ":" + this.min + ":" + this.seg + "' >> /opt/.deligamento.txt");
/*  46 */       channels0.connect();
/*  47 */       channels0.disconnect();
/*     */ 
/*     */       
/*  50 */       ChannelExec channels1 = (ChannelExec)session.openChannel("exec");
/*  51 */       channels1.setCommand("shutdown -h now");
/*  52 */       channels1.connect();
/*  53 */       channels1.disconnect();
/*     */       
/*  55 */       session.disconnect();
/*     */     }
/*  57 */     catch (JSchException e) {
/*     */       
/*  59 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getReiniciar() {
/*  68 */     JSch jsch = new JSch();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  73 */       Session session = jsch.getSession("root", "127.0.0.1", 22);
/*  74 */       session.setUserInfo(new MPInfoUser());
/*  75 */       session.setPassword("qwe123!");
/*  76 */       session.connect();
/*     */ 
/*     */ 
/*     */       
/*  80 */       ChannelExec channels0 = (ChannelExec)session.openChannel("exec");
/*  81 */       channels0.setCommand("echo  'Executado reinicialização do Desktop " + this.data + " - " + this.hora + ":" + this.min + ":" + this.seg + "' >> /opt/.reinicializacao.txt");
/*  82 */       channels0.connect();
/*  83 */       channels0.disconnect();
/*     */ 
/*     */       
/*  86 */       ChannelExec channels1 = (ChannelExec)session.openChannel("exec");
/*  87 */       channels1.setCommand("reboot");
/*  88 */       channels1.connect();
/*  89 */       channels1.disconnect();
/*     */       
/*  91 */       session.disconnect();
/*     */     }
/*  93 */     catch (JSchException e) {
/*     */       
/*  95 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getInstalar() {
/* 104 */     JSch jsch = new JSch();
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 109 */       Session session = jsch.getSession("root", "127.0.0.1", 22);
/* 110 */       session.setUserInfo(new MPInfoUser());
/* 111 */       session.setPassword("qwe123!");
/* 112 */       session.connect();
/*     */ 
/*     */ 
/*     */       
/* 116 */       ChannelExec channels0 = (ChannelExec)session.openChannel("exec");
/*     */       
/* 118 */       channels0.setCommand("echo  'Executado instalação no Desktop " + this.data + " - " + this.hora + ":" + this.min + ":" + this.seg + "' >> /opt/.instalacao.txt");
/* 119 */       channels0.connect();
/* 120 */       channels0.disconnect();
/*     */ 
/*     */       
/* 123 */       ChannelExec channels1 = (ChannelExec)session.openChannel("exec");
/* 124 */       channels1.setCommand("cp -Rf /opt/installprogs/jdk /opt/");
/* 125 */       channels1.connect();
/* 126 */       channels1.disconnect();
/*     */ 
/*     */ 
/*     */       
/* 130 */       ChannelExec channels2 = (ChannelExec)session.openChannel("exec");
/* 131 */       channels2.setCommand("cp -Rf /opt/installprogs/tomcat8 /opt/");
/* 132 */       channels2.connect();
/* 133 */       channels2.disconnect();
/*     */ 
/*     */       
/* 136 */       ChannelExec channels3 = (ChannelExec)session.openChannel("exec");
/* 137 */       channels3.setCommand("cp -Rf /opt/installprogs/acessofacil.jar /opt/");
/* 138 */       channels3.connect();
/* 139 */       channels3.disconnect();
/*     */       
/* 141 */       session.disconnect();
/*     */     }
/* 143 */     catch (JSchException e) {
/*     */       
/* 145 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getDeligarTodas() {
/* 154 */     JSch jsch = new JSch();
/* 155 */     Tray traysistema = new Tray();
/*     */ 
/*     */     
/* 158 */     String somarCaratcter = "";
/* 159 */     String somaparaipalvo = "";
/* 160 */     String ultiCaratcter = "";
/* 161 */     String caracteres = "#@_\\/.*";
/* 162 */     String[] partes = Tray.meuip.split("[" + Pattern.quote(caracteres) + "]");
/*     */ 
/*     */     
/* 165 */     Integer nn = Integer.valueOf(0); byte b; int j; String[] arrayOfString;
/* 166 */     for (j = arrayOfString = partes.length, b = 0; b < j; ) { String i = arrayOfString[b];
/* 167 */       somarCaratcter = String.valueOf(somarCaratcter) + i + ".";
/*     */       
/* 169 */       ultiCaratcter = i;
/* 170 */       System.out.println(i);
/* 171 */       if (nn.intValue() < 3) {
/* 172 */         somaparaipalvo = String.valueOf(somaparaipalvo) + i + ".";
/*     */       }
/*     */       
/* 175 */       nn = Integer.valueOf(nn.intValue() + 1); System.out.println(nn);
/* 176 */       System.out.println(somaparaipalvo);
/*     */       b++; }
/*     */     
/* 179 */     String s = somarCaratcter.substring(0, somarCaratcter.length() - 1);
/* 180 */     Integer aa = Integer.valueOf(1);
/* 181 */     while (aa.intValue() < 254) {
/*     */       
/* 183 */       String convert = Integer.toString(aa.intValue());
/* 184 */       if (s.equals(String.valueOf(somaparaipalvo) + convert)) {
/*     */         
/* 186 */         System.out.println("igual");
/*     */       }
/*     */       else {
/*     */         
/* 190 */         System.out.println("Diferente");
/*     */ 
/*     */         
/*     */         try {
/* 194 */           Session session = jsch.getSession("root", String.valueOf(somaparaipalvo) + convert, 22);
/* 195 */           session.setUserInfo(new MPInfoUser());
/* 196 */           session.setPassword("qwe123!");
/* 197 */           session.connect();
/*     */ 
/*     */ 
/*     */           
/* 201 */           ChannelExec channels0 = (ChannelExec)session.openChannel("exec");
/* 202 */           channels0.setCommand("echo  'Executado Desligamento de Todas as máquinas  " + this.data + " - " + this.hora + ":" + this.min + ":" + this.seg + "' >> /opt/.desligartodas.txt");
/* 203 */           channels0.connect();
/* 204 */           channels0.disconnect();
/*     */ 
/*     */           
/* 207 */           ChannelExec channels1 = (ChannelExec)session.openChannel("exec");
/* 208 */           channels1.setCommand("shutdown -h now");
/* 209 */           channels1.connect();
/* 210 */           channels1.disconnect();
/*     */           
/* 212 */           session.disconnect();
/*     */         }
/* 214 */         catch (JSchException e) {
/*     */           
/* 216 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 221 */       System.out.println(String.valueOf(somaparaipalvo) + convert);
/* 222 */       aa = Integer.valueOf(aa.intValue() + 1);
/*     */     } 
/*     */ 
/*     */     
/* 226 */     getDesligar();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getReiniciarTodas() {
/* 235 */     JSch jsch = new JSch();
/* 236 */     Tray traysistema = new Tray();
/*     */ 
/*     */     
/* 239 */     String somarCaratcter = "";
/* 240 */     String somaparaipalvo = "";
/* 241 */     String ultiCaratcter = "";
/* 242 */     String caracteres = "#@_\\/.*";
/* 243 */     String[] partes = Tray.meuip.split("[" + Pattern.quote(caracteres) + "]");
/*     */ 
/*     */     
/* 246 */     Integer nn = Integer.valueOf(0); byte b; int j; String[] arrayOfString;
/* 247 */     for (j = arrayOfString = partes.length, b = 0; b < j; ) { String i = arrayOfString[b];
/* 248 */       somarCaratcter = String.valueOf(somarCaratcter) + i + ".";
/*     */       
/* 250 */       ultiCaratcter = i;
/* 251 */       System.out.println(i);
/* 252 */       if (nn.intValue() < 3) {
/* 253 */         somaparaipalvo = String.valueOf(somaparaipalvo) + i + ".";
/*     */       }
/*     */       
/* 256 */       nn = Integer.valueOf(nn.intValue() + 1); System.out.println(nn);
/* 257 */       System.out.println(somaparaipalvo);
/*     */       b++; }
/*     */     
/* 260 */     String s = somarCaratcter.substring(0, somarCaratcter.length() - 1);
/* 261 */     Integer aa = Integer.valueOf(1);
/* 262 */     while (aa.intValue() < 254) {
/*     */       
/* 264 */       String convert = Integer.toString(aa.intValue());
/* 265 */       if (s.equals(String.valueOf(somaparaipalvo) + convert)) {
/*     */         
/* 267 */         System.out.println("igual");
/*     */       }
/*     */       else {
/*     */         
/* 271 */         System.out.println("Diferente");
/*     */ 
/*     */         
/*     */         try {
/* 275 */           Session session = jsch.getSession("root", String.valueOf(somaparaipalvo) + convert, 22);
/* 276 */           session.setUserInfo(new MPInfoUser());
/* 277 */           session.setPassword("qwe123!");
/* 278 */           session.connect();
/*     */ 
/*     */ 
/*     */           
/* 282 */           ChannelExec channels0 = (ChannelExec)session.openChannel("exec");
/* 283 */           channels0.setCommand("echo  'Executado Reinicialização de Todas as máquinas  " + this.data + " - " + this.hora + ":" + this.min + ":" + this.seg + "' >> /opt/.reiniciartodas.txt");
/* 284 */           channels0.connect();
/* 285 */           channels0.disconnect();
/*     */ 
/*     */           
/* 288 */           ChannelExec channels1 = (ChannelExec)session.openChannel("exec");
/* 289 */           channels1.setCommand("reboot");
/* 290 */           channels1.connect();
/* 291 */           channels1.disconnect();
/*     */           
/* 293 */           session.disconnect();
/*     */         }
/* 295 */         catch (JSchException e) {
/*     */           
/* 297 */           e.printStackTrace();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 302 */       System.out.println(String.valueOf(somaparaipalvo) + convert);
/* 303 */       aa = Integer.valueOf(aa.intValue() + 1);
/*     */     } 
/*     */ 
/*     */     
/* 307 */     getReiniciar();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void getipverdade() {
/* 313 */     Tray traysistema = new Tray();
/*     */     
/* 315 */     String somarCaratcter = "";
/* 316 */     String somaparaipalvo = "";
/* 317 */     String ultiCaratcter = "";
/* 318 */     String caracteres = "#@_\\/.*";
/* 319 */     String[] partes = Tray.meuip.split("[" + Pattern.quote(caracteres) + "]");
/* 320 */     Integer nn = Integer.valueOf(0); byte b; int j; String[] arrayOfString;
/* 321 */     for (j = arrayOfString = partes.length, b = 0; b < j; ) { String i = arrayOfString[b];
/* 322 */       somarCaratcter = String.valueOf(somarCaratcter) + i + ".";
/*     */       
/* 324 */       ultiCaratcter = i;
/* 325 */       System.out.println(i);
/* 326 */       if (nn.intValue() < 3) {
/* 327 */         somaparaipalvo = String.valueOf(somaparaipalvo) + i + ".";
/*     */       }
/*     */       
/* 330 */       nn = Integer.valueOf(nn.intValue() + 1); System.out.println(nn);
/* 331 */       System.out.println(somaparaipalvo);
/*     */       b++; }
/*     */     
/* 334 */     JOptionPane.showMessageDialog(null, somaparaipalvo);
/*     */ 
/*     */ 
/*     */     
/* 338 */     JOptionPane.showMessageDialog(null, ultiCaratcter);
/* 339 */     String s = somarCaratcter.substring(0, somarCaratcter.length() - 1);
/* 340 */     JOptionPane.showMessageDialog(null, s);
/*     */     
/* 342 */     Integer aa = Integer.valueOf(1);
/* 343 */     while (aa.intValue() < 8) {
/* 344 */       String convert = Integer.toString(aa.intValue());
/* 345 */       if (s.equals(String.valueOf(somaparaipalvo) + convert)) {
/* 346 */         JOptionPane.showMessageDialog(null, "igual");
/*     */       } else {
/*     */         
/* 349 */         JOptionPane.showMessageDialog(null, "Diferente");
/*     */       } 
/* 351 */       JOptionPane.showMessageDialog(null, s);
/* 352 */       JOptionPane.showMessageDialog(null, String.valueOf(somaparaipalvo) + convert);
/* 353 */       aa = Integer.valueOf(aa.intValue() + 1);
/*     */     } 
/*     */     
/* 356 */     System.exit(0);
/*     */   }
/*     */ }


/* Location:              /home/jango/Documentos/Estudando Programação/javadesligarmulyiterminal/00/traymeu/!/com/ssh/sshconect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */