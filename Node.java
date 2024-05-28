public class Node{
    private final Atleta value;
    private Node next;

    public Node(Atleta value) {
        this.value = value;
        next = null;
    }
    public Node() {
        value = new Atleta();
        next = null;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public Atleta getValue() {
        return value;
    }

    public boolean isAdult(){
        return value.isAdult();
    }

    public int getSize(){
        try{
            return 1 + next.getSize();
        }catch (NullPointerException e){
            return 1;
        }
    }

    public int getPettoraleRecord(Node record) throws NoSignedAtleteRuntimeException {
        try{
            if(record.getValue().getRecord() > this.value.getRecord()) return next.getPettoraleRecord(this);
            else return next.getPettoraleRecord(record);
        }catch (NullPointerException e){
            try {
                if(record.getValue().getPettorale() > this.value.getPettorale()) return value.getPettorale();
                else return record.getValue().getPettorale();
            } catch (NullPointerException ex) {
                throw new NoSignedAtleteRuntimeException("in questa maratona non ci sono iscritti");
            }
        }
    }

    public String getPiuMaratone(Node record) throws NoSignedAtleteRuntimeException {
        try{
            if(record.getValue().getMaratone() < this.value.getMaratone()) return next.getPiuMaratone(this);
            else return next.getPiuMaratone(record);
        }catch (NullPointerException e){
            try {
                if(record.getValue().getMaratone() < this.value.getMaratone()) record = this;
                return record.getValue().getDescrizione();
            } catch (NullPointerException ex) {
                throw new NoSignedAtleteRuntimeException("in questa maratona non ci sono iscritti");
            }
        }
    }

    @Override
    public String toString() {
        String info ="";
        info += "\t\tvalore:\t" + value + "\n";
        if(next != null) info += "\tsuccessivo:\n" + next;
        else info += "\tlista terminata\n";
        return info;
    }

    public String toString(String nazionalita) {
        if(value.getNazionalita().equals(nazionalita)){
            String info = "";
            info += "\t\tvalore:\t" + value + "\n";
            if (next != null) info += "\tsuccessivo:\n" + next.toString(nazionalita);
            else info += "\tlista terminata\n";
            return info;
        }else {
            try{
                return next.toString(nazionalita);
            }catch (NullPointerException e){
                return "";
            }
        }
    }

    public boolean equals(Node n){
        return this.value.equals(n.value);
    }
}
