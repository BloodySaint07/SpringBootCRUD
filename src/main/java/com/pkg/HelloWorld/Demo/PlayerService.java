package com.pkg.HelloWorld.Demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PlayerService {

	private static List<PlayerInfo> playerlist = new ArrayList<>();
	private static int playercount = 3;
	private String ErrMsg;

	static {
		playerlist.add(new PlayerInfo(1, "Jadon Sancho", "FWD", "MANU"));
		playerlist.add(new PlayerInfo(2, "Jorginhoo", "MID", "CHEL"));
		playerlist.add(new PlayerInfo(3, "VVD", "DEF", "LIV"));
		playerlist.add(new PlayerInfo(4, "Sadio Mane", "FWD", "LIV"));

	}

	public List<PlayerInfo> findall() {

		return playerlist;
	}

	public PlayerInfo save(PlayerInfo player1) {

		if (player1.getPid() == null) {

			playerlist.add(player1);
		}

		System.out.println("Added Player " + player1.getName() + " " + player1.getPid());
		return player1;
	}

	public PlayerInfo findPlayer(int playerid) throws UserNotFoundException {

		for (PlayerInfo info : playerlist) {

			if (info.getPid() == playerid) {

				System.out.println("Found Player " + info.getPid() + " " + info.getName());

				return info;
			}
//			else if (info.getPid()!=playerid)
//			{
//				System.out.println("No Player Found");
//				
//			}

		}
		ErrMsg = "No Player Found with id " + Integer.toString(playerid);

		//System.out.println("No Player Found with id " + playerid);

		throw new UserNotFoundException(ErrMsg);
	}

}
