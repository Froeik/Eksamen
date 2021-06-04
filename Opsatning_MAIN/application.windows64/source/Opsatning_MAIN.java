import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Opsatning_MAIN extends PApplet {

    //Valutakurs v, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30;
    //ArrayList<Valutakurs> vlist = new ArrayList<Valutakurs>();
    
    
    ControlP5 cp5;
    int cnt = 0;
    DropdownList d1, d2;
    //instance
    Gui g;
    
    public void setup(){ 
      
      
      noStroke();
      cp5 = new ControlP5(this);
       g = new Gui();
    }
    public void Omregn(){
      //Nu er det muligt at sætte variable ind i indput, og hente det
      cp5.get(Textfield.class,"Input1").getText();
      String s = cp5.get(Textfield.class,"Input1").getText();
      //Omregn fra string til float, så mine valutaer laves med decimaler. Her henter jeg så float-værdien i input-boks
      float FloatIndput = Float.parseFloat(s);
      
      //Indput konstanten sættes her
      int index=(int)g.I2.getValue();
      float konstant1 = (g.vlist.get(index).kurs);
      
      //Output konstant variable
      int index2=(int)g.O2.getValue();
      float konstant2 = (g.vlist.get(index2).kurs);
      
      //Udregning af variabler
      Float FloatOutput = FloatIndput/konstant1*konstant2;
      println();
      g.O1.setText(FloatOutput.toString());
      
    }
      
    
    public void draw(){
      background(100);
      int c1 = color(60);
      rect(320, 255, 150, 35);
      fill (c1);
    }
    
    /*void controlEvent(ControlEvent theEvent) {
      // DropdownList is of type ControlGroup.
      // A controlEvent will be triggered from inside the ControlGroup class.
      // therefore you need to check the originator of the Event with
      // if (theEvent.isGroup())
      // to avoid an error message thrown by controlP5.
    
      // her er det som sker når man vægler et element
      if ((theEvent.isFrom(cp5.getController("Omregn")))) {
        // check if the Event was triggered from a ControlGroup
        println("event from group : "+theEvent.getGroup().getValue()+" from "+theEvent.getGroup());
      } else if (theEvent.isController()) {
      println("event from controller : "+theEvent.getController().getValue()+" from "+theEvent.getController());
      }
    }*/
class Gui {
  Textfield I1;
  Textlabel O1;
  DropdownList I2, O2;
  Button Confirm;
  Textlabel Titel,Forklaring,Forklaring1, Forklaring2;
  Valutakurs v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30;
  ArrayList<Valutakurs> vlist = new ArrayList<Valutakurs>();
  //laver en global font for at kunne manipulere de forskellige textfelter
  PFont font;

  Gui() {
    fillValuta();
    font = createFont("Times New Roman", 20);
    I1 = cp5.addTextfield("Input1");
    I1.setPosition(110, 256)
      .setSize(150, 35)
      .setFont(font)
      .setColorBackground(0xff3E3E3E) 
      .setAutoClear(false)
      .setLabel("        Indput                          Output");

    O1 = cp5.addTextlabel("Output1");
    O1.setPosition(320, 256)
      .setSize(150, 35)
      .setFont(font)
      .setColorBackground(0xff3E3E3E) 
      .setLabel("       Output");
      //Dette er OK knap
 
    Confirm = cp5.addButton("Omregn");
    Confirm.setPosition(210, 350)
      .setSize(150, 50)
      .setFont(font)
      .activateBy(ControlP5.RELEASE);
      
    //DROPDOWNLIST
    I2 = cp5.addDropdownList("Input2")
      .setPosition(110, 175)
      .setSize(150, 80);
    customize(I2);

    O2 = cp5.addDropdownList("Output2")
      .setPosition(320, 175)
      .setSize(150, 80);
      
      customize(O2);

      O2.close();
      
      Titel = cp5.addTextlabel("Titel")
      .setText("Velkommen til Valutaomregner DNV!")
      .setPosition(38, 20)
      .setColorValue(0xffFFFFFF)
      .setFont(createFont("Calisto MT fed", 30));
      
      Forklaring = cp5.addTextlabel("Forklaring")
      .setText("                                                          Guide:")
      .setPosition(45, 90)
      .setColorValue(0xffFFFFFF)
      .setFont(createFont("TimesNewRomanPS-BoldMT", 15));
      
      Forklaring1 = cp5.addTextlabel("Forklaring1")
      .setText("              De ønskede valutaer til omregning vælges på dropdownlisterne.")
      .setPosition(45, 105)
      .setColorValue(0xffFFFFFF)
      .setFont(createFont("TimesNewRomanPS-ItalicMT", 15));
      
      Forklaring2 = cp5.addTextlabel("Forklaring2")
      .setText("     Indtast så den enkelte værdi for Indput, og tryk dernæst på knappen Omregn ")
      .setPosition(45, 120)
      .setColorValue(0xffFFFFFF)
      .setFont(createFont("TimesNewRomanPS-ItalicMT", 15));

  }

  public void customize(DropdownList ddl) {
  // a convenience function to customize a DropdownList
  ddl.setBackgroundColor(color(190));
  ddl.setItemHeight(15);
  ddl.setBarHeight(20);

  ddl.setCaptionLabel("dropdown");

  ddl.getCaptionLabel().getStyle().marginTop = 3;
  ddl.getCaptionLabel().getStyle().marginLeft = 3;
  ddl.getValueLabel().getStyle().marginTop = 3;
  //**************************************************************************

  //**************************************************************************

  //for (int i=0; i<168; i++) {
    for (int i=0; i<vlist.size(); i++) {
    Valutakurs va = vlist.get(i);
    ddl.addItem(va.valuta, i);
    // virker ikke
    //ddl.scroll(0);

    ddl.setColorBackground(color(60));
    ddl.setColorActive(color(0xffFFFFFF, 0xffFFFFFF));
  }
}
  public void fillValuta(){
  v0= new Valutakurs("AUD  |  Australske dollar", 1.58f);
  v1= new Valutakurs("AUD  |  UEA dirham", 4.48f);
  v2= new Valutakurs("BRL  |  Brasiliansk real", 0.86f);
  v3= new Valutakurs("CAD  |  Canadisk dollar", 1.47f);
  v4= new Valutakurs("CLP  |  Chilensk peso", 877.39f);
  v4= new Valutakurs("CNY  |  Kinesisk yuan", 7.79f);
  v5= new Valutakurs("COP  |  Colombiansk peso", 4461.48f);
  v6= new Valutakurs("CZK  |  Tjekkisk koruna", 25.46f);
  v7= new Valutakurs("DKK  |  Danske kroner", 7.43f);
  v8= new Valutakurs("EUR  |  Euro", 1);
  v9= new Valutakurs("HUF  |  Ungarsk forint", 346.76f);
  v10= new Valutakurs("INR  |  Indisk rupi", 89.10f);
  v11= new Valutakurs("IDR  |  Indonesiske rupiah", 17406.93f);
  v12= new Valutakurs("ILS  |  Israelske shekel ", 3.97f);
  v13= new Valutakurs("JPY  |  Japanske yen", 133.80f);
  v14= new Valutakurs("KRW  |  Sydkoreansk won", 1356.81f);
  v15= new Valutakurs("MYR  |  Malaysisk ringgit", 5.03f);
  v16= new Valutakurs("MXN  |  Mexicansk peso", 24.32f);
  v17= new Valutakurs("NOK  |  Norske kroner", 10.14f);
  v18= new Valutakurs("NZD  |  Newzealandsk dollar", 1.69f);
  v19= new Valutakurs("PHP  |  Filippinsk peso ", 58.48f);
  v20= new Valutakurs("PLN  |  Polsk zloty", 4.46f);
  v21= new Valutakurs("RON  |  Rumænsk leu", 4.92f);
  v22= new Valutakurs("RUB  |  Russisk rubel", 89.33f);
  v23= new Valutakurs("SAR  |  Saudiarabisk riyal", 4.58f);
  v24= new Valutakurs("SEK  |  Svensk krone ", 0);
  v25= new Valutakurs("SGD  |  Singaporeansk dollar", 6.8f);
  v26= new Valutakurs("THB  |  Thailandsk baht", 37.99f);
  v27= new Valutakurs("TRY  |  Tyrkisk lira", 10.5f);
  v28= new Valutakurs("TWD  |  Nytaiwansk dollar", 33.78f);
  v29= new Valutakurs("USD  |  Amerikansk dollar", 1.22f);
  v30= new Valutakurs("ZAR  |  Sydafrikansk rand", 16.51f);
  vlist.add(v0);
  vlist.add(v1);
  vlist.add(v2);
  vlist.add(v3);
  vlist.add(v4);
  vlist.add(v5);
  vlist.add(v6);
  vlist.add(v7);
  vlist.add(v8);
  vlist.add(v9);
  vlist.add(v10);
  vlist.add(v11);
  vlist.add(v12);
  vlist.add(v13);
  vlist.add(v14);
  vlist.add(v15);
  vlist.add(v16);
  vlist.add(v17);
  vlist.add(v18);
  vlist.add(v19);
  vlist.add(v20);
  vlist.add(v21);
  vlist.add(v22);
  vlist.add(v23);
  vlist.add(v24);
  vlist.add(v25);
  vlist.add(v26);
  vlist.add(v27);
  vlist.add(v28);
  vlist.add(v29);
  vlist.add(v30);
  }
}
      
      
      
class Valutakurs{

float kurs = 0.0f;
String valuta;

Valutakurs(String v, float k){

kurs=k;
valuta=v;
}



}
  public void settings() {  size(600,425);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Opsatning_MAIN" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
