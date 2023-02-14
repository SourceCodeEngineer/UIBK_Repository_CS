public class Player {
	int wins; // # of wins
	int winTotal;

	/**
	 * Randomly choose rock, paper, or scissors
	 */
	public String playerChoice() {
		String choice = "";
		int c = (int) (Math.random() * 3);
		switch (c) {
		case 0:
			choice = ("rock");
			break;
		case 1:
			choice = ("paper");
			break;
		case 2:
			choice = ("scissors");
			break;
		}
		return choice;
	}

	public int setWins() {
		int winTotal = wins++;
		return winTotal;
	}

	public int getWins() {
		return (wins);
	}
}
