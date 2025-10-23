import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Choose your Hero:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        int choice = sc.nextInt();

        Character player;
        Character enemy;

        if (choice == 1) {
            player = new Warrior("Warrior");
            enemy = new Mage("Enemy Mage");
        } else {
            player = new Mage("Mage");
            enemy = new Warrior("Enemy Warrior");
        }

        System.out.println("Battle Start!");
        player.displayStatus();
        enemy.displayStatus();

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nChoose Action:");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Use Item");
            System.out.println("4. Skill");

            int action = sc.nextInt();

            switch (action) {
                case 1 -> player.attack(enemy);
                case 2 -> player.defend();
                case 3 -> player.useItem();
                case 4 -> {
                    if (player instanceof Warrior w) w.primarySkill(enemy);
                    if (player instanceof Mage m) m.primarySkill(enemy);
                }
                default -> System.out.println("Invalid action!");
            }

            // Enemy turn
            if (enemy.isAlive()) {
                if (rand.nextInt(2) == 0) enemy.attack(player);
                else System.out.println(enemy.name + " defends!");
            }

            System.out.println("\nStatus after turn:");
            player.displayStatus();
            enemy.displayStatus();
        }

        if (player.isAlive()) {
            System.out.println("\nYou defeated the enemy!");
        } else {
            System.out.println("\nYou were defeated!");
        }

        sc.close();
    }
}