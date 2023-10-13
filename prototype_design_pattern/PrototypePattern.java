package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Класс Vehicle является прототипом для создания объектов
class Vehicle implements Cloneable
{
  private List<String> vehicleList;

  public Vehicle()
  {
    this.vehicleList = new ArrayList<String>();
  }

  public Vehicle(List<String> list)
  {
    this.vehicleList = list;
  }

  public void insertData()
  {
    vehicleList.add("Honda amaze");
    vehicleList.add("Audi A4");
    vehicleList.add("Hyundai Creta");
    vehicleList.add("Maruti Baleno");
    vehicleList.add("Renault Duster");
  }

  public List<String> getVehicleList()
  {
    return this.vehicleList;
  }

  @Override
  public Object clone() throws CloneNotSupportedException
  {
    List<String> tempList = new ArrayList<String>();

    for(String s : this.getVehicleList())
    {
      tempList.add(s);
    }

    return new Vehicle(tempList);
  }
}

public class PrototypePattern
{
  public static void main(String[] args) throws CloneNotSupportedException
  {
    // Создаем объект Vehicle и заполняем его данными
    Vehicle a = new Vehicle();
    a.insertData();

    // Клонируем объект a, создавая объект b
    Vehicle b = (Vehicle) a.clone();
    List<String> list = b.getVehicleList();
    list.add("Honda new Amaze");

    System.out.println(a.getVehicleList()); // Оригинальный список остается неизменным
    System.out.println(list); // Список b содержит новый элемент

    // Удаляем элемент из списка b
    b.getVehicleList().remove("Audi A4");
    System.out.println(list); // Элемент "Audi A4" удален только из списка b
    System.out.println(a.getVehicleList()); // Оригинальный список остается неизменным
  }
}
