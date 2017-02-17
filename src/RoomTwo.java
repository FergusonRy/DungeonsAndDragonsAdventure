import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RoomTwo
	{
		static Scanner user1nput = new Scanner(System.in);
		static ArrayList<Item> items = Runner.items;
		static ArrayList<Monster> monsters = Runner.monsters;
		static String thing;
		static int answer;
		static MeleeWeapon mw = new MeleeWeapon ("", 0, "", 0);
		static RangedWeapon rw = new RangedWeapon ("", 0, "", 0, 0, 0);
		static Armor a = new Armor ("", 0, 0);
		static Vector<Location> map;
		static Location currentLocation;
		static JFrame frame = new JFrame();
		static boolean chest;
		static void roomTwoEncounter() throws FileNotFoundException
		{
			if(chest = true)
				{
					Runner.setItems();
					Runner.setMonsters();
					ImageIcon icon6 = new ImageIcon(("chest.jpg"));
					Object[] yesNo ={"yes", "no"};
					JOptionPane.showMessageDialog(frame,"There is a chest on the Floor and you decide to open it.");
					answer = JOptionPane.showOptionDialog(frame,"Do you open it?",
							"talk",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					icon6, yesNo, yesNo [0]);
					switch(answer)
					{
						case 0:
								{
									int num = (int) (Math.random() * 8) + 1;
									int num1 = (int) (Math.random() * 4) + 9;
									int num2 = (int) (Math.random() * 5) + 14;
									Runner.p.addInventory(items.get(num));
									Runner.p.addInventory(items.get(num1));
									Runner.p.addInventory(items.get(num2));
									for (Item it : Runner.p.getInventory()) 
										{
											JOptionPane.showMessageDialog(frame,"You have recieved " + it.getName());
											System.out.println(it);
										}
									JOptionPane.showMessageDialog(frame,"you have also recieved 50 gold pieces");
									Runner.p.setMoney(50);
									mw = (MeleeWeapon) items.get(num);
									rw = (RangedWeapon) items.get(num1);
									a = (Armor) items.get(num2);
									MeleeWeapon mww = new MeleeWeapon("Flame Tounge", 15, "piercing", 15);
									System.out.println(mww.getDamage());
									Runner.p.setMeleeWeapon(mw);
									Runner.p.setRangedWeapon(rw);
									Runner.p.setArmor(a);
									System.out.println(Runner.p.getMeleeWeapon().getDamage());
									//setEquipedItems();
									chest = false;
									Runner.playGameTwo();
									break;
								}
						case 1:
								{
									JOptionPane.showMessageDialog(frame,"Whelp... good luck surviving.");
									Runner.playGameTwo();
									break;
								}
					}
				}
		}

	}
