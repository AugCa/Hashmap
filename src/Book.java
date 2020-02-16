//August Carlsson auca4478
//Adan Anwar adan9862

/*
 * Denna klass ska förberedas för att kunna användas som nyckel i en hashtabell. 
 * Du får göra nödvändiga ändringar även i klasserna MyString och ISBN10.
 * 
 * Hashkoden ska räknas ut på ett effektivt sätt och följa de regler och 
 * rekommendationer som finns för hur en hashkod ska konstrueras. Notera i en 
 * kommentar i koden hur du har tänkt när du konstruerat din hashkod.
 */
public class Book{
	private MyString title;
	private MyString author;
	private ISBN10 isbn;
	private MyString content;
	private int price;


	public Book(String title, String author, String isbn, String content, int price) {
		this.title = new MyString(title);
		this.author = new MyString(author);
		this.isbn = new ISBN10(isbn);
		this.content = new MyString(content);
		this.price = price;
	}

	@Override
	public int hashCode(){
		//num är isbn nummer + längden på titeln.
		//Isbn nummer bör vara unikt för alla böcker, bortsett från när en ny upplaga av en bok kommer, då kanske den har samma ISBN men längre titel.
		int num = isbn.number() + (int) title.length();
		num += 31; //Primtal för att minska risk för kollision
		num %= 1000; //Modulo för att göra talen mindre och mer unika
		num += 17; //Samma som ovan
		num %= 100; //Samma som ovan
		return num;



	}


	@Override
	public boolean equals(Object obj)
	{
		return hashCode()==obj.hashCode();
	}



	public MyString getTitle() {
		return title;
	}

	public MyString getAuthor() {
		return author;
	}

	public ISBN10 getIsbn() {
		return isbn;
	}

	public MyString getContent() {
		return content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("\"%s\" by %s Price: %d ISBN: %s lenght: %s", title, author, price, isbn,
				content.length());
	}

}
