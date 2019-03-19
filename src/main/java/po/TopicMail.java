package po;

import lombok.Data;

@Data
public class TopicMail extends Mail{
	private String routingkey;

	@Override
	public String toString() {
		return "TopicMail [routingkey=" + routingkey + "]";
	}
	
}
