import java.util.ArrayList;

public class Player {
	private String clas;
	private String name;
	private int money;
	private int hitPoints;
	private int hitPointMax;
	private ArrayList<Item> inventory;
	private Armor armor;
	private MeleeWeapon meleeWeapon;
	private RangedWeapon rangedWeapon;
	private int xpMax;
	private int xpTotal;
	private int level;
	private int meleeProf;
	private int rangedProf;
	private int armorProf;
	

	public Player(String c, String n, int hp, int hpm, int m, int xpm, int xpt, int l, int mp, int rp, int ap) 
		{
		clas = c;
		name = n;
		money = m;
		hitPoints = hp;
		hitPointMax = hpm;
		inventory = new ArrayList<Item>();
		xpMax = xpm;
		xpTotal = xpt;
		level = l;
		meleeProf = mp;
		rangedProf= rp;
		armorProf = ap;

	}

	public String getClas()
		{
			return clas;
		}

	public void setClas(String clas)
		{
			this.clas = clas;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void addInventory(Item I) {
		this.inventory.add(I);
	}

	public Armor getArmor()
		{
			return armor;
		}

	public void setArmor(Armor armor)
		{
			this.armor = armor;
		}

	public MeleeWeapon getMeleeWeapon()
		{
			return meleeWeapon;
		}

	public void setMeleeWeapon(MeleeWeapon meleeWeapon)
		{
			this.meleeWeapon = meleeWeapon;
		}

	public RangedWeapon getRangedWeapon()
		{
			return rangedWeapon;
		}

	public void setRangedWeapon(RangedWeapon rangedWeapon)
		{
			this.rangedWeapon = rangedWeapon;
		}

	public int getXpMax()
		{
			return xpMax;
		}

	public void setXpMax(int xpMax)
		{
			this.xpMax = xpMax;
		}

	public int getXpTotal()
		{
			return xpTotal;
		}

	public void setXpTotal(int xpTotal)
		{
			this.xpTotal = xpTotal;
		}

	public int getLevel()
		{
			return level;
		}

	public void setLevel(int level)
		{
			this.level = level;
		}

	public void setInventory(ArrayList<Item> inventory)
		{
			this.inventory = inventory;
		}

	public int getMeleeProf()
		{
			return meleeProf;
		}

	public void setMeleeProf(int meleeProf)
		{
			this.meleeProf = meleeProf;
		}

	public int getRangedProf()
		{
			return rangedProf;
		}

	public void setRangedProf(int rangedProf)
		{
			this.rangedProf = rangedProf;
		}

	public int getArmorProf()
		{
			return armorProf;
		}

	public void setArmorProf(int armorProf)
		{
			this.armorProf = armorProf;
		}

	public int getHitPointMax()
		{
			return hitPointMax;
		}

	public void setHitPointMax(int hitPointMax)
		{
			this.hitPointMax = hitPointMax;
		}
	

}