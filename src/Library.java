public abstract class Library {

    public String libraryName;

    private int numOfBooksOwned;

    private Book[] ownedBooks;

    public Library(String libraryName, int numberOfBooks) {
        this.libraryName= libraryName;
        this.ownedBooks = new Book[numberOfBooks];
        this.ownedBooks[0] = new Book("Richard Dawkins", "The Selfish Gene", this );
        this.ownedBooks[1] = new Book("Ayn Rand", "Fountain Head", this );
        this.ownedBooks[2] = new Book("Sesame Street", "the birds and the bees", this);
        this.ownedBooks[3] = new Book("Jack Kerouac", "On the road", this );
        this.numOfBooksOwned = 4;
    }
    public void orderBooks(String authorName , String bookTitle ){
        if(ownedBooks.length < numOfBooksOwned){
            ownedBooks = doubleSpaces(ownedBooks);
        }
        ownedBooks[numOfBooksOwned] = new Book( authorName , bookTitle, this );
        numOfBooksOwned++;
    }

    public Book[] doubleSpaces(Book[] tempArr){
        Book[] newArr = new Book[(tempArr.length + 1) * 2];
        for (int i = 0; i < tempArr.length ; i++) {
            newArr[i] = tempArr[i] ;
        }
        tempArr = newArr ;
        return tempArr;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public Book borrowBookByTitle(String bookTitle , int clientId) {
        for (Book ownedBook : ownedBooks) {
            if (ownedBook == null) {
                System.out.println("We don't have that item.");
                return null;
            }
            if (bookTitle.equalsIgnoreCase(ownedBook.getBookTitle()) && ownedBook.getClientId() == 0) {
                ownedBook.setClientId(clientId);
                return ownedBook;
            }
        }
        return null;
    }

    public Book borrowBookByAuthor(String authorName , int clientId) {
        for (Book ownedBook : ownedBooks) {
            if (ownedBook == null) {
                System.out.println("We don't have that item.");
                return null;
            }
            if (authorName.equalsIgnoreCase(ownedBook.getAuthorName()) && ownedBook.getClientId() == 0) {
                ownedBook.setClientId(clientId);
                return ownedBook;
            }
        }
        return null;
    }
    public void showInventory(){
        System.out.println("\n"+ this.getLibraryName() + " inventory:" );
        System.out.println("------------------------");
        for ( Book books : ownedBooks ) {
            System.out.println(books.getBookTitle() + " by: " + books.getAuthorName());
        }
    }
}
