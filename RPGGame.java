class Character {
    protected String name;
    protected int health;
    protected int mana;
    protected int level;

    public Character(String name, int health, int mana, int level) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.level = level;
    }

    public void attack(Character target) {
        System.out.println(this.name + " attacks " + target.name + "!");
    }

    public void defend() {
        System.out.println(this.name + " defends!");
    }

    public void castSpell(Character target) {
        System.out.println(this.name + " tries to cast a spell on " + target.name + ", but nothing happens!");
    }

    public void levelUp() {
        this.level += 1;
        this.health += 10;
        this.mana += 5;
        System.out.println(this.name + " leveled up to level " + this.level + "!");
    }
}

class Warrior extends Character {
    private int strength;
    private int armor;

    public Warrior(String name, int health, int mana, int level, int strength, int armor) {
        super(name, health, mana, level);
        this.strength = strength;
        this.armor = armor;
    }

    public void powerStrike(Character target) {
        int damage = this.strength * 2;
        target.health -= damage;
        System.out.println(this.name + " performs Power Strike on " + target.name + ", dealing " + damage + " damage!");
    }
}

class Mage extends Character {
    private int intelligence;
    private int spellPower;

    public Mage(String name, int health, int mana, int level, int intelligence, int spellPower) {
        super(name, health, mana, level);
        this.intelligence = intelligence;
        this.spellPower = spellPower;
    }

    public void castFireball(Character target) {
        int damage = this.spellPower * 3;
        target.health -= damage;
        this.mana -= 10;
        System.out.println(this.name + " casts Fireball on " + target.name + ", dealing " + damage + " damage!");
    }
}

class Rogue extends Character {
    private int agility;
    private int dexterity;

    public Rogue(String name, int health, int mana, int level, int agility, int dexterity) {
        super(name, health, mana, level);
        this.agility = agility;
        this.dexterity = dexterity;
    }

    public void backstab(Character target) {
        int damage = this.dexterity * 3;
        target.health -= damage;
        System.out.println(this.name + " performs Backstab on " + target.name + ", dealing " + damage + " damage!");
    }
}

public class RPGGame {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Thorin", 100, 30, 1, 15, 10);
        Mage mage = new Mage("Gandalf", 80, 100, 1, 20, 25);
        Rogue rogue = new Rogue("Loki", 90, 40, 1, 18, 22);

   
        warrior.attack(mage);
        mage.castFireball(warrior);
        rogue.backstab(warrior);

        warrior.levelUp();
        mage.levelUp();
        rogue.levelUp();

        warrior.powerStrike(mage);
        mage.castFireball(rogue);
        rogue.backstab(mage);
    }
}
