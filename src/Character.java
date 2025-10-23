class Character {
    String name;
    int hp, mp, sp;
    int attackDamage;

    public Character(String name, int hp, int mp, int sp, int attackDamage) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.sp = sp;
        this.attackDamage = attackDamage;
    }

    public void attack(Character enemy) {
        if (sp >= 2) {
            sp -= 2;
            enemy.hp -= attackDamage;
            System.out.println(name + " attacks " + enemy.name + " for " + attackDamage + " damage!");
        } else {
            System.out.println(name + " doesn't have enough SP to attack!");
        }
    }

    public void defend() {
        if (sp >= 3) {
            sp -= 3;
            System.out.println(name + " defends and takes reduced damage next turn!");
        } else {
            System.out.println(name + " doesn't have enough SP to defend!");
        }
    }

    public void useItem() {
        System.out.println(name + " uses a healing potion and restores 20 HP!");
        hp += 20;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void displayStatus() {
        System.out.println(name + " [HP: " + hp + ", MP: " + mp + ", SP: " + sp + "]");
    }
}