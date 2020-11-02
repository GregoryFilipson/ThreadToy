public class GameThread {
    public volatile boolean openBox = true;
    private final int TIME_BETWEEN_TOY_PLAY = 800;
    private final int LIMIT_TRYING = 5;
    private final int TIME_BETWEEN_MAN_PLAY = 2800;

    public void toyPlaying() {
        while (true) {
            while (!Thread.currentThread().isInterrupted()) {
                if (!openBox) {
                    System.out.println("Убери руки!...выключает переключатель обратно...");
                    openBox = true;
                } else {
                    try {
                        Thread.sleep(TIME_BETWEEN_TOY_PLAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void manPlaying() {
        for (int i = 0; i <= LIMIT_TRYING; i++) {
            try {
                Thread.sleep(TIME_BETWEEN_MAN_PLAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Включаю...");
            openBox = false;
        }
    }
}