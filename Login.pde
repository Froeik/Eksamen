class login{
  Textfield LogIn;
  Textfield PassWord;
  Button Confirm;
  
  //laver en global font for at kunne manipulere de forskellige textfelter
  PFont font;
  
login(){
  font = createFont("arial", 40);
  //ved ikke at afslutte din sætning med ";" kan du forsætte med at tilføje forskellige funktiorne til det definerede element i dette tilfælde "LogIn"
  LogIn = cp5.addTextfield("USERNAME");
  LogIn.setPosition(50,150)
    .setSize(300,50)
    .setFont(font)
    .setColor(color(255,255,255))
    .setAutoClear(false)
    .setLabel("LogIn");
 
  // husk en label til dine text felter  
   PassWord = cp5.addTextfield("PASS");
   PassWord.setPosition(50,250)
    .setSize(300,50)
    .setFont(font)
    .setColor(color(255,255,255))
    .setAutoClear(false)
    .setLabel("Password");
  }
}
