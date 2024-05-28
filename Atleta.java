public class Atleta {
    private String nome;
    private String cognome;
    private String nazionalita;
    private int nascita;
    private double record;
    private int maratone;
    private int pettorale;

    public Atleta() {
        System.out.println("inserisci il nome di questo atleta (poi ti chiederò anche il cognome)");
        this.nome = getString();
        System.out.println("inserisci il cognome di " + nome);
        this.cognome = getString();
        System.out.println("inserisci l'anno di nascita di " + nome + " " + cognome);
        this.nascita = getInt();
        System.out.println("inserisci la nazionalità di " + nome + " " + cognome);
        this.nazionalita = getString();
        System.out.println("inserisci il record personale in minuti di " + nome + " " + cognome);
        this.record = getInt();
        System.out.println("inserisci il numero di maratone a cui ha partecipato " + nome + " " + cognome);
        this.maratone = getInt();
        this.pettorale = 0;
    }

    public int getPettorale() {
        return pettorale;
    }
    public void setPettorale(int pettorale) {
        this.pettorale = pettorale;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public double getRecord() {
        return record;
    }

    public int getMaratone() {
        return maratone;
    }

    public String getDescrizione(){
        return "l'atleta che ha corso più maratone è " + nome + " " + cognome + " ed è " + nazionalita + "\n";
    }

    public boolean isAdult(){
        return 2024-nascita>17;
    }

    public static int getInt() {
        try{
            return new java.util.Scanner(System.in).nextInt();
        }catch (java.util.InputMismatchException e){
            System.out.println("devi inserire un numero intero");
            return getInt();
        }
    }
    public static String getString(){
        try{
            return new java.util.Scanner(System.in).nextLine();
        }catch (java.util.InputMismatchException e){
            return getString();
        }
    }

    public boolean equals(Atleta a) {
        if(!nome.equals(a.nome)) return false;
        if(!cognome.equals(a.cognome)) return false;
        if(!nazionalita.equals(a.nazionalita)) return false;
        if(nascita != a.nascita) return false;
        if(record != a.record) return false;
        return maratone == a.maratone;
    }

    @Override
    public String toString() {
        String info = "";
        info += "\t\t\tnome:\t\t\t\t\t" + nome + "\n";
        info += "\t\t\tcognome:\t\t\t\t" + cognome + "\n";
        info += "\t\t\tnazionalità:\t\t\t" +  nazionalita + "\n";
        info += "\t\t\tdata di nascita:\t\t" + nascita + "\n";
        info += "\t\t\trecord in minuti:\t\t" + record + "\n";
        info += "\t\t\tmaratone corse:\t\t" + maratone + "\n";
        info += "\t\t\tnumero di pettorale:\t" + pettorale + "\n";
        return info;
    }
}
