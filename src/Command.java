public abstract class Command {
       public abstract void execute();
}
class turnOn extends Command {
    private Administrator admin;
    private Request req1;
    turnOn(Administrator admin, Request req1){
        this.admin = admin;
        this.req1 = req1;
    }
    public void execute(){
        this.admin.turnOn(req1);
    }
}
class turnOff extends Command {
    Administrator admin;
    private Request req1;
    turnOff(Administrator admin,Request req1){
        this.admin = admin;
        this.req1 = req1;
    }
    public void execute(){
        this.admin.turnOff(req1); //послуга как параметр
    }
}
class changePhone extends Command {
    private Request req1;
    Administrator admin;
    changePhone(Administrator admin,Request req1){
        this.req1=req1;
        this.admin = admin;
    }
    public void execute(){
        this.admin.changePhone(req1);} //
}