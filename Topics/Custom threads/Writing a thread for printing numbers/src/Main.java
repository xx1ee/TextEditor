class NumbersThread extends Thread {

    public NumbersThread(int from, int to) {
        for (int i = from ; i < to + 1; i++) {
            System.out.println(i);
        }
    }


}