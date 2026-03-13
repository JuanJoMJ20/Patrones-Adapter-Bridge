public class AdvancedPlayer extends MusicPlayer {
    public AdvancedPlayer(OutputDevice device) {
        super(device);
    }

    @Override
    public void play(String trackName) {
        // Lógica de programación: Aplicar ecualización antes de enviar al dispositivo
        String processedAudio = trackName + " (Ecualización: Bass Boost)";
        device.outputSound(processedAudio);
    }
}