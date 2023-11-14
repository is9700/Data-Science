package data;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Schmuck  {
	 @Id
	 @Column(name="productnummer", nullable = false)
	private long produktNummer;
	 private int price;

	 public Schmuck( int price,long produktNummer ) {
	        this.price = price;
	        this.produktNummer= produktNummer;
	    }

	public Schmuck() {

	}

	public int  getprice() {
			return price ;
		}
	
		public void setprice(int price) {
			this.price = price;
		}
		
		
		public long  getproduktNummer() {
			return produktNummer ;
		}
	
		public void setproduktNummer(long produktNummer) {
			this.produktNummer = produktNummer;
		}

	@Override
	public String toString() {
		return "produktNummer=" + produktNummer +
				", price=" + price;
	}
}
