package ObjectModels;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginModel {
    private AccountModel account;
    private String usernameErr;
    private String passwordErr;
    private String generalErr;

    public LoginModel() {

    }

    public LoginModel(String username, String password, String usernameErr, String passwordErr, String generalErr) {
        this.account = new AccountModel();
        this.account.setPassword(password);
        this.account.setUsername(username);

        //set current elements
        this.generalErr = generalErr;
        this.passwordErr = passwordErr;
        this.usernameErr = usernameErr;
    }

    public AccountModel getAccount() {
        return account;
    }

    @XmlElement
    public void setAccount(AccountModel account) {
        this.account = account;
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
        return "LoginModel{" +
                "account={username:" + account.getUsername() + ",password=" + account.getPassword() +
                "}, usernameErr='" + usernameErr + '\'' +
                ", passwordErr='" + passwordErr + '\'' +
                ", generalErr='" + generalErr + '\'' +
                '}';
    }
}
