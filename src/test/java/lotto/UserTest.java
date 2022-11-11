package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {
	@Test
	void 천원_단위로_안들어오면_exception()
	{
		assertThatThrownBy(() -> new User("2100"))
			.isInstanceOf(IllegalArgumentException.class);
	}
	@Test
	void 팔천원으로_로또8개_사기()
	{
		User user = new User("8000");
		user.buyLotto();
		int size = user.getMyLotto().size();
		assertEquals(size, 8);
	}
}
