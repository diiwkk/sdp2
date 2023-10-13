// Вариант синглтона, который создает экземпляр немедленно при загрузке класса.
class SingletonEagar
{
  private static SingletonEagar instance = new SingletonEagar(); // Единственный экземпляр синглтона

  private SingletonEagar()
  {
    // Приватный конструктор, чтобы предотвратить создание экземпляров извне класса.
  }

  public static SingletonEagar getInstance()
  {
    return instance; // Метод для получения экземпляра синглтона.
  }
}

// Вариант синглтона, который создает экземпляр при первом вызове метода getInstance().
class Singleton
{
  private static Singleton instance; // Единственный экземпляр синглтона

  private Singleton()
  {
    // Приватный конструктор, чтобы предотвратить создание экземпляров извне класса.
  }

  public static Singleton getInstance()
  {
    if(instance == null)
    {
      instance = new Singleton(); // Создание экземпляра при первом вызове.
    }
    return instance; // Метод для получения экземпляра синглтона.
  }
}

// Вариант синглтона с использованием синхронизированного метода.
class SingletonSynchronizedMethod
{
  private static SingletonSynchronizedMethod instance; // Единственный экземпляр синглтона

  private SingletonSynchronizedMethod()
  {
    // Приватный конструктор, чтобы предотвратить создание экземпляров извне класса.
  }

  public static synchronized SingletonSynchronizedMethod getInstance()
  {
    if(instance == null)
    {
      instance = new SingletonSynchronizedMethod(); // Создание экземпляра при первом вызове.
    }
    return instance; // Метод для получения экземпляра синглтона с синхронизацией.
  }
}

// Вариант синглтона с использованием двойной проверки блока синхронизации (Double-Checked Locking).
class SingletonSynchronized
{
  private static SingletonSynchronized instance; // Единственный экземпляр синглтона

  private SingletonSynchronized()
  {
    // Приватный конструктор, чтобы предотвратить создание экземпляров извне класса.
  }

  public static SingletonSynchronized getInstance()
  {
    if(instance == null)
    {
      synchronized (SingletonSynchronized.class)
      {
        if(instance == null)
        {
          instance = new SingletonSynchronized(); // Создание экземпляра с двойной проверкой.
        }
      }
    }
    return instance; // Метод для получения экземпляра синглтона с двойной проверкой.
  }
}

public class SingletonPattern
{
  public static void main(String[] args)
  {
    SingletonSynchronized instance = SingletonSynchronized.getInstance();
    System.out.println(instance);

    SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
    System.out.println(instance1);
  }
}
