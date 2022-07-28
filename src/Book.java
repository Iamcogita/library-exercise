public class Book {
    private String authorName;
    private String bookTitle;
    private Library originalOwner;
    private int clientId;
    Book(String authorName, String bookTitle, Library originalOwner ) {
        this.authorName = authorName;
        this.bookTitle = bookTitle;
        this.originalOwner = originalOwner;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Library getCurrentOwner() {
        return originalOwner;
    }

    public int getClientId() {
        return clientId;
    }
}