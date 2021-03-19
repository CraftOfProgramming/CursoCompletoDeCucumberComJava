package com.craftofprogramming.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final int INVALID_CSV_FILE_TOKEN_ERROR_CODE = 1;
    public static final int MISSING_CSV_FILE = 2;

    public static List<Livro> carregaBiblioteca(Path path) {
        List<Livro> library = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                library.add(obtemLivro(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return library;
    }

    static Livro obtemLivro(String line) {
        final String[] tokens = line.split(",");
        return new Livro(obtemToken(tokens, 0), Integer.parseInt(obtemToken(tokens, 1)), Topico.valueOf(obtemToken(tokens, 2)),
                Year.parse(obtemToken(tokens, 3)), obtemToken(tokens, 4));
    }

    static String obtemToken(String[] tokens, int idx) {
        final String token = tokens[idx];
        if (token == null) {
            throw new IllegalArgumentException(String.format("%d | Found invalid token at index i:%d", INVALID_CSV_FILE_TOKEN_ERROR_CODE, idx));
        }
        return token.trim();
    }
}