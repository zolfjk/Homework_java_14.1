package ru.netology;

public class TicketManager {

    private Repository repository;

    public TicketManager(Repository repository) {

        this.repository = repository;
    }


    public void add(TicketData ticket) {

        repository.save(ticket);
    }

    public TicketData[] findAll() {
        return repository.findAll();
    }

    public TicketData[] findByFrom(String from) {

        return repository.findByFrom(from);
    }

    public TicketData[] findByIn(String in) {

        return repository.findByIn(in);
    }

    public TicketData[] findByFromAndIn(String from, String in) {

        return repository.findByFromAndIn(from, in);
    }

    public void removeById(int id) {

        repository.removeById(id);
    }



}
