package com.example.qrattendance.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qrattendance.R;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.VH> {
    private final List<String> rows;

    public AttendanceAdapter(List<String> rows) { this.rows = rows; }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvTs, tvId, tvName;
        VH(View v) {
            super(v);
            tvTs = v.findViewById(R.id.tvTs);
            tvId = v.findViewById(R.id.tvId);
            tvName = v.findViewById(R.id.tvName);
        }
    }

    @NonNull @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attendance, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH h, int pos) {
        String[] parts = rows.get(pos).split(" \u2022 ");
        if (parts.length >= 3) {
            h.tvTs.setText(parts[0]);
            h.tvId.setText(parts[1]);
            h.tvName.setText(parts[2]);
        } else {
            h.tvTs.setText(rows.get(pos));
            h.tvId.setText("");
            h.tvName.setText("");
        }
    }

    @Override
    public int getItemCount() { return rows.size(); }
}
