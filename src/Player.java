public class Player {
    private String name;
    private int healthPercentage;
    private Weapon weapon;

    public enum Weapon {
        SWORD,
        AXE,
        BOW,
        STAFF
    }

    public Player(String name, int healthPercentage, Weapon weapon) {
        this.name = name;
        // healthPercentage'i 0 ile 100 arasında sınırla
        if (healthPercentage < 0) {
            this.healthPercentage = 0;
        } else if (healthPercentage > 100) {
            this.healthPercentage = 100;
        } else {
            this.healthPercentage = healthPercentage;
        }
        this.weapon = weapon;
    }

    public int healthRemaining() {
        return healthPercentage;
    }

    public void loseHealth(int damage) {
        healthPercentage -= damage;
        if (healthPercentage <= 0) {
            System.out.println(name + " player has been knocked out of the game");
            healthPercentage = 0;
        }
    }

    public void restoreHealth(int healthPotion) {
        healthPercentage += healthPotion;
        if (healthPercentage > 100) {
            healthPercentage = 100;
        }
    }

    public static void main(String[] args) {
        Player player1 = new Player("Alice", 80, Weapon.SWORD);
        Player player2 = new Player("Bob", 120, Weapon.BOW);

        System.out.println(player1.name + " has " + player1.healthRemaining() + " health remaining.");
        System.out.println(player2.name + " has " + player2.healthRemaining() + " health remaining.");

        player1.loseHealth(30);
        player2.loseHealth(50);

        System.out.println(player1.name + " has " + player1.healthRemaining() + " health remaining.");
        System.out.println(player2.name + " has " + player2.healthRemaining() + " health remaining.");

        player1.restoreHealth(20);
        player2.restoreHealth(40);

        System.out.println(player1.name + " has " + player1.healthRemaining() + " health remaining.");
        System.out.println(player2.name + " has " + player2.healthRemaining() + " health remaining.");
    }
}
