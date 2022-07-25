/*     グラフ表示用クラス
	   ※ ローレンツ系（Lorenz system)の解を示すJavaアプレット より
                                Last update: April 18,2006
                                Programed by K. Minemura         */
/* 一部拡張 応用プログラミングⅡ 2012/7/13 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;

// =====  グラフの描画 ===========================================
public class GraphPanel extends JPanel {
   int   Width, Height, Nxmin, Nymin;    // ビューポート変換の使用変数
   float xmin, xmax, ymin, ymax, rx, ry; // ウィンドウポート、スケーリング係数
   float sx=0.75f, sy=0.75f;
   BufferedImage img;
   Graphics g;
     
   public GraphPanel(int width, int height){
      Width=width; Height=height;
      //setSize(Width, Height);
      img = new BufferedImage(Width, Height, BufferedImage.TYPE_INT_RGB);
      g = img.getGraphics();
   }
   
   public void paint(Graphics g)
   {
      int img_offset_x = (getWidth()-Width)/2;
      int img_offset_y = (getHeight()-Height)/2;
      if(img_offset_x<0) img_offset_x = 0;
      if(img_offset_y<0) img_offset_y = 0;
      g.setColor(Color.lightGray);
      g.fillRect(0,0,getWidth(),getHeight());
      g.drawImage(img,img_offset_x,img_offset_y, this);
   }
   
   public void viewPort( int Nup, int Nbot, boolean aspect, double[] range){
      xmin=(float)range[0];  xmax=(float)range[1];
      ymin=(float)range[2];  ymax=(float)range[3];
      transView( Nup, Nbot, aspect );
   }

   // ビューポート変換メソッド
   public void transView( int Nup, int Nbottom, boolean aspect ){
      /*  Nup,Nbottom = ウィンドウ上部及び下部の非描画範囲
          aspect=縦横比を保存する場合はtrue、非保存の場合はfalse  */
      float ap = (ymax-ymin)/(xmax-xmin);
      float aw = (float)(Height-Nup-Nbottom)*sy/(float)Width/sx;
      rx = (float)Width*sx/(xmax-xmin);
      ry = (float)(Height-Nup-Nbottom)*sy/(ymax-ymin);
      Nxmin = (int)((float)Width*(1.0f-sx))/2+15;
      Nymin = Nbottom+(int)((float)(Height-Nup-Nbottom)*(1.0f-sy))/2;
      if(aspect == true){
         if(ap > aw){
            Nxmin += (int)((1.0f-ry/rx)*(float)Width*sx)/2;
            rx = ry;
         }else{
            Nymin += (int)((1.0f-rx/ry)*(float)Height*sy)/2;
            ry = rx;
         }
      }
   }
   //   x座標の変換メソッド
   public int xtr( double x ){
      return (int)(rx*(x-xmin))+Nxmin;
   }
   //   y座標の変換メソッド
   public int ytr( double y ){
      return Height-Nymin-(int)(ry*(y-ymin));
   }
   public void clearImage(){
      g.setColor( Color.white );
      g.fillRect(0,0,Width,Height);
   }
   // データを折線表示し、データ点に丸印を描くメソッド
   public void plotData( double x[], double y[], int N, Color col, Color colp){
      /*  x[],y[]=プロットするデータの座標値；
          col=折線の色;  colp=データ点の色、nullの場合は点を描かない   */
      // int N=x.length;
      int[] xp = new int[N], yp = new int[N];
      g.setColor( col );                    // 折線の色を設定
      for(int i=0; i<N; i++) {
         xp[i] = xtr(x[i]);   yp[i] = ytr(y[i]);
      }
      g.drawPolyline( xp, yp, N );  // 折線
      // colp=null の場合はデータ点を●印で表示しない
      if( colp !=  null){
         int d0 = (int)(0.01f*(float)Width); // 丸印の直径はWidthの1%
         if(d0 < 2) d0 = 2;                  // 最小の丸印直径は2ピクセル
         int r0 = d0/2;                      // 丸印の半径
         g.setColor( colp );      // データ点につける丸印（円）の色を設定
         for(int i=0; i<N; i++){
            g.fillOval( xp[i]-r0, yp[i]-r0, d0, d0 ); // ○印を描画
         }
      }
   }
   // データを折線表示し、データ点に丸印を描くメソッド
   public void plotPoints( double x[], double y[], Color col ){
      /*  x[],y[]=プロットするデータの座標値； col=データ点の色  */
      int N=x.length;
      g.setColor( col );                   // 折線の色を設定
      int d0 = (int)(0.015f*(float)Width); // 丸印の直径はWidthの2%
      if(d0 < 2) d0 = 2;                   // 最小の丸印直径は2ピクセル
      int r0 = d0/2;                       // 丸印の半径
      for(int i=0; i<N; i++) {
         g.fillOval( xtr(x[i])-r0, ytr(y[i])-r0, d0, d0 ); // ○印を描画
      }
   }

   // 座標軸を書くメソッド
   public void drawAxis(String strx, int xdiv, String stry, int ydiv){
      /* (x1,x0)=x軸の描画範囲、 (y0,y1)=y軸の範囲
          xdiv=x軸の目盛の数、    ydiv=y軸の目盛の数    */
      g.setColor(Color.black);
      int i, strW, strH, xs, ys;
      String str;
      Font font= new Font("TimesRoman",Font.PLAIN,12);// 使用フォントの宣言
      Font fontS=new Font("TimesRoman",Font.ITALIC,12);
      g.setFont( font );
      FontMetrics fm=g.getFontMetrics();            // フォントの寸法を取得
      strH=fm.getHeight(); // getLeading()+fm.getAscent();
      float value;
      int m=(int)(0.01f*(float)Width);    // 目盛線長さ
      if(m == 0)  m = 1;
      // x軸を描画
      xs=xtr(xmax);  ys=ytr(0.0);
      g.drawLine(xtr(xmin), ys, xs, ys);
      g.setFont( fontS ); g.drawString(strx, xs+5, ys-strH/2); // x軸の名称
      g.setFont( font );
      for(i=0; i<=xdiv; i++){       // x軸の目盛・数値の描画
         value = xmin+(float)i*(xmax-xmin)/(float)xdiv; // 目盛数値
         str = roundValue( value ); // 数値を丸めて文字列に変換
         strW=fm.stringWidth(str);  // 文字列の全幅を取得
         xs=xtr(value); ys=ytr(0.0);
         g.drawLine(xs, ys-m, xs, ys+m); // 目盛線
        g.drawString(str, xs-strW/2, ys-m+strH+9);// 数値記入
      }
      // y軸を描画
      xs=xtr(0.0);  ys=ytr(ymax);
      g.drawLine(xs, ytr(ymin), xs, ys);
      g.setFont( fontS );
      g.drawString(stry, xs-fm.stringWidth(stry)/2, ys-strH+7); // y軸の名称
      g.setFont( font );
      for(i=0;i<=ydiv;i++){      // y軸の目盛・数値の描画
         value = ymin+(float)i*(ymax-ymin)/(float)ydiv;
         str = roundValue( value ) ; 
         strW=fm.stringWidth(str);
         xs=xtr(0.0);  ys=ytr(value);
         g.drawLine(xs-m, ys, xs+m, ys);
         g.drawString(str, xs-strW-9, ys+strH/2);
      }
   }
   //   データを数表として出力するメソッド
   int writeTable( double[] x, int line0 ){
      int  line=line0, j0 = 0, jmax=5;
      for( int i=0; i<( x.length/5); i++){
         for(int j=j0; j<j0+5; j++) 
            g.drawString("   "+(float)x[j], (j-j0)*75, line );
         j0 += 5;  line += 14;
      }
      return line;
   }
   //  有効数字4桁に丸めるメソッド
   String roundValue( float x ){
      double aa;  float bb = x;  int desimalP, desimal0;
      String str="";
      aa = Math.rint( Math.abs( x )*10000.0 )*0.0001;
      str=""+aa+"0000";
      desimal0 = str.indexOf( "00" );
      desimalP = str.indexOf(".");
      if(desimal0-desimalP==1) desimal0=desimalP;
      if( aa >= 100.0 ) desimal0=3;   // 
      if( aa >= 1000.0) desimal0=4;
      str = str.substring( 0, desimal0 );
      if( bb < 0.0 ) str="-"+str;
      return str;
   }
   //
   // 軸測投影変換メソッド
   float[] ax=new float[3], ay=new float[3], az=new float[3];
   public void transAxono( double theta, double phi ){//]){
      float sp, cp, st, ct;          // 角度のsin,cosの値
      // theta ; y軸周りの回転角度  phi;  x軸周りの回転角度
      ct = (float)Math.cos( theta );  st = (float)Math.sin( theta );
      cp = (float)Math.cos( phi );     sp = (float)Math.sin( phi );
      ax[0]=cp*ct; ax[1]=-st*cp; ax[2]=sp;
      ay[0]=st;      ay[1]=ct;
      az[0]=-ct*sp;az[1]=st*sp;  az[2]=cp;
   }

   //   軸測投影図の作画メソッド
   public void drawInstant( double[] x, double[] y, double[] z, int k, Color col ){
      int px0, py0, px1, py1;
      float zdepth=(float)z[0];
      px0 = xtr(ay[0]*(float)x[k-1]+ay[1]*(float)y[k-1]);
      py0 = ytr(az[0]*(float)x[k-1]+az[1]*(float)y[k-1]+az[2]*(float)z[k-1]);
      px1 = xtr(ay[0]*(float)x[k]+ay[1]*(float)y[k]);
      py1 = ytr(az[0]*(float)x[k]+az[1]*(float)y[k]+az[2]*(float)z[k]);
      zdepth =(az[0]*(float)x[k]+az[1]*(float)y[k]+az[2]*(float)z[k])/60.0f;
      if( col == null ) // 原点からの距離に応じて色を変える
         col = Color.getHSBColor( zdepth, 1.0f, 1.0f );
      g.setColor( col );
      g.drawLine( px0, py0, px1, py1 );
   }
   //   軸測投影図の座標軸作画メソッド（引数は軸の長さ）
   public void drawAxAxis( float length ){
      float xa[]={0F, 0F, 0F}, ya[]={0F, 0F, 0F}, za[]={0F, 0F, 0F};
      xa[0]=length; ya[1]=length; za[2]=length;
      float xe, ye;
      g.setColor( Color.blue );
      for( int i = 0;  i < 3; i++){  // 座標軸
         xe =  ay[0]*xa[i]+ay[1]*ya[i];
         ye =  az[0]*xa[i]+az[1]*ya[i]+az[2]*za[i];
         g.drawLine( xtr(0.0), ytr(0.0), xtr(xe), ytr(ye));
         if(i==0){ xe = ay[0]*(xa[0]+2.0f); ye = az[0]*(xa[0]+2.0f);
                  g.drawString("x", xtr(xe), ytr(ye) ); }
         if(i==1){ xe = ay[1]*(ya[1]+2.0f); ye = az[1]*(ya[1]+2.0f);
                  g.drawString("y", xtr(xe), ytr(ye) ); }
         if(i==2){ xe = 0.0f;  ye = az[2]*(za[2]+2.0f);
                  g.drawString("z", xtr(xe), ytr(ye) ); }
      }
   }
   // 座標(x0,y0,z0)に赤色で丸印をつける
   public void plotPoint(double x0, double y0, double z0 ){
      g.setColor( Color.red );
      float xe = ay[0]*(float)x0+ay[1]*(float)y0;
      float ye = az[0]*(float)x0+az[1]*(float)y0+az[2]*(float)z0;
      g.fillOval( xtr(xe)-3, ytr(ye)-3, 6, 6 );
      g.setColor( Color.blue );
      g.drawRect( 0, 0, Width-1, Height-1 );
      g.drawString("Drag your mouse to change view angle.",20,Height-10);
   }
}