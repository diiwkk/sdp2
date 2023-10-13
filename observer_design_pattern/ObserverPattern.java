package observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Интерфейс Subject определяет методы для регистрации, удаления и уведомления наблюдателей.
interface Subject
{
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}

// Класс DeliveryData реализует интерфейс Subject и предоставляет информацию о местоположении доставки.
class DeliveryData implements Subject
{
    private List<Observer> observers;
    private String location;

    public DeliveryData()
    {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj)
    {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj)
    {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers()
    {
        for(Observer obj : observers)
        {
            obj.update(location);
        }
    }

    public void locationChanged()
    {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation()
    {
        return "YPlace";
    }
}

// Интерфейс Observer определяет метод update() для обновления информации наблюдателями.
interface Observer
{
    public void update(String location);
}

// Класс Seller реализует интерфейс Observer и представляет продавца.
class Seller implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Класс User реализует интерфейс Observer и представляет пользователя.
class User implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Класс DeliveryWarehouseCenter реализует интерфейс Observer и представляет центр по доставке.
class DeliveryWarehouseCenter implements Observer
{
    private String location;

    @Override
    public void update(String location)
    {
        this.location = location;
        showLocation();
    }

    public void showLocation()
    {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern
{
    public static void main(String[] args)
    {
        // Создаем объект DeliveryData, который предоставляет информацию о местоположении доставки.
        DeliveryData topic = new DeliveryData();

        // Создаем объекты-наблюдатели (продавец, пользователь и центр по доставке).
        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        // Регистрируем наблюдателей в объекте DeliveryData.
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Изменяем местоположение и уведомляем наблюдателей.
        topic.locationChanged();

        // Отменяем регистрацию одного из наблюдателей.
        topic.unregister(obj3);

        System.out.println();

        // Изменяем местоположение снова и уведомляем наблюдателей (центр по доставке больше не получит уведомление).
        topic.locationChanged();
    }
}
