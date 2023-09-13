package domains;

import java.util.stream.Stream;

import lombok.Getter;

@Getter
public enum WinningPrize {
	FIRST(2_000_000_000, 6),
	SECOND(1_500_000, 5),
	THIRD(50_000, 4),
	FOURTH(5_000, 3),
	NONE(0, 0),
	;

	private final int prize;
	private final int winningCount;

	WinningPrize(int prize, int winningCount) {
		this.prize = prize;
		this.winningCount = winningCount;
	}

	public static WinningPrize matchPrizeResult(int matchCount) {
		return Stream.of(values())
			.filter(it -> it.winningCount == matchCount)
			.findFirst()
			.orElse(NONE);
	}

	public WinningPrize getWinningPrize() {
		return this;
	}
}
