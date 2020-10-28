public class Main {
    public static void main(String[] args) {
        OptimizedLog log = new OptimizedLog();
        log.add("thing");
        log.add(5);
        log.add('c');
        log.add('c');
        log.add('c');
        log.add('c');

        System.out.println(log);
        System.out.println(log.toString());

        for(Object logged : log)
        {
            System.out.println(logged);
        }
    }
}
