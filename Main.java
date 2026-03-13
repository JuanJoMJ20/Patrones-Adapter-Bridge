public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE AUDIO INICIADO =====");

        // --- DEMOSTRACIÓN ADAPTER ---
        System.out.println("\n[1] Probando Compatibilidad (Patrón Adapter):");
        OldWavPlayer legacyEngine = new OldWavPlayer();
        AudioTarget playerAdapter = new Mp3ToWavAdapter(legacyEngine);
        playerAdapter.playAudio("MP3", "rock_clásico.mp3");

        // --- DEMOSTRACIÓN BRIDGE ---
        System.out.println("\n[2] Probando Dispositivos de Salida (Patrón Bridge):");
        
        // Caso A: Usando Parlantes
        OutputDevice speakers = new SpeakerDevice();
        MusicPlayer system1 = new AdvancedPlayer(speakers);
        system1.play("Camcion No. 5");

        // Caso B: Cambiando a Audífonos
        OutputDevice headphones = new HeadphonesDevice();
        MusicPlayer system2 = new AdvancedPlayer(headphones);
        system2.play("Podcast de Tecnología");

        System.out.println("\n===== CIERRE DEL SISTEMA =====");
    }
}
