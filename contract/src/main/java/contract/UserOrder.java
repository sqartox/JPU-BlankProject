package contract;

public class UserOrder {
	private final int player;
	private final Order order;

	public UserOrder(final int player, final Order order) {
		this.player = player;
		this.order = order;
	}

	public int getPlayer() {
		return this.player;
	}

	public Order getOrder() {
		return this.order;
	}
}
