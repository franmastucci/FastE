package model.price;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.provider.Product;
import model.provider.Provider;

class PriceRecordTest extends PriceTest {

	@BeforeEach
	public void setUp()  {
		 this.cocaCola = Provider.register(20000000001l,"coca-cola","Avenida Beiró", 20, 20);
		 this.coca = Product.publishProduct("Coca", cocaCola, 20f, 15.6f);
		 this.newPrice = CurrentPrice.settlePrice(30.0f, coca);
	}

	@Test
	void testAPriceCanNotBeNotNullToGenerateARecordPrice() {
		assertThrows(RuntimeException.class, ()-> PriceRecord.generateRecord(null));
	}

}
