package view;

import domain.bowlling.BowlingOnBoard;
import domain.frame.result.FrameResult;

public class ResultView {

	private ResultView() {

	}

	public static void printCurrentScore(BowlingOnBoard bowlingOnBoards) {
		System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |   10     |");
		printFrameResults(bowlingOnBoards);
		System.out.println();
	}

	private static void printFrameResults(BowlingOnBoard bowlingOnBoards) {
		StringBuilder stringBuilder = new StringBuilder(String.format("|  %s |", bowlingOnBoards.getUserName()));
		for (FrameResult frameResult : bowlingOnBoards.getNormalFrameResults()) {
			stringBuilder.append(String.format("  %-3s |", getFrameResult(frameResult)));
		}
		stringBuilder.append(String.format("  %-5s  |", getFrameResult(bowlingOnBoards.getFinalFrameResult())));
		System.out.println(stringBuilder.toString());
	}

	private static String getFrameResult(FrameResult frameResult) {
		return String.join("|", frameResult.getPhaseResultSign());
	}

}
