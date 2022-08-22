package pages;

import elements.Button;
import elements.Collection;
import elements.Input;
import elements.Label;
import models.User;
import org.openqa.selenium.By;
import utils.JavaScriptClass;

public class ElementsPage extends BasePage {

    private Button webTablesBtn;
    private Button addBtn;
    private Label userForm;
    private Input firstName;
    private Input lastName;
    private Input email;
    private Input age;
    private Input salary;
    private Input department;
    private Button submitBtn;
    private Label userWebTableFirstName;
    private Label userWebTableLastName;
    private Label userWebTableEmail;
    private Button deleteUserBtn;
    private Collection usersWebTable;
    private int sizeUsersWebTableAfterAdd;
    private int sizeUsersWebTableAfterDelete;

    public ElementsPage() {
        super(new Label(By.xpath("//div[@class = 'main-header']")));
        webTablesBtn = new Button(By.xpath("//div[@class ='element-list collapse show']//li[@id = 'item-3']"));
        addBtn = new Button(By.id("addNewRecordButton"));
        userForm = new Label(By.id("registration-form-modal"));
        firstName = new Input(By.id("firstName"));
        lastName = new Input(By.id("lastName"));
        email = new Input(By.id("userEmail"));
        age = new Input(By.id("age"));
        salary = new Input(By.id("salary"));
        department = new Input(By.id("department"));
        submitBtn = new Button(By.id("submit"));
        userWebTableFirstName = new Label(By.xpath("//div[@class = 'rt-tbody']/div[4]/div/div[1]"));
        userWebTableLastName = new Label(By.xpath("//div[@class = 'rt-tbody']/div[4]/div/div[2]"));
        userWebTableEmail = new Label(By.xpath("//div[@class = 'rt-tbody']/div[4]/div/div[4]"));
        deleteUserBtn = new Button(By.id("delete-record-4"));
        usersWebTable = new Collection(By.xpath("//span[contains(@id, 'delete-record-')]"));
    }

    public String getCheckPageHeaderMain() {
        return getBaseElement().getText("checkPageHeaderMain");
    }

    @Override
    public boolean isDisplay() {
        return getBaseElement().isVisible("checkPageHeaderMain");
    }

    public void clickWebTablesBtn() {
        JavaScriptClass.javaScriptScroll();
        webTablesBtn.click("webTablesBtn");
    }

    public void clickAddBtn() {
        addBtn.click("addBtn");
    }

    public boolean isUserFormDisplayed() {
        return userForm.isDisplayed("userForm");
    }

    public int checkUsersWebTable() {
        return usersWebTable.sizeCollection("usersWebTable");
    }

    public void addUsers(User user) {
        firstName.clearAndType(user.getFirstName(), "firstName");
        lastName.clearAndType(user.getLastName(), " lastName");
        email.clearAndType(user.getEmail(), "email");
        age.clearAndType(user.getAge(), "age");
        salary.clearAndType(user.getSalary(), " salary");
        department.clearAndType(user.getDepartment(), "department");
    }

    public void clickSubmitBtn() {
        JavaScriptClass.javaScriptScroll();
        submitBtn.click("submitBtn");
        setSizeUsersWebTableAfterAdd(checkUsersWebTable());
    }

    public String getUserWebTableFirstName() {
        return userWebTableFirstName.getText(" userWebTableFirstName");
    }

    public String getUserWebTableLastName() {
        return userWebTableLastName.getText("userWebTableLastName");
    }

    public String getUserWebTableEmail() {
        return userWebTableEmail.getText("userWebTableEmail");
    }

    public void deleteUserWebTable() {
        JavaScriptClass.javaScriptScroll();
        deleteUserBtn.click("deleteUserBtn");
        setSizeUsersWebTableAfterDelete(checkUsersWebTable());
    }

    public boolean isCheckUserFormClose() {
        return addBtn.isVisible(" addBtn");
    }

    public int getSizeUsersWebTableAfterAdd() {
        return sizeUsersWebTableAfterAdd;
    }

    public void setSizeUsersWebTableAfterAdd(int sizeUsersWebTableAfterAdd) {
        this.sizeUsersWebTableAfterAdd = sizeUsersWebTableAfterAdd;
    }

    public int getSizeUsersWebTableAfterDelete() {
        return sizeUsersWebTableAfterDelete;
    }

    public void setSizeUsersWebTableAfterDelete(int sizeUsersWebTableAfterDelete) {
        this.sizeUsersWebTableAfterDelete = sizeUsersWebTableAfterDelete;
    }
}