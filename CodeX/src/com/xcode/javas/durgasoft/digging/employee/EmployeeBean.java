package com.xcode.javas.durgasoft.digging.employee;

public class EmployeeBean
{
    private String name;
    private byte age;
    private String address;
    private String email;

    public EmployeeBean()
    {
    }

    public EmployeeBean(String name, byte age, String address, String email)
    {
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public byte getAge()
    {
        return age;
    }

    public void setAge(byte age)
    {
        this.age = age;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof EmployeeBean))
            return false;

        EmployeeBean that = (EmployeeBean) o;

        if (getAge() != that.getAge())
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(that.getAddress()) : that.getAddress() != null)
            return false;

        return getEmail() != null ? getEmail().equals(that.getEmail()) : that.getEmail() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (int) getAge();
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0); result = 31 * result + (int) getAge();
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "EmployeeBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", hashCode='" + this.hashCode() + '\'' +
                "}\n";
    }
}
