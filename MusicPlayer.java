public abstract class MusicPlayer {
    protected OutputDevice device;

    protected MusicPlayer(OutputDevice device) {
        this.device = device;
    }

    public abstract void play(String trackName);
}
