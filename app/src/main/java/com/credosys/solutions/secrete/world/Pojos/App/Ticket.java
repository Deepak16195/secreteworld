package com.credosys.solutions.secrete.world.Pojos.App;

/**
 * Created by Yogesh on 15-Feb-18.
 */

public class Ticket {

    private String ticketNum;
    private String ticketTitle;
    private String ticketSubtitle;
    private String ticketPrice;
    private String ticketViews;

    public Ticket(String ticketNum, String ticketTitle, String ticketSubtitle, String ticketPrice, String ticketViews) {
        this.ticketNum = ticketNum;
        this.ticketTitle = ticketTitle;
        this.ticketSubtitle = ticketSubtitle;
        this.ticketPrice = ticketPrice;
        this.ticketViews = ticketViews;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getTicketSubtitle() {
        return ticketSubtitle;
    }

    public void setTicketSubtitle(String ticketSubtitle) {
        this.ticketSubtitle = ticketSubtitle;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTicketViews() {
        return ticketViews;
    }

    public void setTicketViews(String ticketViews) {
        this.ticketViews = ticketViews;
    }
}
