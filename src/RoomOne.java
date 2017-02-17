import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RoomOne
	{
		static Scanner user1nput = new Scanner(System.in);
		static ArrayList<Item> items = Runner.items;
		static ArrayList<Monster> monsters = Runner.monsters;
		static String thing;
		static int answer;
		static Vector<Location> map;
		static Location currentLocation;
		static JFrame frame = new JFrame();
		static boolean chest;
		static void roomOneEncounter() throws FileNotFoundException
		{
			Runner.setItems();
			Runner.setMonsters();
			ImageIcon icon = new ImageIcon(("tavern.jpg"));
			ImageIcon icon1 = new ImageIcon(("goods.jpg"));
			ImageIcon icon2 = new ImageIcon(("tavernOwner.jpg"));
			ImageIcon icon3 = new ImageIcon(("bard.jpg"));
			ImageIcon icon4 = new ImageIcon(("merchant.jpg"));
			Object[] person ={"Merchant", "bard", "Tavern Owner"};
			answer = JOptionPane.showOptionDialog(frame,"You see a few people: a merchant, a bard, and the owner of the tavern. Who would you like to talk to?",
				"talk",
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			icon, person, person [0]);
			switch(answer)
			{
				case 0:
						{
							Object[] yesNo ={"yes", "no"};
							answer = JOptionPane.showOptionDialog(frame,"hey would you like to check out my items?",
									"talk",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							icon4, yesNo, yesNo [0]);
							switch(answer)
							{
								case 0:
										{
											if(Runner.p.getMoney()<1)
												{
													JOptionPane.showMessageDialog(frame,"to bad you dont have enough gold.");
													Runner.playGame();
													break;
												}
											else
												{
													JOptionPane.showMessageDialog(frame,"Great! what would you like to buy?",
															thing, answer, icon1);
													for (int i =0; i<items.size(); i++)
														{
															System.out.println(items.get(i));
														}
													
												}
										}
								case 1:
										{
											if(Runner.p.getMoney()>0)
												{
													JOptionPane.showMessageDialog(frame, "good because I can see that you do not have enough gold.");
													Runner.playGame();
													break;
												}
											else
												{
													JOptionPane.showMessageDialog(frame,"well let me know if you change your mind");
													Runner.playGame();
													break;
												}
										}
							}
						}
				case 1:
						{
							JOptionPane.showMessageDialog(frame,"shhh... im playing a song. Talk to the tavern owner she will get you an adventure.",
									thing, answer, icon3);
							Runner.playGame();
						}
				case 2:
						{
							Object[] yesNo ={"yes", "no"};
							answer = JOptionPane.showOptionDialog(frame,"hey can you help me with this rat infestation in the wine cellar.",
									"talk",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							icon2, yesNo, yesNo [0]);
							switch(answer)
							{
								case 0:
										{
											JOptionPane.showMessageDialog(frame,"Great!");
											JOptionPane.showMessageDialog(frame,"there are some suplize in the back celler that might help");
											Runner.playGameTwo();
											break;
										}
								case 1:
										{
											JOptionPane.showMessageDialog(frame,"you dont really have a choice you dont have enough money to pay for your week long stay at my Tavern");
											JOptionPane.showMessageDialog(frame,"do this for me and I will consider your debt payed.");
											JOptionPane.showMessageDialog(frame,"there is some suplize in the back celler that might help");
											break;
										}
							}

						}
			}
		}		
	}
