package analizadorjava; public class nepe {

    public static void main( String [ ] args ) {
        int n = 0;
        String l = " ";
        boolean 
                b = true;
        float f = 1.8f;
        double d = 1.5;
        System.out.println("hello world"    )    ;
        for (int x 
                = 0; x < 10; x++) {
            switch(x ) {
                case 1 :
                    System.
                            out.println("its: " + x);
                    if (d > 2) {
                        System.out. println ( "its mayor: than " + 2);
                    }
                    b = 
                            false;
                    break;
                case 3:
                    if (b) {
                        b = true;
                    } else {
                        b = false 
                                ;
                    }
                    System.out.println("its: " + x);
                    break;
            }
        }

    }
}
