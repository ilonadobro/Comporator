import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1;
    Ticket ticket2;
    Ticket ticket3;
    Ticket ticket4;

    public AviaSoulsTest() {
        ticket1 = new Ticket(
                "Moscow",
                "Sochi",
                7800,
                19,
                22);

        ticket2 = new Ticket(
                "Belgrad",
                "Budva",
                4500,
                14,
                15);
        ticket3 = new Ticket(
                "Belgrad",
                "Budva",
                4888,
                13,
                23);
        ticket4 = new Ticket(
                "Belgrad",
                "Budva",
                5138,
                10,
                16);
    }

    @Test
    public void compareToTest() {
        Ticket[] actual = {ticket1, ticket2};
        Arrays.sort(actual);
        Ticket[] expected = {ticket2, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketTimeComparatorTest() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket1, ticket2};

        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket2, ticket1};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void searchAndSortByTest() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);

        Ticket[] tickets = aviaSouls.searchAndSortBy("Belgrad", "Budva", timeComparator);
        Ticket[] expected = {ticket2, ticket4, ticket3};
        Assertions.assertArrayEquals(expected, tickets);
    }
    @Test
    public void searchTest() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);

        Ticket[] tickets = aviaSouls.search("Belgrad", "Budva");
        Ticket[] expected = {ticket2, ticket3, ticket4};
        Assertions.assertArrayEquals(expected, tickets);

        Ticket[] tickets2 = aviaSouls.search("Moscow", "Sochi");
        Ticket[] expected2 = {ticket1};
        Assertions.assertArrayEquals(expected2, tickets2);

        Ticket[] tickets3 = aviaSouls.search("New York", "Texas");
        Ticket[] expected3 = {};
        Assertions.assertArrayEquals(expected3, tickets3);
    }


}

