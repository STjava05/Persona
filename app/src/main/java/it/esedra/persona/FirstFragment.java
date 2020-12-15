package it.esedra.persona;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        button = view.findViewById(R.id.load_fragment2);
        button.setOnClickListener((v) -> {
              /*  MainActivity.fragmentLoaded = new SecondFragment();
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, MainActivity.fragmentLoaded).commit();*/

        });

        return view;
    }

    public Button getButton(){
        return button;
    }
}
