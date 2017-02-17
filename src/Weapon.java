
public abstract class Weapon extends Item
	{
		protected String name;
		protected int hitPoints;
		protected String damageType;

		public Weapon(String n, int hp, String dt) {
			name =n;
			hitPoints = hp;
			damageType = dt;
		}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public int getHitPoints()
			{
				return hitPoints;
			}

		public void setHitPoints(int hitPoints)
			{
				this.hitPoints = hitPoints;
			}

		public String getDamageType()
			{
				return damageType;
			}

		public void setDamageType(String damageType)
			{
				this.damageType = damageType;
			}

	}
