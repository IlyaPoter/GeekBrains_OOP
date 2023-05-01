package Classes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.iMarketBehaviour;

public class Market implements iMarketBehaviour{
    private List<Actor> queue;

    public Market() {
        this.queue = new ArrayList<Actor>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName()+" клиент пришел в магазин ");
        this.queue.add(actor);
        
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for(Actor actor:actors)
        {
            System.out.println(actor.getName()+" клиент ушел из магазина ");
            queue.remove(actor);
        }
        
    }

    @Override
    public void update() {
        //releaseFromMarket();
        
    }
    
}
