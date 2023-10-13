package facade_design_pattern;

import java.sql.Driver;

// Класс Firefox предоставляет методы для работы с Firefox-драйвером и генерации отчетов
class Firefox
{
    public static Driver getFirefoxDriver()
    {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver)
    {
        System.out.println("Generating HTML Report for Firefox Driver");
    }

    public static void generateJUnitReport(String test, Driver driver)
    {
        System.out.println("Generating JUNIT Report for Firefox Driver");
    }
}

// Класс Chrome предоставляет методы для работы с Chrome-драйвером и генерации отчетов
class Chrome
{
    public static Driver getChromeDriver()
    {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver)
    {
        System.out.println("Generating HTML Report for Chrome Driver");
    }

    public static void generateJUnitReport(String test, Driver driver)
    {
        System.out.println("Generating JUNIT Report for Chrome Driver");
    }
}

// Класс WebExplorerHelperFacade - фасад, предоставляющий удобный интерфейс для генерации отчетов
class WebExplorerHelperFacade
{
    public static void generateReports(String explorer, String report, String test)
    {
        Driver driver = null;
        switch(explorer)
        {
            case "firefox":
                driver = Firefox.getFirefoxDriver();
                switch(report)
                {
                    case "html":
                        Firefox.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch(report)
                {
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
        }
    }
}

// Класс FacadePattern - точка входа в программу
public class FacadePattern
{
    public static void main(String[] args)
    {
        String test = "CheckElementPresent";

        // Используем фасад для генерации отчетов для разных браузеров и форматов отчетов
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }
}
