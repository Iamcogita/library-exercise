public class Client {

    private int clientId;
    private Library library;

    private TradeLibrary tradeLib;
    private boolean hasDonated;

    public Book[] heldBooks = new Book[4];
    private String clientName;

    Client(String clientName){
        this.clientName = clientName;
        this.clientId = this.hashCode();
        //heldBooks[0] = new Book("Ayn Rand", "Fountain Head" );
        //heldBooks[1] = new Book("Richard Dawkins", "The Selfish Gene" );
    }


    public void borrowBookByAuthor(String authorName) throws NotInsideLibraryException {
        validateLibrary();
        for (int i = 0; i < heldBooks.length ; i++) {
            if(heldBooks[i] != null){
                continue;
            }
            heldBooks[i] = library.borrowBookByAuthor(authorName, clientId);
            System.out.println(this.getClientName() + " borrowed " + heldBooks[i].getBookTitle() + " by " + heldBooks[i].getAuthorName());
            return;
        }
    }

    public void borrowBookByTitle(String bookTitle) throws NotInsideLibraryException {
        validateLibrary();
        for (int i = 0; i < heldBooks.length; i++) {
            if(heldBooks[i] != null){
                continue;
            }
            heldBooks[i] = library.borrowBookByTitle(bookTitle, clientId);
            System.out.println(this.getClientName() + " borrowed " + heldBooks[i].getBookTitle() + " by " + heldBooks[i].getAuthorName());
            return;
        }
    }

    public String getClientName() {
        return clientName;
    }

    public void setLibrary(Library library) {
        this.library = library;
        System.out.printf("%s got into library: %s \n",this.getClientName(), this.library.getLibraryName());
    }

    public Book giveBackBook(String authorName) throws NotInsideLibraryException {
        validateLibrary();
        for (int i = 0; i < heldBooks.length ; i++) {
            if (heldBooks[i] == null){
                continue;
            }
            if(authorName.equalsIgnoreCase(heldBooks[i].getAuthorName()) && heldBooks[i].getClientId() != 0 ){
                heldBooks[i].setClientId(0);
                System.out.println(this.getClientName() + " returned " + heldBooks[i].getBookTitle());
                return heldBooks[i];
            }
        }
        return null;
    }

    public boolean donateBook(Library libraryName){
        tradeLib.setClientDonated(true);
        return hasDonated = true;
    }


    public void validateLibrary() throws NotInsideLibraryException{
        if(library==null){
            throw new NotInsideLibraryException();
        }
    }
}