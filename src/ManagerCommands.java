public class ManagerCommands {
    private Command command;
    public ManagerCommands(Command command){
        this.command=command;
    }
    public void setManager(Command command){
        this.command=command;
    }
    public void exes(){
        command.execute();
    }
}
