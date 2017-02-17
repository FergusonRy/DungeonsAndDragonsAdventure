

public class Monster
	{
	private String name;
	private int hitPointsOfMonster;
	private int damage;
	private int xpToEarn;
	private int ArmorClass;
	private String weakness;
	private int mLevel;
	
	public Monster (String n, int hp, int d, int xp, int ac, String w, int ml)
		{
		name = n;
		hitPointsOfMonster = hp;
		damage = d;
		xpToEarn = xp;
		ArmorClass = ac;
		weakness = w;
		mLevel = ml;
		}
	public String getName()
		{
		return name;
		}
	public void setName(String n)
		{
		name = n;
		}
	public int getHitPointsOfMonster()
		{
		return hitPointsOfMonster;
		}
	public void setHitPointsOfMonster(int hp)
		{
		hitPointsOfMonster = hp; 
		}
	public int getDamage()
		{
			return damage;
		}
	public void setDamage(int damage)
		{
			this.damage = damage;
		}
	public int getXpToEarn()
		{
			return xpToEarn;
		}
	public void setXpToEarn(int xpToEarn)
		{
			this.xpToEarn = xpToEarn;
		}
	public int getArmorClass()
		{
			return ArmorClass;
		}
	public void setArmorClass(int armorClass)
		{
			ArmorClass = armorClass;
		}
	public String getWeakness()
		{
			return weakness;
		}
	public void setWeakness(String weakness)
		{
			this.weakness = weakness;
		}
	public int getmLevel()
		{
			return mLevel;
		}
	public void setmLevel(int mLevel)
		{
			this.mLevel = mLevel;
		}
	@Override
	public String toString()
		{
			return "Monster [name=" + name + ", hitPointsOfMonster=" + hitPointsOfMonster + ", damage=" + damage
					+ ", xpToEarn=" + xpToEarn + ", ArmorClass=" + ArmorClass + ", getName()=" + getName()
					+ ", getHitPointsOfMonster()=" + getHitPointsOfMonster() + ", getDamage()=" + getDamage()
					+ ", getXpToEarn()=" + getXpToEarn() + ", getArmorClass()=" + getArmorClass() + ", getClass()="
					+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
	
	
	}