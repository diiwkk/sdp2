package factory_design_pattern;

// Абстрактный класс Vehicle с методом getWheel() и переопределенным методом toString()
abstract class Vehicle
{
	public abstract int getWheel();
	public String toString()
	{
		return "Wheel: " + this.getWheel();
	}
}

// Класс Car наследует от Vehicle и имеет поле wheel
class Car extends Vehicle
{
	int wheel;
	Car(int wheel)
	{
		this.wheel = wheel;
	}

	@Override
	public int getWheel()
	{
		return this.wheel;
	}
}

// Класс Bike наследует от Vehicle и имеет поле wheel
class Bike extends Vehicle
{
	int wheel;
	Bike(int wheel)
	{
		this.wheel = wheel;
	}

	@Override
	public int getWheel()
	{
		return this.wheel;
	}
}

// Класс VehicleFactory отвечает за создание объектов типов "Car" и "Bike"
class VehicleFactory
{
	public static Vehicle getInstance(String type, int wheel)
	{
		if(type.equals("car")) // Используйте .equals() для сравнения строк, а не ==.
		{
			return new Car(wheel);
		}
		else if(type.equals("bike")) // Используйте .equals() для сравнения строк, а не ==.
		{
			return new Bike(wheel);
		}
		return null;
	}
}

// Класс FactoryPattern - точка входа в программу
public class FactoryPattern
{
	public static void main(String[] args)
	{
		// Используем фабрику для создания объектов "Car" и "Bike"
		Vehicle car = VehicleFactory.getInstance("car", 4);
		System.out.println(car);

		Vehicle bike = VehicleFactory.getInstance("bike", 2);
		System.out.println(bike);
	}
}
