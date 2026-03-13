public class SpeakerDevice implements OutputDevice {
    @Override
    public void outputSound(String audioData) {
        System.out.println("SALIDA POR PARLANTES >>> [Sonido Ambiente]: " + audioData);
    }
}