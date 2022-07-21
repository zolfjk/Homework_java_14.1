package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketData ticket1 = new TicketData(205, 4000, "Moscow", "Kazan", 70);
    TicketData ticket2 = new TicketData(206, 4500, "Moscow", "Kazan", 90);
    TicketData ticket3 = new TicketData(207, 3500, "Moscow", "Kazan", 95);
    TicketData ticket4 = new TicketData(115, 4000, "Moscow", "Kazan", 70);
    TicketData ticket5 = new TicketData(116, 2900, "Nijniy Novgorod", "Kazan", 50);
    TicketData ticket6 = new TicketData(117, 5500, "Nijniy Novgorod", "Kazan", 120);
    TicketData ticket7 = new TicketData(589, 3500, "Sankt-Petersburg", "Kazan", 95);
    TicketData ticket8 = new TicketData(590, 5500, "Sankt-Petersburg", "Moscow", 120);
    TicketData ticket9 = new TicketData(591, 4200, "Sankt-Petersburg", "Kazan", 135);

    @Test
    public void findByIdTest() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        TicketData actual = repo.findById(589);
        TicketData expected = ticket7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByIdWithNotExistingIdTest() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        TicketData actual = repo.findById(595);
        TicketData expected = null;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findAllTest() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        TicketData[] actual = repo.findAll();
        TicketData[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        manager.removeById(589);

        TicketData[] actual = manager.findAll();
        TicketData[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket8, ticket9};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByFromTest() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        TicketData[] actual = manager.findByFrom("Moscow");
        TicketData[] expected = {ticket3, ticket1, ticket4, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByInTest() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        TicketData[] actual = manager.findByIn("Kazan");
        TicketData[] expected = {ticket5, ticket3, ticket7, ticket1, ticket4, ticket9, ticket2, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByFromAndInTest() {
        Repository repo = new Repository();
        TicketManager manager = new TicketManager(repo);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        TicketData[] actual = manager.findByFromAndIn("Moscow", "Kazan");
        TicketData[] expected = {ticket3, ticket1, ticket4, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }
}

