public class Spielfeld implements ITuWas, ITastatur
{
    //Attribute
    Rechteck boden;
    Kreis ball;
    Taktgeber takt;
    Tastatur t;
    Schieberegler schieb;
    
    //Anfangsgeschwindigkeit
    int dx=0;
    int dy=1;

    public Spielfeld()
    {
        //Boden
        boden=new Rechteck(150,500,50,5);
        boden.setzeFarbe("schwarz");

        //Ball
        ball=new Kreis(200,100,10);
        ball.setzeFarbe("rot");

        //Taktgeber
        takt=new Taktgeber(this, 10);
        takt.setzeZeitZwischenAktionen(2);
        takt.endlos();

        //Tastatursteuerung
        t=new Tastatur();
        t.setzeLink(this);
        t.meldeAnTaste('a',"a");
        t.meldeAnTaste('d',"d");
        
        //Schieberegler
        schieb=new Schieberegler();
        schieb.setzeID(5);
        schieb.setzeLink(this);
    }

    public void tuWas(int id){
        //Taktgeber ID 10
        if(id==10){
            ball.verschieben(dx,dy);
            //Kollision
            if(ball.kollisionMit(boden)){ 
                dy=-dy;
                // System.out.println("Kollision");
            }
        }
        //Schieberegler
        else if(id==5){
        takt.setzeZeitZwischenAktionen(schieb.leseIntWert());
        }
    }

    public void tastenAktion(String rueckgabe){
        //Steuerung
        if(rueckgabe=="a")boden.verschieben(-3,0);
        if(rueckgabe=="d")boden.verschieben(3,0);         
    }
}

