package editor;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEditor extends JFrame {

    int width;
    int height;
    JTextField searchField;
    JButton saveButton;
    JButton loadButton;
    JButton searchButton;
    JButton previousMatch;
    JButton nextMatchButton;
    JTextArea textArea;
    JScrollPane scrollableTextArea;
    JMenuBar menuBar = new JMenuBar();


    public TextEditor() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setName("FileChooser");
        fileChooser.setVisible(false);

        this.width = 800;
        this.height = 320;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);


        //JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        fileMenu.setName("MenuFile");
        menuBar.add(fileMenu);
        JMenuItem MenuLoad = new JMenuItem("Open");
        MenuLoad.setName("MenuOpen");
        MenuLoad.addActionListener(e-> {
            fileChooser.setVisible(true);
            openFile(fileChooser, textArea);
        });

        JMenuItem MenuSave = new JMenuItem("Save");
        MenuSave.setName("MenuSave");
        MenuSave.setFocusable(false);
        MenuSave.addActionListener( e -> {
            fileChooser.setVisible(true);
            fileChooser.showSaveDialog(null);
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try (FileWriter writer = new FileWriter(file)) {
                textArea.write(writer);
            } catch (IOException io) {
                System.out.println("Write Error");
            }
        });

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setName("MenuExit");
        exitMenuItem.addActionListener(event -> System.exit(0));
        fileMenu.add(MenuLoad);
        fileMenu.add(MenuSave);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);


        LinkedList<String> foundText = new LinkedList<>();
        LinkedList<Integer> indexFound = new LinkedList<>();
        JMenu searchMenu = new JMenu("Search");
        searchMenu.setName("MenuSearch");
        menuBar.add(searchMenu);
        JMenuItem menuStartSearch = new JMenuItem("Start search");
        menuStartSearch.setName("MenuStartSearch");
        menuStartSearch.addActionListener(x -> {

            Thread thread = new Thread(() -> {

                try {

                    foundText.clear();
                    indexFound.clear();

                    if (!"".equals(searchField.getText())) {

                        foundText.clear();
                        indexFound.clear();
                        String goal = searchField.getText();
                        String areaText = textArea.getText();
                        Pattern searchPattern = Pattern.compile(goal, Pattern.CASE_INSENSITIVE);
                        Matcher matcher = searchPattern.matcher(areaText);
                        while (matcher.find()) {
                            foundText.add(matcher.group());
                            indexFound.add(matcher.start());
                        }
                        if (!indexFound.isEmpty()) {
                            textArea.setCaretPosition(indexFound.get(0) + foundText.get(0).length());
                            textArea.select(indexFound.get(0), indexFound.get(0) + foundText.get(0).length());
                            textArea.grabFocus();
                        }
                    }

                } catch (Exception ignored) {

                }

            });

            thread.start();

        });

        searchMenu.add(menuStartSearch);

        JMenuItem menuPreviousMatch = new JMenuItem("Previous search");
        menuPreviousMatch.setName("MenuPreviousMatch");
        menuPreviousMatch.addActionListener(x -> {
            try {
                if (!indexFound.isEmpty()) {
                    var a = indexFound.getLast();
                    indexFound.removeLast();
                    indexFound.addFirst(a);

                    var b = foundText.getLast();
                    foundText.removeLast();
                    foundText.addFirst(b);

                    textArea.setCaretPosition(indexFound.get(0) + foundText.get(0).length());
                    textArea.select(indexFound.get(0), indexFound.get(0) + foundText.get(0).length());
                    textArea.grabFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        searchMenu.add(menuPreviousMatch);

        JMenuItem menuNextMatch = new JMenuItem("Next Match");
        menuNextMatch.setName("MenuNextMatch");
        menuNextMatch.addActionListener(x -> {

            try {
                if (!indexFound.isEmpty()) {
                    var b = indexFound.getFirst();
                    indexFound.removeFirst();
                    indexFound.add(b);

                    var a = foundText.getFirst();
                    foundText.removeFirst();
                    foundText.add(a);
                    textArea.setCaretPosition(indexFound.get(0) + foundText.get(0).length());
                    textArea.select(indexFound.get(0), indexFound.get(0) + foundText.get(0).length());
                    textArea.grabFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        searchMenu.add(menuNextMatch);


        setLayout(new FlowLayout(FlowLayout.CENTER));

        searchField = new JTextField(20);
        searchField.setName("SearchField");
        String path0 = "C:\\Users\\Sveta\\Downloads\\folder_storage_document_files_ui_ux_archive_icon_224712 (1).png";
        ImageIcon save = new ImageIcon(path0);
        saveButton = new JButton(save);
        saveButton.setName("SaveButton");
        saveButton.setFocusable(false);
        saveButton.addActionListener(e -> {
            fileChooser.setVisible(true);
            fileChooser.showSaveDialog(null);
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try (FileWriter writer = new FileWriter(file)) {
                textArea.write(writer);
            } catch (IOException io) {
                System.out.println("Write Error");
            }
        });


        loadButton = new JButton("Open");
        String path1 = "C:\\Users\\Sveta\\Downloads\\paper_extension_ui_document_file_ux_icon_224725 (1).png";
        ImageIcon open = new ImageIcon(path1);
        loadButton = new JButton(open);
        loadButton.setName("OpenButton");
        //JFileChooser jfc1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        loadButton.addActionListener(e-> {
            fileChooser.setVisible(true);
            openFile(fileChooser, textArea);
        });

        searchButton = new JButton("SearchField");
        String path2 = "C:\\Users\\Sveta\\Downloads\\zoom_find_ux_search_ui_seo_icon_224737 (1).png";
        ImageIcon search = new ImageIcon(path2);
        searchButton = new JButton(search);
        searchButton.setName("StartSearchButton");
        searchButton.setFocusable(false);
        searchButton.addActionListener(e -> {
            try {
                foundText.clear();
                indexFound.clear();
                String goal = searchField.getText();
                String areaText = textArea.getText();
                Pattern searchPattern = Pattern.compile(goal, Pattern.CASE_INSENSITIVE);
                Matcher matcher = searchPattern.matcher(areaText);
                while (matcher.find()) {
                    foundText.add(matcher.group());
                    indexFound.add(matcher.start());
                }
                if (!indexFound.isEmpty()) {
                    textArea.setCaretPosition(indexFound.get(0) + foundText.get(0).length());
                    textArea.select(indexFound.get(0), indexFound.get(0) + foundText.get(0).length());
                    textArea.grabFocus();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        nextMatchButton = new JButton("NextMatchButton");
        String path4 = "C:\\Users\\Sveta\\Downloads\\free-icon-font-angle-right-3916907.png";
        ImageIcon next = new ImageIcon(path4);
        nextMatchButton = new JButton(next);
        nextMatchButton.setName("NextMatchButton");
        nextMatchButton.setFocusable(false);
        nextMatchButton.addActionListener(e -> {
            if (!indexFound.isEmpty()) {
                var b = indexFound.getFirst();
                indexFound.removeFirst();
                indexFound.add(b);

                var a = foundText.getFirst();
                foundText.removeFirst();
                foundText.add(a);
                textArea.setCaretPosition(indexFound.get(0) + foundText.get(0).length());
                textArea.select(indexFound.get(0), indexFound.get(0) + foundText.get(0).length());
                textArea.grabFocus();
            }
        });

        previousMatch = new JButton("PreviousMatchButton");
        String path3 = "C:\\Users\\Sveta\\Downloads\\free-icon-font-angle-left-3916912 (1).png";
        ImageIcon prev = new ImageIcon(path3);
        previousMatch = new JButton(prev);
        previousMatch.setName("PreviousMatchButton");
        previousMatch.setFocusable(false);
        previousMatch.addActionListener(e -> {
            try {
                var a = indexFound.getLast();
                indexFound.removeLast();
                indexFound.addFirst(a);

                var b = foundText.getLast();
                foundText.removeLast();
                foundText.addFirst(b);

                textArea.setCaretPosition(indexFound.get(0) + foundText.get(0).length());
                textArea.select(indexFound.get(0), indexFound.get(0) + foundText.get(0).length());
                textArea.grabFocus();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });


        JCheckBox checkBox = new JCheckBox();
        checkBox.setName("UseRegExCheckbox");


        JMenuItem label = new JMenuItem("Use regex");
        label.setName("MenuUseRegExp");
        label.addActionListener(x -> checkBox.setSelected(true));
        textArea = new JTextArea(12, 33);
        textArea.setName("TextArea");


        scrollableTextArea = new JScrollPane(textArea);
        scrollableTextArea.setName("ScrollPane");
        scrollableTextArea.setSize(width - 20, height - 20);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVisible(true);

        add(fileChooser);
        add(saveButton);
        add(loadButton);
        add(searchField);
        add(searchButton);
        add(previousMatch);
        add(nextMatchButton);
        add(checkBox);
        add(label);
        add(scrollableTextArea);
        add(fileChooser);
        setTitle("Text Editor");


        setVisible(true);

    }

    public static void openFile(JFileChooser fileChooser, JTextArea textArea) {
        try {
            String chek = "";
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                chek = fileChooser.getSelectedFile().getAbsolutePath();
            }

            FileReader reader = new FileReader(chek);
            BufferedReader br = new BufferedReader(reader);
            textArea.read(br, null);
            br.close();
            textArea.requestFocus();
        } catch (IOException e) {
            textArea.setText(null);
        }
    }

}
