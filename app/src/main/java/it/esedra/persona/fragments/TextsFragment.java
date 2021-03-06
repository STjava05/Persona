package it.esedra.persona.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;

import it.esedra.persona.MainActivity;
import it.esedra.persona.R;

public class TextsFragment extends Fragment {

        private Context context;

        private FileInputStream fis;
        private InputStreamReader isr;
        private StringBuilder builder;
        private String line;
        private ArrayDeque<String> lines = new ArrayDeque<>();

        public TextsFragment(Context context) {
            this.context = context;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.texts_fragment, container, false);
            TextView texts_view = view.findViewById(R.id.texts_view);
            Button change_button = view.findViewById(R.id.change_button);
            Button back_button = view.findViewById(R.id.back_button);

            try {
                fis = context.openFileInput("allTexts.txt");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            builder = new StringBuilder();

            try(BufferedReader reader = new BufferedReader(isr)) {
                while((line = reader.readLine()) != null) {
                    lines.addLast(line);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }

            change_button.setOnClickListener((v1) -> {
                String text = lines.poll();
                texts_view.setText(text);
                lines.addLast(text);
            });

            back_button.setOnClickListener((v2) -> {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.container_fragment, new MainMenuFragment(context)).commit();
            });

            return view;
        }
}
