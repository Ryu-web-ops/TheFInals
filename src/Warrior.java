class Warrior extends Character {
    public Warrior(String name) {
        super(name, 120, 30, 50, 25);
    }

    public void primarySkill(Character enemy) {
        if (sp >= 30) {
            sp -= 30;
            int damage = attackDamage + 15;
            enemy.hp -= damage;
            System.out.println(name + " uses Bloodthirst and deals " + damage + " damage, healing for 10 HP!");
            hp += 10;
        } else {
            System.out.println("Not enough SP for Bloodthirst!");
        }
    }
}