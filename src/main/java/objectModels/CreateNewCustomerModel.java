package objectModels;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CreateNewCustomerModel {
    private AccountModel newAccount;
    private String usernameErr;
    private String passwordErr;
    private String generalErr;

    public CreateNewCustomerModel() {
    }

    public CreateNewCustomerModel(String username, String password, String usernameErr, String passwordErr, String generalErr) {
        this.newAccount = new AccountModel();
        this.newAccount.setPassword(password);
        this.newAccount.setUsername(username);

        //set current elements
        this.generalErr = generalErr;
        this.passwordErr = passwordErr;
        this.usernameErr = usernameErr;
    }

    public AccountModel getNewAccount() {
        return newAccount;
    }

    @XmlElement
    public void setNewAccount(AccountModel newAccount) {
        this.newAccount = newAccount;
    }

    public String getUsernameErr() {
        return usernameErr;
    }

    @XmlElement
    public void setUsernameErr(String usernameErr) {
        this.usernameErr = usernameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    @XmlElement
    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getGeneralErr() {
        return generalErr;
    }

    @XmlElement
    public void setGeneralErr(String generalErr) {
        this.generalErr = generalErr;
    }

    @Override
    public String toString() {
        return "CreateNewCustomerModel{" +
                "account={username:" + newAccount.getUsername() + ",password=" + newAccount.getPassword() +
                "}, usernameErr='" + usernameErr + '\'' +
                ", passwordErr='" + passwordErr + '\'' +
                ", generalErr='" + generalErr + '\'' +
                '}';
    }
}

