package proxy_design_pattern;

// Интерфейс DatabaseExecuter определяет метод для выполнения базовых операций с базой данных.
interface DatabaseExecuter
{
	public void executeDatabase(String query) throws Exception;
}

// Класс DatabaseExecuterImpl реализует интерфейс DatabaseExecuter и предоставляет реализацию выполнения запросов к базе данных.
class DatabaseExecuterImpl implements DatabaseExecuter
{
	@Override
	public void executeDatabase(String query) throws Exception
	{
		System.out.println("Going to execute Query: " + query);
	}
}

// Класс DatabaseExecuterProxy представляет собой прокси для контроля доступа к базе данных и разрешений.
class DatabaseExecuterProxy implements DatabaseExecuter
{
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd)
	{
		if(name.equals("Admin") && passwd.equals("Admin@123"))
		{
			ifAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception
	{
		if(ifAdmin)
		{
			dbExecuter.executeDatabase(query);
		}
		else
		{
			if(query.equals("DELETE"))
			{
				throw new Exception("DELETE not allowed for non-admin user");
			}
			else
			{
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

public class ProxyPattern
{
	public static void main(String[] args) throws Exception
	{
		// Создаем прокси для пользователя NonAdmin
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE"); // Выведет сообщение об ошибке, так как "DELETE" не разрешено для NonAdmin

		// Создаем прокси для пользователя NonAdmin
		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE"); // Выведет сообщение об ошибке, так как "DELETE" не разрешено для NonAdmin

		// Создаем прокси для пользователя Admin
		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE"); // Выполнит операцию "DELETE", так как пользователь Admin имеет разрешение
	}
}
