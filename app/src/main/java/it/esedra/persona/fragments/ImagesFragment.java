package it.esedra.persona.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import it.esedra.persona.MainActivity;
import it.esedra.persona.R;

public class ImagesFragment extends Fragment {

        private Context context;

        public ImagesFragment(Context context) {
            this.context = context;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.image_fragment, container, false);
            ImageView images_view = view.findViewById(R.id.images_view);
            Button back_button2 = view.findViewById(R.id.back_button2);

            images_view.setImageResource(R.drawable.ic_launcher_background);
            images_view.setOnClickListener((v1) -> {
                fade(images_view);
            });

            view.setOnClickListener((view1) -> {
                fade(images_view);
            });

            back_button2.setOnClickListener((v2) -> {
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, new MainMenuFragment(context)).commit();
            });

            return view;
        }

        private void fade(ImageView images_view) {
            if(images_view.getAlpha() == 0){
                images_view.animate().alpha(1).setDuration(200).start();
            } else {
                images_view.animate().alpha(0).setDuration(200).start();
            }
        }
}
