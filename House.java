import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> resident;
  private boolean hasDiningRoom;

  /**
   * Constucts house building with name, address, floors, diningroom, and space for residents
   * @param name house name
   * @param address house address 
   * @param nFloors house floors
   * @param DiningRoom if house has diningroom
   */
  public House(String name, String address, int nFloors, boolean DiningRoom){
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    this.resident = new ArrayList<>();
    this.hasDiningRoom = DiningRoom;
  }

  /**
   * Return house name
   * @return String name of house
   */
  public String getName(){
    return name;
  }

  /**
   * Returns if house has dining room or not
   * @return boolean dining hall
   */
public boolean hasDiningRoom(){
  System.out.println("Does " + this.getName() + " have a dining hall? " + hasDiningRoom);
  return hasDiningRoom; 
}

/**
 * Returns number of residents in house
 * @return int number of residents
 */
public int nResidents(){
  System.out.println("Number of residents in " + this.getName() + ": " + resident.size());
  return resident.size();
}

/**
 * Adds student into house
 * @param s Student moving into house
 */
public void moveIn(Student s){
  resident.add(s);
  System.out.println(s.getName() + " is now a resident of " + this.getName());
}

/**
 * Removes student from house
 * @param s Student leaving house
 */
public Student moveOut(Student s){
  if (resident.remove(s)) {
    System.out.println(s.getName() + " moved out of " + this.getName());
    return s; 
  }
  System.out.println(s.getName() + " is not a resident of " + this.getName());
  return null;
}

/**
 * Checks if student is a resident of hosue
 * @return boolean if student is resident
 */
public boolean isResident(Student s){
  if (resident.contains(s)) {
    System.out.println(s.getName() + " is a resident of " + this.getName());
    return true; 
  }
  return false;
}

  public static void main(String[] args) {
    House Wilson = new House("Wilson","123 Chapin Way", 4, true);
    House Nogi = new House("Nogi", "123 Elm Street", 5, false);
    Student Vivian = new Student("Vivian", "6767", 2028);
    Student Emily = new Student("Emily","123", 2028);
    Wilson.hasDiningRoom();
    Nogi.hasDiningRoom();
    Wilson.moveIn(Emily);  
    Nogi.moveIn(Vivian);
    Nogi.moveOut(Vivian);
    Wilson.nResidents();

  }
}