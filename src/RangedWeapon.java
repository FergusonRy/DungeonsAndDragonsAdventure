
public class RangedWeapon extends Weapon
	{
		private int range;
		private int ammo;
		private int damage;
		private boolean equiped = false;
		public RangedWeapon(String n, int hp, String dt, int r, int a, int d) 
			{
			super(n, hp, dt);
			range = r;
			ammo = a;
			damage = d;

			}

		public int getRange()
			{
				return range;
			}

		public void setRange(int range)
			{
				this.range = range;
			}

		public int getAmmo()
			{
				return ammo;
			}

		public void setAmmo(int ammo)
			{
				this.ammo = ammo;
			}

		public boolean isEquiped()
			{
				return equiped;
			}

		public void setEquiped(boolean equiped)
			{
				this.equiped = equiped;
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
				return "RangedWeapon [range=" + range + ", ammo=" + ammo + ", damage=" + damage + ", equiped=" + equiped
						+ ", name=" + name + ", hitPoints=" + hitPoints + ", damageType=" + damageType + ", getRange()="
						+ getRange() + ", getAmmo()=" + getAmmo() + ", isEquiped()=" + isEquiped() + ", getDamage()="
						+ getDamage() + ", getName()=" + getName() + ", getHitPoints()=" + getHitPoints()
						+ ", getDamageType()=" + getDamageType() + ", getClass()=" + getClass() + ", hashCode()="
						+ hashCode() + ", toString()=" + super.toString() + "]";
			}
		
		

	}
