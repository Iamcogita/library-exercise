public class TradeLibrary extends Library{
    boolean clientDonated = false;
    public TradeLibrary(String name, int numberOfBooks){
        super(name,numberOfBooks);
        this.clientDonated = clientDonated;
    }
    public boolean setClientDonated(boolean clientDonated) {
        this.clientDonated = clientDonated;
        return clientDonated;
    }
    @Override
    public Book borrowBookByAuthor(String authorName, int clientId) {
        if(clientDonated == false){
            System.out.println("You need to donate a book first!");
        }
        return super.borrowBookByAuthor(authorName, clientId);
    }
    @Override
    public Book borrowBookByTitle(String bookTitle, int clientId) {
        if(clientDonated == false){
            System.out.println("You need to donate a book first!");
        }
        return super.borrowBookByTitle(bookTitle, clientId);
    }
}
