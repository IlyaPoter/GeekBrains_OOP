import Classes.Market;
import Classes.OrdinaryClient;

public class App {
    public static void main(String[] args) throws Exception {
        Market market = new Market();
        OrdinaryClient client1 = new OrdinaryClient("Boris");
        OrdinaryClient client2 = new OrdinaryClient("Dasha");
        market.acceptToMarket(client1);
        market.acceptToMarket(client2);
    }
}
