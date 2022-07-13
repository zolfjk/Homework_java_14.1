package ru.netology;

public class TicketManager {

    private Repository repository;

    public TicketManager(Repository repository) {
        this.repository = repository;
    }


    public void add(TicketData ticket) {

        repository.save(ticket);
    }

    public TicketData[] getAll() {
        return repository.getAll();
    }

    public TicketData[] findAll(String from, String in) {
        return repository.findAll(from, in);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }



}
