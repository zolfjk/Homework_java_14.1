package ru.netology;

import java.util.Arrays;

public class Repository {

    private TicketData[] tickets = new TicketData[0];

    public void save(TicketData ticket) {
        TicketData[] tmp = new TicketData[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public TicketData[] findAll() {
        return tickets;
    }

    public TicketData findById(int id) {
        for (TicketData ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }


    public TicketData[] findByFrom(String from) {
        TicketData[] result = new TicketData[0];

        for (TicketData ticket : tickets) {
            if (ticket.getAirportIn() == from) {
                TicketData[] tmp = new TicketData[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public TicketData[] findByIn(String in) {
        TicketData[] result = new TicketData[0];

        for (TicketData ticket : tickets) {
            if (ticket.getAirportOut() == in) {
                TicketData[] tmp = new TicketData[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public TicketData findByAirportInName(String city) {
        for (TicketData ticket : tickets) {
            if (ticket.getAirportOut() == city) {
                return ticket;
            }
        }
        return null;
    }


    public void removeById(int id) {
        int length = tickets.length - 1;
        TicketData[] tmp = new TicketData[length];
        int index = 0;
        for (TicketData ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    public TicketData[] findByFromAndIn(String from, String in) {
        TicketData[] result = new TicketData[0];

        for (TicketData ticket : tickets) {
            if (ticket.getAirportIn() == from && ticket.getAirportOut() == in) {
                TicketData[] tmp = new TicketData[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


}
