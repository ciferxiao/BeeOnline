package com.bee.beeonline.main.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bee.beeonline.R;
import com.bee.beeonline.main.order.OrderActivity;
import com.beeonline.library.base.BaseFragment;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserFragment extends BaseFragment {

    @BindView(R.id.all_order)
    TextView all_order;
    @BindView(R.id.order_status1)
    TextView order_status1;
    @BindView(R.id.order_status2)
    TextView order_status2;
    @BindView(R.id.order_status3)
    TextView order_status3;
    @BindView(R.id.order_status4)
    TextView order_status4;
    @BindView(R.id.order_status5)
    TextView order_status5;

    public static UserFragment newInstance() {
        return new UserFragment();
    }


    @Override
    public void showError(String msg) {

    }

    @Override
    public void initData(Bundle bundle) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_user;
    }

    @Override
    public void initView(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);
        CommonTitleBar titleBar = view.findViewById(R.id.title_bar);
        titleBar.setListener(new CommonTitleBar.OnTitleBarListener() {
            @Override
            public void onClicked(View v, int action, String extra) {
                switch (action) {
                    case CommonTitleBar.ACTION_LEFT_TEXT:
                        break;
                    case CommonTitleBar.ACTION_RIGHT_BUTTON:
                        getActivity().startActivity(new Intent(getActivity(), MineActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void doBusiness() {
        all_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderActivity.startActivity(getActivity(), 1);
            }
        });
        order_status1.setOnClickListener(new OnclickListener(1));
        order_status2.setOnClickListener(new OnclickListener(2));
        order_status3.setOnClickListener(new OnclickListener(3));
        order_status4.setOnClickListener(new OnclickListener(4));
        order_status5.setOnClickListener(new OnclickListener(5));

    }


    private class OnclickListener implements View.OnClickListener {
        int status;

        public OnclickListener(int status) {
            this.status = status;
        }

        @Override
        public void onClick(View v) {
            OrderActivity.startActivity(getActivity(), status);
        }
    }
}
