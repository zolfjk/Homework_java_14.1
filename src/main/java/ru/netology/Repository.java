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

    public TicketData[] getAll() {
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

    public TicketData findByAirportFromName(String city) {
        for (TicketData ticket : tickets) {
            if (ticket.getAirportIn() == city) {
                return ticket;
            }
        }
        return null;
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
        if (findById(id) == null) {
            throw new NotFoundId("Element with id: " + id + " not found");
        }
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

    public TicketData[] findAll(String from, String in) {
        if (findByAirportFromName(from) == null) {
            throw new NotFoundCityFrom("Tickets with point of departure: " + from + " not found");
        }
        if (findByAirportInName(in) == null) {
            throw new NotFoundCityIn("Tickets with point of arrival: " + in + " not found");
        }
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
