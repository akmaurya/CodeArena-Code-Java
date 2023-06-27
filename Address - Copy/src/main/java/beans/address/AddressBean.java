package beans.address;

import org.springframework.stereotype.Component;

@Component
public class AddressBean {
	private String address1;
	private String address2;
	private String address3;
	private String pinCode;
	private String district;
	private String state;
	private String country;

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AddressBean{" +
				"address1='" + address1 + '\'' +
				", address2='" + address2 + '\'' +
				", address3='" + address3 + '\'' +
				", pinCode='" + pinCode + '\'' +
				", district='" + district + '\'' +
				", state='" + state + '\'' +
				", country='" + country + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AddressBean)) return false;

		AddressBean that = (AddressBean) o;

		if (getAddress1() != null ? !getAddress1().equals(that.getAddress1()) : that.getAddress1() != null)
			return false;
		if (getAddress2() != null ? !getAddress2().equals(that.getAddress2()) : that.getAddress2() != null)
			return false;
		if (getAddress3() != null ? !getAddress3().equals(that.getAddress3()) : that.getAddress3() != null)
			return false;
		if (getPinCode() != null ? !getPinCode().equals(that.getPinCode()) : that.getPinCode() != null) return false;
		if (getDistrict() != null ? !getDistrict().equals(that.getDistrict()) : that.getDistrict() != null)
			return false;
		if (getState() != null ? !getState().equals(that.getState()) : that.getState() != null) return false;
		return getCountry() != null ? getCountry().equals(that.getCountry()) : that.getCountry() == null;
	}

	@Override
	public int hashCode() {
		int result = getAddress1() != null ? getAddress1().hashCode() : 0;
		result = 31 * result + (getAddress2() != null ? getAddress2().hashCode() : 0);
		result = 31 * result + (getAddress3() != null ? getAddress3().hashCode() : 0);
		result = 31 * result + (getPinCode() != null ? getPinCode().hashCode() : 0);
		result = 31 * result + (getDistrict() != null ? getDistrict().hashCode() : 0);
		result = 31 * result + (getState() != null ? getState().hashCode() : 0);
		result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
		return result;
	}
}
