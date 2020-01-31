import java.text.ParsePosition;
import java.util.ArrayList;

public class Abonent {
    private int id;
    private String Name;
    private String surName;
    private String phoneNum;
    ArrayList<Posluga> servicies = new ArrayList<Posluga>();
    private Request zapros;
    private double sumForPayment;

    Abonent(int id,String name,String surName,String phoneNum){
        this.id=id;
        this.Name = name;
        this.surName = surName;
        this.phoneNum = phoneNum;
        servicies.add(new phoneTalkInsideCity(1,"городская связь",30.5,true));
        servicies.add(new phoneTalkInterCity(2,"междугородняя связь",8.5,true));
        servicies.add(new InternetService(3,"Internet",100,true));
        servicies.add(new SMSService(4,"SMS",12,false));
    }
    //public  Abonent getAbonent()( return this)
    public int getId() { return id; }

    public String getName() { return Name; }

    public String getSurName() { return surName; }

    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }


    public String getPhoneNum() { return phoneNum; }

    public void addPosluga(Posluga p){ this.servicies.add(p);
    }

    public ArrayList<Posluga> getServicies() { return servicies;
    }
    public Posluga getPoslugaById(int Id){ return this.getServicies().get(Id);}

    @Override
    public String toString() {
        return "Abonent{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", surName='" + surName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", servicies=" + servicies +
                '}';
    }
    public Double createInvoice(){
        double sum = 0;
        System.out.println("Abonent "+ "  id"+ getId());
        for(Posluga posluga:servicies) {
            if (posluga.isTurnOn()) { sum = sum + posluga.makeInvoice();
            System.out.println(posluga.getNameService()+" к оплате "+ posluga.makeInvoice());}
        }
        this.sumForPayment = sum;
        System.out.println("Итого сумма оплаты за услуги: " + sum);
        return sum;
    }
    public void makeRequest() {
        this.zapros = new changePoslugaRequest(1,this.id,this.getServicies().get(1).getId(),true) {
            @Override
            public void execute() {

            }
        };
    }
}
