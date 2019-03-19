package po;

import lombok.Data;

import java.io.Serializable;

@Data
public class Mail implements Serializable{
	private static final long serialVersionUID = -8140693840257585779L;

	private String mailId;
	private String country;
	private Double weight;

	public Mail() {
	}
	public Mail(String mailId, String country, double weight) {
		this.mailId = mailId;
		this.country = country;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Mail [mailId=" + mailId + ", country=" + country + ", weight="
				+ weight + "]";
	}
	
}
