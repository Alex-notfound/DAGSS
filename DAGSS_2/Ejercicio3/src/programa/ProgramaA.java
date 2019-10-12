package programa;

public class ProgramaA implements Runnable{
  public void run(){

    try{ 

      System.out.println("[INICIO] ProgramaA " + Thread.currentThread().getName()); Thread.sleep(10); System.out.println("[FIN] ProgramaA"); 

    }catch(InterruptedException e){ throw new RuntimeException(e);} 

  } 

}
