package com.example.comptermsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ProgFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(  LayoutInflater inflater,   ViewGroup container,
                               Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_prog,container,false);

        Button quiz = (Button)view.findViewById(R.id.quiz1);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(),QuizProgActivity.class);
                startActivity(in);
            }
        });
        return view;
    }

}

