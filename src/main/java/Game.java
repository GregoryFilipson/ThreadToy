public class Game {
    public static void main(String[] args) {
        GameThread gameThread = new GameThread();
        Thread toy = new Thread(null, gameThread::toyPlaying, "Toy");
        Thread man = new Thread(null, gameThread::manPlaying, "Man");

        toy.setDaemon(true);

        toy.start();
        man.start();

        try {
            man.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}