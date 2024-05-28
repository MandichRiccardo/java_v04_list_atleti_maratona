public class List {
    protected Node start;

    public List(){
        start = null;
    }

    public void addNode(Node n) throws MinorAgeRuntimeException {
        if (start != null) addNextNode(start, n);
        else{
            if(n.isAdult()){
                this.start = n;
                start.getValue().setPettorale(1);
            }else{
                throw new MinorAgeRuntimeException("gli atleti minorenni non possono iscriversi");
            }
        }
    }

    protected void addNextNode(Node current, Node n) throws MinorAgeRuntimeException, AtleteAlreadySignedRuntimeException {
        if(current.getNext() != null) {
            if(!current.getNext().equals(n)) addNextNode(current.getNext(), n);
            else throw new AtleteAlreadySignedRuntimeException("l'atleta si è già iscritto a questa maratona");
        } else {
            if(n.isAdult()){
                current.setNext(n);
                n.getValue().setPettorale(current.getValue().getPettorale()+1);
            }else{
                throw new MinorAgeRuntimeException("gli atleti minorenni non possono iscriversi");
            }
        }
    }


    public void removeNode(Node n){
        try {
            if (start.equals(n)) start = start.getNext();
            else removeNextNode(start, n);
        }catch (NullPointerException e){
            System.out.println("non ho potuto rimuovere questo nodo perché non lo ho trovato");
        }
    }

    protected void removeNextNode(Node current, Node n){
        if(current.getNext().equals(n)) current.setNext(current.getNext().getNext());
        else removeNextNode(current.getNext(), n);
    }

    public int getSize(){
        return start == null ? 0 : start.getSize();
    }

    public int getPettoraleRecord(){
        try{
            return start.getPettoraleRecord(start);
        }catch (NullPointerException e){
            throw new NoSignedAtleteRuntimeException("in questa maratona non ci sono iscritti");
        }
    }

    public String getPiuMaratone(){
        try{
            return start.getPiuMaratone(start);
        }catch (NullPointerException e){
            throw new NoSignedAtleteRuntimeException("in questa maratona non ci sono iscritti");
        }
    }

    public void print(String nazionalita){
        System.out.println(toString(nazionalita));
    }

    public void print(){
        System.out.println(this);
    }

    public String toString(String nazionalita){
        String info = "";
        info += "\tlista iniziata\n";
        if(start != null) info += "\tstart:\n" + start.toString(nazionalita) + "\n";
        else info += "\tlista terminata\n";
        return info;
    }

    public String toString(){
        String info = "";
        info += "\tlista iniziata\n";
        if(start != null) info += "\tstart:\n" + start + "\n";
        else info += "\tlista terminata\n";
        return info;
    }
}