//Interfaz Gráfica

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField songField;
    private JComboBox<String> formatBox;
    private JComboBox<String> deviceBox;
    private JTextArea logArea;

    public Main() {
        setTitle("Reproductor Hi-Fi v3.0");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Nombre de la canción:"));
        songField = new JTextField(20);
        add(songField);

        add(new JLabel("Formato de audio:"));
        formatBox = new JComboBox<>(new String[]{"MP3", "WAV"});
        add(formatBox);

        add(new JLabel("Dispositivo de salida:"));
        deviceBox = new JComboBox<>(new String[]{"Parlantes", "Audífonos"});
        add(deviceBox);

        JButton playButton = new JButton("Reproducir Ahora");
        add(playButton);

        logArea = new JTextArea(10, 30);
        logArea.setEditable(false);
        add(new JScrollPane(logArea));

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeLogic();
            }
        });
    }

    private void executeLogic() {
        String song = songField.getText();
        String format = (String) formatBox.getSelectedItem();
        String deviceType = (String) deviceBox.getSelectedItem();

        if (song.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una canción");
            return;
        }

        // ADAPTER
        OldWavPlayer legacyEngine = new OldWavPlayer();
        AudioTarget adapter = new Mp3ToWavAdapter(legacyEngine);
        
        logArea.append("\n--- Procesando Audio ---");
        adapter.playAudio(format, song + "." + format.toLowerCase());
        logArea.append("\nAdaptador: Formato " + format + " procesado.");

        //BRIDG
        OutputDevice selectedDevice;
        if (deviceType.equals("Parlantes")) {
            selectedDevice = new SpeakerDevice();
        } else {
            selectedDevice = new HeadphonesDevice();
        }

        MusicPlayer player = new AdvancedPlayer(selectedDevice);
        player.play(song);
        logArea.append("\nBridge: Sonando en " + deviceType);
        logArea.append("\n-----------------------");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}
