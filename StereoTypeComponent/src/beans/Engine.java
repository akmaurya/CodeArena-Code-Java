package beans;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	private String engName;

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}
	
	
}
