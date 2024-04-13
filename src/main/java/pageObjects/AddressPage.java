package pageObjects;

import helpers.Address;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage {

    @FindBy(id = "telephone")
    private WebElement phoneNumberField;

    @FindBy(id = "street_1")
    private WebElement streetAddressField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "region_id")
    private WebElement stateList;

    @FindBy(id = "zip")
    private WebElement zipCodeField;

    @FindBy(id = "country")
    private WebElement countryList;

    @FindBy(className = "save")
    private WebElement saveAddressButton;

    @FindBy(className = "add")
    private WebElement addNewAddressButton;

    @FindBy(className = "message-success")
    private WebElement addressSavedMsg;

    public AddressPage() {
        super();
    }

    public boolean isAddNewAddressButtonDisplayed() {
        return addNewAddressButton.isDisplayed();
    }

    public void addNewAddress(Address address) {
        if (isAddNewAddressButtonDisplayed()) {
            addNewAddressButton.click();
        }
        //fillAddressFields(address);
        saveAddressButton.click();
    }
/*
    //?????
    public void fillAddressFields(Address address) {
        phoneNumberField.sendKeys(address.getPhoneNumber());
        streetAddressField.sendKeys(address.getStreetAddress());
        cityField.sendKeys(address.getCity());
        Select countrySelect = new Select(countryList);
        countrySelect.selectByValue(address.getCountry());
        Select stateSelect = new Select(stateList);
        stateSelect.selectByVisibleText(address.getState());
        zipCodeField.sendKeys(address.getZipCode());
    }
*/
    public boolean isAddressSavedMsgDisplayed() {
        return addressSavedMsg.isDisplayed();
    }

}
