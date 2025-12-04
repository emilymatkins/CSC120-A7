import java.util.Hashtable;


public class Library extends Building implements LibraryRequirements {

private Hashtable<String, Boolean> collection;

    /**
     * Constucts a Library building with name, address, floors, and space for books
     * @param name library name
     * @param address library address
     * @param nFloors library floors
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      System.out.println("You have built a library: 📖");
      this.collection = new Hashtable<>();
    }

    /**
     * Adds book to collection
     * @param title book added
     */
    public void addTitle(String title){
      collection.put(title, true);
      System.out.println("Added: " + title);
    }

    /**
     * Removes book from collection
     * @param title book removed
     */
    public String removeTitle(String title){
      if (collection.remove(title) != null){
        System.out.println("Removed: " + title);
        return title;
      }
      System.out.println(title + " is not found in collection");
      return null;
    }

    /**
     * Checks book out from collection
     * @param title checked out book
     */
    public void checkOut(String title){
      if (!collection.containsKey(title)){
        System.out.println(title + " not in collection");
        return;
      }
      if (!collection.get(title)){
        System.out.println(title + " is currently unavalible");
        return;
      }
      collection.put(title, false);
      System.out.println("Checked out: " + title);
      
    } 

    /**
     * Returns book from collection
     * @param title book returned
     */
    public void returnBook(String title){
      collection.replace(title, true);
      System.out.println("Returned: " + title);
    } 

    /**
     * Checks if title is in collection
     * @param title book being checked
     * @return boolean if title in collection
     */
    public boolean containsTitle(String title){
      if (collection.containsKey(title)){
        System.out.println(title + " is in collection");
        return true;
      }
      System.out.println(title + " is not in collection");
      return false;
    }

    /**
     * Checks if book is avalible
     * @param title book checked
     * @return boolean if book is avalible
     */
    public boolean isAvailable(String title){
      if (!collection.containsKey(title)){
        System.out.println(title + " is not in collection");
        return false;
      }
      if (!collection.get(title)){
        System.out.println(title + " is currently unavalible");
        return false;
      } 
      System.out.println(title + " is available");
      return true;
    }

    /**
     * Prints collection of books and there avalibility
     */
    public void printCollection(){
      System.out.println("Library Collection:");
      for (String title : collection.keySet()){
        String status = collection.get(title) ? "Available" : "Checked Out";
        System.out.println("-" + title + " (" + status + ") ");
      }
    } 
    
  
    public static void main(String[] args) {
      Library Nelly = new Library("Nelly", "456 Elm Street", 4);
      Nelly.addTitle("Project Hail Mary");
      Nelly.addTitle("Dune");
      Nelly.addTitle("Harry Potter");
      Nelly.checkOut("Harry Potter");
      Nelly.checkOut("Harry Potter");
      Nelly.checkOut("Lord of the Rings");
      Nelly.isAvailable("Dune");
      Nelly.printCollection();
      Nelly.containsTitle("The Martian");
    }
  
  }