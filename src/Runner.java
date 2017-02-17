import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Runner
	{
		static Scanner user1nput = new Scanner(System.in);
		static ArrayList<Item> items = new ArrayList<Item>();;
		static String thing;
		static int answer;
		static Player p = new Player ("", "", 0, 0, 0, 0, 0, 0, 0, 0, 0);
		static Monster m = new Monster ("", 0, 0, 0, 0, "", 0);
		static Vector<Location> map;
		static ArrayList<Monster> monsters = new ArrayList<Monster>();;
		static Location currentLocation;
		static JFrame frame = new JFrame();
		static boolean chest;
		public static void main(String[] args) throws FileNotFoundException
			{
				
				setItems();
				setMonsters();
				characterCreate();
				makeMap();
				playGame();
			}
		static void playGame() throws FileNotFoundException
		{
			while(true)
				{
					if(p.getLevel()==1)
						{
							p.setXpMax(p.getLevel() * 100);
						}
					JOptionPane.showMessageDialog(frame,"Your current health is " + p.getHitPoints());
					JOptionPane.showMessageDialog(frame,"You are level " + p.getLevel());
					JOptionPane.showMessageDialog(frame,"You are in " + currentLocation.getTitle());
					JOptionPane.showMessageDialog(frame,currentLocation.getDescription());
				if(currentLocation.getTitle().equals ("a large Arena"))
					{
						ArenaFight.startFight();
					}
				
				if(currentLocation.getTitle().equals ("a Tavern called the Bard's Trousers."))
					{
						RoomOne.roomOneEncounter();
					}
				if(currentLocation.getTitle().equals ("the Wine Cellar."))
					{
						RoomTwo.roomTwoEncounter();
					}
				if(currentLocation.getTitle().equals ("a large tunnle."))
					{
						RoomTwo.roomTwoEncounter();
					}
				if(currentLocation.getTitle().equals ("a Large room."))
					{
						RoomTwo.roomTwoEncounter();
					}
				if(currentLocation.getTitle().equals ("a very large room that looks like a corridor of a Dungeon."))
					{
						RoomTwo.roomTwoEncounter();
					}
				}
		}
		static void playGameTwo() throws FileNotFoundException
		{
				//Object [] placesToGo = {"north", "east", "south", "West"};
				Object [] placesToGo = new Object[currentLocation.getExits().size()];
				int i = 0;
				for(Exit exit : currentLocation.getExits())
					{
						placesToGo[i] = exit.getDirection();
						i++;
					}

				answer = JOptionPane.showOptionDialog(frame,"Which direction would you like to go",
				 		"Direction Choice",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, placesToGo, placesToGo[0]);
				
				currentLocation = currentLocation.getExits().get(answer).getLeadsTo();
				playGame();
		}
		static void setItems() throws FileNotFoundException
			{
				Scanner file = new Scanner(new File("MeleeWeapons.txt"));
				while (file.hasNext()) 
					{
						String[] data = file.nextLine().split(",");
						if(data.length > 5)
							{
								items.add(new RangedWeapon(data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5])));
							}
						else if(data.length <= 3)
							{
								items.add(new Armor(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2])));
							}
						else
							{
								items.add(new MeleeWeapon(data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3])));
							}

					}
			}
		static void setMonsters() throws FileNotFoundException
		{
			Scanner file = new Scanner(new File("Monsters.txt"));
			while (file.hasNext()) 
				{
					String[] data = file.nextLine().split(",");
					monsters.add(new Monster(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), data[5], Integer.parseInt(data[6])));
				}
		}
		private static void characterCreate()
			{
				ImageIcon icon = new ImageIcon(("dungeonLandscape.jpg"));
				ImageIcon icon1 = new ImageIcon(("fighter.jpg"));
				ImageIcon icon2 = new ImageIcon(("ranger.jpg"));
				ImageIcon icon3 = new ImageIcon(("barbarion.jpg"));
				ImageIcon icon6 = new ImageIcon(("12 sided die.jpg"));
				JOptionPane.showMessageDialog(frame,"Welcome! I hope your ready to enter into the amazing world of fantasy!",
					thing, JOptionPane.QUESTION_MESSAGE,
					icon);
				JOptionPane.showMessageDialog(frame,"First of all you need to choose your Characters name so..."); 
				thing = JOptionPane.showInputDialog("What is your name?");
				JOptionPane.showMessageDialog(frame, "Welcome, " + thing);
				p.setName(thing);
				JOptionPane.showMessageDialog(frame,"Now you much choose a class");
				Object[] classChoices ={"Fighter", "Ranger", "Barbarian"};
				answer = JOptionPane.showOptionDialog(frame,"which class would you like to be.",
				"class",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				icon, classChoices, classChoices [2]);
				switch(answer)
				{
					case 0:
							{
								JOptionPane.showMessageDialog(frame,"you are a Fighter. you gain proficincy in all armor",
								thing, JOptionPane.QUESTION_MESSAGE,
								icon1);
								Object[] roll ={"roll"};
								answer = JOptionPane.showOptionDialog(frame,"now you must roll for your Health",
								"class",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								icon6, roll, roll[0]);
								int num = (int) (Math.random() * 12) + 1;
								JOptionPane.showMessageDialog(frame,"you rolled a " + num + " but because you are a fighter you get + 7 added to that for your health.");
								num = num + 7;
								p.setHitPoints(num);
								p.setHitPointMax(num);
								p.setLevel(1);
								p.setRangedProf(0);
								p.setMeleeProf(0);
								p.setArmorProf(2);
								p.setClas("Fighter");
								break;
							}
					case 1:
							{
								JOptionPane.showMessageDialog(frame,"you are a Ranger you gain proficiency in all ranged weapons",
								thing, JOptionPane.QUESTION_MESSAGE,
								icon2);
								Object[] roll ={"roll"};
								answer = JOptionPane.showOptionDialog(frame,"now you must roll for your Health",
								"class",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								icon6, roll, roll[0]);
								int num = (int) (Math.random() * 12) + 1;
								JOptionPane.showMessageDialog(frame,"you rolled a " + num + " but because you are a ranger you get + 5 added to that for your health.");
								num = num + 5;
								p.setHitPoints(num);
								p.setHitPointMax(num);
								p.setLevel(1);
								p.setRangedProf(2);
								p.setMeleeProf(0);
								p.setArmorProf(0);
								p.setClas("Ranger");
								break;
							}
					case 2:
							{
								JOptionPane.showMessageDialog(frame,"you are a Barbarian you gain proficency in all Melee Weapons",
								thing, JOptionPane.QUESTION_MESSAGE,
								icon3);
								Object[] roll ={"roll"};
								answer = JOptionPane.showOptionDialog(frame,"now you must roll for your Health",
								"class",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								icon6, roll, roll[0]);
								int num = (int) (Math.random() * 12) + 1;
								JOptionPane.showMessageDialog(frame,"you rolled a " + num + " but because you are a ranger you get + 9 added to that for your health.");
								num = num + 9;
								p.setHitPoints(num);
								p.setHitPointMax(num);
								p.setLevel(1);
								p.setRangedProf(0);
								p.setMeleeProf(2);
								p.setArmorProf(0);
								p.setClas("Barbarian");
								break;
							}
				}
			}
		private static void makeMap()
		{
			map = new Vector<Location>(5);
			Location location1 = new Location("a Tavern called the Bard's Trousers.","there is a door to a wine Cellar in the back of the building, to the east.");
			Location location2 = new Location("the Wine Cellar.","the room is full of berrals and bottles on shelves. you see a whole in the floor behind one of the shelves, to the north.");
			Location location3 = new Location("a large tunnle.","You see that the tunnel forks twords the end and opens up into Two larger rooms, to the south and east.");
			Location location4 = new Location("a Large room.","you see no exit except the way you came from, to the west.");
			Location location5 = new Location("a very large room that looks like a corridor of a Dungeon.","You see doors to the north and west.");
			Location location6 = new Location("a large Arena","there is one exit that goes back to the Bard's Trousers.");

			map.addElement(location1);
			map.addElement(location2);
			map.addElement(location3);
			map.addElement(location4);
			map.addElement(location5);
			map.addElement(location6);
			
			// This section defines the exits found in each location and the 
			// locations to which they lead.
			location1.addExit(new Exit(Exit.east, location2));
			location2.addExit(new Exit(Exit.west, location1));
			location2.addExit(new Exit(Exit.north, location3));
			location2.addExit(new Exit(Exit.arena, location6));
			location3.addExit(new Exit(Exit.south, location2));
			location3.addExit(new Exit(Exit.east, location4));
			location3.addExit(new Exit(Exit.north, location5));
			location3.addExit(new Exit(Exit.arena, location6));
			location4.addExit(new Exit(Exit.west, location3));
			location4.addExit(new Exit(Exit.arena, location6));
			location5.addExit(new Exit(Exit.south, location3));
			location5.addExit(new Exit(Exit.arena, location6));
			location6.addExit(new Exit(Exit.arena, location1));
			
			currentLocation = location1;	
		}
		static void levelUp()
			{
				ImageIcon icon = new ImageIcon(("dungeonLandscape.jpg"));
				p.setXpTotal(p.getXpTotal() + m.getXpToEarn());
				if(p.getXpMax() <= p.getXpTotal())
					{
						JOptionPane.showMessageDialog(frame,"You leveled up! you are now level " + p.getLevel());
						p.setXpMax(p.getLevel() * 100);
						p.setXpTotal(p.getXpTotal() - p.getXpMax());
						p.setLevel(2);
						int num = (int) (Math.random() * 8) + 1;
						p.setHitPointMax(p.getHitPointMax() + num);
						p.setHitPoints(p.getHitPointMax());
						Object[] profIncrease ={"Melee", "Ranged", "Armor"};
						answer = JOptionPane.showOptionDialog(frame,"what Proficency Bonas would you like to increase?",
								"talk",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						icon, profIncrease, profIncrease [0]);
						switch(answer)
						{
							case 0:
									{
										p.setMeleeProf(p.getMeleeProf() + 1);
										JOptionPane.showMessageDialog(frame,"you have increased your melee weapon proficency. it is now + " + p.getLevel());
									}
							case 1:
									{
										p.setMeleeProf(p.getRangedProf() + 1);
										JOptionPane.showMessageDialog(frame,"you have increased your ranged weapon proficency. it is now + " + p.getLevel());
									}
							case 2:
									{
										p.setMeleeProf(p.getArmorProf() + 1);
										JOptionPane.showMessageDialog(frame,"you have increased your armor proficency. it is now + " + p.getLevel());
									}
						}
					}
				else
					{
						int water = p.getXpTotal() - p.getXpMax();
						JOptionPane.showMessageDialog(frame,"you will level up once you gain " + water + " experience points.");
					}
			}

	}
