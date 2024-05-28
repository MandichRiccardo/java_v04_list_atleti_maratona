public class Test{
    public static void main(String[] args) {
        List l = esecuzione(new List());
        System.out.println("programma terminato");
    }

    public static List esecuzione(List l){
        System.out.println("""
                cosa vuoi fare?
                    0)\tterminare il programma
                    1)\tinserire un nuovo atleta
                    2)\teliminare un'atleta
                    3)\tstampare gli atleti di una nazionalità
                    4)\tcalcolare il numero totale di iscritti alla maratona
                    5)\tstampare tutti gli iscritti alla gara
                    6)\tstampare il pettorale dell'atleta migliore
                    7)\tstampare chi ha corso più maratone""");
        switch (getInt(0, 7)){
            default -> {
                return l;
            }
            case 1 -> {
                try{
                    l.addNode(new Node());
                }catch (MinorAgeRuntimeException | AtleteAlreadySignedRuntimeException e){
                    System.out.println(e.getMessage());
                }
                return esecuzione(l);
            }
            case 2 -> {
                l.removeNode(new Node());
                return esecuzione(l);
            }
            case 3 -> {
                System.out.println("inserisci la nazionalità di cui vuoi stampare gli atleti");
                l.print(Atleta.getString());
                return esecuzione(l);
            }
            case 4 -> {
                System.out.println("gli iscritti totali alla maratona sono " + l.getSize());
                return esecuzione(l);
            }
            case 5 -> {
                System.out.println(l);
                return esecuzione(l);
            }
            case 6 -> {
                try {
                    System.out.println("il pettorale dell'atleta con il record migliore è " + l.getPettoraleRecord());
                } catch (NoSignedAtleteRuntimeException e) {
                    System.out.println(e.getMessage());
                }
                return esecuzione(l);
            }
            case 7 -> {
                try {
                    System.out.println(l.getPiuMaratone());
                } catch (NoSignedAtleteRuntimeException e) {
                    System.out.println(e.getMessage());
                }
                return esecuzione(l);
            }
        }
    }

    protected static int getInt(int min){
        int ret = Atleta.getInt();
        if (ret >= min) return ret;
        System.out.println("devi inserire un numero maggiore o uguale a " + min);
        return getInt(min);
    }
    protected static int getInt(int min, int max) {
        if (min > max) throw new RuntimeException("il numero minimo non può essere maggiore del massimo");
        int ret = getInt(min);
        if (ret <= max) return ret;
        System.out.println("devi inserire un numero minore o uguale a " + max);
        return getInt(min, max);
    }
    public static boolean getBoolean(){
        try{
            return new java.util.Scanner(System.in).nextBoolean();
        }catch (java.util.InputMismatchException e){
            System.out.println("devi inserire un booleano nel formato \"true\" o \"false\"");
            return getBoolean();
        }
    }
}