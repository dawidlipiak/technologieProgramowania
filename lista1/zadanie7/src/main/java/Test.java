import java.util.Objects;

public class Test {
    public static void main ( String [] argv) {
        Obliczenia [] tab = new AbstractFigura[argv[0].length()];
        
        char rodzajFigury;
        int licznik = 1;
        int rightNumberOfValues = 0;
       
        //Sprawdzenie poprawnej ilości danych
        for(int i = 0; i < argv[0].length(); i++){
            try {
                rodzajFigury = argv[0].charAt(i);

                switch (rodzajFigury) {
                    case 'p' -> rightNumberOfValues++;
                    case 'o' -> rightNumberOfValues++;
                    case 's' -> rightNumberOfValues++;
                    case 'c' -> rightNumberOfValues += 5;
                    default -> {
                        System.out.println(rodzajFigury + " - nieprawidlowe oznaczenie figury");
                        System.exit(0);
                    }
                }
            }
            catch(NumberFormatException ex){
                System.out.println(argv[0].charAt(i) + " - nieprawidlowe oznaczenie figury");
                System.exit(0);
            }  
        }
        
        if( rightNumberOfValues != argv.length-1 ){
            System.out.println("Nieprawidlowa ilosc danych wejsciowych");
            System.exit(0);
        }

        for(int i = 0; i < argv[0].length(); i++ ){
            
            rodzajFigury = argv[0].charAt(i);
            
            switch (rodzajFigury) {
                case 'o':
                    try{    
                        int n = Integer.parseInt(argv[licznik]);
                        if(n>0){
                            Obliczenia kolo = new Kolo(n);
                            tab[i] = kolo;    
                        } 
                        else{
                            System.out.println("ujemna dana");
                            System.exit(0);
                        }                    
                        
                        licznik++;
                        break;
                    }
                    catch(NumberFormatException ex){
                        System.out.println(argv[1] + " - nieprawidlowa dana");
                        System.exit(0);
                    }
                case 'p':
                    try{    
                        int n = Integer.parseInt(argv[licznik]);
                        if(n>0){
                            Obliczenia pieciokat = new Pieciokat(n);
                            tab[i] = pieciokat;
                        }
                        else{
                            System.out.println("ujemna dana");
                            System.exit(0);
                        }      
                        licznik++;
                        break;
                    }
                    catch(NumberFormatException ex){
                        System.out.println(argv[1] + " - nieprawidlowa dana");
                        System.exit(0);
                    }
                case 's':
                    try{    
                        int n = Integer.parseInt(argv[licznik]);
                        if(n>0){
                            Obliczenia szesciokat = new Szesciokat(n);
                            tab[i] = szesciokat;
                        }
                        else{
                            System.out.println("ujemna dana");
                            System.exit(0);
                        }     
                        licznik++;
                        break;
                    }
                    catch(NumberFormatException ex){
                        System.out.println(argv[1] + " - nieprawidlowa dana");
                        System.exit(0);
                    }
                case 'c':
                    try{    
                        int bok1 = Integer.parseInt(argv[licznik]);
                        licznik++;
                        int bok2 = Integer.parseInt(argv[licznik]);
                        licznik++;
                        int bok3 = Integer.parseInt(argv[licznik]);
                        licznik++;
                        int bok4 = Integer.parseInt(argv[licznik]);
                        licznik++;
                        int kat = Integer.parseInt(argv[licznik]);
                        licznik++;

                        if(kat > 90){
                            System.out.println(kat + " - Zla wartosc kata dla czworokata");
                            System.exit(0);
                        }
                        
                        if(kat != 90 && kat>0){
                            Obliczenia romb = new Romb(bok1, kat);
                            tab[i] = romb;
                        }
                            
                        
                        else if( (bok1 == bok2) && (bok1 == bok3) && (bok1 == bok4) ){
                            if(bok1>0){
                                Obliczenia kwadrat = new Kwadrat(bok1);
                                tab[i] = kwadrat;
                            }
                            else{
                                System.out.println("ujemna dana");
                                System.exit(0);
                            }
                        }
                        else if(bok1>0 && bok2>0 && bok3>0 && bok4>0){
                            Obliczenia prostokat = new Prostokat(bok1, bok2, bok3, bok4);
                            tab[i] = prostokat;
                        }
                        else{
                            System.out.println("ujemna dana");
                            System.exit(0);
                        }
                        break;
                    }
                    catch(NumberFormatException ex){
                        System.out.println(argv[licznik] + " - nieprawidlowa dana");
                        System.exit(0);
                    }
                
                default:
                    System.out.println(rodzajFigury + " - nieprawidlowe oznaczenie figury");
                    System.exit(0);
            }
                
            
        }    
        System.out.println();
        licznik = 1;

        //wypisywanie pól i obwodów figur
        for(int i = 0; i < argv[0].length(); i++){
            if(argv[0].charAt(i) == 'o'){
                System.out.println("Obwod kola: " + tab[i].obliczObwod() + "\nPole kola: " + tab[i].obliczPole());
                licznik++;
            }
            else if(argv[0].charAt(i) == 'p'){
                System.out.println("Obwod pieciokata: " + tab[i].obliczObwod() + "\nPole pieciokata: " + tab[i].obliczPole());
                licznik++;
            } 
            else if(argv[0].charAt(i) == 's'){
                System.out.println("Obwod szesciokata: " +tab[i].obliczObwod() + "\nPole szesciokata: " + tab[i].obliczPole());
                licznik++;
            } 
            else if(argv[0].charAt(i) == 'c'){

                if(Integer.parseInt(argv[licznik+4]) != 90 ){
                    System.out.println("Obwod rombu: " + tab[i].obliczObwod() + "\nPole rombu: " + tab[i].obliczPole());
                }
                else if( (Objects.equals(argv[licznik], argv[licznik + 1])) && (Objects.equals(argv[licznik], argv[licznik + 2])) && (Objects.equals(argv[licznik], argv[licznik + 3]))  ){
                    System.out.println("Obwod kwadratu: " + tab[i].obliczObwod() + "\nPole kwadratu: " + tab[i].obliczPole());
                }
                else{
                    System.out.println("Obwod prostokata: " + tab[i].obliczObwod() + "\nPole prostokata: " + tab[i].obliczPole());
                }
                licznik = licznik + 5;
            } 
            System.out.println();
        }
    }
    
}
