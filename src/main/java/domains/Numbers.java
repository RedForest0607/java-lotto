package domains;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.LottoWrongInputException;

public class Numbers {

	private Set<Number> numbers;

	public Numbers(List<Integer> numbers) {
		this.numbers = new HashSet<>();

		for(Integer num: numbers) {
			this.numbers.add(new Number(num));
		}

		validDuplication(numbers);
	}

	private void validDuplication(List<Integer> numbers) {
		if(this.numbers.size() != numbers.size()) {
			throw new LottoWrongInputException("Test");
		}
	}

	public int match(Numbers compareNumbers) {
		return (int)numbers.stream()
			.filter(compareNumbers::isContainNumber)
			.count();
	}

	private boolean isContainNumber(Number number) {
		return numbers.contains(number);
	}
}
