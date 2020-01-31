public  class Request {
    //private Administrator admin;
    private int id;
    private int idAbonent;
    private int idPosluga;
    private Abonent ab;
    private Posluga p;
    private boolean newStatePosluga;
    private String newPhoneNumber;
    public void  execute(){};

    Request(int id, int idAbonent, int idPosluga, boolean newStatePosluga){
        this.id=id;
        this.idAbonent=idAbonent;
        this.idPosluga=idPosluga;
        this.newStatePosluga=newStatePosluga;
    }

    Request(int id,int idAbonent,String newPhoneNumber){

        this.id=id;
        this.idAbonent=idAbonent;
        this.newPhoneNumber = newPhoneNumber;
    }
   //public Abonent getAbonentById(int id) { return this.admin.getAbonents().get(id);}
    //public Posluga getPoslugaById(int Id) {return this.admin.getAbonents().get(id).getServicies().get()}

    public int getId() { return id; }
    public int getIdAbonent() { return idAbonent; }
    public int getIdPosluga() { return idPosluga; }
    public boolean isNewStatePosluga() { return newStatePosluga; }

    public Abonent getAb() {
        return ab;
    }

    public Posluga getP() {
        return p;
    }

    public boolean getNewStatePosluga() {
        return newStatePosluga;
    }
}
class changePhoneRequest extends Request {
    changePhoneRequest(int id,int idAbonent,String newPhoneNumber){
        super( id, idAbonent,newPhoneNumber);
    }
    public void execute(){
        String newPhone = "33333-333333";
        this.getAb().setPhoneNum(newPhone);
        System.out.println("Abonent "+this.getAb().getId()+" have phone number "+this.getAb().getPhoneNum());
    };
}
 class changePoslugaRequest extends Request {
     changePoslugaRequest(int id, int idAbonent, int idPosluga, boolean newState){
    super(id,idAbonent,idPosluga,newState);}
    public void  execute(){
        this.getAb().addPosluga(this.getP());
        System.out.println("Abonent "+this.getAb().getId()+" add new service"+ this.getP().getNameService());
    };
}
