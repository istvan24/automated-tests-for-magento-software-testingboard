package objectModels;

import javax.xml.bind.annotation.XmlElement;

public class NewAccountModel {

    private String newAccountFirstName;
    private String lastName;
    private String password;

    @XmlElement
    public String getNewAccountFirstName() {
        return newAccountFirstName;
    }

    @XmlElement
    public void setNewAccountFirstName(String newAccountFirstName) {
        this.newAccountFirstName = newAccountFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }
}
