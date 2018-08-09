package vendorwar;

/**
 * @author Vizirov, Gabriel
 * @date last modified July 19, 2018
 */

public class Fighter {

	private String vendor;
	private int health;
	private int damage;
	private int attacks;
	private int dodge;
	private int critical;
	private int initiative;
	
	public Fighter() {		//default values
		this.vendor = "";
		this.health = 0;
		this.damage = 0;
		this.attacks = 0;
		this.dodge = 0;
		this.critical = 0;
		this.initiative = 0;
	}
	
	public Fighter(String vendor, int health, int damage, int attacks, int dodge, int critical, int initiative ) {
		this.vendor = vendor;
		this.health = health;
		this.damage = damage;
		this.attacks = attacks;
		this.dodge = dodge;
		this.critical = critical;
		this.initiative = initiative;
	}
	
	public Fighter(String vendor, int health, int damage, int attacks) {
		this.vendor = vendor;
		this.health = health;
		this.damage = damage;
		this.attacks = attacks;
		this.dodge = 0;
		this.critical = 0;
		this.initiative = 0;
	}
	
	//VENDOR
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public String getVendor() {
		return this.vendor;
	}
	
	//HEALTH
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	//DAMAGE
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	//ATTACKS
	public void setAttacks(int attacks) {
		this.attacks = attacks;
	}
	
	public int getAttacks() {
		return this.attacks;
	}
	
	
	//DODGE
	public void setDodge(int dodge) {
		this.dodge = dodge;
	}
	
	public int getDodge() {
		return this.dodge;
	}
	
	
	//CRITICAL
	public void setCritical(int critical) {
		this.critical = critical;
	}
	
	public int getCritical() {
		return this.critical;
	}
	
	
	//INITIATIVE
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	
	public int getInititative() {
		return this.initiative;
	}
	
	public String toString() {
		return this.vendor + ":\n"
				+ "\t" + "Health: " + this.health + "\n"
				+ "\t" + "Damage: " + this.damage + "\n"
				+ "\t" + "Attacks: " + this.attacks + "\n"
				+ "\t" + "Dodge: " + this.dodge + "\n"
				+ "\t" + "Critical: " + this.critical + "\n"
				+ "\t" + "Initiative: " + this.initiative + "\n";
	}
}
