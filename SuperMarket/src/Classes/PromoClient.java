package Classes;

public class PromoClient extends Actor{

    private int sale;

    public PromoClient(String name, int sale)
    {
        super(name);
        this.sale = sale;
    }

    @Override
    public String getName() {
        return super.name;
    }
    
    public int getidVIP(){
        return sale;
    }

    @Override
    public boolean isMakeOrder() {
        return super.isMakeOrder;
    }

    @Override
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }

    @Override
    public void setMakeOrder(boolean makeOrder) {
        super.isMakeOrder = makeOrder;
    }

    @Override
    public void setTakeOrder(boolean pickUpOrder) {
        super.isTakeOrder = pickUpOrder;
    }

    @Override
    public Actor getActor() {
        return this;
    }
     
}
