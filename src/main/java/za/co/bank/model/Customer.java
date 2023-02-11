package za.co.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // The object will be persisted
public class Customer {

    @Id // primary key rep in db
    private int accID;

    private String customerName;
    private String customerSurname;
    private String city;
    private String province;
    private String country;
    private int phoneNo;
    private String password;

    public Customer(){}

    public Customer(int accID, String customerName, String customerSurname,
                    String city, String province, String country, int phoneNo, String password) {
        this.accID = accID;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.city = city;
        this.province = province;
        this.country = country;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
