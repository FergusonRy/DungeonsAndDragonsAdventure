import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ArenaFight
	{
		static Scanner user1nput = new Scanner(System.in);
		static ArrayList<Item> items = Runner.items;
		static ArrayList<Monster> monsters = Runner.monsters;
		static String thing;
		static int answer;
		static Location currentLocation;
		static int temporaryAC = 0;
		static JFrame frame = new JFrame();
		static boolean chest;
		static boolean playerTurn =false;
		static ImageIcon icon = new ImageIcon(("giantRats.jpg"));
		static ImageIcon icon1 = new ImageIcon(("goblin.jpg"));
		static ImageIcon icon2 = new ImageIcon(("orc.Twojpg"));
		static ImageIcon icon3 = new ImageIcon(("Thief.jpg"));
		static ImageIcon icon4 = new ImageIcon(("skeleton.jpg"));
		static ImageIcon icon5 = new ImageIcon(("zombie.jpg"));
		static ImageIcon icon6 = new ImageIcon(("20 sided die.gif"));
		static ImageIcon icon7 = new ImageIcon(("arena.jpg"));
		static ImageIcon icon8 = new ImageIcon(("hugeRat.jpg"));
		static ImageIcon icon9 = new ImageIcon(("Ogre.jpg"));
		static ImageIcon icon10 = new ImageIcon(("ThievesCultLeader.Twojpg"));
		static ImageIcon icon11 = new ImageIcon(("BlueDragon.jpg"));
		
		static void startFight() throws FileNotFoundException
		{
			JOptionPane.showMessageDialog(frame,"hello this is a basic way for you to level up with no consequences!");
			Object[] yesNo ={"yes", "no"};
			answer = JOptionPane.showOptionDialog(frame,"you are in an arena would you like to fight an Oponent.",
					"talk",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			icon7, yesNo, yesNo [0]);
			switch(answer)
			{
				case 0:
						{
							Runner.setItems();
							Runner.setMonsters();
							fightOponent();
						}
				case 1:
						{
							Runner.playGameTwo();
						}
			}
		}
		static void fightBoss() throws FileNotFoundException
			{
				int num = (int)(Math.random()*4) +6;
				String nameOfMonster = monsters.get(num).getName();
				if(nameOfMonster.equals("Mama Rat"))
					{
						JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
								nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
								icon8);
						Runner.m = monsters.get(num);
					}
				if(nameOfMonster.equals("Thieves Cult Leader"))
					{
						JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
								nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
								icon9);
						Runner.m = monsters.get(num);
					}
				if(nameOfMonster.equals("Ogre"))
					{
						JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
								nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
								icon10);
						Runner.m = monsters.get(num);
					}
				if(nameOfMonster.equals("Baby Dragon"))
					{
						JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
								nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
								icon11);
						Runner.m = monsters.get(num);
					}
			}
		static void fightOponent() throws FileNotFoundException
		{	
			int num = (int)(Math.random()*5) +1;
			String nameOfMonster = monsters.get(num).getName();
			if(nameOfMonster.equals("Orc"))
				{
					JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
							nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
							icon2);
					Runner.m = monsters.get(0);
					battle();
				}
			if(nameOfMonster.equals("goblin"))
				{
					JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
							nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
							icon1);
					Runner.m = monsters.get(1);
					battle();
				}
			if(nameOfMonster.equals("Giant Rat"))
				{
					JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
							nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
							icon);
					Runner.m = monsters.get(2);
					battle();
				}
			if(nameOfMonster.equals("Skeleton Warrior"))
				{
					JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
							nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
							icon5);
					Runner.m = monsters.get(3);
					battle();
				}
			if(nameOfMonster.equals("Zombie"))
				{
					JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
							nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
							icon5);
					Runner.m = monsters.get(4);
					battle();
				}
			if(nameOfMonster.equals("Thieves Cult Member"))
				{
					JOptionPane.showMessageDialog(frame,"you will fight against a " + nameOfMonster,
							nameOfMonster, JOptionPane.INFORMATION_MESSAGE,
							icon3);
					Runner.m = monsters.get(5);
					battle();
				}
			System.out.println(Runner.m);
		}
		static void battle() throws FileNotFoundException
		{	
			Object[] roll ={"roll"};
			answer = JOptionPane.showOptionDialog(frame,"ROLL FOR INITIATIVE",
			"Initiative",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			icon6, roll, roll[0]);
			int playerRole = (int) (Math.random() * 20) + 5;
			int monsterRole=  (int) (Math.random() * 20) + 1;
			if(playerRole>monsterRole)
				{
					JOptionPane.showMessageDialog(frame,"you rolled a " + playerRole + " you get to attack first!");
					playerTurn = true;
				}
			boolean fight = true;
			
			while(fight)
				{
					if(playerTurn ==true)
						{
							Object[] yesNo ={"attack with melee weapon", "attack with ranged weapon", "defensive posture", "flee"};
							answer = JOptionPane.showOptionDialog(frame,"do you want to attack!",
									"Attack",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							icon7, yesNo, yesNo [0]);
							switch(answer)
							{
								case 0:
										{
											answer = JOptionPane.showOptionDialog(frame,"Roll to hit!",
													"Initiative",
													JOptionPane.YES_NO_CANCEL_OPTION,
													JOptionPane.QUESTION_MESSAGE,
													icon6, roll, roll[0]);
											int playerRoleToHit = (int) (Math.random() * 20) + 6;
											playerRoleToHit = playerRoleToHit + Runner.p.getMeleeProf();
											System.out.println(playerRoleToHit);
											if (Runner.p.getMeleeWeapon().getDamageType().equals(Runner.m.getWeakness()))
												{
													if ( Runner.m.getArmorClass() < playerRoleToHit)
														{
															JOptionPane.showMessageDialog(frame,"you rolled a " + playerRoleToHit + " you hit!");
															int dm1 =(int) (Math.random() * Runner.p.getMeleeWeapon().getDamage())+2 + Runner.p.getMeleeProf() + 2;
															Runner.m.setHitPointsOfMonster(Runner.m.getHitPointsOfMonster() - dm1);
															JOptionPane.showMessageDialog(frame,"you did " + dm1 + " damage");
															if(Runner.m.getHitPointsOfMonster() <= 0)
																{
																	JOptionPane.showMessageDialog(frame,"you killed the " + Runner.m.getName());
																	Runner.levelUp();
																	fight = false;
																}
															else
																{
																	playerTurn = false;
																}
														}
													else
														{
															JOptionPane.showMessageDialog(frame,"you rolled a " + playerRoleToHit + " you missed");
															playerTurn = false;
														}
													break;
												}
											else
												{
													if ( Runner.m.getArmorClass() < playerRoleToHit)
														{
															JOptionPane.showMessageDialog(frame,"you rolled a " + playerRoleToHit + " you hit!");
															int dm1 =(int) (Math.random() * Runner.p.getMeleeWeapon().getDamage())+2 + Runner.p.getMeleeProf();
															Runner.m.setHitPointsOfMonster(Runner.m.getHitPointsOfMonster() - dm1);
															JOptionPane.showMessageDialog(frame,"you did " + dm1 + " damage");
															if(Runner.m.getHitPointsOfMonster() <= 0)
																{
																	JOptionPane.showMessageDialog(frame,"you killed the " + Runner.m.getName());
																	Runner.levelUp();
																	fight = false;
																}
															else
																{
																	playerTurn = false;
																}
														}
													else
														{
															JOptionPane.showMessageDialog(frame,"you rolled a " + playerRoleToHit + " you missed");
															playerTurn = false;
														}
													break;
												}
										}
								case 1:
										{
											answer = JOptionPane.showOptionDialog(frame,"Roll to hit!",
													"Initiative",
													JOptionPane.YES_NO_CANCEL_OPTION,
													JOptionPane.QUESTION_MESSAGE,
													icon6, roll, roll[0]);
											int playerRoleToHit = (int) (Math.random() * 20) + 6;
											playerRoleToHit = playerRoleToHit + Runner.p.getRangedProf();
											System.out.println(playerRoleToHit);
											if (Runner.p.getMeleeWeapon().getDamageType().equals(Runner.m.getWeakness()))
												{
													if (playerRoleToHit >= Runner.m.getArmorClass())
														{
															JOptionPane.showMessageDialog(frame,"you rolled a " + playerRoleToHit + " you hit!");
															int dm2 =(int) (Math.random() * Runner.p.getRangedWeapon().getDamage())+2 + Runner.p.getRangedProf() + 2;
															Runner.m.setHitPointsOfMonster(Runner.m.getHitPointsOfMonster()-dm2);
															JOptionPane.showMessageDialog(frame,"you did " + dm2 + "damage");
															playerTurn = false;
															if(Runner.m.getHitPointsOfMonster() < 0)
																{
																	JOptionPane.showMessageDialog(frame,"you killed the " + Runner.m.getName());
																	fight = false;
																}
															else
																{
																	playerTurn = false;
																}
														}
													else
														{
															JOptionPane.showMessageDialog(frame,"you rolled a " + playerRoleToHit + " you missed");
															playerTurn =false;
														}
													break;
												}
											else
												{
													if (playerRoleToHit >= Runner.m.getArmorClass())
														{
															JOptionPane.showMessageDialog(frame,"you rolled a " + playerRoleToHit + " you hit!");
															int dm2 =(int) (Math.random() * Runner.p.getRangedWeapon().getDamage())+2 + Runner.p.getRangedProf();
															Runner.m.setHitPointsOfMonster(Runner.m.getHitPointsOfMonster()-dm2);
															JOptionPane.showMessageDialog(frame,"you did " + dm2 + "damage");
															playerTurn = false;
															if(Runner.m.getHitPointsOfMonster() < 0)
																{
																	JOptionPane.showMessageDialog(frame,"you killed the " + Runner.m.getName());
																	fight = false;
																}
															else
																{
																	playerTurn = false;
																}
														}
													else
														{
															JOptionPane.showMessageDialog(frame,"you rolled a " + playerRoleToHit + " you missed");
															playerTurn =false;
														}
													break;
												}
										}
								case 2:
										{
											temporaryAC = temporaryAC + Runner.p.getLevel()*2;
											JOptionPane.showMessageDialog(frame,"you take a defensive posture and gain plus " + temporaryAC + " to your Armor class! this is temporary!");
											playerTurn = false;
											break;
										}
								case 3:
										{
											JOptionPane.showMessageDialog(frame,"you attempt to flee!");
											int fleeChance = (int) (Math.random() * 20) + 1;
											if(fleeChance> 18)
												{
													JOptionPane.showMessageDialog(frame,"you succeed");
													Runner.playGameTwo();
												}
											else
												{
													JOptionPane.showMessageDialog(frame,"you failed to flee and forfit your turn!");
													playerTurn = false;
												}
											break;
										}
							}
						}
					else
						{
							JOptionPane.showMessageDialog(frame,"the monster attacks you!");
							int monsterToHitRole=  (int) (Math.random() * 20) + 4;
							int md1 = Runner.p.getArmor().getArmorClass() + Runner.p.getArmorProf() + temporaryAC;
							System.out.println(monsterToHitRole +" "+ md1);
							if(monsterToHitRole>md1)
								{
									JOptionPane.showMessageDialog(frame,"the monster hit you!");
									int md2 = (int) (Math.random() * Runner.m.getDamage()) + 2;
									JOptionPane.showMessageDialog(frame,"you lost " + md2 + "health");
									Runner.p.setHitPoints(Runner.p.getHitPoints()-md2);
									if(Runner.p.getHitPoints() <= 0)
										{
											JOptionPane.showMessageDialog(frame,"you died");
											fight = false;
										}
									else
										{
											playerTurn = true;
										}
								}
							else
								{
									JOptionPane.showMessageDialog(frame,"the monster missed you!");
									playerTurn = true;
								}
						}
				}
			Object[] yesNo ={"yes", "no"};
			answer = JOptionPane.showOptionDialog(frame,"would you like to face another monster?",
					"talk",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			icon7, yesNo, yesNo [0]);
			switch(answer)
			{
				case 0:
						{
							if(Runner.p.getLevel() == 2)
								{
									Object[] ugh ={"yes", "no"};
									answer = JOptionPane.showOptionDialog(frame,"would you like to fight a Boss?",
											"talk",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									icon7, ugh, ugh [0]);
									switch (answer)
									{
										case 0:
												{
													fightBoss();
												}
									}
								}
							else
								{
									Runner.setItems();
									Runner.setMonsters();
									fightOponent();
								}
						}
				case 1:
						{
							Runner.playGameTwo();
						}
			}
		}

	}
