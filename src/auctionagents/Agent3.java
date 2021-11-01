package auctionagents;

import auctionframework.AbstractAgent;
import auctionframework.Auction;
import auctionframework.AuctionItem;

/**
 *
 * @author 
 */
public class Agent3  extends AbstractAgent {

    /**
     * Default constructor of the third agent.
     * 
     * @param name          Generated name of the agent.
     * @param auction       The auction the agent participates in.
     * @param money         The money the agent has.
     */
    public Agent3(String name, Auction auction, int money) {
        super(name, auction, money);
    }
    
    /**
     * The return value of this function indicates if the agent bids for the 
     * actual item in the auction.
     * 
     * @param item          The item to bid for
     * @return              True if the agent bids for the current price.
     */
    public boolean ask(AuctionItem item) {
        int sum = 0; // az átlagszámításhoz használt összeg változó inicializálása
        for (AbstractAgent participant : auction.getParticipants()) { // végig iterálunk a játékosok listáján
            if (participant.getName() != getName()) { // Magunkat nem vesszük bele a számításba
                sum += participant.getMoney(); // hozzáadjuk az összeghez a jelenleg vizsgált ágens vagyonát
            }
        }
        return ((sum / (auction.getParticipants().size() - 1)) <= item.getPrice()); // Csak a vagyonok átlaga felett licitálunk
    }
    /*public boolean ask(AuctionItem item) {
        // The agent always bids (if it has enough money)
        return true;
    }*/
}
