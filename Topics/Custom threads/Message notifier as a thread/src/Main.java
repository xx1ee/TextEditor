class MessageNotifier extends Thread {

    int k;
    String msgg;

    public MessageNotifier(String msg, int repeats) {
        msgg = msg;
        k = repeats;
    }

    @Override
    public void run() {
        for (int i = 0; i < k ; i++) {
            System.out.println(msgg);
        }
    }
}