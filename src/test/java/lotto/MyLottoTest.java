package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class MyLottoTest {
	@Test
	void 번호가_7개인경우_에러발생() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}
	@Test
	void 번호가_5개인경우_에러발생() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}
	@Test
	void 같은번호가_있는경우_에러발생() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}
	@Test
	void 범위밖번호가_있는경우_에러발생() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 500)))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
