package domains;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

	private List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	// 로또들을 winningLotto와 비교
	public List<WinningPrize> getResult(Lotto winningLotto) {
		return lottos.stream().map(lotto -> lotto.getWinningPrize(winningLotto)).collect(Collectors.toList());
	}
}
