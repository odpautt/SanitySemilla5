package com.indra.actions;

import com.indra.pages.CambioPosPrePage;
import com.indra.pages.CambioPrePosPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class CambioPrePosActions extends CambioPrePosPage {
    public CambioPrePosActions(WebDriver driver) {
        super(driver);
    }

    public void initialRute(){
        postSaleClick();
        transactionClick();
        lineModificationClick();
        ContractAssignmentClick();
    }

    public void executeContractAssignment(String phonenumber, String vendor) throws InterruptedException, AWTException {
        switchToIframe();
        writePhoneNumber(phonenumber);
        waitABit(45000);
        System.out.println("ya pasaron 5 sg");
        writeReasonForChange();
        writeVendorNumber();
        waitABit(2000);
        getClic().click();
        writeNumber();
        writeMail();
        writeDirection();
        directionClick();
        getFactura().click();
        getFacturaReducida().click();
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,820)");
        selectPlan();
        waitABit(3000);
        js.executeScript("window.scrollBy(0,320)");
        renovar();
        waitABit(2000);
        getDriver().findElement(By.xpath("//*[@id='PlanschangeForm:bntPlanChange']")).click();
        waitABit(2000);
        alertAcept();
        waitABit(10000);
        getMensajes().waitUntilPresent();
        System.out.println(getMensajes().getText());
    }

    public void postSaleClick(){
        getPostSale().click();
    }

    public void transactionClick(){
        getTransaction().click();
    }

    public void lineModificationClick(){
        getLineModification().click();
    }

    public void ContractAssignmentClick(){
        getContractAssignment().click();
    }

    public void writePhoneNumber(String phonumber){
        enter(phonumber).into(getPhoneNumber());
        getPhoneNumber().sendKeys(Keys.TAB);
    }

    public void switchToIframe(){
        WebElement iframe = getDriver().findElement(By.xpath("//*[@id='iframe']"));
        getDriver().switchTo().frame(iframe);
    }

    public void writeVendorNumber(){
        enter("10960370").into(getVendedor());
    }

    public void writeNumber(){
        enter("3104099142").into(getMsisdn());
    }

    public void writeReasonForChange(){
        enter("Prueba Cesion Automatizada QA").into(getReasonChange());
    }

    public void writeMail(){
        enter("pruebaAutomatizacion@gmail.com").into(getMail());
    }

    public void writeDirection(){
        enter("Cra 1 bis #2-24").into(getDireccion());
    }

    public void directionClick(){
        getDeparment().click();
        getDeparment1().click();
        waitABit(5000);
        getCity().click();
        getCity1().click();
    }
    public void alertAcept(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public void selectPlan(){
        Select dropDownPlan= new Select(getDriver().findElement(By.xpath("//*[@id='PlanschangeForm:planField:planField']")));
        dropDownPlan.selectByValue("1210");
    }

    public void renovar(){
        getRenovar().click();
        getRenovar1().click();
    }

    public void consultCaja(String vendorCC){
        getDriver().switchTo().defaultContent();
        getConsult().click();
        getCaja().click();
        getPago().click();
        WebElement iframe = getDriver().findElement(By.id("iframe"));
        getDriver().switchTo().frame(iframe);
        enter(vendorCC).into(getCcVendor());
        getSearchButton().click();
    }
}
