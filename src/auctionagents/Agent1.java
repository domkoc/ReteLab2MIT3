package auctionagents;

import auctionframework.AbstractAgent;
import auctionframework.Auction;
import auctionframework.AuctionItem;

/**
 *
 * @author 
 */
public class Agent1 extends AbstractAgent {

    /**
     * Default constructor of the first agent.
     * 
     * @param name          Generated name of the agent.
     * @param auction       The auction the agent participates in.
     * @param money         The money the agent has.
     */
    public Agent1(String name, Auction auction, int money) {
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
        int indexOfPrev = auction.getItems().indexOf(item) - 1; // megkeresi az előző licitre kínált elem indexét
        if (indexOfPrev >= 0) { // Megnézi, hogy nehogy az első elemre licitáljon
            return (auction.getItems().get(indexOfPrev).getPrice() > item.getPrice()); // Licitál, ha a jelenlegi elem ára nem haladja meg az előző elem végső árát.
        } else {
            return false; // Ha az első elem kerül kikiáltásra, nem licitál
        }
    }
    /*public boolean ask(AuctionItem item) {
        // The agent only bids for the starting price.
        return (item.getPrice() == item.getStartingPrice());
    }*/
}
