package com.hsf.JetpackTest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import androidx.navigation.NavController;
import androidx.navigation.NavDeepLinkBuilder;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsf.JetpackTest.databinding.FragmentABinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentA extends BaseFragment {

    FragmentABinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
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
//        Log.d("Daisy", "fragmentA回调onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
//        Log.d("Daisy", "fragmentA回调onCreateView");
        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Daisy", "点击了按钮");
                NavController navController = Navigation.findNavController(binding.tvA);

                Bundle bundle = new Bundle();
                bundle.putString("key", "test");
                navController.navigate(R.id.action_fragmentA_to_fragmentB, bundle);
            }
        });

        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String channelId = "normal_id";

                NotificationManagerCompat manager = NotificationManagerCompat.from(requireContext());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel =
                            new NotificationChannel(channelId, "normal", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("用于deeplink");
                    manager.createNotificationChannel(notificationChannel);
                }

                NavController navController = Navigation.findNavController(binding.getRoot());
                NavDeepLinkBuilder navDeepLinkBuilder = navController.createDeepLink();
                Bundle bundle = new Bundle();
                bundle.putString("key", "justToDeepLink");
                PendingIntent pendingIntent = navDeepLinkBuilder
                        .setGraph(R.navigation.nav_graph)
                        .setArguments(bundle)
                        .setDestination(R.id.deepLinkFragment)
                        .createPendingIntent();

                Notification notification = new NotificationCompat.Builder(requireContext(), channelId)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("测试deeplink")
                        .setContentText("哈哈哈")
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .build();

                manager.notify(1, notification);

            }
        });
    }
}