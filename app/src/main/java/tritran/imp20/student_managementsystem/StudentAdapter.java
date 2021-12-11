package tritran.imp20.student_managementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    String stgStudentName[], stgStudentScore[];
    int stgStudentAvatar[];
    Context context;

    public StudentAdapter(Context ct, String names[], String scores[], int avatars[]) {
        context = ct;
        stgStudentName = names;
        stgStudentScore = scores;
        stgStudentAvatar = avatars;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.student_row, parent, false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        holder.stdName.setText(stgStudentName[position]);
        holder.stdScore.setText(stgStudentScore[position]);
        holder.stdAvatar.setImageResource(stgStudentAvatar[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, stgStudentName[position], duration).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return stgStudentName.length;
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        TextView stdName, stdScore;
        ImageView stdAvatar;
        ConstraintLayout mainLayout;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);

            stdName = itemView.findViewById(R.id.item_student_name);
            stdScore = itemView.findViewById(R.id.item_student_score);
            stdAvatar = itemView.findViewById(R.id.item_student_avatar);
            mainLayout = itemView.findViewById(R.id.student_row_layout);
        }
    }
}
