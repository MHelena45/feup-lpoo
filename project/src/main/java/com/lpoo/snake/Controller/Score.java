package com.lpoo.snake.Controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Score {
    private String SbestScore, MbestScore;
    private static File file = new File("highscore.txt");

    public Score() {
        try {
            getScore();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSbestScore() {
        return SbestScore;
    }

    public String getMbestScore() {
        return MbestScore;
    }

    public void checkScore(int player, int score) throws IOException {
        getScore();
        if (player > 0) {
            int Mbest = Integer.parseInt(MbestScore);
            ;
            if (score > Mbest) {
                MbestScore = String.valueOf(score);
                putScore();
            }
        } else {
            int Sbest = Integer.parseInt(SbestScore);
            if (score > Sbest) {
                SbestScore = String.valueOf(score);
                putScore();
            }
        }

    }

    public void putScore() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("SinglePlayer");
        writer.newLine();
        writer.write(SbestScore);
        writer.newLine();
        writer.write("MultiPlayer");
        writer.newLine();
        writer.write(MbestScore);
        writer.newLine();
        writer.write("Last Score made in: " + new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        // Criando o conteúdo do arquivo
        writer.flush();
        // Fechando conexão e escrita do arquivo.
        writer.close();

    }

    public void getScore() throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String single = null;
        String multi = null;
        single = reader.readLine();
        if (single != null)
            SbestScore = reader.readLine();
        else {
            SbestScore = String.valueOf(0);
            MbestScore = String.valueOf(0);
            fileReader.close();
            reader.close();
            return;
        }
        multi = reader.readLine();
        if (multi != null)
            MbestScore = reader.readLine();
        else
            MbestScore = String.valueOf(0);
        fileReader.close();
        reader.close();
    }
}
