package ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.eventopia.R;

import java.util.List;

import model.Event;

public class EventListAdapter extends ArrayAdapter<Event> {

    public EventListAdapter(@NonNull Context context, @NonNull List<Event> events) {
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_event, parent, false);
        }

        Event event = getItem(position);

        TextView title = convertView.findViewById(R.id.textTitle);
        TextView description = convertView.findViewById(R.id.textDescription);
        TextView date = convertView.findViewById(R.id.textDate);
        TextView location = convertView.findViewById(R.id.textLocation);

        if (event != null) {
            title.setText(event.getTitle());
            description.setText(event.getDescription());
            date.setText(event.getDate());
            location.setText(event.getLocation());
        }

        return convertView;
    }
}

