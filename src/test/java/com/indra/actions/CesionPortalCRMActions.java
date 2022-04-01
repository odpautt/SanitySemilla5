package com.indra.actions;

import com.indra.pages.CesionPortalCRMPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CesionPortalCRMActions extends CesionPortalCRMPage {
    public CesionPortalCRMActions(WebDriver driver) {
        super(driver);
    }

    public void initialRute(){
        postSaleClick();
        transactionClick();
        lineModificationClick();
        ContractAssignmentClick();
    }

    public void executeContractAssignment(String phonenumber, String idClient) throws InterruptedException, AWTException {
        switchToIframe();
        writePhoneNumber(phonenumber);
        getVendedor().waitUntilPresent();
        selectAnnualRenewal();
        writeNewClientNumber(idClient);
        consultClick();
        getEmail().waitUntilPresent();
        writeVendorNumber();
        writeReasonForChange();
        writeObsevations();
        selectBillingDepartment();
        selectBillingCity();
        addressBillingClick();
        selectVia();
        writeAddress();
        writeAddress2();
        writeWithAddress();
        bntAceptClick();
        writeEmail();
        selectPlan();
        btnChangeContractClick();
        alertAcept();

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

    public void selectAnnualRenewal(){
        Select dropDownAnnualRenewal= new Select(getDriver().findElement(By.id("cesionContratoForm:InfoAnnualRenewal:planField")));
        dropDownAnnualRenewal.selectByVisibleText("SI");
    }

    public void switchToIframe(){
        WebElement iframe = getDriver().findElement(By.id("iframe"));
        getDriver().switchTo().frame(iframe);
    }

    public void writeVendorNumber(){
        enter("10960370").into(getVendedor());
    }

    public void writeNewClientNumber(String idClient){
        enter(idClient).into(getNewSudId());
    }

    public void consultClick(){
        getBtnConsultar().click();
    }

    public void writeReasonForChange(){
        enter("Prueba Cesion Automatizada QA").into(getMotivo());
    }

    public void writeObsevations(){
        enter("Prueba Cesion Automatizada QA").into(getObservation());
    }

    public void selectBillingDepartment(){
        Select dropDownBillingDepartment= new Select(getDriver().findElement(By.xpath("//select[@name='cesionContratoForm:deptoField:j_id202']")));
        dropDownBillingDepartment.selectByValue("6");
    }

    public void selectBillingCity(){
        waitABit(1000);
        Select dropDownBillingDepartment= new Select(getDriver().findElement(By.xpath("//select[@name='cesionContratoForm:ciudadField:j_id216']")));
        dropDownBillingDepartment.selectByValue("1241");
    }

    public void addressBillingClick(){
        getDireccionFacturacion().click();
    }

    public void selectVia(){
        Select dropDownVia= new Select(getDriver().findElement(By.xpath("//div[@class='tigo_address_block_locate']/select")));
        dropDownVia.selectByValue("Avenida");
    }

    public void writeAddress(){

        enter("45").into(getCallenumero());
    }

    public void writeAddress2(){
        enter("16").into(getCallenumero2());
    }

    public void writeWithAddress(){
        enter("36").into(getWithAddress());
    }

    public void bntAceptClick(){
        getBtnAceptar().click();
    }

    public void writeEmail(){
        enter("pruebaAutomatizadaQA@gmail.com").into(getEmail());
    }

    public void selectPlan(){
        Select dropDownPlan= new Select(getDriver().findElement(By.xpath("//select[@name='cesionContratoForm:j_id256']")));
        dropDownPlan.selectByValue("739");
    }

    public void btnChangeContractClick(){
        waitABit(1000);
        Actions actions = new Actions(getDriver());

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,420)"); //Scroll vertically down by 1000 pixels

        WebElement inventoryAllocation = getDriver().findElement(By.xpath("//*[@id='cesionContratoForm:bntPlanChange']"));
        actions.moveToElement(inventoryAllocation).click().build().perform();
    }

    public void alertAcept(){
        Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

}
