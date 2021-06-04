    //Valutakurs v, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22, v23, v24, v25, v26, v27, v28, v29, v30;
    //ArrayList<Valutakurs> vlist = new ArrayList<Valutakurs>();
    
    import controlP5.*;
    ControlP5 cp5;
    int cnt = 0;
    DropdownList d1, d2;
    //instance
    Gui g;
    
    void setup(){ 
      size(600,425);
      smooth();
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
      
    
    void draw(){
      background(100);
      color c1 = color(60);
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
