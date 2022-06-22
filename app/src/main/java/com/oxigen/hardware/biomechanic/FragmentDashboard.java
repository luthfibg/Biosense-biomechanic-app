package com.oxigen.hardware.biomechanic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDashboard#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDashboard extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<DataModel> dataHolder;
    private DataAdapter.RecyclerViewClickListener listener;

    public FragmentDashboard() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDashboard.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDashboard newInstance(String param1, String param2) {
        FragmentDashboard fragment = new FragmentDashboard();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        GraphView graph = view.findViewById(R.id.graphview);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat",
                "Sun" });
        staticLabelsFormatter.setVerticalLabels(new String[] {"100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200", "210", "220"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        //First two lines change the grid line color
        graph.getGridLabelRenderer().setGridColor(Color.WHITE);
        graph.getGridLabelRenderer().setHighlightZeroLines(false);

        //Below two lines change the label color
        graph.getGridLabelRenderer().setVerticalLabelsColor(Color.WHITE);
        graph.getGridLabelRenderer().setHorizontalLabelsColor(Color.WHITE);
        graph.getGridLabelRenderer().reloadStyles();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 5),
                new DataPoint(1, 6),
                new DataPoint(2, 8),
                new DataPoint(3, 6),
                new DataPoint(4, 8),
                new DataPoint(5, 9),
                new DataPoint(6, 7)
        });
        graph.addSeries(series);


        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dataHolder = new ArrayList<>();

        DataModel obj1 = new DataModel(R.drawable.ic_heart_broken_24, "Pulse", "Monday, 20/06/2022 17:04:13");
        dataHolder.add(obj1);

        DataModel obj2 = new DataModel(R.drawable.ic_directions_run_24, "Pedometer", "Sunday, 19/06/2022 16:49:53");
        dataHolder.add(obj2);

        DataModel obj3 = new DataModel(R.drawable.ic_directions_run_24, "Pedometer", "Sunday, 19/06/2022 08:33:40");
        dataHolder.add(obj3);

        DataModel obj4 = new DataModel(R.drawable.ic_directions_run_24, "Pedometer", "Saturday, 18/06/2022 07:17:41");
        dataHolder.add(obj4);

        DataModel obj5 = new DataModel(R.drawable.ic_heart_broken_24, "Pulse", "Friday, 17/06/2022 14:30:29");
        dataHolder.add(obj5);

        DataModel obj6 = new DataModel(R.drawable.ic_heart_broken_24, "Pulse", "Thursday, 16/06/2022 16:59:45");
        dataHolder.add(obj6);

        DataModel obj7 = new DataModel(R.drawable.ic_heart_broken_24, "Pulse", "Wednesday, 15/06/2022 17:15:54");
        dataHolder.add(obj7);

        DataModel obj8 = new DataModel(R.drawable.ic_heart_broken_24, "Pulse", "Tuesday, 14/06/2022 17:03:39");
        dataHolder.add(obj8);

        DataModel obj9 = new DataModel(R.drawable.ic_heart_broken_24, "Pulse", "Monday, 13/06/2022 17:00:42");
        dataHolder.add(obj9);

        DataModel obj10 = new DataModel(R.drawable.ic_directions_run_24, "Pedometer", "Sunday, 12/06/2022 08:34:55");
        dataHolder.add(obj10);

        setOnClickListener();
        recyclerView.setAdapter(new DataAdapter(dataHolder, listener));

        return view;
    }
    private void setOnClickListener(){
        listener = new DataAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getContext(), ActivityLog.class);
                intent.putExtra("activity[key]", dataHolder.get(position).getHeader());
                intent.putExtra("datetime[key]", dataHolder.get(position).getDesc());
                startActivity(intent);
            }
        };
    }
}