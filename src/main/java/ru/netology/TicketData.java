package ru.netology;

public class TicketData implements Comparable<TicketData> {

    private int id;
    private int pay;
    private String airportIn;
    private String airportOut;
    private int time;

    public TicketData(int id, int pay, String airportIn, String airportOut, int time) {
        this.id = id;
        this.pay = pay;
        this.airportIn = airportIn;
        this.airportOut = airportOut;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPay() {
        return pay;
    }

    public String getAirportIn() {
        return airportIn;
    }

    public String getAirportOut() {
        return airportOut;
    }

    public int getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public void setAirportIn(String airportIn) {
        this.airportIn = airportIn;
    }

    public void setAirportOut(String airportOut) {
        this.airportOut = airportOut;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(TicketData otherTicket) {
        if (pay < otherTicket.pay) {
            return -1;
        }
        if (pay > otherTicket.pay) {
            return 1;
        }
        return 0;
    }
}
