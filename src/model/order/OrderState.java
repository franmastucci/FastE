package model.order;

enum OrderState implements State {
	
	PENDING("Pendiente") {
		
		@Override
		public void getPrepare(Order anOrder) {
			anOrder.updateLastModify();
			anOrder.setState(OrderState.PREPARED);
		}
		
		@Override
		public void getCancel(Order anOrder) {
			anOrder.updateLastModify();
			anOrder.setState(OrderState.CANCEL);
		}
		
	}, 
	
	PREPARED("Preparado"){
		
		@Override
		public void getArrive(Order anOrder) {
			anOrder.updateLastModify();
			anOrder.setState(OrderState.ARRIVED);
		}
	}
	
	, ARRIVED("Entregado"), CANCEL("Cancelado");
	
	public void getPrepare(Order anOrder) {
		String CANT_BE_PREPARED = "La orden no puede ser preparada porque esta en estado " + this.getName();
		new RuntimeException(CANT_BE_PREPARED);
	}
	
	public void getCancel(Order anOrder) {
		String CANT_BE_CANCEL = "La orden no puede ser entregada porque esta en estado " + this.getName();
		new RuntimeException(CANT_BE_CANCEL);
	}
	
	public void getArrive(Order anOrder) {
		String CANT_BE_ARRIVE = "La orden no puede ser cancelada porque esta en estado " + this.getName();
		new RuntimeException(CANT_BE_ARRIVE );
	}

	private String name;
	
	private OrderState(String aName){
		this.name = aName;
	}
	
	public String getName() {
		return this.name;
	}
}


