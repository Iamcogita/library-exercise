public class Main {
    public static void main(String[] args) {

        TradeLibrary lib01 = new TradeLibrary("Tade-a-book", 5);
        Client client1 = new Client("David");
        client1.setLibrary(lib01);
        try {client1.borrowBookByAuthor("Richard Dawkins");}
        catch (NotInsideLibraryException e) {throw new RuntimeException(e);}
        try {client1.giveBackBook("Richard Dawkins");}
        catch (NotInsideLibraryException e) {throw new RuntimeException(e);}
        try{client1.borrowBookByTitle("the birds and the bees");}
        catch (NotInsideLibraryException e) {throw new RuntimeException(e);}
        lib01.orderBooks("Orwell", "Brave new World");
        lib01.showInventory();
        try{client1.borrowBookByTitle("The selfish gene");}
        catch (NotInsideLibraryException e) {throw new RuntimeException(e);}
        lib01.showInventory();

    }
}