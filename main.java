public class main
{
  public static void main(String[] args) {
    System.out.println("Hello World");

    new Thread() {
      @Override
      public void run() {
        System.out.println(Thread.currentThread() +
                           "Create super " + new Super());
      }
    }.start();

    //try {
    //  Thread.sleep(500);
    //} catch (InterruptedException e) {
    //  throw new RuntimeException(e);
    //}
    System.out.println(Thread.currentThread() + "Created sub: ");
    Sub s = new Sub();
  }
}



public class Super {
  public final static String MYSTATICSTRING;

  static {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    MYSTATICSTRING = "abc";
    Sub s = new Sub();
  }
}

public class Sub extends Super {
  public Sub() {
    System.out.println(Thread.currentThread() + "In Sub constructor");
  }
}
