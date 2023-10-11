package models;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    HashMap<Client, Account> map = new HashMap<>();
    void createClient(Client client, Account account) {
        map.put(client, account);
    }
    void deleteClient(Client client) {
        map.remove(client);
    }
    void informationClient(Client client) {
        System.out.println("Количество рублей у клиента: " + map.get(client).countRUB);
        System.out.println("Количество долларов у клиента: " + map.get(client).countUSD);
        System.out.println("Количество евро у клиента: " + map.get(client).countEUR);
    }
    void countClients() {
        double countRUB = 0, countUSD = 0, countEUR = 0;
        for (Map.Entry<Client, Account> item: map.entrySet()) {
            countRUB += item.getValue().countRUB;
            countUSD += item.getValue().countUSD;
            countEUR += item.getValue().countEUR;
        }
        System.out.println("Общее количество рублей у всех клиентов: " + countRUB);
        System.out.println("Общее количество долларов у всех клиентов: " + countUSD);
        System.out.println("Общее количество евро у всех клиентов: " + countEUR);
    }


}
