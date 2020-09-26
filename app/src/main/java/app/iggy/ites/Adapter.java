package app.iggy.ites;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.List;

public class Adapter extends ArrayAdapter<Item> {

    private static final String TAG = "Adapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<Item> mItems;


    public Adapter(@NonNull Context context, int resource, List<Item> items) {
        super(context, resource);
        Log.d(TAG, "Adapter: starts");
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.mItems = items;
        Log.d(TAG, "Adapter: ends");
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            convertView = layoutInflater.inflate(layoutResource, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item currentApp = mItems.get(position);

        viewHolder.asunto.setText(currentApp.getAsunto());
        viewHolder.contenido.setText(currentApp.getContenido());
        String remitente = currentApp.getRemitente();
        char firstLetter = remitente.charAt(0);
        ColorGenerator generator = ColorGenerator.MATERIAL;

//        Drawable round = TextDrawable.builder().buildRound(String.valueOf(firstLetter), generator.getRandomColor());
        Drawable round = TextDrawable.builder().buildRound(String.valueOf(firstLetter), generator.getColor(currentApp.getColor()));
        viewHolder.mImageView.setImageDrawable(round);

        return convertView;
    }

    public Item getItem (int position){
        return ((mItems != null) && (mItems.size() != 0) ? mItems.get(position) : null);
    }

    public class ViewHolder{
        final TextView asunto;
        final TextView contenido;
        final ImageView mImageView;

        ViewHolder (View v){
            this.asunto = v.findViewById(R.id.asunto);
            this.contenido = v.findViewById(R.id.contenido);
            this.mImageView = v.findViewById(R.id.imageView);
        }
    }
}
