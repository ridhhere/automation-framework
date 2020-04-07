package framework.webPages;

import javafx.scene.control.Alert;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.aspectj.util.FileUtil;
import org.aspectj.weaver.ast.Var;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelImport {


    @Test
    public void excelSheet() throws IOException {
        String file_name = "/Users/ridhgurung/Documents/project_data.xlsx";

        FileInputStream excelFile = new FileInputStream(new File(file_name));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet firstSheet = workbook.getSheetAt(0);
        Sheet secondSheet = workbook.getSheetAt(1);

        int userNameRowNum = firstSheet.getLastRowNum();
        String user = firstSheet.getRow(1).getCell(0).getStringCellValue();
        String userSecond = secondSheet.getRow(1).getCell(0).getStringCellValue();

        System.out.println(user);
        System.out.println(userSecond);
        System.out.println(userNameRowNum);

        for(int i = 1;i<=userNameRowNum; i++){
            String userNames = firstSheet.getRow(i).getCell(0).getStringCellValue();
            System.out.println(userNames);
        }
        workbook.close();
    }

    @Test
        public void TestScenarioClass()  {
            try {
                WebDriver driver = new ChromeDriver();
                driver.get("https://google.com");
                Thread.sleep(2000);
                File fileScr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtil.copyFile(fileScr, new File("/Users/ridhgurung/Desktop/testScreenshot.jpg"));
                driver.quit();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Test
    public void googleTestRandom() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Manhattan",Keys.RETURN);
//        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
        Thread.sleep(1000);



        driver.quit();

    }

    @Test
    public void TestScenarioClassHeadlessDriver() throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("no-sandbox");

        WebDriver driver = new ChromeDriver(options);
            driver.get("https://facebook.com");
            Thread.sleep(2000);
            System.out.println(driver.getTitle().toString());
            File fileScr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtil.copyFile(fileScr, new File("/Users/ridhgurung/Desktop/testScreenshot1.jpg"));
    }

    @Test
    public void handleWindows(){
        WebDriver driver = new ChromeDriver();
        String parentHandle = driver.getWindowHandle(); // get the current window handle
        driver.findElement(By.xpath("//*[@id='someXpath']")).click(); // click some link that opens a new window

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
        }

//code to do something on new window

        driver.close(); // close newly opened window when done with it
        driver.switchTo().window(parentHandle); // switch back to the original window
    }

    @Test
        public void reverseString(){
        String original = "ridhgurung21";
        String reverse = "";
        for (int i=original.length()-1; i>=0;i--){
            reverse = reverse + original.charAt(i);
        }
        System.out.println(reverse);
    }

    @Test
    public void arrayList(){
        ArrayList<String> ridh = new ArrayList<>();
        ridh.add("man");
        ridh.add("awesome");
        ridh.add("test");
//        System.out.println(ridh);
        List<String> ridhTest = ridh;
        System.out.println(ridhTest);

    }

    @Test
    public void facebookTestJan(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ridh");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }

}
