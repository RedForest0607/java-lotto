package domains;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import exceptions.LottoWrongInputException;
import utils.LottoUtil;

public class NumberTest {
	@ParameterizedTest
	@DisplayName("로또 번호의 입력 범위가 1~45까지가 맞는지 검증")
	@ValueSource(ints = {-1 ,47, 100})
	void 로또_번호의_입력_범위가_1_에서_45_까지가_맞는지_검증한다 (int num) {
		assertThatThrownBy(() -> new Number(num))
			.isInstanceOf(LottoWrongInputException.class);
	}
}
