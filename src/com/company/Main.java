package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private JButton newBookButton;
    private JPanel panel1;
    private JButton updateProgressButton;
    private JButton checkButton;
    private JButton deleteBookButton;
    private JPanel MainMenu;
    private JPanel NewBook;
    private JPanel Update;
    private JPanel Check;
    private JPanel Delete;
    private JTextField textNBook;
    private JTextField textPage;
    private JTextField textDays;
    private JButton doneNBButton;
    private JPanel NBOutput;
    private JTextArea textOutput1;
    private JPanel UpOutput;
    private JComboBox comboBox1;
    private JTextField textPage2;
    private JButton updateButton;
    private JTextField textHari2;
    private JButton backNBButton;
    private JButton backNBOButton;
    private JButton backUpButton;
    private JPanel DOutput;
    private JComboBox comboBox2;
    private JButton deleteButton;
    private JButton backDelButton;
    private JPanel UpOutput2;
    private JTextArea OutputUP;
    private JButton backUp2Button;
    private JPanel UpOutput3;
    private JButton newBookButton1;
    private JButton backUp3Button;
    private JTextArea OutputUP1;
    private JComboBox comboBox3;
    private JTextArea textCheck1;
    private JButton checkButton1;
    private JButton button1;
    private JPanel panel2;
    private int baca;
    private ArrayList<buku> data = new ArrayList<>();

    public Main() {

        newBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    panel1.removeAll();
                    panel1.add(NewBook);
                    panel1.repaint();
                    panel1.revalidate();
            }
        });

        doneNBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String NBook = textNBook.getText();
                String halaman = textPage.getText();
                String time = textDays.getText();

                if (NBook.isEmpty() || halaman.isEmpty() || time.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Isi semua data!");
                    return;
                }

                for(buku cekjudul : Main.this.data) {
                    if (cekjudul.getNamaBuku().trim().equalsIgnoreCase(NBook.trim())) {
                        JOptionPane.showMessageDialog((Component)null, "Judul tersebut sudah ada.");
                        return;
                    }
                }


                buku BUKU = new buku(textNBook.getText(), Integer.parseInt(textPage.getText()), Integer.parseInt(textDays.getText()));

                baca = (int) Math.ceil((double)BUKU.getPages() / BUKU.getHari());

                textOutput1.setText("Buku " + BUKU.getNamaBuku() + " dengan jumlah halaman " + BUKU.getPages() + " halaman." + "\nMaka, kamu perlu membaca " + baca + " halaman/hari!");


                data.add(BUKU);
                comboBox1.addItem(BUKU);
                comboBox2.addItem(BUKU);
                comboBox3.addItem(BUKU);

                JOptionPane.showMessageDialog(null, "Buku " + NBook + " berhasil ditambahkan!");


                textNBook.setText("");
                textPage.setText("");
                textDays.setText("");

                panel1.removeAll();
                panel1.add(NBOutput);
                panel1.repaint();
                panel1.revalidate();
            }
        });

        backNBButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(MainMenu);
                panel1.repaint();
                panel1.revalidate();
            }
        });

        backNBOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(MainMenu);
                panel1.repaint();
                panel1.revalidate();
            }
        });


        updateProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(UpOutput);
                panel1.repaint();
                panel1.revalidate();
                }
            });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buku BUKU = (buku) comboBox1.getSelectedItem();

                String pagebaca = textPage2.getText();
                String sisahari = textHari2.getText();

                if (BUKU == null) {
                    JOptionPane.showMessageDialog(null, "Tidak ada buku untuk diupdate.");
                } else if (pagebaca.isEmpty() || sisahari.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Isi semua data!");
                    return;
                }

                int newpage1 = Integer.parseInt(textPage2.getText());
                int daysleft1 = Integer.parseInt(textHari2.getText());

                if (newpage1 > BUKU.getPages()) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan input.");
                    panel1.removeAll();
                    panel1.add(UpOutput);
                    panel1.repaint();
                    panel1.revalidate();
                    return;
                } else if (daysleft1 > BUKU.getHari()) {
                    JOptionPane.showMessageDialog(null, "Kamu sudah melewati tenggat peminjaman buku.");
                    panel1.removeAll();
                    panel1.add(UpOutput);
                    panel1.repaint();
                    panel1.revalidate();
                    return;
                }

                textHari2.setText("");
                textPage2.setText("");

                BUKU.update(newpage1, daysleft1);

                int newtarget = BUKU.newtarget();

                if (BUKU.getPages() == newpage1 && BUKU.getHari() == daysleft1) {
                    OutputUP1.setText("Kamu telah menyelesaikan buku " + BUKU.getNamaBuku() + " dengan tepat waktu!" + "\nSilahkan menambah buku baru untuk dibaca!");

                    data.remove(BUKU);
                    comboBox2.removeItem(BUKU);
                    comboBox1.removeItem(BUKU);
                    comboBox3.removeItem(BUKU);

                    panel1.removeAll();
                    panel1.add(UpOutput3);
                    panel1.repaint();
                    panel1.revalidate();
                } else if (BUKU.getPages() == newpage1 && BUKU.getHari() > daysleft1) {
                    OutputUP1.setText("Kamu telah menyelesaikan buku " + BUKU.getNamaBuku() + " lebih cepat dari jadwal asli!!! KEREN!!" + "\nSilahkan menambah buku baru untuk dibaca!");

                    data.remove(BUKU);
                    comboBox2.removeItem(BUKU);
                    comboBox1.removeItem(BUKU);
                    comboBox3.removeItem(BUKU);

                    panel1.removeAll();
                    panel1.add(UpOutput3);
                    panel1.repaint();
                    panel1.revalidate();
                } else if (newpage1 < baca*daysleft1) {
                    OutputUP.setText("Kamu sedikit terlambat dari jadwal asli" + "\nBerikut target baru kamu: " + newtarget + " halaman/hari.");
                    panel1.removeAll();
                    panel1.add(UpOutput2);
                    panel1.repaint();
                    panel1.revalidate();
                } else if (newpage1 > baca*daysleft1) {
                    OutputUP.setText("Kamu lebih cepat dari jadwal asli!" + "\nBerikut target baru kamu: " + newtarget + " halaman/hari.");
                    panel1.removeAll();
                    panel1.add(UpOutput2);
                    panel1.repaint();
                    panel1.revalidate();
                } else {
                    OutputUP.setText("Kamu on track!" + "\nBerikut sisa halaman yang akan dibaca: " + BUKU.newpage() + " halaman.");
                    panel1.removeAll();
                    panel1.add(UpOutput2);
                    panel1.repaint();
                    panel1.revalidate();
                }

                textHari2.setText("");
                textPage2.setText("");

            }
        });

        backUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(MainMenu);
                panel1.repaint();
                panel1.revalidate();
            }
        });

        backUp2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(MainMenu);
                panel1.repaint();
                panel1.revalidate();
            }
        });
        newBookButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(NewBook);
                panel1.repaint();
                panel1.revalidate();
            }
        });
        backUp3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(MainMenu);
                panel1.repaint();
                panel1.revalidate();
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(Check);
                panel1.repaint();
                panel1.revalidate();
            }
        });

        deleteBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(DOutput);
                panel1.repaint();
                panel1.revalidate();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buku BUKU = (buku) comboBox2.getSelectedItem();
                if (BUKU == null) {
                    JOptionPane.showMessageDialog(null, "Tidak ada buku untuk dihapus.");
                    return;
                }

                int choice = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus " + BUKU.getNamaBuku().toUpperCase() + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    data.remove(BUKU);
                    comboBox2.removeItem(BUKU);
                    comboBox1.removeItem(BUKU);
                    comboBox3.removeItem(BUKU);
                    JOptionPane.showMessageDialog(null, "Buku berhasil dihapus.");
                }

            }
        });

        backDelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(MainMenu);
                panel1.repaint();
                panel1.revalidate();
            }
        });

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(Check);
                panel1.repaint();
                panel1.revalidate();
            }
        });
        checkButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buku BUKU = (buku) comboBox3.getSelectedItem();
                textCheck1.setText("");
                if (BUKU == null) {
                    JOptionPane.showMessageDialog(null, "Tidak ada buku untuk diperiksa.");
                    return;
                }

                String check =
                                "Judul Buku: " + BUKU.getNamaBuku() +
                                "\nTotal halaman: " + BUKU.getPages() +
                                "\nSudah dibaca: " + BUKU.getPageRead() +
                                "\nSisa halaman: " + BUKU.newpage() +
                                "\n\nTenggat peminjaman: " + BUKU.getHari() + " hari" +
                                "\nUpdate terakhir: Hari ke-" + BUKU.getLastRead() +
                                "\nSisa hari: " + BUKU.daysleft() + " hari" +
                                "\n\nTarget Baru            : " + BUKU.newtarget() + " halaman/hari" +
                                "\nStatus                   : " + BUKU.getStatus();

                textCheck1.setText(check);

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.removeAll();
                panel1.add(MainMenu);
                panel1.repaint();
                panel1.revalidate();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("PagePlan");
        frame.setContentPane(new Main().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 450);
        frame.setVisible(true);
    }
}
