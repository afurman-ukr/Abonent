//import com.sun.org.apache.xerces.internal.parsers.DTDParser;
//import com.sun.org.apache.xml.internal.dtm.ref.DTMNodeList;

public class Posluga {
    private int id;
    private String nameService;
    private double tariff;
    private  Months month;
    private boolean isTurnOn;
    private Double Sum;

    Posluga(int id, String name,double tariff){
        this.id = id;
        this.nameService = name;
        this.tariff = tariff;
        setMonth(Months.January);
    }
    Posluga(int id, String name,double tariff, boolean isOn){
        this.id = id;
        this.nameService = name;
        this.tariff = tariff;
        setTurnOn(isOn);
        setMonth(Months.January);
    }

    public void setTurnOn(boolean turnOn) {
        isTurnOn = turnOn;
    }

    public boolean isTurnOn() {
        return isTurnOn;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id;
    }

    public Double getTariff() { return tariff; }

    public Months getMonth() { return month; }

    public String getNameService() { return nameService; }

    public void setNameService(String nameService) { this.nameService = nameService;
    }

    public void setMonth(Months month) { this.month = month; }

    public void setTariff(Double tariff) { this.tariff = tariff; }

    @Override
    public String toString() {
        return "Posluga{" +
                "nameService='" + nameService + '\'' +
                ", isTurnOn=" + isTurnOn +
                '}';
    }
   // @Override
    public Double makeInvoice(){return this.Sum;};
}

 class phoneTalkInsideCity extends Posluga implements Invoice
{
    private int minutes;
    //private boolean isInsideCityTalk;
    phoneTalkInsideCity(int id, String name,double tariff,boolean isOn) {
        super(id,name,tariff,isOn);
        //setInsideCityTalk(true);
        this.setMinutes(200); // 200 minutes per month;

    }

    public void setMinutes(int minutes) { this.minutes = minutes; }
    public int getMinutes() { return minutes; }

    //public boolean isInsideCityTalk() { return isisInsideCityTalk; }

    //public void setInsideCityTalk(boolean insideCityTalk) { isInsideCityTalk = insideCityTalk; }

    @Override
    public Double makeInvoice() {
        return this.getTariff();
    }
}
class phoneTalkInterCity extends Posluga implements Invoice
{
    //private boolean isIntercityTalk;
    private int minutes;
    phoneTalkInterCity(int id, String name,double tariff,boolean isOn) {

        super(id, name, tariff, isOn);
        this.setMinutes(23);
    }
    public void setMinutes(int minutes) { this.minutes = minutes; }
    public int getMinutes() { return minutes; }
    @Override
    public Double makeInvoice() {
        return this.minutes*this.getTariff();
    }
}
class InternetService extends Posluga implements Invoice
{
   //private boolean isInternet;
   private int Speed;
    InternetService(int id, String name,double tariff,boolean isOn) {
        super(id,name,tariff,isOn);
        setSpeed(100);
    }

    //public boolean isInternet() { return isInternet; }
    //public void setInternet(boolean internet) { isInternet = internet; }
    public void setSpeed(int speed) { Speed = speed; }
    public int getSpeed() { return Speed; }

    @Override
    public Double makeInvoice() {
        if (getSpeed()==100) return getTariff();
        else if (getSpeed()==200) return 1.3*getTariff();
        else return 0.8*getTariff();
    }
}
class SMSService extends Posluga implements Invoice
{
    private boolean isSMS;
    SMSService(int id, String name,double tariff,boolean isOn) {
        super(id,name,tariff,isOn);

    }

    public boolean isSMS() { return isSMS; }
    public void setSMS(boolean SMS) { isSMS = SMS; }



    @Override
    public Double makeInvoice() {
        return 20.0;
    }
}
 interface Invoice {
    public Double makeInvoice();
 }
