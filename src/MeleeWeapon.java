
public class MeleeWeapon extends Weapon
	{
		private int damage;

	public MeleeWeapon(String n, int hp, String dt, int d)
		{
			super(n, hp, dt);
			damage = d;
		}

	public int getDamage()
		{
			return damage;
		}

	public void setDamage(int damage)
		{
			this.damage = damage;
		}

	@Override
	public String toString()
		{
			return "MeleeWeapon [damage=" + damage + ", name=" + name + ", hitPoints=" + hitPoints + ", damageType="
					+ damageType + ", getDamage()=" + getDamage() + ", getName()=" + getName() + ", getHitPoints()="
					+ getHitPoints() + ", getDamageType()=" + getDamageType() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}

	
	}
