package Java_advanced_less_8.Java_advanced_less_8.Shop;

import java.util.Date;

public class Salling {

	private int id;
	private int user_id;
	private int book_id;
	private boolean salling_status;
	private Date salling_date;
	private int salling_period;

	public Salling(int id, int user_id, int book_id, boolean salling_status, Date sallingDate,
			int salling_period) {
		this.id = id;
		this.user_id = user_id;
		this.book_id = book_id;
		this.salling_status = salling_status;
		this.salling_date = sallingDate;
		this.salling_period = salling_period;
	}

	public Salling(int user_id, int book_id, boolean salling_status, Date salling_date, int salling_period) {
		this.user_id = user_id;
		this.book_id = book_id;
		this.salling_status = salling_status;
		this.salling_date = salling_date;
		this.salling_period = salling_period;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public boolean isSalling_status() {
		return salling_status;
	}

	public void setSalling_status(boolean salling_status) {
		this.salling_status = salling_status;
	}

	public Date getSalling_date() {
		return salling_date;
	}

	public void setSalling_date(Date salling_date) {
		this.salling_date = salling_date;
	}

	public int getSalling_period() {
		return salling_period;
	}

	public void setSalling_period(int salling_period) {
		this.salling_period = salling_period;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + book_id;
		result = prime * result + id;
		result = prime * result + ((salling_date == null) ? 0 : salling_date.hashCode());
		result = prime * result + salling_period;
		result = prime * result + (salling_status ? 1231 : 1237);
		result = prime * result + user_id;
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
		Salling other = (Salling) obj;
		if (book_id != other.book_id)
			return false;
		if (id != other.id)
			return false;
		if (salling_date == null) {
			if (other.salling_date != null)
				return false;
		} else if (!salling_date.equals(other.salling_date))
			return false;
		if (salling_period != other.salling_period)
			return false;
		if (salling_status != other.salling_status)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salling [id=" + id + ", user_id=" + user_id + ", book_id=" + book_id + ", salling_status="
				+ salling_status + ", salling_date=" + salling_date + ", salling_period=" + salling_period + "]";
	}

}
