package domain.phase;

import domain.PhaseResult;

import java.util.Arrays;
import java.util.List;

public class NormalFramePhaseCollection implements PhaseCollection {

	private static final int START_INDEX = 0;
	private static final int MAX_INDEX = 1;

	private final List<Phase> phaseList;
	private int currentPhaseIndex;

	public NormalFramePhaseCollection() {
		this.phaseList = Arrays.asList(Phase.FIRST_PHASE, Phase.SECOND_PHASE);
		this.currentPhaseIndex = START_INDEX;
	}

	@Override
	public PhaseResult getFrameResult(int remainBowlingPins) {
		if (currentPhaseIndex > MAX_INDEX) {
			throw new IllegalStateException("두 번째 페이즈까지 모두 종료되었습니다");
		}

		return phaseList.get(currentPhaseIndex++).getFrameResult(remainBowlingPins);
	}

	@Override
	public void addThirdPhase() {
		throw new UnsupportedOperationException("1 ~ 9번 프레임에서는 세 번째 페이즈가 없습니다");
	}

}
