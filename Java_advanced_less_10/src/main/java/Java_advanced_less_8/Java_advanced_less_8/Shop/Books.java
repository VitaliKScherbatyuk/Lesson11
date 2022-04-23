package Java_advanced_less_8.Java_advanced_less_8.Shop;

public class Books {

	private int id;
	private String book;
	private String author;
	private String ganre;
	private double price;
	private int cod;

	public Books(int id, String book, String author, String ganre, double price, int cod) {
		super();
		this.id = id;
		this.book = book;
		this.author = author;
		this.ganre = ganre;
		this.price = price;
		this.cod = cod;
	}

	public Books(String book, String author, String ganre, double price, int cod) {
		super();
		this.book = book;
		this.author = author;
		this.ganre = ganre;
		this.price = price;
		this.cod = cod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGanre() {
		return ganre;
	}

	public void setGanre(String ganre) {
		this.ganre = ganre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + cod;
		result = prime * result + ((ganre == null) ? 0 : ganre.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (cod != other.cod)
			return false;
		if (ganre == null) {
			if (other.ganre != null)
				return false;
		} else if (!ganre.equals(other.ganre))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", book=" + book + ", author=" + author + ", ganre=" + ganre + ", price=" + price
				+ ", cod=" + cod + "]";
	}

}
