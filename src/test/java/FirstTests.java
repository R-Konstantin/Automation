import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.DriverManager;
import java.util.List;

public class FirstTests {

    @Test //Первый сайт.
    public void smokeTest2() throws InterruptedException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://calc.by/building-calculators/laminate.html");

        WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
        Select methodLaminate = new Select(selectWebElement);
        methodLaminate.selectByIndex(2);

        WebElement roomLenght = driver.findElement(By.id("ln_room_id"));
        roomLenght.sendKeys(Keys.chord(Keys.CONTROL, "a"), "500");

        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), "400");

        WebElement laminatePanelLength = driver.findElement(By.id("ln_lam_id"));
        laminatePanelLength.sendKeys(Keys.chord(Keys.CONTROL, "a"), "2000");

        WebElement laminatePanelWidth = driver.findElement(By.id("wd_lam_id"));
        laminatePanelWidth.sendKeys(Keys.chord(Keys.CONTROL, "a"), "200");

        WebElement layingDirection = driver.findElement(By.id("direction-laminate-id1"));
        layingDirection.click();

            List<WebElement> list = driver.findElements(By.name("direction-laminate"));
            for (WebElement option : list) {
                if (option.getAttribute("value").equals("1")) {
                    option.click();
                }
        }

        WebElement calcBtn = driver.findElement(By.linkText("Рассчитать"));
        calcBtn.click();

        Thread.sleep(5000);

        WebElement numberBoards = driver.findElement(By.xpath("//span [text() = '53']"));
        Assert.assertEquals(numberBoards.getText(), "53");

        WebElement numberPackages = driver.findElement(By.xpath("//span [text() = '7']"));
        Assert.assertEquals(numberPackages.getText(), "7");

        driver.quit();
    }

    @Test //Второй сайт.
    public void smokeTest3() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement roomLength = driver.findElement(By.name("calc_roomwidth"));
        JavascriptExecutor jseRoomLength = (JavascriptExecutor) driver;
        jseRoomLength.executeScript("arguments[0].value='6';", roomLength);


        WebElement roomWidth = driver.findElement(By.name("calc_roomheight"));
        JavascriptExecutor jseRoomWidth = (JavascriptExecutor) driver;
        jseRoomWidth.executeScript("arguments[0].value='4';", roomWidth);

        WebElement laminateLength = driver.findElement(By.name("calc_lamwidth"));
        JavascriptExecutor jsell = (JavascriptExecutor) driver;
        jsell.executeScript("arguments[0].value='1500';", laminateLength);

        WebElement laminateWidth = driver.findElement(By.name("calc_lamheight"));
        JavascriptExecutor jselw = (JavascriptExecutor) driver;
        jselw.executeScript("arguments[0].value='200';", laminateWidth);

        WebElement packing = driver.findElement(By.name("calc_inpack"));
        JavascriptExecutor jsePacking = (JavascriptExecutor) driver;
        jsePacking.executeScript("arguments[0].value='10';", packing);

        WebElement price = driver.findElement(By.name("calc_price"));
        JavascriptExecutor jsePrice = (JavascriptExecutor) driver;
        jsePrice.executeScript("arguments[0].value='100';", price);

        WebElement layingDirection = driver.findElement(By.name("calc_direct"));
        Select select = new Select(layingDirection);
        select.selectByValue("toh");

        WebElement offsetRows = driver.findElement(By.name("calc_bias"));
        JavascriptExecutor jseOffsetRows = (JavascriptExecutor) driver;
        jseOffsetRows.executeScript("arguments[0].value= '300';", offsetRows);

        WebElement indentFromTheWall = driver.findElement(By.name("calc_walldist"));
        JavascriptExecutor jseindentFromTheWall = (JavascriptExecutor) driver;
        jseindentFromTheWall.executeScript("arguments[0].value = '10';", indentFromTheWall);

        WebElement btn = driver.findElement(By.className("tocalc"));
        btn.click();

        WebElement layingArea = driver.findElement(By.id("s_lam"));
        Assert.assertEquals(layingArea.getText(), "23.80 м2.", "Площадь укладки отображается не верно.");

        WebElement numberPanels = driver.findElement(By.id("l_count"));
        Assert.assertEquals(numberPanels.getText(), "84 шт.", "Количество панелей отображается не верно.");

        WebElement numberPackages = driver.findElement(By.id("l_packs"));
        Assert.assertEquals(numberPackages.getText(), "9 шт.", "Количество упаковок отображается не верно.");

        WebElement costLaminate = driver.findElement(By.id("l_price"));
        Assert.assertEquals(costLaminate.getText(), "2700 руб.", "Стоимость отображается не верно.");

        WebElement remains = driver.findElement(By.id("l_over"));
        Assert.assertEquals(remains.getText(), "6 шт.", "Остатки отображаются не верно.");

        WebElement segments = driver.findElement(By.id("l_trash"));
        Assert.assertEquals(segments.getText(), "6 шт.", "Отрезки отображаются не верно.");

        driver.quit();
    }

    @Test //Второй сайт.
    public void smokeTest4() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement roomLength = driver.findElement(By.name("calc_roomwidth"));
        JavascriptExecutor jseRoomLength = (JavascriptExecutor) driver;
        jseRoomLength.executeScript("arguments[0].value='10.506';", roomLength);


        WebElement roomWidth = driver.findElement(By.name("calc_roomheight"));
        JavascriptExecutor jseRoomWidth = (JavascriptExecutor) driver;
        jseRoomWidth.executeScript("arguments[0].value='4.304';", roomWidth);

        WebElement laminateLength = driver.findElement(By.name("calc_lamwidth"));
        JavascriptExecutor jsell = (JavascriptExecutor) driver;
        jsell.executeScript("arguments[0].value='1000';", laminateLength);

        WebElement laminateWidth = driver.findElement(By.name("calc_lamheight"));
        JavascriptExecutor jselw = (JavascriptExecutor) driver;
        jselw.executeScript("arguments[0].value='250';", laminateWidth);

        WebElement packing = driver.findElement(By.name("calc_inpack"));
        JavascriptExecutor jsePacking = (JavascriptExecutor) driver;
        jsePacking.executeScript("arguments[0].value='4';", packing);

        WebElement price = driver.findElement(By.name("calc_price"));
        JavascriptExecutor jsePrice = (JavascriptExecutor) driver;
        jsePrice.executeScript("arguments[0].value='120';", price);

        WebElement layingDirection = driver.findElement(By.name("calc_direct"));
        Select select = new Select(layingDirection);
        select.selectByValue("tow");

        WebElement offsetRows = driver.findElement(By.name("calc_bias"));
        JavascriptExecutor jseOffsetRows = (JavascriptExecutor) driver;
        jseOffsetRows.executeScript("arguments[0].value= '300';", offsetRows);

        WebElement indentFromTheWall = driver.findElement(By.name("calc_walldist"));
        JavascriptExecutor jseindentFromTheWall = (JavascriptExecutor) driver;
        jseindentFromTheWall.executeScript("arguments[0].value = '10';", indentFromTheWall);

        WebElement btn = driver.findElement(By.className("tocalc"));
        btn.click();

        WebElement layingArea = driver.findElement(By.id("s_lam"));
        Assert.assertEquals(layingArea.getText(), "44.92 м2.", "Площадь укладки отображается не верно.");

        WebElement numberPanels = driver.findElement(By.id("l_count"));
        Assert.assertEquals(numberPanels.getText(), "192 шт.", "Количество панелей отображается не верно.");

        WebElement numberPackages = driver.findElement(By.id("l_packs"));
        Assert.assertEquals(numberPackages.getText(), "48 шт.", "Количество упаковок отображается не верно.");

        WebElement costLaminate = driver.findElement(By.id("l_price"));
        Assert.assertEquals(costLaminate.getText(), "5777 руб.", "Стоимость отображается не верно.");

        WebElement remains = driver.findElement(By.id("l_over"));
        Assert.assertEquals(remains.getText(), "0 шт.", "Остатки отображаются не верно.");

        WebElement segments = driver.findElement(By.id("l_trash"));
        Assert.assertEquals(segments.getText(), "6 шт.", "Отрезки отображаются не верно.");

        driver.quit();
    }
}
