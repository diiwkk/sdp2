package adapter_design_pattern;

// Интерфейс WebDriver определяет два метода, которые должны быть реализованы
interface WebDriver
{
	public void getElement();     // Метод для получения элемента
	public void selectElement();  // Метод для выбора элемента
}

// Класс ChromeDriver реализует интерфейс WebDriver
class ChromeDriver implements WebDriver
{
	@Override
	public void getElement()
	{
		System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement()
	{
		System.out.println("Select element from ChromeDriver");
	}
}

// Класс IEDriver, который не реализует интерфейс WebDriver, но будет адаптирован
class IEDriver
{
	public void findElement()
	{
		System.out.println("Find element from IEDriver");
	}

	public void clickElement()
	{
		System.out.println("Click element from IEDriver");
	}
}

// Класс WebDriverAdapter реализует интерфейс WebDriver и использует адаптер для IEDriver
class WebDriverAdapter implements WebDriver
{
	IEDriver ieDriver;

	// Конструктор класса, принимающий IEDriver в качестве параметра
	public WebDriverAdapter(IEDriver ieDriver)
	{
		this.ieDriver = ieDriver;
	}

	@Override
	public void getElement()
	{
		// Адаптированный вызов метода findElement из IEDriver
		ieDriver.findElement();
	}

	@Override
	public void selectElement()
	{
		// Адаптированный вызов метода clickElement из IEDriver
		ieDriver.clickElement();
	}
}

// Класс AdapterPattern - точка входа в программу
public class AdapterPattern
{
	public static void main(String[] args)
	{
		// Создаем объект ChromeDriver
		ChromeDriver a = new ChromeDriver();
		a.getElement();
		a.selectElement();

		// Создаем объект IEDriver
		IEDriver e = new IEDriver();
		e.findElement();
		e.clickElement();

		// Используем адаптер для IEDriver, чтобы он соответствовал интерфейсу WebDriver
		WebDriver wID = new WebDriverAdapter(e);
		wID.getElement();
		wID.selectElement();
	}
}
