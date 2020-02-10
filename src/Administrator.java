import java.util.ArrayList;
import java.util.Scanner;

enum Months{January,February ,March,April,May,June,July,August,September,October,November,December}
public class Administrator {
private ArrayList<Abonent> Abonents = new ArrayList<Abonent>(20);
//private ArrayList<Request> Requests = new ArrayList<Request>();


    public ArrayList<Abonent> getAbonents() { return Abonents; }
    public void setAbonents(ArrayList<Abonent> abonents) { Abonents = abonents; }
    public void addAbonent(Abonent ab) {
        this.getAbonents().add(ab);
    }
    public Abonent getAbonentById(int Id){ return this.getAbonents().get(Id);}



    public void turnOn(Request r){
        getAbonentById(r.getIdAbonent()).getPoslugaById(r.getIdPosluga()).setTurnOn(true);
        // getAbonentById(r.getIdAbonent()).getServicies().get(r.getIdPosluga()).setTurnOn(true);
       //System.out.println(posl.getNameService()+"Posluga is turned ON");
    };
    public void turnOff(Request r){
        getAbonentById(r.getIdAbonent()).getServicies().get(r.getIdPosluga()).setTurnOn(false);
       //System.out.println(getServicies().get(r.getIdPosluga()).setTurnOn(false)+"Posluga is turned OFF");
    };
    public void changePhone(Request r){
        getAbonentById(r.getIdAbonent()).setPhoneNum("044-4444444444444");
        System.out.println("phone number changed");
    }
    public void turnOn(){

        System.out.println("Posluga is turned ON");
    };
    public void turnOff(){
        System.out.println("Posluga is turned OFF");
    };



  public static void main(String[] args) {
      Abonent ab1 = new Abonent(1, "Egor", "Petrenko", "044-5404040");
      Abonent ab2 = new Abonent(2, "Petr", "Fedorenko", "044-5404041");
      Abonent ab3 = new Abonent(3, "Olga", "Semenova", "044-5404042");

      Administrator admin = new Administrator();
      admin.addAbonent(ab1); admin.addAbonent(ab2); admin.addAbonent(ab3);
      // System.out.println(admin.getAbonents());
      for (Abonent ab:admin.getAbonents()) {
          System.out.println(ab);
      }
      ab1.createInvoice();
      // ===================================================================
      //===================================================================
  Scanner sc = new Scanner(System.in);

  while (true) {
      System.out.println("Input abonent ID:");
      int idAbonent = sc.nextInt();
      System.out.println("Input ID of Posluga (1- phoneTalks inside city, 2- phoneTalks inter city, 3- InternetServise, 4 -SMS Service, 5 - change PhoneNumber):");
      int idService = sc.nextInt();
     // System.out.println("Input old Stastus of Poslugi:");
      // boolean oldStatus = sc.nextBoolean();
      System.out.println("Input new Stastus of Poslugi:");
      boolean newStatus = sc.nextBoolean();
      Request req1 = new Request(1, idAbonent, idService, newStatus);

      //======================================================================
      Command operation;
      if (idService==5) operation = new changePhone(admin,req1);
      else if (newStatus) {
          operation = new turnOn(admin,req1);
      } else {
          operation = new turnOff(admin,req1);
      }

      ManagerCommands manager = new ManagerCommands(operation);
      manager.exes();
       // print all abonents
      for (Abonent ab:admin.getAbonents()) {
          System.out.println(ab);
      }
            System.out.println("github version /");
      // check change the file
  }
  }

}

