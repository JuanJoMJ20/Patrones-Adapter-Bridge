public class Mp3ToWavAdapter implements AudioTarget {
    private OldWavPlayer wavPlayer;

    public Mp3ToWavAdapter(OldWavPlayer wavPlayer) {
        this.wavPlayer = wavPlayer;
    }

    @Override
    public void playAudio(String format, String fileName) {
        if (format.equalsIgnoreCase("MP3")) {
            // Lógica de programación: Transformación de extensión para el motor viejo
            String convertedName = fileName.replace(".mp3", ".wav");
            System.out.println("ADAPTADOR: Convirtiendo flujo de datos MP3 a formato WAV...");
            wavPlayer.playWavFile(convertedName);
        } else {
            System.out.println("ERROR: El formato " + format + " no es compatible.");
        }
    }
}