import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFilechooser extends JFrame {

    PdfParser pdfParser = new PdfParser();

    public  JFilechooser() {
        super("Тестовое окно");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalGlue());

        final JLabel label = new JLabel("Выбранный файл");
        label.setAlignmentX(CENTER_ALIGNMENT);
        panel.add(label);

        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        JButton button = new JButton("Показать JFileChooser");
        button.setAlignmentX(CENTER_ALIGNMENT);



        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fileopen = new JFileChooser();


                //pdf-filter
                fileopen.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf", "pdf"));

                //FileChooserDialog
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();

                    label.setText(file.getName());

                    //Pdf_Parser_to_text
                    try {
                        pdfParser.ParsePdftoText(file.getPath());
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }

                }


            }
        });




        panel.add(button);
        panel.add(Box.createVerticalGlue());
        getContentPane().add(panel);

        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


    }



    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                new JFilechooser();

            }
        });
    }

}