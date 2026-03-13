//Menu interactivo terminal

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== REPRODUCTOR HI-FI v2.0 ==========");
        
        // 1. Lógica del Adapter
        System.out.print("Ingrese el nombre de la canción: ");
        String song = scanner.nextLine();
        System.out.print("Ingrese el formato (MP3 o WAV): ");
        String format = scanner.nextLine();

        OldWavPlayer legacyEngine = new OldWavPlayer();
        AudioTarget adapter = new Mp3ToWavAdapter(legacyEngine);
        adapter.playAudio(format, song + "." + format.toLowerCase());

        // 2. Lógica del Bridge
        System.out.println("\n¿Por dónde desea escuchar la música?");
        System.out.println("1. Parlantes");
        System.out.println("2. Audífonos");
        System.out.print("Seleccione una opción: ");
        int option = scanner.nextInt();

        OutputDevice selectedDevice;
        if (option == 1) {
            selectedDevice = new SpeakerDevice();
        } else {
            selectedDevice = new HeadphonesDevice();
        }

        MusicPlayer player = new AdvancedPlayer(selectedDevice);
        player.play(song);

        System.out.println("\n===========================================");
        System.out.println("Disfrute su música - Taller Finalizado");
        scanner.close();
    }
}