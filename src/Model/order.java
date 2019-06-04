package Model;

public class order {

    public order(int id, String type, String money, String date){
        this.id = id;
        Type = type;
        this.money = money;
        this.date = date;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getType(){
        return Type;
    }

    public void setType(String type){
        Type = type;
    }

    public String getMoney(){
        return money;
    }

    public void setMoney(String money){
        this.money = money;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    private int id;
    private String Type;
    private String money;
    private String date;

}
