package efs.task.oop;

abstract class Monster implements Fighter{
    protected int health;
    protected int damage;
    public Monster(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }
    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
}
