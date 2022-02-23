package challenge.neginet;

public class App {

    public static void main(String[] args) {
        String fileName = args[0];
        Integer limit = Integer.valueOf(args[1]);

        Statistic statistic = new Statistic();
        statistic.printStatisticFromFile(fileName);
        NameModifier.printCreatedNames(fileName, limit);
    }

}
