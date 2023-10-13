package decorator_design_pattern;

// Интерфейс Dress определяет метод assemble(), который будет реализован классами-наследниками
interface Dress
{
	public void assemble();
}

// Базовый класс BasicDress реализует интерфейс Dress
class BasicDress implements Dress
{
	@Override
	public void assemble()
	{
		System.out.println("Basic Dress Features");
	}
}

// Класс DressDecorator - базовый класс для всех декораторов
class DressDecorator implements Dress
{
	protected Dress dress;
	public DressDecorator(Dress c)
	{
		this.dress = c;
	}

	@Override
	public void assemble()
	{
		this.dress.assemble();
	}
}

// Класс CasualDress - конкретный декоратор, добавляющий к базовому платью признаки "casual"
class CasualDress extends DressDecorator
{
	public CasualDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Casual Dress Features");
	}
}

// Класс SportyDress - конкретный декоратор, добавляющий к базовому платью признаки "sporty"
class SportyDress extends DressDecorator
{
	public SportyDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Sporty Dress Features");
	}
}

// Класс FancyDress - конкретный декоратор, добавляющий к базовому платью признаки "fancy"
class FancyDress extends DressDecorator
{
	public FancyDress(Dress c)
	{
		super(c);
	}

	@Override
	public void assemble()
	{
		super.assemble();
		System.out.println("Adding Fancy Dress Features");
	}
}

// Класс DecoratorPattern - точка входа в программу
public class DecoratorPattern
{
	public static void main(String[] args)
	{
		// Создаем объект SportyDress, который декорирует BasicDress
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		// Создаем объект FancyDress, который декорирует BasicDress
		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		// Создаем объект CasualDress, который декорирует BasicDress
		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		// Создаем объект SportyDress, который декорирует FancyDress, который декорирует BasicDress
		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		// Создаем объект CasualDress, который декорирует FancyDress, который декорирует BasicDress
		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}
