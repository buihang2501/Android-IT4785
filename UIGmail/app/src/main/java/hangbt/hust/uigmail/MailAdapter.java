package hangbt.hust.uigmail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.bloco.faker.Faker;
import io.bloco.faker.FakerData;
import io.bloco.faker.components.Date;
import io.bloco.faker.helpers.Period;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.MailViewHolder> {

    List<Faker> fakers = new ArrayList<>();

    private static final String TAG = "MailAdapter";

    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mail, parent, false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MailViewHolder holder, int position) {
        Faker faker = fakers.get(position);
        holder.bindData(faker);
    }

    @Override
    public int getItemCount() {
        return fakers.size();
    }

    public void updateData(List<Faker> fakerList) {
        fakers.clear();
        fakers.addAll(fakerList);
        notifyDataSetChanged();
    }

    static class MailViewHolder extends RecyclerView.ViewHolder {
        private TextView textView, textViewFrom, textViewTitle, textViewContent, textViewTime;
        int[] textViewColors = new int[]{R.drawable.shape1,
                R.drawable.shape2,
                R.drawable.shape3,
                R.drawable.shape4,
                R.drawable.shape5,
                R.drawable.shape6,
                R.drawable.shape7,
                R.drawable.shape8,
                R.drawable.shape9,
                R.drawable.shape10,};
        int random = new Random().nextInt(textViewColors.length);

        public MailViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textViewFrom = itemView.findViewById(R.id.textViewFrom);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewContent = itemView.findViewById(R.id.textViewContent);
        }

        public void bindData(Faker faker) {
            String from = faker.internet.userName();
            textViewFrom.setText(from.substring(0, 1).toUpperCase() + from.substring(1));
            textView.setText(from.substring(0, 1).toUpperCase());
            String time = faker.time.backward(5, Period.morning).toString();
            textViewTime.setText(time.substring(4, 10));
            textViewTitle.setText(faker.team.name());
            String content = faker.lorem.characters(30);
            textViewContent.setText(content.substring(0,1).toUpperCase()+content.substring(1));
            //color textView
            textView.setBackgroundResource(textViewColors[random]);
        }
    }
}
