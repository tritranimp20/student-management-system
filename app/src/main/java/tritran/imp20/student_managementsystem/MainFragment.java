package tritran.imp20.student_managementsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainFragment extends Fragment {

    String stgStudentName[], stgStudentScore[];
    int stgStudentAvatar[];
    RecyclerView listStudent;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stgStudentName = getResources().getStringArray(R.array.storage_student_name);
        stgStudentScore = getResources().getStringArray(R.array.storage_student_score);
        stgStudentAvatar = new int[]{R.drawable.human, R.drawable.human, R.drawable.human, R.drawable.human, R.drawable.human, R.drawable.human, R.drawable.human};
        listStudent = view.findViewById(R.id.list_students);

        StudentAdapter adapter = new StudentAdapter(getContext(), stgStudentName, stgStudentScore, stgStudentAvatar);
        listStudent.setAdapter(adapter);
        listStudent.setLayoutManager(new LinearLayoutManager(getContext()));

        view.findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainFragment.this)
                        .navigate(R.id.action_MainFragment_to_AddStudentFragment);
            }
        });
    }
}