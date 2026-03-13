public class HeadphonesDevice implements OutputDevice {
    @Override
    public void outputSound(String audioData) {
        System.out.println("SALIDA POR AUDÍFONOS >>> [Sonido Privado]: " + audioData);
    }
}