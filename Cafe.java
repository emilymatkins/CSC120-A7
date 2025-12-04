public class Cafe extends Building implements CafeRequirements{

private int nCoffeeOunces;
private int nSugarPackets;
private int nCreams;
private int nCups;

/**
 * Constucts a cafe building with name, address, nfloors and set amount of inventory
 * @param name cafe name
 * @param address cafe address
 * @param nFloors cafe floors
 */
    public Cafe(String name, String address, int nFloors){
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = 200;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 1;
    }

    /**
     * Sells coffee by first checking if inventory is stocked then subtracts amount from current inventory
     * @param size amount of coffee sold
     * @param nSugarPackets amount o sugar packets sold
     * @param nCreams amount of creams sold
     * 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size ||
            this.nSugarPackets < nSugarPackets ||
            this.nCreams < nCreams ||
            this.nCups < 1) {
                System.out.println("Must restock inventory!");
            }
        
            else {
                this.nCoffeeOunces -= size;
                this.nSugarPackets -= nSugarPackets;
                this.nCreams -= nCreams; 
                this.nCups -= 1;
                System.out.println("Sold a Coffee!");
            }
    }

    /**
     * Restocks inventory by inputed amount
     * @param nCoffeeOunces amount restocked
     * @param nSugarPackets amount restocked
     * @param nCreams amount restocked
     * @param nCups amount restocked
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams; 
        this.nCups += nCups;
        System.out.println("Inventory restocked!");
    }
    
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "1 Chapin Way", 1);
        compass.sellCoffee(200, 100, 100);
        compass.restock(100, 100, 100, 1);
        compass.sellCoffee(200, 200, 200);
    }
    
}
