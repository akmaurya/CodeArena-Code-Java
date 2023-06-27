package beans.address;

import org.springframework.stereotype.Component;

@Component
public class PersonBean
{
    private PersonNameBean fullName;
    private int age;
    private String gender;
    private AddressBean fullAddress;
    private String contactNo;
    private String email;

    public PersonNameBean getFullName() {
        return fullName;
    }

    public void setFullName(PersonNameBean fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AddressBean getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(AddressBean fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "[ \n" +
                "\tFirst Name = " + fullName.getFirstName() + "\n" +
                "\tMiddle Name = " + fullName.getMiddleName() + "\n" +
                "\tLast Name = " + fullName.getLastName() + "\n" +
                "\tAge = " + age + "\n" +
                "\tGender = " + gender + "\n" +
                "\tContact No. = " + contactNo + "\n" +
                "\tEmail = " + email + "\n" +
                "\tAddress Line1 = " + fullAddress.getAddress1()+ "\n" +
                "\t\t\t Line2 = " + fullAddress.getAddress2()+ "\n" +
                "\t\t\t Line3 = " + fullAddress.getAddress3()+ "\n" +
                "\tPin Code = " + fullAddress.getPinCode()+ "\n" +
                "\tDistrict = " + fullAddress.getDistrict()+ "\n" +
                "\tState = " + fullAddress.getState()+ "\n" +
                "\tCountry = " + fullAddress.getCountry()+ "\n" +
                "]";
    }
}
