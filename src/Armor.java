
public class Armor extends Item
	{
		private String name;
		private int armorClass;
		private int hitPoints;
	
		public Armor(String n, int ac, int hp)
			{
				name = n;
				armorClass = ac;
				hitPoints = hp;
			}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public int getArmorClass()
			{
				return armorClass;
			}

		public void setArmorClass(int armorClass)
			{
				this.armorClass = armorClass;
			}

		public int getHitPoints()
			{
				return hitPoints;
			}

		public void setHitPoints(int hitPoints)
			{
				this.hitPoints = hitPoints;
			}

		@Override
		public String toString()
			{
				return "Armor [name=" + name + ", armorClass=" + armorClass + ", hitPoints=" + hitPoints
						+ ", getName()=" + getName() + ", getArmorClass()=" + getArmorClass() + ", getHitPoints()="
						+ getHitPoints() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
						+ super.toString() + "]";
			}
		
	}
