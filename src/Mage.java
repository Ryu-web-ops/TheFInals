class Mage extends Character {
    public Mage(String name) {
        super(name, 80, 100, 40, 20);
    }

    public void primarySkill(Character enemy) {
        if (mp >= 25) {
            mp -= 25;
            int damage = attackDamage + 20;
            enemy.hp -= damage;
            System.out.println(name + " casts Fireball and deals " + damage + " damage!");
        } else {
            System.out.println("Not enough MP for Fireball!");
        }
    }
}